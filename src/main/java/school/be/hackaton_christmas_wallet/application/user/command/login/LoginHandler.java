package school.be.hackaton_christmas_wallet.application.user.command.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.config.CustomUserDetails;
import school.be.hackaton_christmas_wallet.config.JwtProvider;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IUsersRepository;

@Service
public class LoginHandler implements IQueryHandler<LoginQuery, String> {
    private final IUsersRepository usersRepository;
    private final JwtProvider jwtProvider;

    public LoginHandler(IUsersRepository usersRepository, JwtProvider jwtProvider) {
        this.usersRepository = usersRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public String handle(LoginQuery input) {
        DbUsers db = usersRepository.findAll().stream()
                .filter(dbUsers -> dbUsers.getUsername().equals(input.username))
                .findFirst()
                .orElse(null);

        if (db==null) {
            return null;
        }

        String hashedPassword = db.getPassword();
        if (!BCrypt.checkpw(input.password, hashedPassword)) {
            return null;
        }

        UserDetails userDetails = new CustomUserDetails(db);


        return jwtProvider.generateToken(userDetails);
    }
}
