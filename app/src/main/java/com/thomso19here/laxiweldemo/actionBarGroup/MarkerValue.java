package com.thomso19here.laxiweldemo.actionBarGroup;

import com.google.android.gms.maps.model.LatLng;

public class MarkerValue {
    private LatLng latLng;
    private String title;

    public MarkerValue(LatLng latLng, String title) {
        this.latLng = latLng;
        this.title = title;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}