package com.projetoimd0509.sistemacampeonatosdefutebol.ui.adapters;

import android.content.Intent;
import android.os.Parcelable;
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
    private ItemCampeonatoListener itemListener;

    public ListaCampeonatosAdpter(List<Campeonato> listaCampeonatos, ItemCampeonatoListener itemListener) {
        this.listaCampeonatos = listaCampeonatos;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public LCHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCampeonato = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_campeonato, parent, false);
        return new LCHolder(itemCampeonato, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LCHolder holder, int position) {
        Campeonato campeonato = listaCampeonatos.get(position);
        holder.campeonato = campeonato;
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
    public class LCHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        Campeonato campeonato;
        TextView tvNomeCampeonato;
        TextView tvNumeroParticipantes;
        TextView tvLider;
        TextView tvViceLider;
        TextView tvAndamento;
        ItemCampeonatoListener itemCListener;

        public LCHolder(View itemView, ItemCampeonatoListener itemCListener) {
            super(itemView);
            tvNomeCampeonato = itemView.findViewById(R.id.tv_nome_campeonato);
            tvNumeroParticipantes = itemView.findViewById(R.id.tv_numero_participantes);
            tvLider = itemView.findViewById(R.id.tv_lider);
            tvViceLider = itemView.findViewById(R.id.tv_vice_lider);
            tvAndamento = itemView.findViewById(R.id.tv_andamento);
            this.itemCListener = itemCListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemCListener.onItemClick(getAdapterPosition());
        }
    }

    public interface ItemCampeonatoListener {
        void onItemClick(int position);
    }
}
