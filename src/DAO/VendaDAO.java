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
import model.Vendas;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Klayton Massango
 */
public class VendaDAO {

    private Connection conexao;

    public VendaDAO() {
        this.conexao = new ConexaoBanco().conectar();
    }

    public void cadastrarVenda(Vendas obj) {
        try {
            String sql = "insert into vendas (fk_conta, vd_data, vd_total) "
                    + "values(?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.setString(2, obj.getVd_data());
            stmt.setDouble(3, obj.getVd_total());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872-293-580");
        }
    }

    public List<Vendas> listarVendas() {
        try {
            List<Vendas> lista = new ArrayList();

            String sql = "select * from vendas";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vendas obj = new Vendas();
                ItensVenda iv = new ItensVenda();
                obj.setId(rs.getInt("id_venda"));
                iv.setId(rs.getInt("fk_conta"));
                obj.setVd_data(rs.getString("vd_data"));
                obj.setVd_total(rs.getDouble("vd_total"));
                obj.setVenda(iv);
                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872-293-580");
        }
        return null;
    }

    public List<Vendas> pesquisarVendas(Vendas obj) {
        try {
            List<Vendas> lista = new ArrayList();

            String sql = "select * from vendas where vd_data = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getVd_data());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItensVenda iv = new ItensVenda();
                obj.setId(rs.getInt("id_venda"));
                iv.setId(rs.getInt("fk_conta"));
                obj.setVd_data(rs.getString("vd_data"));
                obj.setVd_total(rs.getDouble("vd_total"));
                obj.setVenda(iv);
                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e +" Contacte o suporte: (+258)872-293-580");
        }
        return null;
    }
    
        public void imprimirRelatorio(String data, String datafim, String metodo) {
        try {
            String sql = "select produtos.pro_nome,contas.con_pro_qut, contas.metodo,contas.funcionario, mesas.ms_nome, v.vd_data, v.vd_total from vendas as v "
                    + "inner join contas on(v.fk_conta=contas.id_conta) "
                    + "INNER JOIN produtos ON(contas.fk_produto=produtos.id_produto) "
                    + "inner join mesas on(contas.fk_mesa=mesas.id_mesa) "
                    + "where v.vd_data between '"+data+"' and '"+datafim+"' and contas.metodo = '" + metodo + "'";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            JRResultSetDataSource resultSet = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("iReport/RelatorioVendas.jasper", new HashMap(), resultSet);
            JasperViewer jv = new JasperViewer(print, false);
            jv.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
