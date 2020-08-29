package com.leo.mercurio.service;

import com.leo.mercurio.exception.EntityNotFoundException;
import com.leo.mercurio.model.ToDo;
import com.leo.mercurio.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll(){
        return toDoRepository.findAll();
    }

    public ToDo findById(String id){
        return toDoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ToDo save(ToDo toDo){
        return toDoRepository.save(toDo);
    }

    public void deleteById(String id){
        toDoRepository.deleteById(id);
    }
}
