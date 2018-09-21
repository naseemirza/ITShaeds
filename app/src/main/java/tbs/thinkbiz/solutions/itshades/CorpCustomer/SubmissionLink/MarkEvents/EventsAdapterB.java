package tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.MarkEvents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.ArtifactsAdapterB;
import tbs.thinkbiz.solutions.itshades.CorpCustomer.SubmissionLink.ArtifactsB.ArtifactsModelB;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * Created by User on 19-Sep-18.
 */

public class EventsAdapterB extends RecyclerView.Adapter<EventsAdapterB.ViewHolder> {

    private List<EventsModelB> parentList;
    private Context mCtx;

    public EventsAdapterB(Context context, List<EventsModelB> apps) {
        mCtx = context;
        parentList = apps;

    }

    @Override
    public EventsAdapterB.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mCtx).inflate(R.layout.parent_items, parent, false);
        return new EventsAdapterB.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final EventsAdapterB.ViewHolder holder, int position) {
        final EventsModelB app = parentList.get(position);

        final String Pname = app.getName();
        holder.mTextViewName.setText(Pname);

//        holder.setItemClickListener(new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//
//                if (position == 0){
//                    String actname="Solutions";
//
//                    SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor edit = pref.edit();
//
//                    edit.putString("Actvname",actname);
//
//                    edit.commit();
//                    Intent intent0 =  new Intent(mCtx, SolutionBActivity.class);
//                    mCtx.startActivity(intent0);
//                }
//
//            }
//        });

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
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewName;

        // private RecyclerViewItemClickListener itemClickListener;

        public ViewHolder(View itemView) {

            super(itemView);
            mTextViewName = (TextView) itemView.findViewById(R.id.listTitle);
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
