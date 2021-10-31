/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import javax.swing.JOptionPane;

/**
 *
 * @author Klayton Massango
 */
public class TestarConexao {
    public static void main(String []args){
        try{
            new ConexaoBanco().conectar();
            JOptionPane.showMessageDialog(null,"Conectado");
        }catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Erro");
        }
        
    }
}
