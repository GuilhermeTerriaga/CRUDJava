<%-- 
    Document   : excluir_produto
    Created on : 25/03/2020, 16:34:34
    Author     : guilherme
--%>
<%@page import="model.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Produtos</title>
    </head>
    <body>
        <%
            Produto objProduto;
            objProduto = new Produto();
            objProduto = (Produto) request.getSession().getAttribute("produto");
        %>
        <form action="/ExercicioCRUD/ControllerProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objProduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Exlcuir"/>
            <input type="hidden" name="confirmaexclusao" id="cofirmaexclusao" value="2"/>
            <h1> Confirma a exclusao definitiva do registro abaixo?</h1>
            <div>
                <label>Descição</label>
                <label><strong><%= objProduto.getDescricao()%></strong></label>
            </div>
            <div>
                <label>Quantidade</label>
                <label><strong><%= objProduto.getQuantidade()%></strong></label>
            </div>
            <div>
                <input type="submit" name="btnconfirma" id="btnconfirma" value="Confirma"/>
            </div>
        </form>
    </body>
</html>
