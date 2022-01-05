package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import java.util.List;

public class Campeonato {
    private String nome;
    private int numeroParticipantes;
    private boolean emAndamento;
    private Time lider;
    private Time viceLider;
    private List<Time> listaParticipantes;

    public Campeonato(String nome, int numeroParticipantes) {
        this.nome = nome;
        this.numeroParticipantes = numeroParticipantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void setEmAndamento(boolean emAndamento) {
        this.emAndamento = emAndamento;
    }

    public Time getLider() {
        return lider;
    }

    public void setLider(Time lider) {
        this.lider = lider;
    }

    public Time getViceLider() {
        return viceLider;
    }

    public void setViceLider(Time viceLider) {
        this.viceLider = viceLider;
    }

    public List<Time> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Time> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public void adicionarParticipante(Time time) {
        this.listaParticipantes.add(time);
    }
}
