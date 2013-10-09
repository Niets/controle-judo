/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controleatleta.Remedio;
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
        umRemedio = new Remedio("Benzetacil");
        umRemedio.setDosagem(1);
        umRemedio.setTipo("teste");
        
    }
    
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        String expResult = "teste";
        String result = umRemedio.getTipo();
        assertEquals(expResult, result);
    }
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "outroTeste";
        umRemedio.setTipo(tipo);
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Benzetacil";
        String result = umRemedio.getNome();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Topson";
        umRemedio.setNome(nome);
    }

    @Test
    public void testGetDosagem() {
        System.out.println("getDosagem");
        int expResult = 1;
        int result = umRemedio.getDosagem();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetDosagem() {
        System.out.println("setDosagem");
        int dosagem = 50;
        umRemedio.setDosagem(dosagem);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Benzetacil - 1 (teste)";
        String result = umRemedio.toString();
        assertEquals(expResult, result);
    }
}