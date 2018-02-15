package com.apine.socr.loginapp.were_the_magic_happens;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apine.socr.loginapp.R;
import com.apine.socr.loginapp.appSettings;

import java.util.List;

/**
 * Created by Mobark on 2/14/2018.
 */

public class menuADP extends RecyclerView.Adapter<menuADP.viewholders> {
    private List<menuitemholder> list;
    CardView lastcard=null;
    public menuADP(List<menuitemholder> list) {
        this.list = list;
    }

    @Override
    public viewholders onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardmainitem,parent,false);
        return new viewholders(v);
    }

    @Override
    public void onBindViewHolder(final viewholders holder, int position) {
        holder.imageView.setImageDrawable(holder.imageView.getResources().getDrawable(list.get(position).image));
        holder.tx.setText(list.get(position).name);
        Log.e("holderLOG>>>",holder.getLayoutPosition()+holder.getAdapterPosition()+"/"+position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewholders extends RecyclerView.ViewHolder{
        TextView tx;
        ImageView imageView;
        CardView cardView;
        public viewholders(View itemView) {
            super(itemView);
            tx=(TextView)itemView.findViewById(R.id.menuTX);
            imageView=(ImageView)itemView.findViewById(R.id.menuIM);
            cardView=(CardView)itemView.findViewById(R.id.menucard);
        }
    }
}
