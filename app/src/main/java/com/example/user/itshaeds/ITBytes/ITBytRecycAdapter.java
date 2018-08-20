package com.example.user.itshaeds.ITBytes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itshaeds.ITByteDetailsRecy.AnnouncementsActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.CustSuccessActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.FinancialActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.MandAPartActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.MarktAndEventsActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.MiscellaneousActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.RewardAndRecogActivity;
import com.example.user.itshaeds.ITByteDetailsRecy.SolutionsActivity;
import com.example.user.itshaeds.Jobs.ModelJobs;
import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 24-Jul-18.
 */

public class ITBytRecycAdapter extends RecyclerView.Adapter<ITBytRecycAdapter.ProductViewHolder>  {

    private Context mCtx;
    private List<ModelJobs> productList;

    public ITBytRecycAdapter(Context mCtx, List<ModelJobs> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ITBytRecycAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.adapter, null);
        return new ITBytRecycAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ITBytRecycAdapter.ProductViewHolder holder, int position) {
        final ModelJobs product = productList.get(position);

        Log.e("pos", String.valueOf(product));

        holder.textViewTitle.setText(product.getName());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();


                //Log.e("responce", String.valueOf(position));

                //final Intent intent;
                if (position == 0){
                    String actname ="Financial ";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );

                    edit.commit();
                   Intent intent0 =  new Intent(mCtx, FinancialActivity.class);
                    mCtx.startActivity(intent0);
                }
                else if (position == 1){
                    String actname ="Solutions ";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );
                    edit.commit();
                  Intent intent1 =  new Intent(mCtx, SolutionsActivity.class);
                    mCtx.startActivity(intent1);
                }
                else if (position == 2){

                    String actname ="Reward & Recognition ";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );

                    edit.commit();
                    Intent intent2 =  new Intent(mCtx, RewardAndRecogActivity.class);
                    mCtx.startActivity(intent2);
                }
                else if (position == 3){
                    String actname ="Customer Success ";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );
                    edit.commit();
                   Intent intent3 =  new Intent(mCtx, CustSuccessActivity.class);
                    mCtx.startActivity(intent3);
                }
                else if (position == 4){
                    String actname ="Marketing & Events";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );
                    edit.commit();
                   Intent intent4 =  new Intent(mCtx, MarktAndEventsActivity.class);
                    mCtx.startActivity(intent4);
                }
                else if (position == 5){
                    String actname ="M & A Partnerships";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );
                    edit.commit();
                   Intent intent5 =  new Intent(mCtx, MandAPartActivity.class);
                    mCtx.startActivity(intent5);
                }
                else if (position == 6){
                    String actname ="Miscellaneous";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );
                    edit.commit();
                   Intent intent6 =  new Intent(mCtx, MiscellaneousActivity.class);
                    mCtx.startActivity(intent6);
                }
                else if (position == 7){
                    String actname ="Announcements";
                    edit.putString("position", String.valueOf(position));
                    edit.putString("Actvname",actname );
                    edit.commit();
                   Intent intent7 =  new Intent(mCtx, AnnouncementsActivity.class);
                    mCtx.startActivity(intent7);
                }


                else {

                   Intent intent =  new Intent(mCtx, ITBytDetailsActivity.class);
                    mCtx.startActivity(intent);
                }
               // mCtx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle;
        ImageView imageView;

        //CardView cardView;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            imageView = itemView.findViewById(R.id.imageview);
            //cardView = itemView.findViewById(R.id.cardID);
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
