package school.be.hackaton_christmas_wallet.application.user.command.login;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IUsersRepository;

@Service
public class LoginHandler implements IQueryHandler<LoginQuery, Boolean> {
    private final IUsersRepository usersRepository;

    public LoginHandler(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Boolean handle(LoginQuery input) {
        DbUsers db = usersRepository.findAll().stream()
                .filter(dbUsers -> dbUsers.getUsername().equals(input.username))
                .findFirst()
                .orElse(null);
        if (db==null)
            return false;
        String hashedPassword = db.getPassword();
        return BCrypt.checkpw(input.password, hashedPassword);
    }
}
