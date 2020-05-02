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
    
    private boolean isLocked = false;

    public Camera(float WidthView, float heightView, float posX, float posY, GameWorld gameWorld) {
        super(posX, posY, gameWorld);
        this.WidthView = WidthView;
        this.heightView = heightView;
    }

    
    public void lock(){
        isLocked = true;
    }
    
    public void unlock(){
        isLocked = false;
    }
    
    @Override
    public void Update() {
        if(!isLocked){
        
            Megaman mainCharacter = getGameWorld().megaman;

            if(mainCharacter.getPosX() - getPosX() > 400) setPosX(mainCharacter.getPosX() - 400);
            if(mainCharacter.getPosX() - getPosX() < 200) setPosX(mainCharacter.getPosX() - 200);

            if(mainCharacter.getPosY() - getPosY() > 400) setPosY(mainCharacter.getPosY() - 400); // bottom
            else if(mainCharacter.getPosY() - getPosY() < 250) setPosY(mainCharacter.getPosY() - 250);// top 
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
