import java.util.ArrayList;

public class Clinica {

	String nombre;
	String direccion;
	int telefono;
	String correo;
	ArrayList<String> departamentos;
	ArrayList<String> listaSecretarios;
	ArrayList<String> listaMedicos;
	ArrayList<String> listaPacientes;
	Calendario oCalendario;
	Almacen oAlmacen;
	Conector conector;
	Object [][] ob;
	String [][] res;
	
	
	public Clinica(String nombreClinica) {
		this.nombre=nombreClinica;
		this.conector= new Conector();
	}
	
	
	public String getCorreo() {
		return correo;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public ArrayList<String> getMedicos() {
		listaMedicos = new ArrayList<String>();
		try {
			ob = conector.metodo("SELECT `nombreMedico` FROM `Medico`");
			res = new Conversor(ob).convertir();
			
			for (int i = 0; i < ob.length; i++) {
				listaMedicos.add(res[i][0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaMedicos;
	}
	
	public ArrayList<String> getPacientes() {
		listaPacientes = new ArrayList<String>();
		try {
			ob = conector.metodo("SELECT `nombrePaciente` FROM `Paciente`");
			res = new Conversor(ob).convertir();
			
			for (int i = 0; i < ob.length; i++) {
				listaPacientes.add(res[i][0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaPacientes;
	}
	
	public ArrayList<String> getSecretarios() {
		listaSecretarios = new ArrayList<String>();
		try {
			ob = conector.metodo("SELECT `nombre` FROM `Secretario`");
			res = new Conversor(ob).convertir();
			
			for (int i = 0; i < ob.length; i++) {
				listaSecretarios.add(res[i][0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaSecretarios;
	}
	
	public ArrayList<String> getDepartamentos() {
		departamentos = new ArrayList<String>();
		try {
			ob = conector.metodo("SELECT `nombreDepartamento`, `localizacion` FROM `Departamento`");
			res = new Conversor(ob).convertir();
			
			for (int i = 0; i < ob.length; i++) {
				departamentos.add(res[i][0]+" planta "+ res[i][1]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return departamentos;
	}
	

}
