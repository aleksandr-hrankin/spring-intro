package ua.mate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mate.config.AppConfig;
import ua.mate.model.User;
import ua.mate.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User bob = getUser("bob", "1234");
        User alice = getUser("alice", "1234");
        userService.add(bob);
        userService.add(alice);
        userService.listUsers().forEach(System.out::println);
    }

    private static User getUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return user;
    }
}
