package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT CASE WHEN u.password = ?2 THEN u.userid ELSE NULL END FROM User u WHERE u.username = ?1")
    Integer login(String username, String password);

    @Query("SELECT u.isadmin FROM User u WHERE u.userid = ?1")
    boolean isAdmin(int userId);
}