/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author minh
 */
enum DbhandlerType{
    STUDENT
}
public class DbHandlerFactory {
    public static final DbhandlerType STUDENT = DbhandlerType.STUDENT;
    private static DbHandlerFactory instance = new DbHandlerFactory();
    private DbHandlerFactory(){}
    public static DbHandlerFactory getInstance(){
        if (instance == null) {
            instance = new DbHandlerFactory();
        }
        return instance;
    }
    public IDvhandler getHandler(DbhandlerType type){
        IDvhandler handler = null;
        switch(type) {
            case STUDENT:
                handler = new StudentDAO();
                break;
            
        }
        return handler;
    }
     
     
     
}
