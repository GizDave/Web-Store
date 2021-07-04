package com.sg.mthree.webstore.model.dao;

public interface UserRepository extends JpaRepository<User,Integer>{
    @Query("SELECT CASE WHEN u.password = ?2% THEN u.userid ELSE NULL END FROM User u WHERE u.username = ?1%",
            nativeQuery = true)
    Integer login(String username, String password);

    @Query("SELECT u.isadmin FROM User u WHERE u.userid = ?1%")
    boolean isAdmin(int userId);
}