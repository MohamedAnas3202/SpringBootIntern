package com.training.demo.services;
import com.training.demo.jwt.JwtTokenProvider;
import com.training.demo.models.RegisterDetails;
import com.training.demo.models.Roles;
import com.training.demo.models.UserDetailsDto;
import com.training.demo.repository.RegisterDetailsRepository;
import com.training.demo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService  {

    @Autowired
    RegisterDetailsRepository registerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterDetailsRepository regRepo;

    @Autowired
    private RolesRepository roleRepo;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;



    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles = new HashSet<>();
        for(String roleName: register.getRoleName()){
            Roles role = roleRepo.findByRoleName(roleName)
                    .orElseThrow(()->new RuntimeException("User not found" + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        System.out.println("Registration"+ registerDetails);
        registerRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

    public String loginUser(RegisterDetails login) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                login.getUserName(), login.getPassword()
                        )
                );
        return jwtTokenProvider.generateToken(authentication);
    }


    public Optional<RegisterDetails> findByUserByUsername(String userName) {
        return regRepo.findByUserName(userName);
    }

}