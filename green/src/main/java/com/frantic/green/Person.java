package com.frantic.green;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Frantic on 5/3/2016.
 */
public class Person implements Parcelable {

    String firstname;
    String lastname;
    String occupation;

    public Person(String firstname, String lastname, String occupation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.occupation = occupation;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    protected Person(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        occupation = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(occupation);
    }
}
