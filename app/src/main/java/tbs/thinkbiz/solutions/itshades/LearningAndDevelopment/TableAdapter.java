package tbs.thinkbiz.solutions.itshades.LearningAndDevelopment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.R;

/**
 * Created by User on 12-Sep-18.
 */

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<TableModel> productList;


    public TableAdapter(Context mCtx, List<TableModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public TableAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.tablelayout,parent, false);
        return new TableAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TableAdapter.ProductViewHolder holder, int position) {
        final TableModel product = productList.get(position);

        holder.textViewSrn.setText(product.getSrnumbr());
        holder.textViewAdd.setText(product.getAddress());
        holder.textViewCountry.setText(product.getCountry());
        holder.textViewTeleB.setText(product.getTelconBrdg());
        holder.textViewCity.setText(product.getCity());
        holder.textViewUserp.setText(product.getUserprice());
        holder.textViewPstdby.setText(product.getPostedby());
        holder.textViewStrdate.setText(product.getStrtdate());
        holder.textViewEndate.setText(product.getEndate());
        holder.textViewRes.setText(product.getResource());


        holder.textViewRegL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cmpurl=product.getReglink();
                Log.e("responce", cmpurl);

                Intent browserIntent = new Intent( Intent.ACTION_VIEW, Uri.parse((cmpurl)));
                v.getContext().startActivity(browserIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder  {


        public TextView textViewSrn;
        public TextView textViewAdd;
        public TextView textViewCountry;
        public TextView textViewTeleB;
        public TextView textViewCity;
        public TextView textViewUserp;
        public TextView textViewRegL;
        public TextView textViewPstdby;
        public TextView textViewStrdate;
        public TextView textViewEndate;
        public TextView textViewRes;

        //private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewSrn = itemView.findViewById(R.id.tv_nmbr);
            textViewAdd = itemView.findViewById(R.id.tv_add);
            textViewCountry = itemView.findViewById(R.id.tv_country);
            textViewTeleB = itemView.findViewById(R.id.tv_telcbrdge);
            textViewCity = itemView.findViewById(R.id.tv_city1);
            textViewUserp = itemView.findViewById(R.id.tv_userprc);
            textViewRegL = itemView.findViewById(R.id.tv_Reglnk);
            textViewPstdby = itemView.findViewById(R.id.tv_pstdby);
            textViewStrdate = itemView.findViewById(R.id.tv_strtdate);
            textViewEndate = itemView.findViewById(R.id.tv_Enddate);
            textViewRes = itemView.findViewById(R.id.tv_Resorce);



            //itemView.setOnClickListener(this);

        }

//        @Override
//        public void onClick(View v) {
//            this.itemClickListener.onClick(v,getLayoutPosition());
//        }
//
//        public void setItemClickListener(RecyclerViewItemClickListener ic)
//        {
//            this.itemClickListener=ic;
//
//        }

    }
}
