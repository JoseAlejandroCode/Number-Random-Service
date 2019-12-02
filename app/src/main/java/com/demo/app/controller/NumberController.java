package com.demo.app.controller;

import com.demo.app.model.NumberDto;
import com.demo.app.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

  @Autowired
  private NumberService numberService;

  @GetMapping("/generate-one")
  public ResponseEntity<NumberDto> generateOne(){
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(numberService.create());
  }

  @GetMapping("/generate-two")
  public ResponseEntity<NumberDto> generateTwo(){
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(numberService.create());
  }
}
