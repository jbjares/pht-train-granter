package de.difuture.ekut.pht.train.granter;

import de.difuture.ekut.pht.lib.core.messages.TrainVisit;
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

	@StreamListener(Sink.INPUT)
	void sink(TrainVisit trainVisit) {

        System.out.println(trainVisit);
    }
}
