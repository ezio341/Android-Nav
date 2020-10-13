package com.learn.navigation.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Auth implements Parcelable {
    private String uname, pass, email, phone;

    public Auth(String uname, String pass, String email, String phone) {
        this.uname = uname;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
    }

    public Auth() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uname);
        dest.writeString(this.pass);
        dest.writeString(this.email);
        dest.writeString(this.phone);
    }

    protected Auth(Parcel in) {
        this.uname = in.readString();
        this.pass = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
    }

    public static final Parcelable.Creator<Auth> CREATOR = new Parcelable.Creator<Auth>() {
        @Override
        public Auth createFromParcel(Parcel source) {
            return new Auth(source);
        }

        @Override
        public Auth[] newArray(int size) {
            return new Auth[size];
        }
    };

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
