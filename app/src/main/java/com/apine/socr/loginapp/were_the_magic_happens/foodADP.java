package com.apine.socr.loginapp.were_the_magic_happens;

import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apine.socr.loginapp.R;

import java.util.List;

/**
 * Created by Mobark on 2/14/2018.
 */

public class foodADP extends RecyclerView.Adapter<foodADP.foodViewHolder> {
    List<fooditemholder> list;
    List<Integer> addedFood;

    @Override
    public foodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.foodmenuitem,parent,false);
        return new foodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final foodViewHolder holder, final int position) {
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.foodfap.getDrawable()==holder.foodfap.getContext().getResources().getDrawable(R.drawable.ic_playlist_add_black_24dp)) {
                    addedFood.add(list.get(position).foodid);
                    holder.foodfap.setImageDrawable(holder.foodfap.getContext().getResources().getDrawable(R.drawable.ic_playlist_add_check_black_24dp));
                }else{
                    addedFood.remove(list.get(position).foodid);
                    holder.foodfap.setImageDrawable(holder.foodfap.getContext().getResources().getDrawable(R.drawable.ic_playlist_add_black_24dp));
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class foodViewHolder extends RecyclerView.ViewHolder{
        FloatingActionButton foodfap;
        TextView foodname,foodDis;
        ImageView foodimage;
        CardView foodcard;
        public foodViewHolder(View itemView) {
            super(itemView);
            foodcard=(CardView)itemView.findViewById(R.id.fooditemCard);
            foodDis=itemView.findViewById(R.id.foodDecriptionTX);
            foodfap=itemView.findViewById(R.id.foodaddtoorderFap);
            foodimage=itemView.findViewById(R.id.fooditemIM);
            foodname=itemView.findViewById(R.id.foodNameTX);
        }
    }
}
