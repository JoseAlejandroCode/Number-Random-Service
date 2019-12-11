package com.demo.app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class NumberDto implements Serializable {
  @ApiModelProperty(value = "ID", required = true)
  private int id;
  @ApiModelProperty(value = "Value of number", required = true)
  private Integer value;
}
