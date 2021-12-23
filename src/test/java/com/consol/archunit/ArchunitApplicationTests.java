package com.consol.archunit;

import com.consol.archunit.facade.BookBF;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArchunitApplicationTests {

	@Autowired
	private BookBF bookBF;
	@Test
	void contextLoads() {
		String t = "test";
	}

}
