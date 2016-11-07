package ua.vlad.notebook.model;

/**
 * Created by vlad on 06.11.16.
 */
public class Address {

    private String index;
    private String city;
    private String street;
    private String buildingNumber;
    private int apartmentNumber;
    private String fullAddress;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress() {
        this.fullAddress = "";
    }

    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
