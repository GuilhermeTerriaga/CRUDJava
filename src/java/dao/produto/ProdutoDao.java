/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.produto;

import util.Conecta;
import dao.situacao.SituacaoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
import model.Situacao;

/**
 *
 * @author guilherme
 */
public class ProdutoDao implements IProduto {

    private static final String SELECT_ALL = "SELECT * FROM produto where descricao ilike ?;";
    private static final String INSERT = "INSERT INTO produto(descricao,quantidade,situacao) values(?,?,?);";
    private static final String DELETE = "DELETE FROM produto where id=?";
    private static final String BUSCAR = "SELECT * FROM produto WHERE id=?;";
    private static final String UPDATE = "UPDATE produto set descricao=?,quantidade=?,situacao=? WHERE id=?";
    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Produto> listar(Produto produto) {

        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        try {

            //Conexao
            conexao = Conecta.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            pstmt.setString(1, "%" + produto.getDescricao() + "%");

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Produto novoProduto = new Produto();
                novoProduto.setId(rs.getInt("id"));
                novoProduto.setDescricao(rs.getString("descricao"));
                novoProduto.setQuantidade(rs.getInt("quantidade"));
                Situacao situacao = new Situacao();
                situacao.setId(rs.getInt("situacao"));
                SituacaoDao situacaodao = new SituacaoDao();
                situacaodao.buscar(situacao);
                novoProduto.setSituacao(situacao);
                listaProduto.add(novoProduto);
            }
            return listaProduto;

        } catch (Exception ex) {

            return listaProduto;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void buscar(Produto produto) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);
            pstmt.setInt(1, produto.getId());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            produto.setDescricao(rs.getString("descricao"));
            produto.setQuantidade(rs.getInt("quantidade"));
            Situacao situacao = new Situacao();
            situacao.setId(rs.getInt("situacao"));
            SituacaoDao situacaoDao = new SituacaoDao();
            situacaoDao.buscar(situacao);
            produto.setSituacao(situacao);
        } catch (SQLException ex) {

        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean alterar(Produto produto) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getId());
            pstmt.setInt(3, produto.getSituacao().getId());
            pstmt.setInt(4, produto.getId());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean excluir(Produto produto) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, produto.getId());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean cadastrar(Produto produto) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setInt(3, produto.getSituacao().getId());
            pstmt.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
