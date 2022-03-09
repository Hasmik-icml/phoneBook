package com.example.phoneBook.service.impl;

import com.example.phoneBook.model.Contact;
import com.example.phoneBook.repository.ContactRepository;
import com.example.phoneBook.service.ContactService;
import com.example.phoneBook.util.Validation;
import com.example.phoneBook.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        if ((!Validator.checkLable(contact.getEmailLable(), Validation.label)) || (!Validator.checkLable(contact.getPhoneLable(), Validation.label)) || (!Validator.checkEmail(contact.getEmail(), Validation.regexEmail)) || (!Validator.checkPhone(contact.getPhone(), Validation.regexPhone))){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"wrong Email");
        }
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public Contact update(Contact contact, int id) {
        if ((!Validator.checkLable(contact.getEmailLable(), Validation.label)) || (!Validator.checkLable(contact.getPhoneLable(), Validation.label)) || (!Validator.checkEmail(contact.getEmail(), Validation.regexEmail)) || (!Validator.checkPhone(contact.getPhone(), Validation.regexPhone))){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"wrong Email");
        }
        Contact fromDB = contactRepository.findById(id).orElseThrow(()->{
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Bad request");
        });
        fromDB.setName(contact.getName());
        fromDB.setSurname(contact.getSurname());
        fromDB.setPhone(contact.getPhone());
        fromDB.setPhoneLable(contact.getPhoneLable());
        fromDB.setEmail(contact.getEmail());
        fromDB.setEmailLable(contact.getEmailLable());
        return fromDB;
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getByKey(String key) {

//      Validator.checkLength(key, Validation.NAME_LENGTH);

        return getAll()
                .stream()
                .filter((item)->
                    item.stringify().toLowerCase(Locale.ROOT).contains(key.toLowerCase(Locale.ROOT))
        ).collect(Collectors.toList());

    }
}
