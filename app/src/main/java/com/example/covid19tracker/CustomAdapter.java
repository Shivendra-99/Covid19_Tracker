package com.example.covid19tracker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public  class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Statewise> {
    ArrayList<StatewiseItem> data;
    LayoutInflater layoutInflater;
    private OnItemClickListener mListener;
   public interface OnItemClickListener
    {
        public void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }
    public CustomAdapter(Context c, ArrayList<StatewiseItem> n) {
        this.data = n;
        this.layoutInflater = LayoutInflater.from(c);
    }
    @NonNull
    @Override
    public Statewise onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.listitem, parent, false);
        return new Statewise(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Statewise holder, int position) {
        holder.state.setText(data.get(position).getState());
        holder.con.setText(data.get(position).getConfirmed());
        holder.act.setText(data.get(position).getActive());
        holder.rec.setText(data.get(position).getRecovered());
        holder.de.setText(data.get(position).getDeaths());
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class Statewise extends RecyclerView.ViewHolder  {
        TextView state, con, rec, de, act;
        public Statewise(@NonNull View itemView) {
            super(itemView);
            state = itemView.findViewById(R.id.state1);
            con = itemView.findViewById(R.id.co1);
            rec = itemView.findViewById(R.id.recover1);
            de = itemView.findViewById(R.id.deaths1);
            act = itemView.findViewById(R.id.actives1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null)
                    {
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION)
                        {
                            mListener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}