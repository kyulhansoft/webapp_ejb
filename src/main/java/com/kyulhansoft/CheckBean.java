// CDI Bean
package com.kyulhansoft;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
//@RequestScoped
@SessionScoped
public class CheckBean implements Serializable {
    private String user;
    private String pass;
    private String logged = "undefined";
    private String createUserStatus = "undefined";

    @EJB
    CctestEJB cctestEJB;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void onTryLogin() {
        if (cctestEJB.checkAuth(user, pass)) {
            logged = "Logged";
            //System.out.println("Logged");
        } else {
            logged = "Not logged";
            //System.out.println("Not logged");
        }
    }

    public String getLogged() {
        return logged;
    }

    public void setLogged(String logged) {
        this.logged = logged;
    }

    public String getCreateUserStatus() {
        return createUserStatus;
    }

    public void setCreateUserStatus(String createUserStatus) {
        this.createUserStatus = createUserStatus;
    }

    public void onTryCreateUser() {
        if (cctestEJB.createUser(user, pass)) {
            createUserStatus = "User is created";
        } else {
            createUserStatus = "User is NOT created";
        }
    }

    public List<UserEntity> getAllUsers() {
        return cctestEJB.getAllUsers();
    }
}
