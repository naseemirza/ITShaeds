package tbs.thinkbiz.solutions.itshades.ITBytes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 24-Jul-18.
 */

public class ITbytdetailsAdapter extends RecyclerView.Adapter<ITbytdetailsAdapter.ProductViewHolder>  {

    private Context mCtx;
    private List<ITbytdetalsmodel> productList1;


    public ITbytdetailsAdapter(Context mCtx, List<ITbytdetalsmodel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public ITbytdetailsAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.itbytdetails,parent, false);
        return new ITbytdetailsAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ITbytdetailsAdapter.ProductViewHolder holder, int position) {
        final ITbytdetalsmodel product = productList1.get(position);

        holder.textViewTitle.setText(product.getTitlename());
        holder.textViewyrs.setText(product.getDescr());
        //holder.checkBox.setChecked(productList1.get(position).getSelected());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                //SharedPreferences pref1 = view.getContext().getSharedPreferences("MyPrefs1", Context.MODE_PRIVATE);
                //String actname1="Financial";

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String actname=pref.getString("Actvname","");

                    String title = product.getTitlename();
                    String desc = product.getDescr();

                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("Title", title);
                    edit.putString("Descr", desc);
                    edit.putString("Actvname", actname);
                    edit.apply();
                    Intent intent = new Intent(view.getContext(), ITBytDetailsActivity1.class);
                    view.getContext().startActivity(intent);



//                SharedPreferences.Editor edit1 = pref1.edit();
//                edit1.putString("Actvname1", actname1);
//
//                Log.e("responce", actname1);
//
//                edit1.commit();
//                Intent intent1 = new Intent(view.getContext(), ITBytDetailsActivity11.class);
//                view.getContext().startActivity(intent1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView textViewTitle;
        TextView textViewyrs;


        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            textViewyrs = itemView.findViewById(R.id.desctext);

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
