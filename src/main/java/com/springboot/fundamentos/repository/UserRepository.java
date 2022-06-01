package com.springboot.fundamentos.repository;

import com.springboot.fundamentos.dto.UserDTO;
import com.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // JPQL con @Query
    @Query("Select u from User u WHERE u.email = ?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u from User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    // Query Methods
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);

    // Like
    List<User> findByNameLike(String name);

    // Or
    List<User> findByNameOrEmail(String name, String email);

    // Between
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    // Like OrderBy
    List<User> findByNameLikeOrderByIdDesc(String name);

    // Containing OrderBy
    List<User> findByNameContainingOrderByIdDesc(String name);

    // Named parameters
    @Query("SELECT new com.springboot.fundamentos.dto.UserDTO(u.id, u.name, u.birthDate) " +
            "FROM User u " +
            "where u.birthDate=:paramDate " +
            "and u.email=:paramEmail")
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("paramDate") LocalDate date,
                                                @Param("paramEmail") String email);
}
