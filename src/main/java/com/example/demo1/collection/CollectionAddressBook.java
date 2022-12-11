package com.example.demo1.collection;

import com.example.demo1.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook{


    @Override
    public void save(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }

    public void print(){
        int number = 0;

        for (Person p: personList){
            number++;
            System.out.println(number + "pip" + p.getPip() + " phone " + p.getPhone());
        }
    }

    public void fillTestData(){
        personList.add(new Person("Maksym","467298"));
        personList.add(new Person("Oksana","515151"));
        personList.add(new Person("Yulia","101010"));
        personList.add(new Person("Anna","787970"));
    }
}
