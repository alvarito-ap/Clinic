public class Historial {
	private String nombrePaciente;
	private String registro;

	public Historial(String nombrePaciente) {
		this.setNombrePaciente(nombrePaciente);
	}
	public Historial(String nombrePaciente, String registro) {
		this.setNombrePaciente(nombrePaciente);
		this.registro=registro;
		
	}
	public String getRegistro() {
		String historial = new String();
		
		try {
			//saco registro anterior
			Conector conector = new Conector();
			Object [][] ob = conector.metodo("SELECT `intervenciones` FROM `HistorialIntervenciones` WHERE `nombrePaciente`='"+nombrePaciente+"';");
			if(ob!=null&&ob.length>0) {
				String [][] resultados = new Conversor(ob).convertir();
				historial = resultados[0][0];
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return historial;
	}
	public void actualizarRegistro(String registroAñadido) {
		String nuevoHistorial = new String();
		
		try {
			//saco registro anterior
			Conector conector = new Conector();
			Object [][] ob = conector.metodo("SELECT `intervenciones` FROM `HistorialIntervenciones` WHERE `nombrePaciente`='"+nombrePaciente+"';");
			if(ob!=null&&ob.length>0) {
				String [][] resultados = new Conversor(ob).convertir();
				nuevoHistorial = resultados[0][0];
			}
			
			//actualizo registro
			nuevoHistorial = nuevoHistorial +"\n"+registroAñadido;
			conector.insertar("UPDATE `HistorialIntervenciones` SET `intervenciones` = '"+nuevoHistorial+"' WHERE `nombrePaciente` = '"+nombrePaciente+"';");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
}
