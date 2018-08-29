package com.example.user.itshaeds.LearningAndDevelopment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.itshaeds.R;

import java.util.List;

/**
 * Created by User on 03-Aug-18.
 */

public class LnDAdapter extends RecyclerView.Adapter<LnDAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<LnDModel> productList1;


    public LnDAdapter(Context mCtx, List<LnDModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public LnDAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lndlayout,parent, false);
        return new LnDAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LnDAdapter.ProductViewHolder holder, int position) {
        final LnDModel product = productList1.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDesc.setText(product.getDesc());
        holder.textViewInd.setText(product.getIndrel());
        holder.textViewFocs.setText(product.getFocsar());
        holder.textViewpstd.setText(product.getPsted());
        //holder.checkBox.setChecked(productList1.get(position).getSelected());

//        holder.setItemClickListener(new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//
//                String title=product.getName().toString();
//                String exp=product.getExp().toString();
//
//
//                Log.e("responce", title);
//
//                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor edit = pref.edit();
//
//                edit.putString("Title",title);
//                edit.putString("Exp",exp);
//
//
//                edit.commit();
//                Intent intent = new Intent(view.getContext(), ITBytDetailsActivity1.class);
//                view.getContext().startActivity(intent);
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

                                                        //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder   {

        TextView textViewName;
        TextView textViewDesc;
        TextView textViewInd;
        TextView textViewFocs;
        TextView textViewpstd;




       // private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewName = itemView.findViewById(R.id.nameTextview);
            textViewDesc = itemView.findViewById(R.id.descTextview);
            textViewInd = itemView.findViewById(R.id.indrel);
            textViewFocs = itemView.findViewById(R.id.fcsar1);
            textViewpstd = itemView.findViewById(R.id.admin);

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

