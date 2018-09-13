package tbs.thinkbiz.solutions.itshades.Jobs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tbs.thinkbiz.solutions.itshades.Artifacts.AnalystReportActivity;
import tbs.thinkbiz.solutions.itshades.Artifacts.CustSuccStoriesActivity;
import tbs.thinkbiz.solutions.itshades.Artifacts.WhitePapersActivity;
import tbs.thinkbiz.solutions.itshades.ClassifiedsActivity;
import tbs.thinkbiz.solutions.itshades.CompReviewActivity;
import tbs.thinkbiz.solutions.itshades.CompnyDrctry.CmpDirectoryActivity;
import tbs.thinkbiz.solutions.itshades.Events.ConfSumm.ConfrncSummitsActivity;
import tbs.thinkbiz.solutions.itshades.Events.OnlineEvent.OnlineEventsActivity;
import tbs.thinkbiz.solutions.itshades.Events.Webinar.WebinarActivity;
import tbs.thinkbiz.solutions.itshades.ITBytes.ITBytesActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.CertificationsActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.ClassroomTraingActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.OnDemandTrangActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.OnlineTrainingActivity;
import tbs.thinkbiz.solutions.itshades.LearningAndDevelopment.OnlineTranPortalActivity;
import tbs.thinkbiz.solutions.itshades.Main2Activity;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;
import tbs.thinkbiz.solutions.itshades.Solutions.ITConsltAndServActivity;
import tbs.thinkbiz.solutions.itshades.Solutions.IndSolutionsActivity;
import tbs.thinkbiz.solutions.itshades.Solutions.ProdAndPlatformActivity;

import java.util.List;

/**
 * Created by User on 08-Jun-18.
 */

public class AdapterJobs extends RecyclerView.Adapter<AdapterJobs.ProductViewHolder> {

    private Context mCtx;
    private List<ModelJobs> productList;

    public AdapterJobs(Context mCtx, List<ModelJobs> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(tbs.thinkbiz.solutions.itshades.R.layout.adapter, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final ModelJobs product = productList.get(position);

        holder.textViewTitle.setText(product.getName());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.setItemClickListener(new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e("responce", String.valueOf(position));

                //final Intent intent;
            if (position == 0){
                String actname="Dream Jobs";
                SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();
               Intent intent0 =  new Intent(mCtx, JobsActivity.class);
                mCtx.startActivity(intent0);
            } else if (position == 1){
                String actname="Current Jobs";
                SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();

                  Intent  intent1 =  new Intent(mCtx, CurrentJobActivity.class);
                mCtx.startActivity(intent1);
                } else if (position == 2){
                String actname="IT Bytes";
                SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("Actvname",actname);

                edit.commit();

                Intent intent2 =  new Intent(mCtx, ITBytesActivity.class);
                mCtx.startActivity(intent2);

            } else if (position== 3) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mCtx);
                View mView = View.inflate(mCtx, tbs.thinkbiz.solutions.itshades.R.layout.classifiedsdialog, null);

                final Button buttoncls=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonclass);
                final Button buttondrc=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttoncompdr);

                buttoncls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttondrc.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttondrc.setTextColor(Color.BLACK);

                        buttoncls.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttoncls.setTextColor(Color.WHITE);

                        String actname="Classifieds";
                        SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();

                        edit.putString("Actvname",actname);

                        edit.commit();
                        mCtx.startActivity(new Intent(mCtx,ClassifiedsActivity.class));
                    }
                });

                buttondrc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        buttoncls.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttoncls.setTextColor(Color.BLACK);

                        buttondrc.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttondrc.setTextColor(Color.WHITE);

                        String actname="Company Directory";
                        SharedPreferences pref = mCtx.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();

                        edit.putString("Actvname",actname);

                        edit.commit();

                        mCtx.startActivity(new Intent(mCtx,CmpDirectoryActivity.class));
                    }
                });
//                final Spinner spiner = (Spinner)mView.findViewById(R.id.spinner3);
//
//                String[] users = new String[]{
//                        "Classified Types...",
//                        "Classifieds",
//                        "Company Directory"
//
//                };
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                        mCtx,R.layout.spinneritems,users
//                );
//                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//                spiner.setAdapter(spinnerArrayAdapter);

//
//                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(spiner.getSelectedItem().toString().equals("Classifieds")) {
//                          Intent  intent31 = new Intent(mCtx, ClassifiedsActivity.class);
//                            mCtx.startActivity(intent31);
//                            dialogInterface.dismiss();
//                        }
//                        if(spiner.getSelectedItem().toString().equals("Company Directory")) {
//                           Intent intent32 = new Intent(mCtx, CompDirectoryActivity.class);
//                            mCtx.startActivity(intent32);
//                            dialogInterface.dismiss();
//                        }
//                    }
//                });

