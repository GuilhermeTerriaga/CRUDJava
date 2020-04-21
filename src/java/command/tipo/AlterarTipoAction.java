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
public class AlterarTipoAction implements ICommand  {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       Tipo tipo;
       tipo = new Tipo();
       
       tipo.setDescricao(request.getParameter("descricao"));
       tipo.setId(Integer.parseInt(request.getParameter("id")));
       
       TipoDao tipodao;
       tipodao = new TipoDao();
       
       tipodao.alterar(tipo);
       
       return"/ControllerTipo?acao=Listar";
    }
    
}
