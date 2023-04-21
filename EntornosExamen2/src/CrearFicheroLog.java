
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearFicheroLog{
	
	private static final Logger LOGGER = Logger.getLogger(CrearFicheroLog.class.getName());
	private static Scanner teclado = new Scanner(System.in);

	private static CaracteresNoPermitidos caracteresNoPermitidos = new CaracteresNoPermitidos("Caracteres No Permitidos");
	
	public static void main(String[] args) {

		System.out.println("Este programa crea un fichero de log con el nombre introducido por el usuario.");

		String nombre_fichero = null;

		do {
			System.out.println("Introduce nombre del fichero: ");
			nombre_fichero = teclado.next();
		} while (!nombreValido(nombre_fichero));


		configurarLog(nombre_fichero);

		String textoFichero = null;
		System.out.println("Introduce el texto que quieres introducir en el fichero de log: ");
		textoFichero = teclado.next();
		
		LOGGER.log(Level.FINE, textoFichero);

	}

	// TODO implementar Javadoc
	/**
	 * @author ikaslea
	 * @param nombre_fichero
	 * @return devuelve el booleano indicando si es valido
	 */
	public static boolean nombreValido(String nombre_fichero) {
		boolean nombreValido = true;
		for (String caracter : caracteresNoPermitidos.getCaracteres()) {
			if (nombre_fichero.contains(caracter)) {
				nombreValido = false;
			}
		}
		return nombreValido;
	}
	
	public static void configurarLog(String nombre_fichero) {
		 	Handler fileHandler= null;
		 	Handler HTMLHandler = null;
		 	 
		 	try {
				fileHandler = new FileHandler("./"+nombre_fichero + ".txt",true);
				HTMLHandler = new FileHandler("./"+nombre_fichero + ".html");
				
				LOGGER.addHandler(fileHandler);
				LOGGER.addHandler(HTMLHandler);
				
			 	fileHandler.setLevel(Level.ALL);
			 	HTMLHandler.setLevel(Level.ALL);
			 	LOGGER.setLevel(Level.ALL);
			 	
			 	HTMLHandler.setFormatter(new FormatoHTML());

			 	LOGGER.log(Level.FINE, "sjisjisj");
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}
}
