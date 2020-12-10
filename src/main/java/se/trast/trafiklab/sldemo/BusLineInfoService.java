package se.trast.trafiklab.sldemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.trast.trafiklab.sldemo.dtos.JourModel;
import se.trast.trafiklab.sldemo.dtos.StopModel;

@Service
public class BusLineInfoService {

    private static final String NL = System.lineSeparator();

    public String highestNumberOfBusStops(int number, JourModel jourModel) {

        BusLineInfoCalculator infoCalculator = new BusLineInfoCalculator();
        Map<Integer, Long> highestNumberOfBusStops = infoCalculator.highestNumberOfBusStops(number, jourModel);

        List<String> collect = highestNumberOfBusStops.entrySet()
                .stream()
                .map(entry -> "<li>Linje " + entry.getKey() + ", " + entry.getValue() + " hållplatser.</li>")
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("<!DOCTYPE html>").append("<html>")
                .append("<head>")
                .append("<title>Busslinjer med flest antal busshållplatser</title>")
                .append("</head>")
                .append("<body>");
        sb.append("<h1>Busslinjer med flest antal busshållplatser</h1><ul>");
        collect.forEach(line -> sb.append(line));
        sb.append("</ul></body></html>");
        return sb.toString();
    }

    public String busStopsForLine(int line, JourModel jourModel, StopModel stopModel) {

        BusLineInfoCalculator stopComputer = new BusLineInfoCalculator();

        List<String> busStopsForLine = stopComputer.busStopsForLine(line, jourModel, stopModel);

        StringBuilder sb = new StringBuilder("<!DOCTYPE html>").append("<html>")
                .append("<head>")
                .append("<title>Hållplatser på busslinje " + line + "</title>")
                .append("</head>")
                .append("<body>");
        sb.append("<h1>Busslinje " + line + " har " + busStopsForLine.size() + " hållplatser</h1><ul>");
        busStopsForLine.forEach(stopName -> sb.append("<li>" + stopName + "</li>"));
        sb.append("</ul></body></html>");
        return sb.toString();
    }
}
