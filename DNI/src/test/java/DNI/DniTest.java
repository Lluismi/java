package DNI;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DniTest {

    private static final char[] letrasNoPermitidas = {'I', 'Ã', 'O', 'U'};

    private static final String[] casosTestPass = {
        "78484464T","72376173A","01817200Q","95882054E","63587725Q",
        "26861694V","21616083Q","26868974Y","40135330P","89044648X",
        "80117501Z","34168723S","76857238R","66714505S","66499420A"};

    @Test
    public void getParteNumericaDni_stringEsNumero() {
        DNI objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DNI(dni);
            assertTrue(objetoDniCif.isDniNumero(
                        objetoDniCif.extraerParteNumericaDni()));
        }
    }

    @Test
    public void checkNumeroDni() {
        DNI objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DNI(dni);
            assertTrue(objetoDniCif.checkNumeroDni());
        }    
    }

    @Test
    public void obtenerLetra() {
        DNI objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DNI(dni);
            assertEquals(objetoDniCif.extraerParteAlfabeticaDni(), 
                            objetoDniCif.obtenerLetra());
        }    
    }

    @Test
    public void checkLetra() {
        DNI objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DNI(dni);
            objetoDniCif.checkNumeroDni();  
            assertTrue(objetoDniCif.checkLetra());
        }
    }

    @Test
    public void checkCIF() {
        DNI objetoDniCif = null;
        for(String dni : casosTestPass){
            objetoDniCif = new DNI(dni);   
            assertTrue(objetoDniCif.checkDni());
        }
    }

    @Test
    public void checkDniIncorrecto() {

        List<String> casosTestFail = generarCasosTestIncorrectos();
        DNI objetoDniCif = null;

        for(String dni : casosTestFail){
            objetoDniCif = new DNI(dni);   
            assertFalse(objetoDniCif.checkDni());
        }
    }

    private List<String> generarCasosTestIncorrectos() {

        int numeroCasos = 25;
		StringBuilder caso = null;
        
        List<String> casosTest = new ArrayList<String>();
		
		for (int i = 1; i <= numeroCasos; i++) {

			caso = new StringBuilder("");

			for (int j = 1; j < 9; j++) {
				Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 59);
				caso.append(String.valueOf(Character.toChars(caracterAscii)));
			}
			Integer caracterAscii = ThreadLocalRandom.current().nextInt(65, 91);
            caso.append(String.valueOf(Character.toChars(caracterAscii)));
            caso.append(letrasNoPermitidas[ThreadLocalRandom.current().nextInt(0, 4)]);
			casosTest.add(caso.toString());
        }
        return casosTest;
    }
}