package br.com.sa.telas;

public class TelaMacrociclo extends javax.swing.JInternalFrame {

    public static TelaMacrociclo telaMacro;

    public static TelaMacrociclo getInstancia() {
        if (telaMacro == null) {

            telaMacro = new TelaMacrociclo();

        }
        return telaMacro;
    }

    public void duracao() {

        if (cmbDuracao.getSelectedItem().equals("Semestral")) {

            lblData17.setVisible(true);
            lblData18.setVisible(true);
            lblData19.setVisible(true);
            lblData20.setVisible(true);
            lblData21.setVisible(true);
            lblData22.setVisible(true);
            lblData23.setVisible(true);
            lblData24.setVisible(true);
            cmbMicro17.setVisible(true);
            cmbMicro18.setVisible(true);
            cmbMicro19.setVisible(true);
            cmbMicro20.setVisible(true);
            cmbMicro21.setVisible(true);
            cmbMicro22.setVisible(true);
            cmbMicro23.setVisible(true);
            cmbMicro24.setVisible(true);
            cmbMeso05.setVisible(true);
            cmbMeso06.setVisible(true);
            lblVol17.setVisible(true);
            lblVol18.setVisible(true);
            lblVol19.setVisible(true);
            lblVol20.setVisible(true);
            lblVol21.setVisible(true);
            lblVol22.setVisible(true);
            lblVol23.setVisible(true);
            lblVol24.setVisible(true);
            lblInt17.setVisible(true);
            lblInt18.setVisible(true);
            lblInt19.setVisible(true);
            lblInt20.setVisible(true);
            lblInt21.setVisible(true);
            lblInt22.setVisible(true);
            lblInt23.setVisible(true);
            lblInt24.setVisible(true);

        } else {
            lblData17.setVisible(false);
            lblData18.setVisible(false);
            lblData19.setVisible(false);
            lblData20.setVisible(false);
            lblData21.setVisible(false);
            lblData22.setVisible(false);
            lblData23.setVisible(false);
            lblData24.setVisible(false);
            cmbMicro17.setVisible(false);
            cmbMicro18.setVisible(false);
            cmbMicro19.setVisible(false);
            cmbMicro20.setVisible(false);
            cmbMicro21.setVisible(false);
            cmbMicro22.setVisible(false);
            cmbMicro23.setVisible(false);
            cmbMicro24.setVisible(false);
            cmbMeso05.setVisible(false);
            cmbMeso06.setVisible(false);
            lblVol17.setVisible(false);
            lblVol18.setVisible(false);
            lblVol19.setVisible(false);
            lblVol20.setVisible(false);
            lblVol21.setVisible(false);
            lblVol22.setVisible(false);
            lblVol23.setVisible(false);
            lblVol24.setVisible(false);
            lblInt17.setVisible(false);
            lblInt18.setVisible(false);
            lblInt19.setVisible(false);
            lblInt20.setVisible(false);
            lblInt21.setVisible(false);
            lblInt22.setVisible(false);
            lblInt23.setVisible(false);
            lblInt24.setVisible(false);

        }

    }

    public void definircor() {

        if (cor.equals("Ordinário")) {

        }

    }
    String cor;

    public void colorirMicro() {

        cor = cmbMicro01.getSelectedItem().toString();
        definircor();
        cor = cmbMicro01.getSelectedItem().toString();
        
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();
        cor = cmbMicro01.getSelectedItem().toString();

    }

