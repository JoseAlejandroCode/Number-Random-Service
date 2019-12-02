package com.demo.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class NumberDto implements Serializable {
  private int id;
  private Integer value;
}