//
//                mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        dialogInterface.dismiss();
//                    }
//                });
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();

                dialog.getWindow().setDimAmount(0.7f);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                ImageView imageView=dialog.findViewById(tbs.thinkbiz.solutions.itshades.R.id.cancel);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }else if (position == 4) {

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mCtx);
                View mView = View.inflate(mCtx, tbs.thinkbiz.solutions.itshades.R.layout.solutionsdialog, null);

                final Button buttonprd=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonprdct);
                final Button buttonitcns=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonitcns);
                final Button buttonindsol=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonindsln);

                buttonprd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Products & Platforms";
                        String cat_id="1";
                        buttonitcns.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonitcns.setTextColor(Color.BLACK);
                        buttonindsol.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonindsol.setTextColor(Color.BLACK);

                        buttonprd.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonprd.setTextColor(Color.WHITE);

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,ProdAndPlatformActivity.class);
                        mCtx.startActivity(intent);
                        //mCtx.startActivity(new Intent(mCtx,ProdAndPlatformActivity.class));
                    }
                });

                buttonitcns.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="IT Consulting & Services";
                        String cat_id="2";
                        buttonprd.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonprd.setTextColor(Color.BLACK);
                        buttonindsol.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonindsol.setTextColor(Color.BLACK);

                        buttonitcns.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonitcns.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,ITConsltAndServActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,ITConsltAndServActivity.class));
                    }
                });

                buttonindsol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Industry Solutions";
                        String cat_id="3";

                        buttonitcns.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonitcns.setTextColor(Color.BLACK);
                        buttonprd.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonprd.setTextColor(Color.BLACK);

                        buttonindsol.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonindsol.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.commit();
                        Intent intent=new Intent(mCtx,IndSolutionsActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,IndSolutionsActivity.class));
                    }
                });
//                final Spinner spiner = (Spinner)mView.findViewById(R.id.spinner3);
//
//                String[] users = new String[]{
//                        "Classified Types...",
//                        "Classifieds",
//                        "Company Directory"
//
//                };
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                        mCtx,R.layout.spinneritems,users
//                );
//                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//                spiner.setAdapter(spinnerArrayAdapter);

//
//                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(spiner.getSelectedItem().toString().equals("Classifieds")) {
//                          Intent  intent31 = new Intent(mCtx, ClassifiedsActivity.class);
//                            mCtx.startActivity(intent31);
//                            dialogInterface.dismiss();
//                        }
//                        if(spiner.getSelectedItem().toString().equals("Company Directory")) {
//                           Intent intent32 = new Intent(mCtx, CompDirectoryActivity.class);
//                            mCtx.startActivity(intent32);
//                            dialogInterface.dismiss();
//                        }
//                    }
//                });

//
//                mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        dialogInterface.dismiss();
//                    }
//                });
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();

                dialog.getWindow().setDimAmount(0.7f);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                ImageView imageView=dialog.findViewById(tbs.thinkbiz.solutions.itshades.R.id.cancel);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


               //Intent intent4 = new Intent(mCtx, SolutionsActivity.class);
                //mCtx.startActivity(intent4);
            }else if (position == 5) {

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mCtx);
                View mView = View.inflate(mCtx, tbs.thinkbiz.solutions.itshades.R.layout.learningdevelopmntdialog, null);

                final Button buttonOTP=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonOTP);
                final Button buttonOT=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonOT);
                final Button buttonCRmT=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonCT);
                final Button buttonCrtf=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonCRTI);
                final Button buttonODT=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonODT);
