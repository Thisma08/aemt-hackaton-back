package school.be.hackaton_christmas_wallet.application.user.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.user.command.login.LoginQuery;
import school.be.hackaton_christmas_wallet.application.user.command.register.RegisterQuery;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class UserCommandProcessor {
    private final IQueryHandler<LoginQuery, String> loginHandler;
    private final IQueryHandler<RegisterQuery, Boolean> registerHandler;

    public UserCommandProcessor(IQueryHandler<LoginQuery, String> loginHandler,
                                IQueryHandler<RegisterQuery, Boolean> registerHandler) {
        this.loginHandler = loginHandler;
        this.registerHandler = registerHandler;
    }

    public boolean registerUser(RegisterQuery query) {
        return registerHandler.handle(query);
    }

    public String loginUser(LoginQuery query) {
        return loginHandler.handle(query);
    }
}
