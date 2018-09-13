package tbs.thinkbiz.solutions.itshades.CompnyDrctry;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import tbs.thinkbiz.solutions.itshades.R;
import tbs.thinkbiz.solutions.itshades.RecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27-Jul-18.
 */

public class CompanyNameAdapter extends RecyclerView.Adapter<CompanyNameAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<CompnyNameModel> productList;

    public CompanyNameAdapter(Context mCtx, List<CompnyNameModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public CompanyNameAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.compdrlayout1, null);
        return new CompanyNameAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompanyNameAdapter.ProductViewHolder holder, int position) {
        final CompnyNameModel product = productList.get(position);

        final String sitename = product.getSiteName();
        final String desc = product.getDescr();
        final String imageUrl = product.getSitelogo();


        holder.Compname.setText(sitename);
        holder.textViewdesc.setText(desc);

        holder.buttonSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {

                String siteurl=product.getSiteurl();

                Intent browserIntent = new Intent( Intent.ACTION_VIEW, Uri.parse((siteurl)));
                v.getContext().startActivity(browserIntent);
            }
        });

        holder.buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {

                String cntrcode=product.getCntryCode();
                String number=product.getNumber();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                intent.setData(Uri.parse("tel:" + "+"+cntrcode+number));
                if (ActivityCompat.checkSelfPermission(mCtx, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
                 v.getContext(). startActivity(intent);
            }
        });

        holder.buttonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {

                String mailid=product.getMailID();

                Intent emailIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"));
                PackageManager pm = mCtx.getPackageManager();

                List<ResolveInfo> resInfo = pm.queryIntentActivities(emailIntent, 0);
                if (resInfo.size() > 0) {
                    ResolveInfo ri = resInfo.get(0);
                    // First create an intent with only the package name of the first registered email app
                    // and build a picked based on it
                    Intent intentChooser = pm.getLaunchIntentForPackage(ri.activityInfo.packageName);
                    Intent openInChooser =
                            Intent.createChooser(intentChooser,mailid);

                    // Then create a list of LabeledIntent for the rest of the registered email apps
                    List<LabeledIntent> intentList = new ArrayList<LabeledIntent>();
                    for (int i = 1; i < resInfo.size(); i++) {
                        // Extract the label and repackage it in a LabeledIntent
                        ri = resInfo.get(i);
                        String packageName = ri.activityInfo.packageName;
                        Intent intent = pm.getLaunchIntentForPackage(packageName);
                        intentList.add(new LabeledIntent(intent, packageName, ri.loadLabel(pm), ri.icon));
                    }

                    LabeledIntent[] extraIntents = intentList.toArray(new LabeledIntent[intentList.size()]);
                    // Add the rest of the email apps to the picker selection
                    openInChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);
                    v.getContext().startActivity(openInChooser);
                }

//                Intent browserIntent = new Intent( Intent.ACTION_SENDTO, Uri.parse((mailid)));
//                v.getContext().startActivity(browserIntent);

            }
        });


        Glide.with(mCtx)
                .load(imageUrl)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mImageViewsite);

        holder.textViewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String actname=product.getSiteName().toString();
                String cntrcode=product.getCntryCode();
                String number=product.getNumber();
                String website=product.getSiteurl();
                String image=product.getSitelogo();
                String mailid=product.getMailID();

                SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();

                edit.putString("sitename",sitename);
                edit.putString("phone","+"+cntrcode+number);
                edit.putString("website",website);
                edit.putString("desc",desc);
                edit.putString("image",image);
                edit.putString("mailid",mailid);

                edit.putString("Actvname",actname);

                edit.commit();
                Intent intent = new Intent(v.getContext(), CmpProfileActivity.class);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView Compname,textViewdesc ,textViewmore;
        public ImageView mImageViewsite;
        public Button buttonSite;
        public Button buttonMail;
        public Button buttonCall;

        private RecyclerViewItemClickListener itemClickListener;

        public ProductViewHolder(View itemView) {
            super(itemView);
            mCtx=itemView.getContext();
            Compname = itemView.findViewById(R.id.compname);
            textViewdesc = itemView.findViewById(R.id.companydetails);
            textViewmore = itemView.findViewById(R.id.compsite);
            mImageViewsite = itemView.findViewById(R.id.compid);
            buttonSite=(Button) itemView.findViewById(R.id.websitebutton);
            buttonMail=(Button) itemView.findViewById(R.id.emailbutton);
            buttonCall=(Button) itemView.findViewById(R.id.callbutton);

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

