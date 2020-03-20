package com.lugo.manueln.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class adapterRecyclerPost extends RecyclerView.Adapter<adapterRecyclerPost.MyViewHolder> {

    List<Post> listaPost;
    Context context;
    public adapterRecyclerPost(Context context, List<Post> list){
        this.context=context;
        listaPost=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View vista=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post,viewGroup,false);

        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.textViewId.setText(String.valueOf(listaPost.get(i).getId()));
        myViewHolder.textViewTitle.setText(listaPost.get(i).getTitle());
        myViewHolder.textViewBody.setText(listaPost.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        return listaPost.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle,textViewBody,textViewId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewId=itemView.findViewById(R.id.txtId);
            textViewTitle=itemView.findViewById(R.id.txtTitle);
            textViewBody=itemView.findViewById(R.id.txtBody);


        }
    }
}
