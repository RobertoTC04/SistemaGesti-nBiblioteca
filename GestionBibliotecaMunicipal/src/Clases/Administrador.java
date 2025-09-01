package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ConexionMySQL.ConexionMySQL;

public class Administrador {
private String Codigo_Administrador;
private String Nombres_Administrador;
private String Apellidos_Administrador;
private String Usuario_Administrador;
private String Contraseña_Administrador;

public Administrador(String codigo_Administrador, String nombres_Administrador, String apellidos_Administrador,
		String usuario_Administrador, String contraseña_Administrador) {
	Codigo_Administrador = codigo_Administrador;
	Nombres_Administrador = nombres_Administrador;
	Apellidos_Administrador = apellidos_Administrador;
	Usuario_Administrador = usuario_Administrador;
	Contraseña_Administrador = contraseña_Administrador;
}

public Administrador() {
}

public String getCodigo_Administrador() {
	return Codigo_Administrador;
}
public void setCodigo_Administrador(String codigo_Administrador) {
	Codigo_Administrador = codigo_Administrador;
}
public String getNombres_Administrador() {
	return Nombres_Administrador;
}
public void setNombres_Administrador(String nombres_Administrador) {
	Nombres_Administrador = nombres_Administrador;
}
public String getApellidos_Administrador() {
	return Apellidos_Administrador;
}
public void setApellidos_Administrador(String apellidos_Administrador) {
	Apellidos_Administrador = apellidos_Administrador;
}
public String getUsuario_Administrador() {
	return Usuario_Administrador;
}
public void setUsuario_Administrador(String usuario_Administrador) {
	Usuario_Administrador = usuario_Administrador;
}
public String getContraseña_Administrador() {
	return Contraseña_Administrador;
}
public void setContraseña_Administrador(String contraseña_Administrador) {
	Contraseña_Administrador = contraseña_Administrador;
}


public Administrador ObtenerAdministrador(Administrador admin) {
	
	Administrador Admin = null;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		con = ConexionMySQL.getConexion();
		String sql = "SELECT * FROM ADMINISTRADOR WHERE Usuario_Administrador= ? AND Contraseña_Administrador = ?";
		
	    pst=con.prepareStatement(sql);
	    
	    pst.setString(1, admin.getUsuario_Administrador());
	    pst.setString(2, admin.getContraseña_Administrador());
		
	    rs = pst.executeQuery();
		while(rs.next()) {
			
			Admin = new Administrador(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
				
	} catch (Exception e) {
		System.out.println("Error en Obtener Usuario");
	}
	
	return Admin;
	
}
}
