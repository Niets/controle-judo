package controleatleta;

public class Premiacao {

    private String titulo;
    private int ano;
    private String faixa;
    private String medalha;

    public Premiacao(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }
    
    public String getMedalha() {
        return medalha;
    }

    public void setMedalha(String medalha) {
        this.medalha = medalha;
    }
    
    @Override
    public String toString() {
        return this.ano + " - " + this.titulo + " (" + this.faixa + ")" + " - " + this.medalha;
    }
}
