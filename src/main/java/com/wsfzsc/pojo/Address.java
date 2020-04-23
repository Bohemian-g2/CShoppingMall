package com.wsfzsc.pojo;

public class Address {
    private Integer addressId;

    private Integer userId;

    private String addressName;

    private Integer addressPhone;

    private String addressProvince;

    private String addressCity;

    private String addressDistrict;

    private Integer addressPostcode;

    private String detailedAddress;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public Integer getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(Integer addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict == null ? null : addressDistrict.trim();
    }

    public Integer getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(Integer addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }
}