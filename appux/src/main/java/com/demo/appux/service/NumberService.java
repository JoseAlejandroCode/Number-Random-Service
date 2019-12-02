package com.demo.appux.service;

import com.demo.appux.model.NumberDto;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;

@Service
public interface NumberService {
  @GET("generate-one")
  Call<NumberDto> getRandomNumberOne();

  @GET("generate-two")
  Call<NumberDto> getRandomNumberTwo();
}
