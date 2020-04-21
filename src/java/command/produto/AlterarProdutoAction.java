/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;


import command.ICommand;
import dao.produto.ProdutoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.Situacao;
/**
 *
 * @author guilherme
 */
public class AlterarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       Produto produto;
       produto = new Produto();
       
       produto.setDescricao(request.getParameter("txtdescricao"));
       produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
       produto.setId(Integer.parseInt(request.getParameter("id")));
       
       Situacao situacao;
       situacao = new Situacao();
       situacao.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
       produto.setSituacao(situacao);
       
       ProdutoDao produtodao;
       produtodao = new ProdutoDao();
       
       produtodao.alterar(produto);
       
       return("/controllerProduto?acao=Listar");
    }
    
}
