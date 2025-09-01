package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arrays.ArrayLector;
import Arrays.ArrayLibro;
import Clases.Lector;
import Clases.Historial;
import Clases.Libro;
import ConexionMySQL.ConexionMySQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.KeyListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class InterfazAdministrador extends JFrame implements ActionListener, KeyListener, ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable tbInventario;
	private JScrollPane scrollPane_1;
	private JTable tbHistorial;
	private JScrollPane scrollPane_2;
	private JTable tbUsuario;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JLabel lblNewLabel;
	private JTextField txtnombre;
	private JLabel lblIndice;
	private JLabel lblRegistro;
	private JLabel lblInicio;
	private JLabel lblInicio_1;
	private JLabel lblRenta;
	private JLabel lblIndice_1;
	private JLabel lblIndice_2;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JButton btnClientesex;
	private JButton btncerrarsesion;
	private JButton btnQuitarSancin;
	private JTextField txtCodVER;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtUsuVER;
	private JLabel lblNewLabel_4;
	private JLabel label;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JPanel panel_3;
	private JComboBox cboLibro;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_3;
	private JTable tablalibrosrentados;
	private JLabel label_1;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAdministrador frame = new InterfazAdministrador();
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
	public InterfazAdministrador() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblBienvenida = new JLabel("BIENVENIDO ADMINISTRADOR:");
			lblBienvenida.setForeground(new Color(255, 255, 255));
			lblBienvenida.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 16));
			lblBienvenida.setBounds(38, 27, 618, 23);
			contentPane.add(lblBienvenida);
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(38, 88, 799, 484);
			contentPane.add(tabbedPane);
			{
				panel = new JPanel();
				tabbedPane.addTab("LIBROS", null, panel, null);
				panel.setLayout(null);
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(31, 26, 479, 402);
					panel.add(scrollPane);
					{
						tbInventario = new JTable();
						tbInventario.setFillsViewportHeight(true);
						scrollPane.setViewportView(tbInventario);
					}
					ListarLibros("");
				}
				{
					btnAgregar = new JButton("Agregar");
					btnAgregar.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					btnAgregar.addActionListener(this);
					btnAgregar.setBounds(586, 184, 107, 23);
					panel.add(btnAgregar);
				}
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					btnModificar.addActionListener(this);
					btnModificar.setBounds(586, 242, 107, 23);
					panel.add(btnModificar);
				}
				{
					lblNewLabel = new JLabel("Digite nombre:");
					lblNewLabel.setForeground(new Color(255, 255, 255));
					lblNewLabel.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 16));
					lblNewLabel.setBounds(571, 99, 137, 14);
					panel.add(lblNewLabel);
				}
				{
					txtnombre = new JTextField();
					txtnombre.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					txtnombre.addKeyListener(this);
					txtnombre.setColumns(10);
					txtnombre.setBounds(571, 126, 137, 20);
					panel.add(txtnombre);
				}
				{
					label = new JLabel("New label");
					label.setBounds(0, 0, 71, -67);
					panel.add(label);
				}
				{
					lblNewLabel_5 = new JLabel("");
					lblNewLabel_5.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-INVENTARIO.png")));
					lblNewLabel_5.setBounds(0, 0, 794, 457);
					panel.add(lblNewLabel_5);
				}
			}
			{
				panel_1 = new JPanel();
				tabbedPane.addTab("LECTORES", null, panel_1, null);
				panel_1.setLayout(null);
				
				btnNewButton = new JButton("Sancionar");
				btnNewButton.addActionListener(this);
				btnNewButton.setFont(new Font("Noyh R ", Font.PLAIN, 12));
				btnNewButton.setBounds(38, 224, 161, 21);
				panel_1.add(btnNewButton);
				{
					scrollPane_2 = new JScrollPane();
					scrollPane_2.setBounds(234, 42, 499, 362);
					panel_1.add(scrollPane_2);
					{
						tbUsuario = new JTable();
						tbUsuario.addMouseListener(this);
						tbUsuario.setFillsViewportHeight(true);
						scrollPane_2.setViewportView(tbUsuario);
					}
				}
				{
					{
						btnClientesex = new JButton("Ver Clientes Registrados");
						btnClientesex.setFont(new Font("Noyh R ", Font.PLAIN, 12));
						btnClientesex.addActionListener(this);
						btnClientesex.setBounds(38, 191, 161, 23);
						panel_1.add(btnClientesex);
					}
				}
				{
					btnQuitarSancin = new JButton("Quitar Sanción");
					btnQuitarSancin.setFont(new Font("Noyh R ", Font.PLAIN, 12));
					btnQuitarSancin.addActionListener(this);
					btnQuitarSancin.setBounds(38, 255, 161, 23);
					panel_1.add(btnQuitarSancin);
				}
				{
					txtCodVER = new JTextField();
					txtCodVER.setFont(new Font("Noyh R ", Font.PLAIN, 12));
					txtCodVER.setEditable(false);
					txtCodVER.setBounds(116, 102, 83, 20);
					panel_1.add(txtCodVER);
					txtCodVER.setColumns(10);
				}
				{
					lblNewLabel_2 = new JLabel("Código Lector");
					lblNewLabel_2.setForeground(new Color(255, 255, 255));
					lblNewLabel_2.setFont(new Font("Noyh R ", Font.PLAIN, 12));
					lblNewLabel_2.setBounds(28, 108, 86, 14);
					panel_1.add(lblNewLabel_2);
				}
				{
					lblNewLabel_3 = new JLabel("Usuario Lector");
					lblNewLabel_3.setForeground(new Color(255, 255, 255));
					lblNewLabel_3.setFont(new Font("Noyh R ", Font.PLAIN, 12));
					lblNewLabel_3.setBounds(28, 139, 86, 14);
					panel_1.add(lblNewLabel_3);
				}
				{
					txtUsuVER = new JTextField();
					txtUsuVER.setFont(new Font("Noyh R ", Font.PLAIN, 12));
					txtUsuVER.setEditable(false);
					txtUsuVER.setColumns(10);
					txtUsuVER.setBounds(116, 133, 83, 20);
					panel_1.add(txtUsuVER);
				}
				{
					lblNewLabel_6 = new JLabel("");
					lblNewLabel_6.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-USUARIO.png")));
					lblNewLabel_6.setBounds(0, 0, 794, 457);
					panel_1.add(lblNewLabel_6);
				}
			}
			{
				panel_2 = new JPanel();
				tabbedPane.addTab("HISTORIAL", null, panel_2, null);
				panel_2.setLayout(null);
				{
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(243, 57, 510, 343);
					panel_2.add(scrollPane_1);
					{
						tbHistorial = new JTable();
						tbHistorial.setFillsViewportHeight(true);
						scrollPane_1.setViewportView(tbHistorial);
					}
					ListarHistorialCompelto();
				}
				{
					lblIndice = new JLabel("Indice:");
					lblIndice.setFont(new Font("Novecento Narrow DemiBold", Font.PLAIN, 16));
					lblIndice.setForeground(new Color(255, 255, 255));
					lblIndice.setBounds(42, 94, 116, 27);
					panel_2.add(lblIndice);
				}
				{
					lblRegistro = new JLabel("0- Registro");
					lblRegistro.setForeground(new Color(255, 255, 255));
					lblRegistro.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					lblRegistro.setBounds(41, 136, 203, 14);
					panel_2.add(lblRegistro);
				}
				{
					lblInicio = new JLabel("1- Ingreso cliente");
					lblInicio.setForeground(new Color(255, 255, 255));
					lblInicio.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					lblInicio.setBounds(41, 161, 203, 14);
					panel_2.add(lblInicio);
				}
				{
					lblInicio_1 = new JLabel("2- Ingreso administrador");
					lblInicio_1.setForeground(new Color(255, 255, 255));
					lblInicio_1.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					lblInicio_1.setBounds(41, 186, 203, 14);
					panel_2.add(lblInicio_1);
				}
				{
					lblRenta = new JLabel("3- Renta");
					lblRenta.setForeground(new Color(255, 255, 255));
					lblRenta.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					lblRenta.setBounds(41, 211, 203, 14);
					panel_2.add(lblRenta);
				}
				{
					lblIndice_1 = new JLabel("4- Devolucion");
					lblIndice_1.setForeground(new Color(255, 255, 255));
					lblIndice_1.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					lblIndice_1.setBounds(41, 236, 203, 14);
					panel_2.add(lblIndice_1);
				}
				{
					lblIndice_2 = new JLabel("5- Sanción");
					lblIndice_2.setForeground(new Color(255, 255, 255));
					lblIndice_2.setFont(new Font("Noyh R ", Font.PLAIN, 14));
					lblIndice_2.setBounds(41, 261, 203, 14);
					panel_2.add(lblIndice_2);
				}
				{
					lblNewLabel_1 = new JLabel("Tipo de movimiento");
					lblNewLabel_1.setForeground(Color.CYAN);
					lblNewLabel_1.setFont(new Font("Noyh R ", Font.PLAIN, 13));
					lblNewLabel_1.setBounds(66, 315, 116, 14);
					panel_2.add(lblNewLabel_1);
				}
				{
					comboBox = new JComboBox();
					comboBox.setFont(new Font("Noyh R ", Font.PLAIN, 12));
					comboBox.addItemListener(this);
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cualquiera", "0", "1", "2", "3", "4", "5"}));
					comboBox.setBounds(66, 340, 116, 22);
					panel_2.add(comboBox);
				}
				{
					lblNewLabel_7 = new JLabel("");
					lblNewLabel_7.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-HISTORIAL.png")));
					lblNewLabel_7.setBounds(0, 0, 794, 457);
					panel_2.add(lblNewLabel_7);
				}
			}
			{
				panel_3 = new JPanel();
				tabbedPane.addTab("LIBROS RENTADOS", null, panel_3, null);
				panel_3.setLayout(null);
				{
					cboLibro = new JComboBox();
					cboLibro.addItemListener(this);
					cboLibro.setBounds(49, 130, 187, 22);
					panel_3.add(cboLibro);
				}
				{
					lblNewLabel_8 = new JLabel("Libros");
					lblNewLabel_8.setForeground(new Color(255, 255, 255));
					lblNewLabel_8.setFont(new Font("Noyh R ", Font.PLAIN, 16));
					lblNewLabel_8.setBounds(53, 105, 57, 14);
					panel_3.add(lblNewLabel_8);
				}
				{
					scrollPane_3 = new JScrollPane();
					scrollPane_3.setBounds(276, 54, 476, 367);
					panel_3.add(scrollPane_3);
					{
						tablalibrosrentados = new JTable();
						tablalibrosrentados.setFillsViewportHeight(true);
						scrollPane_3.setViewportView(tablalibrosrentados);
					}
				}
				
				JLabel lblNewLabel_11 = new JLabel("");
				lblNewLabel_11.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-LIBROSRENTADOS.png")));
				lblNewLabel_11.setBounds(0, 0, 794, 457);
				panel_3.add(lblNewLabel_11);
			}
		}
		{
			btncerrarsesion = new JButton("Cerrar sesión");
			btncerrarsesion.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			btncerrarsesion.addActionListener(this);
			btncerrarsesion.setBounds(686, 44, 151, 23);
			contentPane.add(btncerrarsesion);
		}
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN.png")));
			lblNewLabel_4.setBounds(0, 0, 885, 608);
			contentPane.add(lblNewLabel_4);
		}
		{
			label_1 = new JLabel("New label");
			label_1.setBounds(414, 35, 46, 14);
			contentPane.add(label_1);
		}
		{
			lblNewLabel_9 = new JLabel("imagen");
			lblNewLabel_9.setBounds(552, 63, 46, 14);
			contentPane.add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("imagenes");
			lblNewLabel_10.setBounds(564, 61, 92, 14);
			contentPane.add(lblNewLabel_10);
		}
		llenarcombo();
	}
    
	
	public void Bienvenida(String nombre) { ////////////////
	    lblBienvenida.setText("Bienvenido administrador: " + nombre);
	    
	    switch (nombre)
        {
        case "Edgar Antonio Vasquez Bedoya":
			lblNewLabel_4.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-EDGAR.png")));
            break;
        case "Roberto Torres Casapia":
			lblNewLabel_4.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-ROBERTO.png")));
            break;
        case "Raul Alessandro Yarupayta Arotaype":
			lblNewLabel_4.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-RAUL.png")));
            break;
        case "Pedro Emmanuel Zapata Paz":
			lblNewLabel_4.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-PEDRO.png")));
            break;
        case "Fresia Nicole Vilchez Puescas":
			lblNewLabel_4.setIcon(new ImageIcon(InterfazAdministrador.class.getResource("/IMAGENES/ADMIN-FRESSIA.png")));
            break;
        }
        
	    
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnQuitarSancin) {
			do_btnQuitarSancin_actionPerformed(e);
		}
		if (e.getSource() == btncerrarsesion) {
			do_btncerrarsesion_actionPerformed(e);
		}
		if (e.getSource() == btnClientesex) {
			do_btnClientesex_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
		/*if (e.getSource() == btnNewButton_1) {
			do_btnNewButton_1_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton_5) {
			do_btnNewButton_5_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}*/
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		
		String cod = txtCodVER.getText();
		String usu = txtUsuVER.getText();

	    if (cod.isEmpty() || usu.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
	        return;
	    }
		try {
            Connection con = ConexionMySQL.getConexion();
            CallableStatement cs = con.prepareCall("{CALL AplicarSancion(?)}");
            cs.setString(1, cod);
            cs.execute();
            
            
            JOptionPane.showMessageDialog(null, "Sanción aplicada al cliente " + usu);
            ListarLec("");
	        ListarHistorialCompelto();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al aplicar sanción: " + ex.getMessage());
        }
		
		Historial h = new Historial(Historial.GenerarCodigoHistorial(),cod,null,null,5,null,"Se sanciono al cliente " + usu );
		h.registrarHistorial(h);
		
	}
	/*protected void do_btnNewButton_5_actionPerformed(ActionEvent e) {
		
		VerHistorialAdmin vh = new VerHistorialAdmin();
		
		vh.setVisible(true);
		
	}*/
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtnombre) {
			do_txtnombre_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void do_txtnombre_keyReleased(KeyEvent e) {
		String nom = txtnombre.getText();
		ListarLibros(nom);
	}
	public void ListarLibros(String libro) {
		
		DefaultTableModel modelolibro= new DefaultTableModel();
		ArrayLibro m = new ArrayLibro();
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		
		if(libro.length() == 0) lista = m.listarLibro();
		else lista = m.ConsultarLibro(libro);
		
		modelolibro.setRowCount(lista.size());
		Iterator<Libro> it = lista.iterator();
		
		modelolibro.addColumn("Código");
		modelolibro.addColumn("Nombre");
		modelolibro.addColumn("Autor");
		modelolibro.addColumn("Editorial");
		modelolibro.addColumn("Stock");
		
		int  i = 0;
		
		while (it.hasNext()) {
			Object obj = it.next();
			Libro lib = (Libro)obj;
			
			modelolibro.setValueAt(lib.getCodigo_Libro(), i, 0);
			modelolibro.setValueAt(lib.getNombre_Libro(), i, 1);
			modelolibro.setValueAt(lib.getAutor_Libro(), i, 2);
			modelolibro.setValueAt(lib.getEditorial_Libro(), i, 3);
			modelolibro.setValueAt(lib.getStock_Libro(), i, 4);
			i++;
			
		}
		tbInventario.setModel(modelolibro);
	}
	
	void Limpiar() {
		txtnombre.setText("");
	}
	
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		AdminAñadirLibros al = new AdminAñadirLibros();
		
		al.setModal(true);
		al.setVisible(true);
		
		ListarLibros(""); 
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		
		AdminEditarLibros vl = new AdminEditarLibros();
		
		vl.setModal(true);
		vl.setVisible(true);
		
		
		ListarLibros(""); 
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboLibro) {
			do_comboBox_1_itemStateChanged(e);
		}
		if (e.getSource() == comboBox) {
			do_comboBox_itemStateChanged(e);
		}
	}
	protected void do_comboBox_itemStateChanged(ItemEvent e) {
		int indice = comboBox.getSelectedIndex();

	    switch (indice) {
	        case 0:
	            ListarHistorialCompelto();
	            break;
	        case 1:
	            ListarHistorial(0);
	            break;
	        case 2:
	        	ListarHistorial(1);
	            break;
	        case 3:
	        	ListarHistorial(2);
	            break;
	        case 4:
	        	ListarHistorial(3);
	            break;
	        case 5:
	        	ListarHistorial(4);
	            break;
	        case 6:
	        	ListarHistorial(5);
	            break;
	    }
	}
	public void ListarHistorial(int tipoMovimiento) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Código");
	    modelo.addColumn("Tipo de Movimiento");
	    modelo.addColumn("Descripción");
	    modelo.addColumn("Fecha");
	    
	    try {
	    	Connection con = ConexionMySQL.getConexion();
			CallableStatement cs = con.prepareCall("{CALL ObtenerHistorialPorTipo(?)}");
			cs.setInt(1, tipoMovimiento);
			ResultSet rs = cs.executeQuery();
			
			 while (rs.next()) {
		            modelo.addRow(new Object[] {
		                rs.getString("Codigo_Historial"),
		                rs.getInt("Tipo_Movimiento"),
		                rs.getString("Descripcion"),
		                rs.getTimestamp("Fecha_Movimiento")
		            });
		        }
			 
			 tbHistorial.setModel(modelo);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, "Error al listar historial: ");
		}
	}
	public void ListarHistorialCompelto() {
		DefaultTableModel modelo = new DefaultTableModel();
	    modelo.addColumn("Código");
	    modelo.addColumn("Tipo de Movimiento");
	    modelo.addColumn("Descripción");
	    modelo.addColumn("Fecha");

	    try {
	        Connection con = ConexionMySQL.getConexion();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(
	            "SELECT Codigo_Historial, Tipo_Movimiento, Descripcion, Fecha_Movimiento FROM HISTORIAL ORDER BY Fecha_Movimiento"
	        );

	        while (rs.next()) {
	            modelo.addRow(new Object[] {
	                rs.getString("Codigo_Historial"),
	                rs.getInt("Tipo_Movimiento"),
	                rs.getString("Descripcion"),
	                rs.getTimestamp("Fecha_Movimiento")
	            });
	        }

	        tbHistorial.setModel(modelo);

	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error al listar historial completo");
	    }
	}

	protected void do_btnClientesex_actionPerformed(ActionEvent e) {
		Limpiar();
		ListarLec("");
	}
	
	
	public void ListarLec(String nomlec) {
		
		DefaultTableModel modelolecto =new DefaultTableModel();
		ArrayLector mc = new ArrayLector();
		
		ArrayList<Lector> listalec = new ArrayList<Lector>();
		
		if(nomlec.length()==0)listalec= mc.listarLector();
	      else listalec = mc.ConsultarLector(nomlec);
	      modelolecto.setRowCount(listalec.size());
	      Iterator<Lector> it =listalec.iterator();
	      
	      modelolecto.addColumn("Codigo");
	      modelolecto.addColumn("Nombre");
	      modelolecto.addColumn("Apellidos");
	      modelolecto.addColumn("Uuario");
	      modelolecto.addColumn("Sanciones");
	      
	      int i = 0;
	      
	      while(it.hasNext()) {
	    	  Object obj=it.next();
	    	  Lector lector =(Lector)obj;
	    	  modelolecto.setValueAt(lector.getCodigo_Lector(), i, 0);
	    	  modelolecto.setValueAt(lector.getNombres_Lector(), i, 1);
	    	  modelolecto.setValueAt(lector.getApellidos_Lector(), i, 2);
	    	  modelolecto.setValueAt(lector.getUsuario_Lector(), i, 3);
	    	  modelolecto.setValueAt(lector.getContadorSanciones_Lector(), i, 4);
	    	  i++;
	      }
	      tbUsuario.setModel(modelolecto);
		
	}
	protected void do_btncerrarsesion_actionPerformed(ActionEvent e) {
		
		int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cerrar sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        this.dispose(); 
	        new InicioDeSesion().setVisible(true); 
	    }
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbUsuario) {
			do_tbUsuario_mouseClicked(e);
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
	protected void do_tbUsuario_mouseClicked(MouseEvent e) {
		
		int fila = tbUsuario.getSelectedRow(); 

	    if (fila >= 0) {
	        String codLector = tbUsuario.getValueAt(fila, 0).toString(); 
	        String usuLector = tbUsuario.getValueAt(fila, 3).toString(); 

	        txtCodVER.setText(codLector);
	        txtUsuVER.setText(usuLector);
	    }
	}
	protected void do_btnQuitarSancin_actionPerformed(ActionEvent e) {
		
		
		String cod = txtCodVER.getText();
	    String usu = txtUsuVER.getText();

	    if (cod.isEmpty() || usu.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
	        return;
	    }

	    try {
	        Connection con = ConexionMySQL.getConexion();

	        
	        PreparedStatement ps = con.prepareStatement("SELECT ContadorSanciones_Lector FROM LECTOR WHERE Codigo_Lector = ?");
	        ps.setString(1, cod);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        	int sanciones = rs.getInt("ContadorSanciones_Lector");

	            if (sanciones <= 0) {
	                JOptionPane.showMessageDialog(null, "Este lector no tiene sanciones que remover.");
	                return;
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Lector no encontrado.");
	            return;
	        }

	      
	        CallableStatement cs = con.prepareCall("{CALL QuitarSancion(?)}");
	        cs.setString(1, cod);
	        cs.execute();

	        JOptionPane.showMessageDialog(null, "Sanción removida al lector " + usu);
	        ListarLec("");
	        ListarHistorialCompelto();

	        
	        Historial h = new Historial(
	            Historial.GenerarCodigoHistorial(), cod, null, null, 5, null,
	            "Se removió la sanción al lector " + usu
	        );
	        h.registrarHistorial(h);

	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al aplicar sanción: " + ex.getMessage());
	    }
	}
	protected void do_comboBox_1_itemStateChanged(ItemEvent e) {
		
		String nombreLibro = cboLibro.getSelectedItem().toString();
		mostrarPrestamosPorLibro(nombreLibro);
	}
	
	public void llenarcombo() {
		try {
			
			Connection con = ConexionMySQL.getConexion();
			PreparedStatement pst = con.prepareStatement("SELECT Nombre_Libro FROM LIBRO");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				cboLibro.addItem(rs.getString("Nombre_Libro"));
				
			}
		} catch (Exception e) {
			
			System.out.println("Error al llenar el combo: " + e.getMessage());
		}
	}
	
	public void mostrarPrestamosPorLibro(String nombreLibro) {
	    DefaultTableModel tablita = new DefaultTableModel();
	    tablita.addColumn("Código Libro");
	    tablita.addColumn("Nombre Libro");
	    tablita.addColumn("Usuario Lector");
	    tablita.addColumn("Fecha Préstamo");

	    try {
	        Connection con = ConexionMySQL.getConexion();
	        String sql = "SELECT LI.Codigo_Libro, LI.Nombre_Libro, L.Usuario_Lector, LL.Fecha_Prestamo " +
	                "FROM LECTOR_LIBRO LL " +
	                "JOIN LECTOR L ON LL.Codigo_Lector = L.Codigo_Lector " +
	                "JOIN LIBRO LI ON LL.Codigo_Libro = LI.Codigo_Libro " +
	                "WHERE LI.Nombre_Libro = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, nombreLibro);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            String codigo = rs.getString("Codigo_Libro");
	            String nombre = rs.getString("Nombre_Libro");
	            String usuario = rs.getString("Usuario_Lector");
	            String fecha = rs.getString("Fecha_Prestamo");

	            tablita.addRow(new Object[]{codigo, nombre, usuario, fecha});
	        }

	        tablalibrosrentados.setModel(tablita);
	        
	    } catch (Exception e) {
	        System.out.println("Error al mostrar préstamos: " + e.getMessage());
	    }
	}
	
	public void imagen (String nombre) {
		switch (nombre) {
	    
	    default:
	    	break;
	        
	}
	}
}
