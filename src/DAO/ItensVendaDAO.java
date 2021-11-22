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
import model.ItensVenda;
import model.Mesa;
import model.Produto;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Klayton Massango
 */
public class ItensVendaDAO {

    private Connection conexao;

    public ItensVendaDAO() {
        this.conexao = new ConexaoBanco().conectar();
    }

    public boolean verificarItem(ItensVenda obj) {
        boolean bool = false;
        try {
            String sqli = "select * from contas where inativo = " + 0;
            PreparedStatement stmtt = conexao.prepareStatement(sqli);
            ResultSet rss = stmtt.executeQuery();

            if (rss.next()) {

                if (obj.getProduto().getId_produto() == rss.getInt("fk_produto") && rss.getInt("fk_mesa") == obj.getMesas().getMsa_id()) {
                    bool = true;
                }
            }
        } catch (Exception e) {
        }
        return bool;
    }

    public void cadastrarItensVenda(ItensVenda obj) {
        try {
            String sqli = "SELECT * FROM contas WHERE fk_mesa = " + obj.getMesas().getMsa_id() + " AND inativo = " + 0;
            PreparedStatement stmtt = conexao.prepareStatement(sqli);

            ResultSet rss = stmtt.executeQuery();
            int negacao = 2;

            if (rss.next()) {
                do {
                    if (negacao == 2) {
                        if (obj.getProduto().getId_produto() == rss.getInt("fk_produto")) {

                            double bpreco = rss.getDouble("con_pro_preco");
                            int bqtd = rss.getInt("con_pro_qut");
                            int qut = bqtd + obj.getQuantidade();
                            double sub = qut * bpreco;

                            String update = "update contas set con_pro_qut= ?, con_pro_sub = ? where fk_produto =? and fk_mesa=?";
                            PreparedStatement stmtu = conexao.prepareStatement(update);
                            stmtu.setInt(1, qut);
                            stmtu.setDouble(2, sub);
                            stmtu.setInt(3, obj.getProduto().getId_produto());
                            stmtu.setInt(4, obj.getMesas().getMsa_id());

                            stmtu.execute();
                            stmtu.close();
                            negacao = 1;
                        }
                    }
                }while (rss.next());
                stmtt.close();
                
                if (negacao ==2) {

                    String sql = "insert into contas (fk_produto, fk_mesa, con_pro_qut, con_pro_preco, con_pro_sub, con_pro_data) "
                            + "values(?,?,?,?,?,?)";
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    stmt.setInt(1, obj.getProduto().getId_produto());
                    stmt.setInt(2, obj.getMesas().getMsa_id());
                    stmt.setInt(3, obj.getQuantidade());
                    stmt.setDouble(4, obj.getPreco());
                    stmt.setDouble(5, obj.getSubtotal());
                    stmt.setString(6, obj.getData());

                    stmt.execute();
                    stmt.close();
                }

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<ItensVenda> listaItensVenda(int fk_mesa, String dataatual) {
        try {
            List<ItensVenda> lista = new ArrayList<>();
            String sql = "select c.id_conta, produtos.pro_nome, mesas.ms_nome, c.con_pro_qut, c.con_pro_preco, c.con_pro_sub, c.inativo from contas as c inner join "
                    + "produtos on(c.fk_produto=produtos.id_produto) inner join mesas on(c.fk_mesa=mesas.id_mesa) where c.fk_mesa=? and c.con_pro_data=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, fk_mesa);
            stmt.setString(2, dataatual);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                if (rs.getInt("c.inativo") == 0) {
                    ItensVenda item = new ItensVenda();
                    Produto p = new Produto();
                    Mesa m = new Mesa();

                    item.setId(rs.getInt("id_conta"));
                    p.setPro_nome(rs.getString("produtos.pro_nome"));
                    m.setMsa_nome(rs.getString("mesas.ms_nome"));
                    item.setQuantidade(rs.getInt("c.con_pro_qut"));
                    item.setPreco(rs.getDouble("c.con_pro_preco"));
                    item.setSubtotal(rs.getDouble("c.con_pro_sub"));
                    item.setProduto(p);
                    item.setMesas(m);
                    lista.add(item);
                }
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public List<ItensVenda> listaVenda(String dataatual) {
        try {
            List<ItensVenda> lista = new ArrayList<>();
            String sql = "select c.id_conta, produtos.pro_nome, mesas.ms_nome, c.con_pro_qut, c.con_pro_preco, c.con_pro_sub, c.con_pro_data, c.inativo from contas as c inner join "
                    + "produtos on(c.fk_produto=produtos.id_produto) inner join mesas on(c.fk_mesa=mesas.id_mesa) where c.con_pro_data=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, dataatual);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                if (rs.getInt("c.inativo") == 1) {
                    ItensVenda item = new ItensVenda();
                    Produto p = new Produto();
                    Mesa m = new Mesa();

                    item.setId(rs.getInt("id_conta"));
                    p.setPro_nome(rs.getString("produtos.pro_nome"));
                    m.setMsa_nome(rs.getString("mesas.ms_nome"));
                    item.setQuantidade(rs.getInt("c.con_pro_qut"));
                    item.setPreco(rs.getDouble("c.con_pro_preco"));
                    item.setSubtotal(rs.getDouble("c.con_pro_sub"));
                    item.setData(rs.getString("c.con_pro_data"));
                    item.setProduto(p);
                    item.setMesas(m);
                    lista.add(item);
                }

            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public void excluirItenVenda(ItensVenda obj) {
        try {
            String sql = "delete from contas where id_conta = ?";

            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Passar Atributos
            stmt.setInt(1, obj.getId());

            //executar e fechar
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e + "/n/r Contacte o suporte maze.of.development@gmail.com");
        }
    }

    public void imprimirConta(int mesa, String data) {
        try {

            String sql = "select c.id_conta, produtos.pro_nome, mesas.ms_nome, c.con_pro_qut, c.con_pro_preco, c.con_pro_sub, c.inativo from contas as c "
                    + "inner join produtos on(c.fk_produto=produtos.id_produto) "
                    + "inner join mesas on(c.fk_mesa=mesas.id_mesa) where c.fk_mesa=" + mesa + " and con_pro_data='" + data + "' and inativo=" + 0;
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            JRResultSetDataSource resultSet = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("iReport/recibo_da_venda.jasper", new HashMap(), resultSet);
            JasperViewer jv = new JasperViewer(print, false);
            jv.setVisible(true);

        } catch (Exception e) {
        }
    }

    public void finalizarConta(int mesa, String data) {
        try {
            String sql = "update contas set inativo = " + 1 + " where fk_mesa =? and con_pro_data = ? and inativo =0";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, mesa);
            stmt.setString(2, data);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public void finalizarVendas(int id) {
        try {
            String sql = "update contas set inativo = " + 2 + " where id_conta =?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public void voidProduto(int id) {
        try {
            String sql = "update contas set fk_mesa = " + 1 + " where id_conta =?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "SUCESSO");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
}
