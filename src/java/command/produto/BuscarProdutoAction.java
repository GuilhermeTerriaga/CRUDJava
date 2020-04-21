/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.produto.ProdutoDao;
import dao.situacao.SituacaoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Produto;
import model.Situacao;

/**
 *
 * @author guilherme
 */
public class BuscarProdutoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        Situacao situacao;
        situacao = new Situacao();
        SituacaoDao situacaodao;
        situacaodao = new SituacaoDao();
        ArrayList<Situacao> arrsituacao;
        arrsituacao = new ArrayList<Situacao>();
        situacao.setDescricao("");
        arrsituacao = situacaodao.listar(situacao);
        HttpSession session = request.getSession();
        session.setAttribute("arrstituacao", arrsituacao);
        } catch(Exception ex){
        
        }
        Produto produto;
        produto = new Produto();
        ProdutoDao produtodao;
        produtodao = new ProdutoDao();
        produto.setId(Integer.parseInt(request.getParameter("id")));
        produtodao.buscar(produto);
        HttpSession session = request.getSession();
        session.setAttribute("produto", produto);
        return "/cadastros/produtos/alterar_produto.jsp";
    }
    
}
