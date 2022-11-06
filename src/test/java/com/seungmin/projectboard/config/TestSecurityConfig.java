package com.seungmin.projectboard.config;

import com.seungmin.projectboard.domain.UserAccount;
import com.seungmin.projectboard.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetup(){
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
                "winTest",
                "pw",
                "win-test@email.com",
                "win-test",
                "test memo"
        )));
    }
}
