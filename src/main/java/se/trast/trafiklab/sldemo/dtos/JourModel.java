package se.trast.trafiklab.sldemo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Data
public class JourModel {

    @JsonProperty("StatusCode")
    private int statusCode;
    @JsonProperty("ExecutionTime")
    private int executionTime;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("ResponseData")
    private JourResponseModel responseData;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JourResponseModel getResponseData() {
        return responseData;
    }

    public void setResponseData(JourResponseModel responseData) {
        this.responseData = responseData;
    }


}
