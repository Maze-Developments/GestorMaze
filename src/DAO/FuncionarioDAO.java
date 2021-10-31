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
import model.Funcionario;
import view.ViewLogin;
import view.ViewPrincipal;


/**
 *
 * @author Klayton Massango
 */
public class FuncionarioDAO {
    private Connection conexao;
    
    public FuncionarioDAO(){
        this.conexao = new ConexaoBanco().conectar();
    }
    
    public void cadastrarFuncionarios(Funcionario obj){
        try{
            String sql = "select * from funcionarios where fun_nome = ? and hide ="+0;
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
            if(obj.getNome().equals(rs.getString("fun_nome"))){
                JOptionPane.showMessageDialog(null, "O Nome já cadastrado.");
                
            }
            }else{
            
            // String da query
            String sqlin = "insert into funcionarios (fun_nome, fun_bi, fun_telefone, fun_usuario, fun_senha, nivel_acesso)"
                    + "values(?,?,?,?,?,?)";
            // Preparar a string
            PreparedStatement stmtt = conexao.prepareStatement(sqlin);
            
            // Passar Atributos
            stmtt.setString(1,obj.getNome());
            stmtt.setString(2,obj.getBi());
            stmtt.setString(3,obj.getTelefone());
            stmtt.setString(4, obj.getUsuario());
            stmtt.setString(5, obj.getSenha());
            stmtt.setString(6, obj.getNivel_acesso());
            
            //executar e feichar
            stmtt.execute();
            stmtt.close();
            
            //Mensagem de Confirmacao
            JOptionPane.showMessageDialog(null,"Novo Funcionario Cadastrado!");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
    }
    
    public List<Funcionario> listarFuncionarios(){
        try{
               List<Funcionario> lista = new ArrayList();
               
            String sql= "select * from funcionarios where hide="+0;
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario obj = new Funcionario();
                obj.setCodigo(rs.getInt("id_funcionario"));
                obj.setNome(rs.getString("fun_nome"));
                obj.setBi(rs.getString("fun_bi"));
                obj.setTelefone(rs.getString("fun_telefone"));
                obj.setUsuario(rs.getString("fun_usuario"));
                obj.setSenha(rs.getString("fun_senha"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
                lista.add(obj);
                System.out.println(lista);
            }
            return lista;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
        return null;
    }

    public void excluirFuncionario(Funcionario obj){
        try{
            String sql = "delete from funcionarios where fun_nome = ?";
            
            // Preparar a string
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            // Passar Atributos
            stmt.setString(1,obj.getNome());
            
            //executar e feichar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Funcionario Excluido!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+ e +"/n Contacte o suporte maze.of.development@gmail.com");
        }
    }
    
    public void efetuarLogin(String usuario, String senha){
        try {
            String sql = "select * from funcionarios where fun_usuario = ? and fun_senha = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
            
            if(rs.getString("nivel_acesso").equals("Administrador")){
                JOptionPane.showMessageDialog(null,"Bem vindo " + rs.getString("fun_nome"),"LOGADO",JOptionPane.INFORMATION_MESSAGE);
                ViewPrincipal principal = new ViewPrincipal();
                principal.admin = rs.getString("nivel_acesso");
                principal.nomeLogado= rs.getString("fun_nome");
                principal.setVisible(true);
                
            }else if (rs.getString("nivel_acesso").equals("Usuario")) {
                JOptionPane.showMessageDialog(null,"Bem vindo " + rs.getString("fun_nome"),"LOGADO",JOptionPane.INFORMATION_MESSAGE);
                ViewPrincipal principal = new ViewPrincipal();
                principal.admin = rs.getString("nivel_acesso");
                principal.nomeLogado= rs.getString("fun_nome");
                principal.setVisible(true);
                
            }
            if (rs.getString("nivel_acesso").equals("Master")) {
                JOptionPane.showMessageDialog(null,"Bem vindo " + rs.getString("fun_nome"),"LOGADO",JOptionPane.INFORMATION_MESSAGE);
                ViewPrincipal principal = new ViewPrincipal();
                principal.admin = rs.getString("nivel_acesso");
                principal.nomeLogado= rs.getString("fun_nome");
                principal.setVisible(true);
               
            }
            }else{
                new ViewLogin().setVisible(true);
                JOptionPane.showMessageDialog(null,"Nome de usuario ou senha incorreta!","NEGADO",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }
    }
    
    public void verificaFuncionario(String nome, String usuario){
        try {
            
            String sql = "select * from funcionarios where fun_nome = ? and fun_usuario = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, usuario);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
            if(rs.getString("fun_nome").equals(nome) && rs.getString("fun_usuario").equals(usuario)){
                JOptionPane.showMessageDialog(null, "O Nome/Usuario já cadastrado.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e);
        }
    }
}
