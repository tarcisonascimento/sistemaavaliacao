package br.com.sa.fundos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class FundoDeTela extends JDesktopPane{
    
    private Image Imagem;
    
    public FundoDeTela (String Imagem){
   
    this.Imagem = new ImageIcon(Imagem).getImage();
    }
    @Override
    public void paintComponent (Graphics g){
    g.drawImage(Imagem, 0, 0, getWidth(), getHeight(), this);
    
    
    }
    
}
