package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.MyEmployer;

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

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.Blog.BlogAdapter;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.Blog.BlogEditActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.Blog.BlogModel;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * Created by User on 25-Sep-18.
 */

public class MyEmpAdapter extends RecyclerView.Adapter<MyEmpAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<MyEmpModel> productList;


    public MyEmpAdapter(Context mCtx, List<MyEmpModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public MyEmpAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.my_employer_layout, parent, false);
        return new MyEmpAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyEmpAdapter.ProductViewHolder holder, int position) {
        final MyEmpModel product = productList.get(position);

        holder.tvfname.setText(product.getFname()+" ");
        holder.tvlname.setText(product.getLname());
        holder.tvemail.setText(product.getEmail());
        holder.tvaddeddate.setText(product.getAddedate());

        holder.tvaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actname = "Edit";
                String siteurl = product.getAction();

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname", actname);
                edit.putString("EditableUrl", siteurl);

                edit.commit();
                Intent intent = new Intent(v.getContext(), MyEmpEditActivity.class);
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    //implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder {


        public TextView tvfname;
        public TextView tvlname;
        public TextView tvemail;
        public TextView tvaddeddate;
        public ImageView tvaction;
        //private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx = itemView.getContext();

            tvfname = itemView.findViewById(R.id.fname);
            tvlname = itemView.findViewById(R.id.lname);
            tvemail = itemView.findViewById(R.id.email);
            tvaddeddate = itemView.findViewById(R.id.addatetv);
            tvaction = (ImageView) itemView.findViewById(R.id.editbtn);

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
