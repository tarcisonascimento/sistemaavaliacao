package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import br.com.sa.classes.CalculoImc;
import br.com.sa.classes.CalculoFcEstimada;
import br.com.sa.classes.CalculoDebitoCardiaco;
import br.com.sa.classes.CalculoVolumeSistolico;
import br.com.sa.classes.CalculoDuploProduto;
import br.com.sa.classes.CalculoMivo;

public class TelaAvaHemo extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java
    
    
    
    //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAvaHemo telaAvaHemo;
    
    public static TelaAvaHemo getInstancia(){
        if (telaAvaHemo == null){
            
            telaAvaHemo = new TelaAvaHemo();

        }
        return telaAvaHemo;
    }

    public void incluiranamnese() {

        String sql = "update avaliacao1 set altura=?,peso=?,imc=?,imcclassifica=?,imcgrau=?,fcprotococloest=?,fcesforco=?,fc=?,pd=?,ps=?,pdesf=?,psesf=?,vo2=?,debcardproto=?,debcard=?,vsproto=?,vs=?,duploproto=?,duploproduto=?,mivoproto=?,mivo=? where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtHemoEsta.getText());
            pst.setString(2, txtHemoPeso.getText());
            pst.setString(3, lblHemoIMC.getText());//ana03
            pst.setString(4, lblHemoResuImc.getText());//ana04
            pst.setString(5, lblHemoGrau.getText());//ana05
            pst.setString(6, cmbFcCalculo.getSelectedItem().toString());//ana06
            pst.setString(7, txtFcEst.getText());//txana06
            pst.setString(8, txtFcRep.getText());//ana07
            pst.setString(9, txtPadRep.getText());//txana07
            pst.setString(10, txtPasRep.getText());//ana08
            pst.setString(11, txtPadEsf.getText());//txana08
            pst.setString(12, txtPasEsf.getText());//ana09
            pst.setString(13, txtVo2.getText());//txana09
            pst.setString(14, cmbDcCalculo.getSelectedItem().toString());//ana10
            pst.setString(15, lblDcResult.getText());//txana09
            pst.setString(16, cmbVsCalculo.getSelectedItem().toString());//ana11
            pst.setString(17, lblVsRetorno.getText());//txana11
            pst.setString(18, cmbDpCalculo.getSelectedItem().toString());//ana12
            pst.setString(19, lblDpRetorno.getText());//
            pst.setString(20, cmbMivoCalculo.getSelectedItem().toString());//
            pst.setString(21, lblMivoRetorno.getText());//
            pst.setString(22, TelaModuloAva.lblIdAva.getText());//

            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Parâmetros Hemodinâmicos incluídos com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }
