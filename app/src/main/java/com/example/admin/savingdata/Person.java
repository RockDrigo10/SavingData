package com.example.admin.savingdata;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 8/3/2017.
 */

public class Person implements Parcelable {
    String name;
    String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    protected Person(Parcel in) {
        name = in.readString();
        gender = in.readString();
    }
    /*reads the parcel after receiving the object in the other end*/
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(gender);
    }
}

