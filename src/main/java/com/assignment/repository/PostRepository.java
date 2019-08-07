package com.assignment.repository;

import com.assignment.model.Post;
import com.assignment.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts(){
        EntityManager em = emf.createEntityManager();

        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);

        List<Post> resultList = query.getResultList();

        return resultList;
    }

    public List<Post> getUserPosts(User user){
        EntityManager em = emf.createEntityManager();

        TypedQuery<Post> query = em.createQuery("SELECT p from Post p where p.user.id = :userid", Post.class);
        query.setParameter("userid", user.getId());

        List<Post> resultList = query.getResultList();

        return resultList;
    }

    public void createPost (Post newPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }
    }



}
