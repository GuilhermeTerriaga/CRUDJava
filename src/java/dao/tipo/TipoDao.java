/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.tipo;

import model.Tipo;
import util.Conecta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme
 */
public class TipoDao implements ITipoDao {

    private static final String SELECT_ALL = "SELECT * FROM tipo WHERE descricao ILIKE ?;";
    private static final String INSERT = "INSERT INTO tipo(descricao) VALUES(?);";
    private static final String DELETE = "DELETE FROM tipo WHERE id=?;";
    private static final String UPDATE = "UPDATE tipo SET descricao=? WHERE id=?;";
    private static final String BUSCAR = "SELECT * FROM tipo WHERE id=?;";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Tipo> listar(Tipo tipo) {
        ArrayList<Tipo> listaTipo;
        listaTipo = new ArrayList<Tipo>();
        try {
            conexao = Conecta.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            pstmt.setString(1, "%" + tipo.getDescricao() + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Tipo novoTipo;
                novoTipo = new Tipo();
                novoTipo.setId(rs.getInt("id'"));
                novoTipo.setDescricao(rs.getString("descricao"));

                listaTipo.add(novoTipo);

            }
            return listaTipo;

        } catch (Exception ex) {
            return listaTipo;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void buscar(Tipo tipo) {
        try {
            conexao = Conecta.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, tipo.getId());

            ResultSet rs = pstmt.executeQuery();

            rs.next();

            tipo.setDescricao(rs.getString("decricao"));

        } catch (Exception ex) {

        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean alterar(Tipo tipo) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, tipo.getDescricao());
            pstmt.setInt(2, tipo.getId());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluir(Tipo tipo) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, tipo.getId());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean cadastrar(Tipo tipo) {
        try {
            conexao = Conecta.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, tipo.getDescricao());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
