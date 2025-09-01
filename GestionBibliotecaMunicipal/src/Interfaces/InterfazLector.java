package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arrays.ArrayLibro;
import Clases.Lector_Libro;
import Clases.Historial;
import Clases.Libro;
import ConexionMySQL.ConexionMySQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;

import java.util.Date;
import java.util.Calendar;
public class InterfazLector extends JFrame implements ItemListener, MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JLabel codigo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNom;
	private JTextField txtAutor;
	private JTextField txtEdit;
	private JTextField txtStock;
	private JButton btnNewButton;
	private JLabel mensaje;
	private JTextField txtCod;
	private JLabel codigo_1;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tbLibros;
	private JScrollPane scrollPane_1;
	private JTable tbmislibros;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txtminom;
	private JTextField txtmiau;
	private JTextField txtmiedito;
	private JTextField txtmicod;
	private JButton btnDevolverLibro;
	private JButton btncerrarsesion;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel IMAGENES;
	private JLabel FOTO;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLector frame = new InterfazLector();
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
	public InterfazLector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblBienvenida = new JLabel("BIENVENIDO CLIENTE ");
			lblBienvenida.setForeground(new Color(255, 255, 255));
			lblBienvenida.setBounds(56, 14, 456, 36);
			lblBienvenida.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 24));
			contentPane.add(lblBienvenida);
		}
		{
			codigo = new JLabel("");
			codigo.setForeground(new Color(255, 255, 255));
			codigo.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 14));
			codigo.setBounds(642, 10, 80, 16);
			contentPane.add(codigo);
		}
		{
			mensaje = new JLabel("");
			mensaje.setBounds(522, 36, 249, 14);
			contentPane.add(mensaje);
		}
		{
			{
				{
					codigo_1 = new JLabel("Código Lector:");
					codigo_1.setForeground(new Color(255, 255, 255));
					codigo_1.setBounds(522, 11, 318, 14);
					codigo_1.setFont(new Font("Noyh R ", Font.PLAIN, 18));
					contentPane.add(codigo_1);
				}
				{
					tabbedPane = new JTabbedPane(JTabbedPane.TOP);
					tabbedPane.setBounds(56, 102, 863, 440);
					contentPane.add(tabbedPane);
					{
						panel = new JPanel();
						tabbedPane.addTab("Libros disponibles", null, panel, null);
						panel.setLayout(null);
						{
							IMAGENES = new JLabel("");
							IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/LIBRO-ICON.png")));
							IMAGENES.setBounds(243, 222, 82, 99);
							panel.add(IMAGENES);
						}
						{
							lblNewLabel = new JLabel("LIBRO");
							lblNewLabel.setForeground(new Color(255, 255, 255));
							lblNewLabel.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 20));
							lblNewLabel.setBounds(39, 57, 89, 23);
							panel.add(lblNewLabel);
						}
						{
							lblNewLabel_1 = new JLabel("Código");
							lblNewLabel_1.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_1.setForeground(new Color(255, 255, 255));
							lblNewLabel_1.setBounds(39, 90, 46, 14);
							panel.add(lblNewLabel_1);
						}
						{
							lblNewLabel_2 = new JLabel("Nombre");
							lblNewLabel_2.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_2.setForeground(new Color(255, 255, 255));
							lblNewLabel_2.setBounds(39, 122, 46, 14);
							panel.add(lblNewLabel_2);
						}
						{
							lblNewLabel_3 = new JLabel("Autor");
							lblNewLabel_3.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_3.setForeground(new Color(255, 255, 255));
							lblNewLabel_3.setBounds(39, 149, 46, 14);
							panel.add(lblNewLabel_3);
						}
						{
							lblNewLabel_4 = new JLabel("Editorial");
							lblNewLabel_4.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_4.setForeground(new Color(255, 255, 255));
							lblNewLabel_4.setBounds(39, 176, 46, 14);
							panel.add(lblNewLabel_4);
						}
						{
							lblNewLabel_5 = new JLabel("Stock");
							lblNewLabel_5.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_5.setForeground(new Color(255, 255, 255));
							lblNewLabel_5.setBounds(39, 201, 46, 14);
							panel.add(lblNewLabel_5);
						}
						{
							txtNom = new JTextField();
							txtNom.setBounds(95, 119, 261, 17);
							panel.add(txtNom);
							txtNom.setEditable(false);
							txtNom.setColumns(10);
						}
						{
							txtAutor = new JTextField();
							txtAutor.setBounds(95, 147, 261, 17);
							panel.add(txtAutor);
							txtAutor.setEditable(false);
							txtAutor.setColumns(10);
						}
						{
							txtEdit = new JTextField();
							txtEdit.setBounds(95, 173, 261, 17);
							panel.add(txtEdit);
							txtEdit.setEditable(false);
							txtEdit.setColumns(10);
						}
						{
							txtStock = new JTextField();
							txtStock.setBounds(95, 198, 89, 17);
							panel.add(txtStock);
							txtStock.setEditable(false);
							txtStock.setColumns(10);
						}
						{
							scrollPane = new JScrollPane();
							scrollPane.setBounds(396, 21, 429, 368);
							panel.add(scrollPane);
							{
								tbLibros = new JTable();
								tbLibros.addMouseListener(this);
								tbLibros.setFillsViewportHeight(true);
								scrollPane.setViewportView(tbLibros);
							}
						}
						{
							txtCod = new JTextField();
							txtCod.setBounds(95, 92, 89, 17);
							panel.add(txtCod);
							txtCod.setEditable(false);
							txtCod.setColumns(10);
						}
						{
							btnNewButton = new JButton("Rentar Libro");
							btnNewButton.setForeground(new Color(0, 0, 0));
							btnNewButton.setFont(new Font("Noyh R ", Font.PLAIN, 14));
							btnNewButton.setBounds(60, 260, 124, 23);
							panel.add(btnNewButton);
							{
								lblNewLabel_12 = new JLabel("");
								lblNewLabel_12.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CLIENTE-LIBROS.png")));
								lblNewLabel_12.setBounds(0, 0, 858, 413);
								panel.add(lblNewLabel_12);
							}
							btnNewButton.addActionListener(this);
						}
					}
					{
						panel_1 = new JPanel();
						tabbedPane.addTab("Ver mis libros", null, panel_1, null);
						panel_1.setLayout(null);
						{
							scrollPane_1 = new JScrollPane();
							scrollPane_1.setBounds(32, 44, 560, 323);
							panel_1.add(scrollPane_1);
							{
								tbmislibros = new JTable();
								tbmislibros.addMouseListener(this);
								tbmislibros.setFillsViewportHeight(true);
								scrollPane_1.setViewportView(tbmislibros);
							}
						
						}
						{
							lblNewLabel_6 = new JLabel("LIBRO");
							lblNewLabel_6.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 20));
							lblNewLabel_6.setForeground(new Color(255, 255, 255));
							lblNewLabel_6.setBounds(622, 64, 69, 23);
							panel_1.add(lblNewLabel_6);
						}
						{
							lblNewLabel_7 = new JLabel("Código");
							lblNewLabel_7.setForeground(new Color(255, 255, 255));
							lblNewLabel_7.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_7.setBounds(622, 96, 46, 14);
							panel_1.add(lblNewLabel_7);
						}
						{
							lblNewLabel_8 = new JLabel("Nombre");
							lblNewLabel_8.setForeground(new Color(255, 255, 255));
							lblNewLabel_8.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_8.setBounds(621, 123, 46, 14);
							panel_1.add(lblNewLabel_8);
						}
						{
							lblNewLabel_9 = new JLabel("Autor");
							lblNewLabel_9.setForeground(new Color(255, 255, 255));
							lblNewLabel_9.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_9.setBounds(621, 148, 46, 14);
							panel_1.add(lblNewLabel_9);
						}
						{
							lblNewLabel_10 = new JLabel("Editorial");
							lblNewLabel_10.setForeground(new Color(255, 255, 255));
							lblNewLabel_10.setFont(new Font("Noyh R ", Font.PLAIN, 13));
							lblNewLabel_10.setBounds(621, 172, 46, 14);
							panel_1.add(lblNewLabel_10);
						}
						{
							txtminom = new JTextField();
							txtminom.setFont(new Font("Noyh R ", Font.PLAIN, 12));
							txtminom.setEditable(false);
							txtminom.setColumns(10);
							txtminom.setBounds(677, 120, 154, 17);
							panel_1.add(txtminom);
						}
						{
							txtmiau = new JTextField();
							txtmiau.setFont(new Font("Noyh R ", Font.PLAIN, 12));
							txtmiau.setEditable(false);
							txtmiau.setColumns(10);
							txtmiau.setBounds(677, 145, 154, 17);
							panel_1.add(txtmiau);
						}
						{
							txtmiedito = new JTextField();
							txtmiedito.setFont(new Font("Noyh R ", Font.PLAIN, 12));
							txtmiedito.setEditable(false);
							txtmiedito.setColumns(10);
							txtmiedito.setBounds(677, 169, 154, 17);
							panel_1.add(txtmiedito);
						}
						{
							txtmicod = new JTextField();
							txtmicod.setFont(new Font("Noyh R ", Font.PLAIN, 12));
							txtmicod.setEditable(false);
							txtmicod.setColumns(10);
							txtmicod.setBounds(678, 93, 89, 17);
							panel_1.add(txtmicod);
						}
						{
							btnDevolverLibro = new JButton("Devolver Libro");
							btnDevolverLibro.setForeground(new Color(255, 0, 128));
							btnDevolverLibro.setFont(new Font("Noyh R ", Font.PLAIN, 12));
							btnDevolverLibro.addActionListener(this);
							btnDevolverLibro.setBounds(663, 311, 124, 23);
							panel_1.add(btnDevolverLibro);
						}
						{
							FOTO = new JLabel("");
							FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CLIENTE-LIBROS-VER.png")));
							FOTO.setBounds(676, 202, 82, 99);
							panel_1.add(FOTO);
						}
						{
							lblNewLabel_13 = new JLabel("");
							lblNewLabel_13.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CLIENTE-VER.png")));
							lblNewLabel_13.setBounds(0, 0, 858, 413);
							panel_1.add(lblNewLabel_13);
						}
					}
				}
				{
					btncerrarsesion = new JButton("Cerrar sesión");
					btncerrarsesion.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					btncerrarsesion.addActionListener(this);
					btncerrarsesion.setBounds(753, 76, 151, 23);
					contentPane.add(btncerrarsesion);
				}
				{
					lblNewLabel_11 = new JLabel("");
					lblNewLabel_11.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CLIENTE.png")));
					lblNewLabel_11.setBounds(0, 0, 965, 589);
					contentPane.add(lblNewLabel_11);
				}
				Listar("");
			}
		}
		
		
	}
	
	public void Bienvenida(String nombre) { ////////////////
	    lblBienvenida.setText("Bienvenido: " + nombre);
	}
	
	public void codigo(String cod) { ////////////////
	    codigo.setText(String.valueOf(cod));
		cargarLibrosLector(codigo.getText());
		Mensaje();
	}
	public void itemStateChanged(ItemEvent e) {
	}
	
	public void Mensaje () {
		String x = codigo.getText();
		
		String sql = "SELECT ContadorSanciones_Lector FROM LECTOR WHERE Codigo_Lector = ?";
		
		try {
			
			Connection con = ConexionMySQL.getConexion();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, x); 
			ResultSet rs = pst.executeQuery();
			
			 if (rs.next()) {
		            int sanciones = rs.getInt(1);

		            if (sanciones == 1) {
		            	mensaje.setText("Usted tiene una sanción aplicada, cuidado");
		            } else if (sanciones == 2) {
		            	mensaje.setText("Usted tiene dos sanciones aplicadas, tenga mucho cuidado");
		            } 

		        }
		} catch (Exception e) {
	        
			 System.out.println("Error al consultar sanciones: " + e.getMessage());
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbmislibros) {
			do_tbmislibros_mouseClicked(e);
		}
		if (e.getSource() == tbLibros) {
			do_tbLibros_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
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
	      tbLibros.setModel(modelo);
		}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btncerrarsesion) {
			do_btncerrarsesion_actionPerformed(e);
		}
		if (e.getSource() == btnDevolverLibro) {
			do_btnDevolverLibro_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	    String codLector = codigo.getText().replace("Código Lector: ", "").trim();
	    String codLibro = txtCod.getText();

	    if (codLibro.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Selecciona un libro primero");
	        return;
	    }

	    Clases.Lector lec = new Clases.Lector().ObtenerLectorPorCodigo(codLector);
	    if (lec == null) {
	        JOptionPane.showMessageDialog(this, "Lector no encontrado");
	        return;
	    }

	    if (codLibro.equals(lec.getLibro1()) || codLibro.equals(lec.getLibro2()) || codLibro.equals(lec.getLibro3())) {
	        JOptionPane.showMessageDialog(this, "Ya tienes este libro rentado");
	        return;
	    }

	    int librosRentados = Lector_Libro.contarLibrosRentados(codLector);
	    if (librosRentados >= 3) {
	        JOptionPane.showMessageDialog(this, "Ya tienes 3 libros rentados");
	        return;
	    }

	    boolean asignado = false;

	    if (lec.getLibro1() == null || lec.getLibro1().isEmpty()) {
	        lec.setLibro1(codLibro);
	        asignado = true;
	    } else if (lec.getLibro2() == null || lec.getLibro2().isEmpty()) {
	        lec.setLibro2(codLibro);
	        asignado = true;
	    } else if (lec.getLibro3() == null || lec.getLibro3().isEmpty()) {
	        lec.setLibro3(codLibro);
	        asignado = true;
	    }

	    if (!asignado) {
	        JOptionPane.showMessageDialog(this, "No se pudo asignar el libro al lector");
	        return;
	    }

	    // Ahora proceder con el préstamo solo si fue asignado
	    if (!Clases.Libro.disminuirStock(codLibro)) {
	        JOptionPane.showMessageDialog(this, "No hay stock disponible para este libro");
	        return;
	    }

	    Lector_Libro prestamo = new Lector_Libro(codLector, codLibro, new Date());
	    if (prestamo.registrarPrestamo()) {
	        JOptionPane.showMessageDialog(this, "Libro rentado correctamente. Recuerda devolverlo en 3 días.");

	        Historial h = new Historial(Historial.GenerarCodigoHistorial(),codLector,codLibro, null, 3, null,
	            "El lector " + lec.getUsuario_Lector() + " rentó el libro " + txtNom.getText());
	        h.registrarHistorial(h);

	        lec.ActualizarLibrosDelLector() ;

	        Listar("");
	        cargarLibrosLector(codigo.getText());
	        limpiarCampos();
	        
	        
	    } else {
	        JOptionPane.showMessageDialog(this, "Error al registrar el préstamo");
	    }
	}
	
	private void limpiarCampos() {
	    txtCod.setText("");
	    txtNom.setText("");
	    txtAutor.setText("");
	    txtEdit.setText("");
	    txtStock.setText("");
	}

	protected void do_tbLibros_mouseClicked(MouseEvent e) {
		int fila=tbLibros.getSelectedRow();
        txtCod.setText(String.valueOf(tbLibros.getValueAt(fila,0)));
        txtNom.setText(String.valueOf(tbLibros.getValueAt(fila,1)));
        txtAutor.setText(String.valueOf(tbLibros.getValueAt(fila,2)));
        txtEdit.setText(String.valueOf(tbLibros.getValueAt(fila,3)));
        txtStock.setText(String.valueOf(tbLibros.getValueAt(fila, 4)));
        
	    String codLibro = txtCod.getText();
        switch (codLibro)
        {
        case "A00":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/100AÑOS.png")));
            break;
        case "A01":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/1984.png")));
            break;
        case "A02":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/DONQUIJOTE.png")));
            break;
        case "A03":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/ELPRINCIPITO.png")));
            break;
        case "A04":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/FAHRENHEIT.png")));
            break;
        case "A05":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CRONICAS.png")));
            break;
        case "A06":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CIUDADDEPERROS.png")));
            break;
        case "A07":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/HAMBRE.png")));
            break;
        case "A08":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/DAVINCI.png")));
            break;
        case "A09":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/IT.png")));
            break;
        case "A10":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/ORGULLO.png")));
            break;
        case "A11":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/DRACULA.png")));
        	break;
        case "A12":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/RAYUELA.png")));
        	break;
        case "A13":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/SOMBRA.png")));
            break;
        case "A14":
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/HOBBIT.png")));
        	break;
        default:
        	IMAGENES.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/LIBRO-ICON.png")));
            break;
        }
	}
	
	protected void do_btnDevolverLibro_actionPerformed(ActionEvent e) {
		String codLector = codigo.getText().replace("Código Lector: ", "").trim();
	    String codLibro = txtmicod.getText();

	    if (codLibro.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Selecciona un libro primero");
	        return;
	    }

	    Clases.Lector lec = new Clases.Lector().ObtenerLectorPorCodigo(codLector);

	    if (lec == null) {
	        JOptionPane.showMessageDialog(this, "Lector no encontrado");
	        return;
	    }

	    boolean encontrado = false;

	    if (codLibro.equals(lec.getLibro1())) {
	        lec.setLibro1(null);
	        encontrado = true;
	    } else if (codLibro.equals(lec.getLibro2())) {
	        lec.setLibro2(null);
	        encontrado = true;
	    } else if (codLibro.equals(lec.getLibro3())) {
	        lec.setLibro3(null);
	        encontrado = true;
	    }

	    if (!encontrado) {
	        JOptionPane.showMessageDialog(this, "Este libro no está rentado por ti");
	        return;
	    }

	    if (!Clases.Libro.aumentarStock(codLibro)) {
	        JOptionPane.showMessageDialog(this, "Error al actualizar el stock del libro");
	        return;
	    }

	    boolean actualizoLector = lec.ActualizarLibrosDelLector();
	    boolean eliminoPrestamo = Lector_Libro.eliminarPrestamo(codLector, codLibro);

	    if (actualizoLector && eliminoPrestamo) {
	        JOptionPane.showMessageDialog(this, "Libro devuelto correctamente");

	        // Registrar historial de devolución
	        Historial h = new Historial(
	            Historial.GenerarCodigoHistorial(),
	            codLector,
	            codLibro,
	            null,
	            4,
	            null,
	            "El lector " + lec.getUsuario_Lector() + " devolvió el libro " + txtminom.getText()
	        );
	        h.registrarHistorial(h);

	        // ----------- LÓGICA DE SANCIÓN AUTOMÁTICA --------------
	        Date fechaHoy = new Date();
	        Date fechaPrestamo = Lector_Libro.obtenerFechaPrestamo(codLector, codLibro);
	        if (fechaPrestamo != null) {
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(fechaPrestamo);

	            int diasHabiles = 0;
	            while (diasHabiles < 3) {
	                cal.add(Calendar.DAY_OF_MONTH, 1);
	                int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
	                if (diaSemana != Calendar.SUNDAY) {
	                    diasHabiles++;
	                }
	            }

	            Date fechaLimite = cal.getTime();

	            if (fechaHoy.after(fechaLimite)) {
	                Calendar hoy = Calendar.getInstance();
	                if (hoy.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	                    try {
	                        Connection con = ConexionMySQL.getConexion();
	                        PreparedStatement pst = con.prepareStatement(
	                            "UPDATE LECTOR SET ContadorSanciones_Lector = LEAST(ContadorSanciones_Lector + 1, 3) WHERE Codigo_Lector = ?"
	                        );
	                        pst.setString(1, codLector);
	                        pst.executeUpdate();
	                        

	                        Historial hSancion = new Historial(
	                            Historial.GenerarCodigoHistorial(),
	                            codLector,
	                            null,
	                            null,
	                            5,
	                            null,
	                            "El lector fue sancionado automáticamente por retraso en la devolución del libro " + txtminom.getText()
	                        );
	                        hSancion.registrarHistorial(hSancion);
	                    } catch (Exception ex) {
	                        System.out.println("Error al sancionar automáticamente: " + ex.getMessage());
	                    }
	                }
	            }
	        }
	        // ------------------------------------------------------

	        cargarLibrosLector(codLector);
	        limpiarCamposMisLibros();
	    } else {
	        JOptionPane.showMessageDialog(this, "Error al devolver el libro. Verifica la conexión o datos.");
	    }
	}
	public void limpiarCamposMisLibros() {
	    txtmicod.setText("");
	    txtminom.setText("");
	    txtmiau.setText("");
	    txtmiedito.setText("");
	}
	protected void do_tbmislibros_mouseClicked(MouseEvent e) {
		int fila= tbmislibros.getSelectedRow();
        txtmicod.setText(String.valueOf(tbmislibros.getValueAt(fila,0)));
        txtminom.setText(String.valueOf(tbmislibros.getValueAt(fila,1)));
        txtmiau.setText(String.valueOf(tbmislibros.getValueAt(fila,2)));
        txtmiedito.setText(String.valueOf(tbmislibros.getValueAt(fila,3)));     

        String codLibro = txtmicod.getText();
        switch (codLibro)
        {
        case "A00":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/100AÑOS.png")));
            break;
        case "A01":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/1984.png")));
            break;
        case "A02":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/DONQUIJOTE.png")));
            break;
        case "A03":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/ELPRINCIPITO.png")));
            break;
        case "A04":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/FAHRENHEIT.png")));
            break;
        case "A05":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CRONICAS.png")));
            break;
        case "A06":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/CIUDADDEPERROS.png")));
            break;
        case "A07":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/HAMBRE.png")));
            break;
        case "A08":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/DAVINCI.png")));
            break;
        case "A09":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/IT.png")));
            break;
        case "A10":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/ORGULLO.png")));
            break;
        case "A11":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/DRACULA.png")));
        	break;
        case "A12":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/RAYUELA.png")));
        	break;
        case "A13":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/SOMBRA.png")));
            break;
        case "A14":
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/HOBBIT.png")));
            break;
        default:
        	FOTO.setIcon(new ImageIcon(InterfazLector.class.getResource("/IMAGENES/LIBRO-ICON.png")));
            break;
        }   
	}
	public void cargarLibrosLector(String codigoLector) {
	    DefaultTableModel modelo = new DefaultTableModel();
	    modelo.addColumn("Código");
	    modelo.addColumn("Nombre");
	    modelo.addColumn("Autor");
	    modelo.addColumn("Editorial");
	    modelo.addColumn("Fecha Préstamo");
	    modelo.addColumn("Advertencia");

	    try {
	        Connection con = ConexionMySQL.getConexion();
	        PreparedStatement pst = con.prepareStatement("SELECT Codigo_Libro, Fecha_Prestamo FROM LECTOR_LIBRO WHERE Codigo_Lector = ?");
	        pst.setString(1, codigoLector);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            String codLibro = rs.getString("Codigo_Libro");
	            Date fechaPrestamo = rs.getDate("Fecha_Prestamo");

	            PreparedStatement psLibro = con.prepareStatement("SELECT * FROM LIBRO WHERE Codigo_Libro = ?");
	            psLibro.setString(1, codLibro);
	            ResultSet rsLibro = psLibro.executeQuery();

	            if (rsLibro.next()) {
	                String advertencia = "";
	                String fechaTexto = "";

	                if (fechaPrestamo != null) {
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    fechaTexto = sdf.format(fechaPrestamo);

	                    
	                    int dias = contarDiasHabiles(fechaPrestamo, new Date());
	                    
	                    
	                    if (dias > 3) {
	                        advertencia = "¡Ya pasó el plazo! Devuélvelo urgente.";
	                    } else if (dias == 3) {
	                        advertencia = "Hoy es el último día para devolver el libro.";
	                    } else if ((3 - dias) == 1) {
	                        advertencia = "Debes devolverlo en 1 día hábil";
	                    } else {
	                        advertencia = "Debes devolverlo en " + (3 - dias) + " días hábiles";
	                    }
	                }

	                modelo.addRow(new Object[] {
	                    codLibro,
	                    rsLibro.getString("Nombre_Libro"),
	                    rsLibro.getString("Autor_Libro"),
	                    rsLibro.getString("Editorial_Libro"),
	                    fechaTexto,
	                    advertencia
	                });
	            }

	            psLibro.close();
	        }

	        rs.close();
	        pst.close();
	        con.close();
	    } catch (Exception e) {
	        System.out.println("Error al cargar libros: " + e.getMessage());
	    }
	    Listar("");

	    tbmislibros.setModel(modelo);
	}

	protected void do_btncerrarsesion_actionPerformed(ActionEvent e) 
	{
		int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cerrar sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        this.dispose(); // Cierra la ventana actual
	        new InicioDeSesion().setVisible(true); // Abre la pantalla de inicio de sesión
	    }
	}
	
	//calcular fecha

	
	public int contarDiasHabiles(Date inicio, Date fin) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(inicio);

	    int diasHabiles = 0;

	    while (cal.getTime().before(fin) || cal.getTime().equals(fin)) {
	        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
	        if (diaSemana != Calendar.SUNDAY) {
	            diasHabiles++;
	        }
	        cal.add(Calendar.DATE, 1);
	    }

	    return diasHabiles - 1; 
	}
}
