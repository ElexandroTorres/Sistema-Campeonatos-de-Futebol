package com.projetoimd0509.sistemacampeonatosdefutebol.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Partida;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Time;

public class InformacoesActivity extends AppCompatActivity {

    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        Campeonato campeonato = getIntent().getParcelableExtra("campeonato");
        table = findViewById(R.id.table);

        for (Partida partida : campeonato.getListaPartidas()) {
            TableRow row = (TableRow) LayoutInflater.from(InformacoesActivity.this).inflate(R.layout.item_rodada, null);

            Time time1 = partida.getTime1();
            TextView tvTime1 = row.findViewById(R.id.tvTime1);
            tvTime1.setText(time1.getNome());

            EditText etPlacar1 = row.findViewById(R.id.etPlacar1);
            etPlacar1.setText(String.valueOf(partida.getTime1Gols()));
//            etPlacar1.addTextChangedListener(new TextWatcher() {
//                Integer placarAntigo = 0;
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                    if (s != null) {
//                        placarAntigo = Integer.parseInt(s.toString());
//                    }
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                }
//            });

            Time time2 = partida.getTime2();
            TextView tvTime2 = row.findViewById(R.id.tvTime2);
            tvTime2.setText(time2.getNome());

            EditText etPlacar2 = row.findViewById(R.id.etPlacar2);
            etPlacar2.setText(String.valueOf(partida.getTime2Gols()));

            table.addView(row);
        }
    }
}