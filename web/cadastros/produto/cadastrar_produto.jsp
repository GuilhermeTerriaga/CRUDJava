<%-- 
    Document   : cadastrar_produto
    Created on : 25/03/2020, 16:33:59
    Author     : guilherme
--%>
<%@page import="model.Situacao" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Produto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
    </head>
    <body>
        <form action="/ExercicioCRUD/ControlProduto" method="POST">
            <input type="hidden" name="acao" id="acao" value="Cadastrar"/>
            
            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value=""/>
            </div>]
             <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value=""/>
            </div>
            <div>
                <label>Situacao</label>
                <select name="cmbsituacao">
                    <%
                    ArrayList<Situacao> arrSituacao;
                    arrSituacao = new ArrayList<Situacao>();
                    arrSituacao = (ArrayList<Situacao>)request.getSession().getAttribute("arrSituacao");
                    for(Situacao obj : arrSituacao){
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                    }
                    %>
                </select>
            </div>
                <div>
                    <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>
                </div>
        </form>
    </body>
</html>
s