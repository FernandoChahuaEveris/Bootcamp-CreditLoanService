package com.everis.creditsloans.util.kafka;

import com.everis.creditsloans.dao.entity.PCreditCard;
import com.everis.creditsloans.dao.entity.PersonalCreditCard;
import com.everis.creditsloans.service.PersonalCreditCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class TopicClient {

    private final PersonalCreditCardService service;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public TopicClient(PersonalCreditCardService service, KafkaTemplate kafkaTemplate) {
        this.service = service;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "t-credits-clients", groupId = "group_id", containerFactory = "containerFactory")
    public void receiverDniClient(String dni){
        log.info("mensaje " + dni);
    }

    public Flux<PersonalCreditCard> sendCreditCardPersonal(String dni){
        return service.findAllByDni(dni).doOnNext(personalCreditCard -> kafkaTemplate.send("t-return-credit-card", personalCreditCard));
    }

}
