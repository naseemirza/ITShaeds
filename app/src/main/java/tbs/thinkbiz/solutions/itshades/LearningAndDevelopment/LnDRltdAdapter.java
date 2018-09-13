package tbs.thinkbiz.solutions.itshades.LearningAndDevelopment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.Artifacts.ArtfAdapter;
import tbs.thinkbiz.solutions.itshades.Artifacts.ArtfModel;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

/**
 * Created by User on 11-Sep-18.
 */

public class LnDRltdAdapter extends RecyclerView.Adapter<LnDRltdAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<LnDRltdModel> productList1;


    public LnDRltdAdapter(Context mCtx, List<LnDRltdModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public LnDRltdAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.relatedlnd,parent, false);
        return new LnDRltdAdapter.ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final LnDRltdAdapter.ProductViewHolder holder, int position) {
        final LnDRltdModel product = productList1.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDesc.setText(product.getDesc());
        holder.textViewIndAra.setText(product.getIndAra());
        holder.textViewFocsAra.setText(product.getFocsar());
        holder.textViewtelcon.setText(product.getTeleconbrdg());
        holder.textViewpstd.setText(product.getPstedby());


        holder.textViewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=product.getId();
                String title=product.getName();
                String inds=product.getIndAra();
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

                Intent intent = new Intent(v.getContext(), LandDetailsActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public TextView textViewDesc;
        public TextView textViewIndAra;
        public TextView textViewFocsAra;
        public TextView textViewtelcon;
        public TextView textViewpstd;
        public TextView textViewdetails;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewName = itemView.findViewById(R.id.nameTextview);
            textViewDesc = itemView.findViewById(R.id.descTextview);
            textViewIndAra = itemView.findViewById(R.id.indrel);
            textViewFocsAra = itemView.findViewById(R.id.fcsar1);
            textViewtelcon = itemView.findViewById(R.id.telecon);
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
