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
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;

/**
 *
 * @author Klayton Massango
 */
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = new ConexaoBanco().conectar();
    }

    public void cadastrarClientes(Cliente obj) {
        try {
            String sql = "select * from clientes where cli_nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (obj.getNome().equals(rs.getString("cli_nome"))) {
                    JOptionPane.showMessageDialog(null, "O Nome já cadastrado.");

                }
            } else {

                // String da query
                String sqlin = "insert into clientes (cli_nome, cli_bi, cli_telefone)"
                        + "values(?,?,?)";
                // Preparar a string
                PreparedStatement stmtt = conexao.prepareStatement(sqlin);

                // Passar Atributos
                stmtt.setString(1, obj.getNome());
                stmtt.setString(2, obj.getBi());
                stmtt.setString(3, obj.getTelefone());

                //executar e feichar
                stmtt.execute();
                stmtt.close();

                //Mensagem de Confirmacao
                JOptionPane.showMessageDialog(null, "Novo Cliente Cadastrado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<Cliente> listarClientes() {
        try {
            List<Cliente> lista = new ArrayList();

            String sql = "select * from clientes order by id_cliente desc";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCodigo(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("cli_nome"));
                obj.setBi(rs.getString("cli_bi"));
                obj.setTelefone("cli_telefone");
                lista.add(obj);
            }
            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public void excluirCliente(Cliente obj) {
        try {
            String sql = "delete from clientes where cli_nome = ?";

            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Passar Atributos
            stmt.setString(1, obj.getNome());

            //executar e feichar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

}
