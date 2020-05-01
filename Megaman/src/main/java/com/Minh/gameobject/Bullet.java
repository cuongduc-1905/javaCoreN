/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.gameobject;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author minh
 */
public abstract class Bullet extends ParticularObject{


    public Bullet(float x, float y, float width, float height, float mass, int damage, GameWorld gameWorld) {
        super(x, y, width, height, mass, 1, gameWorld);
        setDamage(damage);
    }
    
    
    
    public abstract void draw(Graphics2D g2d);
    
    public void Update(){
        super.Update();
        setPosX(getPosX() + getSpeedX());
        setPosY(getPosY() + getSpeedY());
    }
    
    
}
