package com.frantic.dummyproject;

/**
 * Created by Frantic on 2/20/2016.
 */
public class Seats {
    private String seat_no;
    private String seat_status;
    private int seat_price;

    public Seats(String seat_no, String seat_status, int seat_price) {
        this.seat_no = seat_no;
        this.seat_status = seat_status;
        this.seat_price = seat_price;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public String getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(String seat_status) {
        this.seat_status = seat_status;
    }

    public double getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(int seat_price) {
        this.seat_price = seat_price;
    }
}
