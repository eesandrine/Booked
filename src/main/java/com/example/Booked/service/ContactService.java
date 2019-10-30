package com.example.Booked.service;

import com.example.Booked.model.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    List<Contact> saveAll(List<Contact> contacts);

    List findAllContacts();

    Contact findContactById(Long id);

    Contact deleteContact(Long id);
}
