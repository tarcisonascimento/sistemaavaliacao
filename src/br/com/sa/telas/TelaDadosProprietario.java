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

        setBackground(new java.awt.Color(255, 247, 241));
        setClosable(true);
        setTitle("Dados do Proprietário");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 0));
        jLabel1.setText("Nome Fantasia");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(19, 72, 88, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 0));
        jLabel2.setText("Razão Social");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 106, 76, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setText("CPF/CNPJ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(47, 173, 59, 15);

        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FlySys - Sistema de Treinamento Físico Inteligente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(236, 46, 277, 14);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(110, 210, 470, 10);

        txtNomeFantasia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNomeFantasia.setEnabled(false);
        getContentPane().add(txtNomeFantasia);
        txtNomeFantasia.setBounds(117, 66, 468, 28);

        txtRazaoSocial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRazaoSocial.setEnabled(false);
        getContentPane().add(txtRazaoSocial);
        txtRazaoSocial.setBounds(117, 100, 468, 28);

        txtCpfCnpj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCpfCnpj.setEnabled(false);
        getContentPane().add(txtCpfCnpj);
        txtCpfCnpj.setBounds(117, 166, 239, 28);

        txtSlogan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSlogan.setEnabled(false);
        getContentPane().add(txtSlogan);
        txtSlogan.setBounds(117, 133, 468, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 102, 0));
        jLabel8.setText("Slogan");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(64, 140, 42, 15);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(105, 4, 13));
        jLabel9.setText("Dados do Prorietário");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(253, 11, 238, 29);

        txtCidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCidade.setEnabled(false);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(117, 263, 468, 28);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 102, 0));
        jLabel10.setText("Telefone Fixo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(27, 304, 80, 15);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 102, 0));
        jLabel11.setText("Endereço");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(48, 235, 56, 15);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 102, 0));
        jLabel12.setText("Cidade");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(63, 269, 41, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 102, 0));
        jLabel13.setText("CEP");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(390, 310, 23, 15);

        txtEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEndereco.setEnabled(false);
        getContentPane().add(txtEndereco);
        txtEndereco.setBounds(117, 229, 468, 28);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 102, 0));
        jLabel14.setText("UF");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(310, 310, 14, 15);

        cmbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cmbUF.setEnabled(false);
        getContentPane().add(cmbUF);
        cmbUF.setBounds(340, 300, 40, 28);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 102, 0));
        jLabel15.setText("Celular");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(66, 340, 41, 15);

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmail.setEnabled(false);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(117, 369, 340, 28);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 102, 0));
        jLabel16.setText("E-mail");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(70, 374, 36, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 102, 0));
        jLabel5.setText("I.E");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(374, 173, 16, 15);

        txtInscricaoEstadual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtInscricaoEstadual.setEnabled(false);
        getContentPane().add(txtInscricaoEstadual);
        txtInscricaoEstadual.setBounds(394, 166, 191, 28);

        jPanel1.setBackground(new java.awt.Color(255, 247, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Logomarca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(105, 4, 13))); // NOI18N

        lblFotoLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblFotoLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/add-image.png"))); // NOI18N
        lblFotoLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblFotoLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFotoLogoMousePressed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(153, 102, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Tamanho recomendado 180x180px");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFotoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFotoLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(603, 20, 210, 233);

        jTextArea1.setBackground(new java.awt.Color(255, 247, 241));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 102, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("As informações contidas aqui, são de inteira responsabilidade do proprietario do estabelecimento, verifique com atenção de que todas as informações contidas aqui estão corretas antes de solicitar sua chave de liberação de uso do software.\n\nEstas informações serão usadas para a validação e registro do seu sistema.");
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0)), "Atenção!"));
        jTextArea1.setDisabledTextColor(new java.awt.Color(153, 51, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(111, 408, 675, 108);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setEnabled(false);
        txtTelefone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(117, 297, 185, 28);

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setEnabled(false);
        txtCelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtCelular);
        txtCelular.setBounds(117, 335, 193, 28);

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setEnabled(false);
        txtCep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtCep);
        txtCep.setBounds(430, 300, 157, 28);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnSalvar.setText("Salvar Informações");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(640, 310, 157, 39);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anamnese30x40.png"))); // NOI18N
        btnEditar.setText("Editar Informações");
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(640, 260, 157, 39);

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
