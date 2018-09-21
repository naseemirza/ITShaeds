package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission;

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
 * Created by User on 14-Sep-18.
 */

public class JobSubAdapter extends RecyclerView.Adapter<JobSubAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<JobSubModel> productList1;

    public JobSubAdapter(Context mCtx, List<JobSubModel> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public JobSubAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.jobsubmilayout,parent, false);
        return new JobSubAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final JobSubAdapter.ProductViewHolder holder, int position) {
        final JobSubModel product = productList1.get(position);

        holder.titletext.setText(product.getTitle());
        holder.keytext.setText(product.getKeyskills());
        holder.desctext.setText(product.getJobdesc());

        holder.editable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {

                String actname="For Job Editing";
                String siteurl=product.getEditable();

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);
                edit.putString("EditableUrl",siteurl);

                edit.commit();

                Intent intent = new Intent(v.getContext(), EditViewActivity.class);
                v.getContext().startActivity(intent);

//                Intent browserIntent = new Intent( Intent.ACTION_VIEW, Uri.parse((siteurl)));
//                v.getContext().startActivity(browserIntent);
            }
        });

//        holder.textViewdetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String id=product.getId();
//                String title=product.getName();
//                String inds=product.getIndrel();
//                String focs=product.getFocsar();
//                String dscrp=product.getDesc();
//
//
//                Log.e("responce", title);
//
//                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor edit = pref.edit();
//
//                edit.putString("Id",id);
//                edit.putString("Title",title);
//                edit.putString("Inds",inds);
//                edit.putString("Focus",focs);
//                edit.putString("DESC",dscrp);
//
//                edit.commit();
//
//                Intent intent = new Intent(v.getContext(), LandDetailsActivity.class);
//                v.getContext().startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView titletext;
        TextView keytext;
        TextView desctext;
        ImageView editable;


       // private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            titletext = itemView.findViewById(R.id.indsrel);
            keytext = itemView.findViewById(R.id.kskls);
            desctext = itemView.findViewById(R.id.desc);
            editable = (ImageView) itemView.findViewById(R.id.editbtn);


           // itemView.setOnClickListener(this);

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
