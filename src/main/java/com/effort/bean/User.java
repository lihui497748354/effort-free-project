package com.effort.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/21.
 */
public class User implements Serializable {

    private String UId;
    private String UName;
    private Integer Uage;

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public Integer getUage() {
        return Uage;
    }

    public void setUage(Integer uage) {
        Uage = uage;
    }

    @Override
    public String toString() {
        return "User [id=" + UId + ", userName=" + UName + ", age=" + Uage + "]";
    }
}
