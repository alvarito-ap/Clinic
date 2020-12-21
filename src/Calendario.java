import java.util.ArrayList;

public class Calendario {
	
	private int id;
	
	private Conector conector;
	private Object[][] ob;
	private String[][] resultados;
	
	public Calendario(int id) {
		this.id=id;
		conector = new Conector();
	}
	
	
	public void añadirCita(String nombreMedico, String nombrePaciente, String fecha, String hora) {
		try {
			conector.insertar("INSERT INTO `Cita`(`idCalendario`,`nombreMedico`,`nombrePaciente`, `fecha`,`hora`) VALUES('1','"+nombreMedico+
					"','"+nombrePaciente+"','"+fecha+"','"+hora+"');");
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	
	public String obtenerCitasPaciente(String nombrePaciente){
		String citas =  new String();
		try {
			ob = conector.metodo("SELECT `nombreMedico`, `fecha`, `hora` FROM `Cita` WHERE `nombrePaciente` = '"+nombrePaciente+"'");
			resultados = new Conversor(ob).convertir();
			if (ob!=null&&ob.length>0) {
				for (int i = 0; i < ob.length; i++) {
					citas = citas + resultados[i][0]+" el "+resultados[i][1]+" a las "+resultados[i][2]+"\n";
				}
				return citas;
				
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		System.out.println(citas);
		return citas;
	}
	
	public String consultarHorarioMedico(String nombreMedico){
		String citas =  new String();
		try {
			ob = conector.metodo("SELECT `nombrePaciente`, `fecha`, `hora` FROM `Cita` WHERE `nombreMedico` = '"+nombreMedico+"';");
			resultados = new Conversor(ob).convertir();
			if (ob!=null&&ob.length>0) {
				for (int i = 0; i < ob.length; i++) {
					citas = citas + resultados[i][0]+" el "+resultados[i][1]+" a las "+resultados[i][2]+"\n";

				}
				return citas;
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		System.out.println(citas);
		return citas;
	}


	
	
	public void cancelarCita( String nombreMedico, String nombrePaciente, String fecha, String hora) {
		try {
			conector.insertar("DELETE FROM `Cita` WHERE `idCalendario`= '1' AND `nombreMedico` = '"+nombreMedico+"' AND `nombrePaciente` = '"+nombrePaciente+"' AND `fecha` = '"+fecha+"' AND `hora` = '"+hora+"';");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
}
