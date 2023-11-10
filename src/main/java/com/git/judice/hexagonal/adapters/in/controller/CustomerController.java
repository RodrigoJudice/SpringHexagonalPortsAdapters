package com.git.judice.hexagonal.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.judice.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.git.judice.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.git.judice.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.git.judice.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.git.judice.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.git.judice.hexagonal.application.ports.in.UpdateCustomerInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private final InsertCustomerInputPort insertCustomerInputPort;
  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final UpdateCustomerInputPort updateCustomerInputPort;
  private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
  private final CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

    var customer = customerMapper.toCustomer(customerRequest);
    insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
    var customer = findCustomerByIdInputPort.findById(id);
    return ResponseEntity.ok().body(customerMapper.toCustomerResponse(customer));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(
      @PathVariable final String id,
      @Valid @RequestBody CustomerRequest customerRequest) {

    var customer = customerMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerInputPort.update(customer, customer.getId());

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable final String id) {
    deleteCustomerByIdInputPort.delete(id);
    return ResponseEntity.ok().build();
  }
}
