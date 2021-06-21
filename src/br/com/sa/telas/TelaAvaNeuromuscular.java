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

    public static TelaAvaNeuromuscular getInstancia() {
        if (telaAvaNeuromuscular == null) {

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

    public void incluirneuro() {

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
        cmbIsoBraco = new javax.swing.JComboBox<>();
        cmbIsoPeito = new javax.swing.JComboBox<>();
        cmbIsoPerna = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cmbExpBraco = new javax.swing.JComboBox<>();
        cmbExpVert = new javax.swing.JComboBox<>();
        cmbExpHoriz = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cmbMetSup = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cmbMetDors = new javax.swing.JComboBox<>();
        btnMedSalvar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        painelIsotonico = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblIsoAbs = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtIsoAbs = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblIsoBraco = new javax.swing.JLabel();
        txtIsoBraco = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblIsoPeito = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtIsoPeito = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lblIsoPerna = new javax.swing.JLabel();
        txtIsoPerna = new javax.swing.JTextField();
        btnCalc1 = new javax.swing.JButton();
        btnCalc2 = new javax.swing.JButton();
        btnCalc3 = new javax.swing.JButton();
        btnCalc4 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        painelIsometrico = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        txtMetSup = new javax.swing.JFormattedTextField();
        txtMetDors = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        lblMetSup = new javax.swing.JLabel();
        lblMetDors = new javax.swing.JLabel();
        btnCalc8 = new javax.swing.JButton();
        btnCalc9 = new javax.swing.JButton();
        painelExplosivo = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        txtExpBraco = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtExpVert = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtExpHoriz = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        lblExpBraco = new javax.swing.JLabel();
        lblExpVert = new javax.swing.JLabel();
        lblExpHoriz = new javax.swing.JLabel();
        btnCalc5 = new javax.swing.JButton();
        btnCalc6 = new javax.swing.JButton();
        btnCalc7 = new javax.swing.JButton();

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

        cmbIsoBraco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Mathews - Teste de elevação vertical (barra)" }));
        cmbIsoBraco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoBracoActionPerformed(evt);
            }
        });

        cmbIsoPeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo da Eurofit - Flexão de Braços" }));
        cmbIsoPeito.setPreferredSize(new java.awt.Dimension(398, 20));
        cmbIsoPeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoPeitoActionPerformed(evt);
            }
        });

        cmbIsoPerna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Almeida - Teste de extensão de pernas (agachamento)" }));
        cmbIsoPerna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIsoPernaActionPerformed(evt);
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
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIsoPeito, 0, 405, Short.MAX_VALUE)
                            .addComponent(cmbIsoBraco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbIsoAbs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIsoPerna, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoBraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoPeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbIsoPerna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1140, 20, 539, 226);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Testes de Força Explosiva"));

        cmbExpBraco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johonson & Nelson - Teste de lançar a bola" }));
        cmbExpBraco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExpBracoActionPerformed(evt);
            }
        });

        cmbExpVert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johonson & Nelson - Teste de salto vertical" }));
        cmbExpVert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExpVertActionPerformed(evt);
            }
        });

        cmbExpHoriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Johonson & Nelson - Teste de salto horizontal" }));
        cmbExpHoriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbExpHorizActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbExpVert, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbExpHoriz, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExpBraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExpVert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExpHoriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(1110, 250, 539, 181);

        jPanel7.setBackground(new java.awt.Color(255, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Teste de Força Isométrica"));

        cmbMetSup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo da Eurofit - Teste de sustentação vertical" }));
        cmbMetSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetSupActionPerformed(evt);
            }
        });

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
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMetSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMetDors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(1060, 450, 539, 130);

        btnMedSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnMedSalvar.setText("Salvar e Avançar");
        btnMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedSalvar);
        btnMedSalvar.setBounds(790, 590, 240, 39);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/abdomem20x20.png"))); // NOI18N
        jButton1.setText("Testar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 40, 200, 29);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/barrafixa15x22.png"))); // NOI18N
        jButton3.setText("Testar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(50, 120, 200, 29);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/flexao25x13.png"))); // NOI18N
        jButton4.setText("Testar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(50, 200, 200, 29);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 153));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Força Isotônica");
        getContentPane().add(jLabel46);
        jLabel46.setBounds(40, 10, 220, 17);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 51, 153));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Força Explosiva");
        getContentPane().add(jLabel47);
        jLabel47.setBounds(40, 90, 220, 17);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 51, 153));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Força Isométrica");
        getContentPane().add(jLabel48);
        jLabel48.setBounds(40, 170, 220, 17);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/fundoneuro256x640.png"))); // NOI18N
        getContentPane().add(jLabel44);
        jLabel44.setBounds(0, 0, 280, 640);

        painelIsotonico.setBackground(new java.awt.Color(255, 255, 255));
        painelIsotonico.setForeground(new java.awt.Color(0, 0, 102));
        painelIsotonico.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Resultado:");
        painelIsotonico.add(jLabel12);
        jLabel12.setBounds(20, 80, 65, 32);

        lblIsoAbs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoAbs.setForeground(new java.awt.Color(0, 0, 102));
        lblIsoAbs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoAbs.setText("Não calculado");
        painelIsotonico.add(lblIsoAbs);
        lblIsoAbs.setBounds(90, 120, 150, 32);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Classificação:");
        painelIsotonico.add(jLabel15);
        jLabel15.setBounds(10, 120, 79, 32);

        txtIsoAbs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIsoAbs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoAbs.setEnabled(false);
        painelIsotonico.add(txtIsoAbs);
        txtIsoAbs.setBounds(110, 80, 60, 32);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Resultado:");
        painelIsotonico.add(jLabel11);
        jLabel11.setBounds(20, 200, 65, 32);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Classificação:");
        painelIsotonico.add(jLabel18);
        jLabel18.setBounds(10, 240, 79, 32);

        lblIsoBraco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoBraco.setForeground(new java.awt.Color(0, 0, 102));
        lblIsoBraco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoBraco.setText("Não calculado");
        painelIsotonico.add(lblIsoBraco);
        lblIsoBraco.setBounds(90, 240, 150, 32);

        txtIsoBraco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIsoBraco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoBraco.setEnabled(false);
        painelIsotonico.add(txtIsoBraco);
        txtIsoBraco.setBounds(110, 200, 60, 32);

        jPanel4.setBackground(new java.awt.Color(0, 41, 103));

        jLabel24.setBackground(new java.awt.Color(0, 51, 204));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Barra Fixa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsotonico.add(jPanel4);
        jPanel4.setBounds(0, 160, 240, 30);

        jPanel5.setBackground(new java.awt.Color(0, 41, 103));

        jLabel27.setBackground(new java.awt.Color(0, 51, 204));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Flexão de Braços");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsotonico.add(jPanel5);
        jPanel5.setBounds(0, 280, 240, 30);

        lblIsoPeito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoPeito.setForeground(new java.awt.Color(0, 0, 102));
        lblIsoPeito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoPeito.setText("Não calculado");
        painelIsotonico.add(lblIsoPeito);
        lblIsoPeito.setBounds(90, 360, 150, 32);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("Classificação:");
        painelIsotonico.add(jLabel40);
        jLabel40.setBounds(10, 360, 79, 32);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("Resultado:");
        painelIsotonico.add(jLabel41);
        jLabel41.setBounds(20, 320, 65, 32);

        txtIsoPeito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIsoPeito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoPeito.setEnabled(false);
        painelIsotonico.add(txtIsoPeito);
        txtIsoPeito.setBounds(110, 320, 60, 32);

        jPanel3.setBackground(new java.awt.Color(0, 41, 103));

        jLabel9.setBackground(new java.awt.Color(0, 51, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Abdominal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsotonico.add(jPanel3);
        jPanel3.setBounds(0, 40, 240, 30);

        jPanel8.setBackground(new java.awt.Color(0, 41, 103));

        jLabel37.setBackground(new java.awt.Color(0, 51, 204));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Agachamento");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsotonico.add(jPanel8);
        jPanel8.setBounds(0, 400, 240, 30);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("Classificação:");
        painelIsotonico.add(jLabel43);
        jLabel43.setBounds(10, 480, 79, 32);

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("Resultado:");
        painelIsotonico.add(jLabel49);
        jLabel49.setBounds(20, 440, 65, 32);

        lblIsoPerna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIsoPerna.setForeground(new java.awt.Color(0, 0, 102));
        lblIsoPerna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsoPerna.setText("Não calculado");
        painelIsotonico.add(lblIsoPerna);
        lblIsoPerna.setBounds(90, 480, 150, 32);

        txtIsoPerna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIsoPerna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIsoPerna.setEnabled(false);
        painelIsotonico.add(txtIsoPerna);
        txtIsoPerna.setBounds(110, 440, 60, 32);

        btnCalc1.setText("OK");
        btnCalc1.setEnabled(false);
        btnCalc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc1ActionPerformed(evt);
            }
        });
        painelIsotonico.add(btnCalc1);
        btnCalc1.setBounds(180, 80, 50, 32);

        btnCalc2.setText("OK");
        btnCalc2.setEnabled(false);
        btnCalc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc2ActionPerformed(evt);
            }
        });
        painelIsotonico.add(btnCalc2);
        btnCalc2.setBounds(180, 200, 50, 32);

        btnCalc3.setText("OK");
        btnCalc3.setEnabled(false);
        btnCalc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc3ActionPerformed(evt);
            }
        });
        painelIsotonico.add(btnCalc3);
        btnCalc3.setBounds(180, 320, 50, 32);

        btnCalc4.setText("OK");
        btnCalc4.setEnabled(false);
        btnCalc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc4ActionPerformed(evt);
            }
        });
        painelIsotonico.add(btnCalc4);
        btnCalc4.setBounds(180, 440, 50, 32);

        jPanel20.setBackground(new java.awt.Color(0, 51, 51));

        jLabel71.setBackground(new java.awt.Color(0, 51, 204));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("TESTES DE FORÇA ISOTÔNICA");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsotonico.add(jPanel20);
        jPanel20.setBounds(0, 0, 240, 30);

        jPanel23.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        painelIsotonico.add(jPanel23);
        jPanel23.setBounds(0, 520, 240, 30);

        getContentPane().add(painelIsotonico);
        painelIsotonico.setBounds(270, 0, 240, 630);

        painelIsometrico.setBackground(new java.awt.Color(255, 255, 255));
        painelIsometrico.setForeground(new java.awt.Color(0, 0, 102));
        painelIsometrico.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Resultado:");
        painelIsometrico.add(jLabel14);
        jLabel14.setBounds(16, 80, 65, 32);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Classificação:");
        painelIsometrico.add(jLabel21);
        jLabel21.setBounds(6, 120, 79, 32);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Resultado:");
        painelIsometrico.add(jLabel42);
        jLabel42.setBounds(16, 200, 65, 32);

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("Classificação:");
        painelIsometrico.add(jLabel50);
        jLabel50.setBounds(6, 240, 79, 32);

        jPanel10.setBackground(new java.awt.Color(0, 41, 103));

        jLabel51.setBackground(new java.awt.Color(0, 51, 204));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Membros Inferiores");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsometrico.add(jPanel10);
        jPanel10.setBounds(0, 160, 240, 30);

        jPanel12.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        painelIsometrico.add(jPanel12);
        jPanel12.setBounds(0, 280, 240, 30);

        jPanel13.setBackground(new java.awt.Color(0, 41, 103));

        jLabel55.setBackground(new java.awt.Color(0, 51, 204));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Membros Superiores");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsometrico.add(jPanel13);
        jPanel13.setBounds(0, 40, 240, 30);

        jPanel22.setBackground(new java.awt.Color(0, 51, 51));

        jLabel73.setBackground(new java.awt.Color(0, 51, 204));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("TESTES DE FORÇA ISOMÉTRICA");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelIsometrico.add(jPanel22);
        jPanel22.setBounds(0, 0, 240, 30);

        txtMetSup.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtMetSup.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMetSup.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMetSup.setEnabled(false);
        painelIsometrico.add(txtMetSup);
        txtMetSup.setBounds(82, 80, 60, 32);

        txtMetDors.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMetDors.setEnabled(false);
        painelIsometrico.add(txtMetDors);
        txtMetDors.setBounds(82, 200, 60, 32);

        jLabel45.setText("m:s");
        painelIsometrico.add(jLabel45);
        jLabel45.setBounds(145, 100, 20, 14);

        jLabel68.setText("cm");
        painelIsometrico.add(jLabel68);
        jLabel68.setBounds(145, 220, 13, 14);

        lblMetSup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMetSup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMetSup.setText("Não calculado");
        painelIsometrico.add(lblMetSup);
        lblMetSup.setBounds(90, 120, 150, 32);

        lblMetDors.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMetDors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMetDors.setText("Não calculado");
        painelIsometrico.add(lblMetDors);
        lblMetDors.setBounds(80, 240, 160, 32);

        btnCalc8.setText("OK");
        btnCalc8.setEnabled(false);
        btnCalc8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc8ActionPerformed(evt);
            }
        });
        painelIsometrico.add(btnCalc8);
        btnCalc8.setBounds(170, 80, 60, 32);

        btnCalc9.setText("OK");
        btnCalc9.setEnabled(false);
        btnCalc9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc9ActionPerformed(evt);
            }
        });
        painelIsometrico.add(btnCalc9);
        btnCalc9.setBounds(170, 200, 60, 32);

        getContentPane().add(painelIsometrico);
        painelIsometrico.setBounds(790, 0, 240, 580);

        painelExplosivo.setBackground(new java.awt.Color(255, 255, 255));
        painelExplosivo.setForeground(new java.awt.Color(0, 0, 102));
        painelExplosivo.setLayout(null);

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Arremeço:");
        painelExplosivo.add(jLabel59);
        jLabel59.setBounds(22, 80, 64, 32);

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Classificação:");
        painelExplosivo.add(jLabel60);
        jLabel60.setBounds(10, 120, 79, 32);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Altura:");
        painelExplosivo.add(jLabel61);
        jLabel61.setBounds(48, 200, 40, 32);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Classificação:");
        painelExplosivo.add(jLabel62);
        jLabel62.setBounds(10, 240, 79, 32);

        jPanel16.setBackground(new java.awt.Color(0, 41, 103));

        jLabel63.setBackground(new java.awt.Color(0, 51, 204));
        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Impulso Vertical");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelExplosivo.add(jPanel16);
        jPanel16.setBounds(0, 160, 240, 30);

        jPanel17.setBackground(new java.awt.Color(0, 41, 103));

        jLabel64.setBackground(new java.awt.Color(0, 51, 204));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Impulso Horizontal");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelExplosivo.add(jPanel17);
        jPanel17.setBounds(0, 280, 240, 30);

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setText("Classificação:");
        painelExplosivo.add(jLabel65);
        jLabel65.setBounds(10, 360, 79, 32);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("Distância:");
        painelExplosivo.add(jLabel66);
        jLabel66.setBounds(30, 320, 59, 32);

        jPanel18.setBackground(new java.awt.Color(0, 41, 103));

        jLabel67.setBackground(new java.awt.Color(0, 51, 204));
        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Braços");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelExplosivo.add(jPanel18);
        jPanel18.setBounds(0, 40, 240, 30);

        jPanel19.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        painelExplosivo.add(jPanel19);
        jPanel19.setBounds(0, 400, 240, 30);

        jPanel21.setBackground(new java.awt.Color(0, 51, 51));

        jLabel72.setBackground(new java.awt.Color(0, 51, 204));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("TESTES DE FORÇA EXPLOSIVA");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelExplosivo.add(jPanel21);
        jPanel21.setBounds(0, 0, 240, 30);

        txtExpBraco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExpBraco.setEnabled(false);
        painelExplosivo.add(txtExpBraco);
        txtExpBraco.setBounds(100, 80, 60, 32);

        jLabel28.setText("m");
        painelExplosivo.add(jLabel28);
        jLabel28.setBounds(163, 100, 8, 14);

        txtExpVert.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExpVert.setEnabled(false);
        painelExplosivo.add(txtExpVert);
        txtExpVert.setBounds(100, 200, 60, 32);

        jLabel29.setText("cm");
        painelExplosivo.add(jLabel29);
        jLabel29.setBounds(163, 220, 13, 14);

        txtExpHoriz.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExpHoriz.setEnabled(false);
        painelExplosivo.add(txtExpHoriz);
        txtExpHoriz.setBounds(100, 320, 60, 32);

        jLabel30.setText("m");
        painelExplosivo.add(jLabel30);
        jLabel30.setBounds(163, 340, 8, 14);

        lblExpBraco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblExpBraco.setForeground(new java.awt.Color(0, 0, 102));
        lblExpBraco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpBraco.setText("Não calculado");
        painelExplosivo.add(lblExpBraco);
        lblExpBraco.setBounds(89, 120, 150, 32);

        lblExpVert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblExpVert.setForeground(new java.awt.Color(0, 0, 102));
        lblExpVert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpVert.setText("Não calculado");
        painelExplosivo.add(lblExpVert);
        lblExpVert.setBounds(90, 240, 150, 32);

        lblExpHoriz.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblExpHoriz.setForeground(new java.awt.Color(0, 0, 102));
        lblExpHoriz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpHoriz.setText("Não calculado");
        painelExplosivo.add(lblExpHoriz);
        lblExpHoriz.setBounds(90, 360, 150, 32);

        btnCalc5.setText("OK");
        btnCalc5.setEnabled(false);
        btnCalc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc5ActionPerformed(evt);
            }
        });
        painelExplosivo.add(btnCalc5);
        btnCalc5.setBounds(180, 80, 50, 32);

        btnCalc6.setText("OK");
        btnCalc6.setEnabled(false);
        btnCalc6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc6ActionPerformed(evt);
            }
        });
        painelExplosivo.add(btnCalc6);
        btnCalc6.setBounds(180, 200, 50, 32);

        btnCalc7.setText("OK");
        btnCalc7.setEnabled(false);
        btnCalc7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalc7ActionPerformed(evt);
            }
        });
        painelExplosivo.add(btnCalc7);
        btnCalc7.setBounds(180, 320, 50, 32);

        getContentPane().add(painelExplosivo);
        painelExplosivo.setBounds(530, 0, 240, 630);

        setBounds(0, 0, 3000, 670);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        painelIsometrico.setVisible(false);
        painelExplosivo.setVisible(false);
        painelIsotonico.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        painelIsometrico.setVisible(false);
        painelExplosivo.setLocation(270, 0);//setando o campo para o local certo
        painelExplosivo.setVisible(true);
        painelIsotonico.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        painelIsometrico.setLocation(270, 0);//setando o campo para o local do certo
        painelIsometrico.setVisible(true);
        painelExplosivo.setVisible(false);
        painelIsotonico.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JLabel lblExpBraco;
    public static javax.swing.JLabel lblExpHoriz;
    public static javax.swing.JLabel lblExpVert;
    public static javax.swing.JLabel lblIsoAbs;
    public static javax.swing.JLabel lblIsoBraco;
    public static javax.swing.JLabel lblIsoPeito;
    public static javax.swing.JLabel lblIsoPerna;
    public static javax.swing.JLabel lblMetDors;
    public static javax.swing.JLabel lblMetSup;
    private javax.swing.JPanel painelExplosivo;
    private javax.swing.JPanel painelIsometrico;
    private javax.swing.JPanel painelIsotonico;
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
