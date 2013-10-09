/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controleatleta.ControleJudoca;
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
public class ControleJudocaTest {

    ControleJudoca novoControleJudoca = new ControleJudoca();
    Judoca umJudoca = new Judoca("Shigure");
    Judoca outroJudoca = new Judoca("Magus");
    
    @Before
    public void SetUp() {
        this.novoControleJudoca.adicionar(umJudoca);
        this.novoControleJudoca.adicionar(outroJudoca);
    }

    @Test
    public void testGetListaJudocas() {

    ArrayList<Judoca> umaListaJudoca = this.novoControleJudoca.getListaJudocas();
    ArrayList<Judoca> outraListaJudoca = new ArrayList<Judoca>();
                    
                     outraListaJudoca.add(umJudoca);
                     outraListaJudoca.add(outroJudoca);

        assertEquals(umaListaJudoca, outraListaJudoca);
    }

    @Test
    public void testAdicionar() {

        ArrayList<Judoca> umaListaJudocas;

        umaListaJudocas = this.novoControleJudoca.getListaJudocas();

        assertEquals(umJudoca, umaListaJudocas.get(0));
        
    }

    @Test
    public void testRemover() {
        
        assertEquals(2, this.novoControleJudoca.getListaJudocas().size());
        
        this.novoControleJudoca.remover(umJudoca);
        
        assertEquals(1, this.novoControleJudoca.getListaJudocas().size());
        
        this.novoControleJudoca.remover(outroJudoca);
        
        assertEquals(0, this.novoControleJudoca.getListaJudocas().size());
    }

    @Test
    public void testPesquisar() {

        assertEquals(umJudoca, this.novoControleJudoca.pesquisar("Shigure"));
        assertEquals(outroJudoca, this.novoControleJudoca.pesquisar("Magus"));
        
    }
}