package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Lector;
import Clases.Historial;
import ConexionMySQL.ConexionMySQL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Registro extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNuevaContraseña;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtNuevoUsuario;
	private JButton btnNewButton;
	private JButton btnSalir;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registro() {
		setModal(true);
		setBounds(100, 100, 598, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNuevaContraseña = new JTextField();
			txtNuevaContraseña.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			txtNuevaContraseña.setColumns(10);
			txtNuevaContraseña.setBounds(282, 156, 158, 20);
			contentPanel.add(txtNuevaContraseña);
		}
		{
			JLabel lblRegistro = new JLabel("REGISTRO");
			lblRegistro.setForeground(new Color(255, 255, 255));
			lblRegistro.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 20));
			lblRegistro.setBounds(248, 28, 88, 20);
			contentPanel.add(lblRegistro);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			txtNombre.addKeyListener(this);
			txtNombre.setColumns(10);
			txtNombre.setBounds(282, 66, 158, 20);
			contentPanel.add(txtNombre);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			txtApellidos.addKeyListener(this);
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(282, 96, 158, 20);
			contentPanel.add(txtApellidos);
		}
		{
			txtNuevoUsuario = new JTextField();
			txtNuevoUsuario.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			txtNuevoUsuario.setColumns(10);
			txtNuevoUsuario.setBounds(282, 126, 158, 20);
			contentPanel.add(txtNuevoUsuario);
		}
		{
			JLabel lblNewLabel = new JLabel("Nombres:");
			lblNewLabel.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(140, 76, 132, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Apellidos:");
			lblNewLabel_1.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(140, 106, 132, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nuevo Usuario:");
			lblNewLabel_2.setFont(new Font("Noyh R ", Font.BOLD, 14));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setBounds(140, 134, 132, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Nueva Contraseña:");
			lblNewLabel_3.setFont(new Font("Noyh R ", Font.BOLD, 14));
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(140, 159, 132, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			btnNewButton = new JButton("REGISTRARSE");
			btnNewButton.setForeground(new Color(255, 0, 128));
			btnNewButton.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(154, 189, 276, 23);
			contentPanel.add(btnNewButton);
		}
		{
			btnSalir = new JButton("SALIR");
			btnSalir.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(154, 223, 276, 23);
			contentPanel.add(btnSalir);
		}
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Registro.class.getResource("/IMAGENES/REGISTRO.png")));
			lblNewLabel_4.setBounds(0, 0, 584, 276);
			contentPanel.add(lblNewLabel_4);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		String nom = txtNombre.getText();
		String ape = txtApellidos.getText();
		String usu = txtNuevoUsuario.getText();
		String con = txtNuevaContraseña.getText();
		String cod = GeneradorCodigoCliente();
		StringBuilder camposVacios = new StringBuilder();
        
			if (nom.isEmpty()) {
			    camposVacios.append("Nombres\n");
			}
			if (ape.isEmpty()) {
			    camposVacios.append("Apellidos\n");
			}
			if (usu.isEmpty()) {
			    camposVacios.append("Nuevo Usuario\n");
			}
			if (con.isEmpty()) {
			    camposVacios.append("Nueva Contraseña\n");
			}
			
			if (camposVacios.length() > 0) {
			    JOptionPane.showMessageDialog(this, "Los siguientes campos están vacíos:\n" + camposVacios.toString());
			    return;
			}
			
			
		    Lector lec = new Lector(cod, nom, ape, usu, con,0,null,null,null);
			
			lec.RegistrarLector(lec);
			
			String codHistorial = Historial.GenerarCodigoHistorial();
			Historial his = new Historial(codHistorial, cod, null, null, 0, null, "Nuevo Usuario Registrado: " + usu);
			his.registrarHistorial(his);
			
			this.dispose();
		

	}
	
	public String GeneradorCodigoCliente() {
	    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; ////////////////
	    String codigo;
	    Random rand = new Random();

	    do {
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i = 0; i < 3; i++) {
	        	
	            int indiceAleatorio = rand.nextInt(caracteres.length());
	            char caracterSeleccionado = caracteres.charAt(indiceAleatorio);	
	            sb.append(caracterSeleccionado);
	            
	        }
	        
	        codigo = sb.toString(); 
	        
	    } while (codigoExistente(codigo));

	    return codigo;
	}

	
	public boolean codigoExistente(String codigo) { ////////////////
	    boolean existe = false;
	    try {
	        Connection con = ConexionMySQL.getConexion();
	        PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM LECTOR WHERE Codigo_Lector = ?");
	        pst.setString(1, codigo);
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            existe = rs.getInt(1) > 0; 
	        }
	        
	      

	    } catch (Exception e) {
	        System.out.println("Error al verificar código: " + e.getMessage());
	    }

	    return existe;
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtApellidos) {
			do_txtApellidos_keyTyped(e);
		}
		if (e.getSource() == txtNombre) {
			do_txtNombre_keyTyped(e);
		}
	}
	protected void do_txtNombre_keyTyped(KeyEvent e) { /////////////////
        char validarLetras = e.getKeyChar();
		
		if(Character.isDigit(validarLetras)) {
			e.consume();
			
			JOptionPane.showMessageDialog(this, "No se permite números en Nombres");
		}
	}
	protected void do_txtApellidos_keyTyped(KeyEvent e) {////////////////
       char validarLetras = e.getKeyChar();
		
		if(Character.isDigit(validarLetras)) {
			e.consume();
			
			JOptionPane.showMessageDialog(this, "No se permite números en Apellidos");
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
