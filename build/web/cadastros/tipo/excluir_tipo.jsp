<%-- 
    Document   : excluir_tipo
    Created on : 06/04/2020, 20:56:52
    Author     : guilherme
--%>
<%@page import="model.Tipo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir tipo</title>
    </head>
    <body>
       <%
       Tipo objtipo;
       objtipo = new Tipo();
       objtipo= (Tipo) request.getSession().getAttribute("tipo");
       %>
       <form action="/ExercicioCRUD/ControllerTipo" method="POST">
           <input type="hidden" name="id" id="id" value="<%= objtipo.getId()%>"/>
           <input type="hidden" name="acao" id="acao" value="Excluir"/>
           <input type="hidden" name="confirmaexclusao" id="confirmaexclusao" value="2"/>
           <h1>Confirma a exclusao definitica do registro abaixo?</h1> 
           <div>
               <label>Descrição</label>
               <label><strong><%=objtipo.getDescricao()%></strong></label>
           </div>
           <div>
               <input type="submit" name="btnconfirma" id="btnconfirma" value="Confirma"/>
           </div>
       </form>
    </body>
</html>
