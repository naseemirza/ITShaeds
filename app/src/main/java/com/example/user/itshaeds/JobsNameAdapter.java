package com.example.user.itshaeds;

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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

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
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.jobtitle,parent, false);
        return new JobsNameAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final ProductViewHolder holder, int position) {
        final JobsModelName product = productList1.get(position);

        holder.textViewTitle.setText(product.getName());
        holder.textViewyrs.setText(product.getExp());
        //holder.checkBox.setChecked(productList1.get(position).getSelected());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                String title=product.getName().toString();
                String exp=product.getExp().toString();
                //String location=product.getLoc().toString();

                Log.e("responce", title);

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Title",title);
                edit.putString("Exp",exp);
                //edit.putString("Loc",location);

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


    class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView textViewTitle;
        TextView textViewyrs;
        CheckBox checkBox;
        FloatingActionButton floatingActionButton;
        //TextView textViewloc;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            textViewyrs = itemView.findViewById(R.id.yrsTextview);
            checkBox=(CheckBox)itemView.findViewById(R.id.chkox);
            floatingActionButton =(FloatingActionButton)itemView.findViewById(R.id.fab);

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


