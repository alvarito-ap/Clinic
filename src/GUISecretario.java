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
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class GUISecretario extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textFieldDia;
	private JTextField textFieldHora;

	private Secretario secretario;
	private Medico medico;
	private Paciente paciente;

	private String [][] resultados;
	private Object [][]ob;
	private Conector conector;
	private Clinica clinica;

	/**
	 * Launch the application.
	 */
	public void run() {
		/*try {
			GUISecretario frame = new GUISecretario();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 */

	}

	/**
	 * Create the frame.
	 * @param direccion 
	 * @param telefono 
	 * @param nombre 
	 */
	public GUISecretario(String nombre, String telefono, String direccion, Clinica oclinica) {
		conector = new Conector();
		this.clinica = oclinica;
		secretario = new Secretario(nombre, direccion, telefono, 2000, 1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSecretario= new JLabel("Secretario");
		lblSecretario.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 54));
		lblSecretario.setBounds(272, 6, 258, 93);
		contentPane.add(lblSecretario);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblNombre.setBounds(6, 102, 352, 16);
		contentPane.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setBounds(6, 164, 352, 16);
		contentPane.add(lblTelefono);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblDireccion.setBounds(370, 102, 451, 16);
		contentPane.add(lblDireccion);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setBounds(368, 164, 451, 16);
		contentPane.add(lblCorreo);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		textArea.setBackground(new Color(255, 250, 205));
		textArea.setBounds(370, 251, 451, 339);
		contentPane.add(textArea);

		JComboBox<String> comboBoxMedico = new JComboBox<String>();

		comboBoxMedico.setBounds(95, 251, 111, 27);
		contentPane.add(comboBoxMedico);
		Conector con2 = new Conector();



		//ESto es el boton consuktar HORARIO DOCTOR
		JButton btn_ConsultarHorarioDoctor = new JButton("Consultar Horario Doctor");



		btn_ConsultarHorarioDoctor.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btn_ConsultarHorarioDoctor.setBounds(6, 210, 234, 29);
		contentPane.add(btn_ConsultarHorarioDoctor);

		textFieldDia = new JTextField();
		textFieldDia.setBounds(16, 426, 156, 26);
		contentPane.add(textFieldDia);
		textFieldDia.setColumns(10);

		textFieldHora = new JTextField();
		textFieldHora.setBounds(194, 426, 139, 26);
		contentPane.add(textFieldHora);
		textFieldHora.setColumns(10);

		JLabel lblNewLabel = new JLabel("dd/mm/yy");
		lblNewLabel.setBounds(45, 464, 101, 16);
		contentPane.add(lblNewLabel);



		JLabel lblHhmm = new JLabel("hh/mm");
		lblHhmm.setBounds(242, 464, 61, 16);
		contentPane.add(lblHhmm);

		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblMedico.setBounds(16, 257, 61, 16);
		contentPane.add(lblMedico);

		JButton button_solicitarConsulta = new JButton("Solicitar Consulta");

		button_solicitarConsulta.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		button_solicitarConsulta.setBounds(6, 382, 166, 29);
		contentPane.add(button_solicitarConsulta);


		lblTelefono.setText(lblTelefono.getText()+" "+telefono);
		lblDireccion.setText(lblDireccion.getText()+" "+direccion);
		lblNombre.setText(lblNombre.getText()+" "+nombre);

		JButton button_consultarHorariopaciente = new JButton("Consultar Horario Paciente");
		button_consultarHorariopaciente.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		button_consultarHorariopaciente.setBounds(6, 285, 248, 29);
		contentPane.add(button_consultarHorariopaciente);

		JButton btnCancelarCita = new JButton("Cancelar Cita");

		btnCancelarCita.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnCancelarCita.setBounds(184, 382, 149, 29);
		contentPane.add(btnCancelarCita);

		JButton button_registrarPaceinte = new JButton("Registrar Paciente");

		button_registrarPaceinte.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		button_registrarPaceinte.setBounds(86, 517, 168, 29);
		contentPane.add(button_registrarPaceinte);

		JComboBox<String> comboBoxPaciente = new JComboBox<String>();


		comboBoxPaciente.setBounds(70, 330, 136, 27);
		contentPane.add(comboBoxPaciente);

		JLabel label = new JLabel("Paciente");
		label.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		label.setBounds(8, 334, 61, 16);
		contentPane.add(label);

		//Scroll Medico
		ArrayList<String> medicos = clinica.getMedicos();
		for (int i = 0; i < medicos.size(); i++) {
			comboBoxMedico.addItem(medicos.get(i));
		}


		//ESTO ES EL SCROLL DE LOS PACIENTES
		ArrayList<String> pacientes = clinica.getPacientes();
		for (int i = 0; i < pacientes.size(); i++) {
			comboBoxPaciente.addItem(pacientes.get(i));
		}


		//cargo medico y paceinte iniciales
		try {
			ob = conector.metodo("SELECT `nombreMedico`,`telefono`,`direccion`,`especialidad`,`correo`,`sueldo` , `idCalendario`  FROM `medico` WHERE `nombreMedico` = '"+comboBoxMedico.getSelectedItem().toString()+"';");
			if(ob!=null&& ob.length>0) {

				resultados = new Conversor(ob).convertir();

				medico= new Medico( resultados[0][0], resultados[0][1],resultados[0][2], resultados[0][3], resultados[0][4], resultados[0][5], new Calendario(Integer.valueOf(resultados[0][6])));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			ob = conector.metodo("SELECT `nombrePaciente`, `correo`,`telefono`,`direccion`,`idCalendario` FROM `Paciente` WHERE `nombrePaciente` = '"+comboBoxPaciente.getSelectedItem().toString()+"';");
			resultados = new Conversor(ob).convertir();
			paciente = new Paciente(resultados[0][0],resultados[0][1],resultados[0][2],resultados[0][3],new Calendario(Integer.valueOf(resultados[0][4])));
		} catch (Exception e2) {
			// TODO: handle exception
		}

		comboBoxMedico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					ob = conector.metodo("SELECT `nombreMedico`,`telefono`,`direccion`,`especialidad`,`correo`,`sueldo` , `idCalendario`  FROM `medico` WHERE `nombreMedico` = '"+comboBoxMedico.getSelectedItem().toString()+"';");
					resultados = new Conversor(ob).convertir();
					medico= new Medico( resultados[0][0], resultados[0][1],resultados[0][2], resultados[0][3], resultados[0][4], resultados[0][5], new Calendario(Integer.valueOf(resultados[0][6])));
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});


		comboBoxPaciente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					ob = conector.metodo("SELECT `nombrePaciente`, `correo`,`telefono`,`direccion`,`idCalendario` FROM `Paciente` WHERE `nombrePaciente` = '"+comboBoxPaciente.getSelectedItem().toString()+"';");
					resultados = new Conversor(ob).convertir();
					paciente = new Paciente(resultados[0][0],resultados[0][1],resultados[0][2],resultados[0][3],new Calendario(Integer.valueOf(resultados[0][4])));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});



		//CONSULTAR EL HORARIO DEL PACIENTE y del medico

		button_consultarHorariopaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textArea.setText(paciente.consultarHorarios());
				} catch (Exception e) {
					// TODO: handle exception
				}


			}
		});


		btn_ConsultarHorarioDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(medico.obtenerHorario());
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		//solicitar consulta
		button_solicitarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					secretario.asignarCita(medico.getNombre(),paciente.getNombre(), textFieldDia.getText(), textFieldHora.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});


		//cancelar cita
		btnCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					secretario.cancelarCita(medico.getNombre(), paciente.getNombre(), textFieldDia.getText(),textFieldHora.getText());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});


		//Registrar paciente
		button_registrarPaceinte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPaciente r = new RegistrarPaciente(secretario.getNombre(), secretario.getDireccion(), secretario.getTelefono(),clinica);
				r.setVisible(true);
				dispose();

			}
		});
	}
}
