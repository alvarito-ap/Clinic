
public class Habitacion {
	private int numero;
	private Paciente paciente;
	
	public Habitacion(int numero, Paciente paciente) {
		this.numero = numero;
		this.paciente = paciente;
	}
	
	public void modificarPaceinte(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public int getNumero() {
		return numero;
	}
	
}
