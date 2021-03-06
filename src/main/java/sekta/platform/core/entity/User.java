package sekta.platform.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Retro on 14.05.2016.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    private String userName;

    private String password;

    private boolean flag;

    @OneToMany(mappedBy = "user")
    private List<Grade> grades = new ArrayList<Grade>();

    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<Message>();

    @OneToMany(mappedBy = "user")
    private List<Treaty> Treaty = new ArrayList<Treaty>();

    public User() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Treaty> getTreaty() {
        return Treaty;
    }

    public void setTreaty(List<Treaty> treaty) {
        Treaty = treaty;
    }
}
