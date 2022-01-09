package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Time implements Parcelable {
    private final String nome;
    private int pontos;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int gols;
    private int golsContra;
    private int saldoDeGols;

    public Time(String nome) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(pontos);
        dest.writeInt(vitorias);
        dest.writeInt(derrotas);
        dest.writeInt(empates);
        dest.writeInt(gols);
        dest.writeInt(golsContra);
        dest.writeInt(saldoDeGols);
    }

    public static final Parcelable.Creator<Time> CREATOR = new Parcelable.Creator<Time>() {
        public Time createFromParcel(Parcel in) {
            return new Time(in);
        }

        public Time[] newArray(int size) {
            return new Time[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Time(Parcel in) {
        nome = in.readString();
        pontos = in.readInt();
        vitorias = in.readInt();
        derrotas = in.readInt();
        empates = in.readInt();
        gols = in.readInt();
        golsContra = in.readInt();
        saldoDeGols = in.readInt();
    }
}