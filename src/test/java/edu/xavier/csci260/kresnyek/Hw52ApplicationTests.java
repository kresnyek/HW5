package edu.xavier.csci260.kresnyek;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hw52ApplicationTests {

	@Test
	public void contextLoads() {
		assertNotNull(new Integer(4));

	}

}
