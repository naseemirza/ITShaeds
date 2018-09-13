package tbs.thinkbiz.solutions.itshades.CompnyDrctry;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.R;

import java.util.List;

/**
 * Created by User on 30-Jul-18.
 */

public class CompPrflAdapter  extends RecyclerView.Adapter<CompPrflAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<CompPrflModel> productList;

    public CompPrflAdapter(Context mCtx, List<CompPrflModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public CompPrflAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.adapter, null);
        return new CompPrflAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompPrflAdapter.ProductViewHolder holder, int position) {
        final CompPrflModel product = productList.get(position);

        holder.textViewTitle.setText(product.getName());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

//        holder.setItemClickListener(new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Log.e("responce", String.valueOf(position));
//
//                //final Intent intent;
//                if (position == 0){
//                    Intent intent0 =  new Intent(mCtx, JobsActivity.class);
//                    mCtx.startActivity(intent0);
//                } else if (position == 1){
//                    Intent  intent1 =  new Intent(mCtx, CurrentJobActivity.class);
//                    mCtx.startActivity(intent1);
//                } else if (position == 2){
//                    Intent intent2 =  new Intent(mCtx, ITBytesActivity.class);
//                    mCtx.startActivity(intent2);
//
//                } else if (position== 3) {
//                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(mCtx);
//                    View mView = View.inflate(mCtx,R.layout.solutionsdialog, null);
//
//
//                    final Button buttoncls=(Button)mView.findViewById(R.id.buttonclass);
//                    final Button buttondrc=(Button)mView.findViewById(R.id.buttoncompdr);
//                    buttoncls.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            buttondrc.setBackgroundResource(R.drawable.buttonalrt);
//                            buttondrc.setTextColor(Color.BLACK);
//
//                            buttoncls.setBackgroundResource(R.drawable.clickbgclor);
//                            buttoncls.setTextColor(Color.WHITE);
//                            mCtx.startActivity(new Intent(mCtx,ClassifiedsActivity.class));
//                        }
//                    });
//
//                    buttondrc.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            buttoncls.setBackgroundResource(R.drawable.buttonalrt);
//                            buttoncls.setTextColor(Color.BLACK);
//
//                            buttondrc.setBackgroundResource(R.drawable.clickbgclor);
//                            buttondrc.setTextColor(Color.WHITE);
//
//                            mCtx.startActivity(new Intent(mCtx,CompDirectoryActivity.class));
//                        }
//                    });
////                final Spinner spiner = (Spinner)mView.findViewById(R.id.spinner3);
////
////                String[] users = new String[]{
////                        "Classified Types...",
////                        "Classifieds",
////                        "Company Directory"
////
////                };
////
////                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
////                        mCtx,R.layout.spinneritems,users
////                );
////                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
////                spiner.setAdapter(spinnerArrayAdapter);
//
////
////                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        if(spiner.getSelectedItem().toString().equals("Classifieds")) {
////                          Intent  intent31 = new Intent(mCtx, ClassifiedsActivity.class);
////                            mCtx.startActivity(intent31);
////                            dialogInterface.dismiss();
////                        }
////                        if(spiner.getSelectedItem().toString().equals("Company Directory")) {
////                           Intent intent32 = new Intent(mCtx, CompDirectoryActivity.class);
////                            mCtx.startActivity(intent32);
////                            dialogInterface.dismiss();
////                        }
////                    }
////                });
////
//                    mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.dismiss();
//                        }
//                    });
//                    mBuilder.setView(mView);
//                    AlertDialog dialog=mBuilder.create();
//                    dialog.show();
//
//                    //intent = new Intent(mCtx, ClassifiedsActivity.class);
//                }else if (position == 4) {
//                    Intent intent4 = new Intent(mCtx, SolutionsActivity.class);
//                    mCtx.startActivity(intent4);
//                }else if (position == 5) {
//                    Intent intent5 = new Intent(mCtx, LearningActivity.class);
//                    mCtx.startActivity(intent5);
//                }else if (position == 6) {
//                    Intent intent6 = new Intent(mCtx, ArtifactsActivity.class);
//                    mCtx.startActivity(intent6);
//                }else if (position == 7) {
//                    Intent intent7 = new Intent(mCtx, EventsActivity.class);
//                    mCtx.startActivity(intent7);
//                }else if (position == 8) {
//                    Intent intent8 = new Intent(mCtx, CompReviewActivity.class);
//                    mCtx.startActivity(intent8);
//                }
//                else {
//                    Intent intent =  new Intent(mCtx, Main2Activity.class);
//                    mCtx.startActivity(intent);
//                }
//                //mCtx.startActivity(intent);
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

                                                           // implements View.OnClickListener
    class ProductViewHolder extends RecyclerView.ViewHolder  {

        TextView textViewTitle;
        ImageView imageView;

        //private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(R.id.nameTextview);
            imageView = itemView.findViewById(R.id.imageview);
           // itemView.setOnClickListener(this);

        }
//        @Override
//        public void onClick(View v) {
//            this.itemClickListener.onClick(v,getLayoutPosition());
//
//        }
//
//        public void setItemClickListener(RecyclerViewItemClickListener ic)
//        {
//            this.itemClickListener=ic;
//
//        }
    }
}

