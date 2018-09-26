package tbs.thinkbiz.solutions.itshades.CorpCustomer.Profile;

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

import tbs.thinkbiz.solutions.itshades.CompnyDrctry.CmpProfileActivity;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 08-Aug-18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private List<ProfileModel> parentList;
    private Context mCtx;

    public ProfileAdapter(Context context, List<ProfileModel> apps){
        mCtx=context;
        parentList=apps;

    }
    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mCtx).inflate(R.layout.parent_items, parent, false);
        return new ProfileAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ProfileAdapter.ViewHolder holder, int position) {
        final ProfileModel app=parentList.get(position);

        final String Pname = app.getName();
        //String imageurl = app.getImageUrl();
        holder.mTextViewName.setText(Pname);

//        Glide.with(mCtx)
//                .load(imageurl)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .fitCenter()
//                .into(holder.mImageView);

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e("responce", String.valueOf(position));


                if (position == 0){
                    String actname="Company Site";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();

                    Intent intent0 =  new Intent(mCtx, CompanySiteActivity.class);
                    mCtx.startActivity(intent0);
                } else if (position == 1){
                    Intent  intent1 =  new Intent(mCtx, AccDetailsActivity.class);
                    mCtx.startActivity(intent1);
                } else if (position == 2){
                    String actname="Change Password";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent2 =  new Intent(mCtx, ChangePassActivity.class);
                    mCtx.startActivity(intent2);
               }else if (position == 3) {
                    String actname="Invite To Friends";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent3 = new Intent(mCtx, InviteFrndsActivity.class);
                    mCtx.startActivity(intent3);
                }else if (position == 4) {
                    String actname="Contact us";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent4 = new Intent(mCtx, ContactUsPrflActivity.class);
                    mCtx.startActivity(intent4);
                }

            }
        });

    }

    @Override
    public int getItemViewType(int position){

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    // implements View.OnClickListener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView mTextViewName;

        private RecyclerViewItemClickListener itemClickListener;

        public ViewHolder(View itemView ) {

            super(itemView);
            //mImageView=(ImageView)itemView.findViewById(R.id.imageViewName);
            mTextViewName=(TextView) itemView.findViewById(R.id.listTitle);
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
