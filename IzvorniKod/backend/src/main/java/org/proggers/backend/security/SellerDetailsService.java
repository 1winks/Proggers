package org.proggers.backend.security;

import org.proggers.backend.entity.Seller;
import org.proggers.backend.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SellerDetailsService implements UserDetailsService {

    // TODO: ensure the weird autowired constructor is not needed.
    @Autowired
    private SellerRepository sellerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Seller> optionalSeller = sellerRepo.findByUsername(username);
        if (optionalSeller.isEmpty()) {
            throw new UsernameNotFoundException("Unknown User.");
        }
        Seller seller = optionalSeller.get();
        return new User(seller.getUsername(), seller.getPassword(), userAuthority());
    }
    private Collection<GrantedAuthority> userAuthority() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
