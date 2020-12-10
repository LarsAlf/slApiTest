package se.trast.trafiklab.sldemo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Data
public class StopResultModel {

    @JsonProperty("StopPointNumber")
    private int stopPointNumber;

    @JsonProperty("StopPointName")
    private String stopPointName;

    @JsonProperty("StopAreaNumber")
    private int stopAreaNumber;

    @JsonProperty("LocationNorthingCoordinate")
    private Double locationNorthingCoordinate;

    @JsonProperty("LocationEastingCoordinate")
    private Double LocationEastingCoordinate;

    @JsonProperty("ZoneShortName")
    private String zoneShortName;

    @JsonProperty("StopAreaTypeCode")
    private String stopAreaTypeCode;

    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;

    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    public int getStopPointNumber() {
        return stopPointNumber;
    }

    public void setStopPointNumber(int stopPointNumber) {
        this.stopPointNumber = stopPointNumber;
    }

    public String getStopPointName() {
        return stopPointName;
    }

    public void setStopPointName(String stopPointName) {
        this.stopPointName = stopPointName;
    }

    public int getStopAreaNumber() {
        return stopAreaNumber;
    }

    public void setStopAreaNumber(int stopAreaNumber) {
        this.stopAreaNumber = stopAreaNumber;
    }

    public Double getLocationNorthingCoordinate() {
        return locationNorthingCoordinate;
    }

    public void setLocationNorthingCoordinate(Double locationNorthingCoordinate) {
        this.locationNorthingCoordinate = locationNorthingCoordinate;
    }

    public Double getLocationEastingCoordinate() {
        return LocationEastingCoordinate;
    }

    public void setLocationEastingCoordinate(Double locationEastingCoordinate) {
        LocationEastingCoordinate = locationEastingCoordinate;
    }

    public String getZoneShortName() {
        return zoneShortName;
    }

    public void setZoneShortName(String zoneShortName) {
        this.zoneShortName = zoneShortName;
    }

    public String getStopAreaTypeCode() {
        return stopAreaTypeCode;
    }

    public void setStopAreaTypeCode(String stopAreaTypeCode) {
        this.stopAreaTypeCode = stopAreaTypeCode;
    }

    public String getLastModifiedUtcDateTime() {
        return lastModifiedUtcDateTime;
    }

    public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
        this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
    }

    public String getExistsFromDate() {
        return existsFromDate;
    }

    public void setExistsFromDate(String existsFromDate) {
        this.existsFromDate = existsFromDate;
    }


}
