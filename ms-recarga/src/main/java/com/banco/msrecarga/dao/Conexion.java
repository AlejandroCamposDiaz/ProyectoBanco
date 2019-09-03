package com.banco.msrecarga.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;


public class Conexion {

    // Librer ía de MySQL
    public String driver = "org.postgresql.Driver";

    // Nombre de la base de datos desa tges=
    public String database = "postgres";
    //public String database = "log"; desa local
    
    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "5432";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    public String username = "postgres";

    //Clave de usuario tges = "Swl4g105$20" para local vacio;
    public String password = "postgres";
    
    public Connection conn = null;

    public Conexion() {
    	 try {
             Class.forName(driver);
             this.conn = DriverManager.getConnection(this.url, this.username, this.password);
             System.out.println("se conecto");
         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
    } 
    
    public Connection getConnection() {
    	return this.conn;
    }
    
    public void closeConnection() throws Exception{
		  closeResources(conn, null, null,null,null);	  
	  }
	  public void closeResultSet(ResultSet rs) throws Exception{
		  closeResources(null, rs, null,null,null);	  
	  }
	  public void closeStatement(Statement stmt) throws Exception{
		  closeResources(null, null, stmt,null,null);	  
	  }
	  public void closeCallableStatement(CallableStatement cstmt) throws Exception{
		  closeResources(null, null, null,cstmt,null);	  
	  }
	  public void closeResources(Connection conn, ResultSet rs,Statement stmt,CallableStatement cstmt , PreparedStatement pstmt) throws Exception{	 
		   if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException ex) {
		            //System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
		    if (cstmt != null) {
		        try {
		            cstmt.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
		    if (pstmt != null) {
		        try {
		            pstmt.close();
		        } catch (SQLException ex) {
		        	//System.out.println(ex.getMessage());
		            throw new Exception(ex.getMessage());
		        }
		    }
	  }
    
    public static void main(String[] argvs) {
    	new Conexion();
    }

}