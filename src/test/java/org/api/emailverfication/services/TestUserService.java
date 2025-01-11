package org.api.emailverfication.services;


import org.api.emailverfication.constents.STATE;
import org.api.emailverfication.dtos.UserRequestDTO;
import org.api.emailverfication.models.User;
import org.api.emailverfication.repo.UserRepo;
import org.api.emailverfication.services.user.UserService;
import org.api.emailverfication.services.verificationservice.VerificationService;
import org.api.emailverfication.utils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@SpringBootTest
public class TestUserService {

    private final static Logger log = LoggerFactory.getLogger(TestUserService.class);

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepo userRepo;

    @Mock
    private UserRequestDTO userRequestDTO;

    @Mock
    private UserUtils userUtils;

    @Mock
    private VerificationService verificationService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }



    @Test
    @Tag("Unit Testing")
    @DisplayName("Testing the sign up method from the user Service")
    public void testSignUp_Success() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setEmail("test@example.com");
        User user = new User();
        user.setEmail("test@example.com");

        when(userUtils.getUser(dto)).thenReturn(user);
        when(verificationService.sendVerificationEmail(user.getEmail())).thenReturn(true);

        Boolean result = userService.signUp(dto);

        assertTrue(result);
        verify(userRepo, times(1)).save(user);
        assertState(STATE.INACTIVE, user.getState());
        assertNotNull(user.getId());
    }

    // Assert state equals
    private void assertState(STATE state, STATE state1) {
        if(state != state1) {
            throw new AssertionError("Expected state to be " + state + " but was " + state1);
        }
    }

    @Test
    public void testSignUp_Failure() {
        UserRequestDTO dto = new UserRequestDTO();
        dto.setEmail("test@example.com");
        User user = new User();
        user.setEmail("test@example.com");

        when(userUtils.getUser(dto)).thenReturn(user);
        when(verificationService.sendVerificationEmail(user.getEmail())).thenReturn(false);

        Boolean result = userService.signUp(dto);

        assertFalse(result);
        verify(userRepo, never()).save(user);
    }



    @Test
    @Tag("Unit Testing")
    @DisplayName("Testing the sign up method from the user Service")
    public void testSignUp(){

    }

}
















