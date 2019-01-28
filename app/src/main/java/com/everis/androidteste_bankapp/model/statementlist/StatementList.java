package com.everis.androidteste_bankapp.model.statementlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatementList {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("value")
    @Expose
    private String value;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}