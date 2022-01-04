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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Klayton Massango
 */
public class ProdutoDAO {

    private Connection conexao;

    // Metodo conectos
    public ProdutoDAO() {
        this.conexao = new ConexaoBanco().conectar();
    }

    // Metodo de Incersao dos Produtos no Banco de Dados
    public void cadastrarProdutos(Produto obj) {
        try {
            String sql = "select * from produtos where pro_nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getPro_nome());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                if (obj.getPro_nome().equals(rs.getString("pro_nome"))) {
                    JOptionPane.showMessageDialog(null, "O Produto já " + obj.getPro_nome() + " Existe.");

                }
            } else {

                // String da query
                String sqlin = "insert into produtos (pro_nome, pro_categoria, pro_quantidade, pro_preco)"
                        + "values(?,?,?,?)";
                // Preparar a string
                PreparedStatement stmtt = conexao.prepareStatement(sqlin);

                // Passar Atributos
                stmtt.setString(1, obj.getPro_nome());
                stmtt.setString(2, obj.getPro_categoria());
                stmtt.setInt(3, obj.getPro_quantidade());
                stmtt.setDouble(4, obj.getPro_preco());

                //executar e feichar
                stmtt.execute();
                stmtt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
    }

    public List<Produto> listarProdutos() {
        try {
            List<Produto> lista = new ArrayList();

            String sql = "select * from produtos order by id_produto desc";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                obj.setId_produto(rs.getInt("id_produto"));
                obj.setPro_nome(rs.getString("pro_nome"));
                obj.setPro_categoria(rs.getString("pro_categoria"));
                obj.setPro_quantidade(rs.getInt("pro_quantidade"));
                obj.setPro_preco(rs.getDouble("pro_preco"));

                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
        return null;
    }

    public void alterarProduto(Produto obj, int codigo) {
        try {
            String sql = "update produtos set pro_nome = ?, pro_categoria = ?, pro_quantidade = ?, pro_preco = ? where id_produto = " + codigo;

            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Passar Atributos
            stmt.setString(1, obj.getPro_nome());
            stmt.setString(2, obj.getPro_categoria());
            stmt.setInt(3, obj.getPro_quantidade());
            stmt.setDouble(4, obj.getPro_preco());

            //executar e feichar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
    }

    public void excluirProduto(Produto obj) {
        try {
            String sql = "delete from produtos where id_produto = ?";

            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Passar Atributos
            stmt.setInt(1, obj.getId_produto());

            //executar e feichar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
    }

    public List<Produto> pesquisarProNome(String nome) {
        try {
            List<Produto> lista = new ArrayList();
            String sql = "select * from produtos where pro_nome like ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto obj = new Produto();
                obj.setId_produto(rs.getInt("id_produto"));
                obj.setPro_nome(rs.getString("pro_nome"));
                obj.setPro_categoria(rs.getString("pro_categoria"));
                obj.setPro_quantidade(rs.getInt("pro_quantidade"));
                obj.setPro_preco(rs.getDouble("pro_preco"));

                lista.add(obj);

            }
            return lista;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Produto> buscarProdutoNome(String nome) {
        try {
            List<Produto> lista = new ArrayList();
            String sql = "select * from produtos where pro_nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto obj = new Produto();
                obj.setId_produto(rs.getInt("id_produto"));
                obj.setPro_nome(rs.getString("pro_nome"));
                obj.setPro_categoria(rs.getString("pro_categoria"));
                obj.setPro_quantidade(rs.getInt("pro_quantidade"));
                obj.setPro_preco(rs.getDouble("pro_preco"));

                lista.add(obj);

            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
        return null;
    }

    public void baixaEstoque(Produto obj, int codigo) {
        try {
            String sql = "update produtos set pro_quantidade = ? where id_produto = " + codigo;

            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Passar Atributos
            stmt.setInt(1, obj.getPro_quantidade());

            //executar e feichar
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
    }

    public void nomeProdutoQtd(String nome, int qtd) {

        try {
            String sql = "select * from produtos where pro_nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("pro_quantidade")>=0) {
                    int qut = rs.getInt("pro_quantidade");
                    String nnome = rs.getString("pro_nome");
                    int nqtd = qut + qtd;

                    String update = "update produtos set pro_quantidade = ? where pro_nome = ?";
                    PreparedStatement stmtu = conexao.prepareStatement(update);
                    stmtu.setInt(1, nqtd);
                    stmtu.setString(2, nnome);


                    stmtu.execute();
                    stmtu.close();
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
    }

    public void altaEstoque(Produto obj) {
        try {
            String sql = "update produtos set pro_quantidade = ? where pro_nome = ?";
            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, obj.getPro_quantidade());
            stmt.setString(2, obj.getPro_nome());

            //executar e feichar
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872 293 580");
        }
    }
    
    
        public void imprimirProdutos() {
        try {

            String sql = "select pro_nome, pro_categoria, pro_preco, pro_quantidade from produtos";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            JRResultSetDataSource resultSet = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("iReport/RelatorioProdutos.jasper", new HashMap(), resultSet);
            JasperViewer jv = new JasperViewer(print, false);
            jv.setVisible(true);

        } catch (Exception e) {
        }
    }
}
