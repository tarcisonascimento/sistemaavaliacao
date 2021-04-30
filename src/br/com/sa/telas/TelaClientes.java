package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import br.com.sa.busca.Busca;
import br.com.sa.busca.BuscaTableModel;
import br.com.sa.classes.CalculoIdade;
import java.awt.Color;
import java.text.SimpleDateFormat;
import jdk.nashorn.internal.parser.DateParser;

/**
 *
 * @author Tarciso
 */
public class TelaClientes extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java
    BuscaTableModel tableModel = new BuscaTableModel();
    String opcao = null;
    
    
    //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaClientes telaClientes;
    
    public static TelaClientes getInstancia(){
        if (telaClientes == null){
            
            telaClientes = new TelaClientes();

        }
        return telaClientes;
    }
    
    
    
    

    public TelaClientes() {
        initComponents();
        conexao = ModuloConexao.conector();
        tblCliBusca.setModel(tableModel);//setando a tabela para dizer quais parametros ela vai receber
        getRootPane().setDefaultButton(btnCliBusca);

    }

    public void calculodaIdade() {

        CalculoIdade idade = new CalculoIdade();
        String nasc = txtCliDataNasc.getText();
        int resultado = idade.calculaIdade(nasc, "dd/MM/yyyy");
        txtCliIdade.setText(Integer.toString(resultado));

    }

    public void consultar() {

        String sql = "select * from clientes where clinome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliBusca.getText() + "%");
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
        String sql = "insert into clientes (clinome,cliendereco,clicidade,clicelular,clicpf,clidatanasc,cliobjetvos,cliidade,clisexo) values (?,?,?,?,?,?,?,?,?)";

        try {

            pst = conexao.prepareStatement(sql); //preparando a conexão
            pst.setString(1, txtCliNome.getText());
            pst.setString(2, txtCliEndereco.getText());
            pst.setString(3, txtCliCidade.getText());
            pst.setString(4, txtCliCelular.getText());
            pst.setString(5, txtCliCpf.getText());
            pst.setString(6, txtCliDataNasc.getText());
            pst.setString(7, txtCliObjetivos.getText());
            pst.setString(8, txtCliIdade.getText());
            pst.setString(9, cmbCliSexo.getSelectedItem().toString());

            //a linha abaixo atualiza a tabela usuarios com as informaçoes novas do formulario
            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    //Abaixo é o metodo para alterar os dados do usuário
    private void alterar() {

        String sql = "update clientes set clinome=?,cliendereco=?,clicidade=?,clicelular=?,clicpf=?,clidatanasc=?,cliobjetvos=?,cliidade=?,clisexo=? where idcli=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliNome.getText());
            pst.setString(2, txtCliEndereco.getText());
            pst.setString(3, txtCliCidade.getText());
            pst.setString(4, txtCliCelular.getText());
            pst.setString(5, txtCliCpf.getText());
            pst.setString(6, txtCliDataNasc.getText());
            pst.setString(7, txtCliObjetivos.getText());
            pst.setString(8, txtCliIdade.getText());
            pst.setString(9, cmbCliSexo.getSelectedItem().toString());
            pst.setString(10, txtCliMatricula.getText());
            
            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    //Metodo responsavel por excluir cadastros de usuarios
    private void remover() {

        String sql = "delete from clientes where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliMatricula.getText());
            int removido = pst.executeUpdate();//caso a adição for concluida cai no if
            if (removido > 0) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    //o metodo abaixo serve para limpar todos os campos
    private void limpacampos() {
        //nome,endereco,cidade,celular,cpf,datanasc,objetivos,idade

        txtCliNome.setText(null);
        txtCliEndereco.setText(null);
        txtCliCidade.setText(null);
        txtCliCelular.setText(null);
        txtCliCpf.setText(null);
        txtCliDataNasc.setText(null);
        txtCliObjetivos.setText(null);
        txtCliIdade.setText(null);
        txtCliBusca.setText(null);
        tblCliBusca.removeAll();
        txtCliMatricula.setText(null);
        cmbCliSexo.setSelectedItem("Selecione");

    }

    //o metodo abaixo desativa os campos e ativa os botoes de controle
    public void desativacampos() {
        //nome,endereco,cidade,celular,cpf,datanasc,objetivos,idade

        txtCliNome.setEnabled(false);
        txtCliEndereco.setEnabled(false);
        txtCliCidade.setEnabled(false);
        txtCliCelular.setEnabled(false);
        txtCliCpf.setEnabled(false);
        txtCliDataNasc.setEnabled(false);
        txtCliObjetivos.setEnabled(false);
        txtCliObjetivos.setBackground(new Color(240, 240, 240));
        btnCliSalvar.setEnabled(false);
        btnCliAdd.setEnabled(true);
        btnCliDel.setEnabled(true);
        btnCliEdit.setEnabled(true);
        btnCliCancelar.setEnabled(false);
        tblCliBusca.setEnabled(true);
        btnCliBusca.setEnabled(true);
        txtCliBusca.setEnabled(true);
        cmbCliSexo.setEnabled(false);
    }

    //o metodo abaixo ativa os campos e desativa os botoes
    public void ativacampos() {

        //nome,endereco,cidade,celular,cpf,datanasc,objetivos,idade
        txtCliNome.setEnabled(true);
        txtCliEndereco.setEnabled(true);
        txtCliCidade.setEnabled(true);
        txtCliCelular.setEnabled(true);
        txtCliCpf.setEnabled(true);
        txtCliDataNasc.setEnabled(true);
        txtCliObjetivos.setEnabled(true);
        txtCliObjetivos.setBackground(new Color(255, 255, 255));
        btnCliSalvar.setEnabled(true);
        btnCliAdd.setEnabled(false);
        btnCliDel.setEnabled(false);
        tblCliBusca.setEnabled(false);
        tblCliBusca.clearSelection();
        btnCliBusca.setEnabled(false);
        txtCliBusca.setEnabled(false);
        btnCliEdit.setEnabled(false);
        btnCliCancelar.setEnabled(true);
        cmbCliSexo.setEnabled(true);

    }

    //metodo para setar os campos do usuario com o conteudo da tabela
    public void setarCampos() {
        String sql = "select * from clientes where idcli=?";
        int linha = tblCliBusca.getSelectedRow();
        String tarc = tblCliBusca.getValueAt(linha, 2).toString();//linha é alinha selecionada e 0 é a coluna
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tarc);
            rs = pst.executeQuery();

            if (rs.next()) {

                txtCliMatricula.setText(rs.getString(1));
                txtCliNome.setText(rs.getString(2));
                txtCliEndereco.setText(rs.getString(3));
                txtCliCidade.setText(rs.getString(4));
                txtCliCelular.setText(rs.getString(5));
                txtCliCpf.setText(rs.getString(6));
                txtCliDataNasc.setText(rs.getString(7));
                txtCliObjetivos.setText(rs.getString(8));
                txtCliIdade.setText(rs.getString(10));
                cmbCliSexo.setSelectedItem(rs.getString(11));

            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        txtCliIdade = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCliSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCliCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCliDataNasc = new javax.swing.JFormattedTextField();
        txtCliCelular = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCliCpf = new javax.swing.JFormattedTextField();
        btnCliAdd = new javax.swing.JButton();
        btnCliEdit = new javax.swing.JButton();
        btnCliDel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliBusca = new javax.swing.JTable();
        btnCliBusca = new javax.swing.JButton();
        txtCliMatricula = new javax.swing.JTextField();
        txtCliBusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCliEndereco = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCliObjetivos = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        btnCliSalvar = new javax.swing.JButton();
        btnCliCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Clientes");
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

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jDesktopPane2.setBackground(new java.awt.Color(255, 247, 241));

        try {
            txtCliIdade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliIdade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCliIdade.setToolTipText("");
        txtCliIdade.setEnabled(false);
        txtCliIdade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDesktopPane2.add(txtCliIdade);
        txtCliIdade.setBounds(280, 360, 50, 32);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setText("Endereço");
        jDesktopPane2.add(jLabel4);
        jLabel4.setBounds(70, 200, 70, 30);

        cmbCliSexo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbCliSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));
        cmbCliSexo.setEnabled(false);
        cmbCliSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCliSexoActionPerformed(evt);
            }
        });
        jDesktopPane2.add(cmbCliSexo);
        cmbCliSexo.setBounds(140, 400, 190, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 102, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Cidade/UF");
        jDesktopPane2.add(jLabel5);
        jLabel5.setBounds(60, 240, 80, 30);

        txtCliCidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliCidade.setEnabled(false);
        jDesktopPane2.add(txtCliCidade);
        txtCliCidade.setBounds(140, 240, 226, 32);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 102, 0));
        jLabel6.setText("* Celular");
        jDesktopPane2.add(jLabel6);
        jLabel6.setBounds(70, 280, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 102, 0));
        jLabel8.setText("* Data Nasc.");
        jDesktopPane2.add(jLabel8);
        jLabel8.setBounds(50, 357, 90, 30);

        try {
            txtCliDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliDataNasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCliDataNasc.setToolTipText("");
        txtCliDataNasc.setEnabled(false);
        txtCliDataNasc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCliDataNascFocusLost(evt);
            }
        });
        jDesktopPane2.add(txtCliDataNasc);
        txtCliDataNasc.setBounds(140, 360, 130, 32);

        try {
            txtCliCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliCelular.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCliCelular.setEnabled(false);
        txtCliCelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDesktopPane2.add(txtCliCelular);
        txtCliCelular.setBounds(140, 280, 190, 32);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 102, 0));
        jLabel9.setText("C.P.F.");
        jDesktopPane2.add(jLabel9);
        jLabel9.setBounds(89, 320, 50, 30);

        try {
            txtCliCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliCpf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCliCpf.setEnabled(false);
        txtCliCpf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDesktopPane2.add(txtCliCpf);
        txtCliCpf.setBounds(140, 320, 190, 32);

        btnCliAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/adicionaricone30x30.png"))); // NOI18N
        btnCliAdd.setText("Adicionar Cliente");
        btnCliAdd.setToolTipText("Adicionar Cliente");
        btnCliAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCliAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAddActionPerformed(evt);
            }
        });
        jDesktopPane2.add(btnCliAdd);
        btnCliAdd.setBounds(630, 160, 160, 39);

        btnCliEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/edit30x30.png"))); // NOI18N
        btnCliEdit.setText("Editar Cliente");
        btnCliEdit.setToolTipText("Editar Cliente");
        btnCliEdit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCliEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliEditActionPerformed(evt);
            }
        });
        jDesktopPane2.add(btnCliEdit);
        btnCliEdit.setBounds(630, 210, 160, 39);

        btnCliDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/excluir30x30.png"))); // NOI18N
        btnCliDel.setText("Excluir Cliente");
        btnCliDel.setToolTipText("Excluir Cliente");
        btnCliDel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCliDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliDelActionPerformed(evt);
            }
        });
        jDesktopPane2.add(btnCliDel);
        btnCliDel.setBounds(630, 260, 160, 39);

        tblCliBusca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblCliBusca.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCliBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCliBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliBusca);
        if (tblCliBusca.getColumnModel().getColumnCount() > 0) {
            tblCliBusca.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jDesktopPane2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 51, 780, 92);

        btnCliBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Search.png"))); // NOI18N
        btnCliBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliBuscaActionPerformed(evt);
            }
        });
        jDesktopPane2.add(btnCliBusca);
        btnCliBusca.setBounds(480, 10, 70, 32);

        txtCliMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCliMatricula.setEnabled(false);
        txtCliMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliMatriculaActionPerformed(evt);
            }
        });
        txtCliMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCliMatriculaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliMatriculaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliMatriculaKeyTyped(evt);
            }
        });
        jDesktopPane2.add(txtCliMatricula);
        txtCliMatricula.setBounds(690, 10, 100, 32);

        txtCliBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliBuscaActionPerformed(evt);
            }
        });
        txtCliBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCliBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliBuscaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliBuscaKeyTyped(evt);
            }
        });
        jDesktopPane2.add(txtCliBusca);
        txtCliBusca.setBounds(120, 10, 350, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setText("Matrícula");
        jDesktopPane2.add(jLabel3);
        jLabel3.setBounds(620, 10, 70, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 0));
        jLabel1.setText("Buscar Cliente");
        jDesktopPane2.add(jLabel1);
        jLabel1.setBounds(10, 10, 110, 30);

        txtCliNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliNome.setEnabled(false);
        jDesktopPane2.add(txtCliNome);
        txtCliNome.setBounds(140, 160, 410, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 0));
        jLabel2.setText("* Nome Completo");
        jDesktopPane2.add(jLabel2);
        jLabel2.setBounds(10, 160, 130, 30);

        txtCliEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliEndereco.setEnabled(false);
        jDesktopPane2.add(txtCliEndereco);
        txtCliEndereco.setBounds(140, 200, 410, 32);

        txtCliObjetivos.setBackground(new java.awt.Color(240, 240, 240));
        txtCliObjetivos.setColumns(20);
        txtCliObjetivos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCliObjetivos.setLineWrap(true);
        txtCliObjetivos.setRows(5);
        txtCliObjetivos.setWrapStyleWord(true);
        txtCliObjetivos.setEnabled(false);
        jScrollPane2.setViewportView(txtCliObjetivos);

        jDesktopPane2.add(jScrollPane2);
        jScrollPane2.setBounds(350, 320, 440, 110);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 102, 0));
        jLabel13.setText("* Objetivos");
        jDesktopPane2.add(jLabel13);
        jLabel13.setBounds(350, 300, 80, 17);

        btnCliSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnCliSalvar.setText("Salvar");
        btnCliSalvar.setEnabled(false);
        btnCliSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliSalvarActionPerformed(evt);
            }
        });
        jDesktopPane2.add(btnCliSalvar);
        btnCliSalvar.setBounds(630, 440, 160, 40);

        btnCliCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        btnCliCancelar.setText("Cancelar");
        btnCliCancelar.setEnabled(false);
        btnCliCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliCancelarActionPerformed(evt);
            }
        });
        jDesktopPane2.add(btnCliCancelar);
        btnCliCancelar.setBounds(350, 440, 140, 40);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 102, 0));
        jLabel15.setText("* Sexo");
        jDesktopPane2.add(jLabel15);
        jLabel15.setBounds(87, 400, 50, 30);

        jScrollPane3.setViewportView(jDesktopPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        setBounds(0, 0, 842, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAddActionPerformed
        //ativando os campos para serem editados;

        ativacampos();//cgamando o metodo para ativar os campos e desativar botoes
        limpacampos();//chamando o metodo limpar campos
        opcao = "Adicionar";
        btnCliSalvar.setText("Adicionar");


    }//GEN-LAST:event_btnCliAddActionPerformed

    private void btnCliCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliCancelarActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Cancelar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (cancelar == JOptionPane.YES_OPTION) {

            limpacampos();//chamando o metodo limpa campos
            desativacampos();//desativando os campos e ativando os botoes

        }
    }//GEN-LAST:event_btnCliCancelarActionPerformed

    private void btnCliEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliEditActionPerformed
        if ("".equals(txtCliNome.getText())) {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente!");
        } else {

            ativacampos();//chamando o metodo ativar campos
            opcao = "Alterar";
            btnCliSalvar.setText("Alterar");//mudando o nome do btn salvar
        }
    }//GEN-LAST:event_btnCliEditActionPerformed

    private void btnCliDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliDelActionPerformed
        if ("".equals(txtCliNome.getText())) {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente!");
        } else {

            ativacampos();//chamando o metodo para ativar os campos
            opcao = "Excluir";
            btnCliSalvar.setText("Excluir");//alterando o nome do botao salvar

        }
    }//GEN-LAST:event_btnCliDelActionPerformed

    private void btnCliSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliSalvarActionPerformed
        if (opcao.equals("Adicionar")) {//se o texto do botao estiver Adicionar

            if ((txtCliNome.getText().isEmpty()) || (txtCliCelular.getText().isEmpty()) || (txtCliCelular.getText().isEmpty()) || (txtCliDataNasc.getText().isEmpty()) || (cmbCliSexo.getSelectedItem().equals("Selecione"))) {
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

        if (opcao.equals("Alterar")) {// se o texto do botao estiver Alterar

            if ((txtCliNome.getText().isEmpty()) || (txtCliCelular.getText().isEmpty()) || (txtCliCelular.getText().isEmpty()) || (txtCliDataNasc.getText().isEmpty()) || (cmbCliSexo.getSelectedItem().equals("Selecione"))) {
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

        if (opcao.equals("Excluir")) {

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


    }//GEN-LAST:event_btnCliSalvarActionPerformed

    private void btnCliBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliBuscaActionPerformed
        tableModel.removeAll();//limpando a tabela antes de uma nova busca.    
        consultar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCliBuscaActionPerformed

    private void txtCliBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliBuscaActionPerformed

    private void txtCliBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliBuscaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliBuscaKeyReleased

    private void txtCliBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliBuscaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliBuscaKeyTyped

    private void txtCliBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliBuscaKeyPressed

    private void tblCliBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCliBuscaMouseClicked
        setarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_tblCliBuscaMouseClicked

    private void txtCliMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliMatriculaActionPerformed

    private void txtCliMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliMatriculaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliMatriculaKeyPressed

    private void txtCliMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliMatriculaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliMatriculaKeyReleased

    private void txtCliMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliMatriculaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliMatriculaKeyTyped

    private void txtCliDataNascFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCliDataNascFocusLost
        //System.out.println("AQUI VAI A AÇÂO");     
        // TODO add your handling code here:
        calculodaIdade();
    }//GEN-LAST:event_txtCliDataNascFocusLost

    private void cmbCliSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCliSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCliSexoActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        telaClientes = null;
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliAdd;
    private javax.swing.JButton btnCliBusca;
    private javax.swing.JButton btnCliCancelar;
    private javax.swing.JButton btnCliDel;
    private javax.swing.JButton btnCliEdit;
    private javax.swing.JButton btnCliSalvar;
    private javax.swing.JComboBox<String> cmbCliSexo;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCliBusca;
    private javax.swing.JTextField txtCliBusca;
    private javax.swing.JFormattedTextField txtCliCelular;
    private javax.swing.JTextField txtCliCidade;
    private javax.swing.JFormattedTextField txtCliCpf;
    private javax.swing.JFormattedTextField txtCliDataNasc;
    private javax.swing.JTextField txtCliEndereco;
    private javax.swing.JFormattedTextField txtCliIdade;
    private javax.swing.JTextField txtCliMatricula;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextArea txtCliObjetivos;
    // End of variables declaration//GEN-END:variables
}
