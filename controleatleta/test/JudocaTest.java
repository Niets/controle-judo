/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controleatleta.Judoca;
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

    Judoca umJudoca;
    
    @Before
    public void setUp() {
        
        umJudoca = new Judoca("Luca");
        umJudoca.setDeficiencia("B1");
        umJudoca.setEnvergadura(1.1);
        umJudoca.setFaixa("Branca");
        umJudoca.setTecnicaFavorita("Teste-Waza");
        umJudoca.setTotalDerrotas(5);
        umJudoca.setTotalEstrangulamento(2);
        umJudoca.setTotalLutas(15);
        umJudoca.setTotalVitorias(10);
        umJudoca.setTotalVitoriasIppon(8);
        
    }



    @Test
    public void testGetTecnicaFavorita() {
        System.out.println("getTecnicaFavorita");
        String expResult = "Teste-Waza";
        String result = umJudoca.getTecnicaFavorita();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTecnicaFavorita() {
        System.out.println("setTecnicaFavorita");
        String tecnicaFavorita = "Dis-Teste-Waza";
        umJudoca.setTecnicaFavorita(tecnicaFavorita);
    }

    @Test
    public void testGetTotalDerrotas() {
        System.out.println("getTotalDerrotas");
        int expResult = 5;
        int result = umJudoca.getTotalDerrotas();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetTotalDerrotas() {
        System.out.println("setTotalDerrotas");
        int derrotas = 8;
        umJudoca.setTotalDerrotas(derrotas);
    }

    @Test
    public void testGetTotalEstrangulamento() {
        System.out.println("getTotalEstrangulamento");
        int expResult = 2;
        int result = umJudoca.getTotalEstrangulamento();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetTotalEstrangulamento() {
        System.out.println("setTotalEstrangulamento");
        int estrangulamento = 6;
        umJudoca.setTotalEstrangulamento(estrangulamento);
    }

    @Test
    public void testGetEnvergadura() {
        System.out.println("getEnvergadura");
        Double expResult = 1.1;
        Double result = umJudoca.getEnvergadura();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEnvergadura() {
        System.out.println("setEnvergadura");
        Double envergadura = 2.0;
        umJudoca.setEnvergadura(envergadura);
    }

    @Test
    public void testGetFaixa() {
        System.out.println("getFaixa");
        String expResult = "Branca";
        String result = umJudoca.getFaixa();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFaixa method, of class Judoca.
     */
    @Test
    public void testSetFaixa() {
        System.out.println("setFaixa");
        String faixa = "Preta";
        umJudoca.setFaixa(faixa);
    }

    @Test
    public void testGetTotalLutas() {
        System.out.println("getTotalLutas");
        int expResult = 15;
        int result = umJudoca.getTotalLutas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTotalLutas method, of class Judoca.
     */
    @Test
    public void testSetTotalLutas() {
        System.out.println("setTotalLutas");
        int numLutas = 15;
        umJudoca.setTotalLutas(numLutas);
    }

    @Test
    public void testGetDeficiencia() {
        System.out.println("getDeficiencia");
        String expResult = "B1";
        String result = umJudoca.getDeficiencia();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetDeficiencia() {
        System.out.println("setDeficiencia");
        String deficiencia = "B3";
        umJudoca.setDeficiencia(deficiencia);
    }

    @Test
    public void testGetTotalVitorias() {
        System.out.println("getTotalVitorias");
        int expResult = 10;
        int result = umJudoca.getTotalVitorias();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTotalVitorias() {
        System.out.println("setTotalVitorias");
        int vitorias = 19;
        umJudoca.setTotalVitorias(vitorias);
    }

    @Test
    public void testGetTotalVitoriasIppon() {
        System.out.println("getTotalVitoriasIppon");
        int expResult = 8;
        int result = umJudoca.getTotalVitoriasIppon();
        assertEquals(expResult, result);
    }
    @Test
    public void testSetTotalVitoriasIppon() {
        System.out.println("setTotalVitoriasIppon");
        int vitoriasIppon = 8;
        umJudoca.setTotalVitoriasIppon(vitoriasIppon);
    }
}