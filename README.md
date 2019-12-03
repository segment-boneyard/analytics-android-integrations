# analytics-android-integrations
Monorepo storing Segment's analytics Android integrations. You can find additoinal documentation for this repo in the `guides` directory.

## Migrating Destinations to the Monorepo
You can find more information on migrating a destination [here](./guides/MIGRATING.md).

## Setup Android local environment :memo:
#### 1. Requirements:
Android Studio  version 3+

Gradle version 5+

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

#### 1 Label: Ready to merge
- [x] Check if all tests pass
```
./gradlew test
```
- [x] Check if implementation works according to the PR descriptions
- [x] Check if there are breaking changes in this PR
- [x] Check if the new changes could potentially break anything in the future.
- [x] Code style check
```
./gradlew spotlessApply
```
- [x] Check if there are any structural or architectural changes 
- [x] Check for overall best practices
----
#### 2 Label: WIP
- [x] Check if implementation works according to the PR descriptions
- [x] Code style check
```
./gradlew spotlessApply
```
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
./gradlew spotlessApply
```
#### 2 You must run the tests, ensuring they all pass
```
./gradlew test
```
#### 3 Include a well detailed title and description 

### Ready to go :rocket:
