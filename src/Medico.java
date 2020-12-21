import java.util.ArrayList;

public class Medico {
	private String nombre;
	private  String telefono;
	private String direccion;
	private String especialidad;
	private String correo;
	private String sueldo;
	private Calendario calendario;
	
	public Medico(String nombre, String telefono, String direccion, String especialidad,String correo,String sueldo, Calendario calendario) {
		this.nombre=nombre;
		this.telefono=telefono;
		this.direccion=direccion;
		this.especialidad=especialidad;
		this.setCorreo(correo);
		this.sueldo=sueldo;
		this.calendario = calendario;
	}
	public void actualizarInventario() {
		
	}
	public String consultarHistorial(Paciente paciente) {
		
		return paciente.getRegistro();
	}
	
	
	public String obtenerHorario(){
		return calendario.consultarHorarioMedico(nombre);
	}
	public void atenderPaciente(String datos, Paciente paciente) {
		paciente.actualizaHistorial(datos);
	}
	
	public String getCorreo() {
		return correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getSueldo() {
		return sueldo;
	}
	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
