package com.example.NBank.Service;

import com.example.NBank.Model.User;
import com.example.NBank.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean criarUser(User user){
        if(userRepository.existsBycpf(user.getCpf()) && userRepository.existsByemail(user.getEmail())){
            return false;
        }

        userRepository.save(user);
        return true;
    }

    public ResponseEntity<User> login(User user){
        Optional<User> userEncontrado = userRepository.findBycpf(user.getCpf());
        if(userEncontrado.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        User senha = userEncontrado.get();
        //if()
        return ResponseEntity.status(200).body(user);
    }
}
