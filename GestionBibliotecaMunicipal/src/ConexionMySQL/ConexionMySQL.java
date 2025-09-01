package ConexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMySQL {
	
	public static void main(String[] args) {
		getConexion();
	}

public static Connection getConexion() {
	Connection snx = null;
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	    System.out.println("Driver correcto");
	    snx= DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_BIBLIOTECA_MUNICIPAL_2025","root","mysql");
		System.out.println("Conexión correcta");
		
	} catch (Exception e) {
		
		System.out.println("Error: "+e);
		
	}
	
	return snx;
}
}
