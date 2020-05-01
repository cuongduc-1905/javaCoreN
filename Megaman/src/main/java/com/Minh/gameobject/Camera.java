/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.gameobject;

/**
 *
 * @author minh
 */
public class Camera extends GameObject{
    
    private float WidthView;
    private float heightView;
    
    private boolean islocked = false;

    public Camera(float WidthView, float heightView, float posX, float posY, GameWorld gameWorld) {
        super(posX, posY, gameWorld);
        this.WidthView = WidthView;
        this.heightView = heightView;
    }

    
    public void lock(){
        islocked = true;
    }
    
    public void unlock(){
        islocked = false;
    }
    
    @Override
    public void Update() {
        if(!islocked){
            
            Megaman mainCharater = getGameWorld().megaman;
            
            if(mainCharater.getPosX() - getPosX() > 400) setPosX(mainCharater.getPosX() - 400);
            if(mainCharater.getPosX() - getPosX() < 200) setPosX(mainCharater.getPosX() - 200);
            
            if(mainCharater.getPosY() - getPosY() > 400) setPosY(mainCharater.getPosX() - 400);
            else if(mainCharater.getPosY() - getPosY() < 250) setPosY(mainCharater.getPosY() - 250);
            
        }
    }

    public float getWidthView() {
        return WidthView;
    }

    public void setWidthView(float WidthView) {
        this.WidthView = WidthView;
    }

    public float getHeightView() {
        return heightView;
    }

    public void setHeightView(float heightView) {
        this.heightView = heightView;
    }
    
    
    
    
    
}
