package com.example.user.itshaeds.CorpCustomer.SubmissionLink;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.itshaeds.R;
import com.example.user.itshaeds.RecyclerViewItemClickListener;

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

//        Glide.with(mCtx)
//                .load(imageurl)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .fitCenter()
//                .into(holder.mImageView);

//        holder.setItemClickListener(new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                String plistid=app.getId().toString();
//                String Pdname=app.getName().toString();
//                Log.e("responce",Pdname);
//
//                SharedPreferences pref = view.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor edit = pref.edit();
//                edit.putString("pid",plistid);
//                edit.putString("pname",Pdname);
//
//                edit.commit();
//                Intent intent = new Intent(view.getContext(), ChildActivity.class);
//                view.getContext().startActivity(intent);
//
//            }
//        });

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
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewName;

        private RecyclerViewItemClickListener itemClickListener;

        public ViewHolder(View itemView ) {

            super(itemView);
            //mImageView=(ImageView)itemView.findViewById(R.id.imageViewName);
            mTextViewName=(TextView) itemView.findViewById(R.id.listTitle);
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


