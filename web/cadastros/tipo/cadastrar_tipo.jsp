<%-- 
    Document   : cadastrar_tipo
    Created on : 06/04/2020, 20:44:37
    Author     : guilherme
--%>
<%@page import="model.Tipo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Tipo</title>
    </head>
    <body>
        <form action="ExercicioCRUD/ControllerTipo" method="POST">
            ><input type="hidden" name="acao"  id="acao" value="Cadastrar"/>
            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value=""/>
            </div>
            <div>
                <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>
            </div>
        </form>
    </body>
</html>
