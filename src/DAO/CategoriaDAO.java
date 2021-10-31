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
import model.Categoria;

/**
 *
 * @author Klayton Massango
 */
public class CategoriaDAO {
    
     private Connection conexao;

    public CategoriaDAO() {
        this.conexao = new ConexaoBanco().conectar();
    }
    public void cadastrarCategoria(Categoria obj) {
        try {
            String sql = "select * from categorias where cat_nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                if (obj.getNome().equals(rs.getString("cat_nome"))) {
                    JOptionPane.showMessageDialog(null, "O Produto já " + obj.getNome() + " Existe.");

                }
            } else {
            String sqli = "insert into categorias (cat_nome) values(?)";
            PreparedStatement stmtt = conexao.prepareStatement(sqli);
            stmtt.setString(1, obj.getNome());
            stmtt.execute();
            stmtt.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public List<Categoria> listarCategorias() {
        try {
            List<Categoria> lista = new ArrayList();

            String sql = "select * from categorias";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria obj = new Categoria();
                obj.setNome(rs.getString("cat_nome"));
                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }
}
