package com.example.berna.seccion3.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.berna.seccion3.R;

import java.util.List;

/**
 * Created by berni on 19/12/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> names;
    private int layout;
    private onItemClickListener onItemClickListener;

    public MyAdapter(List<String> names, int layout, onItemClickListener onItemClickListener){
        this.names = names;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(names.get(position),onItemClickListener);
    }
    //numero de elemntos que vamos a obtener

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        public ViewHolder(View v) {
            super(v);
            this.tv_name = (TextView) v.findViewById(R.id.tv_name);
        }

        public void bind(final String name, final onItemClickListener listener){
            this.tv_name.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name,getAdapterPosition());
                }
            });

        }
    }

    public interface onItemClickListener{
        void onItemClick(String name, int position);
    }
}
