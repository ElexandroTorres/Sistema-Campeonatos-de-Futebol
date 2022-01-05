package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import java.util.List;

public class SistemaGerenciamento {
    private List<Campeonato> listaCampeonatos;

    public void adicionarCamponato(Campeonato campeonato) {
        listaCampeonatos.add(campeonato);
    }

    public void removerCampeonato(Campeonato campeonato) {
        listaCampeonatos.remove(campeonato);
    }
}
