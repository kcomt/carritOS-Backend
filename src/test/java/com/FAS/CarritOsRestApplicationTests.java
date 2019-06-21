package com.FAS;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.FAS.entities.BuisnessOwner;
import com.FAS.entities.Users;
import com.FAS.repository.BuisnessOwnerRepository;
import com.FAS.repository.UsersRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarritOsRestApplicationTests {

	@Autowired
	private BuisnessOwnerRepository businessOwnerRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void createBusinessOwner() {
		BuisnessOwner businessOwner = new BuisnessOwner();
		businessOwner.setId(1);
		businessOwner.setBuisnessName("FoodTruckGiannela");
		businessOwner.setDni("75316438");
		businessOwner.setEmail("gperamasb@pucp.edu.pe");
		businessOwner.setLastName("Permas");
		businessOwner.setName("Gianne");
		businessOwner.setPassword(encoder.encode("1234"));
		businessOwner.setRating(0);
		businessOwner.setUsername("GiannelaPermas");
		BuisnessOwner retorno = businessOwnerRepository.save(businessOwner);
		
		assertTrue(retorno.getName().equalsIgnoreCase(businessOwner.getName()));
	}
	
	
	@Test
	public void crearUsersTest() {
		Users users = new Users();
		
		users.setName("GiannelaPermas");
		users.setPassword(encoder.encode("123"));
		
		Users returns = usersRepository.save(users);
		
		
		assertTrue(returns.getPassword().equalsIgnoreCase(users.getPassword()));
	}


}
