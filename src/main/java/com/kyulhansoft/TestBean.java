package com.kyulhansoft;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
//@ApplicationScoped
@SessionScoped
public class TestBean implements Serializable {
    private String height;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void onButtonAction() {
        System.out.println(height);
    }
}
