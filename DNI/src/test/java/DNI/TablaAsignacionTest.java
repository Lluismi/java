package DNI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.BeforeClass;
import org.junit.Test;

public class TablaAsignacionTest {

    private static TablaAsignacion tabla;
    private static final char[] letrasNoPermitidas = {'I', 'Ã', 'O', 'U'};

    @BeforeClass
    public static void crearTabla() {
        tabla = new TablaAsignacion();
    }

    @Test 
    public void getLetraTablaAsignacion() {
		assertEquals('T', tabla.getLetra(0));
		assertEquals('E' , tabla.getLetra(22));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getLetraFueraLimitesTablaAsignacion() {
        tabla.getLetra(100);
    }

    @Test
    public void letraNoPermitida() {
        
        for (char letra : letrasNoPermitidas) {
            assertFalse(tabla.letraPermitida(letra));
        }
    }

    private static boolean testCalcularLetra(List<String> casosTest, TablaAsignacion tabla){
		 
        for (String dni : casosTest) {
            
            String parteNumericaDni = dni.substring(0, dni.length() - 1);
            char letraDni = dni.charAt(dni.length() - 1);
            
            if (tabla.calcularLetra( parteNumericaDni ) == letraDni) {
                continue;
            } else {
                return false;
            }
        }
        return true;
 }


    @Test
    public void calcularLetraPermitida() {

        String[] casosTest = {
        "78484464T","72376173A","01817200Q","95882054E","63587725Q",
        "26861694V","21616083Q","26868974Y","40135330P","89044648X",
        "80117501Z","34168723S","76857238R","66714505S","66499420A"};

        assertTrue(testCalcularLetra(List.of(casosTest), tabla));
    }

    @Test
    public void calcularLetraNoPermitida() {
			
			int numeroCasos = 15;
            StringBuilder caso = null;
			
			List<String> casosTestKO = new ArrayList<String>();
			
			for(int i = 1; i <= numeroCasos; i++) {
                caso = new StringBuilder("");

				for(int j = 1; j < 9; j++){
					Integer caracterAscii = ThreadLocalRandom.current().nextInt(48, 58);
                    caso.append(String.valueOf(Character.toChars(caracterAscii)));
                }
                caso.append(letrasNoPermitidas[ThreadLocalRandom.current().nextInt(0, 4)]);
                casosTestKO.add(caso.toString());
            }
            
            assertFalse(testCalcularLetra(casosTestKO, tabla));
    }
}