package br.com.sa.telas;

import br.com.sa.classes.GerenciadorDeJanelas;
import br.com.sa.dal.ModuloConexao;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.Image;
import javax.swing.ImageIcon;

public class TelaPrincipal extends javax.swing.JFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    GerenciadorDeJanelas gerenciadorDeJanela; //variavel para trabalhar com o gerenciador de janelas

    public void setarcamposempresa() {

        String sql = "select * from empresa where idempresa=?";

        try {
            pst = conexao.prepareCall(sql);
            pst.setString(1, "1");
            rs = pst.executeQuery();

            if (rs.next()) {

                TelaDadosProprietario.txtCelular.setText(rs.getString("empcelular"));
                TelaDadosProprietario.txtCep.setText(rs.getString("empcep"));
                TelaDadosProprietario.txtCidade.setText(rs.getString("empcidade"));
                TelaDadosProprietario.txtCpfCnpj.setText(rs.getString("empcnpjcpf"));
                TelaDadosProprietario.txtEmail.setText(rs.getString("empemail"));
                TelaDadosProprietario.txtEndereco.setText(rs.getString("empendereco"));
                TelaDadosProprietario.txtInscricaoEstadual.setText(rs.getString("empinscricao"));
                TelaDadosProprietario.txtNomeFantasia.setText(rs.getString("empnomefantasia"));
                TelaDadosProprietario.txtRazaoSocial.setText(rs.getString("emprazaosocial"));
                TelaDadosProprietario.txtSlogan.setText(rs.getString("empslogan"));
                TelaDadosProprietario.txtTelefone.setText(rs.getString("emptelefone"));
                TelaDadosProprietario.cmbUF.setSelectedItem(rs.getString("empestado"));

                if (rs.getBytes("emplogo") == null) {

                    ImageIcon ft = new ImageIcon("src/br/com/sa/icones/adicionarfoto.png");
                    ft.setImage(ft.getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
                    TelaDadosProprietario.lblFotoLogo.setIcon(ft);

                } else {
                    ImageIcon ft = new ImageIcon(rs.getBytes("emplogo"));
                    ft.setImage(ft.getImage().getScaledInstance(180, 180, Image.SCALE_AREA_AVERAGING));
                    TelaDadosProprietario.lblFotoLogo.setIcon(ft);
                    TelaDadosProprietario.logobytes = rs.getBytes("emplogo");
                }

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao buscar informações da empresa!\nCodigo do Erro: " + e);

        }

    }

    public TelaPrincipal() {
        initComponents();

        conexao = ModuloConexao.conector();
        this.gerenciadorDeJanela = new GerenciadorDeJanelas(Desktop);//passar o desktop para dentro da variavel 

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNovaAvalia = new javax.swing.JButton();
        btnNovoCli = new javax.swing.JButton();
        bntArquivo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovoCli1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menArq = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menArqAva = new javax.swing.JMenuItem();
        menArqFicha = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menArqSair = new javax.swing.JMenuItem();
        MenNov = new javax.swing.JMenu();
        menArqExer = new javax.swing.JMenuItem();
        menNovCli = new javax.swing.JMenuItem();
        menNovUso = new javax.swing.JMenuItem();
        MenCadProp = new javax.swing.JMenuItem();
        menRel = new javax.swing.JMenu();
        menRelAva = new javax.swing.JMenuItem();
        menRelUso = new javax.swing.JMenuItem();
        menRelCli = new javax.swing.JMenuItem();
        menOpc = new javax.swing.JMenu();
        menOpcBac = new javax.swing.JMenuItem();
        menOpcRes = new javax.swing.JMenuItem();
        menOpcReg = new javax.swing.JMenuItem();
        menOpcSob = new javax.swing.JMenuItem();
        menAju = new javax.swing.JMenu();
        menAjuAva = new javax.swing.JMenuItem();
        menAjuSis = new javax.swing.JMenuItem();
        menAjuSac = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 247, 241));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Desktop.setBackground(new java.awt.Color(255, 247, 241));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Fundotelaprincipal.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        Desktop.add(jLabel3);
        jLabel3.setBounds(0, 0, 840, 580);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informações"));

        lblUsuario.setForeground(new java.awt.Color(102, 102, 102));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Nome do Usuario");

        lblPerfil.setForeground(new java.awt.Color(0, 51, 153));
        lblPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerfil.setText("Perfil de Acesso");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblData.setForeground(new java.awt.Color(102, 102, 102));
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("Data de Acesso");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(lblPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Controles"));

        btnNovaAvalia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anamnese30x40.png"))); // NOI18N
        btnNovaAvalia.setText("Avaliação Física");
        btnNovaAvalia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovaAvalia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovaAvalia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaAvaliaActionPerformed(evt);
            }
        });

        btnNovoCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/753210.png"))); // NOI18N
        btnNovoCli.setText("Clientes");
        btnNovoCli.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovoCli.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCliActionPerformed(evt);
            }
        });

        bntArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/open-file_40455.png"))); // NOI18N
        bntArquivo.setText("Abrir");
        bntArquivo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bntArquivo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bntArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntArquivoActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovoCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/753210.png"))); // NOI18N
        btnNovoCli1.setText("Usuários");
        btnNovoCli1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovoCli1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovoCli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCli1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnNovaAvalia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoCli1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnNovaAvalia)
                .addGap(5, 5, 5)
                .addComponent(btnNovoCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoCli1)
                .addGap(34, 34, 34)
                .addComponent(bntArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(36, 36, 36))
        );

        menArq.setText("Arquivo");
        menArq.add(jSeparator2);

        menArqAva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menArqAva.setText("Avaliações Físicas");
        menArq.add(menArqAva);

        menArqFicha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menArqFicha.setText("Fichas de Treino");
        menArq.add(menArqFicha);

        jMenu3.setText("Novo");

        jMenuItem1.setText("Avaliação Física");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Ficha de Treino");
        jMenu3.add(jMenuItem3);

        menArq.add(jMenu3);
        menArq.add(jSeparator3);

        menArqSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menArqSair.setText("Sair");
        menArqSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menArqSairActionPerformed(evt);
            }
        });
        menArq.add(menArqSair);

        jMenuBar1.add(menArq);

        MenNov.setText("Cadastrar");

        menArqExer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menArqExer.setText("Exercícios");
        MenNov.add(menArqExer);

        menNovCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menNovCli.setText("Cliente");
        menNovCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menNovCliActionPerformed(evt);
            }
        });
        MenNov.add(menNovCli);

        menNovUso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menNovUso.setText("Usuário");
        menNovUso.setEnabled(false);
        menNovUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menNovUsoActionPerformed(evt);
            }
        });
        MenNov.add(menNovUso);

        MenCadProp.setText("Dados do Proprietário");
        MenCadProp.setEnabled(false);
        MenCadProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadPropActionPerformed(evt);
            }
        });
        MenNov.add(MenCadProp);

        jMenuBar1.add(MenNov);

        menRel.setText("Relatórios");
        menRel.setEnabled(false);
        menRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelActionPerformed(evt);
            }
        });

        menRelAva.setText("Avaliações");
        menRel.add(menRelAva);

        menRelUso.setText("Usuários");
        menRelUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelUsoActionPerformed(evt);
            }
        });
        menRel.add(menRelUso);

        menRelCli.setText("Clientes");
        menRelCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelCliActionPerformed(evt);
            }
        });
        menRel.add(menRelCli);

        jMenuBar1.add(menRel);

        menOpc.setText("Opções");

        menOpcBac.setText("Backup bd");
        menOpc.add(menOpcBac);

        menOpcRes.setText("Restaurar bd");
        menOpc.add(menOpcRes);

        menOpcReg.setText("Registro");
        menOpc.add(menOpcReg);

        menOpcSob.setText("Sobre");
        menOpc.add(menOpcSob);

        jMenuBar1.add(menOpc);

        menAju.setText("Ajuda");

        menAjuAva.setText("Ajuda Avaliação");
        menAju.add(menAjuAva);

        menAjuSis.setText("Ajuda Sistema");
        menAju.add(menAjuSis);

        menAjuSac.setText("S.A.C.");
        menAju.add(menAjuSac);

        jMenuBar1.add(menAju);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(Desktop)
        );

        setSize(new java.awt.Dimension(1016, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //as linhas abaixo substitui a linha data lbl data pela data atual do sistema ao inicializar o forma

        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);//formata a data
        lblData.setText("Data: " + formatador.format(data));

        //lblData.setText(data.toString());//converte a data em string
    }//GEN-LAST:event_formWindowActivated

    private void menArqSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menArqSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "O Sistema será fechado, deseja continuar?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {

            System.exit(0);//fecha o sistema se clicar em sim

        }

