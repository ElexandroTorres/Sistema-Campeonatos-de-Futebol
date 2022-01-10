package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaGerenciamento {
    public static List<Campeonato> listaCampeonatos = new ArrayList<Campeonato>();

    public void adicionarCampeonato(Campeonato campeonato) {
        listaCampeonatos.add(campeonato);
    }

    public void removerCampeonato(Campeonato campeonato) {
        listaCampeonatos.remove(campeonato);
    }

    public void definirLista(List<Campeonato> lista) {
        listaCampeonatos = lista;
    }
}
