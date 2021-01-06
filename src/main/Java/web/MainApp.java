//package web;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import web.config.AppConfig;
//import web.model.User;
//import web.service.UserService;
//
//public class MainApp {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = context.getBean(UserService.class);
//
////        userService.deleteAll();
//
//        User user1 = new User("Jimmy", 27);
//        User user2 = new User("Johnny", 57);
//        User user3 = new User("Janis", 27);
//
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//        userService.addUser("Kyle", 37);
//
//        userService.allUsers().forEach(System.out::println);
//
//        System.out.println("\n User id 1 - " + userService.show(1));
//        System.out.println("Update user - 1");
//        userService.updateUser(1, "Nikifor", 99);
//        System.out.println("User id 1 - " + userService.show(1));
//
//        System.out.println("\nDelete user - 1");
//        userService.removeUser(1);
//        System.out.println("User id 1 - " + userService.show(1));
//
//        userService.deleteAll();
//        System.out.println("List users after deleting - ");
//        userService.allUsers().forEach(System.out::println);
//
//
//    }
//} // #2
