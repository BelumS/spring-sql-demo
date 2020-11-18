package com.poc.bem.demo.services;

import com.poc.bem.demo.domain.AppUser;

import java.util.List;

public interface AppUserDAOService {

    List<AppUser> listAll();
    AppUser getBy(int id);

    AppUser create(AppUser user);

    Iterable<AppUser> createList(Iterable<AppUser> list);

    AppUser update(AppUser user);

    void deleteBy(int id);
}
