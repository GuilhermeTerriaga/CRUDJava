<%-- 
    Document   : lista_produto
    Created on : 25/03/2020, 16:34:44
    Author     : guilherme
--%>
<%@page  import="java.util.ArrayList"%>
<%@page import="model.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        <a href="ControllerProduto?acao=Cadastrar">Novo</a>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Produto> arrproduto;
                    arrproduto = new ArrayList<Produto>();
                    arrproduto = (ArrayList<Produto>) request.getSession().getAttribute("arrproduto");
                    for (Produto obj : arrproduto) {
                %>
                <tr>
                    <td><%= obj.getId()%></td>
                    <td><%= obj.getDescricao()%></td>
                    <td><%= obj.getQuantidade()%></td>
                    <td>
                        <a href="ControllerProduto?acao=Buscar&id=<%= obj.getId()%>">Alterar</a>
                        <a href="ControllerProduto?acao=Consultar&id=<%= obj.getId()%>">Consultar</a>
                        <a href="ControllerProduto?acao=Excluir&id=<%= obj.getId()%>">Excluir</a>
                    </td>
                </tr>
                <%
                    }
                    %>
            </tbody>
        </table>
    </body>
</html>
