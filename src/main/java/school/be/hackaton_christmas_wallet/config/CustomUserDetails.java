package school.be.hackaton_christmas_wallet.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final DbUsers dbUser;

    public CustomUserDetails(DbUsers dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return dbUser.getPassword();
    }

    @Override
    public String getUsername() {
        return dbUser.getUsername();
    }

    public DbUsers getDbUser() {
        return dbUser;
    }
}
