/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.gameobject;

import com.Minh.userinterface.GameFrame;
import java.awt.Graphics2D;

/**
 *
 * @author minh
 */
public class GameWorld {
    
    public Megaman megaman;
 
    public PhysicaMap physicaMap;
    
    public Camera camera;
    
    public GameWorld(){
        megaman = new Megaman(300, 300,this);
        physicaMap = new PhysicaMap(0, 0, this);
        camera = new Camera(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT,0 , 0, this);
    }
    
    public void Update(){
        megaman.Update();
    }
    
    public void Render(Graphics2D g2){
        
        physicaMap.draw(g2);
        megaman.draw(g2); 
        
    }
    
    
    
}
