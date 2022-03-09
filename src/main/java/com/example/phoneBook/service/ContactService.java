package com.example.phoneBook.service;

import com.example.phoneBook.model.Contact;

import java.util.List;

public interface ContactService {
    Contact create(Contact contact);

    List<Contact> getAll();

    Contact update(Contact contact, int id);

    void delete(int id);

    List<Contact> getByKey(String key);
}
