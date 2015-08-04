package com.example.kyawzinlatt94.realmObjects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by kyawzinlatt94 on 7/29/15.
 */
public class SearchHistory extends RealmObject {
    @PrimaryKey
    private int id;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
