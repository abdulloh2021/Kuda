package com.kuda.model.obj;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MetaLogin implements Serializable, Parcelable {

    @SerializedName("token")
    @Expose
    private String token;
    public final static Creator<MetaLogin> CREATOR = new Creator<MetaLogin>() {

        @SuppressWarnings({
            "unchecked"
        })
        public MetaLogin createFromParcel(android.os.Parcel in) {
            return new MetaLogin(in);
        }

        public MetaLogin[] newArray(int size) {
            return (new MetaLogin[size]);
        }

    }
        ;
    private final static long serialVersionUID = 9076008448116181014L;

    protected MetaLogin(android.os.Parcel in) {
        this.token = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MetaLogin() {
    }

    /**
     *
     * @param token
     */
    public MetaLogin(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MetaLogin.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("token");
        sb.append('=');
        sb.append(((this.token == null)?"<null>":this.token));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(token);
    }

    public int describeContents() {
        return  0;
    }
}
