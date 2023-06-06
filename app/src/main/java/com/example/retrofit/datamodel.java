package com.example.retrofit;

public class datamodel {
    private String url, title;
    private  String ups;

    public datamodel(String url, String title, String ups) {
        this.url = url;
        this.title = title;
        this.ups = ups;

    }
     public datamodel(){

     }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }
}
