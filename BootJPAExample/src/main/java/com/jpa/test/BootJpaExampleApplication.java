package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootJpaExampleApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

//		User user = new User();
//		user.setName("Shivansh Singh");
//		user.setCity("Noida");
//		user.setStatus("I am java programmer");
//		
//		User user1 = userRepository.save(user);
//		
//		System.out.println(user1);

		/* Create Object of User */
//		User user1 = new User();
//		user1.setName("Aman");
//		user1.setCity("City-1");
//		user1.setStatus("Python programmer");
//
//		User user2 = new User();
//		user2.setName("Nitin");
//		user2.setCity("City-2");
//		user2.setStatus("ML programmer");

		/* saving single user */
//		User resultUser = userRepository.save(user2);

//		List<User> users = List.of(user1, user2);
//
//		// save multiple objects
//		Iterable<User> result = userRepository.saveAll(users);
//
//		result.forEach(user -> {
//			System.out.println(user);
//		});
//
////		System.out.println("Saved User " + resultUser);
//		System.out.println("Done");

		/* update (user with id:53) */
//		Optional<User> optional = userRepository.findById(53);
//		User user = optional.get();
//		user.setName("Nitin Yadav");
//		User result = userRepository.save(user);
//		System.out.println(result);
//		
//		/* deleting the user */
//		userRepository.deleteById(53);
//		System.out.println("Deleted");
		
//		List<User>users = userRepository.findByName("Shivansh Singh");
//		users.forEach(e->System.out.println(e));
//		
		List<User>allUsers = userRepository.getAllUser();
		allUsers.forEach(e->System.out.println(e));
		
		System.out.println("_______________________________________________________________");
		
		List<User>users = userRepository.getUserByName("Aman");
		users.forEach(e->System.out.println(e));
		
		System.out.println("_______________________________________________________________");
		
		List<User>allUsersNative = userRepository.getUsers();
		allUsersNative.forEach(e->System.out.println(e));
		
	}

}
