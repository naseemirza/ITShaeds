package com.example.user.itshaeds.ITBytes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itshaeds.ModelJobs;
import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 24-Jul-18.
 */

public class ITBytRecycAdapter extends RecyclerView.Adapter<ITBytRecycAdapter.ProductViewHolder>  {

    private Context mCtx;
    private List<ModelJobs> productList;

    public ITBytRecycAdapter(Context mCtx, List<ModelJobs> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ITBytRecycAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.adapter, null);
        return new ITBytRecycAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ITBytRecycAdapter.ProductViewHolder holder, int position) {
        final ModelJobs product = productList.get(position);

        holder.textViewTitle.setText(product.getName());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

//        holder.setItemClickListener(new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Log.e("responce", String.valueOf(position));
//
//                final Intent intent;
//                if (position == 0){
//                    intent =  new Intent(mCtx, JobsActivity.class);
//                } else if (position == 1){
//                    intent =  new Intent(mCtx, CurrentJobActivity.class);
//                } else if (position == 2){
//                    intent =  new Intent(mCtx, ITBytesActivity.class);
//
//                } else if (position== 3) {
//                    intent = new Intent(mCtx, ClassifiedsActivity.class);
//                }else if (position == 4) {
//                    intent = new Intent(mCtx, SolutionsActivity.class);
//                }else if (position == 5) {
//                    intent = new Intent(mCtx, LearningActivity.class);
//                }
//                else {
//                    intent =  new Intent(mCtx, Main2Activity.class);
//                }
//                mCtx.startActivity(intent);
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

                                                          // implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder  {

        TextView textViewTitle;
        ImageView imageView;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            imageView = itemView.findViewById(R.id.imageview);
            //itemView.setOnClickListener(this);

        }
//        @Override
//        public void onClick(View v) {
//            this.itemClickListener.onClick(v,getLayoutPosition());
//
//        }
//
//        public void setItemClickListener(RecyclerViewItemClickListener ic)
//        {
//            this.itemClickListener=ic;
//
//        }
    }
}
