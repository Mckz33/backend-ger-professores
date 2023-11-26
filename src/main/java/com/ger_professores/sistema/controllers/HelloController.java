package com.ger_professores.sistema.controllers;

import com.ger_professores.sistema.dtos.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public HelloResponse hello() {
    return new HelloResponse("Hello from JWT Authorization");
  }
}
