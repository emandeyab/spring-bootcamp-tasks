package main.com.myApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private String country;
    private String programmingLanguage;
    private List<String> operatingSystems;

    public User() {
        this.operatingSystems = new ArrayList<String>();
    }
}
