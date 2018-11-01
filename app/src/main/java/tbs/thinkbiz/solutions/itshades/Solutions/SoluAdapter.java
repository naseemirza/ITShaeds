package tbs.thinkbiz.solutions.itshades.Solutions;

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

import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.LandDetailsActivity;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * Created by User on 29-Aug-18.
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
        View view = inflater.inflate(tbs.thinkbiz.solutions.itshades.R.layout.solulayout,parent, false);
        return new SoluAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SoluAdapter.ProductViewHolder holder, int position) {
        final SoluModel product = productList1.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDesc.setText(product.getDesc());
        holder.textViewIndAra.setText(product.getIndAra());
        holder.textViewFocsAra.setText(product.getFocsar());
        holder.textViewprce.setText(product.getUprice());
        holder.textViewpstd.setText(product.getPsted());
        holder.textViewevntstrt.setText(product.getEvntstart());
        holder.textViewevntend.setText(product.getEvntend());
        //holder.checkBox.setChecked(productList1.get(position).getSelected());

        holder.textViewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cmpurl=product.getComsite();
                Log.e("responce", cmpurl);
                //Log.e("responce", title);

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("url",cmpurl);
                edit.apply();

                Intent intent = new Intent(v.getContext(), SoluDetailsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder   {

        TextView textViewName;
        TextView textViewDesc;
        public TextView textViewIndAra;
        public TextView textViewFocsAra;
        TextView textViewprce;
        TextView textViewpstd;
        TextView textViewevntstrt;
        TextView textViewevntend;
        TextView textViewdetails;



        // private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewName = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.nameTextview);
            textViewDesc = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.descTextview);
            textViewIndAra = itemView.findViewById(R.id.indrel);
            textViewFocsAra = itemView.findViewById(R.id.fcsar1);
            textViewprce = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.price);
            textViewpstd = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.pstdby);
            textViewevntstrt = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.date1);
            textViewevntend = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.date2);
            textViewdetails =(TextView) itemView.findViewById(R.id.compsite);

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
