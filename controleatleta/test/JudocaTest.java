/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.util.ArrayList;
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
public class JudocaTest {
    
    public JudocaTest() {
    }
    
    Judoca umJudoca;
    
    @Before
    public void setUp()  {
        
        umJudoca = new Judoca("Luis");
        umJudoca.setAltura(1.80);
        umJudoca.setFaixa("Faixa Branca");
        umJudoca.setCategoria('A');
        umJudoca.setCpf("0");
        umJudoca.setEnvergadura(2.0);
        umJudoca.setNomeMae("Júlia");
        umJudoca.setNomePai("Pedro");
        umJudoca.setPeso(78.9);
        umJudoca.setRg("456-1313");
        umJudoca.setSexo('M');
        umJudoca.setTotalDerrotas(5);
        umJudoca.setTotalEstrangulamento(3);
        umJudoca.setTotalLutas(13);
        umJudoca.setTotalVitorias(8);
        umJudoca.setTotalVitoriasIppon(5);
        
    }

    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        char expResult = 'A';
        char result = umJudoca.getCategoria();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetTotalDerrotas() {
        System.out.println("getTotalDerrotas");
        int expResult = 5;
        int result = umJudoca.getTotalDerrotas();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetTotalEstrangulamento() {
        System.out.println("getTotalEstrangulamento");
        int expResult = 3;
        int result = umJudoca.getTotalEstrangulamento();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEnvergadura() {
        System.out.println("getEnvergadura");
        Double expResult = 2.0;
        Double result = umJudoca.getEnvergadura();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFaixa() {
        System.out.println("getFaixa");
        String expResult = "Faixa Branca";
        String result = umJudoca.getFaixa();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalLutas() {
        System.out.println("getTotalLutas");
        int expResult = 13;
        int result = umJudoca.getTotalLutas();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalVitorias() {
        System.out.println("getTotalVitorias");
        int expResult = 8;
        int result = umJudoca.getTotalVitorias();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalVitoriasIppon() {
        System.out.println("getTotalVitoriasIppon");
        int expResult = 5;
        int result = umJudoca.getTotalVitoriasIppon();
        assertEquals(expResult, result);
    }

    @Test
    public void testObterSexoPesoNome_char_double() {
        System.out.println("obterSexoPesoNome");
        char sexo = 'M';
        double peso = 78.9;
        String expResult = "Meio-Médio";
        String result = umJudoca.obterSexoPesoNome(sexo, peso);
        assertEquals(expResult, result);
    }
}