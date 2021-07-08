package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT CASE WHEN u.password = ?2 THEN u.userid ELSE NULL END FROM Users u WHERE u.username = ?1", nativeQuery = true)
    List<Integer> login(String username, String password);

    @Query("SELECT COUNT(u) > 0 FROM Users u WHERE u.username = ?1")
    Boolean existsByUsername(String username);

    @Query("SELECT u FROM Users u")
    List<User> findAll();
}