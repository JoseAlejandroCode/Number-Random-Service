package com.demo.app.service.impl;

import com.demo.app.component.NumberConverter;
import com.demo.app.model.NumberDto;
import com.demo.app.repository.NumberRepository;
import com.demo.app.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberServiceImpl implements NumberService {

  @Autowired
  private NumberConverter numberConverter;

  @Autowired
  private NumberRepository numberRepository;

  @Override
  public NumberDto create() {
    Random rd = new Random();
    NumberDto number = new NumberDto();
    number.setValue(rd.nextInt());
    return numberConverter.convertToDto(numberRepository.save(numberConverter.convertToEntity(number)));
  }
}
