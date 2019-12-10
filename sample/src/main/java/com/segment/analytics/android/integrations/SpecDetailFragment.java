package com.segment.analytics.android.integrations;

import static com.segment.analytics.android.integrations.JSONAsset.ALIAS_JSON_DATA;
import static com.segment.analytics.android.integrations.JSONAsset.GROUP_JSON_DATA;
import static com.segment.analytics.android.integrations.JSONAsset.IDENTITY_JSON_DATA;
import static com.segment.analytics.android.integrations.JSONAsset.PAGE_JSON_DATA;
import static com.segment.analytics.android.integrations.JSONAsset.SCREEN_JSON_DATA;
import static com.segment.analytics.android.integrations.JSONAsset.TRACK_JSON_DATA;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.android.integrations.databinding.FragmentSpecDetailBinding;
import com.segment.analytics.android.integrations.event.Events;

/** A simple {@link Fragment} subclass. */
public class SpecDetailFragment extends Fragment {

  FragmentSpecDetailBinding binding;

  public static SpecDetailFragment getSpec(String spec_name) {
    SpecDetailFragment fragment = new SpecDetailFragment();
    Bundle args = new Bundle();
    args.putString("spec_string", spec_name);
    fragment.setArguments(args);
    return fragment;
  }

  public SpecDetailFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_spec_detail, container, false);
    setUpUi();
    return binding.getRoot();
  }

  private void setUpUi() {
    binding.specTitle.setText(getSpecTitle());
    binding.gotoDocs.setText("Go to " + getSpecTitle() + " documentations");
    binding.gotoDocs.setOnClickListener(v -> gotoSpecDocumentation(getSpecTitle()));
    displayJson(getSpecTitle());

    binding.sendEventButton.setOnClickListener(
        v -> {
          String getJsonEditText = binding.eventEditText.getText().toString();
          if (!getJsonEditText.isEmpty()) {
            sendEvent(getSpecTitle(), getJsonEditText);
          }
        });
  }

  private void sendEvent(String spec, String jSonText) {
    Gson gson = new Gson();
    Events events = gson.fromJson(jSonText, Events.class);
    callSpecEvent(spec, events);
  }

  private void callSpecEvent(String spec, Events events) {
    switch (spec) {
      case "page":
        page();
        break;
      case "screen":
        screen(events);
        break;
      case "track":
        track(events);
        break;
      case "alias":
        alias(events);
        break;
      case "group":
        group(events);
        break;
      case "identify":
        identify(events);
        break;
    }
  }

  private void identify(Events events) {
    Analytics.with(getContext())
        .identify(
            new Traits()
                .putName(events.getTraits().getName())
                .putEmail(events.getTraits().getEmail())
                .putGender(events.getTraits().getGender())
                .putAge(events.getTraits().getAge()));
  }

  private void track(Events events) {
    Analytics.with(getContext())
        .track(
            events.getEvent(),
            new Properties()
                .putTitle(events.getProperties().getTitle())
                .putSku(events.getProperties().getSku())
                .putRevenue(events.getProperties().getRevenue()));
  }

  private void screen(Events event) {
    Analytics.with(getContext())
        .screen(event.getName(), new Properties().putCategory(event.getProperties().getCategory()));
  }

  private void page() {}

  private void alias(Events events) {
    Analytics.with(getContext()).alias(events.getUserId());
  }

  private void group(Events event) {
    Analytics.with(getActivity())
        .group(
            event.getGroupId(),
            new Traits()
                .putEmployees(event.getTraits().getEmployees())
                .putIndustry(event.getTraits().getIndustry()));
  }

  private void displayJson(String spec) {
    switch (spec) {
      case "page":
        binding.eventEditText.setText(PAGE_JSON_DATA);
        break;
      case "screen":
        binding.eventEditText.setText(SCREEN_JSON_DATA);
        break;
      case "track":
        binding.eventEditText.setText(TRACK_JSON_DATA);
        break;
      case "alias":
        binding.eventEditText.setText(ALIAS_JSON_DATA);
        break;
      case "group":
        binding.eventEditText.setText(GROUP_JSON_DATA);
        break;
      case "identify":
        binding.eventEditText.setText(IDENTITY_JSON_DATA);
        break;
    }
  }

  private String getSpecTitle() {
    if (getArguments().getString("spec_string") != null) {
      return getArguments().getString("spec_string");
    }
    return null;
  }

  private void gotoSpecDocumentation(String spec) {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
    browserIntent.setData(Uri.parse("https://segment.com/docs/connections/spec/" + spec + "/"));
    startActivity(browserIntent);
  }
}
