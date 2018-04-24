package de.difuture.ekut.pht.train.granter.client;

import de.difuture.ekut.pht.lib.core.model.Station;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;


@FeignClient("station-office")
public interface StationOfficeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/station/{stationID}", produces = "application/json")
    Station get(@PathVariable("stationID") UUID storeId);
}
