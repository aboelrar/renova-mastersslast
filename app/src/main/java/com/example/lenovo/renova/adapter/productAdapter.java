package com.example.lenovo.renova.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.renova.R;
import com.example.lenovo.renova.list.productList;
import com.example.lenovo.renova.view.doctorDetails;
import com.example.lenovo.renova.view.productDetails;

import java.util.ArrayList;

public class productAdapter extends RecyclerView.Adapter<productAdapter.productHolder> {
    Context context;
    ArrayList<productList>mylist;

    public productAdapter(Context context, ArrayList<productList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.productitem,viewGroup,false);
        productHolder productHolder=new productHolder(view);
        return productHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final productHolder viewHolder, int i) {
viewHolder.productImage.setImageResource(mylist.get(i).getProductImage());
viewHolder.productName.setText(mylist.get(i).getProducrName().toString());
viewHolder.productPrice.setText(mylist.get(i).getProductPrice().toString());
viewHolder.productitem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Bundle b = new Bundle();
        Intent intent=new Intent(context,productDetails.class);
        String name = viewHolder.productName.getText().toString();
        String productPrice = viewHolder.productPrice.getText().toString();

        b.putString("productPrice", productPrice);
        b.putString("name", name);
        intent.putExtras(b);
        v.getContext().startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class productHolder extends RecyclerView.ViewHolder {
        TextView productName,productPrice;
        ImageView productImage;
        LinearLayout productitem;
        public productHolder(@NonNull View itemView) {
            super(itemView);
            productName=(TextView)itemView.findViewById(R.id.productName);
            productPrice=(TextView)itemView.findViewById(R.id.price);
            productImage=(ImageView)itemView.findViewById(R.id.imgproducts);
            productitem=(LinearLayout)itemView.findViewById(R.id.productitem);

        }
    }
}
