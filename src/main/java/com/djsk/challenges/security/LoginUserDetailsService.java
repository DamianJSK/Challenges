package com.djsk.challenges.security;

import com.djsk.challenges.persistence.dao.IUserDao;
import com.djsk.challenges.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    HttpServletRequest request;

    //
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ email);
        }
        if(request.getSession().getAttribute("user") != null){
            request.getSession().removeAttribute("user");
        }
//        String userAgent = request.getHeader("User-Agent");
        request.getSession().setAttribute("user",user);

        CustomUserDetails userDetails = new CustomUserDetails(user);
        return  userDetails;
    }
}
