package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Campeonato implements Parcelable {
    private String nome;
    private int numeroParticipantes = 4;
    private int emAndamento;
    private Time lider;
    private Time viceLider;
    private List<Time> listaParticipantes = new ArrayList<Time>();
    private List<Partida> listaPartidas = new ArrayList<Partida>();

    public Campeonato(String nome) {
        this.nome = nome;
    }

    public Campeonato(){

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
        if(emAndamento == 1) {
            return true;
        }
        return false;
    }

    public void setEmAndamento(boolean emAndamento) {
        if(emAndamento == true) {
            this.emAndamento = 1;
        }
        this.emAndamento = 0;
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


    private void gerarPartidas() {
        for (int i = 0; i < listaParticipantes.size(); i += 2) {
            Partida partida = new Partida(listaParticipantes.get(i), listaParticipantes.get(i + 1));
            listaPartidas.add(partida);
        }
    }

    public List<Partida> getListaPartidas() {
        if (listaPartidas.size() == 0) {
            gerarPartidas();
        }
        return listaPartidas;
    }

    public List<Time> CalcularClassificacao() {
        for (Partida partida : listaPartidas) {
            if (partida.getTime1Gols() == partida.getTime2Gols()) {
                partida.getTime1().addEmpate(partida.getTime1Gols(), partida.getTime2Gols());
                partida.getTime2().addEmpate(partida.getTime1Gols(), partida.getTime2Gols());
            } else if (partida.getTime1Gols() > partida.getTime2Gols()) {
                partida.getTime1().addVitoria(partida.getTime1Gols(), partida.getTime2Gols());
                partida.getTime2().addDerrota(partida.getTime1Gols(), partida.getTime2Gols());
            } else {
                partida.getTime1().addDerrota(partida.getTime1Gols(), partida.getTime2Gols());
                partida.getTime2().addVitoria(partida.getTime1Gols(), partida.getTime2Gols());
            }
        }

        Collections.sort(listaParticipantes);

        return listaParticipantes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(numeroParticipantes);
        dest.writeInt(emAndamento);
        dest.writeParcelable(lider, 0);
        dest.writeParcelable(viceLider, 0);
        dest.writeList(listaParticipantes);
        dest.writeList(listaPartidas);

    }

    public static final Parcelable.Creator<Campeonato> CREATOR = new Parcelable.Creator<Campeonato>() {
        public Campeonato createFromParcel(Parcel in) {
            return new Campeonato(in);
        }

        public Campeonato[] newArray(int size) {
            return new Campeonato[size];
        }
    };

    private Campeonato(Parcel in) {
        nome = in.readString();
        numeroParticipantes = in.readInt();
        emAndamento = in.readInt();
        lider = in.readParcelable(Time.class.getClassLoader());
        viceLider = in.readParcelable(Time.class.getClassLoader());
        listaParticipantes = in.readArrayList(Time.class.getClassLoader());
        listaPartidas = in.readArrayList(Partida.class.getClassLoader());
    }
}
