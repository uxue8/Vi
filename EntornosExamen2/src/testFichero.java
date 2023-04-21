import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testFichero {
	
	@Test
	void testNombreValido() {
	
	
	assertEquals(true,CrearFicheroLog.nombreValido("fichero^logs.txt"));
	assertEquals(false,CrearFicheroLog.nombreValido("fichero*logs.txt"));
	
	}

}
