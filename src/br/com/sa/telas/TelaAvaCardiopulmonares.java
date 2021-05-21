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

    public void desativapainel() {

        painelAlatico.setVisible(false);
        painelAerobico.setVisible(false);
        painelLatico.setVisible(false);
        painelLactato.setVisible(false);
        painelOrientacao.setVisible(false);

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
        painelAerobico = new javax.swing.JPanel();
        cmbProtAero = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtSeg = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtDist = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
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
        jPanel2 = new javax.swing.JPanel();
        txtEstagio = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        rdbMulherAss = new javax.swing.JRadioButton();
        rdbHomemAss = new javax.swing.JRadioButton();
        rdbCardiopata = new javax.swing.JRadioButton();
        rdbSedentario = new javax.swing.JRadioButton();
        btnSairAlatica1 = new javax.swing.JButton();
        btnAjuda1 = new javax.swing.JButton();
        painelLatico = new javax.swing.JPanel();
        cmbLatica = new javax.swing.JComboBox<>();
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
        txtLatDist = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnAjuda2 = new javax.swing.JButton();
        btnSairAlatica2 = new javax.swing.JButton();
        painelAlatico = new javax.swing.JPanel();
        cmbPanaal = new javax.swing.JComboBox<>();
        txtDistPanaal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCalcularPanaal = new javax.swing.JButton();
        txtTempPanaal = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        pbnAjuda0 = new javax.swing.JButton();
        btnSairAlatica = new javax.swing.JButton();
        painelLactato = new javax.swing.JPanel();
        cmbLac = new javax.swing.JComboBox<>();
        btnLacCalc = new javax.swing.JButton();
        txtLacTemp = new javax.swing.JFormattedTextField();
        jLabel41 = new javax.swing.JLabel();
        btnSairAlatica3 = new javax.swing.JButton();
        btnAjuda3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblVo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblClassificado = new javax.swing.JLabel();
        lblPercent = new javax.swing.JLabel();
        lblIf = new javax.swing.JLabel();
        lbllatClass = new javax.swing.JLabel();
        lblClassificaPanaal = new javax.swing.JLabel();
        lblKgAla = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lblPanaal = new javax.swing.JLabel();
        lblLacClass = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblLac = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblIfPanal1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnMedSalvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(143, 170, 207));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
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
        painelOrientacao.setBounds(480, 10, 560, 620);

        painelAerobico.setBackground(new java.awt.Color(255, 247, 241));
        painelAerobico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Capacidade Aeróbica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbProtAero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbProtAero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Astrand bicicleta estacionária", "Protocolo de Bruce esteira multiplos estágios uma milha", "Protocolo de Bruce esteira multiplos estágios adaptado", "Protocolo de Ellestad esteira multiplos estágios", "Protocolo de Cooper 12 minutos pista", "Protocolo de Cooper 12 minutos pscina", "Protocolo de Cooper 12 minutos bicicleta móvel", "Protocolo de Cooper 2400 metros pista", "Protocolo de Rodrigues de Almeida 1600 metros pista", "Protocolo de Ribisl & Kachodorian 3200 metros pista", "Protocolo de Weltman 3200 metros pista", "Protocolo de Klissouras 1000 metros pista", "Protocolo de Balke 15 minutos pista", "Protocolo de Caftt 1200 metros pista", "Protocolo de Rockport 1600 metros pista" }));
        cmbProtAero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProtAeroActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 247, 241));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados obtidos no teste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

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

        jPanel3.setBackground(new java.awt.Color(255, 247, 241));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Tempo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

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

        jPanel6.setBackground(new java.awt.Color(255, 247, 241));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Distância", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

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

        jPanel7.setBackground(new java.awt.Color(255, 247, 241));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Frequência Cardíaca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

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

        jPanel5.setBackground(new java.awt.Color(255, 247, 241));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Potência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        txtPotencia.setBackground(new java.awt.Color(240, 240, 240));
        txtPotencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPotencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPotencia.setToolTipText("Potência em Watts");
        txtPotencia.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Watts");

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

        jPanel2.setBackground(new java.awt.Color(255, 247, 241));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Estágio Alcançado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

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

        jPanel10.setBackground(new java.awt.Color(255, 247, 241));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Condição Funcional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(105, 4, 13))); // NOI18N

        rdbMulherAss.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup1.add(rdbMulherAss);
        rdbMulherAss.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbMulherAss.setText("Mulher Assintomática");
        rdbMulherAss.setEnabled(false);
        rdbMulherAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMulherAssActionPerformed(evt);
            }
        });

        rdbHomemAss.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup1.add(rdbHomemAss);
        rdbHomemAss.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbHomemAss.setText("Homem Assintomático");
        rdbHomemAss.setEnabled(false);
        rdbHomemAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHomemAssActionPerformed(evt);
            }
        });

        rdbCardiopata.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup1.add(rdbCardiopata);
        rdbCardiopata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbCardiopata.setText("Cardiopata");
        rdbCardiopata.setEnabled(false);
        rdbCardiopata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCardiopataActionPerformed(evt);
            }
        });

        rdbSedentario.setBackground(new java.awt.Color(255, 247, 241));
        buttonGroup1.add(rdbSedentario);
        rdbSedentario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addContainerGap(8, Short.MAX_VALUE))
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

        btnSairAlatica1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSairAlatica1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/delete30x30.png"))); // NOI18N
        btnSairAlatica1.setText("Sair");
        btnSairAlatica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairAlatica1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSairAlatica1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(btnCalcular))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairAlatica1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAjuda1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda1.setText("Ajuda");
        btnAjuda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAerobicoLayout = new javax.swing.GroupLayout(painelAerobico);
        painelAerobico.setLayout(painelAerobicoLayout);
        painelAerobicoLayout.setHorizontalGroup(
            painelAerobicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelAerobicoLayout.createSequentialGroup()
                .addComponent(cmbProtAero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAjuda1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelAerobicoLayout.setVerticalGroup(
            painelAerobicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAerobicoLayout.createSequentialGroup()
                .addGroup(painelAerobicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProtAero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjuda1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelAerobico);
        painelAerobico.setBounds(480, 10, 560, 330);

        painelLatico.setBackground(new java.awt.Color(255, 247, 241));
        painelLatico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Capacidade Anaeróbica Lática (PANAL)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbLatica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        txtT1.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT1.setEnabled(false);
        txtT1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT2.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT2.setEnabled(false);
        txtT2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT3.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT3.setEnabled(false);
        txtT3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT4.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT4.setEnabled(false);
        txtT4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT5.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT5.setEnabled(false);
        txtT5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT6.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT6.setEnabled(false);
        txtT6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT7.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT7.setEnabled(false);
        txtT7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT8.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT8.setEnabled(false);
        txtT8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT9.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT9.setEnabled(false);
        txtT9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtT10.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtT10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtT10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT10.setEnabled(false);
        txtT10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("T:01");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("T:02");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("T:03");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("T:04");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("T:05");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("T:06");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("T:07");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("T:08");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("T:10");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("T:09");

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

        txtLatDist.setBackground(new java.awt.Color(240, 240, 240));
        txtLatDist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLatDist.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLatDist.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Distância");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("m");

        btnAjuda2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda2.setText("Ajuda");
        btnAjuda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda2ActionPerformed(evt);
            }
        });

        btnSairAlatica2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSairAlatica2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/delete30x30.png"))); // NOI18N
        btnSairAlatica2.setText("Sair");
        btnSairAlatica2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairAlatica2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLaticoLayout = new javax.swing.GroupLayout(painelLatico);
        painelLatico.setLayout(painelLaticoLayout);
        painelLaticoLayout.setHorizontalGroup(
            painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLaticoLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtT1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(txtT2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(txtT3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(txtT4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(txtT5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(txtT6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(txtT7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(txtT8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel23)
                    .addComponent(txtT9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(txtT10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelLaticoLayout.createSequentialGroup()
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLaticoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSairAlatica2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalcularLat))
                    .addGroup(painelLaticoLayout.createSequentialGroup()
                        .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLaticoLayout.createSequentialGroup()
                                .addComponent(cmbLatica, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAjuda2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLaticoLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLatDist, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelLaticoLayout.setVerticalGroup(
            painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLaticoLayout.createSequentialGroup()
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLatica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjuda2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtT1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLatDist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSairAlatica2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularLat, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        getContentPane().add(painelLatico);
        painelLatico.setBounds(480, 10, 560, 220);

        painelAlatico.setBackground(new java.awt.Color(255, 247, 241));
        painelAlatico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Capacidade Anaeróbica Alática (PANAAL)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(105, 4, 13))); // NOI18N
        painelAlatico.setPreferredSize(new java.awt.Dimension(562, 176));

        cmbPanaal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbPanaal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Margária - Teste da Escada", "Protocolo de Fletcher - Teste de Multi-Saltos", "Protocolo de Almeida & Sampedro - Teste de 30 m", "Protocolo de Kiss - Teste de 45,7 m" }));
        cmbPanaal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPanaalActionPerformed(evt);
            }
        });

        txtDistPanaal.setBackground(new java.awt.Color(240, 240, 240));
        txtDistPanaal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDistPanaal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDistPanaal.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Distância:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("m");

        pbnAjuda0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pbnAjuda0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        pbnAjuda0.setText("Ajuda");
        pbnAjuda0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbnAjuda0ActionPerformed(evt);
            }
        });

        btnSairAlatica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSairAlatica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/delete30x30.png"))); // NOI18N
        btnSairAlatica.setText("Sair");
        btnSairAlatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairAlaticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAlaticoLayout = new javax.swing.GroupLayout(painelAlatico);
        painelAlatico.setLayout(painelAlaticoLayout);
        painelAlaticoLayout.setHorizontalGroup(
            painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlaticoLayout.createSequentialGroup()
                .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAlaticoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelAlaticoLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTempPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDistPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)
                                .addGap(0, 179, Short.MAX_VALUE))
                            .addGroup(painelAlaticoLayout.createSequentialGroup()
                                .addComponent(btnSairAlatica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCalcularPanaal))))
                    .addGroup(painelAlaticoLayout.createSequentialGroup()
                        .addComponent(cmbPanaal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbnAjuda0)))
                .addContainerGap())
        );
        painelAlaticoLayout.setVerticalGroup(
            painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAlaticoLayout.createSequentialGroup()
                .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbnAjuda0, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDistPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTempPanaal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelAlaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcularPanaal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSairAlatica, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        getContentPane().add(painelAlatico);
        painelAlatico.setBounds(510, 10, 506, 170);

        painelLactato.setBackground(new java.awt.Color(255, 247, 241));
        painelLactato.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(105, 4, 13)), "Limiar de Lactato Sanguineo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(105, 4, 13))); // NOI18N

        cmbLac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbLac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um protocolo", "Protocolo de Simões - Teste de 3000 m", "Protocolo de Simões - Teste de 700 m" }));
        cmbLac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLacActionPerformed(evt);
            }
        });

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

        txtLacTemp.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtLacTemp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtLacTemp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLacTemp.setEnabled(false);
        txtLacTemp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Tempo:");

        btnSairAlatica3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSairAlatica3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/delete30x30.png"))); // NOI18N
        btnSairAlatica3.setText("Sair");
        btnSairAlatica3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairAlatica3ActionPerformed(evt);
            }
        });

        btnAjuda3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAjuda3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/help20x20.png"))); // NOI18N
        btnAjuda3.setText("Ajuda");
        btnAjuda3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjuda3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLactatoLayout = new javax.swing.GroupLayout(painelLactato);
        painelLactato.setLayout(painelLactatoLayout);
        painelLactatoLayout.setHorizontalGroup(
            painelLactatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLactatoLayout.createSequentialGroup()
                .addGroup(painelLactatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLactatoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSairAlatica3)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLacTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLacCalc))
                    .addGroup(painelLactatoLayout.createSequentialGroup()
                        .addComponent(cmbLac, 0, 389, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAjuda3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelLactatoLayout.setVerticalGroup(
            painelLactatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLactatoLayout.createSequentialGroup()
                .addGroup(painelLactatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjuda3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(painelLactatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLacCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelLactatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLacTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSairAlatica3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(painelLactato);
        painelLactato.setBounds(510, 10, 506, 170);

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
        jButton1.setBounds(170, 420, 130, 40);

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
        jButton2.setBounds(150, 90, 130, 40);

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
        jButton3.setBounds(310, 320, 130, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/lactatoc40x40.png"))); // NOI18N
        jButton4.setText("testar");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(300, 190, 130, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VO2 Max = ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 150, 90, 20);

        lblVo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblVo2.setForeground(new java.awt.Color(255, 255, 255));
        lblVo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVo2.setText("00,00");
        lblVo2.setToolTipText("VO2 Calculado");
        getContentPane().add(lblVo2);
        lblVo2.setBounds(180, 150, 60, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ml (kg.min)¹");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 150, 90, 20);

        lblClassificado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClassificado.setForeground(new java.awt.Color(255, 255, 255));
        lblClassificado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClassificado.setText("Não calculado");
        getContentPane().add(lblClassificado);
        lblClassificado.setBounds(110, 170, 216, 17);

        lblPercent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPercent.setForeground(new java.awt.Color(255, 255, 255));
        lblPercent.setText("%");
        getContentPane().add(lblPercent);
        lblPercent.setBounds(400, 370, 70, 30);

        lblIf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIf.setForeground(new java.awt.Color(255, 255, 255));
        lblIf.setText("0,00");
        lblIf.setToolTipText("VO2 Calculado");
        getContentPane().add(lblIf);
        lblIf.setBounds(350, 370, 53, 30);

        lbllatClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllatClass.setForeground(new java.awt.Color(255, 255, 255));
        lbllatClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllatClass.setText("Não calculado");
        getContentPane().add(lbllatClass);
        lbllatClass.setBounds(260, 400, 210, 17);

        lblClassificaPanaal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClassificaPanaal.setForeground(new java.awt.Color(255, 255, 255));
        lblClassificaPanaal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClassificaPanaal.setText("Não calculado");
        getContentPane().add(lblClassificaPanaal);
        lblClassificaPanaal.setBounds(250, 270, 230, 17);

        lblKgAla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKgAla.setForeground(new java.awt.Color(255, 255, 255));
        lblKgAla.setText("Kg-m.seg¹");
        getContentPane().add(lblKgAla);
        lblKgAla.setBounds(390, 250, 65, 17);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("PANAAL =");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(270, 250, 62, 17);

        lblPanaal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPanaal.setForeground(new java.awt.Color(255, 255, 255));
        lblPanaal.setText("0000");
        lblPanaal.setToolTipText("VO2 Calculado");
        getContentPane().add(lblPanaal);
        lblPanaal.setBounds(340, 250, 44, 22);

        lblLacClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLacClass.setForeground(new java.awt.Color(255, 255, 255));
        lblLacClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLacClass.setText("Não calculado");
        getContentPane().add(lblLacClass);
        lblLacClass.setBounds(110, 500, 230, 17);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("m/min");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(250, 480, 39, 17);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("LAC =");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(170, 480, 38, 17);

        lblLac.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLac.setForeground(new java.awt.Color(255, 255, 255));
        lblLac.setText("000");
        lblLac.setToolTipText("VO2 Calculado");
        getContentPane().add(lblLac);
        lblLac.setBounds(210, 480, 33, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Capacidade Anaeróbica Alática");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 230, 230, 17);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 204, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Capacidade Aeróbica");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(100, 130, 230, 17);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 204, 0));
        jLabel29.setText("Limiar de Lactato Sanguíneo");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(130, 460, 220, 17);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 204, 0));
        jLabel30.setText("Capacidade Anaeróbica Lática");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(270, 360, 220, 17);

        lblIfPanal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIfPanal1.setForeground(new java.awt.Color(255, 255, 255));
        lblIfPanal1.setText("PANAL =");
        getContentPane().add(lblIfPanal1);
        lblIfPanal1.setBounds(290, 370, 54, 30);

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/fundo480x487.png"))); // NOI18N
        jLabel24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel24KeyTyped(evt);
            }
        });
        getContentPane().add(jLabel24);
        jLabel24.setBounds(0, 70, 490, 490);

        btnMedSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnMedSalvar.setText("Salvar e Avançar");
        btnMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedSalvar);
        btnMedSalvar.setBounds(830, 580, 225, 39);

        setBounds(0, 0, 1068, 664);
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
        desativapainel();
        painelLactato.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        desativapainel();
        painelAerobico.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        desativapainel();
        painelLatico.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        desativapainel();
        painelAlatico.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSairAlaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairAlaticaActionPerformed
        painelAlatico.setVisible(false);
    }//GEN-LAST:event_btnSairAlaticaActionPerformed

    private void btnSairAlatica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairAlatica1ActionPerformed
        painelAerobico.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairAlatica1ActionPerformed

    private void btnSairAlatica2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairAlatica2ActionPerformed
        painelLatico.setVisible(false);
    }//GEN-LAST:event_btnSairAlatica2ActionPerformed

    private void btnSairAlatica3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairAlatica3ActionPerformed
        painelLactato.setVisible(false);
    }//GEN-LAST:event_btnSairAlatica3ActionPerformed

    private void pbnAjuda0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbnAjuda0ActionPerformed
        painelOrientacao.setVisible(true);
        painel = "painelAlatico";
        painelAlatico.setVisible(false);
        
    }//GEN-LAST:event_pbnAjuda0ActionPerformed

    private void btnAjuda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda3ActionPerformed
        painelOrientacao.setVisible(true);
        painel = "painelLactato";
        painelLactato.setVisible(false);
        
    }//GEN-LAST:event_btnAjuda3ActionPerformed

    private void btnAjuda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda2ActionPerformed
        painelOrientacao.setVisible(true);
        painel = "painelLatico";
        painelLatico.setVisible(false);
        
    }//GEN-LAST:event_btnAjuda2ActionPerformed

    private void btnAjuda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjuda1ActionPerformed
        painelOrientacao.setVisible(true);
        painel = "painelAerobico";
        painelAerobico.setVisible(false);
        
    }//GEN-LAST:event_btnAjuda1ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        //desativapainel();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameActivated

    private void jLabel24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel24KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24KeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        desativapainel();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnSairAlatica4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairAlatica4ActionPerformed
        if (painel.equals("painelAerobico")) {
            painelAerobico.setVisible(true);
            painelOrientacao.setVisible(false);
        }
        if (painel.equals("painelLatico")) {
            painelLatico.setVisible(true);
            painelOrientacao.setVisible(false);
        }
        if (painel.equals("painelLactato")) {
            painelLactato.setVisible(true);
            painelOrientacao.setVisible(false);
        }
        if (painel.equals("painelAlatico")) {
            painelAlatico.setVisible(true);
            painelOrientacao.setVisible(false);
        }
    }//GEN-LAST:event_btnSairAlatica4ActionPerformed

    private void btnMedSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSalvarActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Concluiu os Testes?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            incluirmedidas();
            telaAvaCardiopulmonares = null;
            TelaAvaCardiopulmonares.this.dispose();//metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_btnMedSalvarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
          int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAvaCardiopulmonares = null;
            TelaAvaCardiopulmonares.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjuda1;
    private javax.swing.JButton btnAjuda2;
    private javax.swing.JButton btnAjuda3;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcularLat;
    private javax.swing.JButton btnCalcularPanaal;
    private javax.swing.JButton btnLacCalc;
    private javax.swing.JButton btnMedSalvar;
    private javax.swing.JButton btnSairAlatica;
    private javax.swing.JButton btnSairAlatica1;
    private javax.swing.JButton btnSairAlatica2;
    private javax.swing.JButton btnSairAlatica3;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
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
    private javax.swing.JPanel painelAerobico;
    private javax.swing.JPanel painelAlatico;
    private javax.swing.JPanel painelLactato;
    private javax.swing.JPanel painelLatico;
    private javax.swing.JPanel painelOrientacao;
    private javax.swing.JButton pbnAjuda0;
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
