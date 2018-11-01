package tbs.thinkbiz.solutions.itshades.IndividulaProfile;

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

import java.util.List;

import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

/**
 * Created by User on 26-Oct-18.
 */

public class IndprofileAdapter extends RecyclerView.Adapter<IndprofileAdapter.ViewHolder> {

    private List<IndProfileModel> parentList;
    private Context mCtx;

    public IndprofileAdapter(Context context, List<IndProfileModel> apps){
        mCtx=context;
        parentList=apps;

    }
    @Override
    public IndprofileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mCtx).inflate(R.layout.parent_items, parent, false);
        return new IndprofileAdapter.ViewHolder(v);

    }


    @Override
    public void onBindViewHolder(final IndprofileAdapter.ViewHolder holder, int position) {
        final IndProfileModel app=parentList.get(position);

        final String Pname = app.getName();
        holder.mTextViewName.setText(Pname);

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e("responce", String.valueOf(position));

                if (position == 0){
                    String actname="Become Premium User";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("Actvname",actname);
                    edit.apply();
                    Intent intent0 =  new Intent(mCtx, PremiumUserActivity.class);
                    mCtx.startActivity(intent0);

                } else if (position == 1){
                    String actname="Change Password";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("Actvname",actname);
                    edit.apply();
                    Intent  intent1 =  new Intent(mCtx, IndChangePassActivity.class);
                    mCtx.startActivity(intent1);

                } else if (position == 2){
                    String actname="Invite To Friends";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("Actvname",actname);
                    edit.apply();
                    Intent intent2 =  new Intent(mCtx, IndInvitFrndsActivity.class);
                    mCtx.startActivity(intent2);

                }else if (position == 3) {
                    String actname="Contact Us";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("Actvname",actname);
                    edit.apply();
                    Intent intent3 = new Intent(mCtx, IndContactUsActivity.class);
                    mCtx.startActivity(intent3);

                }else if (position == 4) {
                    String actname="Subscibe";
                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("Actvname",actname);
                    edit.apply();
                    Intent intent4 = new Intent(mCtx, IndSubscrbActivity.class);
                    mCtx.startActivity(intent4);
                }
//                else if (position == 5) {
//                    String actname="Logout";
//                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor edit = pref.edit();
//                    edit.putString("Actvname",actname);
//                    edit.apply();
//                    Intent intent5 = new Intent(mCtx, LoginActivity.class);
//                    mCtx.startActivity(intent5);
//                }
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView mTextViewName;
        private RecyclerViewItemClickListener itemClickListener;
        public ViewHolder(View itemView ) {

            super(itemView);
            mTextViewName = (TextView) itemView.findViewById(R.id.listTitle);
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
