package com.example.demo1.collection;

import com.example.demo1.Person;

public interface AddressBook {

    void save(Person person);
    void update(Person person);
    void delete(Person person);

}
