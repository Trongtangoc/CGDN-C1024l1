package com.codegym.demo.model;

public class RentRoom {
    private int id;
    private String tenntt_name;
    private String phoneNumber;
    private String startDate;
    private int paymentTypeId;
    private String paymentTypeName;
    private String note;
    public RentRoom() {

    }

    public RentRoom(int id, String tenntt_name, String phoneNumber, String startDate, int paymentTypeId, String paymentTypeName, String note) {
        this.id = id;
        this.tenntt_name = tenntt_name;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.paymentTypeId = paymentTypeId;
        this.paymentTypeName = paymentTypeName;
        this.note = note;

    }

    public RentRoom(int id, String tenntt_name, String phoneNumber, String startDate, int paymentTypeId, String note) {
        this.id = id;
        this.tenntt_name = tenntt_name;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.paymentTypeId = paymentTypeId;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenntt_name() {
        return tenntt_name;
    }

    public void setTenntt_name(String tenntt_name) {
        this.tenntt_name = tenntt_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
  public String toString() {
        return "RentRoom [id=" + id
                + ", tenntt_name=" + tenntt_name
                + ", phoneNumber=" + phoneNumber
                + ", startDate=" + startDate
                + ", paymentTypeId=" + paymentTypeId
                + ", paymentTypeName=" + paymentTypeName
                + ", note=" + note + "]";
    }

}
