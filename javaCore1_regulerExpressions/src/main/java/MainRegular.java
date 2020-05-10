
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minh
 */
public class MainRegular {

    /**
     * @param args the command line arguments
     */
    private static final String[] fullName = {"nguyen van a", "nguyen van b","cao thi f" , "phung quang thanh"};
    private static final String input = "nguyen van a nguyen van b cao thi f phung quang thanh ";

    
    
    public void saerchName(String[] fullNames){
        String regex = ".*nguyen.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for(int i = 0; i < fullNames.length ; i++){
            matcher = pattern.matcher(fullNames[i]);
            if(matcher.find()){
                System.out.println(fullNames[i]);
            }
        }
        
    }
    public void replacess(String inputs){
        String regex = "[\\s]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputs);
        if(matcher.find()){
          
            System.out.println(matcher.replaceAll("a"));
        }
        
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        MainRegular main = new MainRegular();
        main.saerchName(fullName);
        System.out.println("tim kiem");
        main.replacess(input);
    }
    
}
