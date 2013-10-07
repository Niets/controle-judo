/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

/**
 *
 * @author niets
 */
public class Remedio {

    private String nome;
    private int dosagem;
    private String tipo;
    
    public Remedio(String nome) {
    this.nome = nome;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }
   
    @Override
    public String toString() {
        return this.nome + " - "  + this.dosagem  + " (" + this.tipo + ")";
    }
       
}