//
                buttonOTP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Online Training Portals";
                        buttonOT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOT.setTextColor(Color.BLACK);
                        buttonCRmT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCRmT.setTextColor(Color.BLACK);
                        buttonCrtf.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCrtf.setTextColor(Color.BLACK);
                        buttonODT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonODT.setTextColor(Color.BLACK);

                        buttonOTP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonOTP.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);

                        edit.commit();
                        Intent intent=new Intent(mCtx,OnlineTranPortalActivity.class);
                        mCtx.startActivity(intent);
                       // mCtx.startActivity(new Intent(mCtx,OnlineTranPortalActivity.class));
                    }
                });

                buttonOT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname ="Online Training";
                        String cat_id="1";

                        buttonOTP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOTP.setTextColor(Color.BLACK);
                        buttonCRmT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCRmT.setTextColor(Color.BLACK);
                        buttonCrtf.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCrtf.setTextColor(Color.BLACK);
                        buttonODT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonODT.setTextColor(Color.BLACK);

                        buttonOT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonOT.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname );
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,OnlineTrainingActivity.class);
                        mCtx.startActivity(intent);

                       // mCtx.startActivity(new Intent(mCtx,OnlineTrainingActivity.class));
                    }
                });

                buttonCRmT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String actname="Classroom Training";
                        String cat_id="2";

                        buttonOTP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOTP.setTextColor(Color.BLACK);
                        buttonOT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOT.setTextColor(Color.BLACK);
                        buttonCrtf.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCrtf.setTextColor(Color.BLACK);
                        buttonODT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonODT.setTextColor(Color.BLACK);

                        buttonCRmT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonCRmT.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,ClassroomTraingActivity.class);
                        mCtx.startActivity(intent);

                       // mCtx.startActivity(new Intent(mCtx,ClassroomTraingActivity.class));
                    }
                });

                buttonCrtf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Certifications";
                        String cat_id="3";

                        buttonOTP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOTP.setTextColor(Color.BLACK);
                        buttonOT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOT.setTextColor(Color.BLACK);
                        buttonCRmT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCRmT.setTextColor(Color.BLACK);
                        buttonODT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonODT.setTextColor(Color.BLACK);

                        buttonCrtf.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonCrtf.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,CertificationsActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,CertificationsActivity.class));
                    }
                });

                buttonODT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="On Demand Training";
                        String cat_id="4";

                        buttonOTP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOTP.setTextColor(Color.BLACK);
                        buttonOT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOT.setTextColor(Color.BLACK);
                        buttonCRmT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCRmT.setTextColor(Color.BLACK);
                        buttonCrtf.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCrtf.setTextColor(Color.BLACK);

                        buttonODT.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonODT.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,OnDemandTrangActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,OnDemandTrangActivity.class));
                    }
                });
//                final Spinner spiner = (Spinner)mView.findViewById(R.id.spinner3);
//
//                String[] users = new String[]{
//                        "Classified Types...",
//                        "Classifieds",
//                        "Company Directory"
//
//                };
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                        mCtx,R.layout.spinneritems,users
//                );
//                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//                spiner.setAdapter(spinnerArrayAdapter);

//
//                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(spiner.getSelectedItem().toString().equals("Classifieds")) {
//                          Intent  intent31 = new Intent(mCtx, ClassifiedsActivity.class);
//                            mCtx.startActivity(intent31);
//                            dialogInterface.dismiss();
//                        }
//                        if(spiner.getSelectedItem().toString().equals("Company Directory")) {
//                           Intent intent32 = new Intent(mCtx, CompDirectoryActivity.class);
//                            mCtx.startActivity(intent32);
//                            dialogInterface.dismiss();
//                        }
//                    }
//                });

//
//                mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        dialogInterface.dismiss();
//                    }
//                });
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();

                dialog.getWindow().setDimAmount(0.7f);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                ImageView imageView=dialog.findViewById(tbs.thinkbiz.solutions.itshades.R.id.cancel);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

               //Intent intent5 = new Intent(mCtx, LearningActivity.class);
                //mCtx.startActivity(intent5);
            }else if (position == 6) {

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mCtx);
                View mView = View.inflate(mCtx, tbs.thinkbiz.solutions.itshades.R.layout.artifactsdialog, null);

                final Button buttonAR=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonAR);
                final Button buttonWP=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonWP);
                final Button buttonCSS=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonCSS);
//
                buttonAR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Analyst Reports";
                        String cat_id="1";

                        buttonWP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonWP.setTextColor(Color.BLACK);
                        buttonCSS.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCSS.setTextColor(Color.BLACK);

                        buttonAR.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonAR.setTextColor(Color.WHITE);
                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,AnalystReportActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,AnalystReportActivity.class));
                    }
                });

                buttonWP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="White Papers";
                        String cat_id="2";

                        buttonCSS.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonCSS.setTextColor(Color.BLACK);
                        buttonAR.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonAR.setTextColor(Color.BLACK);

                        buttonWP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonWP.setTextColor(Color.WHITE);

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,WhitePapersActivity.class);
                        mCtx.startActivity(intent);
                        //mCtx.startActivity(new Intent(mCtx,WhitePapersActivity.class));
                    }
                });

                buttonCSS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Customer Success Stories";
                        String cat_id="3";

                        buttonAR.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonAR.setTextColor(Color.BLACK);
                        buttonWP.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonWP.setTextColor(Color.BLACK);

                        buttonCSS.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonCSS.setTextColor(Color.WHITE);

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,CustSuccStoriesActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,CustSuccStoriesActivity.class));
                    }
                });
//                final Spinner spiner = (Spinner)mView.findViewById(R.id.spinner3);
//
//                String[] users = new String[]{
//                        "Classified Types...",
//                        "Classifieds",
//                        "Company Directory"
//
//                };
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                        mCtx,R.layout.spinneritems,users
//                );
//                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//                spiner.setAdapter(spinnerArrayAdapter);

