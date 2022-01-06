package com.projetoimd0509.sistemacampeonatosdefutebol.dadosfalsos;


import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Time;

import java.util.List;

public class ListaFalsaCampeonatos {
    public List<Campeonato> listaFalsaCampeonatos;

    public ListaFalsaCampeonatos() {
        popularLista();
    }

    public List<Campeonato> getLista() {
        return listaFalsaCampeonatos;
    }


    private void popularLista() {

        Campeonato campeonato1 = new Campeonato("Torneio de Natal", 16);
        campeonato1.setLider(new Time("Flamengo"));
        campeonato1.setViceLider(new Time("Corinthians"));
        campeonato1.setEmAndamento(true);

        Campeonato campeonato2 = new Campeonato("Torneio de verão", 16);
        campeonato2.setLider(new Time("Palmeiras"));
        campeonato2.setViceLider(new Time("Inter"));
        campeonato2.setEmAndamento(false);

        Campeonato campeonato3 = new Campeonato("Torneio de inverno", 16);
        campeonato3.setLider(new Time("Cuiaba"));
        campeonato3.setViceLider(new Time("Barcelona"));
        campeonato3.setEmAndamento(true);
    }
}
