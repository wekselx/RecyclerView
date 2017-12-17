package com.veksel.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by masa on 12/17/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Worker> workerList=new ArrayList<>();
    Context ctx;
    public MyAdapter(List<Worker> workers, Context ctx){
        workerList=workers;
        this.ctx=ctx;

    }
    public void dataSetChange(List<Worker> workerList){
        this.workerList=workerList;
        notifyDataSetChanged();
    }
    public void remove(int position){
        workerList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType==1)
            v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_grid_small,parent,false) ;

        else
        v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_grid,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(workerList.get(position).getName());
        holder.age.setText("Age:"+workerList.get(position).getAge());
        holder.position.setText("Age:"+workerList.get(position).getPosition());
        Glide.with(ctx).load(workerList.get(position).getPhoto())
    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
    .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return workerList.size();
    }
    @Override
    public int getItemViewType(int position){
        if(position%2==0)
            return 1;
        else
            return 2;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView age;
        TextView position;
        CircleImageView photo;

        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
           age=(TextView) itemView.findViewById(R.id.age);
            position=(TextView) itemView.findViewById(R.id.position);
            photo=(CircleImageView) itemView.findViewById(R.id.photo);


        }
    }
}
