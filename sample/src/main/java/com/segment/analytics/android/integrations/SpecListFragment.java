package com.segment.analytics.android.integrations;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.segment.analytics.android.integrations.databinding.FragmentSpecListBinding;
import java.util.Arrays;
import java.util.List;

/** A simple {@link Fragment} subclass. */
public class SpecListFragment extends Fragment {

  private FragmentSpecListBinding binding;

  public SpecListFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_spec_list, container, false);
    setupSpecsUI();
    trackAppLifeCycle();
    binding.gotoDocs.setOnClickListener(v -> gotoDocumentation());
    return binding.getRoot();
  }

  private void setupSpecsUI() {
    binding.specList.hasFixedSize();
    SpecClickListener specClickListener =
        string -> {
          SpecDetailFragment specDetailFragment = SpecDetailFragment.getSpec(string);
          getFragmentManager()
              .beginTransaction()
              .replace(R.id.parentContainer, specDetailFragment)
              .addToBackStack("")
              .commit();
        };
    String[] specArray = getResources().getStringArray(R.array.spec_list);
    List<String> speclist = Arrays.asList(specArray);
    SpecListAdapter specListAdapter = new SpecListAdapter(speclist, specClickListener);
    binding.specList.setAdapter(specListAdapter);
    specListAdapter.setSpecList(speclist);
  }

  private void trackAppLifeCycle() {
    binding.trackAppLifecycle.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          SharedPreferences.Editor editor =
              getActivity()
                  .getSharedPreferences(getString(R.string.PACKAGE_NAME), MODE_PRIVATE)
                  .edit();
          if (isChecked) {
            editor.putBoolean("trackLifeCycle", true);
            editor.apply();
          } else {
            editor.putBoolean("trackLifeCycle", false);
            editor.apply();
          }
        });
    SharedPreferences prefs =
        getContext().getSharedPreferences(getString(R.string.PACKAGE_NAME), MODE_PRIVATE);
    binding.trackAppLifecycle.setChecked(prefs.getBoolean("trackLifeCycle", false));
  }

  private void gotoDocumentation() {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
    browserIntent.setData(Uri.parse("https://segment.com/docs/connections/spec/"));
    startActivity(browserIntent);
  }
}
