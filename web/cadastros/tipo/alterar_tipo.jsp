<%-- 
    Document   : alterar_tipo
    Created on : 06/04/2020, 19:54:12
    Author     : guilherme
--%>
<%@page import="model.Tipo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Tipo</title>
    </head>
    <body>
        <% 
        Tipo objtipo;
        objtipo = new Tipo();
        objtipo = (Tipo) request.getSession().getAttribute("tipo");
        %>
        <form action="/ExercicioCRUD/ControllerTipo" method="POST">
            <div>
                <input type="hidden" name="id" id="id" value"<%= objtipo.getId()%>"/>
                <input type="hidden" name="acao" id="acao" value="Alterar"/>
                
            </div>
                <div>
                    <label>Descrição</label>
                <input type="text" name="descricao" id="descricao" value="<%= objtipo.getDescricao()%>"/>
                </div>
                <div>
                    <input type="submit" name="btnalterar" id="btnalterar" value="Aletera"/>
                </div>
        </form>
    </body>
</html>
