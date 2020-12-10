package se.trast.trafiklab.sldemo.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

// @Data
public class StopResponseModel {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Result")
    private List<StopResultModel> result;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<StopResultModel> getResult() {
        return result;
    }

    public void setResult(List<StopResultModel> result) {
        this.result = result;
    }
}
