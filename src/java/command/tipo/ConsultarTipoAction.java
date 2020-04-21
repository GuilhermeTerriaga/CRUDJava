/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.tipo;

import command.ICommand;
import dao.tipo.TipoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Tipo;

/**
 *
 * @author guilherme
 */
public class ConsultarTipoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Tipo tipo;
        tipo = new Tipo();

        TipoDao tipodao;
        tipodao = new TipoDao();

        tipo.setId(Integer.parseInt(request.getParameter("id")));
        tipodao.buscar(tipo);

        HttpSession session = request.getSession();

        session.setAttribute("tipo", tipo);
        return "/cadastros/tipo/consultar_tipo.jsp";
    }

}
