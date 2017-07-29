package rebook.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import rebook.domain.GetTripAllDetailInfo;

@Component
@EnableBinding(Source.class)
public class MsgSendingBean {

	private Source source;

	@Autowired
	public MsgSendingBean(Source source) {
		this.source = source;
	}

	public void sendSeachTravlDetailInfo(GetTripAllDetailInfo gtdi){
		System.out.println("[Rebook Service][Sending Bean] Send a gtdi to queue.");
		source.output().send(
				MessageBuilder.withPayload(gtdi)
						.build());
	}
}