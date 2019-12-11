#### 1 How to set up Sample App
- Add Analytics Dependency to `build.gradle`

```groovy
implementation 'com.segment.analytics.android:analytics:4.+'
```
- Initialize the Client
We recommend initializing the client in your Application subclass `Application` subclass
```java
// Initialize a new instance of the Analytics client.
Analytics.Builder builder =
        new Analytics.Builder(this, ANALYTICS_WRITE_KEY)
            ....
            .build();

// Set the initialized instance as a globally accessible instance.
Analytics.setSingletonInstance(analytics);
```
- Add Internet Permissions in the `manifest.xml`
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```
#### Sending First Track Call
Track call records any actions you perform
```java
// Safely call Analytics.with(context) from anywhere within your app!
Analytics.with(context).track("Application Started");

//Track Product viewed, along with any properties 
Analytics.with(context).track("Product Viewed", new Properties().putValue("name", "Moto 360"))
```
#### How to add and configure a Destination
To start sending data to Destination Analytics from your Android project, Do the following:
- Add Destinations Dependency to `build.gradle`
   
```groovy
implementation 'com.segment.analytics.android.integrations:mixpanel:+'
```
- Configure the destination
```java
Analytics.Builder builder = new Analytics.Builder(this, ANALYTICS_WRITE_KEY)
            .use(MixpanelIntegration.FACTORY)
            .build();
```
#### How to add and configure a Middleware
Middlewares are a powerful mechanism that can augment the events collected by the SDK. A middleware is a simple function that is invoked by the Segment SDK and can be used to monitor, modify or reject events.
```java
Analytics analytics = new Analytics.Builder(getApplicationContext(), ANALYTICS_WRITE_KEY)
    .middleware(new Middleware() {
      @Override
      public void intercept(Chain chain) {
        // Get the original payload.
        BasePayload payload = chain.payload();

        // Set the device year class on the context object.
        int year = YearClass.get(getApplicationContext());
        Map<String, Object> context = new LinkedHashMap<>(payload.context());
        context.put("device_year_class", year);

        // Build our new payload.
        BasePayload newPayload = payload.toBuilder()
            .context(context)
            .build();

        // Continue with the new payload.
        chain.proceed(newPayload);
      }
    })
    .build();
```
#### How to submit a change for this app
- You must run spotless for code formatting before committing
```
./gradlew spotlessApply
```
- You must run the tests, ensuring they all pass
```
./gradlew test
```
- Include a well detailed title and description on the PR
:rocket:
