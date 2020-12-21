
public class Sala {
	
	private int numero;
	private Medico medico;
	
	public Sala(int numero, Medico medico) {
		this.numero = numero;
		this.medico = medico;
	}
	
	public void modificarMedico(Medico medico) {
		this.medico = medico;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public int getNumero() {
		return numero;
	}
}
