package org.andrew.crud.dao;

import org.andrew.crud.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Jack", 24, "jack@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Tom", 28, "tom@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Nick", 21, "nick@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sam", 30, "sam@mail.com"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update (int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete (int id){
        people.removeIf(p -> p.getId() == id);
    }
}
