package com.Hospital.controller;

import com.Hospital.entity.Staff;
import com.Hospital.payload.LoginRequest;
import com.Hospital.repository.StaffRepository;
import com.Hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class StaffController {
    private final StaffService staffService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    public StaffController(StaffService staffService, AuthenticationManager authenticationManager) {
        this.staffService = staffService;
        this.authenticationManager = authenticationManager;
    }



    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Staff staff) {

        if(staffRepository.existsByUsername(staff.getUsername())){
            return new ResponseEntity<>("Username Already taken", HttpStatus.BAD_REQUEST);
        }

        if(staffRepository.existsByEmail(staff.getEmail())){
            return new ResponseEntity<>("Email Address already taken", HttpStatus.BAD_REQUEST);
        }

        staffService.registerStaff(staff);
        return new ResponseEntity<>("Staff registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return ResponseEntity.ok("Login successful for user: " + userDetails.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

