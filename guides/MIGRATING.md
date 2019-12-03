## Migrate a destination from an old repo to the monorepo

#### 1. Clone the destination you intend to migrate
```shell
git clone https://github.com/segment-integrations/analytics-android-integration-firebase
```
#### 2. In Mono-repo project 
Navigate to `File` => `New` => `Import Module...` open the file path in the `Source Directory` and rename the module e.g `firebase`

Mono-repo: `https://github.com/segmentio/analytics-android-integrations`

#### 3. Move the  destination into the integrations directory
``` java
.circleci/
.github/
integrations/
    amplitude/
    firebase/          <-- here
sampleapp/ 
README.md
LICENSE.md
etc
```
#### 4. Set the destination up with the project and sync
`project:settings.gradle` 
```groovy
include ':integrations:firebase'
```
#### 5. Remove the following from the destination
`gradle`, `.circleci` folders, `.gitignore` and if `.buildscript` and `github` folders in the module directory because these folders are already in the `project` level

```java
integrations/ 
    firebase/
        .buildscript/     <-- this
        .circleci/        <-- this
        github/           <-- this
        gradle/           <-- this
        src/ 
        build.gradle
        .gitignore        <-- this
        README.md
        etc
```
#### 6. Remove the promote gradle plugin in the destination because it has already been implemented in the project level 
`firebase:build.gradle` 
``` groovy
apply from: rootProject.file('gradle/promote.gradle')
```

#### 7. Add spotless in the destination for code formatting
`firebase:build.gradle` 
``` groovy
apply from: rootProject.file('spotless.gradle')
```
#### 8. Apply `dependencies.gradle` in the destination. The `dependencies.gradle` is used to manage all dependency versions
`firebase:build.gradle` 
``` groovy
apply from: rootProject.file('dependencies.gradle')
```
#### 9. Revamp the destination `build.gradle` to use depedencies.gradle
`firebase:build.gradle` 
``` groovy
apply from: rootProject.file('dependencies.gradle')
android {
    compileSdkVersion versions.compileSdkVersion 
    buildToolsVersion versions.buildTools
    defaultConfig {
        minSdkVersion versions.minSdkVersion
        targetSdkVersion versions.targetSdkVersion
    }
    ....
}
dependencies {
    api 'com.segment.analytics.android:analytics:' + versions.anayticsSdkVersion
    testImplementation 'org.mockito:mockito-core:' + versions.mockitoVersion
}
```
#### 10. Remove buildscripts  and dependencies {repositories} block in the destination build.gradle, because it has already been implemented in the project level 
`firebase:build.gradle` 
``` groovy
buildscript {             <--- start
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath 'com.android.tools.build:gradle:3.4.2'
  }
}                         <--- end

....
dependencies {
  repositories {          <--- start
    mavenCentral()
    ....
  }                       <--- end
  ....
}
```

#### 11. Finally Run test in terminal and apply spotless to format the code :rocket:
``` shell
./gradlew test 
./gradlew spotlessApply
```