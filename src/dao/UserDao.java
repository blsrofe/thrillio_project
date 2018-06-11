package dao;

import entities.User;
import root.DataStore;

public class UserDao {
    
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
