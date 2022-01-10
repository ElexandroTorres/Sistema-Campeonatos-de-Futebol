package com.projetoimd0509.sistemacampeonatosdefutebol.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Partida implements Parcelable {
    private Time time1;
    private Time time2;
    private int time1Gols;
    private int time2Gols;

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
        this.time1Gols = 0;
        this.time2Gols = 0;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public int getTime1Gols() {
        return time1Gols;
    }

    public void setTime1Gols(int time1Gols) {
        this.time1Gols = time1Gols;
    }

    public int getTime2Gols() {
        return time2Gols;
    }

    public void setTime2Gols(int time2Gols) {
        this.time2Gols = time2Gols;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(time1, 0);
        dest.writeParcelable(time2, 0);
        dest.writeInt(time1Gols);
        dest.writeInt(time2Gols);
    }

    public static final Parcelable.Creator<Partida> CREATOR = new Parcelable.Creator<Partida>() {
        public Partida createFromParcel(Parcel in) {
            return new Partida(in);
        }

        public Partida[] newArray(int size) {
            return new Partida[size];
        }
    };

    private Partida(Parcel in) {
        time1 = in.readParcelable(Time.class.getClassLoader());
        time2 = in.readParcelable(Time.class.getClassLoader());
        time1Gols = in.readInt();
        time2Gols = in.readInt();
    }
}
