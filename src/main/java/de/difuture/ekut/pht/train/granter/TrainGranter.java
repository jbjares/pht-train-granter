package de.difuture.ekut.pht.train.granter;

import de.difuture.ekut.pht.lib.core.messages.TrainVisit;
import de.difuture.ekut.pht.lib.core.model.Station;
import de.difuture.ekut.pht.train.granter.client.StationOfficeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


@SpringBootApplication
@EnableBinding(Sink.class)
public class TrainGranter {

	public static void main(String[] args) {
		SpringApplication.run(TrainGranter.class, args);
	}

	private final StationOfficeClient stationOfficeClient;

	@Autowired
	public TrainGranter(StationOfficeClient stationOfficeClient) {

	    this.stationOfficeClient = stationOfficeClient;
    }


	@StreamListener(Sink.INPUT)
	void sink(TrainVisit trainVisit) {

	    // Get the station this trainVisit belongs to
        final Station station = this.stationOfficeClient.get(trainVisit.getStationID());

        System.out.println(station);
    }
}
