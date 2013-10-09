package controleatleta;

import java.util.ArrayList;

public class Judoca extends Atleta {
    
    private String faixa; // de 0 (branca) até 8 (preta)
    private ArrayList<Premiacao> premiacoes;
    private Double envergadura; // Em cm
    private int totalLutas;
    private int totalVitorias;
    private int totalVitoriasIppon;
    private int totalEstrangulamento;
    private int totalDerrotas;
    private String deficiencia;
    private ArrayList <Remedio> remedios;
    private String tecnicaFavorita;

    public String getTecnicaFavorita() {
        return tecnicaFavorita;
    }

    public void setTecnicaFavorita(String tecnicaFavorita) {
        this.tecnicaFavorita = tecnicaFavorita;
    }

    public ArrayList<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(ArrayList<Remedio> remedios) {
        this.remedios = remedios;
    }

    public Judoca(String nome) {
        super(nome);
    }
    
    public int getTotalDerrotas() {
        return totalDerrotas;
    }

    public void setTotalDerrotas(int derrotas) {
        this.totalDerrotas = derrotas;
    }

    public int getTotalEstrangulamento() {
        return totalEstrangulamento;
    }

    public void setTotalEstrangulamento(int estrangulamento) {
        this.totalEstrangulamento = estrangulamento;
    }

    public Double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(Double envergadura) {
        this.envergadura = envergadura;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public int getTotalLutas() {
        return totalLutas;
    }

    public void setTotalLutas(int numLutas) {
        this.totalLutas = numLutas;
    }
    
    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }

    public int getTotalVitorias() {
        return totalVitorias;
    }

    public void setTotalVitorias(int vitorias) {
        this.totalVitorias = vitorias;
    }

    public int getTotalVitoriasIppon() {
        return totalVitoriasIppon;
    }

    public void setTotalVitoriasIppon(int vitoriasIppon) {
        this.totalVitoriasIppon = vitoriasIppon;
    }
    
    public String obterCategoria() {
        return obterCategoria(this.getIdade());
    }
    
    public static String obterCategoria(int idade){
        if (idade <= 14){
           return "Pré-Juvenil";
        }
        
        else if (idade <= 16){
            return "Juvenil";
        }
        
        else if (idade <= 19){
            return "Júnior";
        }
        
        else {
            return "Sênior";
        }
        
    }

    public String obterSexoPesoNomeCategoria() {
        return obterSexoCategoria(this.getSexo(), this.getPeso(), this.getCategoria());
    }

    public static String obterSexoCategoria(char sexo, double peso, int categoria) {
        if (sexo == 'M') {
            return obterCategoriaMasc(peso, categoria);
        } else if (sexo == 'F') {
            return obterCategoriaFem(peso, categoria);
        } else {
            return "";
        }
    }

    private static String obterCategoriaMasc(double peso, int categoria) {
       
        if (categoria == 0){
            return obterCategoriaM0(peso);
        } else if (categoria == 1){
            return obterCategoriaM1(peso);
        } else if (categoria == 2){
            return obterCategoriaM2(peso);
        } else{
            return obterCategoriaM2(peso);
        }
        
        //Categoria Sênior e Júnior são as mesmas em termo "pesagem".
    }
    
    private static String obterCategoriaM0(double peso){
        if (peso <= 36) {
            return "Sub-Ligeiro";
        } else if (peso <= 40) {
            return "Ligeiro";
        } else if (peso <= 44) {
            return "Meio-Leve";
        } else if (peso <= 48) {
            return "Leve";
        } else if (peso <= 53) {
            return "Meio-Médio";
        } else if (peso <= 58) {
            return "Médio";
        } else if (peso <= 64) {
            return "Meio-Pesado";
        } else {
            return "Pesado";
        }
    }
    
    private static String obterCategoriaM1(double peso){
        if (peso <= 50) {
            return "Sub-Ligeiro";
        } else if (peso <= 55) {
            return "Ligeiro";
        } else if (peso <= 60) {
            return "Meio-Leve";
        } else if (peso <= 66) {
            return "Leve";
        } else if (peso <= 73) {
            return "Meio-Médio";
        } else if (peso <= 81) {
            return "Médio";
        } else if (peso <= 90) {
            return "Meio-Pesado";
        } else {
            return "Pesado";
        }
    }
    
    private static String obterCategoriaM2(double peso){
        if (peso <= 55) {
            return "Sub-Ligeiro";
        } else if (peso <= 60) {
            return "Ligeiro";
        } else if (peso <= 66) {
            return "Meio-Leve";
        } else if (peso <= 73) {
            return "Leve";
        } else if (peso <= 81) {
            return "Meio-Médio";
        } else if (peso <= 90) {
            return "Médio";
        } else if (peso <= 100) {
            return "Meio-Pesado";
        } else {
            return "Pesado";
        }
    }

    private static String obterCategoriaFem(double peso, int categoria) {
       
        if (categoria == 0){
            return obterCategoriaM0(peso);
        } else if (categoria == 1){
            return obterCategoriaF1(peso);
        } else if (categoria == 2){
            return obterCategoriaF2(peso);
        } else{
            return obterCategoriaF2(peso);
        }
        
    }
    
    private static String obterCategoriaF1(double peso){
        if (peso <= 40) {
            return "Sub-Ligeiro";
        } else if (peso <= 44) {
            return "Ligeiro";
        } else if (peso <= 48) {
            return "Meio-Leve";
        } else if (peso <= 52) {
            return "Leve";
        } else if (peso <= 57) {
            return "Meio-Médio";
        } else if (peso <= 64) {
            return "Médio";
        } else if (peso <= 70) {
            return "Meio-Pesado";
        } else {
            return "Pesado";
        }
    }
    
    private static String obterCategoriaF2(double peso){
        if (peso <= 44) {
            return "Sub-Ligeiro";
        } else if (peso <= 48) {
            return "Ligeiro";
        } else if (peso <= 52) {
            return "Meio-Leve";
        } else if (peso <= 57) {
            return "Leve";
        } else if (peso <= 63) {
            return "Meio-Médio";
        } else if (peso <= 70) {
            return "Médio";
        } else if (peso <= 78) {
            return "Meio-Pesado";
        } else {
            return "Pesado";
        }
    }
}