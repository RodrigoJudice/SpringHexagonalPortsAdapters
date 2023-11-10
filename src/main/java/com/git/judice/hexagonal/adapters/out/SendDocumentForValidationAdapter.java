package com.git.judice.hexagonal.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.application.ports.out.SendDocumentForValidationOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SendDocumentForValidationAdapter implements SendDocumentForValidationOutputPort {

  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void send(String docucmentId) {
    kafkaTemplate.send("tp-document-validation", docucmentId);
  }

}
