/*
 * Copyright 2020 Gepardec IT Services GmbH and the CheetUnit contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package com.gepardec.jeetestapp.service;

import com.gepardec.jeetestapp.domain.Person;
import com.gepardec.jeetestapp.domain.dao.PersonDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class PersonService {

    @Inject
    private PersonDao personDao;

    public List<Person> getAllPersons() {
        return personDao.findAll();
    }

    public Person getPersonById(Long id) {
        return personDao.findById(id);
    }

    public void addPerson(Person person) {
        personDao.create(person);
    }
}
