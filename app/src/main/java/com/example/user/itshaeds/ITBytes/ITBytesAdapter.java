package com.example.user.itshaeds.ITBytes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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
        holder.name1.setText(itemList.get(position).getName());
        holder.name2.setText(itemList.get(position).getDesc());



        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

//                String title=product.getName().toString();
//                String exp=product.getExp().toString();
//                //String location=product.getLoc().toString();
//
//                Log.e("responce", title);
//
//                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor edit = pref.edit();
//
//                edit.putString("Title",title);
//                edit.putString("Exp",exp);
//                //edit.putString("Loc",location);
//
//                edit.commit();
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

        public TextView name1, name2;

        private RecyclerViewItemClickListener itemClickListener;


        public ITBytesViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name1 = (TextView) itemView.findViewById(R.id.text1);
            name2 = (TextView) itemView.findViewById(R.id.text2);

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


