package br.udesc.ppr55.sr.utils;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
 
public class ImageRenderer {
    
    public ImageRenderer() {}
     
    /**
     * Converte icon em image
     * 
     * @return image 
     */
    public static Image converterIconImagem(Icon icon) {
        
        if (icon.getClass() == ImageIcon.class) {
           return ((ImageIcon)icon).getImage();
        } 
        else {
           int w = icon.getIconWidth();
           int h = icon.getIconHeight();
           GraphicsEnvironment   ge    = GraphicsEnvironment.getLocalGraphicsEnvironment();
           GraphicsDevice        gd    = ge.getDefaultScreenDevice();
           GraphicsConfiguration gc    = gd.getDefaultConfiguration();
           BufferedImage         image = gc.createCompatibleImage(w, h); 
           return image;
        }
 
    }
    
    /**
     * Redimensiona a imagem passada
     * 
     * @param oImagem - Icon a ser redimensionado
     * @param iComp   - comprimento
     * @param iAlt    - altura
     * @return Icon
     */
    public static Icon redimensionaImagem(Icon oImagem, int iComp, int iAlt) {
        ImageIcon oImgIcon = new ImageIcon(converterIconImagem(oImagem));
        oImgIcon.setImage(oImgIcon.getImage().getScaledInstance(iComp, iAlt, 0));
        
        return oImgIcon;
    } 
 
}