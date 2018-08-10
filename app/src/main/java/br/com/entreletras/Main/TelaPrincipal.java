package br.com.entreletras.Main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

import br.com.entreletras.Adapters.Conteudo;
import br.com.entreletras.Adapters.JsonConsumerTodos;
import br.com.entreletras.R;

public class TelaPrincipal extends AppCompatActivity {

    LinkedList<Conteudo> ls = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        setTitle("Entre Letras");


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d("myapp", "Dentro da verificação");

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {
                Log.d("myapp", "Dentro da verificação 2");
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.
                Log.d("myapp", "Dentro da verificação 3");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        12);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    public void bt1(View view) { // Análise do Tema
        Intent intent = new Intent(this, AnaliseTema.class);
        startActivity(intent);
    }

    public void bt2(View view) { // Estrutura Textual
        Intent intent = new Intent(this, PlanoRedacao.class);
        startActivity(intent);
    }

    public void bt3(View view) { // Plano de Redação
        Intent intent = new Intent(this, EstruturaTextual.class);
        startActivity(intent);
    }

    public void bt4(View view) { // Arquitetura do Parágrafo
        Intent intent = new Intent(this, ArqParagrafo.class);
        startActivity(intent);
    }

    public void bt5(View view) { // Recursos Argumentativos
        Intent intent = new Intent(this, RecArgumentativos.class);
        startActivity(intent);
    }

    public void bt6(View view) { // Arquitetura do texto
        Intent intent = new Intent(this, ArqTexto.class);
        startActivity(intent);
    }

    public void bt7(View view) { // Erros Comuns
        Intent intent = new Intent(this, ErrosComuns.class);
        startActivity(intent);
    }

    public void bt8(View view) { // Dicas
        Intent intent = new Intent(this, Dicas.class);
        startActivity(intent);
    }

    public void bt9(View view) { // Galeria
        Intent intent = new Intent(this, Galeria.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
