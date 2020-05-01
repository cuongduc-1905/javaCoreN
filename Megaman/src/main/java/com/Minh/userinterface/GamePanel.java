/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.userinterface;

import com.Minh.effect.Animation;
import com.Minh.effect.CacheDataLoader;
import com.Minh.effect.FrameImage;
import com.Minh.gameobject.GameWorld;
import com.Minh.gameobject.Megaman;
import com.Minh.gameobject.PhysicaMap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author minh
 */
public class GamePanel extends JPanel implements Runnable, KeyListener{
    
    private Thread thread;
    private boolean isRunning; 
    
    private inputManger inputManger;
    
    //FrameImage frame1;
    //Animation anim1;
    private BufferedImage bufImage;
    private Graphics2D bufG2D;
    
    public GameWorld gameWorld;
    
    public GamePanel(){//goi class;
        gameWorld = new GameWorld();
        
        inputManger = new inputManger(gameWorld);
        
        bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        
        
        //frame1 = CacheDataLoader.getInstance().getFrameImage("idle2");
    
        //anim1 = CacheDataLoader.getInstance().getAnimation("runshoot");
    
        //anim1.flipAllImage();//ham chay nguoc lai
    }
    @Override
    public void paint(Graphics g){//ham ve
        
        g.drawImage(bufImage, 0, 0, this);
        
        //Graphics2D g2 = (Graphics2D) g;
        //frame1.draw(g2, 130, 130);
        
        //anim1.draw(300, 300, g2);
        //g.drawImage(image, 10, 10, this);
        //g.drawImage(subImage, 10, 10, this);
    }
    
    public void UpdateGame(){
       gameWorld.Update();
    }
    
    
    public void RenderGame(){
        if(bufImage == null){
            bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        
        if(bufImage != null){
            bufG2D = (Graphics2D) bufImage.getGraphics();
        }
        
        if(bufG2D != null){
            bufG2D.setColor(Color.white);
            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            //draw objects game here
            
            //megaman.draw(bufG2D);
              gameWorld.Render(bufG2D);
      
            // bufG2D.setColor(Color.red);
            //bufG2D.fillRect(40, 50, 100, 100);
        }
        
        
        
    }
    
    
    
    public void startGame(){
        if(thread == null){
            isRunning = true;
            thread = new Thread(this);//this of Game Panel ,runnable
            thread.start();
        }
    }
    @Override
    public void run() {
        long FPS =80;
        long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        
        //int a = 1;
        
        beginTime = System.nanoTime();
       while(isRunning){
           
          
           //System.out.println("a = "+(a++));
           //update
           //render
           //-> do bien thien gio gian cua update,render la deltaTime
           //anim1.Update(System.nanoTime());
           UpdateGame();
           RenderGame();
           repaint();//goi den ham paint
           long deltaTime = System.nanoTime() - beginTime;
           sleepTime = period - deltaTime;
           
            try {
                if(sleepTime > 0) 
      
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
       }
        
    }
    
    //bo lang nghe Event
    @Override
    public void keyTyped(KeyEvent arg0) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) { //callback method
        //System.out.println("key press");
        inputManger.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManger.processKeyReleased(e.getKeyCode());
    }

    
}
