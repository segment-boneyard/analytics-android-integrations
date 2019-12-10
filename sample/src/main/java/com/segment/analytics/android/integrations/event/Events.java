package com.segment.analytics.android.integrations.event;

import com.google.gson.annotations.SerializedName;


public class Events {
    @SerializedName("type")
    private String types;
    @SerializedName("name")
    private String name;
    @SerializedName("event")
    private String event;
    @SerializedName("userId")
    private String userId;
    @SerializedName("groupId")
    private String groupId;
    @SerializedName("previousId")
    private String previousId;
    @SerializedName("properties")
    private Properties properties;
    @SerializedName("traits")
    private Traits traits;


    public Events(String types, String name, String event, String userId, String groupId,
                  String previousId, Properties properties, Traits traits) {
        this.types = types;
        this.name = name;
        this.event = event;
        this.userId = userId;
        this.groupId = groupId;
        this.previousId = previousId;
        this.properties = properties;
        this.traits = traits;

    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPreviousId() {
        return previousId;
    }

    public void setPreviousId(String previousId) {
        this.previousId = previousId;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Traits getTraits() {
        return traits;
    }

    public void setTraits(Traits traits) {
        this.traits = traits;
    }
}
