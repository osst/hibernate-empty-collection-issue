package org.hibernate.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany
    private List<BankDepartment> departments = new ArrayList<>();

    public List<BankDepartment> getDepartments() {
        return departments;
    }
}
