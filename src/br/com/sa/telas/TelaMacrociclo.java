/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sa.telas;

/**
 *
 * @author Tarciso Nascimento
 */
public class TelaMacrociclo extends javax.swing.JInternalFrame {

    public static TelaMacrociclo telaMacro;

    public static TelaMacrociclo getInstancia() {
        if (telaMacro == null) {

            telaMacro = new TelaMacrociclo();

        }
        return telaMacro;
    }

    public TelaMacrociclo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblExpMs = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblVelocidade = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblExpMi = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblAla = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblAla1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblExpMi1 = new javax.swing.JLabel();
        lblExpMs1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblVelocidade1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblAla2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblAla3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 247, 241));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/macro700x63.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(330, 0, 700, 63);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Parâmetros do Macrociclo");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 310, 310, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(30, 340, 270, 10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Parâmetros da Avaliação Física");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 3, 290, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Neuromusculares");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 45, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cardiopulmonares");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 177, 140, 30);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(30, 30, 270, 10);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(30, 70, 150, 10);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(30, 202, 150, 10);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Flexibilidade Toracolombar:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 160, 170, 14);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("m");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(250, 100, 30, 14);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Força Explosiva Membro Superior:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 100, 170, 14);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Força Explosiva Membro Inferior:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(40, 120, 170, 14);

        lblExpMs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExpMs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpMs.setText("0");
        jPanel2.add(lblExpMs);
        lblExpMs.setBounds(210, 100, 40, 15);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Velocidade de Deslocamento:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(40, 80, 170, 14);

        lblVelocidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVelocidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidade.setText("0");
        jPanel2.add(lblVelocidade);
        lblVelocidade.setBounds(210, 80, 40, 15);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("km/h");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(250, 80, 30, 14);

        lblExpMi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExpMi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpMi.setText("0");
        jPanel2.add(lblExpMi);
        lblExpMi.setBounds(210, 120, 40, 15);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("m");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(250, 120, 30, 14);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("cm");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(250, 160, 40, 14);

        lblAla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAla.setText("0");
        jPanel2.add(lblAla);
        lblAla.setBounds(210, 160, 40, 15);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Volúme Máximo de Oxigênio:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(40, 210, 170, 14);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Melhoria Funcional:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 454, 100, 28);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("RLM de Abdomem:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(40, 250, 170, 14);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("RLM de Braços:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(40, 270, 170, 14);

        lblAla1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAla1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAla1.setText("0");
        jPanel2.add(lblAla1);
        lblAla1.setBounds(210, 270, 40, 15);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("repetições");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(250, 270, 60, 14);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("repetições");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(250, 250, 50, 14);

        lblExpMi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExpMi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpMi1.setText("0");
        jPanel2.add(lblExpMi1);
        lblExpMi1.setBounds(210, 250, 40, 15);

        lblExpMs1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExpMs1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpMs1.setText("0");
        jPanel2.add(lblExpMs1);
        lblExpMs1.setBounds(210, 230, 40, 15);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("l/min");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(250, 230, 30, 14);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("ml (kg.min)¹");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(250, 210, 60, 14);

        lblVelocidade1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVelocidade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidade1.setText("0");
        jPanel2.add(lblVelocidade1);
        lblVelocidade1.setBounds(210, 210, 40, 15);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Capacidade Anaeróbica Alática:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(40, 140, 170, 14);

        lblAla2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAla2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAla2.setText("0");
        jPanel2.add(lblAla2);
        lblAla2.setBounds(210, 140, 40, 15);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("panaal");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(250, 140, 40, 14);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("RLM de Pernas:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(40, 290, 170, 14);

        lblAla3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAla3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAla3.setText("0");
        jPanel2.add(lblAla3);
        lblAla3.setBounds(210, 290, 40, 15);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("repetições");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(250, 290, 60, 14);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Débito Cardíaco:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(40, 230, 170, 14);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Data de Início:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(30, 350, 100, 28);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Duração:");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(30, 421, 100, 28);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Objetivo:");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(30, 385, 100, 28);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(140, 350, 160, 28);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Quadrimestral", "Semestral" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(140, 420, 160, 28);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Hipertrofia", "Emagrecimento" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(140, 385, 160, 28);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%" }));
        jPanel2.add(jComboBox3);
        jComboBox3.setBounds(140, 454, 110, 28);

        jButton1.setText("OK");
        jPanel2.add(jButton1);
        jButton1.setBounds(253, 454, 47, 28);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/fundoMacro640x335.png"))); // NOI18N
        jPanel2.add(jLabel31);
        jLabel31.setBounds(-1, -1, 335, 640);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1032, 643));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAla;
    private javax.swing.JLabel lblAla1;
    private javax.swing.JLabel lblAla2;
    private javax.swing.JLabel lblAla3;
    private javax.swing.JLabel lblExpMi;
    private javax.swing.JLabel lblExpMi1;
    private javax.swing.JLabel lblExpMs;
    private javax.swing.JLabel lblExpMs1;
    private javax.swing.JLabel lblVelocidade;
    private javax.swing.JLabel lblVelocidade1;
    // End of variables declaration//GEN-END:variables
}
