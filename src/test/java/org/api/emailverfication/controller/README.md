# Test Controllers

While Testing Controllers or Controller Advice we will use @WebMvcTest annotation for it with argument test class type

```java
@WebMvcTest(UserController.class)
public class TestUserController{

       // Arrange
       // Act
       // Assert

   @Mock or @MockBean
   // dependencies
   private IUserService userService;

   @Autowired
   private ObjectMapper objectMapper;

   // For captor the arguments
   @Captor
   private ArgumentCaptor<Id_Type_ Either Long or UUID> idCaptor;

 // Add your loggers
// Add any dependencies like cookies and Headers.

/* write your Test logic here 

// Follow the pattern like Arrange, Act and Assert



}
```
