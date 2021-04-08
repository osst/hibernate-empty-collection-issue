package org.hibernate.test;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;

    private String serialNumber;

    public Bank getBank() {
        return bank;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
