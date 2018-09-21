package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.R;

/**
 * Created by User on 20-Sep-18.
 */

public class ArtListAdapter extends RecyclerView.Adapter<ArtListAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<ArtListModel> productList;


    public ArtListAdapter(Context mCtx, List<ArtListModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ArtListAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layoutb,parent, false);
        return new ArtListAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArtListAdapter.ProductViewHolder holder, int position) {
        final ArtListModel product = productList.get(position);

        holder.tvtitlename.setText(product.getName());
        holder.tvindsrelv.setText(product.getIndsRelv());
        holder.tvfocsara.setText(product.getFocsAra());
        holder.tvuserprice.setText(product.getUserPrice());
        holder.tvaddeddate.setText(product.getAddeddate());
        holder.tvstatus.setText(product.getStatus());



        holder.tvaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {

                String actname="Edit";
                String siteurl=product.getAction();

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);
                edit.putString("EditableUrl",siteurl);

                edit.commit();
                Intent intent = new Intent(v.getContext(), ArtEditActivity.class);
                v.getContext().startActivity(intent);

//                Intent browserIntent = new Intent( Intent.ACTION_VIEW, Uri.parse((siteurl)));
//                v.getContext().startActivity(browserIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder  {


        public TextView tvtitlename;
        public TextView tvindsrelv;
        public TextView tvfocsara;
        public TextView tvuserprice;
        public TextView tvaddeddate;
        public TextView tvstatus;
        public ImageView tvaction;


        //private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();

            tvtitlename = itemView.findViewById(R.id.titlenametv);
            tvindsrelv = itemView.findViewById(R.id.indsrel);
            tvfocsara = itemView.findViewById(R.id.fcsar1);
            tvuserprice = itemView.findViewById(R.id.userprice);
            tvaddeddate = itemView.findViewById(R.id.addatetv);
            tvstatus = itemView.findViewById(R.id.statustv);
            tvaction = (ImageView)itemView.findViewById(R.id.editbtn);




            // for table view

//            tvtitlename = itemView.findViewById(R.id.tv_title);
//            tvindsrelv = itemView.findViewById(R.id.tv_indrelv);
//            tvfocsara = itemView.findViewById(R.id.tv_fcsara);
//            tvuserprice = itemView.findViewById(R.id.tv_userprice);
//            tvaddeddate = itemView.findViewById(R.id.tv_addeddate);
//            tvstatus = itemView.findViewById(R.id.tv_status);
//            tvaction = itemView.findViewById(R.id.tv_action);
//            tvaction.setPaintFlags(tvaction.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);



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
