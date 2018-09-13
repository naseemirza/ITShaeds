package tbs.thinkbiz.solutions.itshades.Events.OnlineEvent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

/**
 * Created by User on 13-Sep-18.
 */

public class OnlineEventAdapter extends RecyclerView.Adapter<OnlineEventAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<OnlineEventModel> productList1;


    public OnlineEventAdapter(Context mCtx, List<OnlineEventModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public OnlineEventAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lndlayout,parent, false);
        return new OnlineEventAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OnlineEventAdapter.ProductViewHolder holder, int position) {
        final OnlineEventModel product = productList1.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDesc.setText(product.getDesc());
        holder.textViewInd.setText(product.getIndrel());
        holder.textViewFocs.setText(product.getFocsar());
        holder.textViewpstd.setText(product.getPsted());

        holder.textViewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=product.getId();
                String title=product.getName();
                String inds=product.getIndrel();
                String focs=product.getFocsar();
                String dscrp=product.getDesc();


                Log.e("responce", title);

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Id",id);
                edit.putString("Title",title);
                edit.putString("Inds",inds);
                edit.putString("Focus",focs);
                edit.putString("DESC",dscrp);

                edit.commit();

                Intent intent = new Intent(v.getContext(), OnlineEventDetailsActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener   {

        TextView textViewName;
        TextView textViewDesc;
        TextView textViewInd;
        TextView textViewFocs;
        TextView textViewpstd;
        TextView textViewdetails;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewName = itemView.findViewById(R.id.nameTextview);
            textViewDesc = itemView.findViewById(R.id.descTextview);
            textViewInd = itemView.findViewById(R.id.indrel);
            textViewFocs = itemView.findViewById(R.id.fcsar1);
            textViewpstd = itemView.findViewById(R.id.admin);
            textViewdetails =(TextView) itemView.findViewById(R.id.compsite);

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