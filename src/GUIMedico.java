import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUIMedico extends JFrame implements Runnable {

	private JPanel contentPane;
	private Medico medico;
	private Paciente paciente;
	private Conector conector;
	private String [][] resultados;
	private Object[][] ob;
	private Clinica clinica;


	/**
	 * Launch the application.
	 */
	public void run() {
		/*try {
                        GUIMedico frame = new GUIMedico();
                        frame.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }*/

	}

	/**
	 * Create the frame.
	 * @param correo 
	 * @param espe 
	 * @param telef 
	 * @param nom 
	 */

	public GUIMedico(String nom, String telef, String espe, String correo,Clinica oclinica) {
		conector = new Conector();
		this.clinica = oclinica;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 251, 152));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDr = new JLabel("Nombre:");
		lblDr.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblDr.setForeground(new Color(255, 255, 255));
		lblDr.setBounds(6, 142, 396, 16);
		contentPane.add(lblDr);

		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 54));
		lblMedico.setBounds(330, 21, 224, 72);
		contentPane.add(lblMedico);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblTelefono.setBounds(6, 216, 396, 16);
		contentPane.add(lblTelefono);

		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblEspecialidad.setForeground(new Color(255, 255, 255));
		lblEspecialidad.setBounds(414, 142, 475, 16);
		contentPane.add(lblEspecialidad);

		JLabel lblCoreeo = new JLabel("Correo:");
		lblCoreeo.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblCoreeo.setForeground(new Color(255, 255, 255));
		lblCoreeo.setBounds(414, 216, 475, 16);
		contentPane.add(lblCoreeo);

		JTextArea txtHola = new JTextArea();
		txtHola.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		txtHola.setBackground(new Color(154, 205, 50));
		txtHola.setBounds(403, 330, 486, 329);
		contentPane.add(txtHola);

		JButton btnConsultarHorario = new JButton("Consultar Horario");
		btnConsultarHorario.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnConsultarHorario.setBounds(6, 290, 156, 29);
		contentPane.add(btnConsultarHorario);



		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.setToolTipText("Seleccionar Paciente");
		comboBox.setFont(new Font("Apple Chancery", Font.PLAIN, 13));
		comboBox.setMaximumRowCount(80);
		comboBox.setBounds(211, 412, 169, 27);
		contentPane.add(comboBox);



		JButton btnAtenderPaciente = new JButton("Atender Paciente");

		btnAtenderPaciente.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnAtenderPaciente.setBounds(437, 290, 156, 29);
		contentPane.add(btnAtenderPaciente);



		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setForeground(new Color(255, 255, 255));
		lblPaciente.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		lblPaciente.setBounds(6, 416, 156, 16);
		contentPane.add(lblPaciente);


		lblCoreeo.setText(lblCoreeo.getText()+" "+correo);
		lblDr.setText(lblDr.getText()+" "+nom);
		lblEspecialidad.setText(lblEspecialidad.getText()+" "+espe);
		lblTelefono.setText(lblTelefono.getText()+" "+telef);

		JButton btnConsultarHistorial = new JButton("Consultar Historial");
		btnConsultarHistorial.setFont(new Font("Apple Chancery", Font.PLAIN, 15));
		btnConsultarHistorial.setBounds(211, 290, 169, 29);
		contentPane.add(btnConsultarHistorial);

		//caego mi objeto medico
		ob = conector.metodo("SELECT `sueldo` ,`direccion`, `idCalendario`, `nombreClinica`  FROM `Medico` WHERE `nombreMedico` = '"+nom+"';");
		if(ob!=null&& ob.length>0) {

			resultados= new Conversor(ob).convertir();
			medico= new Medico(nom, telef, resultados[0][1],espe,correo, resultados[0][0], new Calendario(Integer.valueOf(resultados[0][2])));
		}


		//consultar horario medico
		btnConsultarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHola.setText(medico.obtenerHorario());

			}
		});


		//cargo lista de pacientes
		ArrayList<String> pacientes = clinica.getPacientes();
		for (int i = 0; i < pacientes.size(); i++) {
			comboBox.addItem(pacientes.get(i));
		}



		//creo objeto paciente

		try {
			ob = conector.metodo("SELECT `nombrePaciente` ,`correo`, `telefono`, `direccion`, `idCalendario`  FROM `Paciente` WHERE `nombrePaciente` = '"+comboBox.getSelectedItem().toString()+"';");

			if(ob!=null&& ob.length>0) {
				resultados = new Conversor(ob).convertir();
				paciente= new Paciente(resultados[0][0], resultados[0][1],resultados[0][2],resultados[0][3], new Calendario(Integer.valueOf(resultados[0][4])));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}


		//actualizo paciente si se cambia
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ob = conector.metodo("SELECT `nombrePaciente` ,`correo`, `telefono`, `direccion`, `idCalendario`  FROM `Paciente` WHERE `nombrePaciente` = '"+comboBox.getSelectedItem().toString()+"';");

				if(ob!=null&& ob.length>0) {
					resultados = new Conversor(ob).convertir();
					paciente= new Paciente(resultados[0][0], resultados[0][1],resultados[0][2],resultados[0][3], new Calendario(Integer.valueOf(resultados[0][4])));
				}
			}
		});

		//consulto horario del paciente
		btnConsultarHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String historial = paciente.getRegistro();
					txtHola.setText(historial);
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});




		//atender Paciente
		btnAtenderPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					medico.atenderPaciente(txtHola.getText(), paciente);
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});







	}
}
