package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;

public class TelaAvaAna extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    private String ana01, anaparq01, anaparq02, anaparq03, anaparq04, anaparq05, anaparq06, anaparq07, anaparq08, anaparq09;

    //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAvaAna telaAvaAna;

    public static TelaAvaAna getInstancia() {
        if (telaAvaAna == null) {

            telaAvaAna = new TelaAvaAna();

        }
        return telaAvaAna;
    }

    public void incluiranamnese() {

        String sql = "update avaliacao1 set ana01=?,ana02=?,ana03=?,ana04=?,ana05=?,ana06=?,anatx01=?,ana07=?,anatx02=?,ana08=?,anatx03=?,ana09=?,anatx04=?,ana10=?,anatx05=?,ana11=?,anatx06=?,ana12=?,anaparq01=?,anaparq02=?,anaparq03=?,anaparq04=?,anaparq05=?,anaparq06=?,anaparq07=?,anaparq08=?,anaparq09=? where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ana01);
            pst.setString(2, txtAnatx01.getText());
            pst.setBoolean(3, chkAna03.isSelected());//ana03
            pst.setBoolean(4, chkAna04.isSelected());//ana04
            pst.setBoolean(5, chkAna05.isSelected());//ana05
            pst.setBoolean(6, chkAna06.isSelected());//ana06
            pst.setString(7, txtAnatx02.getText());//txana06
            pst.setBoolean(8, chkAna07.isSelected());//ana07
            pst.setString(9, txtAnatx03.getText());//txana07
            pst.setBoolean(10, chkAna08.isSelected());//ana08
            pst.setString(11, txtAnatx04.getText());//txana08
            pst.setBoolean(12, chkAna09.isSelected());//ana09
            pst.setString(13, txtAnatx05.getText());//txana09
            pst.setBoolean(14, chkAna10.isSelected());//ana10
            pst.setString(15, txtAnatx06.getText());//txana09
            pst.setBoolean(16, chkAna11.isSelected());//ana11
            pst.setString(17, txtAnatx07.getText());//txana11
            pst.setBoolean(18, chkAna12.isSelected());//ana12
            pst.setString(19, anaparq01);//
            pst.setString(20, anaparq02);//
            pst.setString(21, anaparq03);//
            pst.setString(22, anaparq04);//
            pst.setString(23, anaparq05);//
            pst.setString(24, anaparq06);//
            pst.setString(25, anaparq07);//
            pst.setString(26, anaparq08);//
            pst.setString(27, anaparq09);//
            pst.setString(28, TelaModuloAva.lblIdAva.getText());//

            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Questionário finalizado com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    //o metodo abaixo valida os radiobutons
    public void validaradiobutons() {

        if (rb1.isSelected()) {
            ana01 = "Sim";
        } else {
        }
        if (rb2.isSelected()) {
            ana01 = "Não";
        } else {
        }
        if (rb3.isSelected()) {
            anaparq01 = "Sim";
        } else {
        }
        if (rb4.isSelected()) {
            anaparq01 = "Não";
        } else {
        }
        if (rb5.isSelected()) {
            anaparq02 = "Sim";
        } else {
        }
        if (rb6.isSelected()) {
            anaparq02 = "Não";
        } else {
        }
        if (rb7.isSelected()) {
            anaparq03 = "Sim";
        } else {
        }
        if (rb8.isSelected()) {
            anaparq03 = "Não";
        } else {
        }
        if (rb9.isSelected()) {
            anaparq04 = "Sim";
        } else {
        }
        if (rb10.isSelected()) {
            anaparq04 = "Não";
        } else {
        }
        if (rb11.isSelected()) {
            anaparq05 = "Sim";
        } else {
        }
        if (rb12.isSelected()) {
            anaparq05 = "Não";
        } else {
        }
        if (rb13.isSelected()) {
            anaparq06 = "Sim";
        } else {
        }
        if (rb14.isSelected()) {
            anaparq06 = "Não";
        } else {
        }
        if (rb15.isSelected()) {
            anaparq07 = "Sim";
        } else {
        }
        if (rb16.isSelected()) {
            anaparq07 = "Não";
        } else {
        }
        if (rb17.isSelected()) {
            anaparq08 = "Sim";
        } else {
        }
        if (rb18.isSelected()) {
            anaparq08 = "Não";
        } else {
        }
        if (rb19.isSelected()) {
            anaparq09 = "Sim";
        } else {
        }
        if (rb20.isSelected()) {
            anaparq09 = "Não";
        } else {
        }

    }

    public TelaAvaAna() {
        initComponents();
        conexao = ModuloConexao.conector();//devese iniciar a conexao sempre pelo construtor antes de realizar uma consulta
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtAnatx01 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        chkAna03 = new javax.swing.JCheckBox();
        chkAna04 = new javax.swing.JCheckBox();
        chkAna05 = new javax.swing.JCheckBox();
        chkAna06 = new javax.swing.JCheckBox();
        chkAna07 = new javax.swing.JCheckBox();
        txtAnatx02 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAnatx03 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chkAna08 = new javax.swing.JCheckBox();
        txtAnatx04 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkAna09 = new javax.swing.JCheckBox();
        txtAnatx05 = new javax.swing.JTextField();
        txtAnatx06 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chkAna11 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        chkAna12 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txtAnatx07 = new javax.swing.JTextField();
        chkAna10 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        rb8 = new javax.swing.JRadioButton();
        rb7 = new javax.swing.JRadioButton();
        rb10 = new javax.swing.JRadioButton();
        rb9 = new javax.swing.JRadioButton();
        rb11 = new javax.swing.JRadioButton();
        rb12 = new javax.swing.JRadioButton();
        rb13 = new javax.swing.JRadioButton();
        rb14 = new javax.swing.JRadioButton();
        rb16 = new javax.swing.JRadioButton();
        rb15 = new javax.swing.JRadioButton();
        rb18 = new javax.swing.JRadioButton();
        rb17 = new javax.swing.JRadioButton();
        rb19 = new javax.swing.JRadioButton();
        rb20 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAnaSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 247, 241));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Anamnese");
        setMaximumSize(new java.awt.Dimension(762, 530));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 247, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Pratica atividade física regularmente?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        rb1.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup1.add(rb1);
        rb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb1.setText("Sim");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        rb2.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb2.setText("Não");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Quantas vezes por semana?");

        txtAnatx01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAnatx01.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(rb1)
                .addGap(12, 12, 12)
                .addComponent(rb2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(txtAnatx01, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnatx01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 247, 241));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Anamnese Clínica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        chkAna03.setBackground(new java.awt.Color(255, 247, 241));
        chkAna03.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna03.setText("Alguma doença na família nos ultimos 5 anos?");
        chkAna03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAna03ActionPerformed(evt);
            }
        });

        chkAna04.setBackground(new java.awt.Color(255, 247, 241));
        chkAna04.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna04.setText("Alguma doença sua nos ultimos 5 anos?");

        chkAna05.setBackground(new java.awt.Color(255, 247, 241));
        chkAna05.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna05.setText("Possui alguma restrição a prática de atividade física?");

        chkAna06.setBackground(new java.awt.Color(255, 247, 241));
        chkAna06.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna06.setText("Foi submetido a cirurgia nos últimos 3 anos?");

        chkAna07.setBackground(new java.awt.Color(255, 247, 241));
        chkAna07.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna07.setText("Possui algum tipo de alergia?");

        txtAnatx02.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Qual?");

        txtAnatx03.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Qual?");

        chkAna08.setBackground(new java.awt.Color(255, 247, 241));
        chkAna08.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna08.setText("Tem alguma lesão múscular ou óssea?");

        txtAnatx04.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Qual?");

        chkAna09.setBackground(new java.awt.Color(255, 247, 241));
        chkAna09.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna09.setText("Usa algum medicamento?");

        txtAnatx05.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtAnatx06.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Onde?");

        chkAna11.setBackground(new java.awt.Color(255, 247, 241));
        chkAna11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna11.setText("Fuma?");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Quantas vezes por dia?");

        chkAna12.setBackground(new java.awt.Color(255, 247, 241));
        chkAna12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna12.setText("Esta fazendo alguma dieta para perder ou ganhar peso?");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Qual?");

        txtAnatx07.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAnatx07.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chkAna10.setBackground(new java.awt.Color(255, 247, 241));
        chkAna10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAna10.setText("Sente dores no corpo?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnatx04)
                    .addComponent(txtAnatx05)
                    .addComponent(txtAnatx06)
                    .addComponent(txtAnatx03)
                    .addComponent(txtAnatx02))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAnatx07, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(chkAna09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(chkAna03, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chkAna04, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chkAna05, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chkAna06, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnatx02, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(chkAna07, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnatx03, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(chkAna08, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnatx04, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(chkAna09, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnatx05, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkAna10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnatx06, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnatx07, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAna11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAna12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 247, 241));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "ParQ - Para Liberação de Atividade Física", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("1 - Já foi mensionado que você possui algum problema cardíaco?");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("2 - Sente dor ou desconforto no peito durante atividade física?");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("3 - Sem atividade fisica tem sentido desconfortos no peito?");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("4 - Você perde o equilíbrio em função de tonturas?");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("5 - Você ja ficou inconsiente? Ou sofre com desmaios?");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("6 - Possui algum problema, osseo, articular ou de coluna?");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("7 - Toma ou ja tomou alguma medicação para pressão arterial?");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("9 - Tem alguma razão conhecida que te impeça de fazer exercícios?");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("8 - Toma ou ja tomou alguma medicação para problema cardíaco?");

        rb3.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup2.add(rb3);
        rb3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb3.setText("Sim");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        rb4.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup2.add(rb4);
        rb4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb4.setText("Não");
        rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4ActionPerformed(evt);
            }
        });

        rb6.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup3.add(rb6);
        rb6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb6.setText("Não");
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });

        rb5.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup3.add(rb5);
        rb5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb5.setText("Sim");
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });

        rb8.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup4.add(rb8);
        rb8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb8.setText("Não");
        rb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb8ActionPerformed(evt);
            }
        });

        rb7.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup4.add(rb7);
        rb7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb7.setText("Sim");
        rb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb7ActionPerformed(evt);
            }
        });

        rb10.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup5.add(rb10);
        rb10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb10.setText("Não");
        rb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb10ActionPerformed(evt);
            }
        });

        rb9.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup5.add(rb9);
        rb9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb9.setText("Sim");
        rb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb9ActionPerformed(evt);
            }
        });

        rb11.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup6.add(rb11);
        rb11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb11.setText("Sim");
        rb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb11ActionPerformed(evt);
            }
        });

        rb12.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup6.add(rb12);
        rb12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb12.setText("Não");
        rb12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb12ActionPerformed(evt);
            }
        });

        rb13.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup7.add(rb13);
        rb13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb13.setText("Sim");
        rb13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb13ActionPerformed(evt);
            }
        });

        rb14.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup7.add(rb14);
        rb14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb14.setText("Não");
        rb14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb14ActionPerformed(evt);
            }
        });

        rb16.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup8.add(rb16);
        rb16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb16.setText("Não");
        rb16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb16ActionPerformed(evt);
            }
        });

        rb15.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup8.add(rb15);
        rb15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb15.setText("Sim");
        rb15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb15ActionPerformed(evt);
            }
        });

        rb18.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup9.add(rb18);
        rb18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb18.setText("Não");
        rb18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb18ActionPerformed(evt);
            }
        });

        rb17.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup9.add(rb17);
        rb17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb17.setText("Sim");
        rb17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb17ActionPerformed(evt);
            }
        });

        rb19.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup10.add(rb19);
        rb19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb19.setText("Sim");
        rb19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb19ActionPerformed(evt);
            }
        });

        rb20.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup10.add(rb20);
        rb20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb20.setText("Não");
        rb20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb20ActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(255, 247, 241));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setText("Obs. Em caso de resposta positiva em alguma questão é recomendável o encaminhamento do aluno para avaliação médica especializada.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel17))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb19, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb20, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 160, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb3)
                    .addComponent(rb4))
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb5)
                    .addComponent(rb6))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb8)
                            .addComponent(rb7))))
                .addGap(9, 9, 9)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb9)
                    .addComponent(rb10))
                .addGap(9, 9, 9)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb11)
                    .addComponent(rb12))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb13)
                            .addComponent(rb14))))
                .addGap(9, 9, 9)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb15)
                    .addComponent(rb16))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb17)
                            .addComponent(rb18))))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb20)
                            .addComponent(rb19))))
                .addGap(18, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAnaSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnAnaSalvar.setText("Salvar e Avançar");
        btnAnaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaSalvarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnaSalvar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(btnAnaSalvar))))
                .addContainerGap())
        );

        setBounds(0, 0, 1071, 672);
    }// </editor-fold>//GEN-END:initComponents

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb5ActionPerformed

    private void rb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb7ActionPerformed

    private void rb9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb9ActionPerformed

    private void rb11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb11ActionPerformed

    private void rb13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb13ActionPerformed

    private void rb15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb15ActionPerformed

    private void rb17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb17ActionPerformed

    private void rb19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb19ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb4ActionPerformed

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb6ActionPerformed

    private void rb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb8ActionPerformed

    private void rb10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb10ActionPerformed

    private void rb12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb12ActionPerformed

    private void rb14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb14ActionPerformed

    private void rb16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb16ActionPerformed

    private void rb18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb18ActionPerformed

    private void rb20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb20ActionPerformed

    private void btnAnaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaSalvarActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Concluiu todo o questionário?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {

            validaradiobutons();
            incluiranamnese();
            telaAvaAna = null;
            TelaAvaAna.this.dispose();//metodo para fechar uma unica janela

        } else {

        }
    }//GEN-LAST:event_btnAnaSalvarActionPerformed

    private void chkAna03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAna03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAna03ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaAna = null;
            TelaAvaAna.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
     int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaAna = null;
            TelaAvaAna.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    public static javax.swing.JCheckBox chkAna03;
    public static javax.swing.JCheckBox chkAna04;
    public static javax.swing.JCheckBox chkAna05;
    public static javax.swing.JCheckBox chkAna06;
    public static javax.swing.JCheckBox chkAna07;
    public static javax.swing.JCheckBox chkAna08;
    public static javax.swing.JCheckBox chkAna09;
    public static javax.swing.JCheckBox chkAna10;
    public static javax.swing.JCheckBox chkAna11;
    public static javax.swing.JCheckBox chkAna12;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JRadioButton rb1;
    public static javax.swing.JRadioButton rb10;
    public static javax.swing.JRadioButton rb11;
    public static javax.swing.JRadioButton rb12;
    public static javax.swing.JRadioButton rb13;
    public static javax.swing.JRadioButton rb14;
    public static javax.swing.JRadioButton rb15;
    public static javax.swing.JRadioButton rb16;
    public static javax.swing.JRadioButton rb17;
    public static javax.swing.JRadioButton rb18;
    public static javax.swing.JRadioButton rb19;
    public static javax.swing.JRadioButton rb2;
    public static javax.swing.JRadioButton rb20;
    public static javax.swing.JRadioButton rb3;
    public static javax.swing.JRadioButton rb4;
    public static javax.swing.JRadioButton rb5;
    public static javax.swing.JRadioButton rb6;
    public static javax.swing.JRadioButton rb7;
    public static javax.swing.JRadioButton rb8;
    public static javax.swing.JRadioButton rb9;
    public static javax.swing.JTextField txtAnatx01;
    public static javax.swing.JTextField txtAnatx02;
    public static javax.swing.JTextField txtAnatx03;
    public static javax.swing.JTextField txtAnatx04;
    public static javax.swing.JTextField txtAnatx05;
    public static javax.swing.JTextField txtAnatx06;
    public static javax.swing.JTextField txtAnatx07;
    // End of variables declaration//GEN-END:variables
}
