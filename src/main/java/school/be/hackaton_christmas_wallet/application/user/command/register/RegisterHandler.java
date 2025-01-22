package school.be.hackaton_christmas_wallet.application.user.command.register;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IUsersRepository;

@Service
public class RegisterHandler implements IQueryHandler<RegisterQuery, Boolean> {
    private final IUsersRepository usersRepository;

    public RegisterHandler(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Boolean handle(RegisterQuery input) {
        DbUsers db = new DbUsers();
        db.setUsername(input.username);

        String hashedPassword = BCrypt.hashpw(input.password, BCrypt.gensalt(12));
        db.setPassword(hashedPassword);

        try {
            usersRepository.save(db);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
