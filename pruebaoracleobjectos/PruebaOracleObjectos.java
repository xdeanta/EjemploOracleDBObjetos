/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaoracleobjectos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class PruebaOracleObjectos {

    /**
     * @param args the command line arguments
     */
    private static Connection conx = null;
    
    public static void getConx(){
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; 
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;
        try{
            conx=DriverManager.getConnection(ulrjdbc);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void closeConexion() {
        try{
            conx.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
      }
    
    public static void insertarFila() throws SQLException{
        //PreparedStatement pst = conx.prepareStatement("insert into alumnos values(?,?,enderezo(?,?,?),TO_DATE(?, 'dd.mm.yyyy hh24:mi:ss')");
        PreparedStatement pst2 = conx.prepareStatement("insert into alumnos values(?,?,enderezo(?,?,?),TO_DATE(?, 'dd.mm.yyyy hh24:mi:ss'))");
        Direccion d = new Direccion("faisan,24","vigo",36205);
        pst2.setInt(1, 5);
        pst2.setString(2, "elsa");
        pst2.setString(3, d.getCalle());
        pst2.setString(4, d.getCiudad());
        pst2.setInt(5, d.getZip());
        pst2.setString(6, "12/4/1984");
        if(pst2.executeUpdate() > 0){
            System.out.println("Insercion correcta");
        }
    }
    
    public static void actualizarFila() throws SQLException{
        //PreparedStatement pst = conx.prepareStatement("insert into alumnos values(?,?,enderezo(?,?,?),TO_DATE(?, 'dd.mm.yyyy hh24:mi:ss')");
        PreparedStatement pst2 = conx.prepareStatement("update alumnos a set a.enderezot.cidade=? where codigo=?");
        
        pst2.setInt(2, 1);
        pst2.setString(1, "pontevedra");
        if(pst2.executeUpdate() > 0){
            System.out.println("Modificacion hecha");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        getConx();
        try{
            insertarFila();
            actualizarFila();
        }catch(SQLException e){
            e.printStackTrace();
        }
        closeConexion();
    }
    
}
