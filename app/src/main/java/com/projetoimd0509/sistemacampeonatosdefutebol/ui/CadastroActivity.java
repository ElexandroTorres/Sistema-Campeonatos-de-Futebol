package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.fragmento.CampeonatoDialogFragment;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity
        implements CampeonatoDialogFragment.AoSalvarCampeonato {

    List<Campeonato> campeonatos;
    CampeonatoDialogFragment campeonatoDialogFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campeonatos = new ArrayList<Campeonato>();
        campeonatoDialogFragment = CampeonatoDialogFragment.novaInstancia();

    }

    @Override
    public void salvouCampeonato(Campeonato campeonato) {
        adicionar(campeonato);
    }

    private void adicionar(Campeonato campeonato) {
        campeonatos.add(campeonato);
    }
}