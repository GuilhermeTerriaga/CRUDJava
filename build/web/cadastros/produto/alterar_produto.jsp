<%-- 
    Document   : alterar_produto
    Created on : 25/03/2020, 16:33:44
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
        <title>Alterar Produto</title>
    </head>
    <body>
        <%
            Produto objProduto;
            objProduto = new Produto();
            objProduto = (Produto) request.getSession().getAttribute("produto");
        %>
        <form action="/ExercicioCRUD/ControllerProduto" method="POST">
            <input type ="hidden" name="id" id="id" value="<%= objProduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Alterar"/>
            <div>
                <label> Descrição </label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="<%=objProduto.getDescricao()%>"/>
            </div>
            <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="<%= objProduto.getQuantidade()%>" />
            </div>
            <div>
                <label>Situação</label>
                <select name="cmbsituacao">
                    <% String selecionado = "";
                        ArrayList<Situacao> arrSituacao;
                        arrSituacao = new ArrayList<Situacao>();
                        arrSituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");
                        for (Situacao obj : arrSituacao) {
                            if (obj.getId() == objProduto.getSituacao().getId()) {
                                selecionado = "selected=selected";
                            } else {
                                selecionado = "";
                            }

                    %>
                    <option <%= selecionado%> value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
            </div>
            <div>
                <label> Situacao </label>
                <label><strong><%= objProduto.getSituacao().getDescricao()%></strong></label>
            </div>
            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>

            </div>

        </form>
    </body>
</html>
