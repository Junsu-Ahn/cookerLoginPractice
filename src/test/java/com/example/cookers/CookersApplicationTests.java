package com.example.cookers;

import com.example.cookers.domain.dto.JoinRequest;
import com.example.cookers.domain.member.repository.UserRepository;
import com.example.cookers.domain.member.service.UserService;
import com.example.cookers.domain.recipe.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CookersApplicationTests {

	@Autowired
	RecipeService recipeService;
	@Autowired
	UserService userService;
	@Test
	void contextLoads() {
		for (int i =1; i<= 10; i++){
			String title = String.format("제목 %d", i);
			String content = String.format("내용 %d", i);
			String nickname = String.format("user%d", i);
			recipeService.create(title, content, nickname);
		}
	}

	@Autowired
	private UserRepository userRepository;

	@Test
	void createTestUsers() {
		for (int i = 1; i <= 10; i++) {
			String loginId = "testuser" + i;
			String password = "password" + i;
			String nickname = "Test User " + i;

			JoinRequest joinRequest = new JoinRequest();
			joinRequest.setLoginId(loginId);
			joinRequest.setPassword(password);
			joinRequest.setNickname(nickname);

			userService.join(joinRequest);
		}
	}

}
