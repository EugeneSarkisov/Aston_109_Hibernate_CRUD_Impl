package ru.aston.crud_impl.util.dao;

import org.hibernate.Session;
import ru.aston.crud_impl.model.UserAccount;
import ru.aston.crud_impl.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

    private static Session currentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public void create(UserAccount userAccount) {
        currentSession().persist(userAccount);
    }

    @Override
    public UserAccount get(String username) {
        String hql = "FROM UserAccount WHERE username = :username";
        return currentSession().
                createQuery(hql, UserAccount.class).
                setParameter("username", username).
                uniqueResult();
    }

    @Override
    public void update(UserAccount userAccount) {
        currentSession().merge(userAccount);
    }

    @Override
    public void delete(String username) {
        UserAccount userAccountDelete = get(username);
        currentSession().remove(userAccountDelete);
    }
}
