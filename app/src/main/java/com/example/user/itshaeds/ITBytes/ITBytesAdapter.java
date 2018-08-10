package com.example.user.itshaeds.ITBytes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by User on 03-Jul-18.
 */

public class ITBytesAdapter extends RecyclerView.Adapter<ITBytesAdapter.ITBytesViewHolders> {

    private List<ITBytesModel> itemList;
    private Context context;

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

        holder.month.setText(itemList.get(position).getMonth());
        holder.edition.setText(itemList.get(position).getEdition());

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                String msg1=product.getMonth();
                String msg2=product.getEdition();

                String year=product.getYear();
                String month_edition=product.getMonth_edition();

               // Log.e("yr",year);
               // Log.e("msg1",msg1);

                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Month",msg1);
                edit.putString("Edition",msg2);

                edit.putString("year",year);
                edit.putString("month_edition",month_edition);

                edit.commit();
                Intent intent = new Intent(view.getContext(), ITBytDetailsActivity.class);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    class ITBytesViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView month, edition;

        private RecyclerViewItemClickListener itemClickListener;

        public ITBytesViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            month = (TextView) itemView.findViewById(R.id.text1);
            edition = (TextView) itemView.findViewById(R.id.text2);

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


