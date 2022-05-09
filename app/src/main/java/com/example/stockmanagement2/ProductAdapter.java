package com.example.stockmanagement2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
{

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Product> productList;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {


        //getting the product of the specified position
        Product product = productList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText("₹"+String.valueOf(product.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i= new Intent(mCtx,Item.class);
                    i.putExtra("title", productList.get(position).getTitle());
                    i.putExtra("shortdes", productList.get(position).getShortdesc());
                    i.putExtra("rating", productList.get(position).getRating());
                    i.putExtra("price", productList.get(position).getPrice());
                    i.putExtra("id", productList.get(position).getId());
                    i.putExtra("image", productList.get(position).getImage());

                    mCtx.startActivity(i);

            }
        });


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}


