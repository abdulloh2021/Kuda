package com.kuda.model.obj;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseLoginObj implements Serializable, Parcelable {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataLogin data;
    @SerializedName("meta")
    @Expose
    private MetaLogin meta;
    public final static Creator<ResponseLoginObj> CREATOR = new Creator<ResponseLoginObj>() {

        @SuppressWarnings({
            "unchecked"
        })
        public ResponseLoginObj createFromParcel(android.os.Parcel in) {
            return new ResponseLoginObj(in);
        }

        public ResponseLoginObj[] newArray(int size) {
            return (new ResponseLoginObj[size]);
        }

    }
        ;
    private final static long serialVersionUID = -5570613763590497569L;

    protected ResponseLoginObj(android.os.Parcel in) {
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((DataLogin) in.readValue((DataLogin.class.getClassLoader())));
        this.meta = ((MetaLogin) in.readValue((MetaLogin.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseLoginObj() {
    }

    /**
     *
     * @param data
     * @param meta
     * @param message
     */
    public ResponseLoginObj(String message, DataLogin data, MetaLogin meta) {
        super();
        this.message = message;
        this.data = data;
        this.meta = meta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLogin getData() {
        return data;
    }

    public void setData(DataLogin data) {
        this.data = data;
    }

    public MetaLogin getMeta() {
        return meta;
    }

    public void setMeta(MetaLogin meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponseLoginObj.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        sb.append("meta");
        sb.append('=');
        sb.append(((this.meta == null)?"<null>":this.meta));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(message);
        dest.writeValue(data);
        dest.writeValue(meta);
    }

    public int describeContents() {
        return  0;
    }

}
