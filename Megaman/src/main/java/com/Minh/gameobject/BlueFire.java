/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.gameobject;

import com.Minh.effect.Animation;
import com.Minh.effect.CacheDataLoader;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author minh
 */
public class BlueFire extends Bullet{
    
    private Animation forwardBulletAnim,backBulletAnim;

    public BlueFire(float x, float y, GameWorld gameWorld) {
        super(x, y, 60, 30, 0.1f, 10, gameWorld);
        forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("bluefire");
        backBulletAnim = CacheDataLoader.getInstance().getAnimation("bluefire");
        backBulletAnim.flipAllImage();//animation nguoc lai
        
    }

    
    
    
    @Override
    public void draw(Graphics2D g2d) {
        if(getSpeedX() > 0){
            if(!forwardBulletAnim.isIgnoreFrame(0) && forwardBulletAnim.getCurrentFrame() == 3){
                forwardBulletAnim.setIgnoreFrame(0);
                forwardBulletAnim.setIgnoreFrame(1);
                forwardBulletAnim.setIgnoreFrame(2);
            }
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2d);
            
        }
    }

    @Override
    public void Update() {
        if(forwardBulletAnim.isIgnoreFrame(0) || backBulletAnim.isIgnoreFrame(0)){
            setPosX(getPosX() + getSpeedX());
        }
    }
    
    
    
    @Override
    public void attack() {}

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {//tra ve vay cham voi nhan vat
        return getBoundForCollisionWithMap();
    }
    
}
