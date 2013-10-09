/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controleatleta.Atleta;
import java.util.ArrayList;
import java.util.Date;
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
public class AtletaTest {
    
    Atleta umAtleta;
    
    @Before
    public void setUp() {
      umAtleta = new Atleta ("Joao");
      umAtleta.setAltura(1.80);
      umAtleta.setCpf("1");
      umAtleta.setNomeMae("Helena");
      umAtleta.setNomePai("Pedro");
      umAtleta.setPeso(70.0);
      umAtleta.setRg("1");
      umAtleta.setSexo('M');
      umAtleta.setIdade(10);
      umAtleta.setCategoria(0);
    }

    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        int expResult = 0;
        int result = umAtleta.getCategoria();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        int categoria = 0;
        Atleta instance = null;
        umAtleta.setCategoria(categoria);
    }

    @Test
    public void testGetIdade() {
        System.out.println("getIdade");
        int expResult = 10;
        int result = umAtleta.getIdade();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetIdade() {
        System.out.println("setIdade");
        int idade = 0;
        umAtleta.setIdade(idade);
    }

    @Test
    public void testGetAltura() {
        System.out.println("getAltura");
        Double expResult = 1.80;
        Double result = umAtleta.getAltura();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAltura() {
        System.out.println("setAltura");
        Double altura = 1.80;
        umAtleta.setAltura(altura);
    }

    @Test
    public void testGetCpf() {
        System.out.println("getCpf");
        String expResult = "1";
        String result = umAtleta.getCpf();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCpf method, of class Atleta.
     */
    @Test
    public void testSetCpf() {
        System.out.println("setCpf");
        String cpf = "1";
        umAtleta.setCpf(cpf);
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Joao";
        String result = umAtleta.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Atleta.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Claudio";
        umAtleta.setNome(nome);
    }

    /**
     * Test of getNomeMae method, of class Atleta.
     */
    @Test
    public void testGetNomeMae() {
        System.out.println("getNomeMae");
        String expResult = "Helena";
        String result = umAtleta.getNomeMae();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNomeMae() {
        System.out.println("setNomeMae");
        String nomeMae = "Cristina";
        umAtleta.setNomeMae(nomeMae);
    }

    @Test
    public void testGetNomePai() {
        System.out.println("getNomePai");
        String expResult = "Pedro";
        String result = umAtleta.getNomePai();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomePai method, of class Atleta.
     */
    @Test
    public void testSetNomePai() {
        System.out.println("setNomePai");
        String nomePai = "Julius";
        umAtleta.setNomePai(nomePai);
    }

    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        Double expResult = 70.0;
        Double result = umAtleta.getPeso();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPeso method, of class Atleta.
     */
    @Test
    public void testSetPeso() {
        System.out.println("setPeso");
        Double peso = 99.9;
        umAtleta.setPeso(peso);
    }

    /**
     * Test of getRg method, of class Atleta.
     */
    @Test
    public void testGetRg() {
        System.out.println("getRg");
        String expResult = "1";
        String result = umAtleta.getRg();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRg method, of class Atleta.
     */
    @Test
    public void testSetRg() {
        System.out.println("setRg");
        String rg = "9090";
        umAtleta.setRg(rg);
    }

    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        char expResult = 'M';
        char result = umAtleta.getSexo();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        char sexo = 'F';
        umAtleta.setSexo(sexo);
    }
}