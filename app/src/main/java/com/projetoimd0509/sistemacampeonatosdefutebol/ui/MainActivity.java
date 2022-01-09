package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.dadosfalsos.ListaFalsaCampeonatos;
import com.projetoimd0509.sistemacampeonatosdefutebol.ui.adapters.ListaCampeonatosAdpter;

public class MainActivity extends AppCompatActivity implements ListaCampeonatosAdpter.ItemCampeonatoListener {

    private FloatingActionButton fabCadastrarCampeonato;
    private RecyclerView rvListaCampeonatos;
    private ListaFalsaCampeonatos listaFalsa;

    private AlertDialog infosDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //apenas para testes
        listaFalsa = new ListaFalsaCampeonatos();

        fabCadastrarCampeonato = findViewById(R.id.fab_cadastrar_campeonato);
        rvListaCampeonatos = findViewById(R.id.rv_lista_campeonatos);


        ListaCampeonatosAdpter adapter = new ListaCampeonatosAdpter(listaFalsa.getLista(), this);
        System.out.println(listaFalsa.getLista().size());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvListaCampeonatos.setLayoutManager(layoutManager);
        rvListaCampeonatos.setHasFixedSize(true);
        rvListaCampeonatos.setAdapter(adapter);


        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tela_principal_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_infos:
                criarDialog();
                break;
        }
        return true;
    }

    private void setListeners() {
        fabCadastrarCampeonato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

    private void criarDialog() {
        infosDialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Integrantes")
                .setMessage("Elexandro Torres Tavares\nFranklin Luiz da Cruz\nVinicius Santos Silva de Lima")
                .setPositiveButton("Ver Site", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/ElexandroTorres/Sistema-Campeonatos-de-Futebol"));
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        infosDialog.dismiss();
                    }
                })
                .create();

        infosDialog.show();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, InformacoesActivity.class);
        startActivity(intent);
    }
}