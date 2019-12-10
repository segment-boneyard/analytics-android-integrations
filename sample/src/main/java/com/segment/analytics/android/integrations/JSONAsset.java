package com.segment.analytics.android.integrations;

public class JSONAsset {

  static final String IDENTITY_JSON_DATA =
      "{\n"
          + "\"type\":\"identify\",\n"
          + "\"traits\":{\n"
          + "\"name\":\"Yoda\",\n"
          + "\"email\":\"yoda@example.org\",\n"
          + "\"gender\":\"male\",\n"
          + "\"age\":180,\n"
          + "\"plan\":\"enterprise\"\n"
          + "},\n"
          + "\"userId\":\"test-user-ru3j5q\"\n"
          + "}";

  static final String GROUP_JSON_DATA =
      "{\n"
          + "\"type\":\"group\",\n"
          + "\"groupId\":\"0e8c78ea9d97a7b8185e8632\",\n"
          + "\"traits\":{\n"
          + "\"name\":\"Initech\",\n"
          + "\"industry\":\"Technology\",\n"
          + "\"employees\":329,\n"
          + "\"plan\":\"enterprise\"\n"
          + "},\n"
          + "\"userId\":\"test-user-ru3j5q\"\n"
          + "}";

  static final String ALIAS_JSON_DATA =
      "{\n"
          + "\"type\":\"alias\",\n"
          + "\"previousId\":\"jen@email.com\",\n"
          + "\"userId\":\"test-user-ru3j5q\"\n"
          + "}";

  static final String TRACK_JSON_DATA =
      "{\n"
          + "\"type\":\"track\",\n"
          + "\"event\":\"Registered\",\n"
          + "\"properties\":{\n"
          + "\"title\":\"bag\",\n"
          + "\"sku\":\"13d31\",\n"
          + "\"revenue\":199.99\n"
          + "},\n"
          + "\"userId\":\"test-user-ru3j5q\"\n"
          + "}";

  static final String SCREEN_JSON_DATA =
      "{\n"
          + "\"type\":\"screen\",\n"
          + "\"name\":\"Home\",\n"
          + "\"properties\":{\n"
          + "\"category\":\"fashion\"\n"
          + "},\n"
          + "\"userId\":\"test-user-ru3j5q\"\n"
          + "}";

  static final String PAGE_JSON_DATA =
      "{\n"
          + "\"type\":\"page\",\n"
          + "\"name\":\"Home\",\n"
          + "\"properties\":{\n"
          + "\"title\":\"Welcome | Initech\",\n"
          + "\"url\":\"http://www.initech.com\"\n"
          + "},\n"
          + "\"userId\":\"test-user-ru3j5q\"\n"
          + "}";
}
