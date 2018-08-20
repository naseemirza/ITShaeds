package com.example.user.itshaeds.Jobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 04-Jul-18.
 */

public class JobsNameAdapter extends RecyclerView.Adapter<JobsNameAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<JobsModelName> productList1;

    public JobsNameAdapter(Context mCtx, List<JobsModelName> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;

    }

    @Override
    public JobsNameAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.jobtitle,parent, false);
        return new JobsNameAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final ProductViewHolder holder, int position) {
        final JobsModelName product = productList1.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewexp.setText(product.getExp()+" Yrs");
        holder.textViewcontry.setText(product.getCountry());
        holder.textViewloc.setText("["+product.getLoc()+"]");

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    // visible button here

                   // holder.buttonaply.setVisibility(View.VISIBLE);

                }else{

                    //invisble button here
                   // holder.buttonaply.setVisibility(View.GONE);
                }

            }
        });



        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                String actname ="Job Descriptions";

                String jobID=product.getmID();
                String title=product.getTitle();
                String exp=product.getExp()+" Yrs";
                String contry=product.getCountry();
                String loc="["+product.getLoc()+"]";
                String cmpname=product.getCmpName();
                String keyskils=product.getKeyskils();
                String jobdes=product.getJobDesc();
                String explevel=product.getExpLevel();


                Log.e("responce", jobID);

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putString("Title",title);
                edit.putString("Exp",exp);
                edit.putString("Country",contry);
                edit.putString("Loc",loc);
                edit.putString("Cmpname",cmpname);
                edit.putString("Keyskills",keyskils);
                edit.putString("Jobdesc",jobdes);
                edit.putString("ExpLevel",explevel);
                edit.putString("Actvname",actname);


                edit.apply();
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView textViewTitle;
        TextView textViewexp;
        TextView textViewcontry;
        TextView textViewloc;
        CheckBox checkBox;
//        Button buttonaply;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            textViewexp = itemView.findViewById(R.id.expTextview);
            textViewcontry = itemView.findViewById(R.id.contryTextview);
            textViewloc = itemView.findViewById(R.id.locTextview);
            checkBox=itemView.findViewById(R.id.chkox);
//            buttonaply=itemView.findViewById(R.id.applybutton);

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


