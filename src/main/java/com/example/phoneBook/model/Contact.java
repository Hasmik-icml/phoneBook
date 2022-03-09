package com.example.phoneBook.model;


import com.example.phoneBook.model.util.Lable;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;


    private String phone;

    @Enumerated(EnumType.STRING)
    private Lable phoneLable;

    private String email;

    @Enumerated(EnumType.STRING)
    private Lable emailLable;


    public String stringify(){
        return  "" + name +
                "" + surname +
                "" + phone +
                "" + phoneLable +
                "" + email +
                "" + emailLable;
    }
}
