package com.segment.analytics.android.integrations;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.segment.analytics.Analytics;
import com.segment.analytics.android.integrations.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  String specText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    String anonymousId = Analytics.with(this).getAnalyticsContext().traits().anonymousId();
    Toast.makeText(this, anonymousId, Toast.LENGTH_LONG).show();

    SpecListFragment fragment = new SpecListFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.parentContainer, fragment).commit();

  }



}
