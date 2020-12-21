
public class Conversor {
	private Object [][] objeto;
	
	public Conversor(Object [][] objeto) {
		this.objeto = objeto;
	}
	
	public String [][] convertir(){
		String resultado[][]=new String[objeto.length][objeto[0].length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = String.valueOf(objeto[i][j]);
			}
		}
		return resultado;
	}
}
