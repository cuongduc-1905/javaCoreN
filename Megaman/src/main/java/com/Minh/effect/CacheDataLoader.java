/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Minh.effect;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;

/**
 *
 * @author minh
 */
public class CacheDataLoader {//dung de load 
    
    private static CacheDataLoader instance ;
    
    private String framefile = "data/frame.txt";
    
    private String animationfile = "data/animation.txt";
    private String physmapfile = "data/phys_map.txt";
    
    private Hashtable<String, FrameImage> frameImage;
    private Hashtable<String, Animation> animation;
    
    private int[][] phys_map;//mang 2 chieu
    
    private CacheDataLoader(){
        //frameImage = new Hashtable<String, FrameImage>();
        //animation = new Hashtable<String, Animation>();
    }
    
    public static CacheDataLoader getInstance(){
        if(instance == null){
            instance = new CacheDataLoader();
        }
        return instance;
    }
    
    public void LoadData() throws IOException {
        LoadFrame();
        LoadAnimation();
        LoadPhyMap();
    }

    public int[][] getPhysicalMap() {
        return instance.phys_map;
    }
    
    public void LoadPhyMap() throws IOException{
        
        FileReader fr = new FileReader(physmapfile);
        
        BufferedReader br = new BufferedReader(fr);
        
        String line = null;
        
        line = br.readLine();
        int numberOfRows = Integer.parseInt(line);
        line = br.readLine();
        int numberOfColumns = Integer.parseInt(line);
        
        instance.phys_map = new int[numberOfRows][numberOfColumns];
        
        for (int i = 0; i < numberOfRows; i++) {
            line = br.readLine();
            String [] str = line.split(" ");
            for (int j = 0; j < numberOfColumns; j++) {
                instance.phys_map[i][j] = Integer.parseInt(str[j]);
            }
        }
        
//        for (int i = 0; i < numberOfRows; i++) {
//            for (int j = 0; j < numberOfColumns; j++) {
//                System.out.println(" "+ instance.phys_map[i][j]);
//            }
//            System.out.println();
//        }
        br.close();
    }
            
            
    public void LoadFrame() throws IOException {//de load du lieu frameImage 
        
        frameImage = new Hashtable<String, FrameImage>();
        
        FileReader fr = new FileReader(framefile);//doc file chuyen vao duong dan
        
        BufferedReader br = new BufferedReader(fr);//chuyen vao file 
        
        String line = null;//doc tu dong
        
        if(br.readLine() == null){//read tra ve string
            System.out.print("No data");
            throw new IOException();
        }else{
            fr = new FileReader(framefile);//
            br = new BufferedReader(fr);
            
            while((line = br.readLine()).equals(""));//de next neu co rong
            int n = Integer.parseInt(line);
            
            for(int i =0; i < n; i++){
                FrameImage frame = new FrameImage();
                while((line = br.readLine()).equals(""));
                frame.setName(line);
                
                while((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                String path = str[1];
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int x = Integer.parseInt(str[1]);
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int y = Integer.parseInt(str[1]);
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int w = Integer.parseInt(str[1]);
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int h = Integer.parseInt(str[1]);
                
                BufferedImage imageData = ImageIO.read(new File(path));
                BufferedImage image = imageData.getSubimage(x, y, w, h);//chi nho hinh ra tu cai
                frame.setImage(image);
                
                instance.frameImage.put(frame.getName(), frame);
            }
        }
        br.close();
    }
    
    public FrameImage getFrameImage(String name){
        FrameImage frameImage = new FrameImage(instance.frameImage.get(name));
        return frameImage;
    }
    
    
    public void LoadAnimation() throws FileNotFoundException, IOException{
        
        animation = new Hashtable<String, Animation>();//load animation vao hashtable
        
        FileReader fr = new FileReader(animationfile);//khoi toa ocject readfile
        
        BufferedReader brA = new BufferedReader(fr);
        
        String line = null;
        
        if(brA.readLine() == null){
            System.out.println("No data");
             throw new IOException();
        }else{
            fr = new FileReader(animationfile);
            brA = new BufferedReader(fr);
            
            while((line = brA.readLine()).equals(""));
            int n = Integer.parseInt(line);
            
            for (int i = 0; i < n; i++) {
                Animation animation = new Animation();
                
                while((line = brA.readLine()).equals(""));
                animation.setName(line);
                
                while((line = brA.readLine()).equals(""));
                String[] str = line.split(" ");
                
                for (int j = 0; j < str.length; j+=2) {
                    animation.add(getFrameImage(str[j]), Double.parseDouble(str[j+1]));
                }
                instance.animation.put(animation.getName(), animation);
            }
            
        }  
        
        brA.close();
 
    }
    public Animation getAnimation(String name){
        Animation animation = new Animation(instance.animation.get(name));
        return animation;
    }
    
    
}
