package com.projetoimd0509.sistemacampeonatosdefutebol.model;

public class Time {
    private final String nome;
    private int pontos;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int gols;
    private int golsContra;
    private int saldoDeGols;

    Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.gols = 0;
        this.golsContra = 0;
        this.saldoDeGols = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }
}