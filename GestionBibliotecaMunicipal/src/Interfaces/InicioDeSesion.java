package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Administrador;
import Clases.Lector;
import Clases.Historial;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class InicioDeSesion extends JFrame implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox TipoUsuario;
	private JTextField txtUsuario;
	private JButton btnNewButton;
	private JButton btneresNuevoUsuario;
	private JPasswordField txtContrasñea;
	private JButton btnSalir;
	private JLabel lblNewLabel_4;
    private int IntentosFallidos=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDeSesion frame = new InicioDeSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioDeSesion() {
		setTitle("Menú de INICIAR SESIÓN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("INICIAR SESIÓN");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 20));
			lblNewLabel.setBounds(307, 148, 175, 22);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Usuario:");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Noyh R ", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(234, 221, 120, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Contraseña:");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Noyh R ", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(234, 249, 120, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Tipo de Usuario:");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Noyh R ", Font.PLAIN, 16));
			lblNewLabel_3.setBounds(234, 192, 120, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			TipoUsuario = new JComboBox();
			TipoUsuario.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			TipoUsuario.addItemListener(this);
			TipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Lector", "Administrador"}));
			TipoUsuario.setBounds(353, 188, 158, 22);
			contentPane.add(TipoUsuario);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			txtUsuario.setColumns(10);
			txtUsuario.setBounds(353, 218, 158, 20);
			contentPane.add(txtUsuario);
		}
		{
			btnNewButton = new JButton("INGRESAR");
			btnNewButton.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(234, 277, 276, 23);
			contentPane.add(btnNewButton);
		}
		{
			btneresNuevoUsuario = new JButton("¿Eres nuevo Lector?");
			btneresNuevoUsuario.setForeground(new Color(255, 0, 128));
			btneresNuevoUsuario.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			btneresNuevoUsuario.addActionListener(this);
			btneresNuevoUsuario.setBounds(234, 313, 277, 23);
			contentPane.add(btneresNuevoUsuario);
		}
		{
			txtContrasñea = new JPasswordField();
			txtContrasñea.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			txtContrasñea.setBounds(353, 246, 158, 20);
			contentPane.add(txtContrasñea);
		}
		{
			btnSalir = new JButton("SALIR");
			btnSalir.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			btnSalir.addActionListener(this);
			btnSalir.setBounds(234, 347, 277, 23);
			contentPane.add(btnSalir);
		}
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(InicioDeSesion.class.getResource("/IMAGENES/FONDOINICIO_USER.png")));
			lblNewLabel_4.setBounds(0, 0, 749, 426);
			contentPane.add(lblNewLabel_4);
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == TipoUsuario) {
			do_comboBox_itemStateChanged(e);
		}
	}
	protected void do_comboBox_itemStateChanged(ItemEvent e) {
		int index = TipoUsuario.getSelectedIndex();
		if(index == 0) {
			lblNewLabel_4.setIcon(new ImageIcon(InicioDeSesion.class.getResource("/IMAGENES/FONDOINICIO_USER.png")));

            	}
		else {
			lblNewLabel_4.setIcon(new ImageIcon(InicioDeSesion.class.getResource("/IMAGENES/FONDOINICIO_ADMIN.png")));

		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btneresNuevoUsuario) {
			do_btneresNuevoUsuario_actionPerformed(e);
		}
	}
	
	void IniciarSesionAdministrador() {
		
	}
	protected void do_btneresNuevoUsuario_actionPerformed(ActionEvent e) {
		
		Registro r = new Registro();
		
		r.setVisible(true);
		
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		int index = TipoUsuario.getSelectedIndex();
		
		String Usuario = txtUsuario.getText();
		String Contraseña = String.valueOf(txtContrasñea.getPassword());
		
		if(Usuario.isEmpty() && Contraseña.isEmpty()) { ////////////////
			JOptionPane.showMessageDialog(this, "El campo Usuario y Contraseña están vacíos");
		}else if (Contraseña.isEmpty()) { ////////////////
			JOptionPane.showMessageDialog(this, "El campo Contraseña está vacío");
		}else if (Usuario.isEmpty()) {////////////////
			JOptionPane.showMessageDialog(this, "El campo Usuario");
		}else {
			
			if(index == 0) {
				
				Lector lec = new Lector();
				lec.setUsuario_Lector(Usuario);
	            lec.setContraseña_Lector(Contraseña);
	            
	            Lector lectorCompleto = lec.ObtenerLector(lec);
	            
	            if(lectorCompleto != null) {
	            	if (lectorCompleto.getContadorSanciones_Lector() >= 3) {
	            		
	            		JOptionPane.showMessageDialog(this, "Su cuenta ha sido suspendida, por favor acercarse al área administrativa para mas información");
	            	}else {
	            		
	            		
		            	Historial h = new Historial(Historial.GenerarCodigoHistorial(),lectorCompleto.getCodigo_Lector(),null,null,1,null,"Inicio de sesión del cliente: " + lectorCompleto.getUsuario_Lector());
		        		
		            	h.registrarHistorial(h);
		            	InterfazLector il = new InterfazLector();
		            	
		            	il.Bienvenida(lectorCompleto.getNombres_Lector() + " " + lectorCompleto.getApellidos_Lector()); ////////////////
		            	il.codigo(lectorCompleto.getCodigo_Lector());////////////////
		            	il.setVisible(true);
		            	
		            	this.dispose();
	            	}
	                    
	            	
	            	
	        		
	            	////////////////
	            }else {
	            	Historial h = new Historial(
	            		    Historial.GenerarCodigoHistorial(),
	            		    null, 
	            		    null,
	            		    null,
	            		    1,
	            		    null,
	            		    "Intento fallido de inicio de sesión para cliente: " + Usuario
	            		);
	            		h.registrarHistorial(h);
	            	IntentosFallidos++;
	            	JOptionPane.showMessageDialog(this, "Tus credenciales de inicio de sesión no coinciden con una cuenta en nuestro sistema");
	                if (IntentosFallidos >= 3) {
	                    JOptionPane.showMessageDialog(this, "Has excedido el número de intentos. El programa se cerrará por seguridad.");
	                    System.exit(0);
	                }
	            }
			}else {
				
				
				Administrador admin = new Administrador();
				admin.setUsuario_Administrador(Usuario);
				admin.setContraseña_Administrador(Contraseña);
				
				Administrador adminCompleto = admin.ObtenerAdministrador(admin);////////////////
			
				
				if (adminCompleto != null) {
					
					Historial h = new Historial(Historial.GenerarCodigoHistorial(),null,null,adminCompleto.getCodigo_Administrador(),2,null,"Inicio de sesión del administrador: " + adminCompleto.getUsuario_Administrador());
					h.registrarHistorial(h);
	            	
				    InterfazAdministrador ia = new InterfazAdministrador(); 
				    ia.Bienvenida(adminCompleto.getNombres_Administrador()+ " "+ adminCompleto.getApellidos_Administrador());////////////////
				    ia.imagen(txtUsuario.getText());
				    ia.setVisible(true);
				    this.dispose(); ////////////////
				} else {
					Historial h = new Historial(
						    Historial.GenerarCodigoHistorial(),
						    null,
						    null,
						    null,
						    2,
						    null,
						    "Intento fallido de inicio de sesión para administrador: " + Usuario
						);
						h.registrarHistorial(h);
					IntentosFallidos++;
				    JOptionPane.showMessageDialog(this, "Tus credenciales de inicio de sesión no coinciden con una cuenta en nuestro sistema");
				    if (IntentosFallidos >= 3) {
	                    JOptionPane.showMessageDialog(this, "Has excedido el número de intentos. El programa se cerrará por seguridad.");
	                    System.exit(0);
	                }
				}
				
			}
		}
		
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
