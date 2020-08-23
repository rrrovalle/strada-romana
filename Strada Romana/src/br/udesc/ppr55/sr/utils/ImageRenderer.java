 /**
 * ImageRenderer Class
 * @author Rodrigo Valle e Robson de Jesus
 * @since 12/08/2020
 * @version 1.0
 */

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
     * Transform image into a Icon
     * 
     * @return image 
     */
    public static Image transformImage(Icon icon) {
        
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
     * @param oImage - Icon to be resized
     * @param iWidth   - width
     * @param iHeight    - height 
     * @return Icon
     */
    public static Icon resizeImage(Icon oImage, int iWidth, int iHeight) {
        ImageIcon oImgIcon = new ImageIcon(transformImage(oImage));
        oImgIcon.setImage(oImgIcon.getImage().getScaledInstance(iWidth, iHeight, 0));
        
        return oImgIcon;
    } 
 
}