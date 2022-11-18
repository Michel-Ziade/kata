package com.example.kata.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name="accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name="firstname")
    private String firstname;

    @NotNull
    @Column(name="lastname")
    private String lastname;

    @NotNull
    @Column(name="amount")
    private Double amount;

    @CreatedDate
    @Column(name="createdDate")
    private Instant createdDate = new Date().toInstant();

    @LastModifiedDate
    @Column(name="modifiedDate")
    private Instant modifiedDate = new Date().toInstant();

    public Account(){}
}
