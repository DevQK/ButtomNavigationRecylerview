package khanh.buttomnavigationrecylerview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import khanh.buttomnavigationrecylerview.Model.Moves;
import khanh.buttomnavigationrecylerview.R;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    private Context ct;
    private List<Moves> dt;

    public StoreAdapter(Context ct, List<Moves> dt) {
        this.ct = ct;
        this.dt = dt;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ct).inflate(R.layout.store_item_row, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Moves moves = dt.get(i);
        myViewHolder.name.setText(moves.getTitle());
        myViewHolder.price.setText(moves.getPrice());
        Glide.with(ct).load(moves.getImage()).into(myViewHolder.thumbnall);
    }

    @Override
    public int getItemCount() {
        return dt.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, price;
        ImageView thumbnall;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            thumbnall = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
}
