package controleatleta;

import java.util.ArrayList;

public class Judoca extends Atleta {

    private char categoria; // A=Amador P=Profissional
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

    public ArrayList<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(ArrayList<Remedio> remedios) {
        this.remedios = remedios;
    }

    public Judoca(String nome) {
        super(nome);
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
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

    public String obterSexoPesoNome() {
        return obterSexoPesoNome(this.getSexo(), this.getPeso());
    }

    public static String obterSexoPesoNome(char sexo, double peso) {
        if (sexo == 'M') {
            return obterCategoriaPesoNomeMasc(peso);
        } else if (sexo == 'F') {
            return obterCategoriaPesoNomeFem(peso);
        } else {
            return "";
        }
    }

    private static String obterCategoriaPesoNomeMasc(double peso) {
        if (peso < 60) {
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
            return "Meio Pesado";
        } else {
            return "Pesado";
        }
    }

    private static String obterCategoriaPesoNomeFem(double peso) {
       
        if (peso <= 48) {
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
            return "Meio Pesado";
        } else {
            return "Pesado";
        }
    }
}