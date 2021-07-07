package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT CASE WHEN u.password = ?2 THEN u.userid ELSE NULL END FROM User u WHERE u.username = ?1", nativeQuery = true)
    Integer login(String username, String password);

    @Query(value = "SELECT u.isadmin FROM User u WHERE u.userid = ?1", nativeQuery = true)
    boolean isAdmin(int userId);

    @Query(value = "SELECT COUNT(u.id)>0 FROM User u", nativeQuery = true)
    boolean existsByUsername(String username);
}