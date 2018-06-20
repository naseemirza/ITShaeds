package com.example.user.itshaeds;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 08-Jun-18.
 */

public class AdapterJobs extends RecyclerView.Adapter<AdapterJobs.ProductViewHolder> {

    private Context mCtx;
    private List<ModelJobs> productList;

    public AdapterJobs(Context mCtx, List<ModelJobs> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.adapter, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final ModelJobs product = productList.get(position);

        holder.textViewTitle.setText(product.getName());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e("responce", String.valueOf(position));

                final Intent intent;
            if (position == 0){
                intent =  new Intent(mCtx, JobsActivity.class);
            } else if (position == 1){
                intent =  new Intent(mCtx, ITBytesActivity.class);

            } else if (position== 2) {
                intent = new Intent(mCtx, ClassifiedsActivity.class);
            }else if (position == 3) {
                intent = new Intent(mCtx, SolutionsActivity.class);
            }else if (position == 4) {
                intent = new Intent(mCtx, LearningActivity.class);
            }
            else {
                intent =  new Intent(mCtx, Main2Activity.class);
            }
            mCtx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView textViewTitle;
        ImageView imageView;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
           mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            imageView = itemView.findViewById(R.id.imageview);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            this.itemClickListener.onClick(v,getLayoutPosition());

        }

        public void setItemClickListener(RecyclerViewItemClickListener ic)
        {
            this.itemClickListener=ic;

        }
    }
}
