package com.leo.springcloudmysql.repository;

import com.leo.springcloudmysql.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
/*
* DAO que irá fornecer os métodos para as operações CRUD.
* A interface JpaRepository precisa de dois parâmetros do tipo Generics:
* o primeiro é a entidade JPA que representa a tabela
* e o segundo é o tipo da chave primária (o mesmo tipo do atributo id).
* */
public interface ContactRepository extends JpaRepository <Contact, Long> {
}
