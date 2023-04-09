package com.application.phoneBookApp.controller;


import com.application.phoneBookApp.dal.entity.Contacts;
import com.application.phoneBookApp.service.impl.ContactsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactsController {

    @Autowired
    ContactsServiceImpl contactsService;

    @GetMapping("/welcome")
    String welcome(){
        return "welcome";
    }

    @PostMapping("/addContact")
    Contacts addContact(@RequestBody Contacts contact) {
        return contactsService.addContact(contact) ;
    }

    @DeleteMapping ("/deleteContact")
    boolean deleteContact(@RequestParam int id){
        return contactsService.deleteContact(id);
    }

    @GetMapping("/search")
    List<Contacts> search(String lastName){
        return contactsService.searchByLastName(lastName);
    }

    @GetMapping("/allContacts")
    List<Contacts> getAllContacts(){
        return contactsService.findAllContacts();
    }

}
