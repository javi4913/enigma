/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Modelo {
    HashSet<QampA> questions; 

    public Modelo() {
        questions = new HashSet<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/enigma", "root", "1234");
            Statement s = con.createStatement();
            Statement s1 = con.createStatement();
            Statement s2 = con.createStatement();
            
            //String tema = "geografia".toUpperCase();
            ResultSet rs = s.executeQuery("select * from root.tema");
            while(rs.next()){
                ResultSet rs1 = s1.executeQuery("select * from root.pregunta where temaid="+rs.getString("id"));
                while(rs1.next()){
                    ResultSet rs2 = s2.executeQuery("select * from root.respuesta where temaid="+rs.getString("id"));
                    ArrayList<String> options = new ArrayList<>();
                    QampA q = new QampA();
                    q.setSubject(rs.getString("name"));
                    q.setQuestion(rs1.getString("pregunta"));
                    while(rs2.next()){
                        if(Boolean.parseBoolean(rs2.getString("respuesta")) && rs2.getString("preguntaid").equalsIgnoreCase(rs1.getString("id"))){
                            q.setAnswer(rs2.getString("descripcion"));
                        }
                        options.add(rs2.getString("descripcion"));
                    }
                    q.setOptions(options);
                    //System.out.println(q.toString());
                    questions.add(q);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashSet<QampA> getQuestions() {
        return questions;
    }
    
    
    
    
}
