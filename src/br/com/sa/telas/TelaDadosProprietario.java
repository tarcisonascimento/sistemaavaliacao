package br.com.sa.telas;

import br.com.sa.classes.ManipularImagem;
import br.com.sa.dal.ModuloConexao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaDadosProprietario extends javax.swing.JInternalFrame {
    
    BufferedImage bflogo;
    public static byte[] logobytes;
    
    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java
    
    
    public void desativacampos () {
    
    txtCelular.setEnabled(false);
    txtCep.setEnabled(false);
    txtCidade.setEnabled(false);
    txtCpfCnpj.setEnabled(false);
    txtEmail.setEnabled(false);
    txtEndereco.setEnabled(false);
    txtInscricaoEstadual.setEnabled(false);
    txtNomeFantasia.setEnabled(false);
    txtRazaoSocial.setEnabled(false);
    txtSlogan.setEnabled(false);
    txtTelefone.setEnabled(false);
    cmbUF.setEnabled(false);
    btnSalvar.setEnabled(false);
    btnEditar.setEnabled(true);
    
    }
    public void ativacampos(){
    txtCelular.setEnabled(true);
    txtCep.setEnabled(true);
    txtCidade.setEnabled(true);
    txtCpfCnpj.setEnabled(true);
    txtEmail.setEnabled(true);
    txtEndereco.setEnabled(true);
    txtInscricaoEstadual.setEnabled(true);
    txtNomeFantasia.setEnabled(true);
    txtRazaoSocial.setEnabled(true);
    txtSlogan.setEnabled(true);
    txtTelefone.setEnabled(true);
    cmbUF.setEnabled(true);
    btnSalvar.setEnabled(true);
    btnEditar.setEnabled(false);
    
    }
    
    public void incluirdados (){
        
        String sql = "update empresa set empnomefantasia=?,emprazaosocial=?,empslogan=?,empcnpjcpf=?,empinscricao=?,empendereco=?,empcidade=?,empestado=?,empcep=?,emptelefone=?,empcelular=?,empemail=?,emplogo=? where idempresa=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeFantasia.getText());
            pst.setString(2, txtRazaoSocial.getText());
            pst.setString(3, txtSlogan.getText());
            pst.setString(4, txtCpfCnpj.getText());
            pst.setString(5, txtInscricaoEstadual.getText());
            pst.setString(6, txtEndereco.getText());
            pst.setString(7, txtCidade.getText());
            pst.setString(8, cmbUF.getSelectedItem().toString());
            pst.setString(9, txtCep.getText());
            pst.setString(10, txtTelefone.getText());
            pst.setString(11, txtCelular.getText());
            pst.setString(12, txtEmail.getText());
            pst.setBytes(13, logobytes);
            pst.setString(14, "1");
            
            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Informações Alteradas com Sucesso!");
            }
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do proprietário!" + e);
        }
        

    }
    


    public TelaDadosProprietario() {
        initComponents();
        conexao = ModuloConexao.conector(); //aqui to chamando o metodo dentro do modulo de conexao. instanciando a classe
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNomeFantasia = new javax.swing.JTextField();
        txtRazaoSocial = new javax.swing.JTextField();
        txtCpfCnpj = new javax.swing.JTextField();
        txtSlogan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmbUF = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtInscricaoEstadual = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblFotoLogo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Dados do Proprietário");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Nome Fantasia");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Razão Social");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("CPF/CNPJ");

        jLabel4.setText("FlySys - Sistema de Treinamento Físico Inteligente");

        txtNomeFantasia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNomeFantasia.setEnabled(false);

        txtRazaoSocial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRazaoSocial.setEnabled(false);

        txtCpfCnpj.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCpfCnpj.setEnabled(false);

        txtSlogan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSlogan.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Slogan");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setText("Dados do Prorietário");

        txtCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCidade.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Telefone Fixo");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Endereço");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Cidade");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("CEP");

        txtEndereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEndereco.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("UF");

        cmbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cmbUF.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Celular");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("E-mail");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Inscrição Estadual");

        txtInscricaoEstadual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtInscricaoEstadual.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Logomarca"));

        lblFotoLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblFotoLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/add-image.png"))); // NOI18N
        lblFotoLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblFotoLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFotoLogoMousePressed(evt);
            }
        });

        jLabel17.setText("Tamanho recomendado 180x180px");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFotoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFotoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("As informações contidas aqui, são de inteira responsabilidade do proprietario do estabelecimento, verifique com atenção de que todas as informações contidas aqui estão corretas antes de solicitar sua chave de liberação de uso do software.\n\nEstas informações serão usadas para a validação e registro do seu sistema.");
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Atenção!"));
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setEnabled(false);
        txtTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setEnabled(false);
        txtCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setEnabled(false);
        txtCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnSalvar.setText("Salvar Informações");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anamnese30x40.png"))); // NOI18N
        btnEditar.setText("Editar Informações");
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(txtSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel9)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14)
                                        .addGap(9, 9, 9)
                                        .addComponent(cmbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnEditar)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setBounds(0, 0, 841, 572);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (logobytes == null){
        JOptionPane.showMessageDialog(null, "Você deve inserir uma logo");
        }else{
        incluirdados();
        desativacampos();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void lblFotoLogoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoLogoMousePressed
        JFileChooser logo = new JFileChooser(); //intanciando o metodo para colocar a foto
        logo.setDialogTitle("Selecione a Foto de Frente"); //tirulo da caixa de dialogo
        logo.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "JPEG", "JPG", "PNG");
        logo.addChoosableFileFilter(filtro);
        logo.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = logo.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            File fotoselecionada = logo.getSelectedFile();//jogando pra dentro da variavel o arquiv
            String caminho = fotoselecionada.getAbsolutePath();//jogando para dentro da string o caminho
            bflogo = ManipularImagem.setImagemDimensao(caminho, lblFotoLogo.getWidth(), lblFotoLogo.getHeight());
            logobytes = ManipularImagem.getImgBytes(bflogo);

            ImageIcon ft = new ImageIcon(logo.getSelectedFile().getPath());
            lblFotoLogo.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFotoLogo.getWidth(), lblFotoLogo.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto
            btnSalvar.setEnabled(true);

        } else {

        }
    }//GEN-LAST:event_lblFotoLogoMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ativacampos();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnSalvar;
    public static javax.swing.JComboBox<String> cmbUF;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JLabel lblFotoLogo;
    public static javax.swing.JFormattedTextField txtCelular;
    public static javax.swing.JFormattedTextField txtCep;
    public static javax.swing.JTextField txtCidade;
    public static javax.swing.JTextField txtCpfCnpj;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtEndereco;
    public static javax.swing.JTextField txtInscricaoEstadual;
    public static javax.swing.JTextField txtNomeFantasia;
    public static javax.swing.JTextField txtRazaoSocial;
    public static javax.swing.JTextField txtSlogan;
    public static javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
