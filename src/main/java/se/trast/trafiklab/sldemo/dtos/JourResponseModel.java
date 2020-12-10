package se.trast.trafiklab.sldemo.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

// @Data
public class JourResponseModel {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Result")
    private List<JourResultModel> result;

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

    public List<JourResultModel> getResult() {
        return result;
    }

    public void setResult(List<JourResultModel> result) {
        this.result = result;
    }


}
