package com.ek.wall.models;

/**
 * Created by Hitesh on 12/27/2016.
 */

public class ServerData {
    String message;
    String type;
    String url;

    public ServerData() {
    }

    public ServerData(String message, String type, String url) {
        this.message = message;
        this.type = type;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ServerData{" +
                "message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
