package com.segment.analytics.android.integrations;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.segment.analytics.Analytics;
public class SampleApp extends Application {

  // https://segment.com/segment-engineering/sources/android-test/settings/keys
  private static final String ANALYTICS_WRITE_KEY = "zHGrqk0zY6eV7V6E74VsGZHykfXisd91";

  @Override
  public void onCreate() {
    super.onCreate();
    SharedPreferences prefs = this.getSharedPreferences(getString(R.string.PACKAGE_NAME), MODE_PRIVATE);
    boolean trackLifeCycle = prefs.getBoolean("trackLifeCycle",false);
    Log.d("trackLifeCycle",String.valueOf(trackLifeCycle));
    // Initialize a new instance of the Analytics client.
      Analytics.Builder builder =
        new Analytics.Builder(this, ANALYTICS_WRITE_KEY)
            .trackAttributionInformation()
            .recordScreenViews();

   if(trackLifeCycle){
     builder.trackApplicationLifecycleEvents();
   }

    // Set the initialized instance as a globally accessible instance.
    Analytics.setSingletonInstance(builder.build());

  }

}
