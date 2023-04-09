package com.application.phoneBookApp.service.impl;

import com.application.phoneBookApp.dal.entity.Contacts;
import com.application.phoneBookApp.dal.repository.ContactsRepository;
import com.application.phoneBookApp.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    ContactsRepository contactsRepository;
    @Override
    public Contacts addContact(Contacts contact) {
        return contactsRepository.save(contact);
    }

    @Override
    public boolean deleteContact(int id) {
        try {
            Optional<Contacts> contact = contactsRepository.findById(id);
            contact.ifPresent(contacts -> contactsRepository.delete(contacts));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Contacts> searchByLastName(String lastName) {
        return contactsRepository.findByLastNameStartsWithIgnoreCaseOrLastNameEndsWithIgnoreCaseOrLastNameLikeIgnoreCaseOrderByLastNameAsc(lastName);
    }
}
