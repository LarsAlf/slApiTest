package se.trast.trafiklab.sldemo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import se.trast.trafiklab.sldemo.dtos.JourModel;
import se.trast.trafiklab.sldemo.dtos.StopModel;
import se.trast.trafiklab.sldemo.dtos.StopResultModel;


class BusLineInfoCalculator {

    List<String> busStopsForLine(int line, JourModel jourModel, StopModel stopModel) {

        List<Integer> stopPointsOnLine = stopPointsFor(line, jourModel);

        Map<Integer, String> stopPointNames = getStopPointNameMap(stopModel);

        Set<String> busStopNamesOnLine =
                stopPointsOnLine.stream().map(stopCode -> stopPointNames.get(stopCode)).collect(Collectors.toSet());

        return new ArrayList<>(busStopNamesOnLine);
    }

    Map<Integer, Long> highestNumberOfBusStops(int number, JourModel jourModel) {

        Map<Integer, Long> numberOfStopsInDirectionOnePerLine = numberOfBusStopsPerLine(jourModel, 1);

        return numberOfStopsInDirectionOnePerLine.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Long>comparingByValue().reversed()))
                .limit(number)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    Map<Integer, Long> numberOfBusStopsPerLine(JourModel jourModel, int directionCode) {

        return jourModel.getResponseData()
                .getResult()
                .stream()
                .filter(jourItem -> jourItem.getDirectionCode() == directionCode)
                .map(jourItem -> jourItem.getLineNumber())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    Map<Integer, String> getStopPointNameMap(StopModel stopModel) {

        return stopModel.getResponseData()
                .getResult()
                .stream()
                .collect(Collectors.toMap(StopResultModel::getStopPointNumber, StopResultModel::getStopPointName));
    }

    List<Integer> stopPointsFor(int line, JourModel jourModel) {

        return jourModel.getResponseData()
                .getResult()
                .stream()
                .filter(jourItem -> jourItem.getLineNumber() == line)
                .map(jourItem -> jourItem.getStopPointNumber())
                .collect(Collectors.toList());
    }
}
