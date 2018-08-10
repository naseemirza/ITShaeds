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
 * Created by User on 04-Jul-18.
 */

public class JobsNameAdapter extends RecyclerView.Adapter<JobsNameAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<JobsModelName> productList1;

    public JobsNameAdapter(Context mCtx, List<JobsModelName> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;

    }

    @Override
    public JobsNameAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.jobtitle,parent, false);
        return new JobsNameAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final ProductViewHolder holder, int position) {
        final JobsModelName product = productList1.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewexp.setText(product.getExp()+" Yrs");
        holder.textViewcontry.setText(product.getCountry());
        holder.textViewloc.setText("["+product.getLoc()+"]");

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
                edit.putString("JobID",jobID);

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


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView textViewTitle;
        TextView textViewexp;
        TextView textViewcontry;
        TextView textViewloc;
        FloatingActionButton floatingActionButton;
        CheckBox checkBox;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            textViewexp = itemView.findViewById(R.id.expTextview);
            textViewcontry = itemView.findViewById(R.id.contryTextview);
            textViewloc = itemView.findViewById(R.id.locTextview);
            checkBox=itemView.findViewById(R.id.chkox);

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


