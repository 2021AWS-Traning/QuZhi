package com.graphql.java.persondetails.resolver;

import com.graphql.java.persondetails.cache.RedisUtil;
import com.graphql.java.persondetails.repository.PersonRepository;
import com.graphql.java.persondetails.type.Person;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Resource
    private PersonRepository personRepository;
    @Resource
    private RedisUtil redisUtil;

    @Transactional
    public Boolean addPerson(String name, String gender){
        Person  person = personRepository.save(Person.builder().name(name).gender(gender).build());
        redisUtil.setWithTimeOut(String.valueOf(person.getId()), person, Duration.ofMinutes(1));
        return Boolean.TRUE;
    }

    public Boolean addPersonByObject(Person person) {
        personRepository.save(person);
        redisUtil.setWithTimeOut(String.valueOf(person.getId()), person, Duration.ofMinutes(1));
        return Boolean.TRUE;
    }
}
