package tbs.thinkbiz.solutions.itshades.ITBytes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.AnnouncementsActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.CustSuccessActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.FinancialActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.MandAPartActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.MarktAndEventsActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.MiscellaneousActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.RewardAndRecogActivity;
import tbs.thinkbiz.solutions.itshades.ITByteDetailsRecy.SolutionsActivity;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 03-Jul-18.
 */

public class ITBytesAdapter extends RecyclerView.Adapter<ITBytesAdapter.ITBytesViewHolders> {

    private List<ITBytesModel> itemList;
    private Context context;
    String url;

    public ITBytesAdapter(Context context, List<ITBytesModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ITBytesViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itbytes, parent, false);
        ITBytesViewHolders rcv = new ITBytesViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ITBytesViewHolders holder, int position) {

        final ITBytesModel product = itemList.get(position);

        holder.yeardispl.setText(itemList.get(position).getYeardisplay());
       // holder.edition.setText(itemList.get(position).getEdition());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                String year=product.getYear();
                String yeardisp=product.getYeardisplay();
                String monthdispl=product.getMonthedition();

                 url ="https://www.itshades.com/appwebservices/industry-update.php?year="+year+"&month_edition="+monthdispl+"&catid=0";

                Log.e("pos", url);

                if (position == 0){
                     edit.putString("monthedi",monthdispl );
                     edit.putString("url",url );
                     edit.putString("position", String.valueOf(position));
                     edit.putString("year",year );
                     edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent0 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent0);
                }
                else if (position == 1){
                    edit.putString("monthedi",monthdispl );
                    edit.putString("url",url );
                    edit.putString("position",String.valueOf(position));
                    edit.putString("year",year );
                    edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent1 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent1);
                }
                else if (position == 2){

                    edit.putString("monthedi",monthdispl );
                    edit.putString("url",url );
                    edit.putString("position",String.valueOf(position));
                    edit.putString("year",year );
                    edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent2 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent2);
                }
                else if (position == 3){

                    edit.putString("monthedi",monthdispl );
                    edit.putString("url",url );
                    edit.putString("position",String.valueOf(position));
                    edit.putString("year",year );
                    edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent3 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent3);

                }
                else if (position == 4){
                    edit.putString("monthedi",monthdispl );
                    edit.putString("url",url );
                    edit.putString("position",String.valueOf(position));
                    edit.putString("year",year );
                    edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent4 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent4);
                }
                else if (position == 5){

                    edit.putString("monthedi",monthdispl );
                    edit.putString("url",url );
                    edit.putString("position",String.valueOf(position));
                    edit.putString("year",year );
                    edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent5 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent5);
                }

                else if (position == 6){
                    String url="https://www.itshades.com/appwebservices/industry-update.php?year=2018&month_edition=Previous&catid=0";
                    edit.putString("monthedi",monthdispl );
                    edit.putString("url",url );
                    edit.putString("position",String.valueOf(position));
                    edit.putString("year",year );
                    edit.putString("yeardisp",yeardisp );
                    edit.apply();
                    Intent intent6 =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent6);
                }

                else {

                    Intent intent =  new Intent(context, ITBytDetailsActivity.class);
                    context.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    class ITBytesViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView yeardispl;

        private RecyclerViewItemClickListener itemClickListener;

        public ITBytesViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            yeardispl = (TextView) itemView.findViewById(R.id.text1);

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


