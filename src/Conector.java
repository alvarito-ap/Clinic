import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Conector {
	
	public Object[][] metodo(String tipo) {
		Object[][] matrix = null;
		ResultSet resTabla = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/Clinica";//jdbc el conector
			Connection con = DriverManager.getConnection(url,"root","");//accedemos al usuario con usuario y contraseñas
			Statement s = con.createStatement();
			int f = 0;
			resTabla = s.executeQuery(tipo);
			while(resTabla.next()) {
				f++;
			}
			resTabla = s.executeQuery(tipo);
			int c = resTabla.getMetaData().getColumnCount();
			matrix = new Object[f][c];
			int cont=1;
			while(resTabla.next()) {
				Object [] prov = new Object[c];
				for (int j = 0; j < prov.length; j++) {
					//System.out.println(resTabla.getString(j+1));
					prov[j] = resTabla.getString(j+1);
					if(prov[j].equals("")) {
						break;
					}else {
						matrix[cont-1][j] = prov[j];
					}
				}
				cont++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return matrix;
	}
	
	public void insertar(String sentencia) {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/Clinica";//jdbc el conector
			Connection con = DriverManager.getConnection(url,"root","");//accedemos al usuario con usuario y contraseñas
			Statement s = con.createStatement();
			s.executeUpdate(sentencia);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
