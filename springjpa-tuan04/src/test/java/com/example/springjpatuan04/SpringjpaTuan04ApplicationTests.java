package com.example.springjpatuan04;

import com.example.springjpatuan04.repository.ChuyenbayRepository;
import com.example.springjpatuan04.repository.MaybayRepository;
import com.example.springjpatuan04.repository.NhanvienRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringjpaTuan04ApplicationTests {
	@Autowired
	private ChuyenbayRepository chuyenbayRepository;
	@Autowired
	private MaybayRepository maybayRepository;
	@Autowired
	private NhanvienRepository nhanvienRepository;

	@Test
	void cau1() {
		System.out.println(chuyenbayRepository.findByGaden("DAD"));
	}

}
