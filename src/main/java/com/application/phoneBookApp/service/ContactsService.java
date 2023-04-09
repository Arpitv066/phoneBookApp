package com.application.phoneBookApp.service;

import com.application.phoneBookApp.dal.entity.Contacts;

import java.util.List;

public interface ContactsService {

    Contacts addContact(Contacts contact);

    boolean deleteContact(int id);

    List<Contacts> searchByLastName(String lastName);

    List<Contacts> findAllContacts();
}
