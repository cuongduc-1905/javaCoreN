/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlappyBirds;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.GameScreen;

/**
 *
 * @author minh
 */
public class FlappyBirds extends GameScreen{

    /**
     * @param args the command line arguments
     */
    private BufferedImage birds;
    
    private Animation bird_anim;
    
    public FlappyBirds(){//dat kich thuoc
        super(800,600);
        
        try {
            birds = ImageIO.read(new File("data/adda.jp"));
            
            
            BeginGame();
        } catch (IOException ex) {
            Logger.getLogger(FlappyBirds.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        A
           
    }
    
    
    public static void main(String args[]) {
        new FlappyBirds();
    }

    @Override
    public void GAME_UPDATE(long deltaTime) {
        
    }

    @Override
    public void GAME_PAINT(Graphics2D g2) {//de ve len mang hinh
        g2.setColor(Color.gray);
        g2.fillRect(50, 100, 100, 100);
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
       
    }
}
