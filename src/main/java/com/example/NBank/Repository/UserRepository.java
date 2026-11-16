package com.example.NBank.Repository;

import com.example.NBank.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsBycpf(String cpf);
    boolean existsByemail(String email);

    Optional<User> findBycpf(String cpf);
}
