package com.graphql.java.persondetails.resolver;


import com.graphql.java.persondetails.cache.RedisUtil;
import com.graphql.java.persondetails.repository.PersonRepository;
import com.graphql.java.persondetails.type.Person;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Resource
    private PersonRepository personRepository;
    @Resource
    private RedisUtil redisUtil;
    public Person personById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> persons(){
        return personRepository.findAll();
    }
}
