/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controleatleta.Endereco;
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
public class EnderecoTest {
    
    Endereco umEndereco;
    
    public EnderecoTest(){
    }
    
    @Before
    public void setUp() {
        
        umEndereco = new Endereco();
        
        umEndereco.setLogradouro("Alameda");
        umEndereco.setNumero("1");
        umEndereco.setBairro("Sunflower");
        umEndereco.setCidade("Anapolis");
        umEndereco.setEstado("Goias");
        umEndereco.setPais("Brasil");
        umEndereco.setComplemento("0");
        umEndereco.setCep("11");
    }
    


    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        String expResult = "Sunflower";
        String result = umEndereco.getBairro();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "Potatis";
        umEndereco.setBairro(bairro);
    }

    @Test
    public void testGetCep() {
        System.out.println("getCep");
        String expResult = "11";
        String result = umEndereco.getCep();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetCep() {
        System.out.println("setCep");
        String cep = "13";
        umEndereco.setCep(cep);
    }

    /**
     * Test of getCidade method, of class Endereco.
     */
    @Test
    public void testGetCidade() {
        System.out.println("getCidade");
        String expResult = "Anapolis";
        String result = umEndereco.getCidade();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCidade method, of class Endereco.
     */
    @Test
    public void testSetCidade() {
        System.out.println("setCidade");
        String cidade = "São Gonçalo";
        umEndereco.setCidade(cidade);
    }

    @Test
    public void testGetComplemento() {
        System.out.println("getComplemento");
        String expResult = "0";
        String result = umEndereco.getComplemento();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetComplemento() {
        System.out.println("setComplemento");
        String complemento = "55";
        umEndereco.setComplemento(complemento);
    }

    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        String expResult = "Goias";
        String result = umEndereco.getEstado();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "Rio de Janeiro";
        umEndereco.setEstado(estado);
    }

    @Test
    public void testGetLogradouro() {
        System.out.println("getLogradouro");
        String expResult = "Alameda";
        String result = umEndereco.getLogradouro();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetLogradouro() {
        System.out.println("setLogradouro");
        String logradouro = "Rua";
        umEndereco.setLogradouro(logradouro);
    }

    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        String expResult = "1";
        String result = umEndereco.getNumero();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "13";
        umEndereco.setNumero(numero);
    }

    @Test
    public void testGetPais() {
        System.out.println("getPais");
        String expResult = "Brasil";
        String result = umEndereco.getPais();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPais() {
        System.out.println("setPais");
        String pais = "China";
        umEndereco.setPais(pais);
    }
}