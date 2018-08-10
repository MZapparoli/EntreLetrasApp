package br.com.entreletras.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import br.com.entreletras.R;


/**
 * Created by matheus on 23/08/17.
 */

public class ConteudoAdapter extends BaseAdapter {

    private List<Conteudo> conteudos;
    private Context context;
    private LayoutInflater inflater;

    public ConteudoAdapter(List<Conteudo> conteudos, Context context) {
        this.conteudos = conteudos;
        this.context = context;
        this.inflater = (LayoutInflater)LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return conteudos.size();
    }

    @Override
    public Object getItem(int position) {
        return conteudos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            Conteudo conteudo = conteudos.get(position);


            View inflated = inflater.inflate(R.layout.activity_list_item, parent, false);

            TextView title = (TextView) inflated.findViewById(R.id.txt_title);
            TextView content = (TextView) inflated.findViewById(R.id.txt_desc);
            title.setText(conteudo.getTitulo());
            content.setText(conteudo.getDescricao());
            return inflated;
        }


    }