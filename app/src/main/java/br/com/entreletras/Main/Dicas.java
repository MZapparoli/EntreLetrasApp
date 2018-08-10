package br.com.entreletras.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.entreletras.Adapters.JsonConsumerTodos;
import br.com.entreletras.R;
import br.com.entreletras.Adapters.Conteudo;
import br.com.entreletras.Adapters.ConteudoAdapter;

public class Dicas extends AppCompatActivity {

    private ListView listView;
    private List<Conteudo> conteudos;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_dicas);

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
        setTitle("Dicas");
        JsonConsumerTodos consumerTodos = new JsonConsumerTodos(this);

        try {
            conteudos = consumerTodos.execute("dicas.txt").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ListView lista = ((ListView) findViewById(R.id.List_contents));

        lista.setAdapter(new ConteudoAdapter(conteudos, this));

    }


}



