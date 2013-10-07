/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niets
 */
public class RemedioTest {
    
    Remedio umRemedio;
    
    @Before
    public void setUp() {
 
        
        umRemedio = new Remedio("Albendazol");
        umRemedio.setDosagem(30);
        umRemedio.setTipo("ml/dia");
                
    }


    /**
     * Test of getTipo method, of class Remedio.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        String expResult = "ml/dia";
        String result = umRemedio.getTipo();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Albendazol";
        String result = umRemedio.getNome();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDosagem() {
        System.out.println("getDosagem");
        int expResult = 30;
        int result = umRemedio.getDosagem();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Remedio.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Albendazol - 30 (ml/dia)";
        String result = umRemedio.toString();
        assertEquals(expResult, result);
    }
}