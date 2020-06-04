/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_core2_addfile;

import java.io.Serializable;

/**
 *
 * @author minh
 */
public class studen implements Serializable{
    private int Id ;
    private String Name;
    private String Age;
    private String phone;
    private String address;

    public studen() {
    }

    public studen(int Id, String Name, String Age, String phone, String address) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
