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
public class PremiacaoTest {
    
    public PremiacaoTest() {
    }
    
    Premiacao umaPremiacao;
    
    @Before
    public void setUp() {
        
        umaPremiacao = new Premiacao("Ippon", 1992);
        umaPremiacao.setFaixa("Faixa Branca");
        umaPremiacao.setMedalha("ouro");
        
    }

    @Test
    public void testGetTitulo() {
        String expResult = "Ippon";
        String result = umaPremiacao.getTitulo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFaixa() {
        System.out.println("getFaixa");
        String expResult = "Faixa Branca";
        String result = umaPremiacao.getFaixa();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAno() {
        System.out.println("getAno");
        int expResult = 1992;
        int result = umaPremiacao.getAno();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMedalha() {
        System.out.println("getMedalha");
        String expResult = "ouro";
        String result = umaPremiacao.getMedalha();
        assertEquals(expResult, result);
    }

}