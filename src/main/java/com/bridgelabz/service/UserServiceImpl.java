package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.Model.User;
import com.bridgelabz.Repository.UserRepo;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	@Override
	public User register(User u) {
		return repo.save(u);
	}

	@Override
	public List<User> getUsers() {
		return repo.findAll();
	}
	

	
//	@Modifying
//	@Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
//	void setUserInfoById(String firstname, String lastname, Integer userId);
    @Override
	public ResponseEntity<User> updateUser(User u,long id) {
    	Optional<User> dbCustomer = repo.findById(id);
	    if(dbCustomer.isPresent()) {
	        User existingUser = dbCustomer.get();
	        existingUser=u;
    return ResponseEntity.ok().body(existingUser); 
	}
	return ResponseEntity.notFound().build();   
    }
	
/*	@Override
	public void updateActivation(Long id) {
		Optional<User> maybeUser = repo.findById(id);
		maybeUser.ifPresent(user -> {
			repo.save(user);
		});
	}
*/

@Override
public boolean deleteUser(long id) {
	Optional<User> dbCustomer = repo.findById(id);
	 if(dbCustomer.isPresent()) {
		 User existingUser = dbCustomer.get();
		 repo.delete(existingUser);
		 return true;
	 }
	 else
	 {return false;}
	
}
    
    
    

}
