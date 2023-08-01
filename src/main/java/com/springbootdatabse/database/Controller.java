package com.springbootdatabse.database;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springbootdatabse.database.beandetails.BeanDetails;

import org.springframework.hateoas.EntityModel;


@RestController
@Validated
public class Controller {

	@Autowired
	private RepositoryClass repository;
	
	
	@Autowired
	private ServiceClass ser;
	
	@GetMapping("/")
	public List<Bean> allUser()
	{
		return repository.findAll();
	}
	
	
	@PostMapping("/usercreate")
	public String createUser(@RequestBody @Valid Bean bean) 
	
	{
		/*
		 * Bean savedBean=repository.save(bean);
		 * 
		 * if(savedBean==null) {throw new
		 * Exception("User name alredy exist please try another username");}
		 * 
		 * return "user name create successfylly";
		 */
		
		try {
			
            repository.save(bean);
            return "User name created successfully.";
        } catch (DataAccessException da) {
           
            return "User name alredy exist please try another username.";
        }
	}
		
	
	
	/*
	 * URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").
	 * buildAndExpand(savedUser.getUsername()) .toUri();
	 * 
	 * return ResponseEntity.created(location).build();
	 */
	/*
	 * try { Bean savedBean = repository.save(bean); System.out.println(savedBean);
	 * 
	 * 
	 * return new ResponseEntity<>(savedBean, HttpStatus.CREATED); } catch
	 * (Exception e) {
	 * 
	 * String errorMessage = e.getMessage(); HttpStatus status =
	 * HttpStatus.INTERNAL_SERVER_ERROR;
	 * 
	 * 
	 * } return null;
	 */
	
	
		@GetMapping("/{username}/{password}")
		public List<BeanDetails> getBeanByUsername (@PathVariable String username ,@PathVariable String password)
//	@GetMapping("/")
//	public List<Bean> getBeanByUsername (@RequestParam (name="username")String username,@RequestParam(name="password") String password)
	
    		throws Exception {
       List<BeanDetails> beanDetails =ser.getBeanByUsername(username,password);
       if (beanDetails.isEmpty()) {throw new Exception( "Please check username and password.");}
       return beanDetails;
    }
		
		
	/*
	 * @GetMapping("/p") public List<Bean> getBeanByUsernamePassword
	 * (@RequestParam("username") String username ,@RequestParam("password") String
	 * password) { return useRrepository.findBeanByUsername(username,password); }
	 */
	
	
	
	/*
	 * @GetMapping("/find/{username}/{password}") public List<Bean>
	 * findBeanByUsername(@PathVariable String username,String password) {
	 * useRrepository.findBeanByUsername(username); return null; }
	 */
	
	
	
	
	/*@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/usercreate1/{username}")
	public ResponseEntity<Object> createUser1(@PathVariable String username,@RequestBody Bean bean ) throws java.lang.Exception
	{
		Bean find = ser.findOne(username);
		
		//boolean isexists = repository.existsbyusernameignorecase(username);
		if ((find == null )) throw new Exception("Username "+username);
			//public ResponseEntity<Object> createUser2
		else {
			repository.save(bean);
		}
		return null;}*/
		
		
	
	
	/*
	 * @PostMapping("/users/{id}") public User saveUser(@PathVariable Long
	 * id, @RequestBody User user) { user.setId(id); return userService.save(user);
	 * }
	 */
	/*
	 * @PostMapping("/usercreate/{username}") public Object
	 * saveCountry(@PathVariable String username){ Optional<Bean> existingCountry =
	 * repository.findByUsername(getUsername()); if(existingCountry == null){
	 * //Country does not already exist so save the new Country return
	 * countryRepository.save(country); } //The Country was found by name, so don't
	 * add a duplicate else return "A Country with that name already exists"; }
	 */

	
	
}
