package br.com.sa.telas;

import br.com.sa.classes.GerenciadorDeJanelas;
import javax.swing.JOptionPane;
import java.sql.*;
import br.com.sa.dal.ModuloConexao;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Window;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.fill.JRAbstractLRUVirtualizer;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRSwapFile;
import net.sf.jasperreports.view.JasperViewer;

public class TelaModuloAva extends javax.swing.JFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    GerenciadorDeJanelas gerenciadorDeJanela; //variavel para trabalhar com o gerenciador de janelas

    //as variaveis abaixo armazenam os dados do usuario do sistema para reabrir a janela.  
    public static String NomeUso = null, PerfilAcesso = null, DataAcesso = null;

//o metodo abaixo ativa os botoes da avaliação fisica para inicio    
    //infotmaçoes necessarias do cliente
    public static String sexo;
    public static int idade;

    public void ativabotoes() {

        btnAvaAnaminese.setEnabled(true);
        btnAvaCardio.setEnabled(true);
        btnAvaHemo.setEnabled(true);
        btnAvaInicio.setEnabled(false);
        btnAvaInicio.setText("Iniciado");
        btnAvaMedidas.setEnabled(true);
        btnAvaNeuro.setEnabled(true);
        btnAvaPostural.setEnabled(true);
        btnAvaImpri.setEnabled(true);

    }
