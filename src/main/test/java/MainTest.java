//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import web.config.AppConfig;
//import web.model.User;
//import web.service.UserService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class)
//public class MainTest {
//
//    @Autowired
//    private AnnotationConfigApplicationContext applicationContext;
//
//    User user2 = new User("Jack", 48);
//    User user3 = new User("Cristopher", 36);
//
////
////    @Before
////    public void setUp() {
////        User user2 = new User("Jack", 48);
////        User user3 = new User("Cristopher", 36);
////    }
////
//    @Test
//    public void contextTest() {
//        UserService userService = applicationContext.getBean(UserService.class);
//        System.out.println(userService);
//    }
////
////    @Test
////    public void deleteTest() {
////        System.out.println("--------123");
////        userService.deleteAll();
////        List<User> list = new ArrayList<>();
////        Assert.assertEquals("Список не опустошен", userService.allUsers(), list);
////    }
////
////    @Test
////    public void addUserTest() {
////
////        userService.addUser(user2);
////        userService.addUser(user3);
////
////        User user2_2 = userService.show(0);
////        User user2_3 = userService.show(1);
////
////        user2.setId(0);
////        user2.setId(1);
////
////        Assert.assertSame("Не добавлен или не найден 2", user2_2, user2);
////        Assert.assertSame("Не добавлен или не найден 3", user2_3, user3);
////
////        System.out.println(user2_2);
////        System.out.println(user2_3);
////    }
////
////    @Test
////    public void updateUserTest() {
////
////        User user2_2 = userService.show(0);
////        User user2_3 = userService.show(1);
////
////        userService.updateUser(0, "Jack2", 99);
////        userService.updateUser(1, "Cristopher2", 99);
////
////        user2_2 = userService.show(0);
////        user2_3 = userService.show(1);
////
////        Assert.assertNotSame("Не добавлен или не найден 2", user2_2, user2);
////        Assert.assertNotSame("Не добавлен или не найден 3", user2_3, user3);
////
////        Assert.assertEquals("Имена не равны", "Jack2", user2_2.getName());
////        Assert.assertEquals("Имена не равны", "Cristopher2", user2_3.getName());
////
////    }
////
////    public void deleteUserTest() {
////        userService.removeUser(0);
////        User user = userService.show(0);
////        Assert.assertEquals("Не удалилось", null, user);
////        userService.deleteAll();
////
////    }
//
////        if (!testText.contains(text) && testText.length() <= text.length()) {
////            Assert.fail("Тест провален, не корректная связь бинов. Итоговая фраза не верна.");
////        }
//
//
//}