package com.example.carrental.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars")
public class Car  implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "tag")
    private String licenseTag;
    @ColumnInfo(name = "available")
    private int available;

    //for the database
    public Car(String name, double price, int id, String licenseTag, int available) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.licenseTag = licenseTag;
        this.available = available;
    }

    // for the user
    @Ignore
    public Car(String name, double price, String licenseTag, int available) {
        this.name = name;
        this.price = price;
        this.licenseTag = licenseTag;
        this.available = available;
    }

    protected Car(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readDouble();
        licenseTag = in.readString();
        available = in.readInt();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLicenseTag() {
        return licenseTag;
    }

    public void setLicenseTag(String licenseTag) {
        this.licenseTag = licenseTag;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailable(){return available;};

    public int getId() {return id;}

    public String isAvailable(){
        return available == 1 ? "YES":"NO";
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", licenseTag='" + licenseTag + '\'' +
                ", available=" + isAvailable()+
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(licenseTag);
        dest.writeInt(available);
    }
}