    public void automatico() {

        if (cmbDuracao.getSelectedItem().equals("Quadrimestral")) {

            cmbMicro01.setSelectedItem("Ordinário");
            cmbMicro02.setSelectedItem("Ordinário");
            cmbMicro03.setSelectedItem("Choque");
            cmbMicro04.setSelectedItem("Ordinário");
            cmbMicro05.setSelectedItem("Ordinário");
            cmbMicro06.setSelectedItem("Choque");
            cmbMicro07.setSelectedItem("Recuperação");
            cmbMicro08.setSelectedItem("Ordinário");
            cmbMicro09.setSelectedItem("Choque");
            cmbMicro10.setSelectedItem("Ordinário");
            cmbMicro11.setSelectedItem("Choque");
            cmbMicro12.setSelectedItem("Recuperação");
            cmbMicro13.setSelectedItem("Ordinário");
            cmbMicro14.setSelectedItem("Choque");
            cmbMicro15.setSelectedItem("Ordinário");
            cmbMicro16.setSelectedItem("Otimização");

            cmbMeso01.setSelectedItem("Aquisição");
            cmbMeso02.setSelectedItem("Aprimoramento");
            cmbMeso03.setSelectedItem("Melhoria");
            cmbMeso04.setSelectedItem("Otimização");

        } else {

            cmbMicro01.setSelectedItem("Ordinário");
            cmbMicro02.setSelectedItem("Ordinário");
            cmbMicro03.setSelectedItem("Ordinário");
            cmbMicro04.setSelectedItem("Choque");
            cmbMicro05.setSelectedItem("Ordinário");
            cmbMicro06.setSelectedItem("Ordinário");
            cmbMicro07.setSelectedItem("Choque");
            cmbMicro08.setSelectedItem("Recuperação");
            cmbMicro09.setSelectedItem("Ordinário");
            cmbMicro10.setSelectedItem("Choque");
            cmbMicro11.setSelectedItem("Ordinário");
            cmbMicro12.setSelectedItem("Choque");
            cmbMicro13.setSelectedItem("Recuperação");
            cmbMicro14.setSelectedItem("Ordinário");
            cmbMicro15.setSelectedItem("Choque");
            cmbMicro16.setSelectedItem("Ordinário");
            cmbMicro17.setSelectedItem("Choque");
            cmbMicro18.setSelectedItem("Recuperação");
            cmbMicro19.setSelectedItem("Ordinário");
            cmbMicro20.setSelectedItem("Choque");
            cmbMicro21.setSelectedItem("Ordinário");
            cmbMicro22.setSelectedItem("Choque");
            cmbMicro23.setSelectedItem("Ordinário");
            cmbMicro24.setSelectedItem("Otimização");

            cmbMeso01.setSelectedItem("Aquisição");
            cmbMeso02.setSelectedItem("Aprimoramento");
            cmbMeso03.setSelectedItem("Melhoria");
            cmbMeso04.setSelectedItem("Aprimoramento");
            cmbMeso05.setSelectedItem("Melhoria");
            cmbMeso06.setSelectedItem("Otimização");

        }

    }

