/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap2;

/**
 *
 * @author minh
 */
public class xlString {

    /**
     * @param args the command line arguments
     */
    void StringIndexOf(){
        String word = "hệ thống đào tạo CNTT Quốc tế VIN-GROUP có 150 năm kinh nghiệm\n" +
        "trong lĩnh vực đào tạo CNTT, ​ hệ thống đã đào tạo hơn 30.000 học viên tốt nghiệp và 98%\n" +
        "có được việc làm.";
        System. out .println("length() = " + word.length());
        System. out .println("IndexOf() = " + word.indexOf("CNTT"));
    }
     void StringCapitalization(){
        String word = "hệ thống đào tạo CNTT Quốc tế VIN-GROUP có 150 năm kinh nghiệm\n" +
        "trong lĩnh vực đào tạo CNTT, ​ hệ thống đã đào tạo hơn 30.000 học viên tốt nghiệp và 98%\n" +
        "có được việc làm.";
        String c = word.toUpperCase();
        System. out .println("viet hoa= " + c);
    }
    void StringChange(){
        String word = "hệ thống đào tạo CNTT Quốc tế VIN-GROUP có 150 năm kinh nghiệm\n" +
        "trong lĩnh vực đào tạo CNTT, ​ hệ thống đã đào tạo hơn 30.000 học viên tốt nghiệp và 98%\n" +
        "có được việc làm.";
        
        word = word.replaceAll("hệ thống", "trường");
        System. out .println("replaceAll() = " + word);
    }
     void StringCapitalizationFirstly(){
        String word = "hệ thống đào tạo CNTT Quốc tế VIN-GROUP có 150 năm kinh nghiệm\n" +
        "trong lĩnh vực đào tạo CNTT, hệ thống đã đào tạo hơn 30.000 học viên tốt nghiệp và 98%\n" +
        "có được việc làm.";
        String[] words = word.split(" ");
        String s = "";
        for (String word1 : words) {
            
            s = s + (word1.substring(0, 1).toUpperCase() + word1.substring(1));
            s = s + " ";
            
        }
        System.out.println(s);
    }
    
    public static void main(String args[]) {
        xlString st = new xlString();
        st.StringCapitalization();
        st.StringIndexOf();
        st.StringChange();
        st.StringCapitalizationFirstly();
    }
}
