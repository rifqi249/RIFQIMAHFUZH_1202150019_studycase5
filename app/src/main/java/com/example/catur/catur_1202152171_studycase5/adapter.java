package com.example.catur.catur_1202152171_studycase5;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.holder>{
    //membuat variabel
    private Context context;
    private List<itemTodo> item;
    int id;

    //constructor nya
    public adapter(Context context, List<itemTodo> item, int id) {
        this.context = context;
        this.item = item;
        this.id = id;
    }

    //untuk menentukan view recycler nya
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview, parent, false);
        holder holder = new holder(view);
        return holder;
    }

    //untuk menentukan nilai objeknya sesuai dengan recycler
    @Override
    public void onBindViewHolder(holder holder, int position) {
        itemTodo itemm = item.get(position);
        holder.td.setText(itemm.getTodo());
        holder.ds.setText(itemm.getDesc());
        holder.pr.setText(itemm.getPrior());
        holder.card.setCardBackgroundColor(context.getResources().getColor(this.id));
    }
    public itemTodo getItem(int position){
        return item.get(position);
    }
    public void removeitem(int i){
        item.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, item.size());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView td, ds, pr;
        CardView card;
        public holder(View itemView) {
            super(itemView);
            td = itemView.findViewById(R.id.todorv);
            ds = itemView.findViewById(R.id.descrv);
            pr = itemView.findViewById(R.id.priorv);
            card = itemView.findViewById(R.id.cd);
        }
    }
}
