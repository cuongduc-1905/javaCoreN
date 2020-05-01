/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class GeneraLManger {

    /**
     * @param args the command line arguments
     */
    ArrayList<Product> isProduct = new ArrayList<>();
    

    private void nhapDuLieu() {
        System.out.println("so lan muon nhap ?");
        Scanner nhap = new Scanner(System.in);
        int chon = nhap.nextInt();
        for(int i = 0 ; i < chon ; i ++){
            System.out.println("lan nhap thu" +(i + 1));
            Product product = new Product();
            product.input();
            isProduct.add(product);
        }
    }
    
    private void hienThiTT() {
        for (Product p : isProduct) {
            p.display();
            
        }
    }

    
    private void oder(){
        Collections.sort(isProduct);
        
        for (Product p : isProduct) {
            p.display();
        }
        
    }
    
    private void salePrice(){
        for (Product p : isProduct) {
            p.display();
            p.caculateSalePrice();
            
        }
    }
//    private void searchPrice(){
//        System.out.println("nhap gia muon tim");
//        Scanner input = new Scanner(System.in);
//        float search = Float.parseFloat(input.nextLine());
//        for (Product p : isProduct) {
//           if(p.getProPrice().equals(search)){
//               p.display();
//           }
//        }
//    }
    private void searchPriceMin(){
        float min = isProduct.get(0).getProPrice() ;
        for(int i = 0 ; i < isProduct.size(); i++){
            if(isProduct.get(i).getProPrice() < min){
                min = isProduct.get(i).getProPrice();
            }
        }
        
        System.out.println("gia tri min:"+min);
        for (Product p: isProduct) {
             if (p.getProPrice() == min) {
                p.display();
            }
        }
        
    }
    
    private void searchName(){
        System.out.println("nhap ten san pham muon tim");
        Scanner input = new Scanner(System.in);
        String seach = input.nextLine();
        for (Product p : isProduct) {
            if(p.getProName().contains(seach)){
                p.display();
            }
        }
        
    }
    
    private int showMenu(){
        System.out.println("|=======Menu=======|");
        System.out.println("1. Nhập thông tin cho n sản phẩm");
        System.out.println("2. Hiển thị thông tin toàn bộ sản phẩm");
        System.out.println("3. Hiển thị thông tin sản phẩm sau khi sắp xếp theo(Alphabet).");
        System.out.println("4. Tính toán giá sản phẩm bán ra. "
        + "Hiển thị danh sách thông tin sản phẩm kèm giá bán ra.");
        System.out.println("5. Tìm kiếm sản phẩm theo giá bán, hiển thị kết quả tìm kiếm.");
        System.out.println("6. Tìm sản phẩm có giá thấp nhất");
        System.out.println("7. Tìm sản phẩm theo tên gọi");
        System.out.println("8. Kết thúc");
        System.out.println("moi chon so: 1 -> 8");
        Scanner nhap = new Scanner(System.in);
        int Chonso = nhap.nextInt();
        return Chonso;
        
    }
    
    
    public static void main(String args[]) {
      GeneraLManger ql = new GeneraLManger();
        int menu = 0;
        do{
            menu = ql.showMenu();
            switch(menu){
                case 1:
                    ql.nhapDuLieu();
                    break;
                case 2:
                    ql.hienThiTT();
                    break;
                case 3:
                    ql.oder();
                    break;
                case 4:
                    ql.salePrice();
                    break;
//                case 5:
//                    ql.searchPrice();
//                    break;
                case 6:
                    ql.searchPriceMin();
                    break;
                 case 7:
                   ql.searchName();
                    break;
                case 8:
                    System.out.println("Thoát");
                    break;
            }
            
            
        }while(menu > 0 && menu <8 );
    }
}
