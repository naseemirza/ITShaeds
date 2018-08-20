package com.example.user.itshaeds.CompnyDrctry;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.itshaeds.R;

import java.util.List;

/**
 * Created by User on 27-Jul-18.
 */

public class CompDrAdapter extends RecyclerView.Adapter<CompDrAdapter.ProductViewHolder> {

   private Context mCtx;
   private List<CmpDrModel> productList;

    public CompDrAdapter(Context mCtx, List<CmpDrModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public CompDrAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.compdrlayout, null);
        return new CompDrAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompDrAdapter.ProductViewHolder holder, int position) {
        final CmpDrModel product = productList.get(position);

        holder.textViewTitle.setText(product.getName());


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

                                                             //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;

       // private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
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


