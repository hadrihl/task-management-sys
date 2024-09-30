package com.example.task_management_sys;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.task_management_sys.repository.UserRepository;
import com.example.task_management_sys.service.UserService;

public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
    }
}
