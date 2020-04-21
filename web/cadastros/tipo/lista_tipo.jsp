<%-- 
    Document   : lista_tipo
    Created on : 06/04/2020, 21:05:23
    Author     : guilherme
--%>
<
<%@page import="model.Tipo" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Tipo</title>
    </head>
    <body>
        <h1>Lista de Tipos</h1>
        <a href="ControleTipo?acao=Cadastrar">Novo</a>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Descrição</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Tipo> arrtipo;
                    arrtipo = new ArrayList<Tipo>();
                    arrtipo = (ArrayList<Tipo>) request.getSession().getAttribute("arrtipo");
                    for (Tipo obj : arrtipo) {
                %>
                <tr>
                    <td><%=obj.getId()%></td>
                    <td><%=obj.getDescricao()%></td>
                    <td>
                        <a href="ControllerTipo?acao=Buscar&id=<%= obj.getId()%>">Alterar</a>
                        <a href="ControllerTipo?acao=Consultar&id=<%= obj.getId()%>">Consultar</a>
                        <a href="ControllerTipo?acao=Excluir&id=<%= obj.getId()%>">Excluir</a>
                   </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
