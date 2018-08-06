package com.example.user.itshaeds.ITBytes;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.user.itshaeds.R;

import java.util.ArrayList;
import java.util.List;

public class ITBytesActivity extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itbytes);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.itbytesbar);
        View view =getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        List<ITBytesModel> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(ITBytesActivity.this, 2);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        ITBytesAdapter rcAdapter = new ITBytesAdapter(ITBytesActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

    }

    private List<ITBytesModel> getAllItemList(){

        List<ITBytesModel> allItems = new ArrayList<ITBytesModel>();
        allItems.add(new ITBytesModel("July 2018", "First-Edition"));
        allItems.add(new ITBytesModel("July 2018", "Second-Edition"));
        allItems.add(new ITBytesModel("June 2018", "First-Edition"));
        allItems.add(new ITBytesModel("June 2018", "Second-Edition"));
        allItems.add(new ITBytesModel("May 2018", "First-Edition"));
        allItems.add(new ITBytesModel("May 2018", "Second-Edition"));
        allItems.add(new ITBytesModel("Previous", "Editions"));


        return allItems;
    }
}
