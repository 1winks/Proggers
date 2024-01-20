package org.proggers.backend.endpoints;

import jakarta.validation.Valid;
import org.proggers.backend.dto.LoginDTO;
import org.proggers.backend.dto.RegisterDTO;
import org.proggers.backend.entity.Seller;
import org.proggers.backend.security.Authenticator;
import org.proggers.backend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    SellerService sellerService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    Authenticator authenticator;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("")
    public String ping () {
        return "Hello, World!";
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register (@Valid @RequestBody RegisterDTO registerDTO) {
        if (!sellerService.exists(registerDTO.getUsername(), registerDTO.getEmail())) {
            Seller seller = new Seller(registerDTO, passwordEncoder);
            sellerService.register(seller);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@Valid @RequestBody LoginDTO loginDTO) {
        Seller seller = sellerService.find(loginDTO.getUsername());

        if (seller == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = authenticator.genToken(authentication.getName());

            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
