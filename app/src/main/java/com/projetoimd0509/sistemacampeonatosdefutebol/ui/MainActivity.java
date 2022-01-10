package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.dadosfalsos.ListaFalsaCampeonatos;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.SistemaGerenciamento;
import com.projetoimd0509.sistemacampeonatosdefutebol.ui.adapters.ListaCampeonatosAdpter;

public class MainActivity extends AppCompatActivity implements ListaCampeonatosAdpter.ItemCampeonatoListener {


    private FloatingActionButton fabCadastrarCampeonato;
    private RecyclerView rvListaCampeonatos;

    private AlertDialog infosDialog;

    private ListaFalsaCampeonatos listaFalsa;

    ListaCampeonatosAdpter adapter;

    ActivityResultLauncher<Intent> cadastroResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Log.d("teste", "entrou no result");
            if(result != null && result.getResultCode() == RESULT_OK) {
                Log.d("teste", "entrou no result 2");
                if(result.getData() != null && result.getData().getExtras().getParcelable("campeonatoCadastro") != null) {
                    Campeonato novoCampeonato = result.getData().getExtras().getParcelable("campeonatoCadastro");
                    SistemaGerenciamento.listaCampeonatos.add(novoCampeonato);
                    int index = SistemaGerenciamento.listaCampeonatos.size() - 1;
                    adapter.notifyItemInserted(index);
                    Log.d("teste", "tamanho lista depois: " + SistemaGerenciamento.listaCampeonatos.size());
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listaFalsa = new ListaFalsaCampeonatos();

        SistemaGerenciamento.listaCampeonatos = listaFalsa.getLista();

        //sistemaGerenciamento.definirLista(listaFalsa.getLista());

        fabCadastrarCampeonato = findViewById(R.id.fab_cadastrar_campeonato);
        rvListaCampeonatos = findViewById(R.id.rv_lista_campeonatos);


        //ListaCampeonatosAdpter adapter = new ListaCampeonatosAdpter(listaFalsa.getLista(), this);
        adapter = new ListaCampeonatosAdpter(SistemaGerenciamento.listaCampeonatos, this);
        //System.out.println(listaFalsa.getLista().size());

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
                Log.d("teste", "tamanho lista antes: " + SistemaGerenciamento.listaCampeonatos.size());
                //Intent cadastroIntent = new Intent(MainActivity.this, CadastroActivity.class);
                //startActivity(cadastroIntent);
                Intent cadastroIntent = new Intent(MainActivity.this, CadastroActivity.class);
                cadastroResult.launch(cadastroIntent);
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
        Intent informacoesIntent = new Intent(MainActivity.this, InformacoesActivity.class);
        informacoesIntent.putExtra("campeonato", (Parcelable) SistemaGerenciamento.listaCampeonatos.get(position));
        startActivity(informacoesIntent);
    }
}