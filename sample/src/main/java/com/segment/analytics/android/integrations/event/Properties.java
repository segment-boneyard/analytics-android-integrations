package com.segment.analytics.android.integrations.event;

import com.google.gson.annotations.SerializedName;

public class Properties {
  @SerializedName("title")
  private String title;

  @SerializedName("url")
  private String url;

  @SerializedName("sku")
  private String sku;

  @SerializedName("price")
  private double price;

  @SerializedName("id")
  private String id;

  @SerializedName("revenue")
  private double revenue;

  @SerializedName("category")
  private String  category;

    public Properties(String title, String url, String sku, double price,
                      String id, double revenue, String category) {
        this.title = title;
        this.url = url;
        this.sku = sku;
        this.price = price;
        this.id = id;
        this.revenue = revenue;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
