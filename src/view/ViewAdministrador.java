/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.FuncionarioDAO;
import DAO.MesaDAO;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Mesa;

/**
 *
 * @author Klayton Massango
 * @since 20 de Setembro de 2021
 * @version 0.3.0
 * @see Maze Development
 */
public final class ViewAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form ViewFuncionario
     */
    ViewRelatorios rel = null;

    public void listar() {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.listarFuncionarios();
        DefaultTableModel dados = (DefaultTableModel) jTable_funcionarios.getModel();
        dados.setNumRows(0);

        for (Funcionario f : lista) {
            dados.addRow(new Object[]{
                f.getNome(),
                f.getBi(),
                f.getTelefone(),
                f.getUsuario(),
                f.getSenha(),
                f.getNivel_acesso(),});
        }
    }

    public void listarMesas() {
        MesaDAO dao = new MesaDAO();
        List<Mesa> lista = dao.listarMesasComId();
        DefaultTableModel dados = (DefaultTableModel) jTable_mesas.getModel();
        dados.setNumRows(0);

        for (Mesa m : lista) {
            dados.addRow(new Object[]{
                m.getMsa_id(),
                m.getMsa_nome()
            });
        }
    }

    public void limparCampos() {
        jTF_fun_nome_.setText("");
        jTF_fun_bi.setText("");
        jTF_fun_telefone.setText("");
        jTF_fun_usuario.setText("");
        jTF_fun_senha.setText("");
    }

    public ViewAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage();
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_mesas = new javax.swing.JTable();
        jTF_Mesa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jBtn_cli_cadastrar = new javax.swing.JButton();
        jBtn_cli_excluir = new javax.swing.JButton();
        jBtn_Relatorio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_funcionarios = new javax.swing.JTable();
        jBtn_cadastrar = new javax.swing.JButton();
        jBtn_excluir = new javax.swing.JButton();
        jTF_fun_nome_ = new javax.swing.JTextField();
        jBtn_editar = new javax.swing.JButton();
        jTF_fun_telefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTF_fun_bi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTF_fun_senha = new javax.swing.JTextField();
        jTF_fun_usuario = new javax.swing.JTextField();
        jCbx_nivel_acesso = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(961, 592));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable_mesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_mesas);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Nome");

        jBtn_cli_cadastrar.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBtn_cli_cadastrar.setText("Cadastrar");
        jBtn_cli_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_cli_cadastrarActionPerformed(evt);
            }
        });

        jBtn_cli_excluir.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBtn_cli_excluir.setText("Excluir");
        jBtn_cli_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_cli_excluirActionPerformed(evt);
            }
        });

        jBtn_Relatorio.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jBtn_Relatorio.setText("Relatorios");
        jBtn_Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_RelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtn_cli_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jTF_Mesa)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtn_cli_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_cli_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_cli_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mesas", jPanel1);

        jTable_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Nr de BI", "Telefone", "Usuario", "Senha", "Nivel de Acesso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_funcionarios);

        jBtn_cadastrar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBtn_cadastrar.setText("Cadastrar");
        jBtn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_cadastrarActionPerformed(evt);
            }
        });

        jBtn_excluir.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBtn_excluir.setText("Excluir");
        jBtn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_excluirActionPerformed(evt);
            }
        });

        jTF_fun_nome_.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTF_fun_nome_InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTF_fun_nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_fun_nome_ActionPerformed(evt);
            }
        });

        jBtn_editar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jBtn_editar.setText("Editar");
        jBtn_editar.setToolTipText("");

        jTF_fun_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_fun_telefoneActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("BI");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Telefone");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Senha");

        jCbx_nivel_acesso.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jCbx_nivel_acesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Master", "Administrador" }));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Nivel de Acesso");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTF_fun_bi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jTF_fun_telefone, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_fun_senha)
                            .addComponent(jTF_fun_usuario)))
                    .addComponent(jTF_fun_nome_))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jCbx_nivel_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTF_fun_nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jBtn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTF_fun_bi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTF_fun_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbx_nivel_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_fun_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTF_fun_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionarios", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

        listar();
        listarMesas();
    }//GEN-LAST:event_formWindowActivated

    private void jBtn_cli_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_cli_excluirActionPerformed
        // TODO add your handling code here:
        Mesa obj = new Mesa();
        int linha = jTable_mesas.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione a mesa que deseja excluir!");
        } else {

            int mesaId = (int) jTable_mesas.getValueAt(linha, 0);

            obj.setMsa_id(mesaId);
            MesaDAO dao = new MesaDAO();
            dao.excluirMesa(obj);

        }
        listarMesas();
    }//GEN-LAST:event_jBtn_cli_excluirActionPerformed

    private void jBtn_cli_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_cli_cadastrarActionPerformed
        // TODO add your handling code here:
        Mesa obj = new Mesa();
        // Verifica se os campos estao vazios
        if (jTF_Mesa.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
        } else {
            // Pega os valores inseridos nos campos e armazena na classe Produto
            obj.setMsa_nome(jTF_Mesa.getText());

            // instancia o DAO e faz executa o metodo de cadastro dos produtos
            MesaDAO dao = new MesaDAO();
            dao.adicionarMesa(obj);

            jTF_Mesa.setText("");
        }
        listarMesas();
    }//GEN-LAST:event_jBtn_cli_cadastrarActionPerformed

    private void jTF_fun_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_fun_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_fun_telefoneActionPerformed

    private void jTF_fun_nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_fun_nome_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_fun_nome_ActionPerformed

    private void jTF_fun_nome_InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTF_fun_nome_InputMethodTextChanged
        // TODO add your handling code here:
        //        jTF_fun_usuario.setText(jTF_cli_nome.getText().trim().substring(0, 4));
    }//GEN-LAST:event_jTF_fun_nome_InputMethodTextChanged

    private void jBtn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_excluirActionPerformed
        // TODO add your handling code here:
        Funcionario obj = new Funcionario();

        int linha = jTable_funcionarios.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione o funcionario depois Exclua!");
        } else {

            String nomeFuncionario = (String) jTable_funcionarios.getValueAt(linha, 0);

            obj.setNome(nomeFuncionario);
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.excluirFuncionario(obj);

            listar();
        }
    }//GEN-LAST:event_jBtn_excluirActionPerformed

    private void jBtn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_cadastrarActionPerformed
        // TODO add your handling code here:
        Funcionario obj = new Funcionario();

        // Verifica se os campos estao vazios
        if (jTF_fun_nome_.getText().equals("")
                || jTF_fun_bi.getText().equals("")
                || jTF_fun_telefone.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
        } else {
            String nome = jTF_fun_nome_.getText();
            String usuario = jTF_fun_usuario.getText();
            // Pega os valores inseridos nos campos e armazena na classe Produto
            obj.setNome(nome);
            obj.setBi(jTF_fun_bi.getText());
            obj.setTelefone(jTF_fun_telefone.getText());
            obj.setUsuario(usuario);
            obj.setSenha(jTF_fun_senha.getText());
            obj.setNivel_acesso(jCbx_nivel_acesso.getSelectedItem().toString());

            // instancia o DAO e faz executa o metodo de cadastro dos produtos
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.cadastrarFuncionarios(obj);

            // Metodo que limpa os campos
            limparCampos();
            listar();
        }
    }//GEN-LAST:event_jBtn_cadastrarActionPerformed

    private void jBtn_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_RelatorioActionPerformed
        // TODO add your handling code here:
        if (rel == null) {
            rel = new ViewRelatorios();
        }
        rel.setVisible(true);
    }//GEN-LAST:event_jBtn_RelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Relatorio;
    private javax.swing.JButton jBtn_cadastrar;
    private javax.swing.JButton jBtn_cli_cadastrar;
    private javax.swing.JButton jBtn_cli_excluir;
    private javax.swing.JButton jBtn_editar;
    private javax.swing.JButton jBtn_excluir;
    private javax.swing.JComboBox<String> jCbx_nivel_acesso;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_Mesa;
    private javax.swing.JTextField jTF_fun_bi;
    private javax.swing.JTextField jTF_fun_nome_;
    private javax.swing.JTextField jTF_fun_senha;
    private javax.swing.JTextField jTF_fun_telefone;
    private javax.swing.JTextField jTF_fun_usuario;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_funcionarios;
    private javax.swing.JTable jTable_mesas;
    // End of variables declaration//GEN-END:variables
}
