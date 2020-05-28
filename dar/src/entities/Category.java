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
public class Category {
    
    private int Id;
    private String Name;

    public Category() {
    }

    public Category(Integer Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

   
    
    
}