//o metodo abaixo cria a avaiação do usuario para dar inicio ao processo   

    public void inicioavaliacao() {

        String sql = "insert into avaliacao1 (idcli,iduso,idade,sexo) values (?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblMatricula.getText());
            pst.setString(2, lblIdProf.getText());
            pst.setString(3, lblIdade.getText());
            pst.setString(4, sexo);
            pst.executeUpdate();//atualiza a tabela

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao Iniciar a Avaliação!" + e);
        }

    }

    //o metodo abaixo seta todos os campos do formulario de anaminese
    String a0, a1, a2, a3, a4, a5, a6, a7, a8, a9;

    public void setcamposanaminese() {

        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                a0 = rs.getString(19);
                TelaAvaAna.txtAnatx01.setText(rs.getString(20));
                TelaAvaAna.chkAna03.setSelected(rs.getString(21).equals("1"));
                TelaAvaAna.chkAna04.setSelected(rs.getString(22).equals("1"));
                TelaAvaAna.chkAna05.setSelected(rs.getString(23).equals("1"));
                TelaAvaAna.chkAna06.setSelected(rs.getString(24).equals("1"));
                TelaAvaAna.txtAnatx02.setText(rs.getString(25));
                TelaAvaAna.chkAna07.setSelected(rs.getString(26).equals("1"));
                TelaAvaAna.txtAnatx03.setText(rs.getString(27));
                TelaAvaAna.chkAna08.setSelected(rs.getString(28).equals("1"));
                TelaAvaAna.txtAnatx04.setText(rs.getString(29));
                TelaAvaAna.chkAna09.setSelected(rs.getString(30).equals("1"));
                TelaAvaAna.txtAnatx05.setText(rs.getString(31));
                TelaAvaAna.chkAna10.setSelected(rs.getString(32).equals("1"));
                TelaAvaAna.txtAnatx06.setText(rs.getString(33));
                TelaAvaAna.chkAna11.setSelected(rs.getString(34).equals("1"));
                TelaAvaAna.txtAnatx07.setText(rs.getString(35));
                TelaAvaAna.chkAna12.setSelected(rs.getString(36).equals("1"));
                a1 = rs.getString(37);
                a2 = rs.getString(38);
                a3 = rs.getString(39);
                a4 = rs.getString(40);
                a5 = rs.getString(41);
                a6 = rs.getString(42);
                a7 = rs.getString(43);
                a8 = rs.getString(44);
                a9 = rs.getString(45);

            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

    }

    public void setcamposmedidas() {

        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                TelaAvaMedidas.txtPescoco.setText(rs.getString(59));
                TelaAvaMedidas.txtOmbro.setText(rs.getString(60));
                TelaAvaMedidas.txtToraRelax.setText(rs.getString(61));
                TelaAvaMedidas.txtToraInsp.setText(rs.getString(62));
                TelaAvaMedidas.txtAbdom.setText(rs.getString(63));
                TelaAvaMedidas.txtCint.setText(rs.getString(64));
                TelaAvaMedidas.txtQuadril.setText(rs.getString(65));
                TelaAvaMedidas.txtBracDir.setText(rs.getString(66));
                TelaAvaMedidas.txtBracEsq.setText(rs.getString(67));
                TelaAvaMedidas.txtAntDir.setText(rs.getString(68));
                TelaAvaMedidas.txtAntEsq.setText(rs.getString(69));
                TelaAvaMedidas.txtPunDir.setText(rs.getString(70));
                TelaAvaMedidas.txtPunEsq.setText(rs.getString(71));
                TelaAvaMedidas.txtCoxProxDir.setText(rs.getString(72));
                TelaAvaMedidas.txtCoxProxEsq.setText(rs.getString(73));
                TelaAvaMedidas.txtCoxMedDir.setText(rs.getString(74));
                TelaAvaMedidas.txtCoxMedEsq.setText(rs.getString(75));
                TelaAvaMedidas.txtCoxDistDir.setText(rs.getString(76));
                TelaAvaMedidas.txtCoxDistEsq.setText(rs.getString(77));
                TelaAvaMedidas.txtPerDir.setText(rs.getString(78));
                TelaAvaMedidas.txtPerEsq.setText(rs.getString(79));
                TelaAvaMedidas.txtTorDir.setText(rs.getString(80));
                TelaAvaMedidas.txtTorEsq.setText(rs.getString(81));
                TelaAvaMedidas.lblCintResult.setText(rs.getString(82));
                TelaAvaMedidas.lblCinturaRisco.setText(rs.getString(83));
                TelaAvaMedidas.txtDiaRa.setText(rs.getString(84));
                TelaAvaMedidas.txtDiaUme.setText(rs.getString(85));
                TelaAvaMedidas.txtDiaFe.setText(rs.getString(86));
                TelaAvaMedidas.txtDiaTor.setText(rs.getString(87));
                TelaAvaMedidas.lblEndomorfo.setText(rs.getString(88));
                TelaAvaMedidas.lblMesomorfo.setText(rs.getString(89));
                TelaAvaMedidas.lblEctomorfo.setText(rs.getString(90));
                TelaAvaMedidas.lblSomaClass.setText(rs.getString(91));
                TelaAvaMedidas.lblPerGordura.setText(rs.getString(93));
                TelaAvaMedidas.lblDensidade.setText(rs.getString(94));
                TelaAvaMedidas.lblPesoOsseo.setText(rs.getString(95));
                TelaAvaMedidas.lblPesoMuscular.setText(rs.getString(96));
                TelaAvaMedidas.lblPesoResidual.setText(rs.getString(97));
                TelaAvaMedidas.lblGordAbs.setText(rs.getString(98));
                TelaAvaMedidas.lblMassaMagra.setText(rs.getString(99));
                TelaAvaMedidas.lblPesoIdeal.setText(rs.getString(100));
                TelaAvaMedidas.lblPesoExe.setText(rs.getString(101));
                TelaAvaMedidas.txtDcPt.setText(rs.getString(102));
                TelaAvaMedidas.txtDcBc.setText(rs.getString(103));
                TelaAvaMedidas.txtDcTr.setText(rs.getString(104));
                TelaAvaMedidas.txtDcSe.setText(rs.getString(105));
                TelaAvaMedidas.txtDcAm.setText(rs.getString(106));
                TelaAvaMedidas.txtDcSi.setText(rs.getString(107));
                TelaAvaMedidas.txtDcAbd.setText(rs.getString(108));
                TelaAvaMedidas.txtDcCx.setText(rs.getString(109));
                TelaAvaMedidas.txtDcMp.setText(rs.getString(110));

            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

    }

    public void setcamposhemodinamicos() {

        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                TelaAvaHemo.txtHemoEsta.setText(rs.getString(50));
                TelaAvaHemo.txtHemoPeso.setText(rs.getString(49));
                TelaAvaHemo.lblHemoIMC.setText(rs.getString(46));
                TelaAvaHemo.lblHemoResuImc.setText(rs.getString(47));
                TelaAvaHemo.lblHemoGrau.setText(rs.getString(48));
                TelaAvaHemo.txtFcRep.setText(rs.getString(7));
                TelaAvaHemo.txtFcEst.setText(rs.getString(8));
                TelaAvaHemo.txtPasRep.setText(rs.getString(4));
                TelaAvaHemo.txtPadRep.setText(rs.getString(3));
                TelaAvaHemo.txtPasEsf.setText(rs.getString(6));
                TelaAvaHemo.txtPadEsf.setText(rs.getString(5));
                TelaAvaHemo.txtVo2.setText(rs.getString(12));
                TelaAvaHemo.lblDcResult.setText(rs.getString(10));
                TelaAvaHemo.lblVsRetorno.setText(rs.getString(13));
                TelaAvaHemo.lblDpRetorno.setText(rs.getString(15));
                TelaAvaHemo.lblMivoRetorno.setText(rs.getString(17));

            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

    }
    String condicao = "";

    public void setcamposcardio() {

        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                if (rs.getString(112) != null) {
                    TelaAvaCardiopulmonares.cmbProtAero.setSelectedItem(rs.getString(112));
                }
                if (rs.getString(113) != null) {
                    condicao = rs.getString(113);
                }
                if (rs.getString(114) != null) {
                    TelaAvaCardiopulmonares.txtMin.setText(rs.getString(114));
                }
                if (rs.getString(115) != null) {
                    TelaAvaCardiopulmonares.txtSeg.setText(rs.getString(115));
                }
                if (rs.getString(116) != null) {
                    TelaAvaCardiopulmonares.txtDist.setText(rs.getString(116));
                }
                if (rs.getString(117) != null) {
                    TelaAvaCardiopulmonares.txtPotencia.setText(rs.getString(117));
                }
                if (rs.getString(118) != null) {
                    TelaAvaCardiopulmonares.txtEstagio.setText(rs.getString(118));
                }
                if (rs.getString(119) != null) {
                    TelaAvaCardiopulmonares.txtFcQuart.setText(rs.getString(119));
                }
                if (rs.getString(120) != null) {
                    TelaAvaCardiopulmonares.txtFcQuint.setText(rs.getString(120));
                }
                if (rs.getString(121) != null) {
                    TelaAvaCardiopulmonares.txtFcBpm.setText(rs.getString(121));
                }
                if (rs.getString(12) != null) {
                    TelaAvaCardiopulmonares.lblVo2.setText(rs.getString(12));
                }
                if (rs.getString(122) != null) {
                    TelaAvaCardiopulmonares.lblClassificado.setText(rs.getString(122));
                }
                if (rs.getString(123) != null) {
                    TelaAvaCardiopulmonares.cmbLatica.setSelectedItem(rs.getString(123));
                }
                if (rs.getString(124) != null) {
                    TelaAvaCardiopulmonares.txtT1.setText(rs.getString(124));
                }
                if (rs.getString(125) != null) {
                    TelaAvaCardiopulmonares.txtT2.setText(rs.getString(125));
                }
                if (rs.getString(126) != null) {
                    TelaAvaCardiopulmonares.txtT3.setText(rs.getString(126));
                }
                if (rs.getString(127) != null) {
                    TelaAvaCardiopulmonares.txtT4.setText(rs.getString(127));
                }
                if (rs.getString(128) != null) {
                    TelaAvaCardiopulmonares.txtT5.setText(rs.getString(128));
                }
                if (rs.getString(129) != null) {
                    TelaAvaCardiopulmonares.txtT6.setText(rs.getString(129));
                }
                if (rs.getString(130) != null) {
                    TelaAvaCardiopulmonares.txtT7.setText(rs.getString(130));
                }
                if (rs.getString(131) != null) {
                    TelaAvaCardiopulmonares.txtT8.setText(rs.getString(131));
                }
                if (rs.getString(132) != null) {
                    TelaAvaCardiopulmonares.txtT9.setText(rs.getString(132));
                }
                if (rs.getString(133) != null) {
                    TelaAvaCardiopulmonares.txtT10.setText(rs.getString(133));
                }
                if (rs.getString(134) != null) {
                    TelaAvaCardiopulmonares.txtLatDist.setText(rs.getString(134));
                }
                if (rs.getString(135) != null) {
                    TelaAvaCardiopulmonares.lblIf.setText(rs.getString(135));
                }
                if (rs.getString(136) != null) {
                    TelaAvaCardiopulmonares.lbllatClass.setText(rs.getString(136));
                }
                if (rs.getString(137) != null) {
                    TelaAvaCardiopulmonares.cmbPanaal.setSelectedItem(rs.getString(137));
                }
                if (rs.getString(138) != null) {
                    TelaAvaCardiopulmonares.txtTempPanaal.setText(rs.getString(138));
                }
                if (rs.getString(139) != null) {
                    TelaAvaCardiopulmonares.txtDistPanaal.setText(rs.getString(139));
                }
                if (rs.getString(140) != null) {
                    TelaAvaCardiopulmonares.lblPanaal.setText(rs.getString(140));
                }
                if (rs.getString(141) != null) {
                    TelaAvaCardiopulmonares.lblClassificaPanaal.setText(rs.getString(141));
                }
                if (rs.getString(142) != null) {
                    TelaAvaCardiopulmonares.cmbLac.setSelectedItem(rs.getString(142));
                }
                if (rs.getString(143) != null) {
                    TelaAvaCardiopulmonares.txtLacTemp.setText(rs.getString(143));
                }
                if (rs.getString(144) != null) {
                    TelaAvaCardiopulmonares.lblLac.setText(rs.getString(144));
                }
                if (rs.getString(145) != null) {
                    TelaAvaCardiopulmonares.lblLacClass.setText(rs.getString(145));
                }

                /* TelaAvaCardiopulmonares.cmbProtAero.setSelectedItem(rs.getString(112));
                condicao = rs.getString(113);
                TelaAvaCardiopulmonares.txtMin.setText(rs.getString(114));
                TelaAvaCardiopulmonares.txtSeg.setText(rs.getString(115));
                TelaAvaCardiopulmonares.txtDist.setText(rs.getString(116));
                TelaAvaCardiopulmonares.txtPotencia.setText(rs.getString(117));
                TelaAvaCardiopulmonares.txtEstagio.setText(rs.getString(118));
                TelaAvaCardiopulmonares.txtFcQuart.setText(rs.getString(119));
                TelaAvaCardiopulmonares.txtFcQuint.setText(rs.getString(120));
                TelaAvaCardiopulmonares.txtFcBpm.setText(rs.getString(121));
                TelaAvaCardiopulmonares.lblVo2.setText(rs.getString(12));
                TelaAvaCardiopulmonares.lblClassificado.setText(rs.getString(122));
                TelaAvaCardiopulmonares.cmbLatica.setSelectedItem(rs.getString(123));
                TelaAvaCardiopulmonares.txtT1.setText(rs.getString(124));
                TelaAvaCardiopulmonares.txtT2.setText(rs.getString(125));
                TelaAvaCardiopulmonares.txtT3.setText(rs.getString(126));
                TelaAvaCardiopulmonares.txtT4.setText(rs.getString(127));
                TelaAvaCardiopulmonares.txtT5.setText(rs.getString(128));
                TelaAvaCardiopulmonares.txtT6.setText(rs.getString(129));
                TelaAvaCardiopulmonares.txtT7.setText(rs.getString(130));
                TelaAvaCardiopulmonares.txtT8.setText(rs.getString(131));
                TelaAvaCardiopulmonares.txtT9.setText(rs.getString(132));
                TelaAvaCardiopulmonares.txtT10.setText(rs.getString(133));
                TelaAvaCardiopulmonares.txtLatDist.setText(rs.getString(134));
                TelaAvaCardiopulmonares.lblIf.setText(rs.getString(135));
                TelaAvaCardiopulmonares.lbllatClass.setText(rs.getString(136));
                TelaAvaCardiopulmonares.cmbPanaal.setSelectedItem(rs.getString(137));
                TelaAvaCardiopulmonares.txtTempPanaal.setText(rs.getString(138));
                TelaAvaCardiopulmonares.txtDistPanaal.setText(rs.getString(139));
                TelaAvaCardiopulmonares.lblPanaal.setText(rs.getString(140));
                TelaAvaCardiopulmonares.lblClassificaPanaal.setText(rs.getString(141));
                TelaAvaCardiopulmonares.cmbLac.setSelectedItem(rs.getString(142));
                TelaAvaCardiopulmonares.txtLacTemp.setText(rs.getString(143));
                TelaAvaCardiopulmonares.lblLac.setText(rs.getString(144));
                TelaAvaCardiopulmonares.lblLacClass.setText(rs.getString(145));
                 */
                if (condicao.equals("Cardiopata")) {
                    TelaAvaCardiopulmonares.rdbCardiopata.setSelected(true);
                }
                if (condicao.equals("Homem Ativo")) {
                    TelaAvaCardiopulmonares.rdbHomemAss.setSelected(true);
                }
                if (condicao.equals("Mulher Ativa")) {
                    TelaAvaCardiopulmonares.rdbMulherAss.setSelected(true);
                }
                if (condicao.equals("Sedentário (a)")) {
                    TelaAvaCardiopulmonares.rdbSedentario.setSelected(true);
                } else {

                }

            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

    }

    public void setarneuromuscular() {
        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                TelaAvaNeuromuscular.cmbIsoAbs.setSelectedItem(rs.getString(146));
                TelaAvaNeuromuscular.txtIsoAbs.setText(rs.getString(147));
                TelaAvaNeuromuscular.lblIsoAbs.setText(rs.getString(148));
                TelaAvaNeuromuscular.cmbIsoBraco.setSelectedItem(rs.getString(149));
                TelaAvaNeuromuscular.txtIsoBraco.setText(rs.getString(150));
                TelaAvaNeuromuscular.lblIsoBraco.setText(rs.getString(151));
                TelaAvaNeuromuscular.cmbIsoPeito.setSelectedItem(rs.getString(152));
                TelaAvaNeuromuscular.txtIsoPeito.setText(rs.getString(153));
                TelaAvaNeuromuscular.lblIsoPeito.setText(rs.getString(154));
                TelaAvaNeuromuscular.cmbIsoPerna.setSelectedItem(rs.getString(155));
                TelaAvaNeuromuscular.txtIsoPerna.setText(rs.getString(156));
                TelaAvaNeuromuscular.lblIsoPerna.setText(rs.getString(157));
                TelaAvaNeuromuscular.cmbExpBraco.setSelectedItem(rs.getString(158));
                TelaAvaNeuromuscular.txtExpBraco.setText(rs.getString(159));
                TelaAvaNeuromuscular.lblExpBraco.setText(rs.getString(160));
                TelaAvaNeuromuscular.cmbExpVert.setSelectedItem(rs.getString(161));
                TelaAvaNeuromuscular.txtExpVert.setText(rs.getString(162));
                TelaAvaNeuromuscular.lblExpVert.setText(rs.getString(163));
                TelaAvaNeuromuscular.cmbExpHoriz.setSelectedItem(rs.getString(164));
                TelaAvaNeuromuscular.txtExpHoriz.setText(rs.getString(165));
                TelaAvaNeuromuscular.lblExpHoriz.setText(rs.getString(166));
                TelaAvaNeuromuscular.cmbMetSup.setSelectedItem(rs.getString(167));
                TelaAvaNeuromuscular.txtMetSup.setText(rs.getString(168));
                TelaAvaNeuromuscular.lblMetSup.setText(rs.getString(169));
                TelaAvaNeuromuscular.cmbMetDors.setSelectedItem(rs.getString(170));
                TelaAvaNeuromuscular.txtMetDors.setText(rs.getString(171));
                TelaAvaNeuromuscular.lblMetDors.setText(rs.getString(172));
                TelaAvaNeuromuscular.txtVelDist.setText(rs.getString("neuro28"));
                TelaAvaNeuromuscular.txtTempoVeloc.setText(rs.getString("neuro29"));
                TelaAvaNeuromuscular.lblVel.setText(rs.getString("neuro30"));
            } else {
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }

    }

    public void setarcamposPostural() {
        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                if (rs.getBytes(51) != null) {
                    ImageIcon foto1 = new ImageIcon(rs.getBytes(51));
                    TelaAnalisePostural.vfoto1 = rs.getBytes(51);
                    foto1.setImage(foto1.getImage().getScaledInstance(TelaAnalisePostural.lblFoto1.getWidth(), TelaAnalisePostural.lblFoto1.getHeight(), Image.SCALE_AREA_AVERAGING));
                    TelaAnalisePostural.lblFoto1.setIcon(foto1);
                } else {
                    ImageIcon foto1 = new ImageIcon("src/br/com/sa/icones/adicionarfoto.png");
                    foto1.setImage(foto1.getImage().getScaledInstance(TelaAnalisePostural.lblFoto1.getWidth(), TelaAnalisePostural.lblFoto1.getHeight(), Image.SCALE_AREA_AVERAGING));
                }

                if (rs.getBytes(52) != null) {
                    ImageIcon foto2 = new ImageIcon(rs.getBytes(52));
                    TelaAnalisePostural.vfoto2 = rs.getBytes(52);
                    foto2.setImage(foto2.getImage().getScaledInstance(TelaAnalisePostural.lblFoto2.getWidth(), TelaAnalisePostural.lblFoto2.getHeight(), Image.SCALE_AREA_AVERAGING));
                    TelaAnalisePostural.lblFoto2.setIcon(foto2);
                } else {
                    ImageIcon foto2 = new ImageIcon("src/br/com/sa/icones/adicionarfoto.png");
                    foto2.setImage(foto2.getImage().getScaledInstance(TelaAnalisePostural.lblFoto2.getWidth(), TelaAnalisePostural.lblFoto2.getHeight(), Image.SCALE_AREA_AVERAGING));
                }

                if (rs.getBytes(53) != null) {
                    ImageIcon foto3 = new ImageIcon(rs.getBytes(53));
                    TelaAnalisePostural.vfoto3 = rs.getBytes(53);
                    foto3.setImage(foto3.getImage().getScaledInstance(TelaAnalisePostural.lblFoto3.getWidth(), TelaAnalisePostural.lblFoto3.getHeight(), Image.SCALE_AREA_AVERAGING));
                    TelaAnalisePostural.lblFoto3.setIcon(foto3);
                } else {
                    ImageIcon foto3 = new ImageIcon("src/br/com/sa/icones/adicionarfoto.png");
                    foto3.setImage(foto3.getImage().getScaledInstance(TelaAnalisePostural.lblFoto3.getWidth(), TelaAnalisePostural.lblFoto3.getHeight(), Image.SCALE_AREA_AVERAGING));

                }

                if (rs.getBytes(54) != null) {
                    ImageIcon foto4 = new ImageIcon(rs.getBytes(54));
                    TelaAnalisePostural.vfoto4 = rs.getBytes(54);
                    foto4.setImage(foto4.getImage().getScaledInstance(TelaAnalisePostural.lblFoto4.getWidth(), TelaAnalisePostural.lblFoto4.getHeight(), Image.SCALE_AREA_AVERAGING));
                    TelaAnalisePostural.lblFoto4.setIcon(foto4);
                } else {
                    ImageIcon foto4 = new ImageIcon("src/br/com/sa/icones/adicionarfoto.png");
                    foto4.setImage(foto4.getImage().getScaledInstance(TelaAnalisePostural.lblFoto4.getWidth(), TelaAnalisePostural.lblFoto4.getHeight(), Image.SCALE_AREA_AVERAGING));

                }
                TelaAnalisePostural.txtObs.setText(rs.getString(173));
                TelaAnalisePostural.chkPost01.setSelected(rs.getString(174).equals("1"));
                TelaAnalisePostural.chkPost02.setSelected(rs.getString(175).equals("1"));
                TelaAnalisePostural.chkPost03.setSelected(rs.getString(176).equals("1"));
                TelaAnalisePostural.chkPost04.setSelected(rs.getString(177).equals("1"));
                TelaAnalisePostural.chkPost05.setSelected(rs.getString(178).equals("1"));
                TelaAnalisePostural.chkPost06.setSelected(rs.getString(179).equals("1"));
                TelaAnalisePostural.chkPost07.setSelected(rs.getString(180).equals("1"));
                TelaAnalisePostural.chkPost08.setSelected(rs.getString(181).equals("1"));
                TelaAnalisePostural.chkPost09.setSelected(rs.getString(182).equals("1"));
                TelaAnalisePostural.chkPost10.setSelected(rs.getString(183).equals("1"));
                TelaAnalisePostural.chkPost11.setSelected(rs.getString(184).equals("1"));
                TelaAnalisePostural.chkPost12.setSelected(rs.getString(185).equals("1"));
                TelaAnalisePostural.chkPost13.setSelected(rs.getString(186).equals("1"));
                TelaAnalisePostural.chkPost14.setSelected(rs.getString(187).equals("1"));
                TelaAnalisePostural.chkPost15.setSelected(rs.getString(188).equals("1"));
                TelaAnalisePostural.chkPost16.setSelected(rs.getString(189).equals("1"));
                TelaAnalisePostural.chkPost17.setSelected(rs.getString(190).equals("1"));
                TelaAnalisePostural.chkPost18.setSelected(rs.getString(191).equals("1"));
                TelaAnalisePostural.chkPost19.setSelected(rs.getString(192).equals("1"));
                TelaAnalisePostural.txtAlcance.setText(rs.getString(193));
                TelaAnalisePostural.lblClasWels.setText(rs.getString(194));

            } else {

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao adicionar informações da Avaliação! " + e);
        }

    }

    //O METODO ABAIXO SETA OS CAMPOS DOS RADIOBUTTON
    public void setaradiobutons() {

        if (a0 == null) {

        } else {
            if (a0.equals("Sim")) {
                TelaAvaAna.rb1.setSelected(true);
            } else {
                TelaAvaAna.rb2.setSelected(true);
            }
        }
        if (a1 == null) {

        } else {
            if (a1.equals("Sim")) {
                TelaAvaAna.rb3.setSelected(true);
            } else {
                TelaAvaAna.rb4.setSelected(true);
            }
        }
        if (a2 == null) {

        } else {
            if (a2.equals("Sim")) {
                TelaAvaAna.rb5.setSelected(true);
            } else {
                TelaAvaAna.rb6.setSelected(true);
            }
        }
        if (a3 == null) {

        } else {
            if (a3.equals("Sim")) {
                TelaAvaAna.rb7.setSelected(true);
            } else {
                TelaAvaAna.rb8.setSelected(true);
            }
        }
        if (a4 == null) {

        } else {
            if (a4.equals("Sim")) {
                TelaAvaAna.rb9.setSelected(true);
            } else {
                TelaAvaAna.rb10.setSelected(true);
            }
        }
        if (a5 == null) {

        } else {
            if (a5.equals("Sim")) {
                TelaAvaAna.rb11.setSelected(true);
            } else {
                TelaAvaAna.rb12.setSelected(true);
            }
        }
        if (a6 == null) {

        } else {
            if (a6.equals("Sim")) {
                TelaAvaAna.rb13.setSelected(true);
            } else {
                TelaAvaAna.rb14.setSelected(true);
            }
        }
        if (a7 == null) {

        } else {
            if (a7.equals("Sim")) {
                TelaAvaAna.rb15.setSelected(true);
            } else {
                TelaAvaAna.rb16.setSelected(true);
            }
        }
        if (a8 == null) {

        } else {
            if (a8.equals("Sim")) {
                TelaAvaAna.rb17.setSelected(true);
            } else {
                TelaAvaAna.rb18.setSelected(true);
            }
        }
        if (a9 == null) {

        } else {
            if (a9.equals("Sim")) {
                TelaAvaAna.rb19.setSelected(true);
            } else {
                TelaAvaAna.rb20.setSelected(true);
            }
        }
    }

    public void buscasexo() {

        String sql = "select * from clientes where idcli=?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, lblMatricula.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                sexo = rs.getString(11);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro" + e);
        }
    }
    //o metodo abaixo busca o ultimo idava que foi inserido na tabela avaliaçao e seta o campo

    public void buscandoultima() {

        String sql = "select  max(idava) as max from avaliacao1";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            if (rs.next()) {

                lblIdAva.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter número da avaliação!" + e);
        }

    }

    private void imprimirAvaliacao() {
        //imprimindo uma avaliação física
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão desta avaliação?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            //imprimeindo relatorio com o framework do jasper
            try {

                //usdando a classe HashMap para criar um filtro
                /*
                O Código abaixo cria uma paginação no swap da memoria do java
                
                JRAbstractLRUVirtualizer Virtualizer = new JRFileVirtualizer(10,System.getProperty("java.io.tmpdir"));
                 */
 /*O código abaixo é usado para criar uma paginação fora da memoria
                
                JRSwapFile arquivoSwap = new JRSwapFile("c:\\tmp", 4096, 100);
                JRAbstractLRUVirtualizer virtualizer = new JRSwapFileVirtualizer(1, arquivoSwap, true);
                HashMap filtro =  new HashMap();
                filtro.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
                
                 */
                JRAbstractLRUVirtualizer virtualizer = new JRFileVirtualizer(1, System.getProperty("java.io.tmpdir"));
                HashMap filtro = new HashMap(); //dando o filtro para o relatorio ele pega a id da avaliação
                filtro.put(JRParameter.REPORT_VIRTUALIZER, virtualizer); //evitando estouro da memória
                filtro.put("id", Integer.parseInt(lblIdAva.getText()));//passando o parametro

                JasperPrint imprime = JasperFillManager.fillReport("src/br/com/sa/relatorio/AvaliacaoFisica.jasper", filtro, conexao);

                //C:\\Users\\Tarciso\\Desktop\\Relatorio Avaliação Fisica\\Novo\\
                //src\\br\\com\\sa\\relatorio\\
                //a linha abaixo exibe o relatorio a travez da classe viewr
                imprime.setName("Avaliação Física - FlySys");
                JasperViewer.viewReport(imprime, false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Imprimir Avaliação Física" + e);
            }

        }

    }

    //o metodo abaixo reabre a tela inicial e envia as informações novamente.
    public void reabretela() {

        if (PerfilAcesso.equals("Administrador")) {

            TelaPrincipal principal = new TelaPrincipal();//instanciando a tela
            //principal.setExtendedState(JFrame.MAXIMIZED_BOTH);//iniciando a tela maximizado
            principal.setVisible(true);
            //TelaPrincipal.//ativando os botoes desativados pelo perfil
            TelaPrincipal.menNovUso.setEnabled(true);
            TelaPrincipal.menRel.setEnabled(true);
            TelaPrincipal.MenCadProp.setEnabled(true);
            TelaPrincipal.lblUsuario.setText(NomeUso);
            TelaPrincipal.lblPerfil.setText(PerfilAcesso);//aqui passa para o lbl o valor do perfil em banco de dados
            TelaPrincipal.lblData.setText(DataAcesso);

        } else {

            TelaPrincipal principal = new TelaPrincipal();//instanciando a tela
            principal.setVisible(true);
            TelaPrincipal.lblUsuario.setText(NomeUso);
            TelaPrincipal.lblPerfil.setText(PerfilAcesso);//aqui passa para o lbl o valor do perfil em banco de dados
            TelaPrincipal.lblData.setText(DataAcesso);

        }

    }

    public TelaModuloAva() {
        initComponents();
        conexao = ModuloConexao.conector();//devese iniciar a conexao sempre pelo construtor antes de realizar uma consulta
        this.gerenciadorDeJanela = new GerenciadorDeJanelas(DesktopAva);//passar o desktop para dentro da variavel 
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAvaAnaminese = new javax.swing.JButton();
        btnAvaHemo = new javax.swing.JButton();
        btnAvaMedidas = new javax.swing.JButton();
        btnAvaCardio = new javax.swing.JButton();
        btnAvaImpri = new javax.swing.JButton();
        btnAvaSair = new javax.swing.JButton();
        btnAvaInicio = new javax.swing.JButton();
        btnAvaNeuro = new javax.swing.JButton();
        btnAvaPostural = new javax.swing.JButton();
        DesktopAva = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblNomeProfessor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblIdProf = new javax.swing.JLabel();
        lblIdAva = new javax.swing.JLabel();
        lblNomeAluno = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Modulo Avaliação");
        setBackground(new java.awt.Color(255, 247, 241));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Controles"));
        jPanel1.setName("Módulos"); // NOI18N

        btnAvaAnaminese.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/anamnese30x40.png"))); // NOI18N
        btnAvaAnaminese.setText("Anamnese");
        btnAvaAnaminese.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaAnaminese.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaAnaminese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaAnamineseActionPerformed(evt);
            }
        });

        btnAvaHemo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/hemo40x40.png"))); // NOI18N
        btnAvaHemo.setText("Hemodinâmico");
        btnAvaHemo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaHemo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaHemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaHemoActionPerformed(evt);
            }
        });

        btnAvaMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/medidas40x40.png"))); // NOI18N
        btnAvaMedidas.setText("Medidas");
        btnAvaMedidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaMedidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaMedidasActionPerformed(evt);
            }
        });

        btnAvaCardio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/cardio40x40.png"))); // NOI18N
        btnAvaCardio.setText("Cardiopulmonar");
        btnAvaCardio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaCardio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaCardio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaCardioActionPerformed(evt);
            }
        });

        btnAvaImpri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/imprimir30x30.png"))); // NOI18N
        btnAvaImpri.setText("Imprimir");
        btnAvaImpri.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaImpri.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaImpri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaImpriActionPerformed(evt);
            }
        });

        btnAvaSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sair30x30.png"))); // NOI18N
        btnAvaSair.setText("Sair");
        btnAvaSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaSairActionPerformed(evt);
            }
        });

        btnAvaInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/start-icon.png"))); // NOI18N
        btnAvaInicio.setText("Iniciar Avaliação");
        btnAvaInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaInicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaInicioActionPerformed(evt);
            }
        });

        btnAvaNeuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/neuro40x40.png"))); // NOI18N
        btnAvaNeuro.setText("Neuromuscular");
        btnAvaNeuro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaNeuro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaNeuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaNeuroActionPerformed(evt);
            }
        });

        btnAvaPostural.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/sime25x34.jpg"))); // NOI18N
        btnAvaPostural.setText("Análise Postural");
        btnAvaPostural.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAvaPostural.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAvaPostural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaPosturalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAvaAnaminese, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaHemo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaMedidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaCardio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaImpri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaNeuro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaPostural, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAvaInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaAnaminese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaHemo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaMedidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaCardio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaNeuro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaPostural, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaImpri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnAvaSair)
                .addContainerGap())
        );

        DesktopAva.setBackground(new java.awt.Color(255, 247, 241));
        DesktopAva.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DesktopAvaPropertyChange(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/Fundotelaprincipal.png"))); // NOI18N
        DesktopAva.add(jLabel5);
        jLabel5.setBounds(90, 0, 940, 670);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informações"));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Aluno:");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Matrícula:");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Professor:");

        lblMatricula.setText("000000");

        lblNomeProfessor.setText("Nome Professor");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("IdA:");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("IdP:");

        lblIdProf.setText("000");

        lblIdAva.setText("000");

        lblNomeAluno.setText("Nome Aluno");

        lblIdade.setText("00");

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Idade:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdAva, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdProf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNomeAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMatricula)
                    .addComponent(lblIdade)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblNomeProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblIdProf)
                    .addComponent(jLabel7)
                    .addComponent(lblIdAva))
                .addGap(6, 6, 6))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MÓDULO DE AVALIAÇÃO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DesktopAva, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(DesktopAva)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Módulos");
        jPanel1.getAccessibleContext().setAccessibleDescription("Módulos");

        setSize(new java.awt.Dimension(1286, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaSairActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Esta tela esta sendo fechada, deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {

            //TelaModuloAva.this.dispose();
            reabretela();
            TelaModuloAva comp = (TelaModuloAva) SwingUtilities.getRoot(this);
            ((Window) comp).dispose();

        } else {

        }
    }//GEN-LAST:event_btnAvaSairActionPerformed

    private void btnAvaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaInicioActionPerformed
        buscasexo();
        ativabotoes();
        inicioavaliacao();
        buscandoultima();
    }//GEN-LAST:event_btnAvaInicioActionPerformed

    private void btnAvaAnamineseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaAnamineseActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAvaAna.getInstancia());//instanciando a tela pela classe gerenciador de janelas
        setcamposanaminese();
        setaradiobutons();
    }//GEN-LAST:event_btnAvaAnamineseActionPerformed

    private void btnAvaHemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaHemoActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAvaHemo.getInstancia());//instanciando a tela pela classe gerenciador de janelas
        TelaAvaHemo.txtHemoIdade.setText(lblIdade.getText());
        setcamposhemodinamicos();

        /*TelaAvaHemo hemo = new TelaAvaHemo();
        hemo.setVisible(true);
        hemo.txtHemoIdade.setText(lblIdade.getText());
        setcamposhemodinamicos();
        DesktopAva.add(hemo);
         */
    }//GEN-LAST:event_btnAvaHemoActionPerformed

    private void btnAvaMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaMedidasActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAvaMedidas.getInstancia());//instanciando a tela pela classe gerenciador de janelas
        setcamposmedidas();

        /* TelaAvaMedidas medida = new TelaAvaMedidas();
        medida.setVisible(true);
        setcamposmedidas();
        DesktopAva.add(medida);
         */
