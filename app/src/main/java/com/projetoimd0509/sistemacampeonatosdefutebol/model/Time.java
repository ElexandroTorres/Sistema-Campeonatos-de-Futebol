package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Time implements Parcelable, Comparable<Time> {
    private final String nome;
    private Integer pontos;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;
    private Integer gols;
    private Integer golsContra;
    private Integer saldoDeGols;

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

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    private void addGols(int gols, int golsContra) {
        this.gols += gols;
        this.golsContra += golsContra;
        this.saldoDeGols += gols - golsContra;
    }

    public void addVitoria(int gols, int golsContra) {
        this.vitorias++;
        this.pontos += 3;
        addGols(gols, golsContra);
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public void addDerrota(int gols, int golsContra) {
        this.derrotas++;
        addGols(gols, golsContra);
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public void addEmpate(int gols, int golsContra) {
        this.empates++;
        this.pontos++;
        addGols(gols, golsContra);
    }

    public Integer getGols() {
        return gols;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public Integer getSaldoDeGols() {
        return saldoDeGols;
    }

    public void setSaldoDeGols(Integer saldoDeGols) {
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

    @Override
    public int compareTo(Time t) {
        if (t.getPontos() == pontos) {
            return t.getSaldoDeGols().compareTo(saldoDeGols);
        }

        return t.getPontos().compareTo(pontos);
    }
}