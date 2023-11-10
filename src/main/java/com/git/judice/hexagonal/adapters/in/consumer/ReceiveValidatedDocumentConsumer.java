package com.git.judice.hexagonal.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.git.judice.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.git.judice.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.git.judice.hexagonal.application.ports.in.UpdateCustomerInputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedDocumentConsumer {

  @Autowired
  private final UpdateCustomerInputPort updateCustomerInputPort;

  @Autowired
  private final CustomerMessageMapper customerMessageMapper;

  @KafkaListener(topics = "tp-document-validation", groupId = "hexagonal")
  public void receive(CustomerMessage customerMessage) {
    var customer = customerMessageMapper.toCustomer(customerMessage);
    updateCustomerInputPort.update(customer, customerMessage.getZipCode());
  }

}
