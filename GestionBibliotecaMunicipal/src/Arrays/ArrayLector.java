package Arrays;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Lector;
import ConexionMySQL.ConexionMySQL;

public class ArrayLector {
	public ArrayList<Lector>listarLector(){
		ArrayList<Lector> lista=new ArrayList<Lector>();
		try {
			CallableStatement csta=ConexionMySQL.getConexion().prepareCall("{call listarLector()}");
			ResultSet rs = csta.executeQuery();
			Lector le;
			while(rs.next()) {
				le = new Lector(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9));
				lista.add(le);
			}
		} catch (Exception e) {
			
		}
		return lista;
}
	public ArrayList<Lector> ConsultarLector(String nom){
		
		ArrayList<Lector> lista = new ArrayList<Lector>();
		
		try {
			
			
			Statement sta = ConexionMySQL.getConexion().createStatement();
			ResultSet rs = sta.executeQuery("Select*from LECTOR where Nombres_Lector like '%" +nom+"%'");
			Lector le;
			while(rs.next()) {
				le = new Lector(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9));
				lista.add(le);
			}
			
		} catch (Exception e) {

		}
		return lista;
}
}
