package com.projetoimd0509.sistemacampeonatosdefutebol.ui.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.ui.InformacoesActivity;

import java.util.List;

public class ListaCampeonatosAdpter extends RecyclerView.Adapter<ListaCampeonatosAdpter.LCHolder> {
    private final List<Campeonato> listaCampeonatos;

    public ListaCampeonatosAdpter(List<Campeonato> listaCampeonatos) {
        this.listaCampeonatos = listaCampeonatos;
    }

    @NonNull
    @Override
    public LCHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCampeonato = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_campeonato, parent, false);
        return new LCHolder(itemCampeonato);
    }

    @Override
    public void onBindViewHolder(@NonNull LCHolder holder, int position) {
        Campeonato campeonato = listaCampeonatos.get(position);
        holder.tvNomeCampeonato.setText(campeonato.getNome());
        holder.tvNumeroParticipantes.setText("Numero participantes: " + String.valueOf(campeonato.getNumeroParticipantes()));
        holder.tvLider.setText("Lider: " + campeonato.getLider().getNome());
        holder.tvViceLider.setText("Vice-lider: " + campeonato.getViceLider().getNome());
        if (campeonato.isEmAndamento()) {
            holder.tvAndamento.setText("Em andamento");
        } else {
            holder.tvAndamento.setText("Finalizado");
        }
    }

    @Override
    public int getItemCount() {
        return listaCampeonatos.size();
    }

    //Holder da Lista dos Campeonatos.
    public class LCHolder extends RecyclerView.ViewHolder {
        TextView tvNomeCampeonato;
        TextView tvNumeroParticipantes;
        TextView tvLider;
        TextView tvViceLider;
        TextView tvAndamento;

        public LCHolder(View itemView) {
            super(itemView);
            tvNomeCampeonato = itemView.findViewById(R.id.tv_nome_campeonato);
            tvNumeroParticipantes = itemView.findViewById(R.id.tv_numero_participantes);
            tvLider = itemView.findViewById(R.id.tv_lider);
            tvViceLider = itemView.findViewById(R.id.tv_vice_lider);
            tvAndamento = itemView.findViewById(R.id.tv_andamento);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent resultadoActivity = new Intent(itemView.getContext(), InformacoesActivity.class);
                    itemView.getContext().startActivity(resultadoActivity);
                }
            });
        }
    }
}
