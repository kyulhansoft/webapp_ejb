package com.kyulhansoft;

import com.sun.tools.javac.util.StringUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CctestEJB {

    @PersistenceContext (unitName = "cctestPU")
    private EntityManager entityManager;

    public boolean checkAuth(String user, String pass) {
        if ((user == null) || user.equals("")) {
            return false;
        }
        if ((pass == null) || pass.equals("")) {
            return false;
        }
        UserEntity userEntity = entityManager.find(UserEntity.class, user);
        if (userEntity == null) {
            return false;
        }
        return pass.equals(userEntity.getPassword());
    }

    public boolean createUser(String user, String pass) {
        if ((user == null) || user.equals("")) {
            return false;
        }
        if ((pass == null) || pass.equals("")) {
            return false;
        }
        UserEntity userEntity = entityManager.find(UserEntity.class, user);
        if (userEntity != null) {
            return false;
        }
        userEntity = new UserEntity();
        userEntity.setUsername(user);
        userEntity.setPassword(pass);
        entityManager.persist(userEntity);
        return true;
    }

    public List<UserEntity> getAllUsers() {
        Query q = entityManager.createQuery("select entity from UserEntity entity");
        return q.getResultList();
    }

}
