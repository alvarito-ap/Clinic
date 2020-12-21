import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class GUIClinica extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textField_User;
	private JTextField textField_Pass;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private Clinica clinica;

	/**
	 * Launch the application.
	 */
	public  void run() {
		try {
			GUIClinica frame = new GUIClinica();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public GUIClinica() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1188, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Clinica Albar");
		lblTitulo.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 60));
		lblTitulo.setBounds(238, 76, 559, 50);
		contentPane.add(lblTitulo);
		
		textField_User = new JTextField();
		textField_User.setBounds(150, 220, 161, 26);
		contentPane.add(textField_User);
		textField_User.setColumns(10);
		
		textField_Pass = new JTextField();
		textField_Pass.setBounds(150, 304, 161, 26);
		contentPane.add(textField_Pass);
		textField_Pass.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario\n");
		lblUser.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		lblUser.setBounds(6, 223, 141, 16);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		lblPass.setBounds(6, 307, 141, 16);
		contentPane.add(lblPass);
		
		JLabel lblDirreccion = new JLabel("Dirreccion");
		lblDirreccion.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		lblDirreccion.setBounds(374, 192, 114, 16);
		contentPane.add(lblDirreccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		lblTelefono.setBounds(374, 269, 86, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		lblCorreo.setBounds(376, 343, 86, 16);
		contentPane.add(lblCorreo);
		
		JLabel labelDirText = new JLabel("");
		labelDirText.setBounds(475, 192, 411, 16);
		contentPane.add(labelDirText);
		
		JLabel lblTelefText = new JLabel("\n");
		lblTelefText.setBounds(472, 270, 372, 16);
		contentPane.add(lblTelefText);
		
		JLabel lblCorreoText = new JLabel("");
		lblCorreoText.setBounds(455, 343, 358, 16);
		contentPane.add(lblCorreoText);
		
		JButton btnAcceder = new JButton("Acceder");
		
		btnAcceder.setForeground(Color.BLACK);
		btnAcceder.setFont(new Font("Apple Chancery", Font.PLAIN, 18));
		btnAcceder.setBackground(Color.PINK);
		btnAcceder.setBounds(150, 363, 161, 38);
		contentPane.add(btnAcceder);
		
		JRadioButton rdbtnPaciente = new JRadioButton("Paciente");
		buttonGroup.add(rdbtnPaciente);
		rdbtnPaciente.setBounds(319, 445, 141, 23);
		contentPane.add(rdbtnPaciente);
		
		JRadioButton rdbtnSecretario = new JRadioButton("Secretario");
		buttonGroup.add(rdbtnSecretario);
		rdbtnSecretario.setBounds(150, 445, 141, 23);
		contentPane.add(rdbtnSecretario);
		
		JRadioButton rdbtnMedico = new JRadioButton("Medico");
		buttonGroup.add(rdbtnMedico);
		rdbtnMedico.setBounds(6, 445, 141, 23);
		contentPane.add(rdbtnMedico);
		
		JLabel lblDepartamentos = new JLabel("Departamentos");
		lblDepartamentos.setFont(new Font("Apple Chancery", Font.PLAIN, 24));
		lblDepartamentos.setBounds(939, 100, 152, 26);
		contentPane.add(lblDepartamentos);
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		lblMedicos.setBounds(908, 288, 78, 16);
		contentPane.add(lblMedicos);
		
		JLabel lblSecretarios = new JLabel("Secretarios");
		lblSecretarios.setFont(new Font("Apple Chancery", Font.PLAIN, 20));
		lblSecretarios.setBounds(1068, 288, 114, 16);
		contentPane.add(lblSecretarios);
		
		JTextArea textArea_Departamentos = new JTextArea();
		textArea_Departamentos.setBounds(898, 129, 259, 137);
		contentPane.add(textArea_Departamentos);
		
		JTextArea textArea_Medicos = new JTextArea();
		textArea_Medicos.setBounds(856, 323, 161, 169);
		contentPane.add(textArea_Medicos);
		
		JTextArea textArea_Secretarios = new JTextArea();
		textArea_Secretarios.setBounds(1040, 323, 142, 169);
		contentPane.add(textArea_Secretarios);
		
		//cargo valores de la base de datos
		try {
			Conector con = new Conector();
			String [][] res;
			Object[][] ob = con.metodo("SELECT `nombreClinica`, `direccion`, `telefono`, `correo` FROM `Clinica` WHERE `nombreClinica` = 'Albar';");
			Conversor conversor = new Conversor(ob);
			if(ob!=null&&ob.length>0) {
				res = conversor.convertir();
				labelDirText.setText(res[0][1]);
				lblCorreoText.setText(res[0][3]);
				lblTelefText.setText(res[0][2]);
				clinica = new Clinica(res[0][0]);
			}
			
			//cargo departamentos medicso y secretarios
			String aux = new String();
			ArrayList<String> departamentos = clinica.getDepartamentos();
			for (int i = 0; i < departamentos.size(); i++) {
				aux = aux+departamentos.get(i)+"\n";
			}
			textArea_Departamentos.setText(aux);
			
			ArrayList<String> medicos = clinica.getMedicos();
			aux = new String();
			for (int i = 0; i < medicos.size(); i++) {
				aux = aux+medicos.get(i)+"\n";
			}
			textArea_Medicos.setText(aux);
			
			ArrayList<String> secretarios = clinica.getSecretarios();
			aux = new String();
			for (int i = 0; i < secretarios.size(); i++) {
				aux = aux+secretarios.get(i)+"\n";
			}
			textArea_Secretarios.setText(aux);
			
			btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String nombre ;
					String password;
					
					if(rdbtnMedico.isSelected()==true) {
						nombre = textField_User.getText();
						password = textField_Pass.getText();
						Conector con = new Conector();
						Object[][] ob = con.metodo("SELECT `nombreMedico`, `telefono`, `especialidad`, `correo` FROM `Medico` WHERE `nombreMedico` = '"+nombre+"' AND `password` = '"+password+"';");
						if(ob!=null&& ob.length>0) {String [][] p = new Conversor(ob).convertir();
						GUIMedico m = new GUIMedico(p[0][0],p[0][1],p[0][2],p[0][3],clinica);
						m.setVisible(true);dispose();}
					}else if(rdbtnSecretario.isSelected()==true) {
						nombre = textField_User.getText();
						password = textField_Pass.getText();
						Conector con = new Conector();
						Object[][] ob = con.metodo("SELECT `nombre`, `telefono`, `direccion` FROM `Secretario` WHERE `nombre` = '"+nombre+"' AND `password` = '"+password+"';");
						if(ob!=null&& ob.length>0) {String [][] p = new Conversor(ob).convertir();
						GUISecretario m = new GUISecretario(p[0][0],p[0][1],p[0][2],clinica);
						m.setVisible(true);dispose();}
					}else if(rdbtnPaciente.isSelected()==true) {
						nombre = textField_User.getText();
						password = textField_Pass.getText();
						Conector con = new Conector();
						Object[][] ob = con.metodo("SELECT `nombrePaciente`, `telefono`, `direccion`, `correo` FROM `Paciente` WHERE `nombrePaciente` = '"+nombre+"' AND `password` = '"+password+"';");
						if(ob!=null&& ob.length>0) {String [][] p = new Conversor(ob).convertir();
						GUIPaciente m = new GUIPaciente(p[0][0],p[0][1],p[0][2],p[0][3],clinica);
						m.setVisible(true);dispose();}
					}
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
