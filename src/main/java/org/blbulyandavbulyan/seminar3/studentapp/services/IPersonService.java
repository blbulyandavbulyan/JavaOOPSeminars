package org.blbulyandavbulyan.seminar3.studentapp.services;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

import java.util.List;

public interface IPersonService <PT extends PersonPrototype<String, Integer>> {
    List<PT> getAll();
    void create(String name, int age);
}
