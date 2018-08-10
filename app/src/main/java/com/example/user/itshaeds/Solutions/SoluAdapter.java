package com.example.user.itshaeds.Solutions;

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

public class SoluAdapter extends RecyclerView.Adapter<SoluAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<SoluModel> productList1;


    public SoluAdapter(Context mCtx, List<SoluModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public SoluAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.detailslayout,parent, false);
        return new SoluAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SoluAdapter.ProductViewHolder holder, int position) {
        final SoluModel product = productList1.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDesc.setText(product.getDesc());
        holder.textViewIndby.setText(product.getIndrelby());
        holder.textViewInd.setText(product.getIndrel());
        holder.textViewFocsby.setText(product.getFocarby());
        holder.textViewFocs.setText(product.getFocsar());
        holder.textViewPostdby.setText(product.getPstdby());
        holder.textViewpstd.setText(product.getPsted());
        holder.textViewPostdate.setText(product.getPstdate());
        holder.textViewdate.setText(product.getDate1());
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
        TextView textViewIndby;
        TextView textViewInd;
        TextView textViewFocsby;
        TextView textViewFocs;
        TextView textViewPostdby;
        TextView textViewpstd;
        TextView textViewPostdate;
        TextView textViewdate;



       // private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewName = itemView.findViewById(R.id.nameTextview);
            textViewDesc = itemView.findViewById(R.id.descTextview);
            textViewIndby = itemView.findViewById(R.id.indrelty);
            textViewInd = itemView.findViewById(R.id.indrel);
            textViewFocsby = itemView.findViewById(R.id.fcsar);
            textViewFocs = itemView.findViewById(R.id.fcsar1);
            textViewPostdby = itemView.findViewById(R.id.postedby);
            textViewpstd = itemView.findViewById(R.id.admin);
            textViewPostdate = itemView.findViewById(R.id.postedate);
            textViewdate = itemView.findViewById(R.id.date1);

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