    public TelaMacrociclo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblExpMs = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblVelocidade = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblExpMi = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblFlex = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblBraco = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblAbd = new javax.swing.JLabel();
        lblDebito = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblVo2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblAla = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblPerna = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cmbDuracao = new javax.swing.JComboBox<>();
        cmbMelhoria = new javax.swing.JComboBox<>();
        btnOk = new javax.swing.JButton();
        cmbObjetivo1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDataInicio1 = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        cmbMicro24 = new javax.swing.JComboBox<>();
        cmbMicro02 = new javax.swing.JComboBox<>();
        cmbMicro03 = new javax.swing.JComboBox<>();
        cmbMicro04 = new javax.swing.JComboBox<>();
        cmbMicro05 = new javax.swing.JComboBox<>();
        cmbMicro06 = new javax.swing.JComboBox<>();
        cmbMicro07 = new javax.swing.JComboBox<>();
        cmbMicro08 = new javax.swing.JComboBox<>();
        cmbMicro09 = new javax.swing.JComboBox<>();
        cmbMicro10 = new javax.swing.JComboBox<>();
        cmbMicro11 = new javax.swing.JComboBox<>();
        cmbMicro12 = new javax.swing.JComboBox<>();
        cmbMicro13 = new javax.swing.JComboBox<>();
        cmbMicro14 = new javax.swing.JComboBox<>();
        cmbMicro15 = new javax.swing.JComboBox<>();
        cmbMicro16 = new javax.swing.JComboBox<>();
        cmbMicro17 = new javax.swing.JComboBox<>();
        cmbMicro18 = new javax.swing.JComboBox<>();
        cmbMicro19 = new javax.swing.JComboBox<>();
        cmbMicro20 = new javax.swing.JComboBox<>();
        cmbMicro21 = new javax.swing.JComboBox<>();
        cmbMicro22 = new javax.swing.JComboBox<>();
        cmbMicro23 = new javax.swing.JComboBox<>();
        lblData24 = new javax.swing.JLabel();
        lblInt01 = new javax.swing.JLabel();
        lblData02 = new javax.swing.JLabel();
        lblData03 = new javax.swing.JLabel();
        lblData04 = new javax.swing.JLabel();
        lblData05 = new javax.swing.JLabel();
        lblData06 = new javax.swing.JLabel();
        lblData07 = new javax.swing.JLabel();
        lblData08 = new javax.swing.JLabel();
        lblData09 = new javax.swing.JLabel();
        lblData10 = new javax.swing.JLabel();
        lblData11 = new javax.swing.JLabel();
        lblData12 = new javax.swing.JLabel();
        lblData13 = new javax.swing.JLabel();
        lblData14 = new javax.swing.JLabel();
        lblData15 = new javax.swing.JLabel();
        lblData16 = new javax.swing.JLabel();
        lblData17 = new javax.swing.JLabel();
        lblData18 = new javax.swing.JLabel();
        lblData19 = new javax.swing.JLabel();
        lblData20 = new javax.swing.JLabel();
        lblData21 = new javax.swing.JLabel();
        lblData22 = new javax.swing.JLabel();
        lblData23 = new javax.swing.JLabel();
        cmbMicro01 = new javax.swing.JComboBox<>();
        cmbMeso06 = new javax.swing.JComboBox<>();
        cmbMeso01 = new javax.swing.JComboBox<>();
        cmbMeso02 = new javax.swing.JComboBox<>();
        cmbMeso03 = new javax.swing.JComboBox<>();
        cmbMeso04 = new javax.swing.JComboBox<>();
        cmbMeso05 = new javax.swing.JComboBox<>();
        lblData01 = new javax.swing.JLabel();
        lblVol01 = new javax.swing.JLabel();
        lblVol02 = new javax.swing.JLabel();
        lblInt02 = new javax.swing.JLabel();
        lblVol03 = new javax.swing.JLabel();
        lblInt03 = new javax.swing.JLabel();
        lblVol04 = new javax.swing.JLabel();
        lblInt04 = new javax.swing.JLabel();
        lblInt05 = new javax.swing.JLabel();
        lblVol05 = new javax.swing.JLabel();
        lblVol06 = new javax.swing.JLabel();
        lblInt06 = new javax.swing.JLabel();
        lblVol07 = new javax.swing.JLabel();
        lblInt07 = new javax.swing.JLabel();
        lblVol08 = new javax.swing.JLabel();
        lblInt08 = new javax.swing.JLabel();
        lblVol09 = new javax.swing.JLabel();
        lblInt09 = new javax.swing.JLabel();
        lblVol10 = new javax.swing.JLabel();
        lblInt10 = new javax.swing.JLabel();
        lblInt11 = new javax.swing.JLabel();
        lblVol11 = new javax.swing.JLabel();
        lblVol12 = new javax.swing.JLabel();
        lblInt12 = new javax.swing.JLabel();
        lblVol13 = new javax.swing.JLabel();
        lblInt13 = new javax.swing.JLabel();
        lblInt14 = new javax.swing.JLabel();
        lblVol14 = new javax.swing.JLabel();
        lblInt15 = new javax.swing.JLabel();
        lblVol15 = new javax.swing.JLabel();
        lblVol17 = new javax.swing.JLabel();
        lblInt17 = new javax.swing.JLabel();
        lblInt16 = new javax.swing.JLabel();
        lblVol16 = new javax.swing.JLabel();
        lblInt18 = new javax.swing.JLabel();
        lblVol18 = new javax.swing.JLabel();
        lblInt19 = new javax.swing.JLabel();
        lblVol19 = new javax.swing.JLabel();
        lblVol20 = new javax.swing.JLabel();
        lblInt20 = new javax.swing.JLabel();
        lblInt21 = new javax.swing.JLabel();
        lblVol21 = new javax.swing.JLabel();
        lblInt22 = new javax.swing.JLabel();
        lblVol22 = new javax.swing.JLabel();
        lblVol23 = new javax.swing.JLabel();
        lblInt23 = new javax.swing.JLabel();
        lblVol24 = new javax.swing.JLabel();
        lblInt24 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 247, 241));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/macro700x63.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(330, 0, 700, 63);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Parâmetros do Macrociclo");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 310, 310, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(30, 340, 270, 10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Determinação de Volúme");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 160, 290, 30);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(30, 30, 270, 10);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Flexibilidade Toracolombar ----------");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 140, 180, 14);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("m");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(230, 80, 30, 14);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Força Explosiva Membro Superior --");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 80, 180, 14);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Força Explosiva Membro Inferior ---");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 100, 180, 14);

        lblExpMs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExpMs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpMs.setText("0");
        jPanel2.add(lblExpMs);
        lblExpMs.setBounds(190, 80, 40, 15);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Velocidade de Deslocamento --------");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 60, 180, 14);

        lblVelocidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVelocidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidade.setText("0");
        jPanel2.add(lblVelocidade);
        lblVelocidade.setBounds(190, 60, 40, 15);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("km/h");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(230, 60, 30, 14);

        lblExpMi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExpMi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExpMi.setText("0");
        jPanel2.add(lblExpMi);
        lblExpMi.setBounds(190, 100, 40, 15);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("m");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(230, 100, 30, 14);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("cm");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(230, 140, 40, 14);

        lblFlex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFlex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFlex.setText("0");
        jPanel2.add(lblFlex);
        lblFlex.setBounds(190, 140, 40, 15);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Volúme Máximo de Oxigênio ---------");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 190, 180, 14);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Melhoria Funcional:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 454, 100, 28);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("RLM de Abdomem ---------------------");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(20, 230, 180, 14);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("RLM de Braços -------------------------");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(20, 250, 180, 14);

        lblBraco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBraco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBraco.setText("0");
        jPanel2.add(lblBraco);
        lblBraco.setBounds(190, 250, 40, 15);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("repetições");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(230, 250, 60, 14);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("repetições");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(230, 230, 50, 14);

        lblAbd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAbd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAbd.setText("0");
        jPanel2.add(lblAbd);
        lblAbd.setBounds(190, 230, 40, 15);

        lblDebito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDebito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDebito.setText("0");
        jPanel2.add(lblDebito);
        lblDebito.setBounds(190, 210, 40, 15);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("l/min");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(230, 210, 30, 14);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("ml (kg.min)¹");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(230, 190, 60, 14);

        lblVo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVo2.setText("0");
        jPanel2.add(lblVo2);
        lblVo2.setBounds(190, 190, 40, 15);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Capacidade Anaeróbica Alática-----");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(20, 120, 180, 14);

        lblAla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAla.setText("0");
        jPanel2.add(lblAla);
        lblAla.setBounds(190, 120, 40, 15);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("panaal");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(230, 120, 40, 14);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("RLM de Pernas -------------------------");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(20, 270, 180, 14);

        lblPerna.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPerna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerna.setText("0");
        jPanel2.add(lblPerna);
        lblPerna.setBounds(190, 270, 40, 15);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("repetições");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(230, 270, 60, 14);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Débito Cardíaco -----------------------");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(20, 210, 180, 14);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Data de Início:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(30, 350, 100, 28);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Duração:");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(30, 421, 100, 28);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Objetivo:");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(30, 385, 100, 28);

        cmbDuracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Quadrimestral", "Semestral" }));
        cmbDuracao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDuracaoItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbDuracao);
        cmbDuracao.setBounds(140, 420, 160, 28);

        cmbMelhoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%" }));
        jPanel2.add(cmbMelhoria);
        cmbMelhoria.setBounds(140, 454, 110, 28);

        btnOk.setText("OK");
        jPanel2.add(btnOk);
        btnOk.setBounds(253, 454, 47, 28);

        cmbObjetivo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Hipertrofia", "Emagrecimento" }));
        jPanel2.add(cmbObjetivo1);
        cmbObjetivo1.setBounds(140, 385, 160, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Parâmetros da Avaliação Física");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 3, 290, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Determinação de Intensidade");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 30, 290, 30);

        try {
            txtDataInicio1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataInicio1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtDataInicio1);
        txtDataInicio1.setBounds(140, 350, 160, 28);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/fundoMacro640x335.png"))); // NOI18N
        jPanel2.add(jLabel31);
        jLabel31.setBounds(-1, -1, 335, 640);

        cmbMicro24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro24);
        cmbMicro24.setBounds(472, 594, 90, 20);

        cmbMicro02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro02);
        cmbMicro02.setBounds(472, 132, 90, 20);

        cmbMicro03.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        cmbMicro03.setSelectedItem("Choque");
        jPanel2.add(cmbMicro03);
        cmbMicro03.setBounds(472, 153, 90, 20);

        cmbMicro04.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro04);
        cmbMicro04.setBounds(472, 174, 90, 20);

        cmbMicro05.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro05);
        cmbMicro05.setBounds(472, 195, 90, 20);

        cmbMicro06.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro06);
        cmbMicro06.setBounds(472, 216, 90, 20);

        cmbMicro07.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro07);
        cmbMicro07.setBounds(472, 237, 90, 20);

        cmbMicro08.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro08);
        cmbMicro08.setBounds(472, 258, 90, 20);

        cmbMicro09.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro09);
        cmbMicro09.setBounds(472, 279, 90, 20);

        cmbMicro10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro10);
        cmbMicro10.setBounds(472, 300, 90, 20);

        cmbMicro11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro11);
        cmbMicro11.setBounds(472, 321, 90, 20);

        cmbMicro12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro12);
        cmbMicro12.setBounds(472, 342, 90, 20);

        cmbMicro13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro13);
        cmbMicro13.setBounds(472, 363, 90, 20);

        cmbMicro14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro14);
        cmbMicro14.setBounds(472, 384, 90, 20);

        cmbMicro15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro15);
        cmbMicro15.setBounds(472, 405, 90, 20);

        cmbMicro16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro16);
        cmbMicro16.setBounds(472, 426, 90, 20);

        cmbMicro17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro17);
        cmbMicro17.setBounds(472, 447, 90, 20);

        cmbMicro18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro18);
        cmbMicro18.setBounds(472, 468, 90, 20);

        cmbMicro19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro19);
        cmbMicro19.setBounds(472, 489, 90, 20);

        cmbMicro20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro20);
        cmbMicro20.setBounds(472, 510, 90, 20);

        cmbMicro21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro21);
        cmbMicro21.setBounds(472, 531, 90, 20);

        cmbMicro22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro22);
        cmbMicro22.setBounds(472, 552, 90, 20);

        cmbMicro23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        jPanel2.add(cmbMicro23);
        cmbMicro23.setBounds(472, 573, 90, 20);

        lblData24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData24.setText("00/00/0000");
        lblData24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData24);
        lblData24.setBounds(395, 594, 70, 20);

        lblInt01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt01.setText("0%");
        lblInt01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt01);
        lblInt01.setBounds(780, 111, 70, 20);

        lblData02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData02.setText("00/00/0000");
        lblData02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData02);
        lblData02.setBounds(395, 132, 70, 20);

        lblData03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData03.setText("00/00/0000");
        lblData03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData03);
        lblData03.setBounds(395, 153, 70, 20);

        lblData04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData04.setText("00/00/0000");
        lblData04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData04);
        lblData04.setBounds(395, 174, 70, 20);

        lblData05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData05.setText("00/00/0000");
        lblData05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData05);
        lblData05.setBounds(395, 195, 70, 20);

        lblData06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData06.setText("00/00/0000");
        lblData06.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData06);
        lblData06.setBounds(395, 216, 70, 20);

        lblData07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData07.setText("00/00/0000");
        lblData07.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData07);
        lblData07.setBounds(395, 237, 70, 20);

        lblData08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData08.setText("00/00/0000");
        lblData08.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData08);
        lblData08.setBounds(395, 258, 70, 20);

        lblData09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData09.setText("00/00/0000");
        lblData09.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData09);
        lblData09.setBounds(395, 279, 70, 20);

        lblData10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData10.setText("00/00/0000");
        lblData10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData10);
        lblData10.setBounds(395, 300, 70, 20);

        lblData11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData11.setText("00/00/0000");
        lblData11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData11);
        lblData11.setBounds(395, 321, 70, 20);

        lblData12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData12.setText("00/00/0000");
        lblData12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData12);
        lblData12.setBounds(395, 342, 70, 20);

        lblData13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData13.setText("00/00/0000");
        lblData13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData13);
        lblData13.setBounds(395, 363, 70, 20);

        lblData14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData14.setText("00/00/0000");
        lblData14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData14);
        lblData14.setBounds(395, 384, 70, 20);

        lblData15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData15.setText("00/00/0000");
        lblData15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData15);
        lblData15.setBounds(395, 405, 70, 20);

        lblData16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData16.setText("00/00/0000");
        lblData16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData16);
        lblData16.setBounds(395, 426, 70, 20);

        lblData17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData17.setText("00/00/0000");
        lblData17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData17);
        lblData17.setBounds(395, 447, 70, 20);

        lblData18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData18.setText("00/00/0000");
        lblData18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData18);
        lblData18.setBounds(395, 468, 70, 20);

        lblData19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData19.setText("00/00/0000");
        lblData19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData19);
        lblData19.setBounds(395, 489, 70, 20);

        lblData20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData20.setText("00/00/0000");
        lblData20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData20);
        lblData20.setBounds(395, 510, 70, 20);

        lblData21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData21.setText("00/00/0000");
        lblData21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData21);
        lblData21.setBounds(395, 531, 70, 20);

        lblData22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData22.setText("00/00/0000");
        lblData22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData22);
        lblData22.setBounds(395, 552, 70, 20);

        lblData23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData23.setText("00/00/0000");
        lblData23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData23);
        lblData23.setBounds(395, 573, 70, 20);

        cmbMicro01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinário", "Otimização", "Choque", "Recuperação" }));
        cmbMicro01.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMicro01ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMicro01);
        cmbMicro01.setBounds(472, 111, 90, 20);

        cmbMeso06.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aquisição", "Aprimoramento", "Melhoria", "Otimização" }));
        cmbMeso06.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMeso06ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMeso06);
        cmbMeso06.setBounds(570, 531, 110, 83);

        cmbMeso01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aquisição", "Aprimoramento", "Melhoria", "Otimização" }));
        cmbMeso01.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMeso01ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMeso01);
        cmbMeso01.setBounds(570, 111, 110, 83);

        cmbMeso02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aquisição", "Aprimoramento", "Melhoria", "Otimização" }));
        cmbMeso02.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMeso02ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMeso02);
        cmbMeso02.setBounds(570, 195, 110, 83);

        cmbMeso03.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aquisição", "Aprimoramento", "Melhoria", "Otimização" }));
        cmbMeso03.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMeso03ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMeso03);
        cmbMeso03.setBounds(570, 279, 110, 83);

        cmbMeso04.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aquisição", "Aprimoramento", "Melhoria", "Otimização" }));
        cmbMeso04.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMeso04ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMeso04);
        cmbMeso04.setBounds(570, 363, 110, 83);

        cmbMeso05.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aquisição", "Aprimoramento", "Melhoria", "Otimização" }));
        cmbMeso05.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMeso05ItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbMeso05);
        cmbMeso05.setBounds(570, 447, 110, 83);

        lblData01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData01.setText("00/00/0000");
        lblData01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblData01);
        lblData01.setBounds(395, 111, 70, 20);

        lblVol01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol01.setText("0%");
        lblVol01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol01);
        lblVol01.setBounds(700, 111, 70, 20);

        lblVol02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol02.setText("0%");
        lblVol02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol02);
        lblVol02.setBounds(700, 132, 70, 20);

        lblInt02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt02.setText("0%");
        lblInt02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt02);
        lblInt02.setBounds(780, 132, 70, 20);

        lblVol03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol03.setText("0%");
        lblVol03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol03);
        lblVol03.setBounds(700, 153, 70, 20);

        lblInt03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt03.setText("0%");
        lblInt03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt03);
        lblInt03.setBounds(780, 153, 70, 20);

        lblVol04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol04.setText("0%");
        lblVol04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol04);
        lblVol04.setBounds(700, 174, 70, 20);

        lblInt04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt04.setText("0%");
        lblInt04.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt04);
        lblInt04.setBounds(780, 174, 70, 20);

        lblInt05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt05.setText("0%");
        lblInt05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt05);
        lblInt05.setBounds(780, 195, 70, 20);

        lblVol05.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol05.setText("0%");
        lblVol05.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol05);
        lblVol05.setBounds(700, 195, 70, 20);

        lblVol06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol06.setText("0%");
        lblVol06.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol06);
        lblVol06.setBounds(700, 216, 70, 20);

        lblInt06.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt06.setText("0%");
        lblInt06.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt06);
        lblInt06.setBounds(780, 216, 70, 20);

        lblVol07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol07.setText("0%");
        lblVol07.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol07);
        lblVol07.setBounds(700, 237, 70, 20);

        lblInt07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt07.setText("0%");
        lblInt07.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt07);
        lblInt07.setBounds(780, 237, 70, 20);

        lblVol08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol08.setText("0%");
        lblVol08.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol08);
        lblVol08.setBounds(700, 258, 70, 20);

        lblInt08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt08.setText("0%");
        lblInt08.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt08);
        lblInt08.setBounds(780, 258, 70, 20);

        lblVol09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol09.setText("0%");
        lblVol09.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol09);
        lblVol09.setBounds(700, 279, 70, 20);

        lblInt09.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt09.setText("0%");
        lblInt09.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt09);
        lblInt09.setBounds(780, 279, 70, 20);

        lblVol10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol10.setText("0%");
        lblVol10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol10);
        lblVol10.setBounds(700, 300, 70, 20);

        lblInt10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt10.setText("0%");
        lblInt10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt10);
        lblInt10.setBounds(780, 300, 70, 20);

        lblInt11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt11.setText("0%");
        lblInt11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt11);
        lblInt11.setBounds(780, 321, 70, 20);

        lblVol11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol11.setText("0%");
        lblVol11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol11);
        lblVol11.setBounds(700, 321, 70, 20);

        lblVol12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol12.setText("0%");
        lblVol12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol12);
        lblVol12.setBounds(700, 342, 70, 20);

        lblInt12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt12.setText("0%");
        lblInt12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt12);
        lblInt12.setBounds(780, 342, 70, 20);

        lblVol13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol13.setText("0%");
        lblVol13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol13);
        lblVol13.setBounds(700, 363, 70, 20);

        lblInt13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt13.setText("0%");
        lblInt13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt13);
        lblInt13.setBounds(780, 363, 70, 20);

        lblInt14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt14.setText("0%");
        lblInt14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt14);
        lblInt14.setBounds(780, 384, 70, 20);

        lblVol14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol14.setText("0%");
        lblVol14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol14);
        lblVol14.setBounds(700, 384, 70, 20);

        lblInt15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt15.setText("0%");
        lblInt15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt15);
        lblInt15.setBounds(780, 405, 70, 20);

        lblVol15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol15.setText("0%");
        lblVol15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol15);
        lblVol15.setBounds(700, 405, 70, 20);

        lblVol17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol17.setText("0%");
        lblVol17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol17);
        lblVol17.setBounds(700, 447, 70, 20);

        lblInt17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt17.setText("0%");
        lblInt17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt17);
        lblInt17.setBounds(780, 447, 70, 20);

        lblInt16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt16.setText("0%");
        lblInt16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt16);
        lblInt16.setBounds(780, 426, 70, 20);

        lblVol16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol16.setText("0%");
        lblVol16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol16);
        lblVol16.setBounds(700, 426, 70, 20);

        lblInt18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt18.setText("0%");
        lblInt18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt18);
        lblInt18.setBounds(780, 468, 70, 20);

        lblVol18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol18.setText("0%");
        lblVol18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol18);
        lblVol18.setBounds(700, 468, 70, 20);

        lblInt19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt19.setText("0%");
        lblInt19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt19);
        lblInt19.setBounds(780, 489, 70, 20);

        lblVol19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol19.setText("0%");
        lblVol19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol19);
        lblVol19.setBounds(700, 489, 70, 20);

        lblVol20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol20.setText("0%");
        lblVol20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol20);
        lblVol20.setBounds(700, 510, 70, 20);

        lblInt20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt20.setText("0%");
        lblInt20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt20);
        lblInt20.setBounds(780, 510, 70, 20);

        lblInt21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt21.setText("0%");
        lblInt21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt21);
        lblInt21.setBounds(780, 531, 70, 20);

        lblVol21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol21.setText("0%");
        lblVol21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol21);
        lblVol21.setBounds(700, 531, 70, 20);

        lblInt22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt22.setText("0%");
        lblInt22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt22);
        lblInt22.setBounds(780, 552, 70, 20);

        lblVol22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol22.setText("0%");
        lblVol22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol22);
        lblVol22.setBounds(700, 552, 70, 20);

        lblVol23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol23.setText("0%");
        lblVol23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol23);
        lblVol23.setBounds(700, 573, 70, 20);

        lblInt23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt23.setText("0%");
        lblInt23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt23);
        lblInt23.setBounds(780, 573, 70, 20);

        lblVol24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVol24.setText("0%");
        lblVol24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblVol24);
        lblVol24.setBounds(700, 594, 70, 20);

        lblInt24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInt24.setText("0%");
        lblInt24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblInt24);
        lblInt24.setBounds(780, 594, 70, 20);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("Intensidade");
        jPanel2.add(jLabel103);
        jLabel103.setBounds(780, 90, 70, 14);

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Data");
        jPanel2.add(jLabel104);
        jLabel104.setBounds(395, 90, 70, 15);

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Microciclo");
        jPanel2.add(jLabel105);
        jLabel105.setBounds(470, 90, 90, 14);

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Mesociclo");
        jPanel2.add(jLabel106);
        jLabel106.setBounds(570, 90, 110, 14);

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Volúme");
        jPanel2.add(jLabel107);
        jLabel107.setBounds(700, 90, 70, 14);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1032, 643));

        setBounds(0, 0, 1048, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMicro01ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMicro01ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMicro01ItemStateChanged

    private void cmbMeso06ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMeso06ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMeso06ItemStateChanged

    private void cmbMeso01ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMeso01ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMeso01ItemStateChanged

    private void cmbMeso02ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMeso02ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMeso02ItemStateChanged

    private void cmbMeso03ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMeso03ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMeso03ItemStateChanged

    private void cmbMeso04ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMeso04ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMeso04ItemStateChanged

    private void cmbMeso05ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMeso05ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMeso05ItemStateChanged

    private void cmbDuracaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDuracaoItemStateChanged
        duracao();
        automatico();
    }//GEN-LAST:event_cmbDuracaoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    public static javax.swing.JComboBox<String> cmbDuracao;
    public static javax.swing.JComboBox<String> cmbMelhoria;
    private javax.swing.JComboBox<String> cmbMeso01;
    private javax.swing.JComboBox<String> cmbMeso02;
    private javax.swing.JComboBox<String> cmbMeso03;
    private javax.swing.JComboBox<String> cmbMeso04;
    private javax.swing.JComboBox<String> cmbMeso05;
    private javax.swing.JComboBox<String> cmbMeso06;
    private javax.swing.JComboBox<String> cmbMicro01;
    private javax.swing.JComboBox<String> cmbMicro02;
    private javax.swing.JComboBox<String> cmbMicro03;
    private javax.swing.JComboBox<String> cmbMicro04;
    private javax.swing.JComboBox<String> cmbMicro05;
    private javax.swing.JComboBox<String> cmbMicro06;
    private javax.swing.JComboBox<String> cmbMicro07;
    private javax.swing.JComboBox<String> cmbMicro08;
    private javax.swing.JComboBox<String> cmbMicro09;
    private javax.swing.JComboBox<String> cmbMicro10;
    private javax.swing.JComboBox<String> cmbMicro11;
    private javax.swing.JComboBox<String> cmbMicro12;
    private javax.swing.JComboBox<String> cmbMicro13;
    private javax.swing.JComboBox<String> cmbMicro14;
    private javax.swing.JComboBox<String> cmbMicro15;
    private javax.swing.JComboBox<String> cmbMicro16;
    private javax.swing.JComboBox<String> cmbMicro17;
    private javax.swing.JComboBox<String> cmbMicro18;
    private javax.swing.JComboBox<String> cmbMicro19;
    private javax.swing.JComboBox<String> cmbMicro20;
    private javax.swing.JComboBox<String> cmbMicro21;
    private javax.swing.JComboBox<String> cmbMicro22;
    private javax.swing.JComboBox<String> cmbMicro23;
    private javax.swing.JComboBox<String> cmbMicro24;
    public static javax.swing.JComboBox<String> cmbObjetivo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lblAbd;
    public static javax.swing.JLabel lblAla;
    public static javax.swing.JLabel lblBraco;
    private javax.swing.JLabel lblData01;
    private javax.swing.JLabel lblData02;
    private javax.swing.JLabel lblData03;
    private javax.swing.JLabel lblData04;
    private javax.swing.JLabel lblData05;
    private javax.swing.JLabel lblData06;
    private javax.swing.JLabel lblData07;
    private javax.swing.JLabel lblData08;
    private javax.swing.JLabel lblData09;
    private javax.swing.JLabel lblData10;
    private javax.swing.JLabel lblData11;
    private javax.swing.JLabel lblData12;
    private javax.swing.JLabel lblData13;
    private javax.swing.JLabel lblData14;
    private javax.swing.JLabel lblData15;
    private javax.swing.JLabel lblData16;
    private javax.swing.JLabel lblData17;
    private javax.swing.JLabel lblData18;
    private javax.swing.JLabel lblData19;
    private javax.swing.JLabel lblData20;
    private javax.swing.JLabel lblData21;
    private javax.swing.JLabel lblData22;
    private javax.swing.JLabel lblData23;
    private javax.swing.JLabel lblData24;
    public static javax.swing.JLabel lblDebito;
    public static javax.swing.JLabel lblExpMi;
    public static javax.swing.JLabel lblExpMs;
    public static javax.swing.JLabel lblFlex;
    private javax.swing.JLabel lblInt01;
    private javax.swing.JLabel lblInt02;
    private javax.swing.JLabel lblInt03;
    private javax.swing.JLabel lblInt04;
    private javax.swing.JLabel lblInt05;
    private javax.swing.JLabel lblInt06;
    private javax.swing.JLabel lblInt07;
    private javax.swing.JLabel lblInt08;
    private javax.swing.JLabel lblInt09;
    private javax.swing.JLabel lblInt10;
    private javax.swing.JLabel lblInt11;
    private javax.swing.JLabel lblInt12;
    private javax.swing.JLabel lblInt13;
    private javax.swing.JLabel lblInt14;
    private javax.swing.JLabel lblInt15;
    private javax.swing.JLabel lblInt16;
    private javax.swing.JLabel lblInt17;
    private javax.swing.JLabel lblInt18;
    private javax.swing.JLabel lblInt19;
    private javax.swing.JLabel lblInt20;
    private javax.swing.JLabel lblInt21;
    private javax.swing.JLabel lblInt22;
    private javax.swing.JLabel lblInt23;
    private javax.swing.JLabel lblInt24;
    public static javax.swing.JLabel lblPerna;
    public static javax.swing.JLabel lblVelocidade;
    public static javax.swing.JLabel lblVo2;
    private javax.swing.JLabel lblVol01;
    private javax.swing.JLabel lblVol02;
    private javax.swing.JLabel lblVol03;
    private javax.swing.JLabel lblVol04;
    private javax.swing.JLabel lblVol05;
    private javax.swing.JLabel lblVol06;
    private javax.swing.JLabel lblVol07;
    private javax.swing.JLabel lblVol08;
    private javax.swing.JLabel lblVol09;
    private javax.swing.JLabel lblVol10;
    private javax.swing.JLabel lblVol11;
    private javax.swing.JLabel lblVol12;
    private javax.swing.JLabel lblVol13;
    private javax.swing.JLabel lblVol14;
    private javax.swing.JLabel lblVol15;
    private javax.swing.JLabel lblVol16;
    private javax.swing.JLabel lblVol17;
    private javax.swing.JLabel lblVol18;
    private javax.swing.JLabel lblVol19;
    private javax.swing.JLabel lblVol20;
    private javax.swing.JLabel lblVol21;
    private javax.swing.JLabel lblVol22;
    private javax.swing.JLabel lblVol23;
    private javax.swing.JLabel lblVol24;
    public static javax.swing.JFormattedTextField txtDataInicio1;
    // End of variables declaration//GEN-END:variables
}
