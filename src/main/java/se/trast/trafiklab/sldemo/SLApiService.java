package se.trast.trafiklab.sldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.trast.trafiklab.sldemo.dtos.JourModel;
import se.trast.trafiklab.sldemo.dtos.StopModel;

@Service
public class SLApiService {

    private static final String key = "9fc01f5e6ca748be884c6de0b8f529c2";

    private static final Logger LOGGER = LoggerFactory.getLogger(SLApiService.class);

    // TODO Add support for 4xx and 5xx responses from sl.se.
    // TODO Add handling of timeout.
    // TODO Move API.key to properties file.

    JourModel getJour() {

        LOGGER.info("Requesting the jour info from SL API.");
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        String jourResourceUrl =
                "https://api.sl.se/api2/linedata.json?key=" + key + "&model=jour&DefaultTransportModeCode=BUS";
        return restTemplate.getForObject(jourResourceUrl, JourModel.class);
    }

    StopModel getStop() {

        LOGGER.info("Requesting the stop info from SL API.");
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

        String stopResourceUrl = "https://api.sl.se/api2/linedata.json?key=" + key + "&model=stop";
        return restTemplate.getForObject(stopResourceUrl, StopModel.class);
    }

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {

        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(10000);
        clientHttpRequestFactory.setReadTimeout(10000);
        return clientHttpRequestFactory;
    }
}
