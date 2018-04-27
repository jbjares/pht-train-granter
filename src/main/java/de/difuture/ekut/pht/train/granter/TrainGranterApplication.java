package de.difuture.ekut.pht.train.granter;

import de.difuture.ekut.pht.lib.core.messages.TrainVisit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableBinding(Sink.class)
public class TrainGranterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainGranterApplication.class, args);
	}


	@StreamListener(Sink.INPUT)
	void sink(TrainVisit trainVisit) {

        // Currently, just forward the TrainVisit to the respective APIStation
        new RestTemplate().postForEntity(trainVisit.getStationURI(), trainVisit, ResponseEntity.class);
    }
}
