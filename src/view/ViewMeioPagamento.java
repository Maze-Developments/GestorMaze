/*
 * Copyright (C) 2021 Klayton Massango
 *
 * This program is not a free software: you can't redistribute it and/or modify
 * it under the terms of the Maze dev License as published by
 * the Maze Development, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT PAYMENTS; with the implied payments of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Maze dev License for more details.
 *
 * You should have received a copy of the Maze Development License
 * along with this program.  If not, see <http://www.mazedeve.com/licenses/>.
 */
package view;

import DAO.ItensVendaDAO;
import DAO.VendaDAO;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Klayton Massango
 */
public class ViewMeioPagamento extends javax.swing.JFrame {

    /**
     * Creates new form ViewMeioPagamento
     */
    public ViewMeioPagamento() {
        initComponents();
        setIconImage();
        setLocationRelativeTo(null);
    }
    public void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gp_pagamento = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRbtn_dinheiro = new javax.swing.JRadioButton();
        jRbtn_cartao = new javax.swing.JRadioButton();
        jRbtn_mpesa = new javax.swing.JRadioButton();
        jRbtn_contamovel = new javax.swing.JRadioButton();
        jBtn_confirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTF_mesa = new javax.swing.JTextField();
        jLbl_nomeFuncionario = new javax.swing.JLabel();
        jLbl_conta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jRbtn_dinheiro.setBackground(new java.awt.Color(0, 153, 153));
        gp_pagamento.add(jRbtn_dinheiro);
        jRbtn_dinheiro.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRbtn_dinheiro.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_dinheiro.setSelected(true);
        jRbtn_dinheiro.setText("Dinheiro");
        jRbtn_dinheiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRbtn_dinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbtn_dinheiroActionPerformed(evt);
            }
        });

        jRbtn_cartao.setBackground(new java.awt.Color(0, 153, 153));
        gp_pagamento.add(jRbtn_cartao);
        jRbtn_cartao.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRbtn_cartao.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_cartao.setText("Cartão");
        jRbtn_cartao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRbtn_mpesa.setBackground(new java.awt.Color(0, 153, 153));
        gp_pagamento.add(jRbtn_mpesa);
        jRbtn_mpesa.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRbtn_mpesa.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_mpesa.setText("M-pesa");
        jRbtn_mpesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRbtn_contamovel.setBackground(new java.awt.Color(0, 153, 153));
        gp_pagamento.add(jRbtn_contamovel);
        jRbtn_contamovel.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jRbtn_contamovel.setForeground(new java.awt.Color(255, 255, 255));
        jRbtn_contamovel.setText("Conta Movel");
        jRbtn_contamovel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jBtn_confirmar.setBackground(new java.awt.Color(255, 255, 255));
        jBtn_confirmar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jBtn_confirmar.setText("CONFIRMAR");
        jBtn_confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_confirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("METODO DE PAGAMENTO");

        jTF_mesa.setEditable(false);
        jTF_mesa.setBackground(new java.awt.Color(0, 153, 153));
        jTF_mesa.setForeground(new java.awt.Color(0, 153, 153));
        jTF_mesa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLbl_nomeFuncionario.setForeground(new java.awt.Color(0, 153, 153));
        jLbl_nomeFuncionario.setText("Nome do Funcionario");

        jLbl_conta.setForeground(new java.awt.Color(0, 153, 153));
        jLbl_conta.setText("Nome do Funcionario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRbtn_cartao)
                    .addComponent(jRbtn_dinheiro)
                    .addComponent(jTF_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRbtn_contamovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRbtn_mpesa)
                    .addComponent(jLbl_nomeFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtn_confirmar)
                    .addComponent(jLbl_conta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRbtn_dinheiro)
                            .addComponent(jRbtn_mpesa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRbtn_cartao)
                            .addComponent(jRbtn_contamovel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbl_nomeFuncionario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jBtn_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLbl_conta)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRbtn_dinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbtn_dinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRbtn_dinheiroActionPerformed

    private void jBtn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_confirmarActionPerformed
        // TODO add your handling code here:
        String metodo = "";
        
        if (jRbtn_dinheiro.isSelected()) {
            metodo = "Dinheiro";
            
        }
        if (jRbtn_mpesa.isSelected()) {
            metodo = "M-Pesa";
        }
        if (jRbtn_cartao.isSelected()) {
            metodo = "Cartao";
        }
        if (jRbtn_dinheiro.isSelected()) {
            metodo = "Dinheiro";
        }
        if (jRbtn_contamovel.isSelected()) {
            metodo = "Conta Movel";
        }
        
        System.out.println("Mesa--" + jTF_mesa.getText());
        Date data = new Date();
        SimpleDateFormat dataSql = new SimpleDateFormat("yyyy-MM-dd");
        String dat = dataSql.format(data);
        
        int mesa = Integer.valueOf(jTF_mesa.getText());
        String nomeFuncionario = jLbl_nomeFuncionario.getText();
        
        ItensVendaDAO dao = new ItensVendaDAO();
        VendaDAO daoo = new VendaDAO();
        dao.imprimirConta(mesa, dat);
        dao.finalizarConta(mesa, dat, metodo, nomeFuncionario);
        
        dispose();
    }//GEN-LAST:event_jBtn_confirmarActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMeioPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMeioPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMeioPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMeioPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMeioPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gp_pagamento;
    private javax.swing.JButton jBtn_confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbl_conta;
    private javax.swing.JLabel jLbl_nomeFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRbtn_cartao;
    private javax.swing.JRadioButton jRbtn_contamovel;
    private javax.swing.JRadioButton jRbtn_dinheiro;
    private javax.swing.JRadioButton jRbtn_mpesa;
    private javax.swing.JTextField jTF_mesa;
    // End of variables declaration//GEN-END:variables
public void valorMesa(String mesa, String nomeFuncionario) {
        jTF_mesa.setText(mesa);
        jLbl_nomeFuncionario.setText(nomeFuncionario);
//        jLbl_conta.setText(conta);
    }
}
