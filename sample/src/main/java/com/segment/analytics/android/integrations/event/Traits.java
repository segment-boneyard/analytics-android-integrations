package com.segment.analytics.android.integrations.event;

import com.google.gson.annotations.SerializedName;

public class Traits {
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private int age;
    @SerializedName("industry")
    private String industry;
    @SerializedName("employees")
    private int employees;
    @SerializedName("plan")
    private String plan;


    public Traits(String email, String name, String gender, int age,
                  String industry, int employees, String plan) {
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.industry = industry;
        this.employees = employees;
        this.plan = plan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
