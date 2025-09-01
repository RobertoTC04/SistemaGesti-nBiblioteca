package Clases;

import ConexionMySQL.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Lector_Libro {
    private String codLector;
    private String codLibro;
    private Date fechaPrestamo;

    public Lector_Libro(String codLector, String codLibro, Date fechaPrestamo) {
        this.codLector = codLector;
        this.codLibro = codLibro;
        this.fechaPrestamo = fechaPrestamo;
    }

    
    public boolean registrarPrestamo() {
        String sql = "INSERT INTO LECTOR_LIBRO (Codigo_Lector, Codigo_Libro, Fecha_Prestamo) VALUES (?, ?, ?)";
        try {
            Connection con = ConexionMySQL.getConexion();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, codLector);
            pst.setString(2, codLibro);
            pst.setTimestamp(3, new java.sql.Timestamp(fechaPrestamo.getTime()));
            int rows = pst.executeUpdate();
            
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
            return false;
        }
    }

  
    public static Date obtenerFechaPrestamo(String codLector, String codLibro) {
        String sql = "SELECT Fecha_Prestamo FROM LECTOR_LIBRO WHERE Codigo_Lector = ? AND Codigo_Libro = ?";
        try {
            Connection con = ConexionMySQL.getConexion();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, codLector);
            pst.setString(2, codLibro);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("Fecha_Prestamo");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error al obtener fecha préstamo: " + e.getMessage());
        }
        return null;
    }
    public static int contarLibrosRentados(String codLector) {
        int cantidad = 0;
        try {
            Connection con = ConexionMySQL.getConexion();
            String sql = "SELECT COUNT(*) FROM LECTOR_LIBRO WHERE Codigo_Lector = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, codLector);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cantidad = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error al contar libros rentados: " + e.getMessage());
        }
        return cantidad;
    }
    public static boolean eliminarPrestamo(String codLector, String codLibro) {
        String sql = "DELETE FROM LECTOR_LIBRO WHERE Codigo_Lector = ? AND Codigo_Libro = ?";
        try (Connection con = ConexionMySQL.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, codLector);
            pst.setString(2, codLibro);
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar préstamo: " + e.getMessage());
            return false;
        }
    }
    

}