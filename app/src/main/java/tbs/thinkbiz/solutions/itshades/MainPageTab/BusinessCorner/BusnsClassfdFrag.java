package tbs.thinkbiz.solutions.itshades.MainPageTab.BusinessCorner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tbs.thinkbiz.solutions.itshades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusnsClassfdFrag extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spiner1,spinner2;

    public BusnsClassfdFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=  inflater.inflate(R.layout.fragment_busns_classfd, container, false);

        spiner1 = (Spinner)rootView.findViewById(R.id.spinner3);
        spinner2 = (Spinner)rootView.findViewById(R.id.spinner4);
        spiner1.setOnItemSelectedListener(this);

        String[] users = new String[]{
                "--Select Classified Types--",
                "Offerings",
                "Promotions",
                "Other"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getActivity(),R.layout.spinneritems,users
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinneritems);
        spiner1.setAdapter(spinnerArrayAdapter);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sp1= String.valueOf(spiner1.getSelectedItem());

        if (sp1.contentEquals("Offerings")){
            spinner2.setVisibility(View.VISIBLE);
            List<String> list = new ArrayList<String>();
            list.add("IT Services");
            list.add("IT Projects");
            list.add("Platforms");
            list.add("Applications");
            list.add("Software");
            list.add("Hardware");
            list.add("Training");
            list.add("Marketing");
            list.add("Content Writing");
            list.add("Recruitment");
            list.add("Immigration");
            list.add("Event");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        else {
            spinner2.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
