/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Klayton Massango
 */
public class ConexaoBanco {
    private final String SERVIDOR = "localhost";
    private final String BANCO = "gestordevendas";
    private final String USUARIO = "mazedev";
    private final String SENHA = "mazedev2*21";
    
    public Connection conectar(){
        try{
            return DriverManager.getConnection("jdbc:mysql://"+SERVIDOR+"/"+BANCO, USUARIO, SENHA);
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
        return null;
    }
}
