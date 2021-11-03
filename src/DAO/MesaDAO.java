/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Mesa;

/**
 *
 * @author Klayton Massango
 */
public class MesaDAO {

    private Connection conexao;

    public MesaDAO() {
        this.conexao = new ConexaoBanco().conectar();
    }
    public List<Mesa> listarMesasComId() {
        try {
            List<Mesa> lista = new ArrayList();

            String sql = "select * from mesas";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mesa obj = new Mesa();
                obj.setMsa_id(rs.getInt("id_mesa"));
                obj.setMsa_nome(rs.getString("ms_nome"));
                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }
    public List<Mesa> listarMesas() {
        try {
            List<Mesa> lista = new ArrayList();

            String sql = "select * from mesas";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Mesa obj = new Mesa();
                obj.setMsa_nome(rs.getString("ms_nome"));
                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public List<Mesa> pegarIdMesa(Mesa obj) {
        try {
            List<Mesa> lista = new ArrayList();

            String sql = "select id_mesa from mesas where ms_nome = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getMsa_nome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                obj.setMsa_id(rs.getInt("id_mesa"));
                lista.add(obj);
            }

            stmt.execute();
            stmt.close();
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public void adicionarMesa(Mesa obj) {
        try {
            String sql = "insert into mesas (ms_nome) values(?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getMsa_nome());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public void excluirMesa(Mesa obj) {
        try {
            String sql = "delete from mesas where id_mesa = ? and hide=0";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getMsa_id());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel remover esta mesa! ");
        }
    }
}
