package com.demo.app.controller;

import com.demo.app.model.NumberDto;
import com.demo.app.service.NumberService;
import com.newrelic.api.agent.Trace;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="number", description="Operations pertaining to numbers")
@RestController
@RequestMapping("/api/numbers")
public class NumberController {

  @Autowired
  private NumberService numberService;

  @ApiOperation(value = "Generate first number random", response = Integer.class)
  @Trace
  @GetMapping("/generate-one")
  public ResponseEntity<NumberDto> generateOne(){
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(numberService.create());
  }

  @ApiOperation(value = "Generate second number random", response = Integer.class)
  @Trace
  @GetMapping("/generate-two")
  public ResponseEntity<NumberDto> generateTwo(){
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(numberService.create());
  }
}
