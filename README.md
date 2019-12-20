# analytics-android-integrations

[![CircleCI](https://circleci.com/gh/segmentio/analytics-android-integrations/tree/master.svg?style=svg)](https://circleci.com/gh/segmentio/analytics-android-integrations/tree/master)

Monorepo storing Segment's analytics Android integrations. You can find additional documentation for this repo in the `guides` directory.

## Usage
You can open the root project on Android Studio. All integrations are included by default.

### Linter and formatter
We use [Spotless](https://github.com/diffplug/spotless) and [Android's linter](https://developer.android.com/studio/write/lint) to format our code, run:
```bash
$ ./gradlew lint spotlessCheck // Linter
$ ./gradlew lintFix spotlessApply // Formatter
```

### Tests
You can run all the tests using:
```bash
$ ./gradlew test [--rerun-tasks]
```

### Build
You are required to sign your builds. To set up the signature, you need to export the following environment variables:
```
SIGNATURE_KEY_ID=<Key id>
SIGNATURE_SECRET_FILE=<Path where the key lives>
SIGNATURE_PASSWORD=<Password>
```

You can add these to the Android Studio configuration, or in the terminal. For more information see [here](https://docs.gradle.org/current/userguide/signing_plugin.html).

When that's ready, you can run the build command:
```bash
$ ./gradlew build jarRelease
```

### Release
You can release SNAPSHOTS (with your own credentials) running:
```bash
$ ./gradlew uploadArchives
```

For releasing production versions, please check our Segment's internal documentation.

## Migrating Destinations to the Monorepo
You can find more information on migrating a destination [here](./guides/MIGRATING.md).

## Setup Android local environment :memo:
#### 1. Requirements:
Android Studio  version 3+
Gradle version 6+

#### 2. Clone the repo
```shell
git clone https://github.com/segmentio/analytics-android-integrations.git
```

#### 3. Open the project with Android Studio 

 Click on `File` => `Open` on the toolbar menu, then select the project and `Open`

#### 4. Run the test

Click `Terminal` on the bottom tab to open the terminal 
```shell
./gradlew test
```
#### 5. Run the sample app

Select sample module on the top toolbar menu drop-down:
<img width="734" alt="Screenshot 2019-11-26 at 10 19 52" src="https://user-images.githubusercontent.com/20865566/69715500-a2628e80-1108-11ea-8d27-52297b11d9a8.png">
and click run

## Semantic Versioning

Version X.Y.Z
#### 1 Pre-release versions
Version `1.0.0-alpha.1`: is the pre-official release of the integration SDK. Here the SDK is still being test run

#### 2 Initial Release
Version `1.0.0`: is initial official stable release of the integration SDK going into production

#### 3 Patch Release
Version `1.0.Z`: is the release when a bug is fixed in the integration SDK, `Z` must be incremented. i.e `1.0.1`

#### 4 Minor Version 
Version `1.Y.0`: is the release when a backwards compatible feature is introduced to the integration SDK. `Y` must be incremented and `patch` version number must be reset to 0. i.e `1.1.0`

#### 5 Major Version 
Version `X.0.0`: is the release when a backwards incompatible change is introduced to the integration SDK. `X` must  be incremented while the `minor` and `patch` version numbers must be reset to 0. i.e  `2.0.0`

### Before Submitting a PR
**Important** PRs from non-Segment employees that change circleci or buildkite configuration (CI) will be
rejected automatically. Do not change the CI configuration.

- [x] Run linter and formatter
```bash
$ ./gradle lint spotlessCheck
$ ./gradle lintFix spotlessApply
```

- [x] Check if all tests pass
```bash
$ ./gradlew test
```
- [x] Check if implementation works according to the PR descriptions
- [x] Check if there are breaking changes in this PR
- [x] Check if the new changes could potentially break anything in the future.
- [x] Check if there are any structural or architectural changes
- [x] Check for overall best practices

## How to submit a PR 

### Commit Process
#### 1 Branches should include ticket number e.g DAND-6-TASK-NAME
#### 2 Commits should include ticket number and a verb for action e.g DAND-6-Fix - or DAND-6-Add or DAND-6-Update
---
### Before Submitting PR Requirements
#### 1 You must run spotless for code formatting before committing
```
./gradlew lintFix spotlessApply
```
#### 2 You must run the tests, ensuring they all pass
```
./gradlew test
```
#### 3 Include a well detailed title and description 

### Ready to go :rocket:

## How to review a PR
Here's a checklist of what to look for when reviewing a PR:
- [x] No changes have been made to `.circleci`.
- [x] No changes have been made to `.buildkite`.
- [x] CircleCI SaaS has completed successfully.
- [x] Buildkite CI has completed successfully (only for non-forked repos).
- [x] There is *enough* testing coverage for the changes.
- [x] If the change is updating an integration's SDK, the Changelog link is included in the description of the PR.
- [x] Big changes are split on multiple commits.
- [x] The version has changed following SemVer for functional changes.

If any of this checks fail, the PR will be rejected.