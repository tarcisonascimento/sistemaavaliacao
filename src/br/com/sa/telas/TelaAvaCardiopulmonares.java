package br.com.sa.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import br.com.sa.classes.CalculoCapacidadeAerobica;
import br.com.sa.classes.CalculoCapacidadeAnaerobicaAlatica;
import br.com.sa.classes.CalculoCapacidadeAnaerobicaLatica;
import br.com.sa.classes.CalculoLimiarLactato;
import br.com.sa.classes.DescricaoProtocolos;
import java.awt.Color;

public class TelaAvaCardiopulmonares extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java
    public static String painel = null;
    int fecha = 0;

    //variaveis de informaçoes importantes do cliente
    public String sexo;
    public double peso, estatura, idade;

    //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAvaCardiopulmonares telaAvaCardiopulmonares;

    public static TelaAvaCardiopulmonares getInstancia() {
        if (telaAvaCardiopulmonares == null) {

            telaAvaCardiopulmonares = new TelaAvaCardiopulmonares();

        }
        return telaAvaCardiopulmonares;
    }

    public void incluirmedidas() {

        String sql = "update avaliacao1 set car01=?,car02=?,car03=?,car04=?,car05=?,car06=?,car07=?,car08=?,car09=?,car10=?,vo2=?,car11=?,carlat=?,carlat01=?,carlat02=?,carlat03=?,carlat04=?,carlat05=?,carlat06=?,carlat07=?,carlat08=?,carlat09=?,carlat10=?,carlat11=?,carlat12=?,carlat13=?,carala=?,carala01=?,carala02=?,carala03=?,carala04=?,carlac=?,carlac01=?,carlac02=?,carlac03=? where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cmbProtAero.getSelectedItem().toString());
            pst.setString(2, condicao);
            pst.setString(3, txtMin.getText());
            pst.setString(4, txtSeg.getText());
            pst.setString(5, txtDist.getText());
            pst.setString(6, txtPotencia.getText());
            pst.setString(7, txtEstagio.getText());
            pst.setString(8, txtFcQuart.getText());
            pst.setString(9, txtFcQuint.getText());
            pst.setString(10, txtFcBpm.getText());
            pst.setString(11, lblVo2.getText());
            pst.setString(12, lblClassificado.getText());
            pst.setString(13, cmbLatica.getSelectedItem().toString());
            pst.setString(14, txtT1.getText());
            pst.setString(15, txtT2.getText());
            pst.setString(16, txtT3.getText());
            pst.setString(17, txtT4.getText());
            pst.setString(18, txtT5.getText());
            pst.setString(19, txtT6.getText());
            pst.setString(20, txtT7.getText());
            pst.setString(21, txtT8.getText());
            pst.setString(22, txtT9.getText());
            pst.setString(23, txtT10.getText());
            pst.setString(24, txtLatDist.getText());
            pst.setString(25, lblIf.getText());
            pst.setString(26, lbllatClass.getText());
            pst.setString(27, cmbPanaal.getSelectedItem().toString());
            pst.setString(28, txtTempPanaal.getText());
            pst.setString(29, txtDistPanaal.getText());
            pst.setString(30, lblPanaal.getText());
            pst.setString(31, lblClassificaPanaal.getText());
            pst.setString(32, cmbLac.getSelectedItem().toString());
            pst.setString(33, txtLacTemp.getText());
            pst.setString(34, lblLac.getText());
            pst.setString(35, lblLacClass.getText());
            pst.setString(36, TelaModuloAva.lblIdAva.getText());

            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Informações Inseridas com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir" + e);

        }

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

    public void desativacampos() {

        txtDist.setEnabled(false);
        txtEstagio.setEnabled(false);
        txtFcBpm.setEnabled(false);
        txtFcQuart.setEnabled(false);
        txtFcQuint.setEnabled(false);
        txtMin.setEnabled(false);
        txtPotencia.setEnabled(false);
        txtSeg.setEnabled(false);
        rdbCardiopata.setEnabled(false);
        rdbHomemAss.setEnabled(false);
        rdbMulherAss.setEnabled(false);
        rdbSedentario.setEnabled(false);

        txtDist.setText(null);
        txtEstagio.setText(null);
        txtFcBpm.setText(null);
        txtFcQuart.setText(null);
        txtFcQuint.setText(null);
        txtMin.setText(null);
        txtPotencia.setText(null);
        txtSeg.setText(null);
        rdbCardiopata.setSelected(false);
        rdbHomemAss.setSelected(false);
        rdbMulherAss.setSelected(false);
        rdbSedentario.setSelected(false);
        lblVo2.setText("00,00");
        lblClassificado.setText("Não calculado");

        txtDist.setBackground(new Color(240, 240, 240));
        txtEstagio.setBackground(new Color(240, 240, 240));
        txtFcBpm.setBackground(new Color(240, 240, 240));
        txtFcQuart.setBackground(new Color(240, 240, 240));
        txtFcQuint.setBackground(new Color(240, 240, 240));
        txtMin.setBackground(new Color(240, 240, 240));
        txtPotencia.setBackground(new Color(240, 240, 240));
        txtSeg.setBackground(new Color(240, 240, 240));

    }

    public void desativacamposlatico() {

        txtT1.setEnabled(false);
        txtT2.setEnabled(false);
        txtT3.setEnabled(false);
        txtT4.setEnabled(false);
        txtT5.setEnabled(false);
        txtT6.setEnabled(false);
        txtT7.setEnabled(false);
        txtT8.setEnabled(false);
        txtT9.setEnabled(false);
        txtT10.setEnabled(false);
        txtLatDist.setEnabled(false);

        txtT1.setText(null);
        txtT2.setText(null);
        txtT3.setText(null);
        txtT4.setText(null);
        txtT5.setText(null);
        txtT6.setText(null);
        txtT7.setText(null);
        txtT8.setText(null);
        txtT9.setText(null);
        txtT10.setText(null);
        txtLatDist.setText(null);
        lblIf.setText("0,00");
        lbllatClass.setText("Não calculado");
        lblPercent.setText("PANAL =");
        lblPercent.setText(null);

        txtT1.setBackground(new Color(240, 240, 240));
        txtT2.setBackground(new Color(240, 240, 240));
        txtT3.setBackground(new Color(240, 240, 240));
        txtT4.setBackground(new Color(240, 240, 240));
        txtT5.setBackground(new Color(240, 240, 240));
        txtT6.setBackground(new Color(240, 240, 240));
        txtT7.setBackground(new Color(240, 240, 240));
        txtT8.setBackground(new Color(240, 240, 240));
        txtT9.setBackground(new Color(240, 240, 240));
        txtT10.setBackground(new Color(240, 240, 240));
        txtLatDist.setBackground(new Color(240, 240, 240));

    }

    public void desativacampospanaal() {

        txtTempPanaal.setEnabled(false);
        txtDistPanaal.setEnabled(false);
        txtTempPanaal.setBackground(new Color(240, 240, 240));
        txtDistPanaal.setBackground(new Color(240, 240, 240));
        lblPanaal.setText("0000");
        lblKgAla.setText("Kg-m.seg¹");
        lblClassificaPanaal.setText("Não calculado");
        txtTempPanaal.setText(null);
        txtDistPanaal.setText(null);

    }

    public void desativacamposlac() {

        txtLacTemp.setEnabled(false);
        txtLacTemp.setText(null);
        btnLacCalc.setEnabled(false);
        txtLacTemp.setBackground(new Color(240, 240, 240));
        lblLac.setText("000");
        lblLacClass.setText("Não calculado");

    }

    public void calcproto01() {
        //instancia e recebe os valores
        //protocolo de Astrand bicicleta estacionária

        if ((txtPotencia.getText().isEmpty()) || (txtFcQuart.getText().isEmpty()) || (txtFcQuint.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.watts = Double.parseDouble(txtPotencia.getText().replaceAll(",", "."));
        calc.fc4 = Double.parseDouble(txtFcQuart.getText().replaceAll(",", "."));
        calc.fc5 = Double.parseDouble(txtFcQuint.getText().replaceAll(",", "."));
        calc.astrandbicicleta();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }
    String condicao;

    public void calcproto02() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Informe o tempo com Minutos e Segundos!");

        }
        if ((rdbCardiopata.isSelected()) || (rdbHomemAss.isSelected()) || (rdbMulherAss.isSelected()) || (rdbSedentario.isSelected())) {
            CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
            calc.sexo = sexo;
            calc.peso = peso;
            calc.idade = idade;
            calc.estatura = estatura;
            calc.tempoMin = Double.parseDouble(txtMin.getText().replaceAll(",", "."));
            calc.tempoSeg = Double.parseDouble(txtSeg.getText().replaceAll(",", "."));
            if (rdbCardiopata.isSelected()) {
                condicao = "Cardiopata";
            }
            if (rdbHomemAss.isSelected()) {
                condicao = "Homem Ativo";
            }
            if (rdbMulherAss.isSelected()) {
                condicao = "Mulher Ativa";
            }
            if (rdbSedentario.isSelected()) {
                condicao = "Sedentário (a)";
            }
            calc.quadro = condicao;
            calc.bruceesteira8est();
            lblVo2.setText(String.format("%.2f", calc.resultado));
            calc.classificavo2();
            lblClassificado.setText(calc.classificado);
        } else {

            JOptionPane.showMessageDialog(null, "Selecione a condição funcional!");

        }
    }

    public void calcproto03() {

        if (txtEstagio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.estagio = Integer.parseInt(txtEstagio.getText());
        calc.bruceesteira6est();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto04() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Integer.parseInt(txtMin.getText());
        calc.tempoSeg = Integer.parseInt(txtSeg.getText());
        calc.ellestadesteira();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto05() {

        if (txtDist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.dist = Double.parseDouble(txtDist.getText());
        calc.cooper12Min();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto06() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.cooper2400mts();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto07() {

        if (txtDist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.resultado = Double.parseDouble(txtDist.getText());
        lblVo2.setText(txtDist.getText() + " mts");
        calc.classificapsina();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto08() {

        if (txtDist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.resultado = Double.parseDouble(txtDist.getText());
        lblVo2.setText(txtDist.getText() + " mts");
        calc.classificabike();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto09() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.rodrigues1600mts();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto10() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");
            return;

        }

        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.ribsl3200m();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto11() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.weltman3200mts();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto12() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.klissouras1000mts();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto13() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty()) || (txtDist.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.dist = Double.parseDouble(txtDist.getText());
        calc.balke15min();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto14() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty()) || (txtFcBpm.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");
            return;

        }

        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.caft1200mts();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcproto15() {

        if ((txtMin.getText().isEmpty()) || (txtSeg.getText().isEmpty()) || (txtFcBpm.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Todos os campos verdes são obrigatórios!");
            return;
        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");
            return;

        }

        CalculoCapacidadeAerobica calc = new CalculoCapacidadeAerobica();
        calc.sexo = sexo;
        calc.peso = peso;
        calc.idade = idade;
        calc.estatura = estatura;
        calc.tempoMin = Double.parseDouble(txtMin.getText());
        calc.tempoSeg = Double.parseDouble(txtSeg.getText());
        calc.rockport1600mts();
        lblVo2.setText(String.format("%.2f", calc.resultado));
        calc.classificavo2();
        lblClassificado.setText(calc.classificado);

    }

    public void calcprotolat01() {

        if ((txtT1.getText().equals("  :  ")) || (txtT2.getText().equals("  :  ")) || (txtT3.getText().equals("  :  ")) || (txtT8.getText().equals("  :  ")) || (txtT9.getText().equals("  :  ")) || (txtT10.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "Os Tempos T1, T2, T3, T8, T9 e T10\nSão Obrigatórios para o Cálculo!\nPreencha-os");
        } else {

            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;

            calc.t0 = Double.parseDouble(txtT1.getText().replaceAll(":", "."));
            calc.t1 = Double.parseDouble(txtT2.getText().replaceAll(":", "."));
            calc.t2 = Double.parseDouble(txtT3.getText().replaceAll(":", "."));
            calc.t7 = Double.parseDouble(txtT8.getText().replaceAll(":", "."));
            calc.t8 = Double.parseDouble(txtT9.getText().replaceAll(":", "."));
            calc.t9 = Double.parseDouble(txtT10.getText().replaceAll(":", "."));
            calc.stuart01();
            lblIf.setText(String.format("%.2f", calc.resultado));
            lbllatClass.setText(calc.classifica);
        }

    }

    public void calcprotolat02() {
        if ((txtT1.getText().equals("  :  ")) || (txtT2.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "Informe os tempos: \nT1 = Melhor Tempo \nT2 = Pior Tempo");
            return;
        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");

        } else {

            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;

            calc.t0 = Double.parseDouble(txtT1.getText().replaceAll(":", "."));
            calc.t1 = Double.parseDouble(txtT2.getText().replaceAll(":", "."));
            calc.almeida01();
            lblIf.setText(String.format("%.2f", calc.resultado));
            lbllatClass.setText(calc.classifica);

        }

    }

    public void calcprotolat03() {

        if ((txtT1.getText().equals("  :  ")) || (txtT2.getText().equals("  :  ")) || (txtT3.getText().equals("  :  ")) || (txtT8.getText().equals("  :  ")) || (txtT9.getText().equals("  :  ")) || (txtT10.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "Os Tempos T1, T2, T3, T8, T9 e T10\nSão Obrigatórios para o Cálculo!\nPreencha-os");
        } else {

            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;

            calc.t0 = Double.parseDouble(txtT1.getText().replaceAll(":", "."));
            calc.t1 = Double.parseDouble(txtT2.getText().replaceAll(":", "."));
            calc.t2 = Double.parseDouble(txtT3.getText().replaceAll(":", "."));
            calc.t7 = Double.parseDouble(txtT8.getText().replaceAll(":", "."));
            calc.t8 = Double.parseDouble(txtT9.getText().replaceAll(":", "."));
            calc.t9 = Double.parseDouble(txtT10.getText().replaceAll(":", "."));
            calc.almeida02();
            lblIf.setText(String.format("%.2f", calc.resultado));
            lbllatClass.setText(calc.classifica);
        }

    }

    public void calcprotolat04() {
        if (txtLatDist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Distância Percorrida!");
            return;
        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");

        } else {
            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.distancia = Double.parseDouble(txtLatDist.getText().replaceAll(",", "."));
            calc.matsudo01();
            lblIf.setText(String.format("%.0f", calc.resultado));
            lbllatClass.setText(calc.classifica);

        }

    }

    public void calcprotolat05() {
        if (txtLatDist.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a Distância Percorrida!");
            return;
        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");

        } else {
            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.distancia = Double.parseDouble(txtLatDist.getText().replaceAll(",", "."));
            calc.almeida03();
            lblIf.setText(String.format("%.0f", calc.resultado));
            lbllatClass.setText(calc.classifica);

        }

    }

    public void calcprotolat06() {
        if (txtT1.getText().equals("  :  ")) {
            JOptionPane.showMessageDialog(null, "Informe os tempo total em MM:SS \nEx: 01:12");
        } else {

            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;

            calc.t0 = Double.parseDouble(txtT1.getText().replaceAll(":", "."));
            calc.lanceta01();
            lblIf.setText(txtT1.getText());
            lbllatClass.setText(calc.classifica);

        }

    }

    public void calcprotolat07() {
        if ((txtT1.getText().equals("  :  ")) || (txtT2.getText().equals("  :  ")) || (txtT3.getText().equals("  :  ")) || (txtT4.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "Os Tempos: T1, T2, T3 e T4 devem ser Informados!\nInforme os tempos em MM:SS \nEx: 01:12");
        } else {

            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;

            calc.t0 = Double.parseDouble(txtT1.getText().replaceAll(":", "."));
            calc.t1 = Double.parseDouble(txtT2.getText().replaceAll(":", "."));
            calc.t2 = Double.parseDouble(txtT3.getText().replaceAll(":", "."));
            calc.t3 = Double.parseDouble(txtT4.getText().replaceAll(":", "."));
            calc.almeida04();
            lblIf.setText(String.format("%.2f", calc.resultado));
            lbllatClass.setText(calc.classifica);

        }

    }

    public void calcprotolat08() {
        if ((txtT1.getText().equals("  :  ")) || (txtT2.getText().equals("  :  ")) || (txtT3.getText().equals("  :  ")) || (txtT4.getText().equals("  :  ")) || (txtT5.getText().equals("  :  ")) || (txtT6.getText().equals("  :  ")) || (txtT7.getText().equals("  :  ")) || (txtT8.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "Os Tempos: T1, T2, T3, T4, T5, T6, T7 e T8 devem ser Informados!\nInforme os tempos em MM:SS \nEx: 01:12");
        } else {

            CalculoCapacidadeAnaerobicaLatica calc = new CalculoCapacidadeAnaerobicaLatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;

            calc.t0 = Double.parseDouble(txtT1.getText().replaceAll(":", "."));
            calc.t1 = Double.parseDouble(txtT2.getText().replaceAll(":", "."));
            calc.t2 = Double.parseDouble(txtT3.getText().replaceAll(":", "."));
            calc.t3 = Double.parseDouble(txtT4.getText().replaceAll(":", "."));
            calc.t4 = Double.parseDouble(txtT5.getText().replaceAll(":", "."));
            calc.t5 = Double.parseDouble(txtT6.getText().replaceAll(":", "."));
            calc.t6 = Double.parseDouble(txtT7.getText().replaceAll(":", "."));
            calc.t7 = Double.parseDouble(txtT8.getText().replaceAll(":", "."));
            calc.almeida05();
            lblIf.setText(String.format("%.2f", calc.resultado));
            lbllatClass.setText(calc.classifica);

        }

    }

    public void protoPannal01() {
        if ((txtDistPanaal.getText().isEmpty()) || (txtTempPanaal.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "O Tempo e a Distância devem ser informados!\nEx:\nTempo: 01:78\nDistância em metros: 1,56");

        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");

        } else {

            CalculoCapacidadeAnaerobicaAlatica calc = new CalculoCapacidadeAnaerobicaAlatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.distancia = Double.parseDouble(txtDistPanaal.getText().replaceAll(",", "."));
            calc.tempo = Double.parseDouble(txtTempPanaal.getText().replaceAll(":", "."));
            calc.margaria01();
            lblPanaal.setText(String.format("%.0f", calc.resultado));
            lblClassificaPanaal.setText(calc.classifica);
        }
    }

    public void protoPannal02() {
        if ((txtDistPanaal.getText().isEmpty()) || (txtTempPanaal.getText().equals("  :  "))) {
            JOptionPane.showMessageDialog(null, "O Tempo e a Distância devem ser informados!\nEx:\nTempo: 01:78\nDistância em metros: 1,56");

        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");

        } else {

            CalculoCapacidadeAnaerobicaAlatica calc = new CalculoCapacidadeAnaerobicaAlatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.distancia = Double.parseDouble(txtDistPanaal.getText().replaceAll(",", "."));
            calc.tempo = Double.parseDouble(txtTempPanaal.getText().replaceAll(":", "."));
            calc.fletcher01();
            lblPanaal.setText(String.format("%.0f", calc.resultado));
            lblClassificaPanaal.setText(calc.classifica);

        }

    }

    public void protoPannal03() {
        if (txtTempPanaal.getText().equals("  :  ")) {
            JOptionPane.showMessageDialog(null, "O Tempo deve ser informado!\nEx:\nTempo: 01:78");

        }
        if (peso < 10) {
            JOptionPane.showMessageDialog(null, "O peso é necessário para esse cálculo!\nAcesse Hemodinâmico e corrija!");

        } else {

            CalculoCapacidadeAnaerobicaAlatica calc = new CalculoCapacidadeAnaerobicaAlatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.tempo = Double.parseDouble(txtTempPanaal.getText().replaceAll(":", "."));
            calc.almeida01();
            lblPanaal.setText(String.format("%.0f", calc.resultado));
            lblClassificaPanaal.setText(calc.classifica);
        }

    }

    public void protoPannal04() {
        if (txtTempPanaal.getText().equals("  :  ")) {
            JOptionPane.showMessageDialog(null, "O Tempo deve ser informado!\nEx:\nTempo: 01:78");

        } else {

            CalculoCapacidadeAnaerobicaAlatica calc = new CalculoCapacidadeAnaerobicaAlatica();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.tempo = Double.parseDouble(txtTempPanaal.getText().replaceAll(":", "."));
            calc.kiss01();
            lblPanaal.setText(txtTempPanaal.getText());
            lblClassificaPanaal.setText(calc.classifica);

        }

    }

    public void protlimiar01() {

        if (txtLacTemp.getText().equals("  :  ")) {
            JOptionPane.showMessageDialog(null, "O Tempo deve ser informado!\nEx:\nTempo: 01:58");

        } else {
            CalculoLimiarLactato calc = new CalculoLimiarLactato();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.tempo = Double.parseDouble(txtLacTemp.getText().replaceAll(":", "."));
            calc.simoes01();
            lblLac.setText(String.format("%.0f", calc.resultado));
            calc.classificalimiar();
            lblLacClass.setText(calc.classifica);
        }
    }

    public void protlimiar02() {
        if (txtLacTemp.getText().equals("  :  ")) {
            JOptionPane.showMessageDialog(null, "O Tempo deve ser informado!\nEx:\nTempo: 01:58");

        } else {
            CalculoLimiarLactato calc = new CalculoLimiarLactato();
            calc.sexo = sexo;
            calc.idade = idade;
            calc.peso = peso;
            calc.estatura = estatura;
            calc.tempo = Double.parseDouble(txtLacTemp.getText().replaceAll(":", "."));
            calc.simoes02();
            lblLac.setText(String.format("%.0f", calc.resultado));
            calc.classificalimiar();
            lblLacClass.setText(calc.classifica);
        }
    }

    public void desativaPaineis() {

        painelAero520.setVisible(false);
        painelAnaAla520.setVisible(false);
        painelAnaLat520.setVisible(false);
        painelLac520.setVisible(false);

    }

//o metodo abaixo calcula o peso osseo
    public TelaAvaCardiopulmonares() {
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
        buttonGroup12 = new javax.swing.ButtonGroup();
        painelOrientacao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObjetivo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMaterial = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtExecucao = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOrientacoes = new javax.swing.JTextArea();
        btnSairAlatica4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnMedSalvar = new javax.swing.JButton();
        painelIsometrico = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblVo2 = new javax.swing.JLabel();
        lblClassificado = new javax.swing.JLabel();
        lblKgAla = new javax.swing.JLabel();
        lblPanaal = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblClassificaPanaal = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        lblIfPanal1 = new javax.swing.JLabel();
        lblIf = new javax.swing.JLabel();
        lblPercent = new javax.swing.JLabel();
        lbllatClass = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblLac = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblLacClass = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        painelAero520 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        cmbProtAero = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        btnAjuda8 = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        rdbMulherAss = new javax.swing.JRadioButton();
        rdbHomemAss = new javax.swing.JRadioButton();
        rdbCardiopata = new javax.swing.JRadioButton();
        rdbSedentario = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtSeg = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtDist = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtEstagio = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtFcQuart = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFcQuint = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFcBpm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtPotencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        painelAnaAla520 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        cmbPanaal = new javax.swing.JComboBox<>();
        jPanel27 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        btnAjuda9 = new javax.swing.JButton();
        painelAlatico = new javax.swing.JPanel();
        txtDistPanaal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTempPanaal = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btnCalcularPanaal = new javax.swing.JButton();
        painelAnaLat520 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        cmbLatica = new javax.swing.JComboBox<>();
        jPanel29 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        btnAjuda10 = new javax.swing.JButton();
        painelLatico = new javax.swing.JPanel();
        txtT1 = new javax.swing.JFormattedTextField();
        txtT2 = new javax.swing.JFormattedTextField();
        txtT3 = new javax.swing.JFormattedTextField();
        txtT4 = new javax.swing.JFormattedTextField();
        txtT5 = new javax.swing.JFormattedTextField();
        txtT6 = new javax.swing.JFormattedTextField();
        txtT7 = new javax.swing.JFormattedTextField();
        txtT8 = new javax.swing.JFormattedTextField();
        txtT9 = new javax.swing.JFormattedTextField();
        txtT10 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnCalcularLat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtLatDist = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        painelLac520 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        cmbLac = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        btnAjuda11 = new javax.swing.JButton();
        painelAlatico1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        txtLacTemp = new javax.swing.JFormattedTextField();
        jLabel45 = new javax.swing.JLabel();
        btnLacCalc = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 247, 241));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Parâmetros Cardiopulmonares");
        setMaximumSize(new java.awt.Dimension(762, 530));
        setPreferredSize(new java.awt.Dimension(2000, 676));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        painelOrientacao.setBackground(new java.awt.Color(255, 247, 241));
        painelOrientacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Orientações para execução dos protocolos"));

        txtObjetivo.setEditable(false);
        txtObjetivo.setBackground(new java.awt.Color(255, 247, 241));
        txtObjetivo.setColumns(20);
        txtObjetivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtObjetivo.setLineWrap(true);
        txtObjetivo.setRows(3);
        txtObjetivo.setWrapStyleWord(true);
        txtObjetivo.setAutoscrolls(false);
        txtObjetivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Objetivo"));
        txtObjetivo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtObjetivo.setKeymap(null);
        txtObjetivo.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtObjetivo.setOpaque(false);
        jScrollPane2.setViewportView(txtObjetivo);

        txtMaterial.setEditable(false);
        txtMaterial.setBackground(new java.awt.Color(255, 247, 241));
        txtMaterial.setColumns(20);
        txtMaterial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMaterial.setLineWrap(true);
        txtMaterial.setRows(3);
        txtMaterial.setWrapStyleWord(true);
        txtMaterial.setAutoscrolls(false);
        txtMaterial.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Material Necessário"));
        txtMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setKeymap(null);
        txtMaterial.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtMaterial.setOpaque(false);
        jScrollPane1.setViewportView(txtMaterial);

        txtExecucao.setEditable(false);
        txtExecucao.setBackground(new java.awt.Color(255, 247, 241));
        txtExecucao.setColumns(20);
        txtExecucao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtExecucao.setLineWrap(true);
        txtExecucao.setRows(4);
        txtExecucao.setWrapStyleWord(true);
        txtExecucao.setAutoscrolls(false);
        txtExecucao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Metodologia de Execução"));
        txtExecucao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtExecucao.setKeymap(null);
        txtExecucao.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtExecucao.setOpaque(false);
        jScrollPane3.setViewportView(txtExecucao);

        txtOrientacoes.setEditable(false);
        txtOrientacoes.setBackground(new java.awt.Color(255, 247, 241));
        txtOrientacoes.setColumns(20);
        txtOrientacoes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtOrientacoes.setLineWrap(true);
        txtOrientacoes.setRows(3);
        txtOrientacoes.setToolTipText("");
        txtOrientacoes.setWrapStyleWord(true);
        txtOrientacoes.setAutoscrolls(false);
        txtOrientacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Orientações ao Avaliando"));
        txtOrientacoes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtOrientacoes.setKeymap(null);
        txtOrientacoes.setMargin(new java.awt.Insets(1, 1, 1, 1));
        txtOrientacoes.setOpaque(false);
        jScrollPane4.setViewportView(txtOrientacoes);

        btnSairAlatica4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSairAlatica4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/delete30x30.png"))); // NOI18N
        btnSairAlatica4.setText("Sair");
        btnSairAlatica4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairAlatica4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelOrientacaoLayout = new javax.swing.GroupLayout(painelOrientacao);
        painelOrientacao.setLayout(painelOrientacaoLayout);
        painelOrientacaoLayout.setHorizontalGroup(
            painelOrientacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane4)
            .addGroup(painelOrientacaoLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSairAlatica4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        painelOrientacaoLayout.setVerticalGroup(
            painelOrientacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrientacaoLayout.createSequentialGroup()
                .addGroup(painelOrientacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairAlatica4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(painelOrientacao);
        painelOrientacao.setBounds(3940, 0, 530, 620);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Lactatob40x40.png"))); // NOI18N
        jButton1.setText("Testar");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 270, 210, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/VO240X40.png"))); // NOI18N
        jButton2.setText("Testar");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 30, 210, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Lactato40x40.png"))); // NOI18N
        jButton3.setText("Testar");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 190, 210, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/lactatoc40x40.png"))); // NOI18N
        jButton4.setText("Testar");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(40, 110, 210, 40);

        btnMedSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnMedSalvar.setText("Salvar");
        btnMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedSalvar);
        btnMedSalvar.setBounds(780, 590, 140, 39);

        painelIsometrico.setBackground(new java.awt.Color(255, 255, 255));
        painelIsometrico.setForeground(new java.awt.Color(0, 0, 102));
        painelIsometrico.setLayout(null);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Classificação:");
        painelIsometrico.add(jLabel35);
        jLabel35.setBounds(0, 100, 79, 32);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Classificação:");
        painelIsometrico.add(jLabel42);
        jLabel42.setBounds(0, 440, 80, 32);

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("Classificação:");
        painelIsometrico.add(jLabel50);
        jLabel50.setBounds(0, 220, 79, 32);

        jPanel11.setBackground(new java.awt.Color(0, 41, 103));

        jLabel51.setBackground(new java.awt.Color(0, 51, 204));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Capacidade Anaeróbica Alática");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelIsometrico.add(jPanel11);
        jPanel11.setBounds(0, 140, 240, 30);

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
        jPanel12.setBounds(0, 480, 240, 30);

        jPanel13.setBackground(new java.awt.Color(0, 41, 103));

        jLabel55.setBackground(new java.awt.Color(0, 51, 204));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Capacidade Aeróbica");

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
        jLabel73.setText("PARÂMETROS HEMODINÂMICOS");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("VO2 Max = ");
        painelIsometrico.add(jLabel2);
        jLabel2.setBounds(10, 80, 90, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ml (kg.min)¹");
        painelIsometrico.add(jLabel1);
        jLabel1.setBounds(150, 80, 90, 20);

        lblVo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblVo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVo2.setText("00,00");
        lblVo2.setToolTipText("VO2 Calculado");
        painelIsometrico.add(lblVo2);
        lblVo2.setBounds(80, 80, 70, 20);

        lblClassificado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClassificado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClassificado.setText("Não calculado");
        painelIsometrico.add(lblClassificado);
        lblClassificado.setBounds(80, 105, 160, 20);

        lblKgAla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKgAla.setText("Kg-m.seg¹");
        painelIsometrico.add(lblKgAla);
        lblKgAla.setBounds(140, 180, 90, 32);

        lblPanaal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPanaal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPanaal.setText("0000");
        lblPanaal.setToolTipText("VO2 Calculado");
        painelIsometrico.add(lblPanaal);
        lblPanaal.setBounds(70, 180, 70, 32);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("PANAAL =");
        painelIsometrico.add(jLabel31);
        jLabel31.setBounds(10, 180, 62, 32);

        lblClassificaPanaal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClassificaPanaal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClassificaPanaal.setText("Não calculado");
        painelIsometrico.add(lblClassificaPanaal);
        lblClassificaPanaal.setBounds(80, 220, 160, 32);

        jPanel14.setBackground(new java.awt.Color(0, 41, 103));

        jLabel52.setBackground(new java.awt.Color(0, 51, 204));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Capacidade Anaeróbica Lática");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelIsometrico.add(jPanel14);
        jPanel14.setBounds(0, 260, 240, 30);

        lblIfPanal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIfPanal1.setText("PANAL =");
        painelIsometrico.add(lblIfPanal1);
        lblIfPanal1.setBounds(24, 300, 70, 32);

        lblIf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIf.setText("0,00");
        lblIf.setToolTipText("VO2 Calculado");
        painelIsometrico.add(lblIf);
        lblIf.setBounds(83, 300, 70, 32);

        lblPercent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPercent.setText("%");
        painelIsometrico.add(lblPercent);
        lblPercent.setBounds(150, 300, 70, 32);

        lbllatClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllatClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllatClass.setText("Não calculado");
        painelIsometrico.add(lbllatClass);
        lbllatClass.setBounds(80, 330, 150, 32);

        jPanel15.setBackground(new java.awt.Color(0, 41, 103));

        jLabel53.setBackground(new java.awt.Color(0, 51, 204));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Limiar de Lactato Sanguíneo");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelIsometrico.add(jPanel15);
        jPanel15.setBounds(0, 370, 240, 30);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("m/min");
        painelIsometrico.add(jLabel39);
        jLabel39.setBounds(140, 410, 39, 32);

        lblLac.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLac.setText("000");
        lblLac.setToolTipText("VO2 Calculado");
        painelIsometrico.add(lblLac);
        lblLac.setBounds(83, 410, 50, 32);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("LAC =");
        painelIsometrico.add(jLabel37);
        jLabel37.setBounds(40, 410, 38, 32);

        lblLacClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLacClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLacClass.setText("Não calculado");
        painelIsometrico.add(lblLacClass);
        lblLacClass.setBounds(80, 440, 160, 32);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("Classificação:");
        painelIsometrico.add(jLabel43);
        jLabel43.setBounds(0, 330, 80, 32);

        getContentPane().add(painelIsometrico);
        painelIsometrico.setBounds(270, 0, 240, 640);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 153));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Capacidade Anaeróbica Lática");
        getContentPane().add(jLabel46);
        jLabel46.setBounds(40, 160, 220, 30);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 51, 153));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Capacidade Anaeróbica Alática");
        getContentPane().add(jLabel47);
        jLabel47.setBounds(40, 80, 220, 30);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 51, 153));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Limiar de Lactato Sanguíneo");
        getContentPane().add(jLabel48);
        jLabel48.setBounds(40, 240, 220, 30);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 51, 153));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Capacidade Aeróbica");
        getContentPane().add(jLabel49);
        jLabel49.setBounds(50, 2, 210, 30);

        painelAero520.setBackground(new java.awt.Color(255, 255, 255));
        painelAero520.setForeground(new java.awt.Color(0, 0, 102));
        painelAero520.setLayout(null);

        jPanel24.setBackground(new java.awt.Color(0, 41, 103));

        cmbProtAero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbProtAero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Astrand bicicleta estacionária", "Protocolo de Bruce esteira multiplos estágios uma milha", "Protocolo de Bruce esteira multiplos estágios adaptado", "Protocolo de Ellestad esteira multiplos estágios", "Protocolo de Cooper 12 minutos pista", "Protocolo de Cooper 12 minutos pscina", "Protocolo de Cooper 12 minutos bicicleta móvel", "Protocolo de Cooper 2400 metros pista", "Protocolo de Rodrigues de Almeida 1600 metros pista", "Protocolo de Ribisl & Kachodorian 3200 metros pista", "Protocolo de Weltman 3200 metros pista", "Protocolo de Klissouras 1000 metros pista", "Protocolo de Balke 15 minutos pista", "Protocolo de Caftt 1200 metros pista", "Protocolo de Rockport 1600 metros pista" }));
        cmbProtAero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProtAeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbProtAero, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbProtAero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAero520.add(jPanel24);
        jPanel24.setBounds(0, 40, 530, 54);

        jPanel25.setBackground(new java.awt.Color(0, 51, 51));

        jLabel74.setBackground(new java.awt.Color(0, 51, 204));
        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("PROTOCOLOS - Capacidade Aeróbica");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelAero520.add(jPanel25);
        jPanel25.setBounds(0, 0, 350, 30);

        btnAjuda8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda8.setText("Ajuda");
        btnAjuda8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda8ActionPerformed(evt);
            }
        });
        painelAero520.add(btnAjuda8);
        btnAjuda8.setBounds(430, 5, 91, 29);

        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/calcular40x40.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setToolTipText("Calcular VO2");
        btnCalcular.setEnabled(false);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        painelAero520.add(btnCalcular);
        btnCalcular.setBounds(10, 300, 510, 54);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Condição Funcional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        rdbMulherAss.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbMulherAss);
        rdbMulherAss.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rdbMulherAss.setText("Mulher Assintomática");
        rdbMulherAss.setEnabled(false);
        rdbMulherAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMulherAssActionPerformed(evt);
            }
        });

        rdbHomemAss.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbHomemAss);
        rdbHomemAss.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rdbHomemAss.setText("Homem Assintomático");
        rdbHomemAss.setEnabled(false);
        rdbHomemAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHomemAssActionPerformed(evt);
            }
        });

        rdbCardiopata.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbCardiopata);
        rdbCardiopata.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rdbCardiopata.setText("Cardiopata");
        rdbCardiopata.setEnabled(false);
        rdbCardiopata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCardiopataActionPerformed(evt);
            }
        });

        rdbSedentario.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbSedentario);
        rdbSedentario.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rdbSedentario.setText("Sedentário(a)");
        rdbSedentario.setEnabled(false);
        rdbSedentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSedentarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbSedentario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbCardiopata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbHomemAss)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbMulherAss)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSedentario)
                    .addComponent(rdbCardiopata)
                    .addComponent(rdbHomemAss)
                    .addComponent(rdbMulherAss)))
        );

        painelAero520.add(jPanel10);
        jPanel10.setBounds(10, 100, 510, 47);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Tempo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("min");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("seg");

        txtMin.setBackground(new java.awt.Color(240, 240, 240));
        txtMin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMin.setToolTipText("Minutos");
        txtMin.setEnabled(false);
        txtMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinActionPerformed(evt);
            }
        });

        txtSeg.setBackground(new java.awt.Color(240, 240, 240));
        txtSeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSeg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSeg.setToolTipText("Segundos");
        txtSeg.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAero520.add(jPanel3);
        jPanel3.setBounds(10, 160, 230, 57);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Distância", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        txtDist.setBackground(new java.awt.Color(240, 240, 240));
        txtDist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDist.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDist.setToolTipText("Distância em Metros ex. 2310");
        txtDist.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Metros");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAero520.add(jPanel6);
        jPanel6.setBounds(240, 160, 144, 57);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Estágio Alcançado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        txtEstagio.setBackground(new java.awt.Color(240, 240, 240));
        txtEstagio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEstagio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstagio.setToolTipText("Estágio Alcançado no Teste");
        txtEstagio.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEstagio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtEstagio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAero520.add(jPanel2);
        jPanel2.setBounds(390, 160, 130, 57);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Frequência Cardíaca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        txtFcQuart.setBackground(new java.awt.Color(240, 240, 240));
        txtFcQuart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFcQuart.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFcQuart.setToolTipText("Frequência Cardíaca no 4\" minuto");
        txtFcQuart.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("4\"");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("5\"");

        txtFcQuint.setBackground(new java.awt.Color(240, 240, 240));
        txtFcQuint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFcQuint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFcQuint.setToolTipText("Frequência Cardíaca no 5\" minuto");
        txtFcQuint.setEnabled(false);
        txtFcQuint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFcQuintActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("bpm");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("bpm");

        txtFcBpm.setBackground(new java.awt.Color(240, 240, 240));
        txtFcBpm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFcBpm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFcBpm.setToolTipText("Frequência Cardiaca Obtida");
        txtFcBpm.setEnabled(false);
        txtFcBpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFcBpmActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("bpm");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("FC");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFcQuart, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFcQuint, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFcBpm, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtFcBpm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel12)
                .addComponent(jLabel13))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(txtFcQuart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel9)
                .addComponent(txtFcQuint, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10)
                .addComponent(jLabel11))
        );

        painelAero520.add(jPanel7);
        jPanel7.setBounds(10, 230, 399, 53);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Potência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        txtPotencia.setBackground(new java.awt.Color(240, 240, 240));
        txtPotencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPotencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPotencia.setToolTipText("Potência em Watts");
        txtPotencia.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("watt");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(txtPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(txtPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelAero520.add(jPanel5);
        jPanel5.setBounds(410, 230, 110, 53);

        getContentPane().add(painelAero520);
        painelAero520.setBounds(2290, 0, 530, 580);

        painelAnaAla520.setBackground(new java.awt.Color(255, 255, 255));
        painelAnaAla520.setForeground(new java.awt.Color(0, 0, 102));
        painelAnaAla520.setLayout(null);

        jPanel26.setBackground(new java.awt.Color(0, 41, 103));

        cmbPanaal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbPanaal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Margária - Teste da Escada", "Protocolo de Fletcher - Teste de Multi-Saltos", "Protocolo de Almeida & Sampedro - Teste de 30 m", "Protocolo de Kiss - Teste de 45,7 m" }));
        cmbPanaal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPanaalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAnaAla520.add(jPanel26);
        jPanel26.setBounds(0, 40, 530, 54);

        jPanel27.setBackground(new java.awt.Color(0, 51, 51));

        jLabel75.setBackground(new java.awt.Color(0, 51, 204));
        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("PROTOCOLOS - Capacidade Anaeróbica Alática");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelAnaAla520.add(jPanel27);
        jPanel27.setBounds(0, 0, 390, 30);

        btnAjuda9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda9.setText("Ajuda");
        btnAjuda9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda9ActionPerformed(evt);
            }
        });
        painelAnaAla520.add(btnAjuda9);
        btnAjuda9.setBounds(430, 5, 91, 29);

        painelAlatico.setBackground(new java.awt.Color(255, 255, 255));
        painelAlatico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Capacidade Anaeróbica Alática (PANAAL)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N
        painelAlatico.setPreferredSize(new java.awt.Dimension(562, 176));

        txtDistPanaal.setBackground(new java.awt.Color(240, 240, 240));
        txtDistPanaal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDistPanaal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDistPanaal.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Distância:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtTempPanaal.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtTempPanaal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTempPanaal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTempPanaal.setEnabled(false);
        txtTempPanaal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Tempo:");

        jLabel40.setText("mm:ss");

        jLabel44.setText("metros");

        javax.swing.GroupLayout painelAlaticoLayout = new javax.swing.GroupLayout(painelAlatico);
        painelAlatico.setLayout(painelAlaticoLayout);
        painelAlaticoLayout.setHorizontalGroup(
            painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlaticoLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelAlaticoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTempPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDistPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addGap(19, 19, 19))
        );
        painelAlaticoLayout.setVerticalGroup(
            painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlaticoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTempPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDistPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelAlaticoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel44))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAnaAla520.add(painelAlatico);
        painelAlatico.setBounds(10, 110, 506, 70);

        btnCalcularPanaal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalcularPanaal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/calcular40x40.png"))); // NOI18N
        btnCalcularPanaal.setText("Calcular");
        btnCalcularPanaal.setToolTipText("Calcular VO2");
        btnCalcularPanaal.setEnabled(false);
        btnCalcularPanaal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPanaalActionPerformed(evt);
            }
        });
        painelAnaAla520.add(btnCalcularPanaal);
        btnCalcularPanaal.setBounds(10, 200, 504, 54);

        getContentPane().add(painelAnaAla520);
        painelAnaAla520.setBounds(3390, 0, 530, 580);

        painelAnaLat520.setBackground(new java.awt.Color(255, 255, 255));
        painelAnaLat520.setForeground(new java.awt.Color(0, 0, 102));
        painelAnaLat520.setLayout(null);

        jPanel28.setBackground(new java.awt.Color(0, 41, 103));

        cmbLatica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbLatica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Stuart - Teste de 36,5 m", "Protocolo de Almeida & Sampedro - Teste de 35 m", "Protocolo de Almeida - Teste de vai-Vem-Vai em 30 m", "Protocolo de Matsudo - Teste de 40 seg", "Protocolo de Almeida - Teste de 40 seg (Adaptado)", "Protocolo de Lancetta - Testes de 400 e 600 m", "Protocolo de Almeida - Teste de 400 m", "Protocolo de Almeida - Teste de Vai e Vem em 25 m" }));
        cmbLatica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLaticaItemStateChanged(evt);
            }
        });
        cmbLatica.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cmbLaticaComponentShown(evt);
            }
        });
        cmbLatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLaticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbLatica, 0, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbLatica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelAnaLat520.add(jPanel28);
        jPanel28.setBounds(0, 40, 530, 54);

        jPanel29.setBackground(new java.awt.Color(0, 51, 51));

        jLabel76.setBackground(new java.awt.Color(0, 51, 204));
        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("PROTOCOLOS - Capacidade Anaeróbica Lática");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelAnaLat520.add(jPanel29);
        jPanel29.setBounds(0, 0, 350, 30);

        btnAjuda10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda10.setText("Ajuda");
        btnAjuda10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda10ActionPerformed(evt);
            }
        });
        painelAnaLat520.add(btnAjuda10);
        btnAjuda10.setBounds(430, 5, 91, 29);

        painelLatico.setBackground(new java.awt.Color(255, 255, 255));
        painelLatico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Tempo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N
        painelLatico.setLayout(null);

        txtT1.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT1.setEnabled(false);
        txtT1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT1);
        txtT1.setBounds(80, 20, 60, 32);

        txtT2.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT2.setEnabled(false);
        txtT2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT2);
        txtT2.setBounds(80, 60, 60, 32);

        txtT3.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT3.setEnabled(false);
        txtT3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT3);
        txtT3.setBounds(80, 100, 60, 32);

        txtT4.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT4.setEnabled(false);
        txtT4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT4);
        txtT4.setBounds(80, 140, 60, 32);

        txtT5.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT5.setEnabled(false);
        txtT5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT5);
        txtT5.setBounds(80, 180, 60, 32);

        txtT6.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT6.setEnabled(false);
        txtT6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT6);
        txtT6.setBounds(250, 20, 60, 32);

        txtT7.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT7.setEnabled(false);
        txtT7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT7);
        txtT7.setBounds(250, 60, 60, 32);

        txtT8.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT8.setEnabled(false);
        txtT8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT8);
        txtT8.setBounds(250, 100, 60, 32);

        txtT9.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT9.setEnabled(false);
        txtT9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT9);
        txtT9.setBounds(250, 140, 60, 32);

        txtT10.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT10.setEnabled(false);
        txtT10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        painelLatico.add(txtT10);
        txtT10.setBounds(250, 180, 60, 32);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tempo 01:");
        painelLatico.add(jLabel3);
        jLabel3.setBounds(10, 20, 68, 32);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tempo 02:");
        painelLatico.add(jLabel5);
        jLabel5.setBounds(10, 60, 68, 32);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Tempo 03:");
        painelLatico.add(jLabel16);
        jLabel16.setBounds(10, 100, 68, 32);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Tempo 04:");
        painelLatico.add(jLabel17);
        jLabel17.setBounds(10, 140, 68, 32);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tempo 05:");
        painelLatico.add(jLabel18);
        jLabel18.setBounds(10, 180, 68, 32);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Tempo 06:");
        painelLatico.add(jLabel19);
        jLabel19.setBounds(180, 20, 68, 32);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Tempo 07:");
        painelLatico.add(jLabel20);
        jLabel20.setBounds(180, 60, 68, 32);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Tempo 08:");
        painelLatico.add(jLabel21);
        jLabel21.setBounds(180, 100, 68, 32);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Tempo 10:");
        painelLatico.add(jLabel22);
        jLabel22.setBounds(180, 180, 68, 32);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Tempo 09:");
        painelLatico.add(jLabel23);
        jLabel23.setBounds(180, 140, 68, 32);

        painelAnaLat520.add(painelLatico);
        painelLatico.setBounds(10, 100, 330, 230);

        btnCalcularLat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalcularLat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/calcular40x40.png"))); // NOI18N
        btnCalcularLat.setText("Calcular");
        btnCalcularLat.setToolTipText("Calcular VO2");
        btnCalcularLat.setEnabled(false);
        btnCalcularLat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularLatActionPerformed(evt);
            }
        });
        painelAnaLat520.add(btnCalcularLat);
        btnCalcularLat.setBounds(10, 340, 510, 54);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Distância", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Distância");

        txtLatDist.setBackground(new java.awt.Color(240, 240, 240));
        txtLatDist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLatDist.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLatDist.setEnabled(false);

        jLabel27.setText("m");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(6, 6, 6)
                .addComponent(txtLatDist, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel26))
                        .addComponent(txtLatDist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        painelAnaLat520.add(jPanel4);
        jPanel4.setBounds(350, 270, 170, 57);

        getContentPane().add(painelAnaLat520);
        painelAnaLat520.setBounds(1740, 0, 530, 580);

        painelLac520.setBackground(new java.awt.Color(255, 255, 255));
        painelLac520.setForeground(new java.awt.Color(0, 0, 102));
        painelLac520.setLayout(null);

        jPanel30.setBackground(new java.awt.Color(0, 41, 103));

        cmbLac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbLac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Simões - Teste de 3000 m", "Protocolo de Simões - Teste de 700 m" }));
        cmbLac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbLac, 0, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbLac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelLac520.add(jPanel30);
        jPanel30.setBounds(0, 40, 530, 54);

        jPanel31.setBackground(new java.awt.Color(0, 51, 51));

        jLabel77.setBackground(new java.awt.Color(0, 51, 204));
        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("PROTOCOLOS - Limiar de Lactato Sanguíneo");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        painelLac520.add(jPanel31);
        jPanel31.setBounds(0, 0, 390, 30);

        btnAjuda11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda11.setText("Ajuda");
        btnAjuda11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda11ActionPerformed(evt);
            }
        });
        painelLac520.add(btnAjuda11);
        btnAjuda11.setBounds(430, 5, 91, 29);

        painelAlatico1.setBackground(new java.awt.Color(255, 255, 255));
        painelAlatico1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 41, 103)), "Tempo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 41, 103))); // NOI18N
        painelAlatico1.setPreferredSize(new java.awt.Dimension(562, 176));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel41.setText("mm:ss");

        txtLacTemp.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtLacTemp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtLacTemp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLacTemp.setEnabled(false);
        txtLacTemp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Tempo:");

        javax.swing.GroupLayout painelAlatico1Layout = new javax.swing.GroupLayout(painelAlatico1);
        painelAlatico1.setLayout(painelAlatico1Layout);
        painelAlatico1Layout.setHorizontalGroup(
            painelAlatico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlatico1Layout.createSequentialGroup()
                .addGroup(painelAlatico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAlatico1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelAlatico1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLacTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        painelAlatico1Layout.setVerticalGroup(
            painelAlatico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlatico1Layout.createSequentialGroup()
                .addGroup(painelAlatico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAlatico1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(painelAlatico1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLacTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlatico1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelLac520.add(painelAlatico1);
        painelAlatico1.setBounds(180, 110, 180, 70);

        btnLacCalc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLacCalc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/calcular40x40.png"))); // NOI18N
        btnLacCalc.setText("Calcular");
        btnLacCalc.setToolTipText("Calcular VO2");
        btnLacCalc.setEnabled(false);
        btnLacCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLacCalcActionPerformed(evt);
            }
        });
        painelLac520.add(btnLacCalc);
        btnLacCalc.setBounds(10, 190, 510, 57);

        getContentPane().add(painelLac520);
        painelLac520.setBounds(2840, 0, 530, 580);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/mostrarTelas46x40.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(40, 340, 200, 50);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/fundoacardio258x640.png"))); // NOI18N
        jLabel32.setText("jLabel32");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(0, 0, 260, 640);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        jButton6.setText("Sair");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(930, 590, 90, 40);

        setBounds(0, 0, 1065, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProtAeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProtAeroActionPerformed
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 12 minutos pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.cooper01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtDist.setEnabled(true);
            txtDist.setBackground(new Color(205, 255, 204));

        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Astrand bicicleta estacionária")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.astrand();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            desativacampos();
            btnCalcular.setEnabled(true);
            txtFcQuart.setEnabled(true);
            txtFcQuint.setEnabled(true);
            txtPotencia.setEnabled(true);
            txtFcQuart.setBackground(new Color(205, 255, 204));
            txtFcQuint.setBackground(new Color(205, 255, 204));
            txtPotencia.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Bruce esteira multiplos estágios uma milha")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.bruce01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            rdbCardiopata.setEnabled(true);
            rdbHomemAss.setEnabled(true);
            rdbMulherAss.setEnabled(true);
            rdbSedentario.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }

        if (cmbProtAero.getSelectedItem().equals("Protocolo de Bruce esteira multiplos estágios adaptado")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.bruce01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtEstagio.setEnabled(true);
            txtEstagio.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Ellestad esteira multiplos estágios")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.eleastad();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 12 minutos pscina")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.cooper02();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtDist.setEnabled(true);
            txtDist.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 12 minutos bicicleta móvel")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.cooper03();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtDist.setEnabled(true);
            txtDist.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 2400 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.cooper04();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Rodrigues de Almeida 1600 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.rodrigues01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Ribisl & Kachodorian 3200 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.ribsil01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Weltman 3200 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.weltman01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Klissouras 1000 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.klissouras01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Balke 15 minutos pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.balke01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtDist.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
            txtDist.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Caftt 1200 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.caftt01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtFcBpm.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
            txtFcBpm.setBackground(new Color(205, 255, 204));

        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Rockport 1600 metros pista")) {
            DescricaoProtocolos desc = new DescricaoProtocolos();
            desc.rockport01();
            txtObjetivo.setText(desc.objetivo);
            txtMaterial.setText(desc.material);
            txtExecucao.setText(desc.execucao);
            txtOrientacoes.setText(desc.orientacao);
            btnCalcular.setEnabled(true);
            desativacampos();
            txtMin.setEnabled(true);
            txtSeg.setEnabled(true);
            txtFcBpm.setEnabled(true);
            txtMin.setBackground(new Color(205, 255, 204));
            txtSeg.setBackground(new Color(205, 255, 204));
            txtFcBpm.setBackground(new Color(205, 255, 204));
        }
        if (cmbProtAero.getSelectedItem().equals("Selecione um protocolo")) {
            txtObjetivo.setText(null);
            txtMaterial.setText(null);
            txtExecucao.setText(null);
            txtOrientacoes.setText(null);
            btnCalcular.setEnabled(false);
            desativacampos();

        }// TODO add your handling code here:
    }//GEN-LAST:event_cmbProtAeroActionPerformed

    private void txtFcQuintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFcQuintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFcQuintActionPerformed

    private void txtFcBpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFcBpmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFcBpmActionPerformed

    private void txtMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Astrand bicicleta estacionária")) {
            buscadados();
            calcproto01();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Bruce esteira multiplos estágios uma milha")) {
            buscadados();
            calcproto02();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Bruce esteira multiplos estágios adaptado")) {
            buscadados();
            calcproto03();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Ellestad esteira multiplos estágios")) {
            buscadados();
            calcproto04();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 12 minutos pista")) {
            buscadados();
            calcproto05();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 2400 metros pista")) {
            buscadados();
            calcproto06();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 12 minutos pscina")) {
            buscadados();
            calcproto07();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Cooper 12 minutos bicicleta móvel")) {
            buscadados();
            calcproto08();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Rodrigues de Almeida 1600 metros pista")) {
            buscadados();
            calcproto09();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Ribisl & Kachodorian 3200 metros pista")) {
            buscadados();
            calcproto10();

        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Weltman 3200 metros pista")) {
            buscadados();
            calcproto11();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Klissouras 1000 metros pista")) {
            buscadados();
            calcproto12();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Balke 15 minutos pista")) {
            buscadados();
            calcproto13();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Caftt 1200 metros pista")) {

            buscadados();
            calcproto14();
        }
        if (cmbProtAero.getSelectedItem().equals("Protocolo de Rockport 1600 metros pista")) {
            buscadados();
            calcproto15();
        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnCalcularLatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularLatActionPerformed
        if (cmbLatica.getSelectedItem().equals("Protocolo de Stuart - Teste de 36,5 m")) {
            buscadados();
            calcprotolat01();

        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida & Sampedro - Teste de 35 m")) {
            buscadados();
            calcprotolat02();
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de vai-Vem-Vai em 30 m")) {
            buscadados();
            calcprotolat03();
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Matsudo - Teste de 40 seg")) {
            buscadados();
            calcprotolat04();

        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de 40 seg (Adaptado)")) {
            buscadados();
            calcprotolat05();

        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Lancetta - Testes de 400 e 600 m")) {
            buscadados();
            calcprotolat06();

        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de 400 m")) {
            buscadados();
            calcprotolat07();

        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de Vai e Vem em 25 m")) {
            buscadados();
            calcprotolat08();

        }
    }//GEN-LAST:event_btnCalcularLatActionPerformed

    private void btnCalcularPanaalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPanaalActionPerformed
        if (cmbPanaal.getSelectedItem().equals("Selecione um protocolo")) {
            desativacampospanaal();
        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Margária - Teste da Escada")) {
            buscadados();
            protoPannal01();
        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Fletcher - Teste de Multi-Saltos")) {
            buscadados();
            protoPannal02();
        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Almeida & Sampedro - Teste de 30 m")) {
            buscadados();
            protoPannal03();
        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Kiss - Teste de 45,7 m")) {
            buscadados();
            protoPannal04();
        }
    }//GEN-LAST:event_btnCalcularPanaalActionPerformed

    private void btnLacCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLacCalcActionPerformed
        if (cmbLac.getSelectedItem().equals("Protocolo de Simões - Teste de 3000 m")) {

            buscadados();
            protlimiar02();
        }
        if (cmbLac.getSelectedItem().equals("Protocolo de Simões - Teste de 700 m")) {

            buscadados();
            protlimiar01();

        }

    }//GEN-LAST:event_btnLacCalcActionPerformed

    private void cmbLaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLaticaActionPerformed
        if (cmbLatica.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposlatico();
            btnCalcularLat.setEnabled(false);
            txtObjetivo.setText(null);
            txtMaterial.setText(null);
            txtExecucao.setText(null);
            txtOrientacoes.setText(null);
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Stuart - Teste de 36,5 m")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            txtT3.setEnabled(true);
            txtT4.setEnabled(true);
            txtT5.setEnabled(true);
            txtT6.setEnabled(true);
            txtT7.setEnabled(true);
            txtT8.setEnabled(true);
            txtT9.setEnabled(true);
            txtT10.setEnabled(true);

            txtT1.setBackground(new Color(255, 255, 204));
            txtT2.setBackground(new Color(255, 255, 204));
            txtT3.setBackground(new Color(255, 255, 204));
            txtT4.setBackground(new Color(255, 255, 204));
            txtT5.setBackground(new Color(255, 255, 204));
            txtT6.setBackground(new Color(255, 255, 204));
            txtT7.setBackground(new Color(255, 255, 204));
            txtT8.setBackground(new Color(255, 255, 204));
            txtT9.setBackground(new Color(255, 255, 204));
            txtT10.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat01();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida & Sampedro - Teste de 35 m")) {
            // JOptionPane.showMessageDialog(null, "Informe os tempos: \n T1 = Melhor Tempo \nT2 = Pior Tempo");
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            txtT1.setBackground(new Color(255, 255, 204));
            txtT2.setBackground(new Color(255, 255, 204));
            lblPercent.setText("Índice de Fadiga =");
            lblPercent.setText("%");

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat02();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }

        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de vai-Vem-Vai em 30 m")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            txtT3.setEnabled(true);
            txtT4.setEnabled(true);
            txtT5.setEnabled(true);
            txtT6.setEnabled(true);
            txtT7.setEnabled(true);
            txtT8.setEnabled(true);
            txtT9.setEnabled(true);
            txtT10.setEnabled(true);

            txtT1.setBackground(new Color(255, 255, 204));
            txtT2.setBackground(new Color(255, 255, 204));
            txtT3.setBackground(new Color(255, 255, 204));
            txtT4.setBackground(new Color(255, 255, 204));
            txtT5.setBackground(new Color(255, 255, 204));
            txtT6.setBackground(new Color(255, 255, 204));
            txtT7.setBackground(new Color(255, 255, 204));
            txtT8.setBackground(new Color(255, 255, 204));
            txtT9.setBackground(new Color(255, 255, 204));
            txtT10.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat03();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }

        if (cmbLatica.getSelectedItem().equals("Protocolo de Matsudo - Teste de 40 seg")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtLatDist.setEnabled(true);
            txtLatDist.setBackground(new Color(255, 255, 204));
            lblPercent.setText("Distância =");
            lblPercent.setText("m");
            lblIf.setText("000");

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat04();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de 40 seg (Adaptado)")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtLatDist.setEnabled(true);
            txtLatDist.setBackground(new Color(255, 255, 204));
            lblPercent.setText("Distância =");
            lblPercent.setText("m");
            lblIf.setText("000");

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat05();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Lancetta - Testes de 400 e 600 m")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtT1.setEnabled(true);
            txtT1.setBackground(new Color(255, 255, 204));
            lblPercent.setText("Tempo =");
            lblIf.setText("00:00");
            lblPercent.setText("min");

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat06();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);
        }
        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de 400 m")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            txtT3.setEnabled(true);
            txtT4.setEnabled(true);
            txtT1.setBackground(new Color(255, 255, 204));
            txtT2.setBackground(new Color(255, 255, 204));
            txtT3.setBackground(new Color(255, 255, 204));
            txtT4.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat07();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);
        }

        if (cmbLatica.getSelectedItem().equals("Protocolo de Almeida - Teste de Vai e Vem em 25 m")) {
            btnCalcularLat.setEnabled(true);
            desativacamposlatico();
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            txtT3.setEnabled(true);
            txtT4.setEnabled(true);
            txtT5.setEnabled(true);
            txtT6.setEnabled(true);
            txtT7.setEnabled(true);
            txtT8.setEnabled(true);

            txtT1.setBackground(new Color(255, 255, 204));
            txtT2.setBackground(new Color(255, 255, 204));
            txtT3.setBackground(new Color(255, 255, 204));
            txtT4.setBackground(new Color(255, 255, 204));
            txtT5.setBackground(new Color(255, 255, 204));
            txtT6.setBackground(new Color(255, 255, 204));
            txtT7.setBackground(new Color(255, 255, 204));
            txtT8.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protLat08();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }
    }//GEN-LAST:event_cmbLaticaActionPerformed

    private void cmbPanaalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPanaalActionPerformed
        if (cmbPanaal.getSelectedItem().equals("Selecione um protocolo")) {
            desativacampospanaal();
        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Margária - Teste da Escada")) {
            //JOptionPane.showMessageDialog(null, "Informe o Tempo segundos e centésimos e Distância!\nEx:\nTempo = 01:78\nDistância em Metros = 2,36");
            desativacampospanaal();
            btnCalcularPanaal.setEnabled(true);
            txtTempPanaal.setEnabled(true);
            txtDistPanaal.setEnabled(true);
            txtTempPanaal.setBackground(new Color(255, 255, 204));
            txtDistPanaal.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protpanaal01();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Fletcher - Teste de Multi-Saltos")) {
            //JOptionPane.showMessageDialog(null, "Informe o Tempo segundos e centésimos e Distância!\nEx:\nTempo = 01:78\nDistância em Metros = 2,36");
            desativacampospanaal();
            btnCalcularPanaal.setEnabled(true);
            txtTempPanaal.setEnabled(true);
            txtDistPanaal.setEnabled(true);
            txtTempPanaal.setBackground(new Color(255, 255, 204));
            txtDistPanaal.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protpanaal02();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Almeida & Sampedro - Teste de 30 m")) {
            //JOptionPane.showMessageDialog(null, "Informe o Tempo em segundos e centésimos!\nEx:\nTempo = 01:78");
            desativacampospanaal();
            btnCalcularPanaal.setEnabled(true);
            txtTempPanaal.setEnabled(true);
            txtTempPanaal.setBackground(new Color(255, 255, 204));
            lblKgAla.setText("Watts");

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protpanaal03();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }
        if (cmbPanaal.getSelectedItem().equals("Protocolo de Kiss - Teste de 45,7 m")) {
            // JOptionPane.showMessageDialog(null, "Informe o Tempo em segundos e centésimos!\nEx:\nTempo = 01:78");
            desativacampospanaal();
            btnCalcularPanaal.setEnabled(true);
            txtTempPanaal.setEnabled(true);
            txtTempPanaal.setBackground(new Color(255, 255, 204));
            lblKgAla.setText("Segundos");

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protpanaal04();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }

    }//GEN-LAST:event_cmbPanaalActionPerformed

    private void cmbLacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLacActionPerformed
        if (cmbLac.getSelectedItem().equals("Selecione um protocolo")) {
            desativacamposlac();

        }

        if (cmbLac.getSelectedItem().equals("Protocolo de Simões - Teste de 3000 m")) {
            //JOptionPane.showMessageDialog(null, "Informe o Tempo em Minutos e Segundos!\nEx:\nTempo = 03:15");
            desativacamposlac();
            btnLacCalc.setEnabled(true);
            txtLacTemp.setEnabled(true);
            txtLacTemp.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protlac01();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }
        if (cmbLac.getSelectedItem().equals("Protocolo de Simões - Teste de 700 m")) {
            //JOptionPane.showMessageDialog(null, "Informe o Tempo em Minutos e Segundos!\nEx:\nTempo = 01:15");
            desativacamposlac();
            btnLacCalc.setEnabled(true);
            txtLacTemp.setEnabled(true);
            txtLacTemp.setBackground(new Color(255, 255, 204));

            DescricaoProtocolos p = new DescricaoProtocolos();
            p.protlac02();
            txtObjetivo.setText(p.objetivo);
            txtMaterial.setText(p.material);
            txtExecucao.setText(p.execucao);
            txtOrientacoes.setText(p.orientacao);

        }

    }//GEN-LAST:event_cmbLacActionPerformed

    private void cmbLaticaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLaticaItemStateChanged

    }//GEN-LAST:event_cmbLaticaItemStateChanged

    private void cmbLaticaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cmbLaticaComponentShown

    }//GEN-LAST:event_cmbLaticaComponentShown

    private void rdbCardiopataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCardiopataActionPerformed
        condicao = "Cardiopata";        // TODO add your handling code here:
    }//GEN-LAST:event_rdbCardiopataActionPerformed

    private void rdbHomemAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHomemAssActionPerformed
        condicao = "Homem Ativo";        // TODO add your handling code here:
    }//GEN-LAST:event_rdbHomemAssActionPerformed

    private void rdbMulherAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMulherAssActionPerformed
        condicao = "Mulher Ativa";
    }//GEN-LAST:event_rdbMulherAssActionPerformed

    private void rdbSedentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSedentarioActionPerformed
        condicao = "Sedentário (a)";        // TODO add your handling code here:
    }//GEN-LAST:event_rdbSedentarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        desativaPaineis();
        painelLac520.setLocation(520, 0);
        painelLac520.setVisible(true);
        fecha = 1;

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        desativaPaineis();
        painelAero520.setLocation(520, 0);
        painelAero520.setVisible(true);
        fecha = 1;

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        desativaPaineis();
        painelAnaLat520.setLocation(520, 0);
        painelAnaLat520.setVisible(true);
        fecha = 1;

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        desativaPaineis();
        painelAnaAla520.setLocation(520, 0);
        painelAnaAla520.setVisible(true);
        fecha = 1;

    }//GEN-LAST:event_jButton4ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnSairAlatica4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairAlatica4ActionPerformed

    }//GEN-LAST:event_btnSairAlatica4ActionPerformed

    private void btnMedSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSalvarActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Concluiu os Testes?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            incluirmedidas();
            fecha = 0;
            //telaAvaCardiopulmonares = null;
            //TelaAvaCardiopulmonares.this.dispose();//metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_btnMedSalvarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (fecha == 1){

        int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaCardiopulmonares = null;
            TelaAvaCardiopulmonares.this.dispose(); //metodo para fechar uma unica janela
            
        }
        } else {
            telaAvaCardiopulmonares = null;
            TelaAvaCardiopulmonares.this.dispose(); //metodo para fechar uma unica janela

        }        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnAjuda8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda8ActionPerformed
        painelOrientacao.setLocation(520, 0);
        painelOrientacao.setVisible(true);

    }//GEN-LAST:event_btnAjuda8ActionPerformed

    private void btnAjuda9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjuda9ActionPerformed

    private void btnAjuda10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda10ActionPerformed

    }//GEN-LAST:event_btnAjuda10ActionPerformed

    private void btnAjuda11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjuda11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        desativaPaineis();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int fechando = fecha; //aqui estou pegando o valor da variavel do sistema se 0 feha direto se 1 pede confirmaçao

        if (fechando == 1) {

            fechando = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção!", JOptionPane.YES_NO_OPTION);

            if (fechando == JOptionPane.YES_OPTION) {
                telaAvaCardiopulmonares = null;
                TelaAvaCardiopulmonares.this.dispose(); //metodo para fechar uma unica janela

            }
        } else {
            telaAvaCardiopulmonares = null;
            TelaAvaCardiopulmonares.this.dispose(); //metodo para fechar uma unica janela

        }// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjuda10;
    private javax.swing.JButton btnAjuda11;
    private javax.swing.JButton btnAjuda8;
    private javax.swing.JButton btnAjuda9;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcularLat;
    private javax.swing.JButton btnCalcularPanaal;
    private javax.swing.JButton btnLacCalc;
    private javax.swing.JButton btnMedSalvar;
    private javax.swing.JButton btnSairAlatica4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    public static javax.swing.JComboBox<String> cmbLac;
    public static javax.swing.JComboBox<String> cmbLatica;
    public static javax.swing.JComboBox<String> cmbPanaal;
    public static javax.swing.JComboBox<String> cmbProtAero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lblClassificaPanaal;
    public static javax.swing.JLabel lblClassificado;
    public static javax.swing.JLabel lblIf;
    private javax.swing.JLabel lblIfPanal1;
    private javax.swing.JLabel lblKgAla;
    public static javax.swing.JLabel lblLac;
    public static javax.swing.JLabel lblLacClass;
    public static javax.swing.JLabel lblPanaal;
    private javax.swing.JLabel lblPercent;
    public static javax.swing.JLabel lblVo2;
    public static javax.swing.JLabel lbllatClass;
    private javax.swing.JPanel painelAero520;
    private javax.swing.JPanel painelAlatico;
    private javax.swing.JPanel painelAlatico1;
    private javax.swing.JPanel painelAnaAla520;
    private javax.swing.JPanel painelAnaLat520;
    private javax.swing.JPanel painelIsometrico;
    private javax.swing.JPanel painelLac520;
    private javax.swing.JPanel painelLatico;
    private javax.swing.JPanel painelOrientacao;
    public static javax.swing.JRadioButton rdbCardiopata;
    public static javax.swing.JRadioButton rdbHomemAss;
    public static javax.swing.JRadioButton rdbMulherAss;
    public static javax.swing.JRadioButton rdbSedentario;
    public static javax.swing.JTextField txtDist;
    public static javax.swing.JTextField txtDistPanaal;
    public static javax.swing.JTextField txtEstagio;
    private javax.swing.JTextArea txtExecucao;
    public static javax.swing.JTextField txtFcBpm;
    public static javax.swing.JTextField txtFcQuart;
    public static javax.swing.JTextField txtFcQuint;
    public static javax.swing.JFormattedTextField txtLacTemp;
    public static javax.swing.JTextField txtLatDist;
    private javax.swing.JTextArea txtMaterial;
    public static javax.swing.JTextField txtMin;
    private javax.swing.JTextArea txtObjetivo;
    private javax.swing.JTextArea txtOrientacoes;
    public static javax.swing.JTextField txtPotencia;
    public static javax.swing.JTextField txtSeg;
    public static javax.swing.JFormattedTextField txtT1;
    public static javax.swing.JFormattedTextField txtT10;
    public static javax.swing.JFormattedTextField txtT2;
    public static javax.swing.JFormattedTextField txtT3;
    public static javax.swing.JFormattedTextField txtT4;
    public static javax.swing.JFormattedTextField txtT5;
    public static javax.swing.JFormattedTextField txtT6;
    public static javax.swing.JFormattedTextField txtT7;
    public static javax.swing.JFormattedTextField txtT8;
    public static javax.swing.JFormattedTextField txtT9;
    public static javax.swing.JFormattedTextField txtTempPanaal;
    // End of variables declaration//GEN-END:variables
}
