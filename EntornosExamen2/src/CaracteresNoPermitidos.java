
import java.util.ArrayList;

public class CaracteresNoPermitidos extends Caracteres{
		
	public CaracteresNoPermitidos(String nombre) {
		
		setNombreJuegoDeCaracteres(nombre);
		
		caracteres = new ArrayList<String>();
		caracteres.add("<");
		caracteres.add(">");
		caracteres.add("\""); // car�cter "
		caracteres.add("/");
		caracteres.add("\\"); // car�cter \
		caracteres.add("|");
		caracteres.add("?");
		caracteres.add("*");
		caracteres.add(":");
	}
}
