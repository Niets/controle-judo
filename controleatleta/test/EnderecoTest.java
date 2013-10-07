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
public class EnderecoTest {
    
    public EnderecoTest() {
    }
    
    Endereco umEndereco;
    
    @Before
    public void setUp() {
        
        umEndereco = new Endereco();
        umEndereco.setBairro("Sunflower");
        umEndereco.setCep("75000");
        umEndereco.setCidade("Rio");
        umEndereco.setComplemento("1");
        umEndereco.setEstado("Rio de Janeiro");
        umEndereco.setLogradouro("Alameda");
        umEndereco.setNumero("13");
        umEndereco.setPais("Brasil");
                
    }


    /**
     * Test of getBairro method, of class Endereco.
     */
    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        String expResult = "Sunflower";
        String result = umEndereco.getBairro();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCep() {
        System.out.println("getCep");
        String expResult = "75000";
        String result = umEndereco.getCep();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetComplemento() {
        System.out.println("getComplemento");
        String expResult = "1";
        String result = umEndereco.getComplemento();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        String expResult = "Rio de Janeiro";
        String result = umEndereco.getEstado();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLogradouro() {
        System.out.println("getLogradouro");
        String expResult = "Alameda";
        String result = umEndereco.getLogradouro();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        String expResult = "13";
        String result = umEndereco.getNumero();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPais() {
        System.out.println("getPais");
        String expResult = "Brasil";
        String result = umEndereco.getPais();
        assertEquals(expResult, result);
    }
}