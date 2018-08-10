package com.example.user.itshaeds.Jobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 09-Aug-18.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<DetailsModel> productList1;

    public DetailsAdapter(Context mCtx, List<DetailsModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;

    }

    @Override
    public DetailsAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.details_layout,parent, false);
        return new DetailsAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DetailsAdapter.ProductViewHolder holder, int position) {
        final DetailsModel product = productList1.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewexp.setText(product.getExp()+" Yrs");
        holder.textViewcontry.setText(product.getCountry());
        holder.textViewloc.setText("["+product.getLoc()+"]");
        holder.textViewcmpname.setText(product.getCmpName());
        holder.textViewkeyskills.setText(product.getKeyskils());
        holder.textViewjobdesc.setText(product.getJobDesc());
        holder.textViewexplevel.setText(product.getExpLevel());


        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                String jobID=product.getmID().toString();
                //String title=product.getName().toString();
                //String exp=product.getExp().toString();
                Log.e("responce", jobID);
                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                //edit.putString("Title",title);
                // edit.putString("Exp",exp);
                edit.putString("Exp",jobID);

                edit.commit();
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

                                                        // implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView textViewTitle;
        TextView textViewexp;
        TextView textViewcontry;
        TextView textViewloc;
        TextView textViewcmpname;
        TextView textViewkeyskills;
        TextView textViewjobdesc;
        TextView textViewexplevel;


        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.textvpost);
            textViewexp = itemView.findViewById(R.id.textyrs);
            textViewcontry = itemView.findViewById(R.id.textcontry);
            textViewloc = itemView.findViewById(R.id.textlocation);
            textViewcmpname = itemView.findViewById(R.id.compnm);
            textViewkeyskills = itemView.findViewById(R.id.kskls);
            textViewjobdesc = itemView.findViewById(R.id.desc);
            textViewexplevel = itemView.findViewById(R.id.explevl);


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


