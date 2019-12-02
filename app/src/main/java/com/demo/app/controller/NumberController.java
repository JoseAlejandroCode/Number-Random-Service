package com.demo.app.controller;

import com.demo.app.model.NumberDto;
import com.demo.app.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

  @Autowired
  private NumberService numberService;

  @PostMapping("/generate-one")
  public NumberDto generateOne(){
    return numberService.create();
  }

  @PostMapping("/generate-two")
  public NumberDto generateTwo(){
    return numberService.create();
  }
}
