package br.com.alura.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.alura.agenda.FormularioActivity;
import br.com.alura.agenda.R;
import br.com.alura.modelo.Aluno;

/**
 * Created by contrui on 29/11/17.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.formulario_nomeAluno);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_enderecoAluno);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefoneAluno);
        campoSite = (EditText) activity.findViewById(R.id.formulario_siteAluno);
        campoNota = (RatingBar) activity.findViewById(R.id.formulario_notaAluno);
    }

    public Aluno pegaAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }
}