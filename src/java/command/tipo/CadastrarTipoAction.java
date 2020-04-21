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
import model.Tipo;

/**
 *
 * @author guilherme
 */
public class CadastrarTipoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Tipo tipo;
            tipo = new Tipo();

            tipo.setDescricao(request.getParameter("txtdescricao"));

            if (tipo.getDescricao().length() == 0) {
                return "/cadastros/tipo/cadastrar_tipo.jsp";
            } else {
                TipoDao tipodao = new TipoDao();
                tipodao.cadastrar(tipo);

                return "/cadastros/tipo/sucesso.jsp";
            }
        } catch(Exception ex){
        return "/cadastros/tipo/cadastrar_tipo.jsp";
        }

    }

}
