package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ConexionMySQL.ConexionMySQL;

public class Lector {
private String Codigo_Lector;
private String Nombres_Lector;
private String Apellidos_Lector;
private String Usuario_Lector;
private String Contraseña_Lector;
private int ContadorSanciones_Lector;
private String Libro1;
private String Libro2;
private String Libro3;

public Lector(String codigo_Lector, String nombres_Lector, String apellidos_Lector, String usuario_Lector,
		String contraseña_Lector, int contadorSanciones_Lector, String libro1, String libro2, String libro3) {
	Codigo_Lector = codigo_Lector;
	Nombres_Lector = nombres_Lector;
	Apellidos_Lector = apellidos_Lector;
	Usuario_Lector = usuario_Lector;
	Contraseña_Lector = contraseña_Lector;
	ContadorSanciones_Lector = contadorSanciones_Lector;
	Libro1 = libro1;
	Libro2 = libro2;
	Libro3 = libro3;
}



public Lector() {
}

public String getCodigo_Lector() {
	return Codigo_Lector;
}



public void setCodigo_Lector(String codigo_Lector) {
	Codigo_Lector = codigo_Lector;
}



public String getNombres_Lector() {
	return Nombres_Lector;
}



public void setNombres_Lector(String nombres_Lector) {
	Nombres_Lector = nombres_Lector;
}



public String getApellidos_Lector() {
	return Apellidos_Lector;
}



public void setApellidos_Lector(String apellidos_Lector) {
	Apellidos_Lector = apellidos_Lector;
}



public String getUsuario_Lector() {
	return Usuario_Lector;
}



public void setUsuario_Lector(String usuario_Lector) {
	Usuario_Lector = usuario_Lector;
}



public String getContraseña_Lector() {
	return Contraseña_Lector;
}



public void setContraseña_Lector(String contraseña_Lector) {
	Contraseña_Lector = contraseña_Lector;
}



public int getContadorSanciones_Lector() {
	return ContadorSanciones_Lector;
}



public void setContadorSanciones_Lector(int contadorSanciones_Lector) {
	ContadorSanciones_Lector = contadorSanciones_Lector;
}



public String getLibro1() {
	return Libro1;
}



public void setLibro1(String libro1) {
	Libro1 = libro1;
}



public String getLibro2() {
	return Libro2;
}



public void setLibro2(String libro2) {
	Libro2 = libro2;
}



public String getLibro3() {
	return Libro3;
}



public void setLibro3(String libro3) {
	Libro3 = libro3;
}



public void RegistrarLector(Lector lec) {
	
	Connection con = null;
	PreparedStatement pst = null;
	
	try {
		con = ConexionMySQL.getConexion();
		String sql = "INSERT INTO LECTOR (Codigo_Lector, Nombres_Lector, Apellidos_Lector, Usuario_Lector, Contraseña_Lector, ContadorSanciones_Lector, Libro1, Libro2, Libro3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pst = con.prepareStatement(sql);
		pst.setString(1, lec.getCodigo_Lector());
        pst.setString(2, lec.getNombres_Lector());
        pst.setString(3, lec.getApellidos_Lector());
        pst.setString(4, lec.getUsuario_Lector());
        pst.setString(5, lec.getContraseña_Lector());
        pst.setInt(6, lec.getContadorSanciones_Lector());
        pst.setString(7, lec.getLibro1());
        pst.setString(8, lec.getLibro2());
        pst.setString(9, lec.getLibro3());
        
        
        int filas = pst.executeUpdate();

        if (filas > 0) {
            JOptionPane.showMessageDialog(null, "Su cuenta ha sido creada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar lector");
        }
		
	} catch (Exception e) {
		
		JOptionPane.showMessageDialog(null, "El Usuario ya existe, pruebe con otro por favor");
	}
}

public Lector ObtenerLector(Lector lec) {
	
	Lector lector = null;
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		
		con = ConexionMySQL.getConexion();
		String sql = "SELECT * FROM LECTOR WHERE Usuario_Lector= ? AND Contraseña_Lector = ?";
		
	   pst = con.prepareStatement(sql);
	   pst.setString(1, lec.getUsuario_Lector());
	   pst.setString(2, lec.getContraseña_Lector());
	   
	   rs = pst.executeQuery();
	   
	   while(rs.next()) {
		   lector = new Lector(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9));
	   }
	} catch (Exception e) {
		System.out.println("Error en Obtener Lector");
	}
	return lector;
	
}
public Lector ObtenerLectorPorCodigo(String codigoLector) {
    Lector lector = null;
    try (Connection con = ConexionMySQL.getConexion();
         PreparedStatement pst = con.prepareStatement("SELECT * FROM LECTOR WHERE Codigo_LECTOR = ?")) {

        pst.setString(1, codigoLector);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            lector = new Lector(
                rs.getString("Codigo_Lector"),
                rs.getString("Nombres_Lector"),
                rs.getString("Apellidos_Lector"),
                rs.getString("Usuario_Lector"),
                rs.getString("Contraseña_Lector"),
                rs.getInt("ContadorSanciones_Lector"),
                rs.getString("Libro1"),
                rs.getString("Libro2"),
                rs.getString("Libro3")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lector;
}
public boolean ActualizarLibrosDelLector() {
    String sql = "UPDATE LECTOR SET Libro1=?, Libro2=?, Libro3=? WHERE Codigo_Lector=?";
    try (Connection con = ConexionMySQL.getConexion();
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, Libro1);
        pst.setString(2, Libro2);
        pst.setString(3, Libro3);
        pst.setString(4, Codigo_Lector);
        int rows = pst.executeUpdate();
        return rows > 0;
    } catch (Exception e) {
        System.out.println("Error al actualizar lector: " + e.getMessage());
        return false;
    }
}

}
