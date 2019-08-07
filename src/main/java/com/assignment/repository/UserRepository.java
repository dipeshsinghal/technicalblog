package com.assignment.repository;

import com.assignment.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public User loginUser(User user){
        EntityManager em = emf.createEntityManager();

        TypedQuery<User> query = em.createQuery("SELECT u from User u where u.username = :username AND u.password = :password", User.class);

        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());

        User loggedInUser = null;
        try {
            loggedInUser = query.getSingleResult();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return loggedInUser;
    }

    public boolean registerUser(User newUser){
        EntityManager em = emf.createEntityManager();

        TypedQuery<User> query = em.createQuery("SELECT u from User u where u.username = :username", User.class);

        query.setParameter("username", newUser.getUsername());

        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        if( user == null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(newUser);
                transaction.commit();
                return true;
            } catch (Exception e){
                transaction.rollback();
            }
        }
        return false;
    }
}
