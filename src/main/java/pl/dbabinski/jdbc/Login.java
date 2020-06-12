/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.dbabinski.jdbc;

import java.util.List;
import javax.persistence.Query;
import pl.dbabinski.jdbc.entity.Users;
import pl.dbabinski.jdbc.entitymanager.MyEntityManager;

/**
 *
 * @author XC
 */
public class Login {
    private String login;
    private String password;
    
    public Login(){}
    
    public Login(String login, String password){
        this.login = login;
        this.password = password;
    }
    
    public boolean sprawdzLogowanie(){
        boolean wynikSprawdzLogowanie = false;
        
        MyEntityManager entityManager = new MyEntityManager();
        entityManager.getEntityManager();
//        Query query = entityManager.entityManager.createQuery("FROM users  WHERE login = :login AND password = :password")
//        .setParameter("login", login)
//        .setParameter("password", password);
        Query query = entityManager.entityManager.createNativeQuery("SELECT * FROM users WHERE login = ?login AND password = ?password ", Users.class)
                .setParameter("login", login)
                .setParameter("password", password);
        
        try {
            Object result =  query.getResultList().stream().findFirst().orElse(null);
            
            if(result!=null){
            wynikSprawdzLogowanie = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errorrr");
        }
        System.out.println(wynikSprawdzLogowanie);
        return wynikSprawdzLogowanie;
    }
}
