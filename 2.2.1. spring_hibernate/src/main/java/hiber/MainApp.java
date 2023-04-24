package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User ("Walter", "White", "crystal@mail.ru");
      User user2 = new User ("Peter", "Parker", "givemethephoto@mail.ru");
      User user3 = new User ("Harry", "Potter", "expelearmus@mail.ru");
      User user4 = new User ("Homer", "Simpson", "dufbir@mail.ru");

      Car car1 = new Car("AVENTADOR", 2021);
      Car car2 = new Car("MURCIELAGO", 2010);
      Car car3 = new Car("URUS", 2018);
      Car car4 = new Car("GALLARDO", 2013);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }


      System.out.println("Getting a user by car model and series:");

//      System.out.println("The car belongs to the user with the data: " + userService.getUserByCar("AVENTADOR", 2021));
//      System.out.println("The car belongs to the user with the data: " + userService.getUserByCar("URUS", 2018));
//      System.out.println("The car belongs to the user with the data: " + userService.getUserByCar("MURCIELAGO", 2010));
      System.out.println("The car belongs to the user with the data: " + userService.getUserByCar("GALLARDO", 2013));


      context.close();
   }
}
