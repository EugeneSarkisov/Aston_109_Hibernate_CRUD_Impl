package ru.aston.crud_impl.util.dao;

import ru.aston.crud_impl.model.UserAccount;

public interface UserDAO {
    void create(UserAccount userAccount);
    UserAccount get(String username);
    void update(UserAccount userAccount);
    void delete(String username);
}
