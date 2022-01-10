package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.SistemaGerenciamento;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Time;


public class CadastroActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etTime1;
    private EditText etTime2;
    private EditText etTime3;
    private EditText etTime4;
    private Button btnCadastrar;
    private Button btnCancelar;

    Campeonato novoCampeonato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        novoCampeonato = new Campeonato();

        etNome = findViewById(R.id.etNome);
        etTime1 = findViewById(R.id.etTime1);
        etTime2 = findViewById(R.id.etTime2);
        etTime3 = findViewById(R.id.etTime3);
        etTime4 = findViewById(R.id.etTime4);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoCampeonato.setNome(etNome.getText().toString());
                adicionarTimes();
                Intent intent = new Intent();
                intent.putExtra("campeonatoCadastro", novoCampeonato);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void adicionarTimes() {
        novoCampeonato.adicionarParticipante(new Time(etTime1.getText().toString()));
        novoCampeonato.adicionarParticipante(new Time(etTime2.getText().toString()));
        novoCampeonato.adicionarParticipante(new Time(etTime3.getText().toString()));
        novoCampeonato.adicionarParticipante(new Time(etTime4.getText().toString()));
        novoCampeonato.setLider(novoCampeonato.getListaParticipantes().get(0));
        novoCampeonato.setViceLider(novoCampeonato.getListaParticipantes().get(1));
        novoCampeonato.setEmAndamento(true);
    }
}