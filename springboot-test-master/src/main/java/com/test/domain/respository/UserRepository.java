package com.test.domain.respository;

import com.test.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by miaorf on 2016/6/19.
 */
@Repository
public class UserRepository {
    private static List<User> users = new ArrayList<User>();

    private static int SEQUENCE=0;

    static {
        users.add(new User(SEQUENCE++,"Ryan","123456", 18,"1991-02-23","man"));
        users.add(new User(SEQUENCE++,"Leslie","password", 18,"1993-02-23","woman"));
        users.add(new User(SEQUENCE++,"XiaoMing","bugaosuni", 8,"1891-12-03","man"));
        users.add(new User(SEQUENCE++,"Tom","chiru", 28,"1981-02-23","man"));
    }

    public List<User> getUsers(){
        return users;
    }

    public User addUser(User user){
        user.setId(SEQUENCE++);
        users.add(user);
        return user;
    }


    public boolean delete(int id) {
        Optional<User> userOptional = users.stream().filter((user) -> user.getId() == id).findFirst();
        if (userOptional.isPresent()){
            User user = userOptional.get();
            users.remove(user);
        }
        return true;
    }
}
