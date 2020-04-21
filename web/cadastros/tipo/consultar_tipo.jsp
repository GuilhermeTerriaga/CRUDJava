<%-- 
    Document   : consultar_tipo
    Created on : 06/04/2020, 20:52:20
    Author     : guilherme
--%>
<%@page import="model.Tipo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Tipo</title>
    </head>
    <body>
        <%
            Tipo objtipo;
            objtipo = new Tipo();

            objtipo = (Tipo) request.getSession().getAttribute("tipo");
        %>
        <form>
            <div>
                <label>Descrição</label>
                <label><strong><%= objtipo.getDescricao()%></strong></label>
            </div>
        </form>
    </body>
</html>
