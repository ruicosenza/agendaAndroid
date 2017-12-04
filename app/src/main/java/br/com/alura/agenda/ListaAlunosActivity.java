package br.com.alura.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alura.dao.AlunoDAO;
import br.com.alura.modelo.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        Button novoAluno = findViewById(R.id.lista_botaoSalvar);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaiProFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class );
                startActivity(vaiProFormulario);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    /**
     * Método utilizado para carregar a lista inicial de alunos
     */
    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        ArrayList<Aluno> alunos = dao.carregaAlunos();

        ListView listaAlunos = findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);
    }
}