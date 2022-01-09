package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Partida;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Time;

public class InformacoesActivity extends AppCompatActivity {
    private LinearLayout llInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        llInfo = findViewById(R.id.llInfo);

        Campeonato campeonato = getIntent().getParcelableExtra("campeonato");
        renderTabela(campeonato);

        Button btnClassificacao = findViewById(R.id.btnClassificacao);
        btnClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renderClassificao(campeonato);
            }
        });

        Button btnTabela = findViewById(R.id.btnTabela);
        btnTabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renderTabela(campeonato);
            }
        });

    }

    public void renderTabela(Campeonato campeonato) {
        llInfo.removeAllViews();
        LinearLayout llRodada = (LinearLayout) LayoutInflater.from(InformacoesActivity.this).inflate(R.layout.rodada, null);
        llInfo.addView(llRodada);

        TableLayout table = findViewById(R.id.table);

        for (Partida partida : campeonato.getListaPartidas()) {
            TableRow row = (TableRow) LayoutInflater.from(InformacoesActivity.this).inflate(R.layout.item_rodada, null);

            Time time1 = partida.getTime1();
            TextView tvTime1 = row.findViewById(R.id.tvTime1);
            tvTime1.setText(time1.getNome());

            EditText etPlacar1 = row.findViewById(R.id.etPlacar1);
            etPlacar1.setText(String.valueOf(partida.getTime1Gols()));

            etPlacar1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    partida.setTime1Gols(Integer.parseInt(s.toString()));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            Time time2 = partida.getTime2();
            TextView tvTime2 = row.findViewById(R.id.tvTime2);
            tvTime2.setText(time2.getNome());

            EditText etPlacar2 = row.findViewById(R.id.etPlacar2);
            etPlacar2.setText(String.valueOf(partida.getTime2Gols()));
            etPlacar2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    partida.setTime2Gols(Integer.parseInt(s.toString()));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            table.addView(row);
        }
    }

    public void renderClassificao(Campeonato campeonato) {
        llInfo.removeAllViews();
        TableLayout tableClassificao = (TableLayout) LayoutInflater.from(InformacoesActivity.this).inflate(R.layout.classificacao, null);
        llInfo.addView(tableClassificao);

        TableLayout table = findViewById(R.id.table);

        for (Time time : campeonato.CalcularClassificacao()) {
            TableRow row = (TableRow) LayoutInflater.from(InformacoesActivity.this).inflate(R.layout.item_classificacao, null);

            TextView tvTime = row.findViewById(R.id.tvTime);
            tvTime.setText(time.getNome());

            TextView tvPontos = row.findViewById(R.id.tvPontos);
            tvPontos.setText(String.valueOf(time.getPontos()));

            TextView tvVitorias = row.findViewById(R.id.tvVitorias);
            tvVitorias.setText(String.valueOf(time.getVitorias()));

            TextView tvDerrotas = row.findViewById(R.id.tvDerrotas);
            tvDerrotas.setText(String.valueOf(time.getDerrotas()));

            table.addView(row);
        }


    }
}