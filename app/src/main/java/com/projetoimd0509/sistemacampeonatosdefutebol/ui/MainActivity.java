package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.dadosfalsos.ListaFalsaCampeonatos;
import com.projetoimd0509.sistemacampeonatosdefutebol.ui.adapters.ListaCampeonatosAdpter;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabCadastrarCampeonato;
    RecyclerView rvListaCampeonatos;
    ListaFalsaCampeonatos listaFalsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //apenas para testes
        listaFalsa = new ListaFalsaCampeonatos();

        fabCadastrarCampeonato = findViewById(R.id.fab_cadastrar_campeonato);
        rvListaCampeonatos = findViewById(R.id.rv_lista_campeonatos);



        ListaCampeonatosAdpter adapter = new ListaCampeonatosAdpter(listaFalsa.getLista());
        System.out.println(listaFalsa.getLista().size());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvListaCampeonatos.setLayoutManager(layoutManager);
        rvListaCampeonatos.setHasFixedSize(true);
        rvListaCampeonatos.setAdapter(adapter);


        setListeners();
    }

    void setListeners() {
        fabCadastrarCampeonato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}