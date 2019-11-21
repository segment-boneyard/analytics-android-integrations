package com.segment.analytics.android.integrations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.segment.analytics.Analytics;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    String anonymousId = Analytics.with(this).getAnalyticsContext().traits().anonymousId();
    Toast.makeText(this, anonymousId, Toast.LENGTH_LONG).show();
  }
}
