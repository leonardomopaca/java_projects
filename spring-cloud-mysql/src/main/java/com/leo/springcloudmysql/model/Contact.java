package com.leo.springcloudmysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
}

/*AllArgsContructor - cria automaticamente um construtor com todos os atributos da classe como argumento
* NoArgsConstructor - cria automaticamente um construtor vazio
* Data - cria automaticamente os métodos toString, equals, hashCode, getters e setters*/