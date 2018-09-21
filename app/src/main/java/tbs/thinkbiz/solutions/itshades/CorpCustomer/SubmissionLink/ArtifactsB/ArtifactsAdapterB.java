package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.CertifictinActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.ClassRmTrngActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.OnDemndTrngActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.LearnAndDevlp.OnlnTrangActivity;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB.SoluAdapterB;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.SolutionsB.SoluModelB;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

/**
 * Created by User on 19-Sep-18.
 */

public class ArtifactsAdapterB extends RecyclerView.Adapter<ArtifactsAdapterB.ViewHolder> {

    private List<ArtifactsModelB> parentList;
    private Context mCtx;

    public ArtifactsAdapterB(Context context, List<ArtifactsModelB> apps) {
        mCtx = context;
        parentList = apps;

    }

    @Override
    public ArtifactsAdapterB.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mCtx).inflate(R.layout.parent_items, parent, false);
        return new ArtifactsAdapterB.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ArtifactsAdapterB.ViewHolder holder, int position) {
        final ArtifactsModelB app = parentList.get(position);

        final String Pname = app.getName();
        holder.mTextViewName.setText(Pname);

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                if (position == 0){
                    String actname="Analyst Report";
                    String CatId="1";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.putString("CatId",CatId);

                    edit.commit();
                    Intent intent0 =  new Intent(mCtx, AnalysReprtActivity.class);
                    mCtx.startActivity(intent0);
                } else if (position == 1){
                    String actname="White Paper";
                    String CatId="2";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.putString("CatId",CatId);

                    edit.commit();
                    Intent intent1 =  new Intent(mCtx, WhtPapersActivity.class);
                    mCtx.startActivity(intent1);
                } else if (position == 2){
                    String actname="Customer Success Stories";
                    String CatId="3";

                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString("Actvname",actname);
                    edit.putString("CatId",CatId);

                    edit.commit();
                    Intent intent2 =  new Intent(mCtx, CustScsStoriesActivity.class);
                    mCtx.startActivity(intent2);
                }

            }
        });

    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    // implements View.OnClickListener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTextViewName;

         private RecyclerViewItemClickListener itemClickListener;

        public ViewHolder(View itemView) {

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
