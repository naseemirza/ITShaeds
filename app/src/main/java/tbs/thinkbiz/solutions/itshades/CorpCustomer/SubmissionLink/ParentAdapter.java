package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink;

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

import tbs.thinkbiz.solutions.itshades.AllUrls;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.ArtifactsBActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.JobSubmission.JobSubmiActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.LearngAndDevActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.MarkEvents.MarktngEvntsActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB.ProdAndPlatfActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB.SolutionBActivity;
import tbs.thinkbiz.solutions.itshades.Jobs.JobsActivity;
import tbs.thinkbiz.solutions.itshades.Main2Activity;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 08-Aug-18.
 */

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {

    private List<Parent> parentList;
    private Context mCtx;

    public ParentAdapter(Context context, List<Parent> apps){
        mCtx=context;
        parentList=apps;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mCtx).inflate(R.layout.parent_items, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Parent app=parentList.get(position);

        final String Pname = app.getName();
        //String imageurl = app.getImageUrl();
        holder.mTextViewName.setText(Pname);

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                if (position == 0){
                    String actname="Jobs Submission";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent0 =  new Intent(mCtx, JobSubmiActivity.class);
                    mCtx.startActivity(intent0);
                } else if (position == 1){
                    String actname="Solutions";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent0 =  new Intent(mCtx, SolutionBActivity.class);
                    mCtx.startActivity(intent0);
                } else if (position == 2){
                    String actname="Learning & Development";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent0 =  new Intent(mCtx, LearngAndDevActivity.class);
                    mCtx.startActivity(intent0);
                }else if (position == 3){
                    String actname="Artifacts";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent0 =  new Intent(mCtx, ArtifactsBActivity.class);
                    mCtx.startActivity(intent0);
                } else if (position == 4){
                    String actname="Marketing Events";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);

                    edit.commit();
                    Intent intent0 =  new Intent(mCtx, MarktngEvntsActivity.class);
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


