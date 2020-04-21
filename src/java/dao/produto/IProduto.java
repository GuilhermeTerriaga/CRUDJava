/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.produto;

import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author guilherme
 */
public interface IProduto {

    public ArrayList<Produto> listar(Produto produto);

    public void buscar(Produto produto);

    public boolean alterar(Produto produto);

    public boolean excluir(Produto produto);

    public boolean cadastrar(Produto produto);

}
