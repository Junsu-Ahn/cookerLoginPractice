package com.example.cookers.domain.member.controller;


import com.example.cookers.domain.dto.JoinRequest;
import com.example.cookers.domain.dto.LoginRequest;
import com.example.cookers.domain.member.entity.User;
import com.example.cookers.domain.member.service.MemberService;
import com.example.cookers.domain.member.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }

    @PostMapping("/login") // 로그인 처리를 위한 POST 매핑 추가
    public String login(@Valid LoginRequest loginRequest) {
        // 로그인 처리 로직 구현
        // userService.login(loginRequest)를 호출하여 로그인 처리하고 성공 시 리다이렉트 등의 작업 수행
        return "redirect:/"; // 로그인 성공 후 리다이렉트할 경로
    }
    @GetMapping("/signup")
    public String signupPage() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid JoinRequest joinRequest) {
        userService.join2(joinRequest);
        return "redirect:/member/login";
    }
}
