package com.segment.analytics.android.integrations;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.segment.analytics.android.integrations.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    getSupportActionBar().setTitle("Sample");
    SpecListFragment fragment = new SpecListFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.parentContainer, fragment).commit();
  }



}
