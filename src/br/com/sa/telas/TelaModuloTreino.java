package br.com.sa.telas;

import br.com.sa.classes.GerenciadorDeJanelas;
import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import java.awt.Window;
import javax.swing.SwingUtilities;

public class TelaModuloTreino extends javax.swing.JFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    GerenciadorDeJanelas gerenciadorDeJanela; //variavel para trabalhar com o gerenciador de janelas

    //as variaveis abaixo armazenam os dados do usuario do sistema para reabrir a janela.  
    public static String NomeUso = null, PerfilAcesso = null, DataAcesso = null;

    //infotmaçoes necessarias do cliente
    public static String sexo;
    public static int idade;

    public void buscasexo() {

        String sql = "select * from clientes where idcli=?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblMatricula.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                sexo = rs.getString(11);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }

    public void carregainfomacro() {
        
        String sql = "select * from avaliacao1 where idava=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();
            
            if (rs.next()){
            
            TelaMacrociclo.lblVelocidade.setText(rs.getString("neuro30"));//velocidade de deslocamento
            TelaMacrociclo.lblExpMs.setText(rs.getString("neuro14"));//força explosiva membos superiores
            TelaMacrociclo.lblExpMi.setText(rs.getString("neuro17"));//impulso horizontal
            TelaMacrociclo.lblAla.setText(rs.getString("carala03"));//potencia alatica
            TelaMacrociclo.lblFlex.setText(rs.getString("postu21"));//Nivel de Flexibilidade
            TelaMacrociclo.lblVo2.setText(rs.getString("vo2"));//Volume maximo de oxigênio
            TelaMacrociclo.lblDebito.setText(rs.getString("debcard"));//Debito cardiaco
            TelaMacrociclo.lblAbd.setText(rs.getString("neuro02"));//resistencia muscular local de abdomem
            TelaMacrociclo.lblBraco.setText(rs.getString("neuro08"));//resistencia muscular local de membors superiores
            TelaMacrociclo.lblPerna.setText(rs.getString("neuro11"));//resistencia muscular local de membors infereiores
            
            
            
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao carregar macrociclo\n"+e);
        }
    }

    //o metodo abaixo reabre a tela inicial e envia as informações novamente.
    public void reabretela() {

        if (PerfilAcesso.equals("Administrador")) {

            TelaPrincipal principal = new TelaPrincipal();//instanciando a tela
            //principal.setExtendedState(JFrame.MAXIMIZED_BOTH);//iniciando a tela maximizado
            principal.setVisible(true);
            //TelaPrincipal.//ativando os botoes desativados pelo perfil
            TelaPrincipal.menNovUso.setEnabled(true);
            TelaPrincipal.menRel.setEnabled(true);
            TelaPrincipal.MenCadProp.setEnabled(true);
            TelaPrincipal.lblUsuario.setText(NomeUso);
            TelaPrincipal.lblPerfil.setText(PerfilAcesso);//aqui passa para o lbl o valor do perfil em banco de dados
            TelaPrincipal.lblData.setText(DataAcesso);

        } else {

            TelaPrincipal principal = new TelaPrincipal();//instanciando a tela
            principal.setVisible(true);
            TelaPrincipal.lblUsuario.setText(NomeUso);
            TelaPrincipal.lblPerfil.setText(PerfilAcesso);//aqui passa para o lbl o valor do perfil em banco de dados
            TelaPrincipal.lblData.setText(DataAcesso);

        }

    }

    public TelaModuloTreino() {
        initComponents();
        conexao = ModuloConexao.conector();//devese iniciar a conexao sempre pelo construtor antes de realizar uma consulta
        this.gerenciadorDeJanela = new GerenciadorDeJanelas(DesktopTreino);//passar o desktop para dentro da variavel 
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAvaAnaminese = new javax.swing.JButton();
        btnAvaHemo = new javax.swing.JButton();
        btnAvaMedidas = new javax.swing.JButton();
        btnAvaCardio = new javax.swing.JButton();
        btnAvaImpri = new javax.swing.JButton();
        btnAvaSair = new javax.swing.JButton();
        btnAvaInicio = new javax.swing.JButton();
        btnAvaNeuro = new javax.swing.JButton();
        DesktopTreino = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblNomeProfessor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblIdProf = new javax.swing.JLabel();
        lblIdAva = new javax.swing.JLabel();
        lblNomeAluno = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Modulo Avaliação");
        setBackground(new java.awt.Color(255, 247, 241));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Controles"));
        jPanel1.setName("Módulos"); // NOI18N

        btnAvaAnaminese.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anamnese30x40.png"))); // NOI18N
        btnAvaAnaminese.setText("Macrociclo");
        btnAvaAnaminese.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaAnaminese.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaAnaminese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaAnamineseActionPerformed(evt);
            }
        });

        btnAvaHemo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/hemo40x40.png"))); // NOI18N
        btnAvaHemo.setText("Ficha de Treino");
        btnAvaHemo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaHemo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaHemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaHemoActionPerformed(evt);
            }
        });

        btnAvaMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/medidas40x40.png"))); // NOI18N
        btnAvaMedidas.setText("Resultados");
        btnAvaMedidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaMedidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaMedidasActionPerformed(evt);
            }
        });

        btnAvaCardio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/cardio40x40.png"))); // NOI18N
        btnAvaCardio.setText("Parâmetros");
        btnAvaCardio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaCardio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaCardio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaCardioActionPerformed(evt);
            }
        });

        btnAvaImpri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/imprimir30x30.png"))); // NOI18N
        btnAvaImpri.setText("Imprimir");
        btnAvaImpri.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaImpri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaImpri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaImpriActionPerformed(evt);
            }
        });

        btnAvaSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        btnAvaSair.setText("Sair");
        btnAvaSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaSairActionPerformed(evt);
            }
        });

        btnAvaInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/start-icon.png"))); // NOI18N
        btnAvaInicio.setText("Iniciar Programa");
        btnAvaInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaInicioActionPerformed(evt);
            }
        });

        btnAvaNeuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/neuro40x40.png"))); // NOI18N
        btnAvaNeuro.setText("Cadastrar Exercícios");
        btnAvaNeuro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaNeuro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaNeuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaNeuroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAvaAnaminese, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaHemo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaMedidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaCardio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaImpri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaNeuro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAvaInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaAnaminese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaHemo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaMedidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaCardio)
                .addGap(45, 45, 45)
                .addComponent(btnAvaNeuro)
                .addGap(51, 51, 51)
                .addComponent(btnAvaImpri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnAvaSair)
                .addContainerGap())
        );

        DesktopTreino.setBackground(new java.awt.Color(255, 247, 241));
        DesktopTreino.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DesktopTreinoPropertyChange(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Fundotelaprincipal.png"))); // NOI18N
        DesktopTreino.add(jLabel5);
        jLabel5.setBounds(90, 0, 940, 670);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informações"));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Aluno:");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Matrícula:");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Professor:");

        lblMatricula.setText("000000");

        lblNomeProfessor.setText("Nome Professor");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("IdA:");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("IdP:");

        lblIdProf.setText("000");

        lblIdAva.setText("000");

        lblNomeAluno.setText("Nome Aluno");

        lblIdade.setText("00");

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Idade:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdAva, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdProf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNomeAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMatricula)
                    .addComponent(lblIdade)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblNomeProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblIdProf)
                    .addComponent(jLabel7)
                    .addComponent(lblIdAva))
                .addGap(6, 6, 6))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MÓDULO DE TREINO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DesktopTreino, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(DesktopTreino)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Módulos");
        jPanel1.getAccessibleContext().setAccessibleDescription("Módulos");

        setSize(new java.awt.Dimension(1286, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaSairActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Esta tela esta sendo fechada, deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {

            //TelaModuloAva.this.dispose();
            reabretela();
            TelaModuloTreino comp = (TelaModuloTreino) SwingUtilities.getRoot(this);
            ((Window) comp).dispose();

        } else {

        }
    }//GEN-LAST:event_btnAvaSairActionPerformed

    private void btnAvaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaInicioActionPerformed


    }//GEN-LAST:event_btnAvaInicioActionPerformed

    private void btnAvaAnamineseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaAnamineseActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaMacrociclo.getInstancia());
        carregainfomacro();
    }//GEN-LAST:event_btnAvaAnamineseActionPerformed

    private void btnAvaHemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaHemoActionPerformed

    }//GEN-LAST:event_btnAvaHemoActionPerformed

    private void btnAvaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaMedidasActionPerformed


    }//GEN-LAST:event_btnAvaMedidasActionPerformed

    private void DesktopTreinoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DesktopTreinoPropertyChange

    }//GEN-LAST:event_DesktopTreinoPropertyChange

    private void btnAvaCardioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaCardioActionPerformed

    }//GEN-LAST:event_btnAvaCardioActionPerformed

    private void btnAvaNeuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaNeuroActionPerformed

    }//GEN-LAST:event_btnAvaNeuroActionPerformed

    private void btnAvaImpriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaImpriActionPerformed

    }//GEN-LAST:event_btnAvaImpriActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int adicionar = JOptionPane.showConfirmDialog(null, "Esta tela esta sendo fechada, deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (adicionar == JOptionPane.YES_OPTION) {

            reabretela();//chama a tela principal
            //abaixo fecha a tela modulo ava
            TelaMacrociclo.telaMacro = null;
            TelaModuloTreino comp = (TelaModuloTreino) SwingUtilities.getRoot(this);
            ((Window) comp).dispose();

            //TelaModuloAva.this.dispose(); metodo antigo de fechar a janela
        } else {

        }
    }//GEN-LAST:event_formWindowClosing

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaModuloTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModuloTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModuloTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModuloTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModuloTreino().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane DesktopTreino;
    public static javax.swing.JButton btnAvaAnaminese;
    public static javax.swing.JButton btnAvaCardio;
    public static javax.swing.JButton btnAvaHemo;
    public static javax.swing.JButton btnAvaImpri;
    public static javax.swing.JButton btnAvaInicio;
    public static javax.swing.JButton btnAvaMedidas;
    public static javax.swing.JButton btnAvaNeuro;
    private javax.swing.JButton btnAvaSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblIdAva;
    public static javax.swing.JLabel lblIdProf;
    public static javax.swing.JLabel lblIdade;
    public static javax.swing.JLabel lblMatricula;
    public static javax.swing.JLabel lblNomeAluno;
    public static javax.swing.JLabel lblNomeProfessor;
    // End of variables declaration//GEN-END:variables
}
