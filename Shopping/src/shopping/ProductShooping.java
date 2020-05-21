/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author minh
 */
public class ProductShooping {
    
    public static boolean flag = false;
    public static void insertIntoProductDB(String bard, String model, int price, int qty, String description, String imagePath){
        PreparedStatement ps;
        ResultSet rs;
        
        MyConnection myConnection = new MyConnection();
        
        String sql = "insert into Product(brand,model,Price,qty,description,imagePath) values(?,?,?,?,?,?)";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
        
            ps.setString(1, bard);
            ps.setString(2, model);
            ps.setInt(3, price);
            ps.setInt(4, qty);
            ps.setString(5, description);
            ps.setString(6, imagePath);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Entry !successfully");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ProductShooping.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
//    public static void updateProduct(String model, int qty){
//        PreparedStatement ps;
//        ResultSet rs;
//        
//        MyConnection myConnection = new MyConnection();
//        
//        String sql = "update Product"
//        
//        
//    }
    
    public static ArrayList<ProductList> TableProduct(){
        ArrayList<ProductList> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        
        MyConnection myConnection = new MyConnection();
        
        String sql = "select *from Product";
        
        try {
            ps = myConnection.getJDBCConnection().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            ProductList p1;
            while(rs.next()){
                 p1 = new ProductList(
                         rs.getString("mbrand"), 
                         rs.getString("mmodel"),
                         rs.getInt("mmprice"),
                         rs.getInt("mquantity"),
                         rs.getString("mdescription"), 
                         rs.getString("mphoto")
                 );
                 
                list.add(p1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductShooping.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
        
    }
    
    
}