//o metodo abaixo calcula o imc

    public void calculoimc() {
        String imc;
        CalculoImc p = new CalculoImc();
        p.peso = Double.parseDouble(txtHemoPeso.getText().replaceAll(",", "."));
        p.estatura = Double.parseDouble(txtHemoEsta.getText());
        p.calculoimc();
        imc = String.format("%.2f", p.imc); //formatando a string para pegar só duas casas
        lblHemoIMC.setText(imc);
        lblHemoResuImc.setText(p.classifica);
        lblHemoGrau.setText(p.obesidade);

    }

    //o metodo abaixo calcula a fc maxima
    public void calcularfc() {

        String fc;
        if (cmbFcCalculo.getSelectedItem().equals("Karvonen Homens e Mulheres (1957)")) {

            CalculoFcEstimada p = new CalculoFcEstimada();
            p.fc = Integer.parseInt(txtFcRep.getText());
            p.idade = Integer.parseInt(txtHemoIdade.getText());
            p.karvoren();
            fc = String.format("%.0f", p.resultado);
            txtFcEst.setText(fc);

        }
        if (cmbFcCalculo.getSelectedItem().equals("Shefield Homens e Mulheres Não Atletas (1965)")) {

            CalculoFcEstimada p = new CalculoFcEstimada();
            p.fc = Integer.parseInt(txtFcRep.getText());
            p.idade = Integer.parseInt(txtHemoIdade.getText());
            p.shefieldnaoatleta();
            fc = String.format("%.0f", p.resultado);
            txtFcEst.setText(fc);

        }
        if (cmbFcCalculo.getSelectedItem().equals("Shefield Homens e Mulheres Atletas (1965)")) {

            CalculoFcEstimada p = new CalculoFcEstimada();
            p.fc = Integer.parseInt(txtFcRep.getText());
            p.idade = Integer.parseInt(txtHemoIdade.getText());
            p.shefieldatleta();
            fc = String.format("%.0f", p.resultado);
            txtFcEst.setText(fc);

        }
        if (cmbFcCalculo.getSelectedItem().equals("Jones  Homens e Mulheres (1975)")) {

            CalculoFcEstimada p = new CalculoFcEstimada();
            p.fc = Integer.parseInt(txtFcRep.getText());
            p.idade = Integer.parseInt(txtHemoIdade.getText());
            p.jones();
            fc = String.format("%.0f", p.resultado);
            txtFcEst.setText(fc);

        }
        if (cmbFcCalculo.getSelectedItem().equals("ACMS Homens e Mulheres (1995)")) {

            CalculoFcEstimada p = new CalculoFcEstimada();
            p.fc = Integer.parseInt(txtFcRep.getText());
            p.idade = Integer.parseInt(txtHemoIdade.getText());
            p.acms();
            fc = String.format("%.0f", p.resultado);
            txtFcEst.setText(fc);

        }
    }

    //o metodo abaixo calcula o Débito cardíaco.
    public void debitocardiaco() {
        String dc;
        if (cmbDcCalculo.getSelectedItem().equals("Falkner Homens e Mulheres Não Atleta Menor de 40 anos (1977)")) {

            CalculoDebitoCardiaco p = new CalculoDebitoCardiaco();
            p.vo2 = Double.parseDouble(txtVo2.getText().replaceAll(",", "."));
            p.peso = Double.parseDouble(txtHemoPeso.getText().replaceAll(",", "."));
            p.falkner1();
            dc = String.format("%.2f", p.DCresultado);
            lblDcResult.setText(dc);

        }
        if (cmbDcCalculo.getSelectedItem().equals("Falkner Homens e Mulheres Atleta Maior de 40 anos (1977)")) {

            CalculoDebitoCardiaco p = new CalculoDebitoCardiaco();
            p.vo2 = Double.parseDouble(txtVo2.getText().replaceAll(",", "."));
            p.peso = Double.parseDouble(txtHemoPeso.getText().replaceAll(",", "."));
            p.falkner2();
            dc = String.format("%.2f", p.DCresultado);
            lblDcResult.setText(dc);

        }
        if (cmbDcCalculo.getSelectedItem().equals("Falkner Homens e Mulheres Atletas (1977)")) {

            CalculoDebitoCardiaco p = new CalculoDebitoCardiaco();
            p.vo2 = Double.parseDouble(txtVo2.getText().replaceAll(",", "."));
            p.peso = Double.parseDouble(txtHemoPeso.getText().replaceAll(",", "."));
            p.falkner3();
            dc = String.format("%.2f", p.DCresultado);
            lblDcResult.setText(dc);

        }
        if (cmbDcCalculo.getSelectedItem().equals("Hossack Homens (1980)")) {

            CalculoDebitoCardiaco p = new CalculoDebitoCardiaco();
            p.vo2 = Double.parseDouble(txtVo2.getText().replaceAll(",", "."));
            p.peso = Double.parseDouble(txtHemoPeso.getText().replaceAll(",", "."));
            p.hossack1();
            dc = String.format("%.2f", p.DCresultado);
            lblDcResult.setText(dc);

        }
        if (cmbDcCalculo.getSelectedItem().equals("Hossack Mulheres (1980)")) {

            CalculoDebitoCardiaco p = new CalculoDebitoCardiaco();
            p.vo2 = Double.parseDouble(txtVo2.getText().replaceAll(",", "."));
            p.peso = Double.parseDouble(txtHemoPeso.getText().replaceAll(",", "."));
            p.hossack2();
            dc = String.format("%.2f", p.DCresultado);
            lblDcResult.setText(dc);

        }
    }

    //o metodo abaixo calcula o volume sistólico
    public void calculovolsist() {
        String vs;
        if (cmbVsCalculo.getSelectedItem().equals("Wilmore & Norton Homens e Mulheres Geral (1975)")) {

            CalculoVolumeSistolico p = new CalculoVolumeSistolico();
            p.dc = Double.parseDouble(lblDcResult.getText().replaceAll(",", "."));
            p.fc = Double.parseDouble(txtFcEst.getText());
            p.calculo();
            vs = String.format("%.2f", p.retornoVS);
            lblVsRetorno.setText(vs);

        }

    }
    // o metodo abaixo calcula o duplo produto

    public void calculoduploProd() {
        String dp;
        if (cmbDpCalculo.getSelectedItem().equals("Hellertein et all Homens e Mulheres Geral (1978)")) {

            CalculoDuploProduto p = new CalculoDuploProduto();
            p.fcmax = Double.parseDouble(txtFcEst.getText().replaceAll(",", "."));
            p.pas = Double.parseDouble(txtPasEsf.getText());
            p.calculo();
            dp = String.format("%.0f", p.retorno);
            lblDpRetorno.setText(dp);

        }
    }

    public void calculoMivo2() {
        String mivo;
        if (cmbMivoCalculo.getSelectedItem().equals("Hellertein et all Homens e Mulheres Geral (1978)")) {

            CalculoMivo p = new CalculoMivo();
            p.dp = Double.parseDouble(lblDpRetorno.getText().replaceAll(",", "."));
            p.calculo();
            mivo = String.format("%.0f", p.retorno);
            lblMivoRetorno.setText(mivo);

        }
    }

    public TelaAvaHemo() {
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
        txtHemoEsta = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnHemCalcImc = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblHemoIMC = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblHemoResuImc = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHemoGrau = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtHemoIdade = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtHemoPeso = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtPasRep = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtPadRep = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPasEsf = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtPadEsf = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmbFcCalculo = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        btnCalculoFc = new javax.swing.JButton();
        txtFcRep = new javax.swing.JTextField();
        txtFcEst = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtVo2 = new javax.swing.JTextField();
        btnAnaSalvar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        cmbDcCalculo = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        btnCalculoDebito = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        lblDcResult = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        cmbVsCalculo = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        btnCalculoDebito1 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        lblVsRetorno = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        cmbDpCalculo = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        btnCalculoDebito2 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        lblDpRetorno = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        cmbMivoCalculo = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        btnCalculoDebito3 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        lblMivoRetorno = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 247, 241));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Parâmetros Hemodinâmicos");
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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Estatura e Peso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        try {
            txtHemoEsta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHemoEsta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHemoEsta.setText("");
        txtHemoEsta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHemoEsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHemoEstaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Estatura");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Peso");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("cm");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("kg");

        btnHemCalcImc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHemCalcImc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/piza15x15.png"))); // NOI18N
        btnHemCalcImc.setText("Calcular");
        btnHemCalcImc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHemCalcImcActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 247, 241));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "IMC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        lblHemoIMC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHemoIMC.setText("00.0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Classificação");

        lblHemoResuImc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHemoResuImc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHemoResuImc.setText("RESULTADO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Grau de Obesidade");

        lblHemoGrau.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHemoGrau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHemoGrau.setText("RESULTADO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHemoGrau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHemoIMC, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblHemoResuImc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblHemoIMC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHemoResuImc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHemoGrau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Idade");

        txtHemoIdade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHemoIdade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHemoIdade.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Anos");

        txtHemoPeso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHemoPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHemoIdade)
                            .addComponent(txtHemoPeso, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHemoEsta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnHemCalcImc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtHemoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtHemoEsta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtHemoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHemCalcImc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 247, 241));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Parâmetros Hemodinâmicos PRÉ-TESTAGEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 247, 241));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Pressão Arterial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        txtPasRep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPasRep.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("PAS");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("PAD");

        txtPadRep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPadRep.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("mmhg");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("mmhg");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("REPOUSO");

        txtPasEsf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPasEsf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("PAS");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("PAD");

        txtPadEsf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPadEsf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("mmhg");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("mmhg");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ESFORÇO");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtPadRep, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtPasRep, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtPasEsf, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPadEsf, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPasRep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPadRep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPasEsf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPadEsf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 247, 241));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Frequencia Cardíaca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Freq. Cardiaca Max.");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Freq. Cardiaca Rep.");

        cmbFcCalculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbFcCalculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Karvonen Homens e Mulheres (1957)", "Shefield Homens e Mulheres Não Atletas (1965)", "Shefield Homens e Mulheres Atletas (1965)", "Jones  Homens e Mulheres (1975)", "ACMS Homens e Mulheres (1995)" }));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Protocolo");

        btnCalculoFc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalculoFc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/piza15x15.png"))); // NOI18N
        btnCalculoFc.setText("Calcular");
        btnCalculoFc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoFcActionPerformed(evt);
            }
        });

        txtFcRep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFcRep.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtFcEst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFcEst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("bpm");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("bpm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFcCalculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFcRep, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(txtFcEst))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalculoFc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFcRep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFcEst, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculoFc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFcCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 247, 241));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Volume de Oxigênio - Fluxometria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("VO²max = ");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("mL/kg·min¹");

        txtVo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtVo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVo2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVo2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAnaSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnAnaSalvar.setText("Salvar e Avançar");
        btnAnaSalvar.setAlignmentX(1.0F);
        btnAnaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaSalvarActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 247, 241));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Parâmetros Hemodinâmicos PÓS-TESTAGEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 102, 0))); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 247, 241));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Débito Cardíaco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbDcCalculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDcCalculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Falkner Homens e Mulheres Não Atleta Menor de 40 anos (1977)", "Falkner Homens e Mulheres Atleta Maior de 40 anos (1977)", "Falkner Homens e Mulheres Atletas (1977)", "Hossack Homens (1980)", "Hossack Mulheres (1980)" }));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Protocolo");

        btnCalculoDebito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalculoDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/piza15x15.png"))); // NOI18N
        btnCalculoDebito.setText("Calcular");
        btnCalculoDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoDebitoActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Débto Cardíaco = ");

        lblDcResult.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDcResult.setText("00,00");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("l/min");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDcCalculo, 0, 536, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDcResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDcCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDcResult, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 247, 241));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Volúme Sistólico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbVsCalculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbVsCalculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wilmore & Norton Homens e Mulheres Geral (1975)" }));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Protocolo");

        btnCalculoDebito1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalculoDebito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/piza15x15.png"))); // NOI18N
        btnCalculoDebito1.setText("Calcular");
        btnCalculoDebito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoDebito1ActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Volúme Sistólico = ");

        lblVsRetorno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblVsRetorno.setText("00,00");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("ml/bpm");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbVsCalculo, 0, 536, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVsRetorno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculoDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVsCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVsRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculoDebito1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 247, 241));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Duplo Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbDpCalculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbDpCalculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hellertein et all Homens e Mulheres Geral (1978)" }));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Protocolo");

        btnCalculoDebito2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalculoDebito2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/piza15x15.png"))); // NOI18N
        btnCalculoDebito2.setText("Calcular");
        btnCalculoDebito2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoDebito2ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Duplo Produto =");

        lblDpRetorno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDpRetorno.setText("00");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("mmhg");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDpCalculo, 0, 536, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDpRetorno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculoDebito2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDpCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDpRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculoDebito2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 247, 241));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Consumo de Oxigênio do Miocardio MIVO²max", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbMivoCalculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbMivoCalculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hellertein et all Homens e Mulheres Geral (1978)" }));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Protocolo");

        btnCalculoDebito3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalculoDebito3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/piza15x15.png"))); // NOI18N
        btnCalculoDebito3.setText("Calcular");
        btnCalculoDebito3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoDebito3ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("MIVO²max = ");

        lblMivoRetorno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMivoRetorno.setText("00,00");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("ml");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMivoCalculo, 0, 536, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMivoRetorno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculoDebito3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMivoCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMivoRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculoDebito3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/pessoas.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAnaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setBounds(0, 0, 1071, 656);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaSalvarActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Concluiu todo o questionário?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            incluiranamnese();
            telaAvaHemo = null;
            TelaAvaHemo.this.dispose();//metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_btnAnaSalvarActionPerformed

    private void btnHemCalcImcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHemCalcImcActionPerformed
        if ((txtHemoEsta.getText().equals(" .  ")) || (txtHemoPeso.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe 'Altura' e 'Peso'!");
            return;
        } else {
            calculoimc();
        }
    }//GEN-LAST:event_btnHemCalcImcActionPerformed

    private void btnCalculoFcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoFcActionPerformed
        if (txtFcRep.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a 'Frequência Cardíaca'!");
            return;
        } else {
            calcularfc();
        }
    }//GEN-LAST:event_btnCalculoFcActionPerformed

    private void btnCalculoDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoDebitoActionPerformed
        if (txtHemoPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Peso é necessário para esse cálculo!");
            return;
        }
        if ((txtVo2.getText().isEmpty())||txtVo2.getText().equals("00,00")) {
            JOptionPane.showMessageDialog(null, "O VO²max deve ser obtido antes!");
            return;
        }

        debitocardiaco();

    }//GEN-LAST:event_btnCalculoDebitoActionPerformed

    private void btnCalculoDebito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoDebito1ActionPerformed
        if (lblDcResult.getText().equals("00,00")) {
            JOptionPane.showMessageDialog(null, "O Débito Cardíaco deve ser calculado antes!");
            return;
        }
        if (txtFcEst.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A Frequência cardíaca Máxima deve ser Informada!");
            return;
        }

        calculovolsist();
    }//GEN-LAST:event_btnCalculoDebito1ActionPerformed

    private void btnCalculoDebito2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoDebito2ActionPerformed
        if (txtFcEst.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A Frequência cardiaca máxima deve ser informada");
            return;
        }
        if (txtPasEsf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A PAS de Esforço deve ser informada!");
            return;
        }

        calculoduploProd();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalculoDebito2ActionPerformed

    private void btnCalculoDebito3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoDebito3ActionPerformed
        if (lblDpRetorno.getText().equals("00")) {
            JOptionPane.showMessageDialog(null, "O Duplo Produto deve ser calculado primeiro!");
            return;
        }
        calculoMivo2();
    }//GEN-LAST:event_btnCalculoDebito3ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
            int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaHemo = null;
            TelaAvaHemo.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void txtHemoEstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHemoEstaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHemoEstaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaSalvar;
    private javax.swing.JButton btnCalculoDebito;
    private javax.swing.JButton btnCalculoDebito1;
    private javax.swing.JButton btnCalculoDebito2;
    private javax.swing.JButton btnCalculoDebito3;
    private javax.swing.JButton btnCalculoFc;
    private javax.swing.JButton btnHemCalcImc;
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
    public static javax.swing.JComboBox<String> cmbDcCalculo;
    public static javax.swing.JComboBox<String> cmbDpCalculo;
    public static javax.swing.JComboBox<String> cmbFcCalculo;
    public static javax.swing.JComboBox<String> cmbMivoCalculo;
    public static javax.swing.JComboBox<String> cmbVsCalculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JLabel lblDcResult;
    public static javax.swing.JLabel lblDpRetorno;
    public static javax.swing.JLabel lblHemoGrau;
    public static javax.swing.JLabel lblHemoIMC;
    public static javax.swing.JLabel lblHemoResuImc;
    public static javax.swing.JLabel lblMivoRetorno;
    public static javax.swing.JLabel lblVsRetorno;
    public static javax.swing.JTextField txtFcEst;
    public static javax.swing.JTextField txtFcRep;
    public static javax.swing.JFormattedTextField txtHemoEsta;
    public static javax.swing.JTextField txtHemoIdade;
    public static javax.swing.JTextField txtHemoPeso;
    public static javax.swing.JTextField txtPadEsf;
    public static javax.swing.JTextField txtPadRep;
    public static javax.swing.JTextField txtPasEsf;
    public static javax.swing.JTextField txtPasRep;
    public static javax.swing.JTextField txtVo2;
    // End of variables declaration//GEN-END:variables
}
