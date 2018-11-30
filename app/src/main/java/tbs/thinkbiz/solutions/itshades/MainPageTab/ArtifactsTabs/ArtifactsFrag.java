package tbs.thinkbiz.solutions.itshades.MainPageTab.ArtifactsTabs;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.CRTrainingFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.CertificationsFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.L_AND_DFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.OTPortalsFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.OnDTrainingFrag;
import tbs.thinkbiz.solutions.itshades.MainPageTab.L_n_DTabs.OnlineTrainingFrag;
import tbs.thinkbiz.solutions.itshades.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtifactsFrag extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public ArtifactsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artifacts, container, false);

        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(R.color.colorBlack, R.color.colorBlack);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new AnalyReportFrag(), "Analyst Reports");
        adapter.addFragment(new WhtPapersFrag(), "White Papers");
        adapter.addFragment(new CSStoriesFrag(), "Customer Success Stories");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
