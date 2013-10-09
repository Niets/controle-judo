/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controleatleta.Premiacao;
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
public class PremiacaoTest {
    
    public PremiacaoTest() {
    }

    Premiacao umPremio;
    
    @Before
    public void setUp() {
        
        umPremio = new Premiacao("Dragao", 13);
        umPremio.setFaixa("Preta");
        umPremio.setMedalha("Ouro");
    }

    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        String expResult = "Dragao";
        String result = umPremio.getTitulo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitulo method, of class Premiacao.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "Unicórnio";
        umPremio.setTitulo(titulo);
    }

    /**
     * Test of getAno method, of class Premiacao.
     */
    @Test
    public void testGetAno() {
        System.out.println("getAno");
        int expResult = 13;
        int result = umPremio.getAno();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetAno() {
        System.out.println("setAno");
        int ano = 1;
        umPremio.setAno(ano);
    }

    @Test
    public void testGetFaixa() {
        System.out.println("getFaixa");
        String expResult = "Preta";
        String result = umPremio.getFaixa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFaixa method, of class Premiacao.
     */
    @Test
    public void testSetFaixa() {
        System.out.println("setFaixa");
        String faixa = "Roxa";
        umPremio.setFaixa(faixa);
    }

    @Test
    public void testGetMedalha() {
        System.out.println("getMedalha");
        String expResult = "Ouro";
        String result = umPremio.getMedalha();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetMedalha() {
        System.out.println("setMedalha");
        String medalha = "Couro";
        umPremio.setMedalha(medalha);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "13 - Dragao (Preta) - Ouro";
        String result = umPremio.toString();
        assertEquals(expResult, result);
    }
}