// TODO add your handling code here:
    }//GEN-LAST:event_menArqSairActionPerformed

    private void menNovUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menNovUsoActionPerformed
        //instanciando a tela de usuarios ao clicar no item do menu
        gerenciadorDeJanela.abrirJanelas(TelaUsuarios.getInstancia());//instanciando a tela pela classe gerenciador de janelas
        /*TelaUsuarios usuario = new TelaUsuarios();
        usuario.setVisible(true);
        Desktop.add(usuario);
        
        Modelo Antigo e instanciamento*/
    }//GEN-LAST:event_menNovUsoActionPerformed

    private void menNovCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menNovCliActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaClientes.getInstancia());//instanciando a tela pela classe gerenciador de janelas
    }//GEN-LAST:event_menNovCliActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAva.getInstancia());//instanciando a tela pela classe gerenciador de janelas
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnNovaAvaliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaAvaliaActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAva.getInstancia());//instanciando a tela pela classe gerenciador de janelas
    }//GEN-LAST:event_btnNovaAvaliaActionPerformed

    private void btnNovoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCliActionPerformed
        
        gerenciadorDeJanela.abrirJanelas(TelaClientes.getInstancia());
//instanciando a tela pela classe gerenciador de janelas
    }//GEN-LAST:event_btnNovoCliActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        int sair = JOptionPane.showConfirmDialog(null, "O Sistema será fechado, deseja continuar?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {

            System.exit(0);//fecha o sistema se clicar em sim

        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void menRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelActionPerformed

    }//GEN-LAST:event_menRelActionPerformed

    private void menRelCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelCliActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Impressão deste Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            //imprimeindo relatorio com o framework do jasper
            try {
                JasperPrint imprime = JasperFillManager.fillReport("src/br/com/sa/relatorio/clientes.jasper", null, conexao);
                //a linha abaixo exibe o relatorio a travez da classe viewr
                imprime.setName("Relatório de Clientes - FlySys");
                JasperViewer.viewReport(imprime, false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Imprimir relatorio" + e);
            }

        }
    }//GEN-LAST:event_menRelCliActionPerformed

    private void menRelUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelUsoActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Impressão deste Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            //imprimeindo relatorio com o framework do jasper
            try {
                JasperPrint imprime = JasperFillManager.fillReport("src/br/com/sa/relatorio/usuarios.jasper", null, conexao);
                //a linha abaixo exibe o relatorio a travez da classe viewr
                imprime.setName("Relatório de Usuários - FlySys");
                JasperViewer.viewReport(imprime, false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Imprimir relatorio" + e);
            }

        }
    }//GEN-LAST:event_menRelUsoActionPerformed

    private void MenCadPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadPropActionPerformed
        TelaDadosProprietario t = new TelaDadosProprietario();
        t.setVisible(true);
        setarcamposempresa();
        Desktop.add(t);
    }//GEN-LAST:event_MenCadPropActionPerformed

    private void bntArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntArquivoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = JOptionPane.showConfirmDialog(null, "O Sistema será fechado, deseja continuar?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {

            System.exit(0);//fecha o sistema se clicar em sim

        }

    }//GEN-LAST:event_formWindowClosing

    private void btnNovoCli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCli1ActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaUsuarios.getInstancia());//instanciando a tela pela classe gerenciador de janelas
    }//GEN-LAST:event_btnNovoCli1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Desktop;
    public static javax.swing.JMenuItem MenCadProp;
    private javax.swing.JMenu MenNov;
    private javax.swing.JButton bntArquivo;
    private javax.swing.JButton btnNovaAvalia;
    private javax.swing.JButton btnNovoCli;
    private javax.swing.JButton btnNovoCli1;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    public static javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblPerfil;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAju;
    private javax.swing.JMenuItem menAjuAva;
    private javax.swing.JMenuItem menAjuSac;
    private javax.swing.JMenuItem menAjuSis;
    private javax.swing.JMenu menArq;
    private javax.swing.JMenuItem menArqAva;
    private javax.swing.JMenuItem menArqExer;
    private javax.swing.JMenuItem menArqFicha;
    private javax.swing.JMenuItem menArqSair;
    private javax.swing.JMenuItem menNovCli;
    public static javax.swing.JMenuItem menNovUso;
    private javax.swing.JMenu menOpc;
    private javax.swing.JMenuItem menOpcBac;
    private javax.swing.JMenuItem menOpcReg;
    private javax.swing.JMenuItem menOpcRes;
    private javax.swing.JMenuItem menOpcSob;
    public static javax.swing.JMenu menRel;
    private javax.swing.JMenuItem menRelAva;
    private javax.swing.JMenuItem menRelCli;
    private javax.swing.JMenuItem menRelUso;
    // End of variables declaration//GEN-END:variables
}
