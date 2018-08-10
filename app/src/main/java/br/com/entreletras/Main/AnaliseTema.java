package br.com.entreletras.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

import br.com.entreletras.Adapters.ConteudoAdapter;
import br.com.entreletras.Adapters.JsonConsumerTodos;
import br.com.entreletras.R;
import br.com.entreletras.Adapters.Conteudo;


public class AnaliseTema extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise_tema);

        ListView lv = (ListView) findViewById(R.id.List_contents);
        lv.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


       // getSupportActionBar().setDisplayShowHomeEnabled(true);

      //  getSupportActionBar().setIcon(R.drawable.ic_analise2);

        LinkedList<Conteudo> conteudos = null;
        setTitle("Análise do Tema");
        JsonConsumerTodos consumerTodos = new JsonConsumerTodos(this);

        try {
            conteudos = consumerTodos.execute("analisetema.txt").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ListView lista = ((ListView) findViewById(R.id.List_contents));

        lista.setAdapter(new ConteudoAdapter(conteudos, this));

    }




}