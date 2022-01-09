package com.projetoimd0509.sistemacampeonatosdefutebol.fragmento;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.projetoimd0509.sistemacampeonatosdefutebol.R;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Campeonato;
import com.projetoimd0509.sistemacampeonatosdefutebol.model.Time;

public class CampeonatoDialogFragment extends DialogFragment {

    public static final String DIALOG_TAG = "addDialog";

    private EditText etNome;
    private EditText etNumeroParticipantes;
    private EditText etTime1;
    private EditText etTime2;
    private EditText etTime3;
    private EditText etTime4;

    private Button btnCadastrar;

    //variável que representa o time que será adicionado

    Campeonato meuCampeonato;

    public CampeonatoDialogFragment() {
        // Required empty public constructor
    }

    public static CampeonatoDialogFragment novaInstancia(){
        //1. instancia do fragmento que vai ser iniciado
        CampeonatoDialogFragment campeonatoDialogFragment = new CampeonatoDialogFragment();

        return campeonatoDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        meuCampeonato = new Campeonato();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.activity_cadastro, container, false);

        etNome = layout.findViewById(R.id.etNome);
        etNumeroParticipantes = layout.findViewById(R.id.etNumeroParticipantes);
        etTime1 = layout.findViewById(R.id.etTime1);
        etTime2 = layout.findViewById(R.id.etTime2);
        etTime3 = layout.findViewById(R.id.etTime3);
        etTime4 = layout.findViewById(R.id.etTime4);

        btnCadastrar = layout.findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                salvarCampeonato();
            }
        });

        getDialog().setTitle("Novo Campeonato");

        return layout;
    }

    public void salvarCampeonato(){

        //1. Atividade onde o fragmento está rodando
        Activity activity = getActivity();

        //2. A Atividade Implementa a interface?
        if(activity instanceof AoSalvarCampeonato){

            meuCampeonato.setNome(etNome.getText().toString());
            meuCampeonato.setNumeroParticipantes(
                    Integer.parseInt(etNumeroParticipantes.getText().toString()));
//            meuCampeonato.setLider(etTime1.getText().toString());
//            meuCampeonato.setLider(etTime2.getText().toString());

        }

        AoSalvarCampeonato listener = (AoSalvarCampeonato) activity;
        listener.salvouCampeonato(meuCampeonato);

        //fecha o dialog
        dismiss();

    }

    public interface AoSalvarCampeonato{
        void salvouCampeonato(Campeonato campeonato);

    }

}