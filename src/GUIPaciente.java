import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIPaciente extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textFieldDia;
	private JTextField textFieldHora;
	private Object[][] ob;
	private Conversor conversor;
	private String[][] resultados;
	private Clinica clinica;
	
	private Paciente paciente;

	/**
	 * Launch the application.
	 */
	public void run() {
		/*try {
			GUIPaciente frame = new GUIPaciente();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

	/**
	 * Create the frame.
	 * @param correo 
	 * @param direccion 
	 * @param telefono 
	 * @param nombre 
	 */
	public GUIPaciente(String nombre, String telefono, String direccion, String correo, Clinica oclinica) {
		this.clinica = oclinica;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 54));
		lblPaciente.setBounds(272, 6, 213, 93);
		contentPane.add(lblPaciente);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblNombre.setBounds(6, 102, 352, 16);
		contentPane.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setBounds(6, 195, 352, 16);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblDireccion.setBounds(370, 102, 451, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setBounds(370, 195, 451, 16);
		contentPane.add(lblCorreo);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		textArea.setBackground(new Color(255, 228, 181));
		textArea.setBounds(370, 251, 451, 339);
		contentPane.add(textArea);
		
		JButton btnConsultarHorario = new JButton("Consultar Horario Doctor");
		
		btnConsultarHorario.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnConsultarHorario.setBounds(6, 249, 234, 29);
		contentPane.add(btnConsultarHorario);
		
		JButton btnSolicitarConsulta = new JButton("Solicitar Consulta");
		
		btnSolicitarConsulta.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnSolicitarConsulta.setBounds(40, 317, 166, 29);
		contentPane.add(btnSolicitarConsulta);
		
		textFieldDia = new JTextField();
		textFieldDia.setBounds(6, 358, 111, 26);
		contentPane.add(textFieldDia);
		textFieldDia.setColumns(10);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(129, 358, 111, 26);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("dd/mm/yy");
		lblNewLabel.setBounds(16, 396, 101, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> comboBoxMedico = new JComboBox<String>();
		comboBoxMedico.setBounds(79, 449, 111, 27);
		contentPane.add(comboBoxMedico);
		
		JLabel lblHhmm = new JLabel("hh/mm");
		lblHhmm.setBounds(129, 396, 61, 16);
		contentPane.add(lblHhmm);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(6, 453, 61, 16);
		contentPane.add(lblMedico);
		
		JButton btnNewButton = new JButton("Cancelar Cita");
		
		btnNewButton.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnNewButton.setBounds(40, 512, 166, 29);
		contentPane.add(btnNewButton);
		
		//inicializo datos
		lblCorreo.setText(lblCorreo.getText()+" "+correo);
		lblNombre.setText(lblNombre.getText()+" "+nombre);
		lblDireccion.setText(lblDireccion.getText()+" "+direccion);
		lblTelefono.setText(lblTelefono.getText()+" "+telefono);
		
		JButton btnNewButton_1 = new JButton("Consultar Citas");
		btnNewButton_1.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		
		btnNewButton_1.setBounds(40, 561, 166, 29);
		contentPane.add(btnNewButton_1);
		
		//inicializo paciente
		paciente = new Paciente(nombre, correo, telefono, direccion, new Calendario(1));
		
		//cargar Scrool bar de medicos
		ArrayList<String> medicos = clinica.getMedicos();
		for(int i=0; i<medicos.size();i++) {
			comboBoxMedico.addItem(medicos.get(i));
		}
		
		//solicitar cita
		btnSolicitarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					paciente.solicitarConsulta(comboBoxMedico.getSelectedItem().toString(),nombre,textFieldDia.getText().toString(),textFieldHora.getText().toString());
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		
		//consultar horario doctor
		btnConsultarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendario calendario = new Calendario(1);
				textArea.setText(calendario.consultarHorarioMedico(comboBoxMedico.getSelectedItem().toString()));
			}
		});
		
		//consultar horarios paciente
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(paciente.consultarHorarios());
			}
		});
		
		
		//cancelar cita
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paciente.cancelarConsulta(comboBoxMedico.getSelectedItem().toString(),nombre, textFieldDia.getText(), textFieldHora.getText());
			}
		});
		
	}
}
