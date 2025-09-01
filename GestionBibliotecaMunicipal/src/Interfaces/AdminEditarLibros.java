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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class AdminEditarLibros extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtAutor;
	private JTextField txtEdit;
	private JTextField txtStock;
	private JButton btnModificarLibro;
	private JButton btnSalirdemod;
	private JScrollPane scrollPane;
	private JTable tbModificar;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminEditarLibros dialog = new AdminEditarLibros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminEditarLibros() {
		setBounds(100, 100, 724, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Código");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel.setBounds(37, 78, 63, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(37, 110, 63, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Autor");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(37, 135, 63, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Editorial");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(37, 159, 63, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Stock");
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setFont(new Font("Noyh R ", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(37, 184, 63, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtCod = new JTextField();
			txtCod.setEditable(false);
			txtCod.setColumns(10);
			txtCod.setBounds(107, 78, 125, 17);
			contentPanel.add(txtCod);
		}
		{
			txtNom = new JTextField();
			txtNom.setColumns(10);
			txtNom.setBounds(107, 110, 125, 17);
			contentPanel.add(txtNom);
		}
		{
			txtAutor = new JTextField();
			txtAutor.setColumns(10);
			txtAutor.setBounds(107, 135, 125, 17);
			contentPanel.add(txtAutor);
		}
		{
			txtEdit = new JTextField();
			txtEdit.setColumns(10);
			txtEdit.setBounds(107, 159, 125, 17);
			contentPanel.add(txtEdit);
		}
		{
			txtStock = new JTextField();
			txtStock.setColumns(10);
			txtStock.setBounds(107, 184, 125, 17);
			contentPanel.add(txtStock);
		}
		{
			btnModificarLibro = new JButton("Modificar");
			btnModificarLibro.setFont(new Font("Noyh R ", Font.PLAIN, 12));
			btnModificarLibro.addActionListener(this);
			btnModificarLibro.setBounds(87, 225, 89, 23);
			contentPanel.add(btnModificarLibro);
		}
		{
			{
				btnSalirdemod = new JButton("Salir");
				btnSalirdemod.setFont(new Font("Noyh R ", Font.PLAIN, 12));
				btnSalirdemod.addActionListener(this);
				btnSalirdemod.setBounds(87, 260, 89, 23);
				contentPanel.add(btnSalirdemod);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(272, 56, 381, 256);
				contentPanel.add(scrollPane);
				{
					tbModificar = new JTable();
					tbModificar.addMouseListener(this);
					tbModificar.setFillsViewportHeight(true);
					scrollPane.setViewportView(tbModificar);
				}
				{
					lblNewLabel_5 = new JLabel("");
					lblNewLabel_5.setIcon(new ImageIcon(AdminEditarLibros.class.getResource("/IMAGENES/EDITARLIBROS.png")));
					lblNewLabel_5.setBounds(0, 0, 710, 370);
					contentPanel.add(lblNewLabel_5);
				}
				Listar("");
			}
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalirdemod) {
			do_btnSalirdemod_actionPerformed(e);
		}
		if (e.getSource() == btnModificarLibro) {
			do_btnModificarLibro_actionPerformed(e);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbModificar) {
			do_tbModificar_mouseClicked(e);
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
	      tbModificar.setModel(modelo);
		}
	protected void do_btnModificarLibro_actionPerformed(ActionEvent e) {
		
		try {
			Libro li=new Libro(txtCod.getText(),txtNom.getText(),
					txtAutor.getText() ,txtEdit.getText(),
					Integer.parseInt(txtStock.getText()));
			ArrayLibro m=new ArrayLibro();
			m.editar(li);
			Listar("");
			Limpiar();
			
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Datos vacíos");
		}
	}
	
	
	protected void do_tbModificar_mouseClicked(MouseEvent e) {
		
		int fila= tbModificar.getSelectedRow();
		txtCod.setText(String.valueOf(tbModificar.getValueAt(fila,0)));
		txtNom.setText(String.valueOf(tbModificar.getValueAt(fila,1)));
		txtAutor.setText(String.valueOf(tbModificar.getValueAt(fila,2)));
		txtEdit.setText(String.valueOf(tbModificar.getValueAt(fila,3)));
		txtStock.setText(String.valueOf(tbModificar.getValueAt(fila, 4)));
	}
	void Limpiar() {
		txtCod.setText("");
		txtNom.setText("");
		txtAutor.setText("");
		txtEdit.setText("");
		txtStock.setText("");
	}
	protected void do_btnSalirdemod_actionPerformed(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas salir de Modificar?", "Confirmar", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        this.dispose(); // Cierra la ventana actual
	    }
	}
}
