
package com.demo.controller;

import com.demo.model.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControllerSql {
    public static Conexion con = new Conexion();
    
    public static PreparedStatement sentencia_preparada;
    
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero=0;
    
     public int logup(  String id, String nom, String apellido_p, String apellido_m,String usuario,String clave){
 int resultado =0;
   Connection con = null;
String sentencia_guardar=( "INSERT INTO cliente (Id,Nombre,Apellido_Paterno,Apellido_Materno,Usuario,Clave)VALUES(?,?,?,?,?,?)");
       

        //Se registrara en la tabla creada CLIENTE, he creado la tabla cliente, para que registre usuario clave id nombre y apellidos
        //Es decir estoy suponiendo que un cliente se está registrando, por eso he creado tabla cliente, y no tabla usuario, ya que no tendria
        //mucho sentido cuando registre en el atributo usuario.
        
        try {
            con=Conexion.conexion();
            sentencia_preparada =con.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, id);
            sentencia_preparada.setString(2, nom);
           sentencia_preparada.setString(3, apellido_p);
            sentencia_preparada.setString(4, apellido_m);
            sentencia_preparada.setString(5, usuario);
            sentencia_preparada.setString(6, clave);

            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"ERROR");
        }
        return resultado;

    }
    public static String buscarDato(String Usuario){
    String busqueda_dato= null;
      Connection con = null;
      try{
      con=Conexion.conexion();
      String sentencia_buscar=("SELECT Id,Nombre,Apellido_Paterno,Apellido_Materno FROM cliente WHERE Usuario='"+Usuario+"'");
      sentencia_preparada =con.prepareStatement(sentencia_buscar);
      resultado = sentencia_preparada.executeQuery();
      
      if(resultado.next()){
      String nombre= resultado.getString("Nombre");
      String apellido_paterno=resultado.getString("Apellido_Paterno");
      busqueda_dato = (nombre+" "+apellido_paterno);
      
      }
      con.close();
      }catch(Exception e){
      JOptionPane.showMessageDialog(null,"Error");
      }
      return busqueda_dato;
    }
    public static String buscarUsuarioRegistrado(String Usuario,String Clave){
    String busqueda_usuario=null;
       Connection con = null;
       
       try{
        con=Conexion.conexion();
       
       String sentencia_buscar_usuario=("SELECT Nombre,Usuario,Clave FROM cliente WHERE Usuario='"+Usuario+"'&& Clave='"+Clave+"'");
    sentencia_preparada=con.prepareStatement(sentencia_buscar_usuario);
       resultado=sentencia_preparada.executeQuery();
       if(resultado.next()){
       
       busqueda_usuario="usuario encontrado";
       }else{
       busqueda_usuario="usuario no encontrado";
       }
       con.close();
       }catch(Exception e){
       JOptionPane.showMessageDialog(null,"ERROR");
       }
return busqueda_usuario;    
    }}
    

