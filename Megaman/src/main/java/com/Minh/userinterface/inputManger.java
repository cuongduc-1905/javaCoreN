/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.userinterface;

import com.Minh.gameobject.GameWorld;
import com.Minh.gameobject.Megaman;
import java.awt.event.KeyEvent;

/**
 *
 * @author minh
 */
public class inputManger {//tham tac voi phim
    
    //private GamePanel gamePanel;
    private GameWorld gameWorld;
    
    public inputManger(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }
    
    
    public void processKeyPressed(int keyCode){
        switch(keyCode){
            
            case KeyEvent.VK_UP:
                System.out.println("you press up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("you press down");
                break;    
            case KeyEvent.VK_RIGHT:
                  //gameWorld.megaman.setSpeedX(-3);
                gameWorld.megaman.setDirection(gameWorld.megaman.RIGHT_DIR);//vi kg chay thi xem no o huong nao
                gameWorld.megaman.run();
                //System.out.println(""+KeyEvent.VK_RIGHT);
                break;    
            case KeyEvent.VK_LEFT:
                gameWorld.megaman.setDirection(gameWorld.megaman.LEFT_DIR);//vi kg chay thi xem no o huong nao
                gameWorld.megaman.run();
                //System.out.println(""+ KeyEvent.VK_LEFT);
                break;    
            case KeyEvent.VK_ENTER:
                System.out.println("you press enter");
                break;    
            case KeyEvent.VK_SPACE:
                gameWorld.megaman.Jump();
                //gameWorld.megaman.setSpeedY(-3);
                //gameWorld.megaman.setPosY(gameWorld.megaman.getPosY() - 3);
                break;   
            case KeyEvent.VK_A:
                System.out.println("you press A");
                break;    
        }
                
    }
    
    public void processKeyReleased(int keyCode){
        switch(keyCode){
            
            case KeyEvent.VK_UP:
                System.out.println("you Released up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("you Released down");
                break;    
            case KeyEvent.VK_RIGHT:               
                gameWorld.megaman.setSpeedX(0);
                break;    
            case KeyEvent.VK_LEFT:
                //gamePanel.megaman.setDirection(Megaman.DIR_LEFT); 
                gameWorld.megaman.setSpeedX(0);
                break;    
            case KeyEvent.VK_ENTER:
                System.out.println("you Released enter");
                break;    
            case KeyEvent.VK_SPACE:
                System.out.println("you Released space");
                break;   
            case KeyEvent.VK_A:
                System.out.println("you Released A");
                break;    
        }
                
    }
    
}
