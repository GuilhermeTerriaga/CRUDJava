/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.tipo;

import java.util.ArrayList;
import model.Tipo;

/**
 *
 * @author guilherme
 */
interface ITipoDao {
    
    public ArrayList<Tipo> listar(Tipo tipo);

    public void buscar(Tipo tipo);

    public boolean alterar(Tipo tipo);

    public boolean excluir(Tipo tipo);

    public boolean cadastrar(Tipo tipo);
}
