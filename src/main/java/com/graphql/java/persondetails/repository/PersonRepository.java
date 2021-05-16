package com.graphql.java.persondetails.repository;

import com.graphql.java.persondetails.type.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @NotNull
    @Override
    Optional<Person> findById(@NotNull Long id);
}
