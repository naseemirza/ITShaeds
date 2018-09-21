package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission.JobSubmiActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB.SoluAdapterB;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB.SoluModelB;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

/**
 * Created by User on 19-Sep-18.
 */

public class LanDAdapterB extends RecyclerView.Adapter<LanDAdapterB.ViewHolder> {

    private List<LanDModelB> parentList;
    private Context mCtx;

    public LanDAdapterB(Context context, List<LanDModelB> apps){
        mCtx=context;
        parentList=apps;

    }
    @Override
    public LanDAdapterB.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mCtx).inflate(R.layout.parent_items, parent, false);
        return new LanDAdapterB.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final LanDAdapterB.ViewHolder holder, int position) {
        final LanDModelB app=parentList.get(position);

        final String Pname = app.getName();
        holder.mTextViewName.setText(Pname);

       holder.setItemClickListener(new RecyclerViewItemClickListener() {
           @Override
           public void onClick(View view, int position) {

               if (position == 0){
                   String actname="Online Training";
                   String CatId="1";

                   SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                   SharedPreferences.Editor edit = pref.edit();

                   edit.putString("Actvname",actname);
                   edit.putString("CatId",CatId);

                   edit.commit();
                   Intent intent0 =  new Intent(mCtx, OnlnTrangActivity.class);
                   mCtx.startActivity(intent0);
               } else if (position == 1){
                   String actname="Classroom Training";
                   String CatId="2";

                   SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                   SharedPreferences.Editor edit = pref.edit();

                   edit.putString("Actvname",actname);
                   edit.putString("CatId",CatId);

                   edit.commit();
                   Intent intent0 =  new Intent(mCtx, ClassRmTrngActivity.class);
                   mCtx.startActivity(intent0);
               } else if (position == 2){
                   String actname="Certification";
                   String CatId="3";

                   SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                   SharedPreferences.Editor edit = pref.edit();

                   edit.putString("Actvname",actname);
                   edit.putString("CatId",CatId);

                   edit.commit();
                   Intent intent0 =  new Intent(mCtx, CertifictinActivity.class);
                   mCtx.startActivity(intent0);
               } else if (position == 3){
                   String actname="On Demand Training";
                   String CatId="4";

                   SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                   SharedPreferences.Editor edit = pref.edit();

                   edit.putString("Actvname",actname);
                   edit.putString("CatId",CatId);

                   edit.commit();
                   Intent intent0 =  new Intent(mCtx, OnDemndTrngActivity.class);
                   mCtx.startActivity(intent0);
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

        public TextView mTextViewName;

        private RecyclerViewItemClickListener itemClickListener;

        public ViewHolder(View itemView ) {

            super(itemView);
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
