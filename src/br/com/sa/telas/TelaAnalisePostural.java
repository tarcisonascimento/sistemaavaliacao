package br.com.sa.telas;

import br.com.sa.classes.ClasseSiemetrografia;
import br.com.sa.classes.ManipularImagem;
import br.com.sa.dal.ModuloConexao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaAnalisePostural extends javax.swing.JInternalFrame {

    Connection conexao = null;//usando o metodo de conexao e atribuindo a conexao limpa para iniciar
    PreparedStatement pst = null; //usado para preparar a conexao com o banco de dados
    ResultSet rs = null;//exibe o resultado das instruçoes sql que sera usado no java

    //variaveis de informaçoes importantes do cliente
    public String sexo;
    String localfoto1 = "src/br/com/sa/icones/addfotofundo.png";
    String localfoto2 = "src/br/com/sa/icones/addfotofundo.png";
    String localfoto3 = "src/br/com/sa/icones/addfotofundo.png";
    String localfoto4 = "src/br/com/sa/icones/addfotofundo.png";
    public double peso, estatura, idade;
    public static byte[] vfoto1 = null, vfoto2 = null, vfoto3 = null, vfoto4 = null;
    BufferedImage foto001 = null, foto002 = null, foto003 = null, foto004 = null;
    
     //o metodo abaixo é utilizado para abrir apenas uma janela no Jdesktop
    public static TelaAnalisePostural telaAnalisePostural;
    
    public static TelaAnalisePostural getInstancia(){
        if (telaAnalisePostural == null){
            
            telaAnalisePostural = new TelaAnalisePostural();

        }
        return telaAnalisePostural;
    }
    

    public void buscadados() {

        String sql = "select * from avaliacao1 where idava=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TelaModuloAva.lblIdAva.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                sexo = rs.getString(56);
                idade = Double.parseDouble(rs.getString(58));
                if (rs.getString(50) != null) {
                    estatura = Double.parseDouble(rs.getString(50).replaceAll(",", "."));
                } else {
                    estatura = 0;
                }
                if (rs.getString(49) != null){
                peso = Double.parseDouble(rs.getString(49).replaceAll(",", "."));
                }else{
                peso = 0;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro 01" + e);
        }

    }

    public void incluiranalise() {

        String sql = "update avaliacao1 set fotofrente=?,fotocostas=?,fotodireita=?,fotoesquerda=?,postu01=?,postu02=?,postu03=?,postu04=?,postu05=?,postu06=?,postu07=?,postu08=?,postu09=?,postu10=?,postu11=?,postu12=?,postu13=?,postu14=?,postu15=?,postu16=?,postu17=?,postu18=?,postu19=?,postu20=?,postu21=?,postu22=? where idava=?";

        try {

            pst = conexao.prepareStatement(sql);
            
            if (vfoto1 == null){
               
            String caminho = "src/br/com/sa/icones/addfotofundo.png";  
            foto001 = ManipularImagem.setImagemDimensao(caminho, lblFoto2.getWidth(), lblFoto2.getHeight());
            vfoto1 = ManipularImagem.getImgBytes(foto001);
            pst.setBytes(1, vfoto1);
            }else{
            pst.setBytes(1, vfoto1);
            }
            
            if (vfoto2 == null){
               
            String caminho = "src/br/com/sa/icones/addfotofundo.png";  
            foto002 = ManipularImagem.setImagemDimensao(caminho, lblFoto2.getWidth(), lblFoto2.getHeight());
            vfoto2 = ManipularImagem.getImgBytes(foto002);
            pst.setBytes(2, vfoto2);
            }else{
            pst.setBytes(2, vfoto2);
            }
            
            if (vfoto3 == null){
               
            String caminho = "src/br/com/sa/icones/addfotofundo.png";  
            foto003 = ManipularImagem.setImagemDimensao(caminho, lblFoto3.getWidth(), lblFoto3.getHeight());
            vfoto3 = ManipularImagem.getImgBytes(foto003);
            pst.setBytes(3, vfoto3);
            }else{
            pst.setBytes(3, vfoto3);
            }
            
            if (vfoto4 == null){
               
            String caminho = "src/br/com/sa/icones/addfotofundo.png";  
            foto004 = ManipularImagem.setImagemDimensao(caminho, lblFoto4.getWidth(), lblFoto4.getHeight());
            vfoto4 = ManipularImagem.getImgBytes(foto004);
            pst.setBytes(4, vfoto4);
            }else{
            pst.setBytes(4, vfoto4);
            }
            
            pst.setString(5, txtObs.getText());
            pst.setBoolean(6, chkPost01.isSelected());
            pst.setBoolean(7, chkPost02.isSelected());
            pst.setBoolean(8, chkPost03.isSelected());
            pst.setBoolean(9, chkPost04.isSelected());
            pst.setBoolean(10, chkPost05.isSelected());
            pst.setBoolean(11, chkPost06.isSelected());
            pst.setBoolean(12, chkPost07.isSelected());
            pst.setBoolean(13, chkPost08.isSelected());
            pst.setBoolean(14, chkPost09.isSelected());
            pst.setBoolean(15, chkPost10.isSelected());
            pst.setBoolean(16, chkPost11.isSelected());
            pst.setBoolean(17, chkPost12.isSelected());
            pst.setBoolean(18, chkPost13.isSelected());
            pst.setBoolean(19, chkPost14.isSelected());
            pst.setBoolean(20, chkPost15.isSelected());
            pst.setBoolean(21, chkPost16.isSelected());
            pst.setBoolean(22, chkPost17.isSelected());
            pst.setBoolean(23, chkPost18.isSelected());
            pst.setBoolean(24, chkPost19.isSelected());
            pst.setString(25, txtAlcance.getText());
            pst.setString(26, lblClasWels.getText());
            pst.setString(27, TelaModuloAva.lblIdAva.getText());

            int adicionado = pst.executeUpdate();//caso a adição for concluida cai no if
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Informações Inseridas com Sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir" + e);
            return;

        }

    }

    public void protobancodewells() {
        ClasseSiemetrografia wels = new ClasseSiemetrografia();
        wels.idade = idade;
        wels.sexo = sexo;
        wels.alcance = Double.parseDouble(txtAlcance.getText().replaceAll(",", "."));
        wels.wellsenelson();
        lblClasWels.setText(wels.classifica);

    }

    /*private byte[] pegaImagem() {

        //ImageIcon foto = new ImageIcon(lblFoto1.getIcon().toString()); //pega imagem do icon
        //Image foto1 = foto.getImage(); // joga a imagem pra variavel
        File foto2 = new File(lblFoto1.getIcon().toString()); //cria um arquivo com o icone
        
        boolean isPng = false;

        if (foto2 != null) {

            try {
                BufferedImage foto3 = ImageIO.read(foto2.getAbsoluteFile());
                ByteArrayOutputStream saida = new ByteArrayOutputStream();
                int type = BufferedImage.TYPE_INT_RGB;

                if (isPng) {
                    type = BufferedImage.BITMASK;
                }
                BufferedImage novafoto = new BufferedImage(lblFoto1.getWidth() - 5, lblFoto1.getHeight(), type);//redimencionando a foto
                Graphics2D g = novafoto.createGraphics();//criando o novo arquivo
                g.setComposite(AlphaComposite.Src);
                g.drawImage(foto3, 0, 0, lblFoto1.getWidth() - 5, lblFoto1.getHeight() - 5, null);

                if (isPng) {
                    ImageIO.write(novafoto, "png", saida);
                } else {
                    ImageIO.write(novafoto, "jpg", saida);
                }
                saida.flush();

                byte[] byteArray = saida.toByteArray();
                saida.close();

                return byteArray;

            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Erro ao processar imagem");
                
            }

        }
        return null;

    }
     */
    public TelaAnalisePostural() {
        initComponents();
        conexao = ModuloConexao.conector();//devese iniciar a conexao sempre pelo construtor antes de realizar uma consulta
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnColocaGrade = new javax.swing.JToggleButton();
        lblGrade4 = new javax.swing.JLabel();
        lblFoto4 = new javax.swing.JLabel();
        lblGrade1 = new javax.swing.JLabel();
        lblFoto1 = new javax.swing.JLabel();
        lblGrade3 = new javax.swing.JLabel();
        lblFoto3 = new javax.swing.JLabel();
        lblGrade2 = new javax.swing.JLabel();
        lblFoto2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        chkPost03 = new javax.swing.JCheckBox();
        chkPost06 = new javax.swing.JCheckBox();
        chkPost05 = new javax.swing.JCheckBox();
        chkPost04 = new javax.swing.JCheckBox();
        chkPost07 = new javax.swing.JCheckBox();
        chkPost08 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        chkPost15 = new javax.swing.JCheckBox();
        chkPost16 = new javax.swing.JCheckBox();
        chkPost12 = new javax.swing.JCheckBox();
        chkPost11 = new javax.swing.JCheckBox();
        chkPost14 = new javax.swing.JCheckBox();
        chkPost13 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        chkPost01 = new javax.swing.JCheckBox();
        chkPost02 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        chkPost09 = new javax.swing.JCheckBox();
        chkPost10 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        chkPost17 = new javax.swing.JCheckBox();
        chkPost18 = new javax.swing.JCheckBox();
        chkPost19 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        txtAlcance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblClasWels = new javax.swing.JLabel();
        btnMedSalvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 247, 241));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        btnColocaGrade.setText("COLOCAR GRADE");
        btnColocaGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColocaGradeActionPerformed(evt);
            }
        });
        getContentPane().add(btnColocaGrade);
        btnColocaGrade.setBounds(10, 350, 310, 23);

        lblGrade4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGrade4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/grade.png"))); // NOI18N
        lblGrade4.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                lblGrade4HierarchyChanged(evt);
            }
        });
        lblGrade4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGrade4MousePressed(evt);
            }
        });
        getContentPane().add(lblGrade4);
        lblGrade4.setBounds(790, 10, 248, 320);

        lblFoto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/addfotofundo.png"))); // NOI18N
        lblFoto4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lado Esquerdo"));
        lblFoto4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFoto4MousePressed(evt);
            }
        });
        getContentPane().add(lblFoto4);
        lblFoto4.setBounds(790, 0, 254, 336);

        lblGrade1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGrade1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/grade.png"))); // NOI18N
        lblGrade1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                lblGrade1HierarchyChanged(evt);
            }
        });
        lblGrade1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGrade1MousePressed(evt);
            }
        });
        getContentPane().add(lblGrade1);
        lblGrade1.setBounds(10, 10, 248, 320);

        lblFoto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/addfotofundo.png"))); // NOI18N
        lblFoto1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Frente"));
        lblFoto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFoto1MousePressed(evt);
            }
        });
        getContentPane().add(lblFoto1);
        lblFoto1.setBounds(10, 0, 254, 336);

        lblGrade3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGrade3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/grade.png"))); // NOI18N
        lblGrade3.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                lblGrade3HierarchyChanged(evt);
            }
        });
        lblGrade3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGrade3MousePressed(evt);
            }
        });
        getContentPane().add(lblGrade3);
        lblGrade3.setBounds(530, 10, 248, 320);

        lblFoto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/addfotofundo.png"))); // NOI18N
        lblFoto3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lado Direito"));
        lblFoto3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFoto3MousePressed(evt);
            }
        });
        getContentPane().add(lblFoto3);
        lblFoto3.setBounds(530, 0, 254, 336);

        lblGrade2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGrade2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/grade.png"))); // NOI18N
        lblGrade2.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                lblGrade2HierarchyChanged(evt);
            }
        });
        lblGrade2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblGrade2MousePressed(evt);
            }
        });
        getContentPane().add(lblGrade2);
        lblGrade2.setBounds(270, 10, 248, 320);

        lblFoto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/addfotofundo.png"))); // NOI18N
        lblFoto2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Costas"));
        lblFoto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFoto2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFoto2MousePressed(evt);
            }
        });
        getContentPane().add(lblFoto2);
        lblFoto2.setBounds(270, 0, 254, 336);

        txtObs.setColumns(20);
        txtObs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtObs.setLineWrap(true);
        txtObs.setRows(5);
        txtObs.setWrapStyleWord(true);
        txtObs.setBorder(javax.swing.BorderFactory.createTitledBorder("Observações"));
        jScrollPane1.setViewportView(txtObs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 380, 310, 220);

        jPanel3.setBackground(new java.awt.Color(255, 247, 241));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 153, 0), null), "Análise Simetrográfica Subjetiva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 247, 241));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Coluna"));

        chkPost03.setBackground(new java.awt.Color(255, 247, 241));
        chkPost03.setText("Hiperlordose Cervical");

        chkPost06.setBackground(new java.awt.Color(255, 247, 241));
        chkPost06.setText("Escoliose Toráxica");

        chkPost05.setBackground(new java.awt.Color(255, 247, 241));
        chkPost05.setText("Hipercifose Toráxica");

        chkPost04.setBackground(new java.awt.Color(255, 247, 241));
        chkPost04.setText("Escoliose Cervical");

        chkPost07.setBackground(new java.awt.Color(255, 247, 241));
        chkPost07.setText("Hiperlordose Lombar");

        chkPost08.setBackground(new java.awt.Color(255, 247, 241));
        chkPost08.setText("Escoliose Lombar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPost08)
                    .addComponent(chkPost07)
                    .addComponent(chkPost04)
                    .addComponent(chkPost05)
                    .addComponent(chkPost06)
                    .addComponent(chkPost03))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(chkPost03)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost04)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost05)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost06)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost07)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost08))
        );

        jPanel6.setBackground(new java.awt.Color(255, 247, 241));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pés"));

        chkPost15.setBackground(new java.awt.Color(255, 247, 241));
        chkPost15.setText("Pés Calcâneos");

        chkPost16.setBackground(new java.awt.Color(255, 247, 241));
        chkPost16.setText("Pés Equinos");

        chkPost12.setBackground(new java.awt.Color(255, 247, 241));
        chkPost12.setText("Pés Adutos");

        chkPost11.setBackground(new java.awt.Color(255, 247, 241));
        chkPost11.setText("Pés Abdutos");

        chkPost14.setBackground(new java.awt.Color(255, 247, 241));
        chkPost14.setText("Pés Planos");

        chkPost13.setBackground(new java.awt.Color(255, 247, 241));
        chkPost13.setText("Pés Cavos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPost12)
                    .addComponent(chkPost11)
                    .addComponent(chkPost14)
                    .addComponent(chkPost13)
                    .addComponent(chkPost15)
                    .addComponent(chkPost16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(chkPost11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkPost12)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(chkPost13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkPost14)))
                .addComponent(chkPost15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost16))
        );

        jPanel8.setBackground(new java.awt.Color(255, 247, 241));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ombros"));

        chkPost01.setBackground(new java.awt.Color(255, 247, 241));
        chkPost01.setText("Elevação Ombro Direito");

        chkPost02.setBackground(new java.awt.Color(255, 247, 241));
        chkPost02.setText("Elevação Ombro Esquerdo");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPost02)
                    .addComponent(chkPost01)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chkPost01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost02))
        );

        jPanel2.setBackground(new java.awt.Color(255, 247, 241));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Crista Ilíaca"));

        chkPost09.setBackground(new java.awt.Color(255, 247, 241));
        chkPost09.setText("Elevação Crista Direita");

        chkPost10.setBackground(new java.awt.Color(255, 247, 241));
        chkPost10.setText("Elevação Crista  Esquerda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPost10)
                    .addComponent(chkPost09))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chkPost09)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost10))
        );

        jPanel4.setBackground(new java.awt.Color(255, 247, 241));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Joelhos"));

        chkPost17.setBackground(new java.awt.Color(255, 247, 241));
        chkPost17.setText("Valgo");

        chkPost18.setBackground(new java.awt.Color(255, 247, 241));
        chkPost18.setText("Varo");

        chkPost19.setBackground(new java.awt.Color(255, 247, 241));
        chkPost19.setText("Recurvato");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkPost18)
                    .addComponent(chkPost17)
                    .addComponent(chkPost19))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(chkPost17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPost19))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(330, 350, 380, 250);

        jPanel7.setBackground(new java.awt.Color(255, 247, 241));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 153, 0), null), "Teste de Flexibilidade - Wells & Dillon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0))); // NOI18N

        txtAlcance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAlcance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlcance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlcanceFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Alcance:");

        jLabel1.setText("cm");

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Obs. Implemento Banco de Wells ");

        jPanel1.setBackground(new java.awt.Color(255, 247, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Classificação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 102, 0))); // NOI18N

        lblClasWels.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblClasWels.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClasWels.setText("Não calculado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClasWels, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClasWels)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlcance, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlcance)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(720, 350, 320, 108);

        btnMedSalvar.setBackground(new java.awt.Color(255, 247, 241));
        btnMedSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sa/icones/salvar30x30.png"))); // NOI18N
        btnMedSalvar.setText("Salvar");
        btnMedSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMedSalvar);
        btnMedSalvar.setBounds(850, 560, 190, 39);

        setBounds(0, 0, 1067, 662);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFoto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto2MouseClicked


    }//GEN-LAST:event_lblFoto2MouseClicked

    private void lblGrade4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGrade4MousePressed


    }//GEN-LAST:event_lblGrade4MousePressed

    private void lblFoto2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto2MousePressed
        JFileChooser foto2 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto2.setDialogTitle("Selecione a Foto de Frente"); //tirulo da caixa de dialogo
        foto2.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "JPEG", "JPG", "PNG");
        foto2.addChoosableFileFilter(filtro);
        foto2.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto2.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            File fotoselecionada = foto2.getSelectedFile();//jogando pra dentro da variavel o arquivo
            String caminho = fotoselecionada.getAbsolutePath();//jogando para dentro da string o caminho
            localfoto2 = caminho;

            foto002 = ManipularImagem.setImagemDimensao(caminho, lblFoto2.getWidth(), lblFoto2.getHeight());
            vfoto2 = ManipularImagem.getImgBytes(foto002);

            ImageIcon ft = new ImageIcon(foto2.getSelectedFile().getPath());
            lblFoto2.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto2.getWidth(), lblFoto2.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

        } else {

        }


        /* JFileChooser foto2 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto2.setDialogTitle("Selecione a Foto de Costas"); //tirulo da caixa de dialogo
        foto2.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto2.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            ImageIcon ft = new ImageIcon(foto2.getSelectedFile().getPath());
            lblFoto2.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto2.getWidth(), lblFoto2.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

        } else {

        }*/
    }//GEN-LAST:event_lblFoto2MousePressed

    private void lblFoto3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto3MousePressed
        JFileChooser foto3 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto3.setDialogTitle("Selecione a Foto de Frente"); //tirulo da caixa de dialogo
        foto3.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "JPEG", "JPG", "PNG");
        foto3.addChoosableFileFilter(filtro);
        foto3.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto3.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            File fotoselecionada = foto3.getSelectedFile();//jogando pra dentro da variavel o arquivo
            String caminho = fotoselecionada.getAbsolutePath();//jogando para dentro da string o caminho
            localfoto3 = caminho;

            foto003 = ManipularImagem.setImagemDimensao(caminho, lblFoto3.getWidth(), lblFoto3.getHeight());
            vfoto3 = ManipularImagem.getImgBytes(foto003);

            ImageIcon ft = new ImageIcon(foto3.getSelectedFile().getPath());
            lblFoto3.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto3.getWidth(), lblFoto3.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

        } else {

        }

        /*JFileChooser foto3 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto3.setDialogTitle("Selecione a Foto de Costas"); //tirulo da caixa de dialogo
        foto3.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto3.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            ImageIcon ft = new ImageIcon(foto3.getSelectedFile().getPath());
            lblFoto3.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto2.getWidth(), lblFoto2.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

        } else {

        }*/
    }//GEN-LAST:event_lblFoto3MousePressed

    private void lblFoto4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto4MousePressed
        JFileChooser foto4 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto4.setDialogTitle("Selecione a Foto de Frente"); //tirulo da caixa de dialogo
        foto4.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "JPEG", "JPG", "PNG");
        foto4.addChoosableFileFilter(filtro);
        foto4.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto4.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            File fotoselecionada = foto4.getSelectedFile();//jogando pra dentro da variavel o arquivo
            String caminho = fotoselecionada.getAbsolutePath();//jogando para dentro da string o caminho
            localfoto4 = caminho;

            foto004 = ManipularImagem.setImagemDimensao(caminho, lblFoto4.getWidth(), lblFoto4.getHeight());
            vfoto4 = ManipularImagem.getImgBytes(foto004);

            ImageIcon ft = new ImageIcon(foto4.getSelectedFile().getPath());
            lblFoto4.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto4.getWidth(), lblFoto4.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

        } else {

        }

        /*JFileChooser foto4 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto4.setDialogTitle("Selecione a Foto de Costas"); //tirulo da caixa de dialogo
        foto4.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto4.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            ImageIcon ft = new ImageIcon(foto4.getSelectedFile().getPath());
            lblFoto4.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto4.getWidth(), lblFoto4.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

//lblFoto4.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto4.getWidth(), lblFoto4.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto
        } else {

        }*/
    }//GEN-LAST:event_lblFoto4MousePressed

    private void lblFoto1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFoto1MousePressed
        JFileChooser foto1 = new JFileChooser(); //intanciando o metodo para colocar a foto
        foto1.setDialogTitle("Selecione a Foto de Frente"); //tirulo da caixa de dialogo
        foto1.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "JPEG", "JPG", "PNG");
        foto1.addChoosableFileFilter(filtro);
        foto1.setFileSelectionMode(JFileChooser.FILES_ONLY);//setando para selecionar apenas um arquivo

        //abaixo eu estou criando uma variavel caso abra o arquivo
        int deucerto = foto1.showOpenDialog(this);
        if (deucerto == JFileChooser.APPROVE_OPTION) {//casoo de certo a busca pelos arquivos ele faz isso 

            File fotoselecionada = foto1.getSelectedFile();//jogando pra dentro da variavel o arquiv
            String caminho = fotoselecionada.getAbsolutePath();//jogando para dentro da string o caminho
            localfoto1 = caminho;
            foto001 = ManipularImagem.setImagemDimensao(caminho, lblFoto1.getWidth(), lblFoto1.getHeight());
            vfoto1 = ManipularImagem.getImgBytes(foto001);

            ImageIcon ft = new ImageIcon(foto1.getSelectedFile().getPath());
            Image im = ft.getImage();

            lblFoto1.setIcon(new ImageIcon(ft.getImage().getScaledInstance(lblFoto1.getWidth(), lblFoto1.getHeight(), Image.SCALE_AREA_AVERAGING)));//colocando a foto do tamanho do jlabel foto

        } else {

        }
    }//GEN-LAST:event_lblFoto1MousePressed

    private void btnColocaGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColocaGradeActionPerformed
        if (btnColocaGrade.isSelected()) {
            lblGrade1.setVisible(true);
            lblGrade2.setVisible(true);
            lblGrade3.setVisible(true);
            lblGrade4.setVisible(true);
            btnColocaGrade.setText("Remover Grade");
        } else {
            lblGrade1.setVisible(false);
            lblGrade2.setVisible(false);
            lblGrade3.setVisible(false);
            lblGrade4.setVisible(false);
            btnColocaGrade.setText("Colocar Grade");
        }
    }//GEN-LAST:event_btnColocaGradeActionPerformed

    private void lblGrade4HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_lblGrade4HierarchyChanged
        if (btnColocaGrade.isSelected()) {
            lblGrade1.setVisible(true);
            lblGrade2.setVisible(true);
            lblGrade3.setVisible(true);
            lblGrade4.setVisible(true);
        } else {
            lblGrade1.setVisible(false);
            lblGrade2.setVisible(false);
            lblGrade3.setVisible(false);
            lblGrade4.setVisible(false);
        }
    }//GEN-LAST:event_lblGrade4HierarchyChanged

    private void lblGrade1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_lblGrade1HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGrade1HierarchyChanged

    private void lblGrade1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGrade1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGrade1MousePressed

    private void lblGrade2HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_lblGrade2HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGrade2HierarchyChanged

    private void lblGrade2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGrade2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGrade2MousePressed

    private void lblGrade3HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_lblGrade3HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGrade3HierarchyChanged

    private void lblGrade3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGrade3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGrade3MousePressed

    private void txtAlcanceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlcanceFocusLost

    }//GEN-LAST:event_txtAlcanceFocusLost

    private void btnMedSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedSalvarActionPerformed
        int adicionar = JOptionPane.showConfirmDialog(null, "Concluiu todas as Medidas?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {

            incluiranalise();
            telaAnalisePostural = null;
            TelaAnalisePostural.this.dispose();//metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_btnMedSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtAlcance.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Informe a distância atingida em cm\nEx: 32");

        } else {
            buscadados();
            protobancodewells();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
            int adicionar = JOptionPane.showConfirmDialog(null, "Você não salvou! deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (adicionar == JOptionPane.YES_OPTION) {
            telaAnalisePostural = null;
            TelaAnalisePostural.this.dispose(); //metodo para fechar uma unica janela
        } else {

        }
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnColocaGrade;
    public static javax.swing.JButton btnMedSalvar;
    public static javax.swing.JCheckBox chkPost01;
    public static javax.swing.JCheckBox chkPost02;
    public static javax.swing.JCheckBox chkPost03;
    public static javax.swing.JCheckBox chkPost04;
    public static javax.swing.JCheckBox chkPost05;
    public static javax.swing.JCheckBox chkPost06;
    public static javax.swing.JCheckBox chkPost07;
    public static javax.swing.JCheckBox chkPost08;
    public static javax.swing.JCheckBox chkPost09;
    public static javax.swing.JCheckBox chkPost10;
    public static javax.swing.JCheckBox chkPost11;
    public static javax.swing.JCheckBox chkPost12;
    public static javax.swing.JCheckBox chkPost13;
    public static javax.swing.JCheckBox chkPost14;
    public static javax.swing.JCheckBox chkPost15;
    public static javax.swing.JCheckBox chkPost16;
    public static javax.swing.JCheckBox chkPost17;
    public static javax.swing.JCheckBox chkPost18;
    public static javax.swing.JCheckBox chkPost19;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblClasWels;
    public static javax.swing.JLabel lblFoto1;
    public static javax.swing.JLabel lblFoto2;
    public static javax.swing.JLabel lblFoto3;
    public static javax.swing.JLabel lblFoto4;
    private javax.swing.JLabel lblGrade1;
    private javax.swing.JLabel lblGrade2;
    private javax.swing.JLabel lblGrade3;
    private javax.swing.JLabel lblGrade4;
    public static javax.swing.JTextField txtAlcance;
    public static javax.swing.JTextArea txtObs;
    // End of variables declaration//GEN-END:variables
}
