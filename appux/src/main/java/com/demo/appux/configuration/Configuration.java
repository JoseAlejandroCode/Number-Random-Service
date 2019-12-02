package com.demo.appux.configuration;

import com.demo.appux.service.NumberService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class Configuration {
  @Bean
  public OkHttpClient okHttpClient() {
    OkHttpClient client = new OkHttpClient();
    client.newBuilder().interceptors().add(chain -> {
      Request request = chain.request();
      Response response = chain.proceed(request);
      return response;
    });
    return client;
  }

  @Bean
  public Retrofit retrofit(OkHttpClient client) {
    return new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl("http://localhost:8080/api/numbers/")
            .client(client)
            .build();
  }

  @Bean
  public NumberService numberService(Retrofit retrofit) {
    return retrofit.create(NumberService.class);
  }
}
