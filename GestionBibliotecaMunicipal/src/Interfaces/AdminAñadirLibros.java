package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arrays.ArrayLibro;
import Clases.Libro;
import ConexionMySQL.ConexionMySQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class AdminAñadirLibros extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAgregar;
	private JLabel lblNombre;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JLabel lblStock;
	private JTextField txtnombre;
	private JTextField txtautor;
	private JTextField txteditorial;
	private JTextField txtstock;
	private JButton btnsalir;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminAñadirLibros dialog = new AdminAñadirLibros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminAñadirLibros() {
		setTitle("Agregar libro");
		setBounds(100, 100, 286, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Listar("");
		}
		{
			btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Noyh R ", Font.PLAIN, 16));
			btnAgregar.addActionListener(this);
			btnAgregar.setBounds(77, 220, 118, 23);
			contentPanel.add(btnAgregar);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(new Color(255, 255, 255));
			lblNombre.setFont(new Font("Noyh R ", Font.PLAIN, 18));
			lblNombre.setBounds(32, 47, 78, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblAutor = new JLabel("Autor:");
			lblAutor.setForeground(new Color(255, 255, 255));
			lblAutor.setFont(new Font("Noyh R ", Font.PLAIN, 18));
			lblAutor.setBounds(32, 88, 78, 14);
			contentPanel.add(lblAutor);
		}
		{
			lblEditorial = new JLabel("Editorial:");
			lblEditorial.setForeground(new Color(255, 255, 255));
			lblEditorial.setFont(new Font("Noyh R ", Font.PLAIN, 18));
			lblEditorial.setBounds(32, 124, 78, 14);
			contentPanel.add(lblEditorial);
		}
		{
			lblStock = new JLabel("Stock:");
			lblStock.setForeground(new Color(255, 255, 255));
			lblStock.setFont(new Font("Noyh R ", Font.PLAIN, 18));
			lblStock.setBounds(32, 171, 78, 14);
			contentPanel.add(lblStock);
		}
		{
			txtnombre = new JTextField();
			txtnombre.setColumns(10);
			txtnombre.setBounds(127, 47, 116, 20);
			contentPanel.add(txtnombre);
		}
		{
			txtautor = new JTextField();
			txtautor.setColumns(10);
			txtautor.setBounds(127, 88, 116, 20);
			contentPanel.add(txtautor);
		}
		{
			txteditorial = new JTextField();
			txteditorial.setColumns(10);
			txteditorial.setBounds(127, 124, 116, 20);
			contentPanel.add(txteditorial);
		}
		{
			txtstock = new JTextField();
			txtstock.setColumns(10);
			txtstock.setBounds(127, 171, 116, 20);
			contentPanel.add(txtstock);
		}
		{
			btnsalir = new JButton("Salir");
			btnsalir.setFont(new Font("Noyh R ", Font.PLAIN, 16));
			btnsalir.addActionListener(this);
			btnsalir.setBounds(77, 254, 118, 23);
			contentPanel.add(btnsalir);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(AdminAñadirLibros.class.getResource("/IMAGENES/AÑADIRLIBRO.png")));
			lblNewLabel_1.setBounds(0, 0, 272, 311);
			contentPanel.add(lblNewLabel_1);
		}
		Listar("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsalir) {
			do_btnsalir_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	
	public void Listar(String nom) {
	      DefaultTableModel modelo=new DefaultTableModel();
	      ArrayLibro m=new ArrayLibro();
	      ArrayList<Libro> lista=new ArrayList<Libro>();
	      if(nom.length()==0)lista=m.listarLibro();
	      else lista=m.ConsultarLibro(nom);
	      modelo.setRowCount(lista.size());
	      Iterator<Libro> it=lista.iterator();
	      modelo.addColumn("Codigo");
	      modelo.addColumn("Nombre");
	      modelo.addColumn("Autor");
	      modelo.addColumn("Editorial");
	      modelo.addColumn("Stock");
	      
	      int i=0;
	      while(it.hasNext()) {
	    	  Object obj=it.next();
	    	  Libro li=(Libro)obj;
	    	  modelo.setValueAt(li.getCodigo_Libro(), i, 0);
	    	  modelo.setValueAt(li.getNombre_Libro(), i, 1);
	    	  modelo.setValueAt(li.getAutor_Libro(), i, 2);
	    	  modelo.setValueAt(li.getEditorial_Libro(), i, 3);
	    	  modelo.setValueAt(li.getStock_Libro(), i, 4);
	    	  i++;
	      }
		}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		
		
	    String nombre = txtnombre.getText().trim();
	    String autor = txtautor.getText().trim();
	    String editorial = txteditorial.getText().trim();
	    String stockTexto = txtstock.getText().trim();

	    
	    if (nombre.isEmpty() || autor.isEmpty() || editorial.isEmpty() || stockTexto.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
	        return;
	    }

	    
	    
	    int stock;
	    try {
	        stock = Integer.parseInt(stockTexto);
	        if (stock < 0) {
	            JOptionPane.showMessageDialog(null, "El stock no puede ser negativo");
	            return;
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "El stock debe ser un número válido");
	        return;
	    }

	    
	    ArrayLibro m = new ArrayLibro();

	    
	    Libro lib = new Libro(generarCodigoLibro(), nombre, autor, editorial, stock);

	    try {
	        
	        m.Insertar(lib);

	        
	        Limpiar();
	        Listar("");

	        JOptionPane.showMessageDialog(null, "Libro registrado correctamente");

	    } catch (Exception e2) {
	        JOptionPane.showMessageDialog(null, "Error al registrar el libro");
	        e2.printStackTrace();
	    }
	}
	void Limpiar() {
		txtnombre.setText("");
		txtautor.setText("");
		txteditorial.setText("");
		txtstock.setText("");
	}
	
	protected void do_btnsalir_actionPerformed(ActionEvent e) {
		
		int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas salir de Modificar?", "Confirmar", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        this.dispose(); 
	  }
	}
	
	
	public static int contarLibros() {
	    int total = 0;
	    try {
	        Connection con = ConexionMySQL.getConexion();
	        PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM LIBRO");
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            total = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        System.out.println("Error al contar libros: " + e.getMessage());
	    }
	    return total;
	}
	
	public static String generarCodigoLibro() {
	    int cantidad = contarLibros(); 

	    char letra = (char)('A' + cantidad / 100);
	    String numero = String.format("%02d", cantidad % 100);

	    return letra + numero;
	}


}
