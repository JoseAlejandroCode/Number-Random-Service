package com.demo.app.repository;

import com.demo.app.model.Number;
import org.springframework.data.repository.CrudRepository;

public interface NumberRepository extends CrudRepository<Number, String> {
}
