import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegistrarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_telefono;
	private JTextField textField_direccion;
	private JTextField textField_correo;
	
	private Secretario secretario;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPaciente frame = new RegistrarPaciente("",  "", "",null);
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
	public RegistrarPaciente(String nombre, String direccion, String telefono, Clinica clinica) {
		
		secretario = new Secretario(nombre, direccion,telefono, 2000,1);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setFont(new Font("Apple Chancery", Font.PLAIN, 37));
		lblRegistrar.setBounds(167, 10, 231, 56);
		contentPane.add(lblRegistrar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblNombre.setBounds(6, 83, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblTelefono.setBounds(6, 163, 61, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblDireccion.setBounds(6, 241, 78, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblCorreo.setBounds(6, 329, 61, 16);
		contentPane.add(lblCorreo);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		textField_nombre.setBounds(108, 78, 373, 26);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_telefono = new JTextField();
		textField_telefono.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		textField_telefono.setBounds(108, 158, 373, 26);
		contentPane.add(textField_telefono);
		textField_telefono.setColumns(10);
		
		textField_direccion = new JTextField();
		textField_direccion.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		textField_direccion.setBounds(108, 236, 373, 26);
		contentPane.add(textField_direccion);
		textField_direccion.setColumns(10);
		
		textField_correo = new JTextField();
		textField_correo.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		textField_correo.setBounds(108, 324, 373, 26);
		contentPane.add(textField_correo);
		textField_correo.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		
		btnNewButton.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(167, 453, 175, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		lblContrasea.setBounds(6, 399, 78, 16);
		contentPane.add(lblContrasea);
		
		textField_password = new JTextField();
		textField_password.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		textField_password.setBounds(108, 394, 373, 26);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secretario.registroPaciente(textField_nombre.getText(), textField_telefono.getText(), textField_direccion.getText(), textField_correo.getText(), textField_password.getText());
				new GUISecretario(secretario.getNombre(), secretario.getTelefono(), secretario.getDireccion(), clinica).setVisible(true);;
				dispose();
			}
		});
	}
}
