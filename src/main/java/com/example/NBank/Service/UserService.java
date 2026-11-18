package com.example.NBank.Service;

import com.example.NBank.Model.User;
import com.example.NBank.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean criarUser(User user){
        if(userRepository.existsBycpf(user.getCpf()) && userRepository.existsByemail(user.getEmail())){
            return false;
        }
        String criptografia = passwordEncoder.encode(user.getSenha());
        user.setSenha(criptografia);
        userRepository.save(user);
        return true;
    }

    public ResponseEntity<String> login(User user){
        Optional<User> userEncontrado = userRepository.findBycpf(user.getCpf());
        if(userEncontrado.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        User user1 = userEncontrado.get();
        if(passwordEncoder.matches(user.getSenha(), user1.getSenha())){
            return ResponseEntity.status(200).body("Usuario logado");
        } else {
            return ResponseEntity.status(400).body("Email ou senha invalidos");
        }

    }
}
