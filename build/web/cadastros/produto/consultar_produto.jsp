<%-- 
    Document   : consultar_produto
    Created on : 25/03/2020, 16:34:18
    Author     : guilherme
--%>
<%@page import="model.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <%
        Produto objProduto;
        objProduto = new Produto();
        objProduto = (Produto) request.getSession().getAttribute("produto");
        %>
        <form>
            <div>
                <label>Descrição</label>
                <label><strong><%= objProduto.getDescricao() %></strong></label>
            </div>
            <div>
                <label>Quantidade</label>
                <label><strong><%= objProduto.getQuantidade() %></strong></label>
            </div>
             <div>
                <label>Situação</label>
                <label><strong><%= objProduto.getSituacao().getDescricao() %></strong></label>
            </div>
        </form>
    </body>
</html>
