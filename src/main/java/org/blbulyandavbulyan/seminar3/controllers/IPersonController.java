package org.blbulyandavbulyan.seminar3.controllers;

import org.blbulyandavbulyan.seminar3.studentapp.domen.protypes.PersonPrototype;

public interface IPersonController <PT extends PersonPrototype<String, Integer>> {
    void create(String firstName, int age);
}
