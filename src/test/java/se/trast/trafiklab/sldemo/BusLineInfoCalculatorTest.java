package se.trast.trafiklab.sldemo;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.trast.trafiklab.sldemo.dtos.JourModel;
import se.trast.trafiklab.sldemo.dtos.StopModel;

public class BusLineInfoCalculatorTest {

    BusLineInfoCalculator sutBusLineInfoCalculator;
    JourModel jourModel;
    StopModel stopModel;

    @BeforeEach
    public void init() throws JsonMappingException, JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        jourModel = objectMapper.readValue(getJsonJourString(), JourModel.class);
        stopModel = objectMapper.readValue(getJsonStopString(), StopModel.class);

        sutBusLineInfoCalculator = new BusLineInfoCalculator();
    }

    @Test
    public void validateStopPointsForLine() {

        assertThat(sutBusLineInfoCalculator.stopPointsFor(2, jourModel).size()).isEqualTo(6);
    }

    @Test
    public void validateBusStopsForLine() {

        List<String> busStopsForLine = sutBusLineInfoCalculator.busStopsForLine(3, jourModel, stopModel);
        assertThat(busStopsForLine.size()).isEqualTo(2);
        Set<String> busStops = new HashSet<>(busStopsForLine);
        assertThat(busStops).contains("CCC");
        assertThat(busStops).contains("BBB");
    }

    @Test
    public void validatenNumberOfBusStopsPerLine() {

        Map<Integer, Long> numberOfBusStopsPerLine = sutBusLineInfoCalculator.numberOfBusStopsPerLine(jourModel, 1);
        assertThat(numberOfBusStopsPerLine.get(1)).isEqualTo(2);
        assertThat(numberOfBusStopsPerLine.get(4)).isEqualTo(4);
    }

    @Test
    public void validateStopPointNameMap() {

        Map<Integer, String> stopPointNameMap = sutBusLineInfoCalculator.getStopPointNameMap(stopModel);
        assertThat(stopPointNameMap.get(3)).isEqualTo("BBB");
        assertThat(stopPointNameMap.get(7)).isEqualTo("DDD");
    }

    @Test
    public void validateHighestNumberOfBusStops() {

        Map<Integer, Long> highestNumberOfBusStops = sutBusLineInfoCalculator.highestNumberOfBusStops(2, jourModel);
        assertThat(highestNumberOfBusStops.size()).isEqualTo(2);
        List<Integer> keys = new ArrayList<>(highestNumberOfBusStops.keySet());
        assertThat(keys.get(0)).isEqualTo(4);
        assertThat(keys.get(1)).isEqualTo(2);
        List<Long> values = new ArrayList<>(highestNumberOfBusStops.values());
        assertThat(values.get(0)).isEqualTo(4);
        assertThat(values.get(1)).isEqualTo(3);

        highestNumberOfBusStops = sutBusLineInfoCalculator.highestNumberOfBusStops(3, jourModel);
        assertThat(highestNumberOfBusStops.size()).isEqualTo(3);

    }

    private String getJsonStopString() {

        return "{\r\n" + "    \"StatusCode\": 0,\r\n" + "    \"Message\": null,\r\n" + "    \"ExecutionTime\": 485,\r\n"
                + "    \"ResponseData\": {\r\n" + "        \"Version\": \"2020-12-03 00:04\",\r\n"
                + "        \"Type\": \"StopPoint\",\r\n" + "        \"Result\": [\r\n" + "            {\r\n"
                + "                \"StopPointNumber\": \"1\",\r\n" + "                \"StopPointName\": \"AAA\"\r\n"
                + "            },\r\n" + "            {\r\n" + "                \"StopPointNumber\": \"2\",\r\n"
                + "                \"StopPointName\": \"BBB\"\r\n" + "             },\r\n" + "            {\r\n"
                + "                \"StopPointNumber\": \"3\",\r\n" + "                \"StopPointName\": \"BBB\"\r\n"
                + "            },\r\n" + "            {\r\n" + "                \"StopPointNumber\": \"4\",\r\n"
                + "                \"StopPointName\": \"AAA\"\r\n" + "             },\r\n" + "            {\r\n"
                + "                \"StopPointNumber\": \"5\",\r\n" + "                \"StopPointName\": \"CCC\"\r\n"
                + "            },\r\n" + "            {\r\n" + "                \"StopPointNumber\": \"6\",\r\n"
                + "                \"StopPointName\": \"CCC\"\r\n" + "             },\r\n" + "            {\r\n"
                + "                \"StopPointNumber\": \"7\",\r\n" + "                \"StopPointName\": \"DDD\"\r\n"
                + "            },\r\n" + "            {\r\n" + "                \"StopPointNumber\": \"8\",\r\n"
                + "                \"StopPointName\": \"DDD\"\r\n" + "             }\r\n" + "        ]\r\n"
                + "    }\r\n" + "}";
    }

    private String getJsonJourString() {

        return "{\r\n" + "    \"StatusCode\": 0,\r\n" + "    \"Message\": null,\r\n" + "    \"ExecutionTime\": 740,\r\n"
                + "    \"ResponseData\": {\r\n" + "        \"Version\": \"2020-12-02 00:04\",\r\n"
                + "        \"Type\": \"JourneyPatternPointOnLine\",\r\n" + "        \"Result\": [\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"1\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"1\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"1\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"2\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"1\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"3\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"1\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"4\"\r\n" + "            },\r\n" + "            \r\n"
                + "            {\r\n" + "                \"LineNumber\": \"2\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"1\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"2\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"5\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"2\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"2\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"2\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"3\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"2\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"6\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"2\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"4\"\r\n" + "            },\r\n" + "            \r\n"
                + "            {\r\n" + "                \"LineNumber\": \"3\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"5\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"3\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"2\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"3\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"3\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"3\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"6\"\r\n" + "            },\r\n" + "            \r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"7\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"2\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"5\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"1\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"1\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"4\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"6\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"3\"\r\n" + "            },\r\n"
                + "            {\r\n" + "                \"LineNumber\": \"4\",\r\n"
                + "                \"DirectionCode\": \"2\",\r\n"
                + "                \"JourneyPatternPointNumber\": \"8\"\r\n" + "            }\r\n" + "        ]\r\n"
                + "    }\r\n" + "}";
    }
}
