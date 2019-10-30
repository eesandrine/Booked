package com.example.Booked.service;

import com.example.Booked.model.Contact;
import com.example.Booked.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> saveAll(List<Contact> contacts) {
        return contactRepository.save(contacts);
    }

    @Override
    public List findAllContacts() {
        List result = new ArrayList();
        List<Object[]> contacts = contactRepository.findContactList(new Sort(Sort.Direction.ASC, "name"));
        for (Object[] contact: contacts) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", contact[0]);
            map.put("name", contact[1]);
            result.add(map);
        }
        return result;
    }

    @Override
    public Contact findContactById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact deleteContact(Long id) {
        Contact contact = findContactById(id);
        if (contact != null)
            contactRepository.delete(contact);
        return contact;
    }
}
