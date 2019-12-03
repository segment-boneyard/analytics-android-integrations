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
---

### PR Template
#### 
**What does this PR do?**

**Are there breaking changes in this PR?**

**Has this been tested end-to-end? Please provide screenshots on how the fix now populates in the end tool. If not, what was done to test?**

**Any background context you want to provide?**

**Is there parity with the server-side/analytics.js integration (if applicable)?**

**Does this require a metadata change? If so, please link the PR from https://github.com/segmentio/destination-scripts.**


**What are the relevant tickets?**


**Link to CC ticket**


**List all the tests accounts you have used to make sure this change works**


**Helpful Docs**


**Version for this change**
