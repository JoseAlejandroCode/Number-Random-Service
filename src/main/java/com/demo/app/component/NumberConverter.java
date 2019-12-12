package com.demo.app.component;

import com.demo.app.model.NumberDto;
import com.demo.app.model.Number;
import org.springframework.stereotype.Component;

@Component
public class NumberConverter {

  public NumberDto convertToDto(Number number){
    NumberDto numberDto = new NumberDto();
    numberDto.setId(number.getId());
    numberDto.setValue(number.getValue());
    return numberDto;
  }

  public Number convertToEntity(NumberDto numberDto){
    Number number = new Number();
    number.setId(numberDto.getId());
    number.setValue(numberDto.getValue());
    return number;
  }

}
