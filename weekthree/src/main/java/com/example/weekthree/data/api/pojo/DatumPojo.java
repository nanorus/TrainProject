
package com.example.weekthree.data.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumPojo {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("from_city")
    @Expose
    private FromCityPojo fromCity;
    @SerializedName("from_date")
    @Expose
    private String fromDate;
    @SerializedName("from_time")
    @Expose
    private String fromTime;
    @SerializedName("from_info")
    @Expose
    private String fromInfo;
    @SerializedName("to_city")
    @Expose
    private ToCityPojo toCity;
    @SerializedName("to_date")
    @Expose
    private String toDate;
    @SerializedName("to_time")
    @Expose
    private String toTime;
    @SerializedName("to_info")
    @Expose
    private String toInfo;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("bus_id")
    @Expose
    private int busId;
    @SerializedName("reservation_count")
    @Expose
    private int reservationCount;

    public DatumPojo(int id, FromCityPojo fromCity, String fromDate, String fromTime, String fromInfo, ToCityPojo toCity, String toDate, String toTime, String toInfo, String info, int price, int busId, int reservationCount) {
        this.id = id;
        this.fromCity = fromCity;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.fromInfo = fromInfo;
        this.toCity = toCity;
        this.toDate = toDate;
        this.toTime = toTime;
        this.toInfo = toInfo;
        this.info = info;
        this.price = price;
        this.busId = busId;
        this.reservationCount = reservationCount;
    }

    public DatumPojo(int id, String fromCityName, String toCityName, int price) {
        this.id = id;
        this.fromCity = new FromCityPojo(0, 0, fromCityName);
        this.toCity = new ToCityPojo(0, 0, toCityName);
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FromCityPojo getFromCity() {
        return fromCity;
    }

    public void setFromCity(FromCityPojo fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getFromInfo() {
        return fromInfo;
    }

    public void setFromInfo(String fromInfo) {
        this.fromInfo = fromInfo;
    }

    public ToCityPojo getToCity() {
        return toCity;
    }

    public void setToCity(ToCityPojo toCity) {
        this.toCity = toCity;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getToInfo() {
        return toInfo;
    }

    public void setToInfo(String toInfo) {
        this.toInfo = toInfo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getReservationCount() {
        return reservationCount;
    }

    public void setReservationCount(int reservationCount) {
        this.reservationCount = reservationCount;
    }

    @Override
    public String toString() {
        return "DatumPojo{" +
                "id=" + id +
                ", fromCity=" + fromCity.getName() +
                ", fromDate='" + fromDate + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", fromInfo='" + fromInfo + '\'' +
                ", toCity=" + toCity.getName() +
                ", toDate='" + toDate + '\'' +
                ", toTime='" + toTime + '\'' +
                ", toInfo='" + toInfo + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", busId=" + busId +
                ", reservationCount=" + reservationCount +
                '}';
    }
}
