package com.example.user.itshaeds.CompnyDrctry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 27-Jul-18.
 */

public class CompanyNameAdapter extends RecyclerView.Adapter<CompanyNameAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<CompnyNameModel> productList;

    public CompanyNameAdapter(Context mCtx, List<CompnyNameModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public CompanyNameAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.compdrlayout1, null);
        return new CompanyNameAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompanyNameAdapter.ProductViewHolder holder, int position) {
        final CompnyNameModel product = productList.get(position);

        holder.textViewTitle.setText(product.getName());
        holder.textViewdesc.setText(product.getCompnydesc());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {


                String actname=product.getName().toString();

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);


               edit.commit();
                Intent intent = new Intent(view.getContext(), CmpProfileActivity.class);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView textViewTitle,textViewdesc;
        ImageView imageView;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.compname);
            textViewdesc = itemView.findViewById(R.id.companydetails);
            imageView = itemView.findViewById(R.id.compid);
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

