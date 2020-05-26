/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author minh
 */
public class Stundent {
    private String Id;
    private String Name;
    private int Age;
    private String Email;
    private String Address;

    public Stundent() {
    }

    public Stundent(String Id, String Name, int Age, String Email, String Address) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.Email = Email;
        this.Address = Address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
      
}