//
//                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(spiner.getSelectedItem().toString().equals("Classifieds")) {
//                          Intent  intent31 = new Intent(mCtx, ClassifiedsActivity.class);
//                            mCtx.startActivity(intent31);
//                            dialogInterface.dismiss();
//                        }
//                        if(spiner.getSelectedItem().toString().equals("Company Directory")) {
//                           Intent intent32 = new Intent(mCtx, CompDirectoryActivity.class);
//                            mCtx.startActivity(intent32);
//                            dialogInterface.dismiss();
//                        }
//                    }
//                });

//
//                mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        dialogInterface.dismiss();
//                    }
//                });
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();

                dialog.getWindow().setDimAmount(0.7f);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                ImageView imageView=dialog.findViewById(tbs.thinkbiz.solutions.itshades.R.id.cancel);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

               //Intent intent6 = new Intent(mCtx, ArtifactsActivity.class);
                //mCtx.startActivity(intent6);
            }else if (position == 7) {

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mCtx);
                View mView = View.inflate(mCtx, tbs.thinkbiz.solutions.itshades.R.layout.eventsdialog, null);

                final Button buttonOE=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonOE);
                final Button buttonOnfrndsumt=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonCAS);
                final Button buttonWebnr=(Button)mView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.buttonWbnr);

                buttonOE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String actname="Online Events";
                        String cat_id="1";

                        buttonOnfrndsumt.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOnfrndsumt.setTextColor(Color.BLACK);
                        buttonWebnr.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonWebnr.setTextColor(Color.BLACK);

                        buttonOE.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonOE.setTextColor(Color.WHITE);

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,OnlineEventsActivity.class);
                        mCtx.startActivity(intent);
                        //mCtx.startActivity(new Intent(mCtx,OnlineEventsActivity.class));
                    }
                });

                buttonOnfrndsumt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String actname="Conferences & Summits";
                        String cat_id="2";
                        buttonWebnr.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonWebnr.setTextColor(Color.BLACK);
                        buttonOE.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOE.setTextColor(Color.BLACK);

                        buttonOnfrndsumt.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonOnfrndsumt.setTextColor(Color.WHITE);

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,ConfrncSummitsActivity.class);
                        mCtx.startActivity(intent);

                        //mCtx.startActivity(new Intent(mCtx,ConfrncSummitsActivity.class));
                    }
                });

                buttonWebnr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String actname="Webinar";
                        String cat_id="3";

                        buttonOE.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOE.setTextColor(Color.BLACK);
                        buttonOnfrndsumt.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.buttonalrt);
                        buttonOnfrndsumt.setTextColor(Color.BLACK);

                        buttonWebnr.setBackgroundResource(tbs.thinkbiz.solutions.itshades.R.drawable.clickbgclor);
                        buttonWebnr.setTextColor(Color.WHITE);

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("Actvname",actname);
                        edit.putString("CatId",cat_id );

                        edit.apply();
                        Intent intent=new Intent(mCtx,WebinarActivity.class);
                        mCtx.startActivity(intent);

                      //  mCtx.startActivity(new Intent(mCtx,WebinarActivity.class));
                    }
                });
//                final Spinner spiner = (Spinner)mView.findViewById(R.id.spinner3);
//
//                String[] users = new String[]{
//                        "Classified Types...",
//                        "Classifieds",
//                        "Company Directory"
//
//                };
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                        mCtx,R.layout.spinneritems,users
//                );
//                spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
//                spiner.setAdapter(spinnerArrayAdapter);

//
//                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(spiner.getSelectedItem().toString().equals("Classifieds")) {
//                          Intent  intent31 = new Intent(mCtx, ClassifiedsActivity.class);
//                            mCtx.startActivity(intent31);
//                            dialogInterface.dismiss();
//                        }
//                        if(spiner.getSelectedItem().toString().equals("Company Directory")) {
//                           Intent intent32 = new Intent(mCtx, CompDirectoryActivity.class);
//                            mCtx.startActivity(intent32);
//                            dialogInterface.dismiss();
//                        }
//                    }
//                });

//
//                mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        dialogInterface.dismiss();
//                    }
//                });
                mBuilder.setView(mView);
                final AlertDialog dialog=mBuilder.create();

                dialog.getWindow().setDimAmount(0.7f);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.show();
                ImageView imageView=dialog.findViewById(tbs.thinkbiz.solutions.itshades.R.id.cancel);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

               //Intent intent7 = new Intent(mCtx, EventsActivity.class);
                //mCtx.startActivity(intent7);
            }else if (position == 8) {
                Intent intent8 = new Intent(mCtx, CompReviewActivity.class);
                mCtx.startActivity(intent8);
            }
            else {
               Intent intent =  new Intent(mCtx, Main2Activity.class);
                mCtx.startActivity(intent);
            }
            //mCtx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView textViewTitle;
        ImageView imageView;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
           mCtx=itemView.getContext();
            textViewTitle = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.nameTextview);
            imageView = itemView.findViewById(tbs.thinkbiz.solutions.itshades.R.id.imageview);
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