// TODO add your handling code here:
    }//GEN-LAST:event_btnAvaMedidasActionPerformed

    private void DesktopAvaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DesktopAvaPropertyChange

    }//GEN-LAST:event_DesktopAvaPropertyChange

    private void btnAvaCardioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaCardioActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAvaCardiopulmonares.getInstancia());//instanciando a tela pela classe gerenciador de janelas
        setcamposcardio();

        /*        TelaAvaCardiopulmonares cardio = new TelaAvaCardiopulmonares();
        cardio.setVisible(true);
        setcamposcardio();
        DesktopAva.add(cardio);
         */
    }//GEN-LAST:event_btnAvaCardioActionPerformed

    private void btnAvaNeuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaNeuroActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAvaNeuromuscular.getInstancia());//instanciando a tela pela classe gerenciador de janelas
        setarneuromuscular();

        /*        TelaAvaNeuromuscular neuro = new TelaAvaNeuromuscular();
        neuro.setVisible(true);
        setarneuromuscular();
        DesktopAva.add(neuro);
         */
    }//GEN-LAST:event_btnAvaNeuroActionPerformed

    private void btnAvaPosturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaPosturalActionPerformed
        gerenciadorDeJanela.abrirJanelas(TelaAnalisePostural.getInstancia());
        setarcamposPostural();

        /*        TelaAnalisePostural analise = new TelaAnalisePostural();
        analise.setVisible(true);
        setarcamposPostural();
        DesktopAva.add(analise);
         */
    }//GEN-LAST:event_btnAvaPosturalActionPerformed

    private void btnAvaImpriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaImpriActionPerformed
        imprimirAvaliacao();               // TODO add your handling code here:
    }//GEN-LAST:event_btnAvaImpriActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int adicionar = JOptionPane.showConfirmDialog(null, "Esta tela esta sendo fechada, deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (adicionar == JOptionPane.YES_OPTION) {

            reabretela();//chama a tela principal

            //abaixo fecha a tela modulo ava
            TelaModuloAva comp = (TelaModuloAva) SwingUtilities.getRoot(this);
            ((Window) comp).dispose();

            //TelaModuloAva.this.dispose(); metodo antigo de fechar a janela
        } else {

        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaModuloAva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModuloAva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModuloAva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModuloAva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModuloAva().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane DesktopAva;
    public static javax.swing.JButton btnAvaAnaminese;
    public static javax.swing.JButton btnAvaCardio;
    public static javax.swing.JButton btnAvaHemo;
    public static javax.swing.JButton btnAvaImpri;
    public static javax.swing.JButton btnAvaInicio;
    public static javax.swing.JButton btnAvaMedidas;
    public static javax.swing.JButton btnAvaNeuro;
    public static javax.swing.JButton btnAvaPostural;
    private javax.swing.JButton btnAvaSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblIdAva;
    public static javax.swing.JLabel lblIdProf;
    public static javax.swing.JLabel lblIdade;
    public static javax.swing.JLabel lblMatricula;
    public static javax.swing.JLabel lblNomeAluno;
    public static javax.swing.JLabel lblNomeProfessor;
    // End of variables declaration//GEN-END:variables
}
