package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import br.com.sa.busca.Busca;
import br.com.sa.busca.BuscaTableModel;

public class TelaUsuarios extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java
    BuscaTableModel tableModel = new BuscaTableModel();
    
    
    //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaUsuarios telaUsuarios;
   
    
    public static TelaUsuarios getInstancia(){
        if (telaUsuarios == null){
            
            telaUsuarios = new TelaUsuarios();
        }
        return telaUsuarios;
    }
    

    public TelaUsuarios() {
        initComponents();
        conexao = ModuloConexao.conector();
        tblUsoBusca.setModel(tableModel);//setando a tabela para dizer quais parametros ela vai receber
        getRootPane().setDefaultButton(btnUsoBusca);

    }

    public void consultar() {

        String sql = "select * from usuarios where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsoBusca.getText() + "%");
            rs = pst.executeQuery();

            while (rs.next()) { //enquanto o RS result set for inteiro existe um laço de repetiçao.

                Busca b = new Busca();
                b.setNome(rs.getString(2));
                b.setTelefone(rs.getString(5));
                b.setId(rs.getInt(1));
                tableModel.addRow(b);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    //metodo para adicionar usuarios
    private void adicionar() {
        //instrução sql para inserção de dados na tabela mysql
        String sql = "insert into usuarios (nome,endereco,cidade,celular,cref,datacontrato,usuario,senha,perfil,cpf) values (?,?,?,?,?,?,?,?,?,?)";

        try {

            pst = conexao.prepareStatement(sql); //preparando a conexão
            pst.setString(1, txtUsoNome.getText());
            pst.setString(2, txtUsoEndereco.getText());
            pst.setString(3, txtUsoCidade.getText());
            pst.setString(4, txtUsoCelular.getText());
            pst.setString(5, txtUsoCref.getText());
            pst.setString(6, txtUsoContrato.getText());
            pst.setString(7, txtUsoLogin.getText());
            pst.setString(8, txtUsoSenha.getText());
            pst.setString(9, cmbUsoPerfil.getSelectedItem().toString());
            pst.setString(10, txtUsoCpf.getText());

            //a estrutura abaixo valida os campos obrigatórios
  
            //a linha abaixo atualiza a tabela usuarios com as informaçoes novas do formulario
            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
            }
            
        
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }
          
    }
    
    //Abaixo é o metodo para alterar os dados do usuário
    
    private void alterar(){
    
        String sql = "update usuarios set nome=?,endereco=?,cidade=?,celular=?,cref=?,datacontrato=?,usuario=?,senha=?,perfil=?,cpf=? where iduso=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsoNome.getText());
            pst.setString(2, txtUsoEndereco.getText());
            pst.setString(3, txtUsoCidade.getText());
            pst.setString(4, txtUsoCelular.getText());
            pst.setString(5, txtUsoCref.getText());
            pst.setString(6, txtUsoContrato.getText());
            pst.setString(7, txtUsoLogin.getText());
            pst.setString(8, txtUsoSenha.getText());
            pst.setString(9, cmbUsoPerfil.getSelectedItem().toString());
            pst.setString(10, txtUsoCpf.getText());
            pst.setString(11, txtUsoMatricula.getText());
            
            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }
        
    }

    //Metodo responsavel por excluir cadastros de usuarios
    private void remover(){
    
    String sql="delete from usuarios where iduso=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtUsoMatricula.getText());
            int removido = pst.executeUpdate();//caso a adição for concluida cai no if
            if (removido > 0) {
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }
   
    //o metodo abaixo serve para limpar todos os campos
    private void limpacampos() {

        txtUsoCelular.setText(null);
        txtUsoCidade.setText(null);
        txtUsoContrato.setText(null);
        txtUsoCpf.setText(null);
        txtUsoCref.setText(null);
        txtUsoEndereco.setText(null);
        txtUsoLogin.setText(null);
        txtUsoNome.setText(null);
        txtUsoSenha.setText(null);
        cmbUsoPerfil.setSelectedItem(null);
        txtUsoBusca.setText(null);
        tblUsoBusca.removeAll();
        txtUsoMatricula.setText(null);

    }

    //o metodo abaixo desativa os campos e ativa os botoes de controle
    public void desativacampos() {

        txtUsoCelular.setEnabled(false);
        txtUsoCidade.setEnabled(false);
        txtUsoContrato.setEnabled(false);
        txtUsoCpf.setEnabled(false);
        txtUsoCref.setEnabled(false);
        txtUsoEndereco.setEnabled(false);
        txtUsoLogin.setEnabled(false);
        txtUsoNome.setEnabled(false);
        txtUsoSenha.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnUsoAdd.setEnabled(true);
        btnUsoDel.setEnabled(true);
        btnUsoEdit.setEnabled(true);
        btnUsoCancelar.setEnabled(false);
        cmbUsoPerfil.setEnabled(false);
        tblUsoBusca.setEnabled(true);
        btnUsoBusca.setEnabled(true);
        txtUsoBusca.setEnabled(true);
    }

    //o metodo abaixo ativa os campos e desativa os botoes
    public void ativacampos() {

        txtUsoCelular.setEnabled(true);
        txtUsoCidade.setEnabled(true);
        txtUsoContrato.setEnabled(true);
        txtUsoCpf.setEnabled(true);
        txtUsoCref.setEnabled(true);
        txtUsoEndereco.setEnabled(true);
        txtUsoLogin.setEnabled(true);
        txtUsoNome.setEnabled(true);
        txtUsoSenha.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnUsoAdd.setEnabled(false);
        btnUsoDel.setEnabled(false);
        tblUsoBusca.setEnabled(false);
        tblUsoBusca.clearSelection();
        btnUsoBusca.setEnabled(false);
        txtUsoBusca.setEnabled(false);
        btnUsoEdit.setEnabled(false);
        btnUsoCancelar.setEnabled(true);
        cmbUsoPerfil.setEnabled(true);

    }

    //metodo para setar os campos do usuario com o conteudo da tabela
    public void setarCampos() {
        String sql = "select * from usuarios where iduso=?";
        int linha = tblUsoBusca.getSelectedRow();
        String tarc = tblUsoBusca.getValueAt(linha, 2).toString();//linha é alinha selecionada e 0 é a coluna
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tarc);
            rs = pst.executeQuery();

            if (rs.next()) {

                txtUsoNome.setText(rs.getString(2));
                txtUsoEndereco.setText(rs.getString(3));
                txtUsoCidade.setText(rs.getString(4));
                txtUsoCelular.setText(rs.getString(5));
                txtUsoCref.setText(rs.getString(6));
                txtUsoContrato.setText(rs.getString(7));
                txtUsoLogin.setText(rs.getString(8));
                txtUsoSenha.setText(rs.getString(9));
                cmbUsoPerfil.setSelectedItem(rs.getString(10));
                txtUsoCpf.setText(rs.getString(11));
                txtUsoMatricula.setText(rs.getString(1));

            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        txtUsoEndereco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnUsoCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtUsoCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsoCref = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUsoBusca = new javax.swing.JButton();
        txtUsoBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbUsoPerfil = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnUsoAdd = new javax.swing.JButton();
        txtUsoNome = new javax.swing.JTextField();
        btnUsoEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnUsoDel = new javax.swing.JButton();
        txtUsoContrato = new javax.swing.JFormattedTextField();
        txtUsoCelular = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUsoCpf = new javax.swing.JFormattedTextField();
        txtUsoSenha = new javax.swing.JPasswordField();
        txtUsoLogin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsoBusca = new javax.swing.JTable();
        txtUsoMatricula = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(600, 458));
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

        jDesktopPane1.setBackground(new java.awt.Color(255, 247, 241));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(612, 451));

        txtUsoEndereco.setEnabled(false);
        jDesktopPane1.add(txtUsoEndereco);
        txtUsoEndereco.setBounds(150, 195, 451, 32);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnSalvar);
        btnSalvar.setBounds(630, 490, 179, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setText("Endereço Completo");
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(10, 193, 136, 32);

        btnUsoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        btnUsoCancelar.setText("Cancelar");
        btnUsoCancelar.setEnabled(false);
        btnUsoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoCancelarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnUsoCancelar);
        btnUsoCancelar.setBounds(20, 490, 183, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 102, 0));
        jLabel5.setText("Cidade/UF");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(73, 233, 73, 32);

        txtUsoCidade.setEnabled(false);
        jDesktopPane1.add(txtUsoCidade);
        txtUsoCidade.setBounds(150, 235, 226, 32);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 102, 0));
        jLabel6.setText("* Celular");
        jDesktopPane1.add(jLabel6);
        jLabel6.setBounds(86, 313, 60, 32);

        txtUsoCref.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoCref.setEnabled(false);
        jDesktopPane1.add(txtUsoCref);
        txtUsoCref.setBounds(150, 355, 226, 32);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 102, 0));
        jLabel7.setText("CREF");
        jDesktopPane1.add(jLabel7);
        jLabel7.setBounds(109, 353, 37, 32);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 102, 0));
        jLabel8.setText("* Data Contrato");
        jDesktopPane1.add(jLabel8);
        jLabel8.setBounds(34, 398, 112, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setText("Matrícula");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(655, 11, 62, 32);

        btnUsoBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Search.png"))); // NOI18N
        btnUsoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoBuscaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnUsoBusca);
        btnUsoBusca.setBounds(475, 11, 70, 34);

        txtUsoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsoBuscaActionPerformed(evt);
            }
        });
        txtUsoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsoBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsoBuscaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsoBuscaKeyTyped(evt);
            }
        });
        jDesktopPane1.add(txtUsoBusca);
        txtUsoBusca.setBounds(129, 13, 340, 32);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 0));
        jLabel1.setText("Buscar Usuário");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(22, 11, 103, 32);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 102, 0));
        jLabel11.setText("* Senha");
        jDesktopPane1.add(jLabel11);
        jLabel11.setBounds(520, 360, 56, 32);

        cmbUsoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Coordenador", "Estagiário", "Professor", "Outro", " ", " " }));
        cmbUsoPerfil.setEnabled(false);
        jDesktopPane1.add(cmbUsoPerfil);
        cmbUsoPerfil.setBounds(580, 400, 226, 32);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 102, 0));
        jLabel13.setText("* Perfil de Acesso");
        jDesktopPane1.add(jLabel13);
        jLabel13.setBounds(450, 400, 120, 32);

        btnUsoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/adicionaricone30x30.png"))); // NOI18N
        btnUsoAdd.setText("Adicionar Usuário");
        btnUsoAdd.setToolTipText("Adicionar Usuário");
        btnUsoAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoAddActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnUsoAdd);
        btnUsoAdd.setBounds(620, 154, 179, 39);

        txtUsoNome.setEnabled(false);
        jDesktopPane1.add(txtUsoNome);
        txtUsoNome.setBounds(151, 155, 450, 32);

        btnUsoEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/edit30x30.png"))); // NOI18N
        btnUsoEdit.setText("Etitar Usuário");
        btnUsoEdit.setToolTipText("Editar Usuário");
        btnUsoEdit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoEditActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnUsoEdit);
        btnUsoEdit.setBounds(620, 200, 179, 39);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 0));
        jLabel2.setText("* Nome Completo");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(22, 153, 125, 32);

        btnUsoDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/excluir30x30.png"))); // NOI18N
        btnUsoDel.setText("Remover Usuário");
        btnUsoDel.setToolTipText("Excluir Usuário");
        btnUsoDel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsoDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoDelActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnUsoDel);
        btnUsoDel.setBounds(620, 246, 179, 39);

        try {
            txtUsoContrato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtUsoContrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoContrato.setEnabled(false);
        jDesktopPane1.add(txtUsoContrato);
        txtUsoContrato.setBounds(150, 400, 226, 32);

        try {
            txtUsoCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtUsoCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoCelular.setEnabled(false);
        jDesktopPane1.add(txtUsoCelular);
        txtUsoCelular.setBounds(150, 315, 226, 32);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 102, 0));
        jLabel9.setText("* C.P.F.");
        jDesktopPane1.add(jLabel9);
        jLabel9.setBounds(94, 273, 52, 32);

        try {
            txtUsoCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtUsoCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoCpf.setEnabled(false);
        jDesktopPane1.add(txtUsoCpf);
        txtUsoCpf.setBounds(150, 275, 226, 32);

        txtUsoSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoSenha.setEnabled(false);
        jDesktopPane1.add(txtUsoSenha);
        txtUsoSenha.setBounds(580, 360, 226, 32);

        txtUsoLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoLogin.setEnabled(false);
        jDesktopPane1.add(txtUsoLogin);
        txtUsoLogin.setBounds(580, 320, 226, 32);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 102, 0));
        jLabel10.setText("* Usuário");
        jDesktopPane1.add(jLabel10);
        jLabel10.setBounds(510, 320, 65, 32);

        tblUsoBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Telefone"
            }
        ));
        tblUsoBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsoBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsoBusca);
        if (tblUsoBusca.getColumnModel().getColumnCount() > 0) {
            tblUsoBusca.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(22, 51, 781, 91);

        txtUsoMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsoMatricula.setEnabled(false);
        txtUsoMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsoMatriculaActionPerformed(evt);
            }
        });
        txtUsoMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsoMatriculaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsoMatriculaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsoMatriculaKeyTyped(evt);
            }
        });
        jDesktopPane1.add(txtUsoMatricula);
        txtUsoMatricula.setBounds(721, 13, 82, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 842, 571);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoAddActionPerformed
        //ativando os campos para serem editados;

        ativacampos();//cgamando o metodo para ativar os campos e desativar botoes
        limpacampos();//chamando o metodo limpar campos
        btnSalvar.setText("Adicionar");


    }//GEN-LAST:event_btnUsoAddActionPerformed

    private void btnUsoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoCancelarActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Cancelar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (cancelar == JOptionPane.YES_OPTION) {

            limpacampos();//chamando o metodo limpa campos
            desativacampos();//desativando os campos e ativando os botoes

        }
    }//GEN-LAST:event_btnUsoCancelarActionPerformed

    private void btnUsoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoEditActionPerformed
        if ("".equals(txtUsoNome.getText())) {
            JOptionPane.showMessageDialog(null, "Selecione um Usuário!");
        } else {

            ativacampos();//chamando o metodo ativar campos
            btnSalvar.setText("Alterar");//mudando o nome do btn salvar
        }
    }//GEN-LAST:event_btnUsoEditActionPerformed

    private void btnUsoDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoDelActionPerformed
        if ("".equals(txtUsoNome.getText())) {
            JOptionPane.showMessageDialog(null, "Selecione um Usuário!");
        } else {

            ativacampos();//chamando o metodo para ativar os campos
            btnSalvar.setText("Excluir");//alterando o nome do botao salvar

        }
    }//GEN-LAST:event_btnUsoDelActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if ("Adicionar".equals(btnSalvar.getText())) {//se o texto do botao estiver Adicionar
           
            if ((txtUsoNome.getText().isEmpty()) || (txtUsoCelular.getText().isEmpty()) || (txtUsoCpf.getText().isEmpty()) || (txtUsoContrato.getText().isEmpty()) || (txtUsoLogin.getText().isEmpty()) || (txtUsoSenha.getText().isEmpty()) || (cmbUsoPerfil.getSelectedItem().equals(null))) {
            JOptionPane.showMessageDialog(null, "(*) Preencha todos os campos obrigatórios!");
            return;
            }

            int adicionar = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja adicionar?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (adicionar == JOptionPane.YES_OPTION) {

                adicionar();
                limpacampos();
                desativacampos();

            }
        }

        if ("Alterar".equals(btnSalvar.getText())) {// se o texto do botao estiver Alterar

            if ((txtUsoNome.getText().isEmpty()) || (txtUsoCelular.getText().isEmpty()) || (txtUsoCpf.getText().isEmpty()) || (txtUsoContrato.getText().isEmpty()) || (txtUsoLogin.getText().isEmpty()) || (txtUsoSenha.getText().isEmpty()) || (cmbUsoPerfil.getSelectedItem().equals(null))) {
            JOptionPane.showMessageDialog(null, "(*) Preencha todos os campos obrigatórios!");
            return;
            }
            
            int altera = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Alterar?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (altera == JOptionPane.YES_OPTION) {
                
                alterar();
                limpacampos();
                desativacampos();

            }
        }
        if ("Excluir".equals(btnSalvar.getText())) {

            int excluir = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (excluir == JOptionPane.YES_OPTION) {
            int excluir2 = JOptionPane.showConfirmDialog(null, "Esta Operação não pode ser desfeita Continuar?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (excluir2 == JOptionPane.YES_OPTION) {
                
                remover();
                limpacampos();
                desativacampos();
               
                

            }

            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnUsoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoBuscaActionPerformed
        tableModel.removeAll();//limpando a tabela antes de uma nova busca.    
        consultar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsoBuscaActionPerformed

    private void txtUsoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsoBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoBuscaActionPerformed

    private void txtUsoBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoBuscaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoBuscaKeyReleased

    private void txtUsoBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoBuscaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoBuscaKeyTyped

    private void txtUsoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoBuscaKeyPressed

    private void tblUsoBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsoBuscaMouseClicked
        setarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_tblUsoBuscaMouseClicked

    private void txtUsoMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsoMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoMatriculaActionPerformed

    private void txtUsoMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoMatriculaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoMatriculaKeyPressed

    private void txtUsoMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoMatriculaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoMatriculaKeyReleased

    private void txtUsoMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoMatriculaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsoMatriculaKeyTyped

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
    telaUsuarios = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUsoAdd;
    private javax.swing.JButton btnUsoBusca;
    private javax.swing.JButton btnUsoCancelar;
    private javax.swing.JButton btnUsoDel;
    private javax.swing.JButton btnUsoEdit;
    private javax.swing.JComboBox<String> cmbUsoPerfil;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsoBusca;
    private javax.swing.JTextField txtUsoBusca;
    private javax.swing.JFormattedTextField txtUsoCelular;
    private javax.swing.JTextField txtUsoCidade;
    private javax.swing.JFormattedTextField txtUsoContrato;
    private javax.swing.JFormattedTextField txtUsoCpf;
    private javax.swing.JTextField txtUsoCref;
    private javax.swing.JTextField txtUsoEndereco;
    private javax.swing.JTextField txtUsoLogin;
    private javax.swing.JTextField txtUsoMatricula;
    private javax.swing.JTextField txtUsoNome;
    private javax.swing.JPasswordField txtUsoSenha;
    // End of variables declaration//GEN-END:variables
}
