package com.demo.appux.controller;

import com.demo.appux.model.NumberDto;
import com.demo.appux.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping
public class NumberController {

  private static final Logger logger = LoggerFactory.getLogger(NumberController.class);

  @Autowired
  private NumberService numberService;

  @GetMapping("sum")
  private ResponseEntity<Integer> sum() throws IOException {

    Call<NumberDto> callOne = numberService.getRandomNumberOne();
    Response<NumberDto> numberOne = callOne.execute();

    logger.info("Primer número : ".concat(numberOne.body().getValue().toString()));

    Call<NumberDto> callTwo = numberService.getRandomNumberTwo();
    Response<NumberDto> numberTwo = callTwo.execute();

    logger.info("Segundo número : ".concat(numberTwo.body().getValue().toString()));

    if (numberOne.isSuccessful() && numberTwo.isSuccessful()) {
      Integer sum = numberOne.body().getValue() + numberTwo.body().getValue();
      logger.info("Suma : ".concat(sum.toString()));
      return ResponseEntity.ok(sum);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(0);
    }
  }
}
