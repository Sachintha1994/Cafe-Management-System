/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;



/**
 *
 * @author sachi
 */
public class UserDao {

    public static void save(User user) {
        String query = "Insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully ! Wait for Admin Approval");

    }

    public static User login(String email, String password) {

        User user = null;

        try {
            ResultSet rs = DbOperations.getData("select *from cms.user where email='" + email + "'and password= '" + password + "'"); // database ekat link krnn oni databasename.user kyla nttm exceptions enw.
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
            return user;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return null;

    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from cms.user where email='" + email + "'"); // database ekat link krnn oni databasename.user kyla nttm exceptions enw.
            while (rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
    
                    }
        
    
    return user;
 
        
    }
    public static void update(String email,String newPassword){
        String query = "update user set password = '" + newPassword + "'where email= '" + email + "'";
        DbOperations.setDataOrDelete(query, "Password changed Successfully");
    }
}
