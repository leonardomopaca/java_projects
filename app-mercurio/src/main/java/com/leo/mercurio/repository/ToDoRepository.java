package com.leo.mercurio.repository;

import com.leo.mercurio.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {}
