package com.example.lenovo.renova.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.list.reserveList;
import com.example.lenovo.renova.view.Login;

import java.util.ArrayList;

public class reservationAdapter extends RecyclerView.Adapter<reservationAdapter.reservationHolder> {
    Context context;
    ArrayList<reserveList>mylist;

    public reservationAdapter(Context context, ArrayList<reserveList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public reservationHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.reservationitem,viewGroup,false);
        reservationHolder reservationHolder=new reservationHolder(view);
        return reservationHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull reservationHolder viewHolder, int i) {
        viewHolder.date.setText(mylist.get(i).getDate().toString());
        viewHolder.from.setText(mylist.get(i).getFrom().toString());
        viewHolder.to.setText(mylist.get(i).getTo().toString());
        viewHolder.reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context,Login.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class reservationHolder extends RecyclerView.ViewHolder {
        TextView date,from,to,reservation;
        public reservationHolder(@NonNull View itemView) {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.date);
            from=(TextView)itemView.findViewById(R.id.from);
            to=(TextView)itemView.findViewById(R.id.to);
            reservation=(TextView)itemView.findViewById(R.id.reserve);
        }
    }
}
