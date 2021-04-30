package br.com.sa.classes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;



public class TransformaImagem {
    

    public static BufferedImage ImageToBuffered(Image im) {

        BufferedImage bi = new BufferedImage(
        im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        
        return bi;

    }
    
    public static byte[] bufferToBytes( BufferedImage buffer, String formatName ) throws Exception {
		
		byte[] bytes = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();;
		
		try {
			
			if ( buffer != null)
				ImageIO.write(buffer, formatName, baos);
			
		} catch (IOException e) {
			
			baos = null;
			throw e;
			
		} finally {
		
			if ( baos != null )
				bytes =  baos.toByteArray();
		
		}
		
		return bytes;
		
	}

}
