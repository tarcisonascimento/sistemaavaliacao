package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import br.com.sa.busca.BuscaAvaTabelModel;
import br.com.sa.busca.BuscaUsoAvaTableModel;
import br.com.sa.busca.BuscaUsoAva;
import br.com.sa.busca.BuscaAva;
import java.awt.Window;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tarciso
 */
public class TelaAva extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java
    BuscaUsoAvaTableModel tableModel = new BuscaUsoAvaTableModel();
    BuscaAvaTabelModel tableModelAva = new BuscaAvaTabelModel();
    String sexo;

    //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAva telaAva;

    public static TelaAva getInstancia() {
        if (telaAva == null) {

            telaAva = new TelaAva();

        }
        return telaAva;
    }

    public TelaAva() {
        initComponents();
        conexao = ModuloConexao.conector();
        tblAvaBusca.setModel(tableModel);//setando a tabela busca usuario para dizer quais parametros ela vai receber
        tblAvaAva.setModel(tableModelAva);//setando a tabela avaliação
        getRootPane().setDefaultButton(btnAvaBusca);

    }

    /*public void calculodaIdade(){
   
       CalculoIdade idade = new CalculoIdade();
       String nasc = txtAvaData.getText();
       int resultado = idade.calculaIdade(nasc, "dd/MM/yyyy");
       txtCliIdade.setText(Integer.toString(resultado));
   
   }*/
    public void consultarCliente() {

        String sql = "select * from clientes where clinome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtAvaBusca.getText() + "%");
            rs = pst.executeQuery();

            while (rs.next()) { //enquanto o RS result set for inteiro existe um laço de repetiçao.

                BuscaUsoAva b = new BuscaUsoAva();
                b.setNome(rs.getString(2));
                b.setId(rs.getInt(1));
                tableModel.addRow(b);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    public void consultarAvaliacao() {

        String sql = "select * from avaliacao1 where idcli=?";
        int linhaava = tblAvaBusca.getSelectedRow();
        String tabela = tblAvaBusca.getValueAt(linhaava, 1).toString();//linha é alinha selecionada e 0 é a coluna

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tabela);
            rs = pst.executeQuery();
            int item = 1;
            tblAvaAva.removeAll();
            while (rs.next()) { //enquanto o RS result set for inteiro existe um laço de repetiçao.

                BuscaAva b = new BuscaAva();
                b.setIdava(rs.getInt(1));
                b.setData(rs.getString(2));
                b.setItem(item++);
                tableModelAva.addRow(b);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    //o metodo abaixo serve para limpar todos os campos
    private void limpacampos() {
        //nome,endereco,cidade,celular,cpf,datanasc,objetivos,idade

        txtAvaNome.setText(null);
        txtAvaBusca.setText(null);
        tblAvaBusca.removeAll();

    }

    //o metodo abaixo desativa os campos e ativa os botoes de controle
    public void desativacampos() {
        //nome,endereco,cidade,celular,cpf,datanasc,objetivos,idade

        txtAvaNome.setEnabled(false);
        tblAvaBusca.setEnabled(true);
        btnAvaBusca.setEnabled(true);
        txtAvaBusca.setEnabled(true);
    }

    //o metodo abaixo ativa os campos e desativa os botoes
    public void ativacampos() {

        //nome,endereco,cidade,celular,cpf,datanasc,objetivos,idade
        txtAvaNome.setEnabled(true);
        tblAvaBusca.setEnabled(false);
        tblAvaBusca.clearSelection();
        btnAvaBusca.setEnabled(false);
        txtAvaBusca.setEnabled(false);

    }

    //metodo para setar os campos do usuario com o conteudo da tabela
    public void setarCampos() {

        String sql = "select * from clientes where idcli=?";
        int linha = tblAvaBusca.getSelectedRow();
        String tarc = tblAvaBusca.getValueAt(linha, 1).toString();//linha é alinha selecionada e 0 é a coluna
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tarc);
            rs = pst.executeQuery();

            if (rs.next()) {

                txtAvaNome.setText(rs.getString(2));

            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    private void setarcamposava() {
        int avalinha = tblAvaAva.getSelectedRow();
        txtNumAva.setText(tblAvaAva.getValueAt(avalinha, 0).toString());
        txtDataAva.setText(tblAvaAva.getValueAt(avalinha, 1).toString());
        // a estrutura abaixo esta pegando o texto e tirando a hora

        txtDataAva.setText(tblAvaAva.getValueAt(avalinha, 1).toString().substring(0, tblAvaAva.getValueAt(avalinha, 1).toString().length() - 11).replaceAll("-", "/"));

    }
//o metodo abaixo envia as inforrmaçoes do Cliente para a tela de avaliaçao

    public void enviariformacoescliente() {

        String sql = "select * from clientes where idcli=?";
        int linha = tblAvaBusca.getSelectedRow();
        String tarc = tblAvaBusca.getValueAt(linha, 1).toString();//linha é alinha selecionada e 0 é a coluna

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tarc);
            rs = pst.executeQuery();

            if (rs.next()) {

                int numaceito = 16;//aqui é a quantidade de caracteres que cabe no Jtext
                int qtdcaracter = rs.getString(2).length();//aqui esta contando quantos caracteres tem no nome
                int calc = qtdcaracter - numaceito;//aqui subtrai a quantidade aceita de caracteres

                //a estrutura abaixo limita a quantidade de caracteres para nao distorcer o Jlabel
                if (qtdcaracter >= 16) {
                    TelaModuloAva.lblNomeAluno.setText(rs.getString(2).substring(0, rs.getString(2).length() - calc));
                    TelaModuloAva.lblMatricula.setText(rs.getString(1));
                    TelaModuloAva.lblIdade.setText(rs.getString(10));
                    sexo = (rs.getString(11));
                    TelaModuloAva.sexo = sexo;
                    TelaModuloAva.idade = Integer.parseInt(rs.getString(10));

                } else {
                    TelaModuloAva.lblNomeAluno.setText(rs.getString(2));
                    TelaModuloAva.lblMatricula.setText(rs.getString(1));
                    TelaModuloAva.lblIdade.setText(rs.getString(10));

                }

            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    private void removerava() {

        String sql = "delete from avaliacao1 where idava=?";

        int avasel = tblAvaAva.getSelectedRow();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tblAvaAva.getValueAt(avasel, 2).toString());
            int removido = pst.executeUpdate();//caso a exclusão for concluida cai no if
            if (removido > 0) {
                JOptionPane.showMessageDialog(null, "Avaliação Removida com Sucesso!");

                //a linha abaixo limpa a tabela
                tableModelAva.removeAll();  //limpa a tabela
                txtDataAva.setText(null);
                txtNumAva.setText(null);
                consultarAvaliacao();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

//o metodo abaixo envia as inforrmaçoes do usuario para a tela de avaliaçao
    public void enviarinformacoesusuario() {

        String sql = "select * from usuarios where nome like ?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaPrincipal.lblUsuario.getText() + "%");
            rs = pst.executeQuery();

            if (rs.next()) {

                int numaceito = 16;//aqui é a quantidade de caracteres que cabe no Jtext
                int qtdcaracter = rs.getString(2).length();//aqui esta contando quantos caracteres tem no nome
                int calc = qtdcaracter - numaceito;//aqui subtrai a quantidade aceita de caracteres

                //a estrutura abaixo limita a quantidade de caracteres para nao distorcer o Jlabel
                if (qtdcaracter >= 16) {
                    TelaModuloAva.lblNomeProfessor.setText(rs.getString(2).substring(0, rs.getString(2).length() - calc));
                    TelaModuloAva.lblIdProf.setText(rs.getString(1));

                } else {

                    TelaModuloAva.lblNomeProfessor.setText(rs.getString(2));
                    TelaModuloAva.lblIdProf.setText(rs.getString(1));
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 02" + e);
        }

    }

    //o metodo abaixo envia informaçoes do usuario atual do sistema para reabertura da tela principal
    public void enviainformacoesuso() {

        TelaModuloAva.NomeUso = TelaPrincipal.lblUsuario.getText();
        TelaModuloAva.PerfilAcesso = TelaPrincipal.lblPerfil.getText();
        TelaModuloAva.DataAcesso = TelaPrincipal.lblData.getText();

    }
    // o conteudo abaixo fecha as janelas abertas
    public void fechatelas (){

            TelaUsuarios.telaUsuarios = null;//setando a variavel do campo como nula
            TelaClientes.telaClientes = null;//idem
            
            //o comando abaixo fecha as janelas
            TelaPrincipal p = (TelaPrincipal) SwingUtilities.getRoot(this);
            ((Window) p).dispose();
            
            this.dispose();//fechando esta janela
            
            
            
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvaBusca = new javax.swing.JTable();
        txtAvaBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAvaNome = new javax.swing.JTextField();
        btnAvaBusca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvaAva = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnNovaAvalia = new javax.swing.JButton();
        btnAbrirAva = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDataAva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumAva = new javax.swing.JTextField();
        btnAbrirAva1 = new javax.swing.JButton();
        btnAbrirAva2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Avaliação Física");
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
        jDesktopPane1.setToolTipText("");
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(599, 454));

        tblAvaBusca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblAvaBusca.setForeground(new java.awt.Color(153, 102, 0));
        tblAvaBusca.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAvaBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAvaBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAvaBusca);
        if (tblAvaBusca.getColumnModel().getColumnCount() > 0) {
            tblAvaBusca.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblAvaBusca.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        txtAvaBusca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAvaBusca.setForeground(new java.awt.Color(153, 102, 0));
        txtAvaBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAvaBuscaActionPerformed(evt);
            }
        });
        txtAvaBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAvaBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAvaBuscaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAvaBuscaKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 0));
        jLabel1.setText("Buscar Cliente");

        txtAvaNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAvaNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAvaNome.setEnabled(false);

        btnAvaBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Search.png"))); // NOI18N
        btnAvaBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaBuscaActionPerformed(evt);
            }
        });

        tblAvaAva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblAvaAva.setForeground(new java.awt.Color(153, 102, 0));
        tblAvaAva.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAvaAva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAvaAvaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAvaAva);
        if (tblAvaAva.getColumnModel().getColumnCount() > 0) {
            tblAvaAva.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente Selecionado");

        btnNovaAvalia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anamnese30x40.png"))); // NOI18N
        btnNovaAvalia.setText("Nova Avaliação Física");
        btnNovaAvalia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovaAvalia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovaAvalia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaAvaliaActionPerformed(evt);
            }
        });

        btnAbrirAva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/open-file_40455.png"))); // NOI18N
        btnAbrirAva.setText("Abrir Avaliação Física");
        btnAbrirAva.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbrirAva.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAbrirAva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirAvaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Avaliações Físicas Encontradas Para o Cliente");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Avaliação Física Selecionada");

        txtDataAva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataAva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataAva.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 102, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nº");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 102, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Data");

        txtNumAva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNumAva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumAva.setEnabled(false);

        btnAbrirAva1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/excluir30x30.png"))); // NOI18N
        btnAbrirAva1.setText("Excluir Avaliação Física");
        btnAbrirAva1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbrirAva1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAbrirAva1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirAva1ActionPerformed(evt);
            }
        });

        btnAbrirAva2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/comparaazul30x30.png"))); // NOI18N
        btnAbrirAva2.setText("Comparar Avaliações");
        btnAbrirAva2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbrirAva2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAbrirAva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirAva2ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtAvaBusca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtAvaNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAvaBusca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnNovaAvalia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAbrirAva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtDataAva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtNumAva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAbrirAva1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnAbrirAva2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAvaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAvaBusca))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAvaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumAva, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataAva, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(btnAbrirAva1)
                                .addGap(40, 40, 40)
                                .addComponent(btnAbrirAva2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnAbrirAva, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 206, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovaAvalia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAvaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnAvaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAvaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataAva, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumAva, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirAva)
                    .addComponent(btnNovaAvalia)
                    .addComponent(btnAbrirAva1)
                    .addComponent(btnAbrirAva2))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 842, 579);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvaBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaBuscaActionPerformed
        tableModel.removeAll();
        tableModelAva.removeAll();                        //limpando a tabela antes de uma nova busca.    
        consultarCliente();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvaBuscaActionPerformed

    private void txtAvaBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAvaBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvaBuscaActionPerformed

    private void txtAvaBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAvaBuscaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvaBuscaKeyReleased

    private void txtAvaBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAvaBuscaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvaBuscaKeyTyped

    private void txtAvaBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAvaBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAvaBuscaKeyPressed

    private void tblAvaBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAvaBuscaMouseClicked
        setarCampos();
        tableModelAva.removeAll();  //limpa a tabela
        consultarAvaliacao();
    }//GEN-LAST:event_tblAvaBuscaMouseClicked

    private void tblAvaAvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAvaAvaMouseClicked
        setarcamposava();        // TODO add your handling code here:
    }//GEN-LAST:event_tblAvaAvaMouseClicked

    private void btnNovaAvaliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaAvaliaActionPerformed
        if (txtAvaNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "(*) Selecione um cliente!");

        } else {

            TelaModuloAva avaliacao = new TelaModuloAva();
            avaliacao.setVisible(true);
            enviariformacoescliente();
            enviarinformacoesusuario();
            enviainformacoesuso();
            fechatelas();

            
            
        }
    }//GEN-LAST:event_btnNovaAvaliaActionPerformed

    private void btnAbrirAvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirAvaActionPerformed
        int aval = tblAvaAva.getSelectedRow();
        if (aval < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma avaliação para abrir!");
        } else {

            String idaval = tblAvaAva.getValueAt(aval, 2).toString();
            TelaModuloAva avaliacao = new TelaModuloAva();
            avaliacao.setVisible(true);
            enviariformacoescliente();
            enviarinformacoesusuario();
            enviainformacoesuso();
            TelaModuloAva.lblIdAva.setText(idaval);
            TelaModuloAva.btnAvaInicio.setEnabled(false);

            //ativando os botões da tela avaliaçao
            TelaModuloAva.btnAvaAnaminese.setEnabled(true);
            TelaModuloAva.btnAvaCardio.setEnabled(true);
            TelaModuloAva.btnAvaHemo.setEnabled(true);
            TelaModuloAva.btnAvaImpri.setEnabled(true);
            TelaModuloAva.btnAvaInicio.setEnabled(false);
            TelaModuloAva.btnAvaMedidas.setEnabled(true);
            TelaModuloAva.btnAvaNeuro.setEnabled(true);
            TelaModuloAva.btnAvaPostural.setEnabled(true);
            
            fechatelas();
           
 

        }

    }//GEN-LAST:event_btnAbrirAvaActionPerformed

    private void btnAbrirAva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirAva1ActionPerformed
        if (txtNumAva.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Selecione a avaliação que deseja excluir!");
        } else {

            int sair = JOptionPane.showConfirmDialog(null, "A Avaliação Física selecionada será Apagada!\nEsta operação não poderá ser desfeita.\nDeseja Continuar?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (sair == JOptionPane.YES_OPTION) {

                removerava();
            }
        }
    }//GEN-LAST:event_btnAbrirAva1ActionPerformed

    private void btnAbrirAva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirAva2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirAva2ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        telaAva = null;        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirAva;
    private javax.swing.JButton btnAbrirAva1;
    private javax.swing.JButton btnAbrirAva2;
    private javax.swing.JButton btnAvaBusca;
    private javax.swing.JButton btnNovaAvalia;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAvaAva;
    private javax.swing.JTable tblAvaBusca;
    private javax.swing.JTextField txtAvaBusca;
    private javax.swing.JTextField txtAvaNome;
    private javax.swing.JTextField txtDataAva;
    private javax.swing.JTextField txtNumAva;
    // End of variables declaration//GEN-END:variables
}
