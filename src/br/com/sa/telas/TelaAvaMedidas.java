package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import br.com.sa.classes.CalcluloRelacaoCQ;
import br.com.sa.classes.CalculoComposicaoCorporal;
import br.com.sa.classes.CalculoDensidadeCorporal;
import br.com.sa.classes.CalculoSomatotipo;
import br.com.sa.telas.TelaModuloAva;
import java.awt.Color;
import javax.swing.border.Border;

public class TelaAvaMedidas extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    //variaveis de informaçoes importantes do cliente
    public String sexo;
    public double peso, estatura, idade;
    
    
     //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAvaMedidas telaAvaMedidas;
    
    public static TelaAvaMedidas getInstancia(){
        if (telaAvaMedidas == null){
            
            telaAvaMedidas = new TelaAvaMedidas();

        }
        return telaAvaMedidas;
    }
    

    public void incluirmedidas() {

        String sql = "update avaliacao1 set diapesc=?,diaombro=?,diatoraxrelax=?,diatoraxinsp=?,diaabdomem=?,diacintura=?,diaquadril=?,diabracdir=?,diabraesq=?,diaantdir=?,diaantesq=?,diapunhdir=?,diapunhesq=?,diacoxaproxdir=?,diacoxaproxesq=?,diacoxameddir=?,diacoxamedesq=?,diacoxadistdir=?,diacoxadistesq=?,diaperdir=?,diaperesq=?,diatornodir=?,diatornoesq=?,cintquadrilvalor=?,cintquadrilrisco=?,diaradioulna=?,diaumero=?,diafemur=?,diatornozelo=?,somaendomorfo=?,sommesomorfo=?,somaectomorfo=?,somaclassifica=?,compoprotocolo=?,compogordura=?,compodensidade=?,compopesoosseo=?,compopesomuscu=?,compopesoresid=?,compogordabsoluta=?,compomassamagra=?,compopesoideal=?,compopesoexesso=?,dobrapeitoral=?,dobrabiciptal=?,dobratriciptal=?,dobrasubescapular=?,dobraaxilar=?,dobrasuprailiaca=?,dobraabdominal=?,dobracoxa=?,dobramedialperna=? where idava=?";
        
        
        
        

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPescoco.getText());
            pst.setString(2, txtOmbro.getText());
            pst.setString(3, txtToraRelax.getText());
            pst.setString(4, txtToraInsp.getText());
            pst.setString(5, txtAbdom.getText());
            pst.setString(6, txtCint.getText());
            pst.setString(7, txtQuadril.getText());
            pst.setString(8, txtBracDir.getText());
            pst.setString(9, txtBracEsq.getText());
            pst.setString(10, txtAntDir.getText());
            pst.setString(11, txtAntEsq.getText());
            pst.setString(12, txtPunDir.getText());
            pst.setString(13, txtPunEsq.getText());
            pst.setString(14, txtCoxProxDir.getText());
            pst.setString(15, txtCoxProxEsq.getText());
            pst.setString(16, txtCoxMedDir.getText());
            pst.setString(17, txtCoxMedEsq.getText());
            pst.setString(18, txtCoxDistDir.getText());
            pst.setString(19, txtCoxDistEsq.getText());
            pst.setString(20, txtPerDir.getText());
            pst.setString(21, txtPerEsq.getText());
            pst.setString(22, txtTorDir.getText());
            pst.setString(23, txtTorEsq.getText());
            pst.setString(24, lblCintResult.getText());
            pst.setString(25, lblCinturaRisco.getText());
            pst.setString(26, txtDiaRa.getText());
            pst.setString(27, txtDiaUme.getText());
            pst.setString(28, txtDiaFe.getText());
            pst.setString(29, txtDiaTor.getText());
            pst.setString(30, lblEndomorfo.getText());
            pst.setString(31, lblMesomorfo.getText());
            pst.setString(32, lblEctomorfo.getText());
            pst.setString(33, lblSomaClass.getText());
            pst.setString(34, cmbProtocolo.getSelectedItem().toString());
            pst.setString(35, lblPerGordura.getText());
            pst.setString(36, lblDensidade.getText());
            pst.setString(37, lblPesoOsseo.getText());
            pst.setString(38, lblPesoMuscular.getText());
            pst.setString(39, lblPesoResidual.getText());
            pst.setString(40, lblGordAbs.getText());
            pst.setString(41, lblMassaMagra.getText());
            pst.setString(42, lblPesoIdeal.getText());
            pst.setString(43, lblPesoExe.getText());
            pst.setString(44, txtDcPt.getText());
            pst.setString(45, txtDcBc.getText());
            pst.setString(46, txtDcTr.getText());
            pst.setString(47, txtDcSe.getText());
            pst.setString(48, txtDcAm.getText());
            pst.setString(49, txtDcSi.getText());
            pst.setString(50, txtDcAbd.getText());
            pst.setString(51, txtDcCx.getText());
            pst.setString(52, txtDcMp.getText());
            pst.setString(53, TelaModuloAva.lblIdAva.getText());

            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Questionário finalizado com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    public void calculoDensidade() {
        /*
           Aqui são calculados:
           densidade corporal
           percentual de gordura
           Gordura absoluta
           Massa magra
           peso ideal
           peso em excesso*/

        String retden;

        if (cmbProtocolo.getSelectedItem().equals("4 Dobras Petrotsk (1995) Geral")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.dcmp = Double.parseDouble(txtDcMp.getText().replaceAll(",", "."));
            d.idade = idade;
            d.petrotsky01();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Geral")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.dcpt = Double.parseDouble(txtDcPt.getText().replaceAll(",", "."));
            d.dcab = Double.parseDouble(txtDcAbd.getText().replaceAll(",", "."));
            d.jacson01();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984) Homens Adultos")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcam = Double.parseDouble(txtDcAm.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.dcab = Double.parseDouble(txtDcAbd.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.dcmp = Double.parseDouble(txtDcMp.getText().replaceAll(",", "."));
            d.thorland01();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984) Homens Adultos")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcam = Double.parseDouble(txtDcAm.getText().replaceAll(",", "."));

            d.thorland02();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984) Mulheres Adultas")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcam = Double.parseDouble(txtDcAm.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.dcab = Double.parseDouble(txtDcAbd.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.dcmp = Double.parseDouble(txtDcMp.getText().replaceAll(",", "."));
            d.thorland03();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984) Mulheres Adultas")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));

            d.thorland04();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Homens 18 a 61 anos")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dcpt = Double.parseDouble(txtDcPt.getText().replaceAll(",", "."));
            d.dcab = Double.parseDouble(txtDcAbd.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.idade = idade;
            d.jackson02();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Mulheres 18 a 55 anos")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.idade = idade;
            d.jackson03();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("2 Dobras Sloan (1962) Homens Universitários")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.solan01();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("2 Dobras Sloan (1962)Mulheres Universitárias")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.solan02();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984)Adolecente  Homem Atleta")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcam = Double.parseDouble(txtDcAm.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.dcab = Double.parseDouble(txtDcAbd.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.dcmp = Double.parseDouble(txtDcMp.getText().replaceAll(",", "."));
            d.thorland05();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984)Adolecente  Homem Atleta")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));

            d.thorland06();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcam = Double.parseDouble(txtDcAm.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
            d.dcab = Double.parseDouble(txtDcAbd.getText().replaceAll(",", "."));
            d.dccx = Double.parseDouble(txtDcCx.getText().replaceAll(",", "."));
            d.dcmp = Double.parseDouble(txtDcMp.getText().replaceAll(",", "."));
            d.thorland07();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta")) {

            CalculoDensidadeCorporal d = new CalculoDensidadeCorporal();
            d.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
            d.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
            d.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));

            d.thorland08();
            retden = String.format("%.3f", d.resultado);
            lblDensidade.setText(retden);

        }

    }

    public void desativacamposdc() {
        
        txtDcAbd.setEnabled(false);
        txtDcAm.setEnabled(false);
        txtDcBc.setEnabled(false);
        txtDcCx.setEnabled(false);
        txtDcMp.setEnabled(false);
        txtDcPt.setEnabled(false);
        txtDcSe.setEnabled(false);
        txtDcSi.setEnabled(false);
        txtDcTr.setEnabled(false);
        txtDcAbd.setBackground(new Color(240, 240, 240));
        txtDcAm.setBackground(new Color(240, 240, 240));
        txtDcBc.setBackground(new Color(240, 240, 240));
        txtDcCx.setBackground(new Color(240, 240, 240));
        txtDcMp.setBackground(new Color(240, 240, 240));
        txtDcPt.setBackground(new Color(240, 240, 240));
        txtDcSe.setBackground(new Color(240, 240, 240));
        txtDcSi.setBackground(new Color(240, 240, 240));
        txtDcTr.setBackground(new Color(240, 240, 240));
        

    }
