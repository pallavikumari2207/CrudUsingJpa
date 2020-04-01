package com.bridgelabz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Model.User;
import com.bridgelabz.service.UserService;


@RestController
public class UserController {

		@Autowired
		private UserService service;

		@PostMapping("/register")
		public ResponseEntity<User> registerUser(@RequestBody User user) {
			User maybeUser = service.register(user);
			if (maybeUser != null)
				return ResponseEntity.ok().body(maybeUser);
			return ResponseEntity.notFound().build();
		}

		@GetMapping("/users")
		public List<User> getUsers() {
			return service.getUsers();
		}
		
		@PutMapping("/Update/{id}")
		public  ResponseEntity<User> Updateuserlist(@RequestBody User user,@PathVariable long id) {
			return service.updateUser(user,id);
		}
		
		
		@DeleteMapping("/delete/{id}")
		public String deleteUser(@PathVariable long id){
			if(service.deleteUser(id))
			{
				return "deleted";
			}
			return "ID NOT FOUND";
			
		}

}
