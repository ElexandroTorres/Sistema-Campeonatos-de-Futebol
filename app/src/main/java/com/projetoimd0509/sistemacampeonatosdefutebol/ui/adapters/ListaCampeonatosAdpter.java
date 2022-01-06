package com.projetoimd0509.sistemacampeonatosdefutebol.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;

import java.util.List;

public class ListaCampeonatosAdpter extends RecyclerView.Adapter<ListaCampeonatosAdpter.LCHolder> {
    private List<Campeonato> listaCampeonatos;

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

    }

    @Override
    public int getItemCount() {
        return this.listaCampeonatos.size();
    }

    //Holder da Lista dos Campeonatos.
    public class LCHolder extends  RecyclerView.ViewHolder{
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
        }
    }
}