//o metodo abaixo busca os dados do cliente na avaliaçao para tratar

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
//o metodo abaixo calcula o peso osseo

    public void calculoPO() {

        String po;
        CalculoComposicaoCorporal c = new CalculoComposicaoCorporal();
        c.diaradio = Double.parseDouble(txtDiaRa.getText().replaceAll(",", "."));
        c.diafemur = Double.parseDouble(txtDiaFe.getText().replaceAll(",", "."));
        c.estatura = estatura;
        c.pesoosseo();
        po = String.format("%.3f", c.retpesoosseo);
        lblPesoOsseo.setText(po);

    }
//o metodo a baixo calcula o peso muscular

    public void calculapesomusc() {
        String pmusc;
        CalculoComposicaoCorporal pm = new CalculoComposicaoCorporal();
        pm.pmgordura = Double.parseDouble(lblPerGordura.getText().replaceAll(",", "."));
        pm.pmpct = peso;
        pm.pmosso = Double.parseDouble(lblPesoOsseo.getText().replaceAll(",", "."));
        pm.pmresidual = Double.parseDouble(lblPesoResidual.getText().replaceAll(",", "."));
        pm.pesomuscular();
        pmusc = String.format("%.3f", pm.retpesmusc);
        lblPesoMuscular.setText(pmusc);

    }

    //o metodo abaixo calcula o peso residual 
    public void calcularpesoresidual() {
        String pre;
        CalculoComposicaoCorporal pr = new CalculoComposicaoCorporal();
        pr.pct = peso;
        pr.sexo = sexo;
        pr.pesoresidual();
        pre = String.format("%.3f", pr.retpesoresidual);
        lblPesoResidual.setText(pre);

    }

    //o modulo abaixo calcula e classifica a relaçao cintura quadril
    public void calculoccq() {
        buscadados();
        String ccq;
        CalcluloRelacaoCQ p = new CalcluloRelacaoCQ();
        p.cintura = Double.parseDouble(txtCint.getText().replaceAll(",", "."));
        p.quadril = Double.parseDouble(txtQuadril.getText().replaceAll(",", "."));
        p.idade = idade;
        p.sexo = sexo;
        p.calculo();
        ccq = String.format("%.2f", p.retorno);
        lblCintResult.setText(ccq);
        lblCinturaRisco.setText(p.clas);

    }

    public void calculopercentgordura() {
        String pergord;
        CalculoComposicaoCorporal com = new CalculoComposicaoCorporal();
        com.denscorp = Double.parseDouble(lblDensidade.getText().replaceAll(",", "."));
        com.percentualGordura();
        pergord = String.format("%.3f", com.percentgord);
        lblPerGordura.setText(pergord);

    }

    public void gorduraabsoluta() {
        String gab;
        CalculoComposicaoCorporal ga = new CalculoComposicaoCorporal();
        ga.gapercegordura = Double.parseDouble(lblPerGordura.getText().replaceAll(",", "."));
        ga.gapct = peso;
        ga.gorduraabsoluta();
        gab = String.format("%.3f", ga.retgabs);
        lblGordAbs.setText(gab);

    }

    public void massamagraideal() {
        String mmi;
        CalculoComposicaoCorporal mm = new CalculoComposicaoCorporal();
        mm.mmpct = peso;
        mm.gaabs = Double.parseDouble(lblGordAbs.getText().replaceAll(",", "."));
        mm.massamagraideal();
        mmi = String.format("%.3f", mm.retmm);
        lblMassaMagra.setText(mmi);

    }

    public void calcpesoideal() {

        String pie;
        CalculoComposicaoCorporal pi = new CalculoComposicaoCorporal();
        pi.sexo = sexo;
        pi.pimm = Double.parseDouble(lblMassaMagra.getText().replaceAll(",", "."));
        pi.pesoideal();
        pie = String.format("%.3f", pi.retpi);
        lblPesoIdeal.setText(pie);

    }

    public void calcpesoexesso() {

        String pex;
        CalculoComposicaoCorporal pe = new CalculoComposicaoCorporal();
        pe.pepct = peso;
        pe.pepi = Double.parseDouble(lblPesoIdeal.getText().replaceAll(",", "."));
        pe.pesoee();
        pex = String.format("%.3f", pe.retpe);
        lblPesoExe.setText(pex);

    }

    //o metodo abaixo faz o calculo do somatotipoantropométrico
    public void calcsomatotipo() {
 
        CalculoSomatotipo cs = new CalculoSomatotipo();
        cs.dctr = Double.parseDouble(txtDcTr.getText().replaceAll(",", "."));
        cs.dcse = Double.parseDouble(txtDcSe.getText().replaceAll(",", "."));
        cs.dcsi = Double.parseDouble(txtDcSi.getText().replaceAll(",", "."));
        cs.dcper = Double.parseDouble(txtDcMp.getText().replaceAll(",", "."));
        cs.estatura = estatura;
        cs.peso = peso;
        cs.diaum = Double.parseDouble(txtDiaUme.getText().replaceAll(",", "."));
        cs.diafem = Double.parseDouble(txtDiaFe.getText().replaceAll(",", "."));
        cs.perbrac = Double.parseDouble(txtBracDir.getText().replaceAll(",", "."));
        cs.perper = Double.parseDouble(txtPerDir.getText().replaceAll(",", "."));
        cs.endomofia();
        lblEndomorfo.setText(String.format("%.1f", cs.retendo));
        cs.mesomorfia();
        lblMesomorfo.setText(String.format("%.1f", cs.retmeso));
        cs.ectomorfia();
        lblEctomorfo.setText(String.format("%.1f", cs.retecto));
        cs.retecto = Double.parseDouble(lblEctomorfo.getText().replaceAll(",", "."));
        cs.retmeso = Double.parseDouble(lblMesomorfo.getText().replaceAll(",", "."));
        cs.retendo = Double.parseDouble(lblEndomorfo.getText().replaceAll(",", "."));
        cs.classifica();
        lblSomaClass.setText(cs.classificado);
    }

    public TelaAvaMedidas() {
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
        btnMedSalvar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnCalcularSoma = new javax.swing.JButton();
        btnTogleSoma = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbProtocolo = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtDcBc = new javax.swing.JTextField();
        txtDcTr = new javax.swing.JTextField();
        txtDcSe = new javax.swing.JTextField();
        txtDcPt = new javax.swing.JTextField();
        txtDcAm = new javax.swing.JTextField();
        txtDcSi = new javax.swing.JTextField();
        txtDcAbd = new javax.swing.JTextField();
        txtDcCx = new javax.swing.JTextField();
        txtDcMp = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblGordAbs = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lblMassaMagra = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lblPesoIdeal = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lblPesoExe = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        lblPesoResidual = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        lblPerGordura = new javax.swing.JLabel();
        lblDensidade = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPesoOsseo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPesoMuscular = new javax.swing.JLabel();
        btnCalcularInicio = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtQuadril = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOmbro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtToraRelax = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtToraInsp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAbdom = new javax.swing.JTextField();
        txtPescoco = new javax.swing.JTextField();
        txtCint = new javax.swing.JTextField();
        txtTorDir = new javax.swing.JTextField();
        txtBracEsq = new javax.swing.JTextField();
        txtAntEsq = new javax.swing.JTextField();
        txtPunEsq = new javax.swing.JTextField();
        txtCoxProxEsq = new javax.swing.JTextField();
        txtCoxMedEsq = new javax.swing.JTextField();
        txtCoxDistEsq = new javax.swing.JTextField();
        txtPerEsq = new javax.swing.JTextField();
        txtTorEsq = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBracDir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtAntDir = new javax.swing.JTextField();
        txtPunDir = new javax.swing.JTextField();
        txtCoxProxDir = new javax.swing.JTextField();
        txtCoxMedDir = new javax.swing.JTextField();
        txtCoxDistDir = new javax.swing.JTextField();
        txtPerDir = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txtDiaRa = new javax.swing.JTextField();
        txtDiaUme = new javax.swing.JTextField();
        txtDiaFe = new javax.swing.JTextField();
        txtDiaTor = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCintResult = new javax.swing.JLabel();
        lblCinturaRisco = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lblEndomorfo = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lblMesomorfo = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        lblEctomorfo = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lblSomaClass = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 247, 241));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Avaliação Antropométrica");
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
        getContentPane().setLayout(null);

        btnMedSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnMedSalvar.setText("Salvar e Avançar");
        btnMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedSalvar);
        btnMedSalvar.setBounds(825, 596, 225, 39);

        jPanel4.setBackground(new java.awt.Color(131, 126, 132));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Somatotipo Antropométrico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(105, 4, 13));
        jPanel4.setToolTipText("");

        btnCalcularSoma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalcularSoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/soma40x40.png"))); // NOI18N
        btnCalcularSoma.setText("Calcular");
        btnCalcularSoma.setEnabled(false);
        btnCalcularSoma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCalcularSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularSomaActionPerformed(evt);
            }
        });

        btnTogleSoma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTogleSoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/start-icon.png"))); // NOI18N
        btnTogleSoma.setText("Iniciar");
        btnTogleSoma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTogleSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTogleSomaActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/somo101x76.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalcularSoma, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btnTogleSoma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTogleSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcularSoma)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(310, 460, 271, 130);

        jPanel1.setBackground(new java.awt.Color(255, 247, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Composição Corporal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbProtocolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbProtocolo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4 Dobras Petrotsk (1995) Geral", "3 Dobras Jackson & Pollock (1978) Geral", "7 Dobras Thorland et alli (1984) Homens Adultos", "3 Dobras Thorland et alli (1984) Homens Adultos", "7 Dobras Thorland et alli (1984) Mulheres Adultas", "3 Dobras Thorland et alli (1984) Mulheres Adultas", "3 Dobras Jackson & Pollock (1978) Homens 18 a 61 anos", "3 Dobras Jackson & Pollock (1978) Mulheres 18 a 55 anos", "2 Dobras Sloan (1962) Homens Universitários", "2 Dobras Sloan (1962)Mulheres Universitárias", "7 Dobras Thorland et alli (1984)Adolecente  Homem Atleta", "3 Dobras Thorland et alli (1984)Adolecente  Homem Atleta", "7 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta", "3 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta" }));
        cmbProtocolo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProtocoloItemStateChanged(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("Protocolo");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Subescapular");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Bicipital");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Tricipital");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Axilar Média");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Supra Ilíaca");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Abdominal");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Coxa");

        txtDcBc.setBackground(new java.awt.Color(240, 240, 240));
        txtDcBc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcBc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDcBc.setEnabled(false);

        txtDcTr.setBackground(new java.awt.Color(204, 204, 255));
        txtDcTr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcTr.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDcSe.setBackground(new java.awt.Color(204, 204, 255));
        txtDcSe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcSe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDcPt.setBackground(new java.awt.Color(240, 240, 240));
        txtDcPt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcPt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDcPt.setEnabled(false);

        txtDcAm.setBackground(new java.awt.Color(240, 240, 240));
        txtDcAm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcAm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDcAm.setEnabled(false);

        txtDcSi.setBackground(new java.awt.Color(204, 204, 255));
        txtDcSi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcSi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDcAbd.setBackground(new java.awt.Color(240, 240, 240));
        txtDcAbd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcAbd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDcAbd.setEnabled(false);

        txtDcCx.setBackground(new java.awt.Color(240, 240, 240));
        txtDcCx.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcCx.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDcCx.setEnabled(false);

        txtDcMp.setBackground(new java.awt.Color(204, 204, 255));
        txtDcMp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDcMp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Medial Perna");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("cm");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("cm");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("cm");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("cm");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("cm");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("cm");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("cm");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("cm");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("cm");

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel96.setText("Peitoral");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/medidas100x101.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Peso Ósseo =");

        lblGordAbs.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblGordAbs.setForeground(new java.awt.Color(105, 4, 13));
        lblGordAbs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGordAbs.setText("0,000");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Peso Muscular =");

        lblMassaMagra.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMassaMagra.setForeground(new java.awt.Color(105, 4, 13));
        lblMassaMagra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMassaMagra.setText("0,000");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Gordura Absoluta =");

        lblPesoIdeal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPesoIdeal.setForeground(new java.awt.Color(105, 4, 13));
        lblPesoIdeal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesoIdeal.setText("0,000");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Massa Magra =");

        lblPesoExe.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPesoExe.setForeground(new java.awt.Color(105, 4, 13));
        lblPesoExe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesoExe.setText("0,000");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("g/ml");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("%");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("kg");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("kg");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("kg");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("kg");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setText("kg");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setText("Peso Ideal =");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setText("Peso em Excesso =");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setText("kg");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Peso Residual =");

        lblPesoResidual.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPesoResidual.setForeground(new java.awt.Color(105, 4, 13));
        lblPesoResidual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesoResidual.setText("0,000");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setText("kg");

        lblPerGordura.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPerGordura.setForeground(new java.awt.Color(105, 4, 13));
        lblPerGordura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerGordura.setText("0,000");

        lblDensidade.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDensidade.setForeground(new java.awt.Color(105, 4, 13));
        lblDensidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDensidade.setText("0,000");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Percentual de Grodura =");

        lblPesoOsseo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPesoOsseo.setForeground(new java.awt.Color(105, 4, 13));
        lblPesoOsseo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesoOsseo.setText("0,000");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Densidade Corporal =");

        lblPesoMuscular.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPesoMuscular.setForeground(new java.awt.Color(105, 4, 13));
        lblPesoMuscular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesoMuscular.setText("0,000");

        btnCalcularInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalcularInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/percentage40x40.png"))); // NOI18N
        btnCalcularInicio.setText("Calcular Gordura");
        btnCalcularInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCalcularInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularInicioActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/calcOsso40x40.png"))); // NOI18N
        jButton12.setText("Calcular Peso Ósseo");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/calcMusc40x40.png"))); // NOI18N
        jButton13.setText("Calcular Peso Muscular");
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProtocolo, 0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel96))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtDcPt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcBc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcTr, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcSe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcAm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcSi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcAbd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcCx, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDcMp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel41))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCalcularInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel47)
                                        .addComponent(jLabel32)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPerGordura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDensidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPesoOsseo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPesoMuscular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPesoResidual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGordAbs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMassaMagra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPesoIdeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPesoExe, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel64))
                                .addGap(2, 2, 2)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCalcularInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPerGordura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDensidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesoOsseo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesoMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesoResidual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGordAbs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMassaMagra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesoIdeal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPesoExe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDcPt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcBc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcTr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcSe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcAm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcSi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcAbd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcCx, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDcMp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(587, 7, 463, 581);

        jPanel6.setBackground(new java.awt.Color(255, 247, 241));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Perímetros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(105, 4, 13))); // NOI18N

        txtQuadril.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQuadril.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuadril.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuadrilFocusLost(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Cintura");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Abdomem");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Quadril");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Pescoço");

        txtOmbro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOmbro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ombro");

        txtToraRelax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtToraRelax.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Torax Relaxado");

        txtToraInsp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtToraInsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Torax em Inspiração");

        txtAbdom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAbdom.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPescoco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPescoco.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCint.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCintFocusLost(evt);
            }
        });

        txtTorDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTorDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtBracEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBracEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtAntEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAntEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPunEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPunEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCoxProxEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCoxProxEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCoxMedEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCoxMedEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCoxDistEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCoxDistEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPerEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPerEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTorEsq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTorEsq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Direito");

        txtBracDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBracDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Braço");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Coxa Proximal");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Antebraço");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Punho");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Esquerdo");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Coxa Medial");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Coxa Distal");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Perna");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Tornozelo");

        txtAntDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAntDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPunDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPunDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCoxProxDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCoxProxDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCoxMedDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCoxMedDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCoxDistDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCoxDistDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtPerDir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPerDir.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("cm");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("cm");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("cm");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("cm");

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setText("cm");

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel73.setText("cm");

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setText("cm");

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setText("cm");

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel76.setText("cm");

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setText("cm");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setText("cm");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("cm");

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("cm");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("cm");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("cm");

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("cm");

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel84.setText("cm");

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel85.setText("cm");

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel87.setText("cm");

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel88.setText("cm");

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel89.setText("cm");

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel90.setText("cm");

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel91.setText("cm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtCint, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAbdom, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtToraInsp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtToraRelax, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOmbro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPescoco, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuadril, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel84)
                            .addComponent(jLabel85)
                            .addComponent(jLabel88)
                            .addComponent(jLabel89)
                            .addComponent(jLabel90)
                            .addComponent(jLabel91)
                            .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtBracDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAntDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPunDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxProxDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxMedDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxDistDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPerDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTorDir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel25)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73)
                            .addComponent(jLabel74)
                            .addComponent(jLabel75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtBracEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAntEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPunEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxProxEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxMedEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxDistEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPerEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTorEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77)
                            .addComponent(jLabel78)
                            .addComponent(jLabel80)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82)
                            .addComponent(jLabel83)
                            .addComponent(jLabel79, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPescoco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOmbro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtToraRelax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtToraInsp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAbdom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCint, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuadril, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBracDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAntDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPunDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBracEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAntEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPunEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoxProxDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCoxMedDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCoxDistDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPerDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTorDir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoxProxEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoxMedEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoxDistEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPerEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTorEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 10, 301, 580);

        jPanel9.setBackground(new java.awt.Color(255, 247, 241));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)), "Diâmetros Ósseos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(105, 4, 13))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Bi-Estilóideo Rádio-Ulnar");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setText("Bi-Maleolar do Tornozelo");

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setText("Bi-Epicondiliano do Úmero");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Bi-Epicondiliano do Fêmur");

        txtDiaRa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiaRa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDiaUme.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiaUme.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDiaFe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiaFe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDiaTor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiaTor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("cm");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel92.setText("cm");

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel86.setText("cm");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel93.setText("cm");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDiaRa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaUme, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaFe, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaTor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86)
                    .addComponent(jLabel92)
                    .addComponent(jLabel93)
                    .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaRa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaUme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaFe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaTor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel9);
        jPanel9.setBounds(310, 10, 270, 162);

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anatomico107x255.png"))); // NOI18N
        getContentPane().add(jLabel68);
        jLabel68.setBounds(310, 180, 107, 255);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("RCQ = ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 190, 46, 32);

        lblCintResult.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCintResult.setForeground(new java.awt.Color(165, 0, 0));
        lblCintResult.setText("0,0");
        getContentPane().add(lblCintResult);
        lblCintResult.setBounds(510, 190, 40, 32);

        lblCinturaRisco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCinturaRisco.setForeground(new java.awt.Color(102, 102, 102));
        lblCinturaRisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCinturaRisco.setText("Risco Resultado");
        getContentPane().add(lblCinturaRisco);
        lblCinturaRisco.setBounds(410, 220, 178, 20);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Relação Cintura Quadril");
        getContentPane().add(jLabel61);
        jLabel61.setBounds(400, 180, 180, 17);

        lblEndomorfo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEndomorfo.setForeground(new java.awt.Color(165, 0, 0));
        lblEndomorfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndomorfo.setText("0,0");
        getContentPane().add(lblEndomorfo);
        lblEndomorfo.setBounds(510, 290, 50, 20);

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("%");
        getContentPane().add(jLabel65);
        jLabel65.setBounds(560, 290, 14, 17);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setText("%");
        getContentPane().add(jLabel66);
        jLabel66.setBounds(560, 310, 14, 17);

        lblMesomorfo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMesomorfo.setForeground(new java.awt.Color(165, 0, 0));
        lblMesomorfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMesomorfo.setText("0,0");
        getContentPane().add(lblMesomorfo);
        lblMesomorfo.setBounds(510, 310, 50, 20);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("Mesomorfo = ");
        getContentPane().add(jLabel62);
        jLabel62.setBounds(421, 310, 86, 17);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setText("Ectomorfo = ");
        getContentPane().add(jLabel63);
        jLabel63.setBounds(424, 330, 83, 17);

        lblEctomorfo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEctomorfo.setForeground(new java.awt.Color(165, 0, 0));
        lblEctomorfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEctomorfo.setText("0,0");
        getContentPane().add(lblEctomorfo);
        lblEctomorfo.setBounds(510, 328, 50, 20);

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setText("%");
        getContentPane().add(jLabel67);
        jLabel67.setBounds(560, 330, 14, 17);

        lblSomaClass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSomaClass.setForeground(new java.awt.Color(165, 0, 0));
        lblSomaClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSomaClass.setText("NÃO CALCULADO");
        getContentPane().add(lblSomaClass);
        lblSomaClass.setBounds(400, 400, 181, 20);

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Perfil Antropométrico");
        getContentPane().add(jLabel97);
        jLabel97.setBounds(400, 380, 180, 17);

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel98.setText("Endomorfo = ");
        getContentPane().add(jLabel98);
        jLabel98.setBounds(420, 290, 87, 17);

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Somatotipo");
        getContentPane().add(jLabel99);
        jLabel99.setBounds(410, 270, 160, 17);

        setBounds(0, 0, 1069, 672);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMedSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSalvarActionPerformed
            int adicionar = JOptionPane.showConfirmDialog(null, "Concluiu todas as Medidas?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            incluirmedidas();
            telaAvaMedidas = null;
            TelaAvaMedidas.this.dispose();//metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_btnMedSalvarActionPerformed

    private void txtQuadrilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuadrilFocusLost
        if ((txtCint.getText().isEmpty()) || (txtQuadril.getText().isEmpty())) {
            
        } else {
            calculoccq();
        }
    }//GEN-LAST:event_txtQuadrilFocusLost

    private void txtCintFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCintFocusLost
        if ((txtCint.getText().isEmpty()) || (txtQuadril.getText().isEmpty())) {
            
        } else {
            calculoccq();
        }
    }//GEN-LAST:event_txtCintFocusLost

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if ((txtDiaRa.getText().isEmpty()) || (txtDiaFe.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "(*) O Diâmetro do Rádio e do Fêmur são obrigatórios!");

        } else {
            buscadados();
            calculoPO();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btnCalcularInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularInicioActionPerformed
        buscadados();

        if (cmbProtocolo.getSelectedItem().equals("4 Dobras Petrotsk (1995) Geral")) {
            if ((txtDcMp.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Geral")) {
            if ((txtDcAbd.getText().isEmpty()) || (txtDcCx.getText().isEmpty()) || (txtDcPt.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984) Homens Adultos")) {

            if ((txtDcAbd.getText().isEmpty()) || (txtDcAm.getText().isEmpty()) || (txtDcCx.getText().isEmpty()) || (txtDcMp.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984) Homens Adultos")) {
            if ((txtDcAm.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984) Mulheres Adultas")) {

            if ((txtDcAbd.getText().isEmpty()) || (txtDcAm.getText().isEmpty()) || (txtDcCx.getText().isEmpty()) || (txtDcMp.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984) Mulheres Adultas")) {

            if ((txtDcTr.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Homens 18 a 61 anos")) {

            if ((txtDcPt.getText().isEmpty()) || (txtDcAbd.getText().isEmpty()) || (txtDcCx.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Mulheres 18 a 55 anos")) {

            if ((txtDcTr.getText().isEmpty()) || (txtDcCx.getText().isEmpty()) || (txtDcSi.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("2 Dobras Sloan (1962) Homens Universitários")) {

            if ((txtDcSe.getText().isEmpty()) || (txtDcCx.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("2 Dobras Sloan (1962)Mulheres Universitárias")) {
            if ((txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984)Adolecente  Homem Atleta")) {
            if ((txtDcAbd.getText().isEmpty()) || (txtDcAm.getText().isEmpty()) || (txtDcCx.getText().isEmpty()) || (txtDcMp.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984)Adolecente  Homem Atleta")) {
            if ((txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta")) {

            if ((txtDcAbd.getText().isEmpty()) || (txtDcAm.getText().isEmpty()) || (txtDcCx.getText().isEmpty()) || (txtDcMp.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {

                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta")) {
            if ((txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcTr.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Os campos ativos são obrigatórios!");

            } else {
                calculoDensidade();
                calculopercentgordura();
                gorduraabsoluta();
                massamagraideal();
                calcpesoideal();
                calcpesoexesso();
                calcularpesoresidual();

            }

        }

    }//GEN-LAST:event_btnCalcularInicioActionPerformed

    private void cmbProtocoloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProtocoloItemStateChanged
        if (cmbProtocolo.getSelectedItem().equals("4 Dobras Petrotsk (1995) Geral")) {
            desativacamposdc();
            txtDcMp.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            txtDcMp.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Geral")) {

            desativacamposdc();
            txtDcAbd.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcPt.setEnabled(true);
            
            txtDcAbd.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
            txtDcPt.setBackground(new Color(204,204,255));

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984) Homens Adultos")) {

            desativacamposdc();
            txtDcAbd.setEnabled(true);
            txtDcAm.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcMp.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            
            txtDcAbd.setBackground(new Color(204,204,255));
            txtDcAm.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
            txtDcMp.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984) Homens Adultos")) {

            desativacamposdc();
            txtDcAm.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcTr.setEnabled(true);
            
            txtDcAm.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));

        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984) Mulheres Adultas")) {

            desativacamposdc();
            txtDcAbd.setEnabled(true);
            txtDcAm.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcMp.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            
            txtDcAbd.setBackground(new Color(204,204,255));
            txtDcAm.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
            txtDcMp.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984) Mulheres Adultas")) {

            desativacamposdc();
            txtDcTr.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            
            txtDcTr.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Homens 18 a 61 anos")) {

            desativacamposdc();
            txtDcPt.setEnabled(true);
            txtDcAbd.setEnabled(true);
            txtDcCx.setEnabled(true);
            
            txtDcPt.setBackground(new Color(204,204,255));
            txtDcAbd.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));

        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Jackson & Pollock (1978) Mulheres 18 a 55 anos")) {

            desativacamposdc();
            txtDcTr.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("2 Dobras Sloan (1962) Homens Universitários")) {

            desativacamposdc();
            txtDcSe.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("2 Dobras Sloan (1962)Mulheres Universitárias")) {

            desativacamposdc();
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984)Adolecente  Homem Atleta")) {

            desativacamposdc();
            txtDcAbd.setEnabled(true);
            txtDcAm.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcMp.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            txtDcAbd.setBackground(new Color(204,204,255));
            txtDcAm.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
            txtDcMp.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984)Adolecente  Homem Atleta")) {
            desativacamposdc();
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("7 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta")) {

            desativacamposdc();
            txtDcAbd.setEnabled(true);
            txtDcAm.setEnabled(true);
            txtDcCx.setEnabled(true);
            txtDcMp.setEnabled(true);
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            txtDcAbd.setBackground(new Color(204,204,255));
            txtDcAm.setBackground(new Color(204,204,255));
            txtDcCx.setBackground(new Color(204,204,255));
            txtDcMp.setBackground(new Color(204,204,255));
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));
        }
        if (cmbProtocolo.getSelectedItem().equals("3 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta")) {

            desativacamposdc();
            txtDcSe.setEnabled(true);
            txtDcSi.setEnabled(true);
            txtDcTr.setEnabled(true);
            txtDcSe.setBackground(new Color(204,204,255));
            txtDcSi.setBackground(new Color(204,204,255));
            txtDcTr.setBackground(new Color(204,204,255));
        }
    }//GEN-LAST:event_cmbProtocoloItemStateChanged

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (lblPesoResidual.getText().equals("0,000")) {

            JOptionPane.showMessageDialog(null, "Deve calcular o percentual de gordura primeiro!");
            return;
        }
        if (lblPesoOsseo.getText().equals("0,000")) {

            JOptionPane.showMessageDialog(null, "Deve calcular o peso ósseo primeiro!");

        } else {

            buscadados();
            calculapesomusc();

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnTogleSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTogleSomaActionPerformed
        buscadados();
        if (estatura == 0){
        JOptionPane.showMessageDialog(null,"A estatura deve ser informada!\n Informe em 'Hemodinâmico'");
        }
        if (peso == 0){
        JOptionPane.showMessageDialog(null,"O Peso deve ser informado!\n Informe em'Hemodinâmico'");
        }else{
        
        if (btnTogleSoma.isSelected()) {
            btnTogleSoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/parar40x40.png")));
            txtDcTr.setBackground(new Color(204, 255, 204));
            txtDcSe.setBackground(new Color(204, 255, 204));
            txtDcSi.setBackground(new Color(204, 255, 204));
            txtDcMp.setBackground(new Color(204, 255, 204));
            txtDiaUme.setBackground(new Color(204, 255, 204));
            txtDiaFe.setBackground(new Color(204, 255, 204));
            txtBracDir.setBackground(new Color(204, 255, 204));
            txtPerDir.setBackground(new Color(204, 255, 204));
            btnTogleSoma.setText("Parar");
            btnCalcularSoma.setEnabled(true);
            cmbProtocolo.setSelectedItem("4 Dobras Petrotsk (1995) Geral");
            JOptionPane.showMessageDialog(null, "Preencha todos os campos em verde!" + "\n" + "Depois clique em Calcular!");
        } else {
            btnTogleSoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/start-icon.png")));
            txtDcTr.setBackground(new Color(204, 204, 255));
            txtDcSe.setBackground(new Color(204, 204, 255));
            txtDcSi.setBackground(new Color(204, 204, 255));
            txtDcMp.setBackground(new Color(204, 204, 255));
            txtDiaUme.setBackground(new Color(255, 255, 255));
            txtDiaFe.setBackground(new Color(255, 255, 255));
            txtBracDir.setBackground(new Color(255, 255, 255));
            txtPerDir.setBackground(new Color(255, 255, 255));
            btnTogleSoma.setText("Início");
            btnCalcularSoma.setEnabled(false);

        }
        }
    }//GEN-LAST:event_btnTogleSomaActionPerformed

    private void btnCalcularSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularSomaActionPerformed
        if ((txtDcTr.getText().isEmpty()) || (txtDcSe.getText().isEmpty()) || (txtDcSi.getText().isEmpty()) || (txtDcMp.getText().isEmpty()) || (txtDiaUme.getText().isEmpty()) || (txtDiaFe.getText().isEmpty()) || (txtBracDir.getText().isEmpty()) || (txtPerDir.getText().isEmpty())) {

            JOptionPane.showMessageDialog(null, "Os campos em verde são Obrigatórios!");

        } else {

            buscadados();
            calcsomatotipo();
            
            txtDcTr.setBackground(new Color(204, 204, 255));
            txtDcSe.setBackground(new Color(204, 204, 255));
            txtDcSi.setBackground(new Color(204, 204, 255));
            txtDcMp.setBackground(new Color(204, 204, 255));
            txtDiaUme.setBackground(new Color(255, 255, 255));
            txtDiaFe.setBackground(new Color(255, 255, 255));
            txtBracDir.setBackground(new Color(255, 255, 255));
            txtPerDir.setBackground(new Color(255, 255, 255));
            btnTogleSoma.setText("Início");
            btnTogleSoma.setSelected(false);
            btnCalcularSoma.setEnabled(false);
            btnTogleSoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/start-icon.png")));
            JOptionPane.showMessageDialog(null, "Somatotipo Calculado com Sucesso!");

        }
    }//GEN-LAST:event_btnCalcularSomaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaMedidas = null;
            TelaAvaMedidas.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularInicio;
    private javax.swing.JButton btnCalcularSoma;
    private javax.swing.JButton btnMedSalvar;
    private javax.swing.JToggleButton btnTogleSoma;
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
    private javax.swing.JComboBox<String> cmbProtocolo;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
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
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JLabel lblCintResult;
    public static javax.swing.JLabel lblCinturaRisco;
    public static javax.swing.JLabel lblDensidade;
    public static javax.swing.JLabel lblEctomorfo;
    public static javax.swing.JLabel lblEndomorfo;
    public static javax.swing.JLabel lblGordAbs;
    public static javax.swing.JLabel lblMassaMagra;
    public static javax.swing.JLabel lblMesomorfo;
    public static javax.swing.JLabel lblPerGordura;
    public static javax.swing.JLabel lblPesoExe;
    public static javax.swing.JLabel lblPesoIdeal;
    public static javax.swing.JLabel lblPesoMuscular;
    public static javax.swing.JLabel lblPesoOsseo;
    public static javax.swing.JLabel lblPesoResidual;
    public static javax.swing.JLabel lblSomaClass;
    public static javax.swing.JTextField txtAbdom;
    public static javax.swing.JTextField txtAntDir;
    public static javax.swing.JTextField txtAntEsq;
    public static javax.swing.JTextField txtBracDir;
    public static javax.swing.JTextField txtBracEsq;
    public static javax.swing.JTextField txtCint;
    public static javax.swing.JTextField txtCoxDistDir;
    public static javax.swing.JTextField txtCoxDistEsq;
    public static javax.swing.JTextField txtCoxMedDir;
    public static javax.swing.JTextField txtCoxMedEsq;
    public static javax.swing.JTextField txtCoxProxDir;
    public static javax.swing.JTextField txtCoxProxEsq;
    public static javax.swing.JTextField txtDcAbd;
    public static javax.swing.JTextField txtDcAm;
    public static javax.swing.JTextField txtDcBc;
    public static javax.swing.JTextField txtDcCx;
    public static javax.swing.JTextField txtDcMp;
    public static javax.swing.JTextField txtDcPt;
    public static javax.swing.JTextField txtDcSe;
    public static javax.swing.JTextField txtDcSi;
    public static javax.swing.JTextField txtDcTr;
    public static javax.swing.JTextField txtDiaFe;
    public static javax.swing.JTextField txtDiaRa;
    public static javax.swing.JTextField txtDiaTor;
    public static javax.swing.JTextField txtDiaUme;
    public static javax.swing.JTextField txtOmbro;
    public static javax.swing.JTextField txtPerDir;
    public static javax.swing.JTextField txtPerEsq;
    public static javax.swing.JTextField txtPescoco;
    public static javax.swing.JTextField txtPunDir;
    public static javax.swing.JTextField txtPunEsq;
    public static javax.swing.JTextField txtQuadril;
    public static javax.swing.JTextField txtTorDir;
    public static javax.swing.JTextField txtTorEsq;
    public static javax.swing.JTextField txtToraInsp;
    public static javax.swing.JTextField txtToraRelax;
    // End of variables declaration//GEN-END:variables
}
