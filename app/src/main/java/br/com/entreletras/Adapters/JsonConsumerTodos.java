package br.com.entreletras.Adapters;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

import static android.R.id.input;


public class JsonConsumerTodos extends AsyncTask<String, Void, LinkedList<Conteudo>> {

    private ProgressDialog dialog;
    private Context context;
    private TextView textView;

    public JsonConsumerTodos(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog = ProgressDialog.show(context, "Aguarde", "Baixando JSON, por favor Aguarde");
    }

    @Override
    protected void onPostExecute(LinkedList<Conteudo> conteudoEncontrado) {
        super.onPostExecute(conteudoEncontrado);
        dialog.dismiss();

        if (conteudoEncontrado == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    context).setTitle("Atenção")
                    .setMessage("Não foi possivel acessar essas informações...")
                    .setPositiveButton("Ok", null);
            builder.create().show();
        }
    }

    /**
     * Converte o json em objetos java
     *
     * @param jsonString
     * @return
     */
    private LinkedList<Conteudo> getConteudos(String jsonString) {
        LinkedList<Conteudo> conteudos = new LinkedList<>();
        try {
            // JSON Array
            JSONObject objetoRaiz = new JSONObject(jsonString);
            JSONArray conteudosArray = objetoRaiz.getJSONArray("conteudos");
            int comprimento = conteudosArray.length();
            for (int i = 0; i < comprimento; i++) {
                JSONObject conteudoJson = conteudosArray.getJSONObject(i);
                Conteudo conteudo = new Conteudo();
                conteudo.setTitulo(conteudoJson.getString("titulo"));
                conteudo.setDescricao(conteudoJson.getString("descricao"));
                conteudos.add(conteudo);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("my_appmodel", e.getMessage());
        }
        return conteudos;
    }

    @Override
    protected LinkedList<Conteudo> doInBackground(String... params) {
        String urlString = "http://" + MeuIP.IP + "/" + params[0];

        try {
            URL url = new URL(urlString);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(http.getInputStream(), "LATIN1"));

            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = inputReader.readLine()) != null) {
                builder.append(line);
            }

            String json = builder.toString();
            http.disconnect();

            // faz algoritmo de filtrar por nome da conteudo
            LinkedList<Conteudo> conteudos = getConteudos(json);

            // checar se é null
            return conteudos;
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e("my_appmodel", ex.getMessage());
        }
        return null;

    }

}