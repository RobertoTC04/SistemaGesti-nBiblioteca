package Arrays;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;  
import Clases.Libro;
import ConexionMySQL.ConexionMySQL;

public class ArrayLibro {
	public ArrayList<Libro>listarLibro(){
		ArrayList<Libro> lista=new ArrayList<Libro>();
		try {
			CallableStatement csta=ConexionMySQL.getConexion().prepareCall("{call ListarLibro()}");
			ResultSet rs = csta.executeQuery();
			Libro li;
			while(rs.next()) {
				li = new Libro(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5));
				lista.add(li);
			}
		} catch (Exception e) {
			
		}
		return lista;
}

	
public ArrayList<Libro> ConsultarCodLibro(String cod){
		
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		try {
			
			CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call ConsultarCodLibro(?)}");
			csta.setString(1, cod);
			ResultSet rs = csta.executeQuery();
			Libro li;
			while(rs.next()) {
				li = new Libro(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5));
				lista.add(li);
			}
			
		} catch (Exception e) {

		}
		return lista;
	}
public ArrayList<Libro> ConsultarLibro(String nom){
	
	ArrayList<Libro> lista = new ArrayList<Libro>();
	
	try {
		
		
		Statement sta = ConexionMySQL.getConexion().createStatement();
		ResultSet rs = sta.executeQuery("Select*from LIBRO where Nombre_Libro like '%" +nom+"%'");
		Libro li;
		while(rs.next()) {
			li = new Libro(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5));
			lista.add(li);
		}
		
	} catch (Exception e) {

	}
	return lista;
	
}
public void Insertar(Libro li) {
	try {
		Connection cnx=ConexionMySQL.getConexion();
		CallableStatement csta=cnx.prepareCall("{call InsertarLibro(?,?,?,?,?)}");
		csta.setString(1,li.getCodigo_Libro());
		csta.setString(2,li.getNombre_Libro());
		csta.setString(3,li.getEditorial_Libro());
		csta.setString(4,li.getEditorial_Libro());
		csta.setInt(5,li.getStock_Libro());
		csta.executeUpdate();
	}catch(Exception e) {
		System.out.println("ERROR"+e);
	}
}
public void eliminar(String cod) {
	try {
		Connection cnx=ConexionMySQL.getConexion();
		CallableStatement csta=cnx.prepareCall("{call EliminarLibro(?)}");
		csta.setString(1, cod);
		csta.executeUpdate();
	}catch (Exception e) {
		System.out.println("ERROR"+e);
	}
}
public void editar(Libro li) {
	try {
		Connection cnx =ConexionMySQL.getConexion();
		CallableStatement csta=cnx.prepareCall("{call EditarLibro(?,?,?,?,?)}");
		csta.setString(1,li.getCodigo_Libro());
		csta.setString(2,li.getNombre_Libro());
		csta.setString(3,li.getAutor_Libro());
		csta.setString(4,li.getEditorial_Libro());
		csta.setInt(5,li.getStock_Libro());
		csta.executeUpdate();
		
	}catch(Exception e) {
		System.out.println("ERROR"+e);
	}
}
}
