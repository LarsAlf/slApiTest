package se.trast.trafiklab.sldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = TEXT_HTML_VALUE)
public class HallplatsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HallplatsController.class);

    private BusLineInfoService stopInfoService;
    private SLApiService slHandler;

    @Autowired
    public HallplatsController(BusLineInfoService stopInfoService, SLApiService slHandler) {
        this.stopInfoService = stopInfoService;
        this.slHandler = slHandler;
    }

    @RequestMapping(value = "/toplines", produces = "text/html", method = {RequestMethod.GET})
    public String getTopLines() {
        LOGGER.info("Starting to handle /toplines");
        return stopInfoService.highestNumberOfBusStops(10, slHandler.getJour());
    }

    @RequestMapping(value = "/toplines/{numberOfLines}", produces = "text/html", method = {RequestMethod.GET})
    public String getTopLines(@PathVariable("numberOfLines") int numberOfLines) {

        return stopInfoService.highestNumberOfBusStops(numberOfLines, slHandler.getJour());
    }

    @RequestMapping(value = "/busstops/{lineNumber}", produces = "text/html", method = {RequestMethod.GET})
    public String getBusstops(@PathVariable("lineNumber") int lineNumber) {

        return stopInfoService.busStopsForLine(lineNumber, slHandler.getJour(), slHandler.getStop());
    }
}
