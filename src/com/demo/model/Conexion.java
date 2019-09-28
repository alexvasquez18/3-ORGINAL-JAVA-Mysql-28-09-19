
package com.demo.model;

import java.sql.*;
import javax.swing.JOptionPane;
        
public class Conexion {
    private static String db="bd-usuarios";
    private static String user="root";
    private static String pass="";
    private static String host="localhost:3307";
    private static String server="jdbc:mysql://"+host+"/"+db;
    
    public static Connection conexion(){
        Connection con = null;
    try {
    //cargar el driver
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection(server,user,pass);
        System.out.println("conexion establecida");
        JOptionPane.showMessageDialog(null, "conexion establecida");
    }catch (ClassNotFoundException | SQLException e){
        System.out.println("error de conexion");
        JOptionPane.showMessageDialog(null, "error de conexion"+e);
    }
        return con;
    
    }

    public ResultSet createStatement() {
        Connection con= conexion();
    Statement st;
    ResultSet datos=null;
    try{
        st=con.createStatement();
        
    }catch(Exception e){
        System.out.print(e.toString());
    
    }
    return datos;
    } 

    

   
    }

   
    
    

