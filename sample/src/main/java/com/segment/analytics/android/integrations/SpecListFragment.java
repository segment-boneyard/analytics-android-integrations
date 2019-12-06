package com.segment.analytics.android.integrations;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.segment.analytics.Analytics;
import com.segment.analytics.android.integrations.databinding.FragmentSpecListBinding;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpecListFragment extends Fragment {

    private FragmentSpecListBinding binding;
    String specText;

    public SpecListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_spec_list, container, false);
        setupUI();
        return binding.getRoot();
    }

    private void setupUI(){
        binding.specList.hasFixedSize();
        SpecClickListener specClickListener = string -> {};
        String [] specArray = getResources().getStringArray(R.array.spec_list);
        List<String> speclist = Arrays.asList(specArray);
        SpecListAdapter specListAdapter = new SpecListAdapter(speclist,specClickListener);
        binding.specList.setAdapter(specListAdapter);
        specListAdapter.setSpecList(speclist);
    }

    private void trackAppLifeCycle(){
        if(binding.trackAppLifecycle.isChecked()){
            //todo
        }
    }

    private void gotoDocumentation(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(""));
        startActivity(browserIntent);
    }
}
