package com.ecetech.titi3.itprojet.Ecole.model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {
	private static final String dbPath   = "jdbc:mysql://localhost:3306/bulletin"; //N° de port mysql 3306, 8889 sous mac
	  private static final String user     = "root";
	  private static final String password = "";
	  private static Connection   con      = null;
	  private static Statement    stm      = null;
	  private static ResultSet    res      = null;
	  private static int          erreur;

	  public static Exception DBConnexion() {
	      try {
	          Class.forName("com.mysql.jdbc.Driver").newInstance();
	          con = DriverManager.getConnection(dbPath, user, password);
	          stm = con.createStatement();

	          return null;
	      } catch (Exception e) {
	          System.out.println("ERROR in Connexion to " + dbPath + " :");

	          return e;
	      }
	  }

	  public static int DBClose() 
	  {
	      try {
	          stm.close();
	          con.close();
	      } catch (Exception e) {
	          System.out.println("ERROR in Connexion closure to " + dbPath + " : " + e.getMessage());
	      }

	      return erreur;
	  }

	  public static Connection getCon() {
	      return con;
	  }

	  public static void setCon(Connection con) {
		  ConnexionDB.con = con;
	  }

	  public static Statement getStm() {
	      return stm;
	  }

	  public static void setStm(Statement stm) {
		  ConnexionDB.stm = stm;
	  }

	  public static ResultSet getRes() {
	      return res;
	  }

	  public static void setRes(ResultSet res) {
	      ConnexionDB.res = res;
	  }

}
