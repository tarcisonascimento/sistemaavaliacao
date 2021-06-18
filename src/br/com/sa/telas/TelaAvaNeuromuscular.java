package br.com.sa.telas;

import br.com.sa.classes.CalculoNeuromuscular;
import br.com.sa.classes.DescricaoProtocolos;
import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import java.awt.Color;

public class TelaAvaNeuromuscular extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    //variaveis de informaçoes importantes do cliente
    public String sexo;
    public double peso, estatura, idade;
    
    
     //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAvaNeuromuscular telaAvaNeuromuscular;
    
    public static TelaAvaNeuromuscular getInstancia(){
        if (telaAvaNeuromuscular == null){
            
            telaAvaNeuromuscular = new TelaAvaNeuromuscular();

        }
        return telaAvaNeuromuscular;
    }
    

    public void buscadados() {

        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaModuloAva.lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                sexo = rs.getString(56);
                idade = Double.parseDouble(rs.getString(58).replaceAll(",", "."));
                estatura = Double.parseDouble(rs.getString(50).replaceAll(",", "."));
                peso = Double.parseDouble(rs.getString(49).replaceAll(",", "."));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }
    
    public void incluirneuro () {
    
        String sql = "update avaliacao1 set neuro01=?,neuro02=?,neuro03=?,neuro04=?,neuro05=?,neuro06=?,neuro07=?,neuro08=?,neuro09=?,neuro10=?,neuro11=?,neuro12=?,neuro13=?,neuro14=?,neuro15=?,neuro16=?,neuro17=?,neuro18=?,neuro19=?,neuro20=?,neuro21=?,neuro22=?,neuro23=?,neuro24=?,neuro25=?,neuro26=?,neuro27=? where idava=?";
        
        try {
            
            pst = conexao.prepareStatement(sql);
            
            pst.setString(1, cmbIsoAbs.getSelectedItem().toString());
            pst.setString(2, txtIsoAbs.getText());
            pst.setString(3, lblIsoAbs.getText());
            pst.setString(4, cmbIsoBraco.getSelectedItem().toString());
            pst.setString(5, txtIsoBraco.getText());
            pst.setString(6, lblIsoBraco.getText());
            pst.setString(7, cmbIsoPeito.getSelectedItem().toString());
            pst.setString(8, txtIsoPeito.getText());
            pst.setString(9, lblIsoPeito.getText());
            pst.setString(10, cmbIsoPerna.getSelectedItem().toString());
            pst.setString(11, txtIsoPerna.getText());
            pst.setString(12, lblIsoPerna.getText());
            pst.setString(13, cmbExpBraco.getSelectedItem().toString());
            pst.setString(14, txtExpBraco.getText());
            pst.setString(15, lblExpBraco.getText());
            pst.setString(16, cmbExpVert.getSelectedItem().toString());
            pst.setString(17, txtExpVert.getText());
            pst.setString(18, lblExpVert.getText());
            pst.setString(19, cmbExpHoriz.getSelectedItem().toString());
            pst.setString(20, txtExpHoriz.getText());
            pst.setString(21, lblExpHoriz.getText());
            pst.setString(22, cmbMetSup.getSelectedItem().toString());
            pst.setString(23, txtMetSup.getText());
            pst.setString(24, lblMetSup.getText());
            pst.setString(25, cmbMetDors.getSelectedItem().toString());
            pst.setString(26, txtMetDors.getText());
            pst.setString(27, lblMetDors.getText());
            pst.setString(28, TelaModuloAva.lblIdAva.getText());

            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Informações Inseridas com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Ao incluir dados no banco\n" + e);
            
        }
    
    
    
    
    
    
    }
    

    public void desativacamposiso01() {

        txtIsoAbs.setEnabled(false);
        txtIsoAbs.setBackground(new Color(240, 240, 240));
        txtIsoAbs.setText(null);
        lblIsoAbs.setText("Não calculado");
        btnCalc1.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposiso02() {

        txtIsoBraco.setEnabled(false);
        txtIsoBraco.setBackground(new Color(240, 240, 240));
        txtIsoBraco.setText(null);
        lblIsoBraco.setText("Não calculado");
        btnCalc2.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposiso03() {

        txtIsoPeito.setEnabled(false);
        txtIsoPeito.setBackground(new Color(240, 240, 240));
        txtIsoPeito.setText(null);
        lblIsoPeito.setText("Não calculado");
        btnCalc3.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposiso04() {

        txtIsoPerna.setEnabled(false);
        txtIsoPerna.setBackground(new Color(240, 240, 240));
        txtIsoPerna.setText(null);
        lblIsoPerna.setText("Não calculado");
        btnCalc4.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposexplo01() {

        txtExpBraco.setEnabled(false);
        txtExpBraco.setBackground(new Color(240, 240, 240));
        txtExpBraco.setText(null);
        lblExpBraco.setText("Não calculado");
        btnCalc5.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposexplo02() {

        txtExpVert.setEnabled(false);
        txtExpVert.setBackground(new Color(240, 240, 240));
        txtExpVert.setText(null);
        lblExpVert.setText("Não calculado");
        btnCalc6.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposexplo03() {

        txtExpHoriz.setEnabled(false);
        txtExpHoriz.setBackground(new Color(240, 240, 240));
        txtExpHoriz.setText(null);
        lblExpHoriz.setText("Não calculado");
        btnCalc7.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposmet01() {

        txtMetDors.setEnabled(false);
        txtMetDors.setBackground(new Color(240, 240, 240));
        txtMetDors.setText(null);
        lblMetDors.setText("Não calculado");
        btnCalc9.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void desativacamposmet02() {

        txtMetSup.setEnabled(false);
        txtMetSup.setBackground(new Color(240, 240, 240));
        txtMetSup.setText(null);
        lblMetSup.setText("Não calculado");
        btnCalc8.setEnabled(false);
        txtObjetivo.setText(null);
        txtMaterial.setText(null);
        txtExecucao.setText(null);
        txtOrientacoes.setText(null);

    }

    public void isoabs01() {
        if (txtIsoAbs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de repetições!");

        } else {
            //Protocolo da AAHPER - Teste de flexão do tronco (abdominal)
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.quantidade = Integer.parseInt(txtIsoAbs.getText());
            calc.ahper01abs();
            lblIsoAbs.setText(calc.classifica);
        }
    }

    public void isoabs02() {
        if (txtIsoAbs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de repetições!");

        } else {
            //Protocolo de Robertson - Teste de flexão do tronco (abdominal)
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.quantidade = Integer.parseInt(txtIsoAbs.getText());
            calc.robertson01abs();
            lblIsoAbs.setText(calc.classifica);
        }
    }

    public void isoabs03() {
        if (txtIsoAbs.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de repetições!");

        } else {
            //Prototocolo de Sidnei & Jeté - Teste de flexão do tronco (abdominal)
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.quantidade = Integer.parseInt(txtIsoAbs.getText());
            calc.sidinei01abs();
            lblIsoAbs.setText(calc.classifica);
        }
    }

    public void isobraco01() {
        if (txtIsoBraco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de repetições!");

        } else {
            //Protocolo de Mathews - Teste de elevação vertical (barra)
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.quantidade = Integer.parseInt(txtIsoBraco.getText());
            calc.mathews01eleva();
            lblIsoBraco.setText(calc.classifica);
        }
    }

    public void isopeito01() {
        if (txtIsoPeito.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de repetições!");

        } else {
            //Protocolo da Eurofit - Flexão de Braços
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.quantidade = Integer.parseInt(txtIsoPeito.getText());
            calc.eurofit01brac();
            lblIsoPeito.setText(calc.classifica);
        }
    }

    public void isoperna01() {
        if (txtIsoPerna.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de repetições!");

        } else {
            //Protocolo de Almeida - Teste de extensão de pernas (agachamento)
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.quantidade = Integer.parseInt(txtIsoPerna.getText());
            calc.almeida01perna();
            lblIsoPerna.setText(calc.classifica);
        }
    }

    public void expobraco01() {
        if (txtExpBraco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a distância em metros!\n Ex: 2,23");

        } else {
            //Protocolo de Johonson & Nelson - Teste de lançar a bola
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.distancia = Double.parseDouble(txtExpBraco.getText().replaceAll(",", "."));
            calc.johnson01bola();
            lblExpBraco.setText(calc.classifica);
        }
    }

    public void expovert01() {
        if (txtExpVert.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a altura do salto em centimetros!\n Ex: 65");

        } else {
            //Protocolo de Johonson & Nelson - Teste de salto vertical
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.distancia = Double.parseDouble(txtExpVert.getText().replaceAll(",", "."));
            calc.johnson02saltovert();
            lblExpVert.setText(calc.classifica);
        }
    }

    public void expohoriz01() {
        if (txtExpHoriz.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a distância do salto em metros!\nEx: 1,26");

        } else {
            //Protocolo de Johonson & Nelson - Teste de salto Horizontal
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.distancia = Double.parseDouble(txtExpHoriz.getText().replaceAll(",", "."));
            calc.johnson02saltohori();
            lblExpHoriz.setText(calc.classifica);
        }
    }

    public void metsup01() {
        if (txtMetSup.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o tempo com minutos e segundos!\nEx: 00:48");

        } else {
            //Protocolo da Eurofit - Teste de sustentação vertical
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.tempo = Double.parseDouble(txtMetSup.getText().replaceAll(":", "."));
            calc.eurofit02suste();
            lblMetSup.setText(calc.classifica);
        }
    }

    public void metdor01() {
        if (txtMetDors.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o resultado em centímetros!\nEx: 115");

        } else {
            //Protocolo de Johnson & Nelson - Teste de hiper-extensão
            //padrao
            CalculoNeuromuscular calc = new CalculoNeuromuscular();
            calc.idade = idade;
            calc.sexo = sexo;
            calc.peso = peso;
            calc.estatura = estatura;
            //fim padrao
            calc.distancia = Double.parseDouble(txtMetDors.getText().replaceAll(",", "."));
            calc.johnson03hiperextensao();
            lblMetDors.setText(calc.classifica);
        }
    }

    public TelaAvaNeuromuscular() {
        initComponents();
        conexao = ModuloConexao.conector();//devese iniciar a conexao sempre pelo construtor antes de realizar uma consulta
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObjetivo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMaterial = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOrientacoes = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtExecucao = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        cmbIsoAbs = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtIsoAbs = new javax.swing.JTextField();
        btnCalc1 = new javax.swing.JButton();
        cmbIsoBraco = new javax.swing.JComboBox<>();
        txtIsoBraco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnCalc2 = new javax.swing.JButton();
        cmbIsoPeito = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtIsoPeito = new javax.swing.JTextField();
        btnCalc3 = new javax.swing.JButton();
        cmbIsoPerna = new javax.swing.JComboBox<>();
        txtIsoPerna = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnCalc4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cmbExpBraco = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtExpBraco = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblExpBraco = new javax.swing.JLabel();
        btnCalc5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cmbExpVert = new javax.swing.JComboBox<>();
        txtExpVert = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lblExpVert = new javax.swing.JLabel();
        btnCalc6 = new javax.swing.JButton();
        cmbExpHoriz = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtExpHoriz = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lblExpHoriz = new javax.swing.JLabel();
        btnCalc7 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cmbMetSup = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblMetSup = new javax.swing.JLabel();
        btnCalc8 = new javax.swing.JButton();
        txtMetSup = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cmbMetDors = new javax.swing.JComboBox<>();
        btnCalc9 = new javax.swing.JButton();
        lblMetDors = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtMetDors = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnMedSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIsoAbs = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        lblIsoBraco = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        lblIsoPeito = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        lblIsoPerna = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 247, 241));
        setTitle("Parametros Neuromusculares");
        getContentPane().setLayout(null);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Orientações para execução dos protocolos"));

        txtObjetivo.setEditable(false);
        txtObjetivo.setBackground(new java.awt.Color(214, 217, 223));
        txtObjetivo.setColumns(20);
        txtObjetivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtObjetivo.setLineWrap(true);
        txtObjetivo.setRows(3);
        txtObjetivo.setWrapStyleWord(true);
        txtObjetivo.setAutoscrolls(false);
        txtObjetivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Objetivo"));
        txtObjetivo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtObjetivo.setEnabled(false);
        txtObjetivo.setKeymap(null);
        txtObjetivo.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtObjetivo.setOpaque(false);
        jScrollPane2.setViewportView(txtObjetivo);

        txtMaterial.setEditable(false);
        txtMaterial.setBackground(new java.awt.Color(214, 217, 223));
        txtMaterial.setColumns(20);
        txtMaterial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMaterial.setLineWrap(true);
        txtMaterial.setRows(3);
        txtMaterial.setWrapStyleWord(true);
        txtMaterial.setAutoscrolls(false);
        txtMaterial.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Material Necessário"));
        txtMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setEnabled(false);
        txtMaterial.setKeymap(null);
        txtMaterial.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtMaterial.setOpaque(false);
        jScrollPane1.setViewportView(txtMaterial);

        txtOrientacoes.setEditable(false);
        txtOrientacoes.setBackground(new java.awt.Color(214, 217, 223));
        txtOrientacoes.setColumns(20);
        txtOrientacoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtOrientacoes.setLineWrap(true);
        txtOrientacoes.setRows(3);
        txtOrientacoes.setToolTipText("");
        txtOrientacoes.setWrapStyleWord(true);
        txtOrientacoes.setAutoscrolls(false);
        txtOrientacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Orientações ao Avaliando"));
        txtOrientacoes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtOrientacoes.setEnabled(false);
        txtOrientacoes.setKeymap(null);
        txtOrientacoes.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtOrientacoes.setOpaque(false);
        jScrollPane4.setViewportView(txtOrientacoes);

        txtExecucao.setEditable(false);
        txtExecucao.setBackground(new java.awt.Color(214, 217, 223));
        txtExecucao.setColumns(20);
        txtExecucao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtExecucao.setLineWrap(true);
        txtExecucao.setRows(3);
        txtExecucao.setWrapStyleWord(true);
        txtExecucao.setAutoscrolls(false);
        txtExecucao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Procedimentos para Excecução"));
        txtExecucao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtExecucao.setEnabled(false);
        txtExecucao.setKeymap(null);
        txtExecucao.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtExecucao.setOpaque(false);
        jScrollPane5.setViewportView(txtExecucao);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane5)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel11);
        jPanel11.setBounds(2073, 11, 331, 585);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Testes de Força Isotônica"));

        cmbIsoAbs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo da AAHPER - Teste de flexão do tronco (abdominal)", "Protocolo de Robertson - Teste de flexão do tronco (abdominal)", "Prototocolo de Sidnei & Jeté - Teste de flexão do tronco (abdominal)" }));
        cmbIsoAbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoAbsActionPerformed(evt);
            }
        });

        jLabel1.setText("Resultado:");

        txtIsoAbs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoAbs.setEnabled(false);

        btnCalc1.setText("Calcular");
        btnCalc1.setEnabled(false);
        btnCalc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc1ActionPerformed(evt);
            }
        });

        cmbIsoBraco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Mathews - Teste de elevação vertical (barra)" }));
        cmbIsoBraco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoBracoActionPerformed(evt);
            }
        });

        txtIsoBraco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoBraco.setEnabled(false);

        jLabel10.setText("Resultado:");

        btnCalc2.setText("Calcular");
        btnCalc2.setEnabled(false);
        btnCalc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc2ActionPerformed(evt);
            }
        });

        cmbIsoPeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo da Eurofit - Flexão de Braços" }));
        cmbIsoPeito.setPreferredSize(new java.awt.Dimension(398, 20));
        cmbIsoPeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoPeitoActionPerformed(evt);
            }
        });

        jLabel7.setText("Resultado:");

        txtIsoPeito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoPeito.setEnabled(false);

        btnCalc3.setText("Calcular");
        btnCalc3.setEnabled(false);
        btnCalc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc3ActionPerformed(evt);
            }
        });

        cmbIsoPerna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Almeida - Teste de extensão de pernas (agachamento)" }));
        cmbIsoPerna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoPernaActionPerformed(evt);
            }
        });

        txtIsoPerna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoPerna.setEnabled(false);

        jLabel13.setText("Resultado:");

        btnCalc4.setText("Calcular");
        btnCalc4.setEnabled(false);
        btnCalc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Abdominal");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Braços");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Braços e Peito");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Pernas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIsoAbs, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIsoPeito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIsoBraco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalc3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalc1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalc2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalc4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbIsoPeito, 0, 405, Short.MAX_VALUE)
                            .addComponent(cmbIsoBraco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbIsoAbs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIsoPerna, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(348, 348, 348))
                            .addComponent(cmbIsoPerna, 0, 404, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsoAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnCalc1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoBraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsoBraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnCalc2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoPeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsoPeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnCalc3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoPerna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsoPerna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnCalc4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(692, 26, 539, 262);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Testes de Força Explosiva"));

        cmbExpBraco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johonson & Nelson - Teste de lançar a bola" }));
        cmbExpBraco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExpBracoActionPerformed(evt);
            }
        });

        jLabel16.setText("Arremeço:");

        txtExpBraco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExpBraco.setEnabled(false);

        jLabel17.setText("Classificação:");

        lblExpBraco.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblExpBraco.setText("Não calculado");

        btnCalc5.setText("Calcular");
        btnCalc5.setEnabled(false);
        btnCalc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc5ActionPerformed(evt);
            }
        });

        jLabel19.setText("Altura do Salto:");

        cmbExpVert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johonson & Nelson - Teste de salto vertical" }));
        cmbExpVert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExpVertActionPerformed(evt);
            }
        });

        txtExpVert.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExpVert.setEnabled(false);

        jLabel20.setText("Classificação:");

        lblExpVert.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblExpVert.setText("Não calculado");

        btnCalc6.setText("Calcular");
        btnCalc6.setEnabled(false);
        btnCalc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc6ActionPerformed(evt);
            }
        });

        cmbExpHoriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johonson & Nelson - Teste de salto horizontal" }));
        cmbExpHoriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExpHorizActionPerformed(evt);
            }
        });

        jLabel22.setText("Distância do Salto:");

        txtExpHoriz.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExpHoriz.setEnabled(false);

        jLabel23.setText("Classificação:");

        lblExpHoriz.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblExpHoriz.setText("Não calculado");

        btnCalc7.setText("Calcular");
        btnCalc7.setEnabled(false);
        btnCalc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc7ActionPerformed(evt);
            }
        });

        jLabel28.setText("m");

        jLabel29.setText("cm");

        jLabel30.setText("m");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Braços");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Impulso Vertical");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Impulso Horizontal");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCalc5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtExpVert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCalc6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbExpVert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtExpHoriz, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(lblExpVert, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(lblExpHoriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCalc7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(cmbExpHoriz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(lblExpBraco)
                    .addComponent(btnCalc5)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExpVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(lblExpVert)
                    .addComponent(btnCalc6)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExpHoriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpHoriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(lblExpHoriz)
                    .addComponent(btnCalc7)
                    .addComponent(jLabel30)))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(692, 312, 539, 181);

        jPanel7.setBackground(new java.awt.Color(255, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Teste de Força Isométrica"));

        cmbMetSup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo da Eurofit - Teste de sustentação vertical" }));
        cmbMetSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetSupActionPerformed(evt);
            }
        });

        jLabel25.setText("Tempo:");

        jLabel26.setText("Classificação:");

        lblMetSup.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMetSup.setText("Não calculado");

        btnCalc8.setText("Calcular");
        btnCalc8.setEnabled(false);
        btnCalc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc8ActionPerformed(evt);
            }
        });

        txtMetSup.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtMetSup.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMetSup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMetSup.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Membro Superior");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Inferior e Dorsal");

        cmbMetDors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johnson & Nelson - Teste de hiper-extensão" }));
        cmbMetDors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetDorsActionPerformed(evt);
            }
        });

        btnCalc9.setText("Calcular");
        btnCalc9.setEnabled(false);
        btnCalc9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc9ActionPerformed(evt);
            }
        });

        lblMetDors.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMetDors.setText("Não calculado");

        jLabel38.setText("Classificação:");

        jLabel39.setText("Centímetros:");

        txtMetDors.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMetDors.setEnabled(false);

        jLabel45.setText("cm");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMetDors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMetDors, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel26))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel38)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMetDors, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalc8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalc9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(lblMetSup)
                    .addComponent(btnCalc8)
                    .addComponent(txtMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMetDors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(lblMetDors)
                    .addComponent(btnCalc9)
                    .addComponent(txtMetDors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(520, 510, 539, 130);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(2720, 602, 109, 39);

        btnMedSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnMedSalvar.setText("Salvar e Avançar");
        btnMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedSalvar);
        btnMedSalvar.setBounds(2835, 602, 149, 39);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/abdomem60x60.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 30, 60, 51);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Classificação:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 40, 90, 17);

        lblIsoAbs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoAbs.setForeground(new java.awt.Color(255, 153, 0));
        lblIsoAbs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoAbs.setText("Não calculado");
        getContentPane().add(lblIsoAbs);
        lblIsoAbs.setBounds(550, 40, 131, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Abdominal");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(460, 10, 200, 22);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/circulo100x100.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(330, 10, 100, 100);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/abdomem20x20.png"))); // NOI18N
        jButton1.setText("Testar");
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 60, 200, 29);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/barrafixa50x72.png"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(350, 120, 50, 80);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Barra Fixa");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(440, 110, 200, 22);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/circulo100x100.png"))); // NOI18N
        getContentPane().add(jLabel24);
        jLabel24.setBounds(320, 110, 100, 100);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/barrafixa15x22.png"))); // NOI18N
        jButton3.setText("Testar");
        getContentPane().add(jButton3);
        jButton3.setBounds(440, 160, 200, 29);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(310, 210, 370, 2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Classificação:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(440, 140, 90, 17);

        lblIsoBraco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoBraco.setForeground(new java.awt.Color(255, 153, 0));
        lblIsoBraco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoBraco.setText("Não calculado");
        getContentPane().add(lblIsoBraco);
        lblIsoBraco.setBounds(530, 140, 120, 15);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(320, 110, 370, 2);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/flexao78x40.png"))); // NOI18N
        getContentPane().add(jLabel27);
        jLabel27.setBounds(310, 220, 90, 80);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Flexão de Braços");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(390, 210, 260, 22);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/circulo100x100.png"))); // NOI18N
        getContentPane().add(jLabel40);
        jLabel40.setBounds(300, 210, 100, 100);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/flexao25x13.png"))); // NOI18N
        jButton4.setText("Testar");
        getContentPane().add(jButton4);
        jButton4.setBounds(430, 260, 200, 29);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(290, 310, 370, 2);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Classificação:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(430, 240, 100, 17);

        lblIsoPeito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoPeito.setForeground(new java.awt.Color(255, 153, 0));
        lblIsoPeito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoPeito.setText("Não calculado");
        getContentPane().add(lblIsoPeito);
        lblIsoPeito.setBounds(520, 240, 120, 17);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/agachamento60x75.png"))); // NOI18N
        getContentPane().add(jLabel41);
        jLabel41.setBounds(320, 320, 60, 80);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Agachamento");
        getContentPane().add(jLabel42);
        jLabel42.setBounds(410, 310, 200, 22);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/circulo100x100.png"))); // NOI18N
        getContentPane().add(jLabel43);
        jLabel43.setBounds(290, 310, 100, 100);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/agachamento20x25.png"))); // NOI18N
        jButton5.setText("Testar");
        getContentPane().add(jButton5);
        jButton5.setBounds(410, 360, 200, 29);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(280, 410, 370, 2);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Classificação:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(420, 340, 120, 17);

        lblIsoPerna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoPerna.setForeground(new java.awt.Color(255, 153, 0));
        lblIsoPerna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoPerna.setText("Não calculado");
        getContentPane().add(lblIsoPerna);
        lblIsoPerna.setBounds(500, 340, 131, 17);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/fundoneuro256x640.png"))); // NOI18N
        getContentPane().add(jLabel44);
        jLabel44.setBounds(0, 0, 280, 640);

        setBounds(0, 0, 3000, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaNeuromuscular = null;
            TelaAvaNeuromuscular.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnMedSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSalvarActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Deseja Salvar as alterações?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            
            incluirneuro();
            telaAvaNeuromuscular = null;
            TelaAvaNeuromuscular.this.dispose();

        } else {

        }
    }//GEN-LAST:event_btnMedSalvarActionPerformed

    private void cmbIsoAbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIsoAbsActionPerformed
        if (cmbIsoAbs.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposiso01();

        }
        if (cmbIsoAbs.getSelectedItem().equals("Protocolo da AAHPER - Teste de flexão do tronco (abdominal)")) {
            desativacamposiso01();
            txtIsoAbs.setEnabled(true);
            txtIsoAbs.setBackground(new Color(255, 255, 255));
            btnCalc1.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }
        if (cmbIsoAbs.getSelectedItem().equals("Protocolo de Robertson - Teste de flexão do tronco (abdominal)")) {
            desativacamposiso01();
            txtIsoAbs.setEnabled(true);
            txtIsoAbs.setBackground(new Color(255, 255, 255));
            btnCalc1.setEnabled(true);
            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro02();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }
        if (cmbIsoAbs.getSelectedItem().equals("Prototocolo de Sidnei & Jeté - Teste de flexão do tronco (abdominal)")) {
            desativacamposiso01();
            txtIsoAbs.setEnabled(true);
            txtIsoAbs.setBackground(new Color(255, 255, 255));
            btnCalc1.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro03();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
        }


    }//GEN-LAST:event_cmbIsoAbsActionPerformed

    private void cmbIsoBracoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIsoBracoActionPerformed
        if (cmbIsoBraco.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposiso02();
        }
        if (cmbIsoBraco.getSelectedItem().equals("Protocolo de Mathews - Teste de elevação vertical (barra)")) {
            desativacamposiso02();
            txtIsoBraco.setEnabled(true);
            txtIsoBraco.setBackground(new Color(255, 255, 255));
            btnCalc2.setEnabled(true);
            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro05();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
        }
    }//GEN-LAST:event_cmbIsoBracoActionPerformed

    private void cmbIsoPeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIsoPeitoActionPerformed
        if (cmbIsoPeito.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposiso03();
        }
        if (cmbIsoPeito.getSelectedItem().equals("Protocolo da Eurofit - Flexão de Braços")) {
            desativacamposiso03();
            txtIsoPeito.setEnabled(true);
            txtIsoPeito.setBackground(new Color(255, 255, 255));
            btnCalc3.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro04();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }

    }//GEN-LAST:event_cmbIsoPeitoActionPerformed

    private void cmbIsoPernaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIsoPernaActionPerformed
        if (cmbIsoPerna.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposiso04();
        }
        if (cmbIsoPerna.getSelectedItem().equals("Protocolo de Almeida - Teste de extensão de pernas (agachamento)")) {
            desativacamposiso04();
            txtIsoPerna.setEnabled(true);
            txtIsoPerna.setBackground(new Color(255, 255, 255));
            btnCalc4.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro06();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }


    }//GEN-LAST:event_cmbIsoPernaActionPerformed

    private void btnCalc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc1ActionPerformed
        if (cmbIsoAbs.getSelectedItem().equals("Protocolo da AAHPER - Teste de flexão do tronco (abdominal)")) {
            buscadados();
            isoabs01();
        }
        if (cmbIsoAbs.getSelectedItem().equals("Protocolo de Robertson - Teste de flexão do tronco (abdominal)")) {
            buscadados();
            isoabs02();
        }
        if (cmbIsoAbs.getSelectedItem().equals("Prototocolo de Sidnei & Jeté - Teste de flexão do tronco (abdominal)")) {
            buscadados();
            isoabs03();
        }
    }//GEN-LAST:event_btnCalc1ActionPerformed

    private void btnCalc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc2ActionPerformed
        if (cmbIsoBraco.getSelectedItem().equals("Protocolo de Mathews - Teste de elevação vertical (barra)")) {
            buscadados();
            isobraco01();
        }
    }//GEN-LAST:event_btnCalc2ActionPerformed

    private void btnCalc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc3ActionPerformed
        if (cmbIsoPeito.getSelectedItem().equals("Protocolo da Eurofit - Flexão de Braços")) {
            buscadados();
            isopeito01();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnCalc3ActionPerformed

    private void btnCalc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc4ActionPerformed
        if (cmbIsoPerna.getSelectedItem().equals("Protocolo de Almeida - Teste de extensão de pernas (agachamento)")) {
            buscadados();
            isoperna01();
        }
    }//GEN-LAST:event_btnCalc4ActionPerformed

    private void cmbExpBracoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbExpBracoActionPerformed
        if (cmbExpBraco.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposexplo01();

        }
        if (cmbExpBraco.getSelectedItem().equals("Protocolo de Johonson & Nelson - Teste de lançar a bola")) {
            desativacamposexplo01();
            txtExpBraco.setEnabled(true);
            txtExpBraco.setBackground(new Color(255, 255, 255));
            btnCalc5.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro07();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }

    }//GEN-LAST:event_cmbExpBracoActionPerformed

    private void cmbExpVertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbExpVertActionPerformed
        if (cmbExpVert.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposexplo02();

        }
        if (cmbExpVert.getSelectedItem().equals("Protocolo de Johonson & Nelson - Teste de salto vertical")) {
            desativacamposexplo02();
            txtExpVert.setEnabled(true);
            txtExpVert.setBackground(new Color(255, 255, 255));
            btnCalc6.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro08();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
        }

    }//GEN-LAST:event_cmbExpVertActionPerformed

    private void cmbExpHorizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbExpHorizActionPerformed
        if (cmbExpHoriz.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposexplo03();

        }
        if (cmbExpHoriz.getSelectedItem().equals("Protocolo de Johonson & Nelson - Teste de salto horizontal")) {
            desativacamposexplo03();
            txtExpHoriz.setEnabled(true);
            txtExpHoriz.setBackground(new Color(255, 255, 255));
            btnCalc7.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro09();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
        }
    }//GEN-LAST:event_cmbExpHorizActionPerformed

    private void btnCalc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc5ActionPerformed
        if (cmbExpBraco.getSelectedItem().equals("Protocolo de Johonson & Nelson - Teste de lançar a bola")) {
            buscadados();
            expobraco01();
        }
    }//GEN-LAST:event_btnCalc5ActionPerformed

    private void btnCalc6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc6ActionPerformed
        if (cmbExpVert.getSelectedItem().equals("Protocolo de Johonson & Nelson - Teste de salto vertical")) {
            buscadados();
            expovert01();
        }
    }//GEN-LAST:event_btnCalc6ActionPerformed

    private void btnCalc7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc7ActionPerformed
        if (cmbExpHoriz.getSelectedItem().equals("Protocolo de Johonson & Nelson - Teste de salto horizontal")) {
            buscadados();
            expohoriz01();
        }
    }//GEN-LAST:event_btnCalc7ActionPerformed

    private void cmbMetSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetSupActionPerformed
        if (cmbMetSup.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposmet02();
        }
        if (cmbMetSup.getSelectedItem().equals("Protocolo da Eurofit - Teste de sustentação vertical")) {
            desativacamposmet02();
            txtMetSup.setEnabled(true);
            txtMetSup.setBackground(new Color(255, 255, 255));
            btnCalc8.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro10();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }
    }//GEN-LAST:event_cmbMetSupActionPerformed

    private void cmbMetDorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetDorsActionPerformed
        if (cmbMetDors.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposmet01();
        }
        if (cmbMetDors.getSelectedItem().equals("Protocolo de Johnson & Nelson - Teste de hiper-extensão")) {
            desativacamposmet01();
            txtMetDors.setEnabled(true);
            txtMetDors.setBackground(new Color(255, 255, 255));
            btnCalc9.setEnabled(true);

            //setando os campso dos objetivos
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.protneuro11();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);

        }
    }//GEN-LAST:event_cmbMetDorsActionPerformed

    private void btnCalc8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc8ActionPerformed
        if (cmbMetSup.getSelectedItem().equals("Protocolo da Eurofit - Teste de sustentação vertical")) {
            buscadados();
            metsup01();
        }
    }//GEN-LAST:event_btnCalc8ActionPerformed

    private void btnCalc9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalc9ActionPerformed
        if (cmbMetDors.getSelectedItem().equals("Protocolo de Johnson & Nelson - Teste de hiper-extensão")) {
            buscadados();
            metdor01();
        }
    }//GEN-LAST:event_btnCalc9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc1;
    private javax.swing.JButton btnCalc2;
    private javax.swing.JButton btnCalc3;
    private javax.swing.JButton btnCalc4;
    private javax.swing.JButton btnCalc5;
    private javax.swing.JButton btnCalc6;
    private javax.swing.JButton btnCalc7;
    private javax.swing.JButton btnCalc8;
    private javax.swing.JButton btnCalc9;
    public static javax.swing.JButton btnMedSalvar;
    public static javax.swing.JComboBox<String> cmbExpBraco;
    public static javax.swing.JComboBox<String> cmbExpHoriz;
    public static javax.swing.JComboBox<String> cmbExpVert;
    public static javax.swing.JComboBox<String> cmbIsoAbs;
    public static javax.swing.JComboBox<String> cmbIsoBraco;
    public static javax.swing.JComboBox<String> cmbIsoPeito;
    public static javax.swing.JComboBox<String> cmbIsoPerna;
    public static javax.swing.JComboBox<String> cmbMetDors;
    public static javax.swing.JComboBox<String> cmbMetSup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JLabel lblExpBraco;
    public static javax.swing.JLabel lblExpHoriz;
    public static javax.swing.JLabel lblExpVert;
    public static javax.swing.JLabel lblIsoAbs;
    public static javax.swing.JLabel lblIsoBraco;
    public static javax.swing.JLabel lblIsoPeito;
    public static javax.swing.JLabel lblIsoPerna;
    public static javax.swing.JLabel lblMetDors;
    public static javax.swing.JLabel lblMetSup;
    private javax.swing.JTextArea txtExecucao;
    public static javax.swing.JTextField txtExpBraco;
    public static javax.swing.JTextField txtExpHoriz;
    public static javax.swing.JTextField txtExpVert;
    public static javax.swing.JTextField txtIsoAbs;
    public static javax.swing.JTextField txtIsoBraco;
    public static javax.swing.JTextField txtIsoPeito;
    public static javax.swing.JTextField txtIsoPerna;
    private javax.swing.JTextArea txtMaterial;
    public static javax.swing.JTextField txtMetDors;
    public static javax.swing.JFormattedTextField txtMetSup;
    private javax.swing.JTextArea txtObjetivo;
    private javax.swing.JTextArea txtOrientacoes;
    // End of variables declaration//GEN-END:variables
}
