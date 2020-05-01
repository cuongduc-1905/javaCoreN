/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.effect;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class Animation {
    private String name;
    private boolean isRepeated;
    
    private ArrayList<FrameImage> framImage;
    
    private int currentFrame   ; //luu chu chir den
    
    private ArrayList<Boolean> ignoreFrame; //apply 
    
    private ArrayList<Double> delayFrame;//chua thoi gian
    
    private long beginTime;
    
    private boolean drawRectFrame;//tao khung, muc dich do rong

   public Animation() {
       delayFrame = new ArrayList<Double>();//khoi tao cac arraylist
       
       beginTime = 0;
       
       currentFrame = 0;
       
       ignoreFrame = new ArrayList<Boolean>();
       
       framImage = new ArrayList<FrameImage>();
       
       drawRectFrame = false;
       
       isRepeated = true;
   }

   public Animation(Animation animation){
       beginTime = animation.beginTime;
       currentFrame = animation.currentFrame;
       drawRectFrame = animation.drawRectFrame;
       isRepeated = animation.isRepeated;
       
       delayFrame  = new ArrayList<Double>();
       for (Double d : animation.delayFrame) {
           delayFrame.add(d);
       }
       
       ignoreFrame = new ArrayList<Boolean>();
       for (Boolean b : animation.ignoreFrame) {
           ignoreFrame.add(b);
       }
       
       framImage = new ArrayList<FrameImage>();
       for (FrameImage f : animation.framImage) {
           framImage.add(new FrameImage(f));
       }
       
       
       
       
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsRepeated() {
        return isRepeated;
    }

    public void setIsRepeated(boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    public ArrayList<FrameImage> getFramImage() {
        return framImage;
    }

    public void setFramImage(ArrayList<FrameImage> framImage) {
        this.framImage = framImage;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        if(currentFrame >=0 && currentFrame < framImage.size()){
            this.currentFrame = currentFrame;
        }else{
            this.currentFrame = 0;
        }
    }

    public ArrayList<Boolean> getIgnoreFrame() {
        return ignoreFrame;
    }

    public void setIgnoreFrame(ArrayList<Boolean> ignoreFrame) {
        this.ignoreFrame = ignoreFrame;
    }

    public ArrayList<Double> getDelayFrame() {
        return delayFrame;
    }

    public void setDelayFrame(ArrayList<Double> delayFrame) {
        this.delayFrame = delayFrame;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public boolean getDrawRectFrame() {
        return drawRectFrame;
    }

    public void setDrawRectFrame(boolean drawRectFrame) {
        this.drawRectFrame = drawRectFrame;
    }
    
    public boolean isIgnoreFrame(int id){
        return ignoreFrame.get(id);
    }
    
    public void setIgnoreFrame(int id){
        if(id >= 0 && id < ignoreFrame.size()){
            ignoreFrame.set(id, true);
        }
            
    }
    
    public void unIgnoreFrame(int id){
        if(id >= 0 && id < ignoreFrame.size()){
            ignoreFrame.set(id, false);
        }
            
    }
    public void reset(){//qua tro lai
        currentFrame = 0;
        beginTime = 0;
        for(int i =0 ; i < ignoreFrame.size(); i++){
            ignoreFrame.set(i, false);
        }
    }
    
    public void add(FrameImage frameImage, double timeToNextFrame){
        ignoreFrame.add(false);
        framImage.add(frameImage);
        delayFrame.add(new Double(timeToNextFrame));
    }
    
    public BufferedImage getCurrentImage(){
        return framImage.get(currentFrame).getImage();
    }
    
    public void Update(long currentTime){
        
        if(beginTime == 0 ){
            beginTime = currentTime;
        }else{
            if(currentTime - beginTime > delayFrame.get(currentFrame)){
                nextFrame();
                beginTime = currentTime;
            }
        }
        
    }
    
    
    private void nextFrame(){
        if(currentFrame >= framImage.size() - 1){
            if(isRepeated){
                currentFrame = 0;
            }
        }else{
            currentFrame++;
        }
        
        if(ignoreFrame.get(currentFrame)){
            nextFrame();
        }
    }
    
    //tra kiem nhan vat chya song chua de chuyen trai thai
    public boolean isLastFrame(){
        if(currentFrame == framImage.size() - 1){
            return true;
        }else{
            return false;
        }
    }
    
    public void flipAllImage(){//dung de lap nguoc lai
        for (int i = 0; i < framImage.size(); i++) {
            BufferedImage image = framImage.get(i).getImage();
        
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        
            tx.translate(-image.getWidth(), 0);
            
            AffineTransformOp op = new AffineTransformOp(tx, 
            AffineTransformOp.TYPE_BILINEAR);
            image = op.filter(image, null);
            framImage.get(i).setImage(image);
        
        }
    }
    
    public void draw(int x, int y, Graphics2D g2){
        BufferedImage image = getCurrentImage();
        
        g2.drawImage(image, x-image.getWidth()/2, y-image.getHeight()/2, null);
    
        if(drawRectFrame){
            g2.drawRect(x - image.getWidth()/2, x - image.getWidth()/2, y - image.getHeight()/2, y - image.getHeight()/2);
        }
    }
    
    
}
