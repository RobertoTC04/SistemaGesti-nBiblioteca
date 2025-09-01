package Clases;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Random;
////////////////////////////////////////////////
import ConexionMySQL.ConexionMySQL;


////////////////////////////////////////////////
public class Historial {
private String CodigoHistorial;
private int Tipo_Movimiento;
private Timestamp Fecha_Movimiento;
private String descripcion;
private String Codigo_Lector;
private String Codigo_Libro;
private String Codigo_Administrador;

public Historial(String codigoHistorial, String codigoLector, String codigoLibro,String Codigo_Administrador, int tipoMovimiento, Timestamp fechaMovimiento, String descripcion) {
    this.CodigoHistorial = codigoHistorial;
    this.Codigo_Lector = codigoLector;
    this.Codigo_Libro = codigoLibro;
    this.Codigo_Administrador = Codigo_Administrador;
    this.Tipo_Movimiento = tipoMovimiento;
    this.Fecha_Movimiento = fechaMovimiento;
    this.descripcion = descripcion;
    
}


public String getCodigoHistorial() {
	return CodigoHistorial;
}
public void setCodigoHistorial(String codigoHistorial) {
	CodigoHistorial = codigoHistorial;
}
public int getTipo_Movimiento() {
	return Tipo_Movimiento;
}
public void setTipo_Movimiento(int tipo_Movimiento) {
	Tipo_Movimiento = tipo_Movimiento;
}
public Timestamp getFecha_Movimiento() {
	return Fecha_Movimiento;
}
public void setFecha_Movimiento(Timestamp fecha_Movimiento) {
	Fecha_Movimiento = fecha_Movimiento;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getCodigo_Lector() {
	return Codigo_Lector;
}
public void setCodigo_Cliente(String codigo_Lector) {
	Codigo_Lector = codigo_Lector;
}
public String getCodigo_Libro() {
	return Codigo_Libro;
}
public void setCodigo_Libro(String codigo_Libro) {
	Codigo_Libro = codigo_Libro;
}


public String getCodigo_Administrador() {
	return Codigo_Administrador;
}


public void setCodigo_Administrador(String codigo_Administrador) {
	Codigo_Administrador = codigo_Administrador;
}


public void registrarHistorial(Historial h) {
	Connection con =  null;
	
	PreparedStatement pst = null;
	
	try {
		
		con = ConexionMySQL.getConexion();
		
		String sql = "INSERT INTO HISTORIAL (Codigo_Historial, Codigo_Lector, Codigo_Libro,Codigo_Administrador, Tipo_Movimiento, Descripcion) VALUES (?, ?, ?, ?, ?, ?)";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, h.getCodigoHistorial());
        pst.setString(2, h.getCodigo_Lector());
        pst.setString(3, h.getCodigo_Libro());
        pst.setString(4, h.getCodigo_Administrador());
        pst.setInt(5, h.getTipo_Movimiento());
        pst.setString(6, h.getDescripcion());

        pst.executeUpdate();
        
	} catch (Exception e) {
		System.out.println("Error al registrar historial: " + e.getMessage());
	}
}

public static String GenerarCodigoHistorial() {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String codigo;
    Random rand = new Random();

    do {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int indiceAleatorio = rand.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indiceAleatorio));
        }
        codigo = sb.toString();
    } while (codigoExistenteHistorial(codigo));

    return codigo;
}


public static  boolean codigoExistenteHistorial(String codigo) {
    boolean existe = false;
    try {
        Connection con = ConexionMySQL.getConexion();
        PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM HISTORIAL WHERE Codigo_Historial = ?");
        pst.setString(1, codigo);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            existe = rs.getInt(1) > 0;
        }

    } catch (Exception e) {
        System.out.println("Error al verificar código Historial: " + e.getMessage());
    }
    return existe;
}

}
