package tbs.thinkbiz.solutions.itshades.Artifacts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 29-Aug-18.
 */

public class ArtfAdapter  extends RecyclerView.Adapter<ArtfAdapter.ProductViewHolder>  {

    private Context mCtx;
    private List<ArtfModel> productList1;


    public ArtfAdapter(Context mCtx, List<ArtfModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public ArtfAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.artifactslayout,parent, false);
        return new ArtfAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArtfAdapter.ProductViewHolder holder, int position) {
        final ArtfModel product = productList1.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDesc.setText(product.getDesc());
        holder.textViewIndAra.setText(product.getIndAra());
        holder.textViewFocsAra.setText(product.getFocsar());
        holder.textViewpstd.setText(product.getPstedby());
        holder.textViewpstdate.setText(product.getPstdate());

        holder.textViewcmpsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cmpurl=product.getComsite();
                Log.e("responce", cmpurl);

                String actname=product.getName();
                SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("url",cmpurl);
                edit.putString("Actvname",actname);
                edit.apply();

                Intent browserIntent = new Intent( mCtx, ArtifactsViewActivity.class);
                v.getContext().startActivity(browserIntent);
            }
        });

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
    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView textViewName;
        public TextView textViewDesc;
        public TextView textViewIndAra;
        public TextView textViewFocsAra;
        public TextView textViewpstd;
        public TextView textViewpstdate;
        public TextView textViewcmpsite;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewName = itemView.findViewById(R.id.nameTextview);
            textViewDesc = itemView.findViewById(R.id.descTextview);
            textViewIndAra = itemView.findViewById(R.id.indrel);
            textViewFocsAra = itemView.findViewById(R.id.fcsar1);
            textViewpstd = itemView.findViewById(R.id.admin);
            textViewpstdate = itemView.findViewById(R.id.date1);
            textViewcmpsite =(TextView) itemView.findViewById(R.id.compsite);

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

