package moepad.playground.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SimpleRestController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/")
  public String index() {
    return "<a href='/queryAllUsers'>query all users</a><br><a href='/createRandomUser'>create user</a>";
  }

  @RequestMapping("/queryAllUsers")
  public Iterable<User> allUsers() {
    return userRepository.findAll();
  }

  @RequestMapping("/createRandomUser")
  public ModelAndView createRandomUser() {
    userRepository.save(User.createRandom());
    ModelMap model = new ModelMap();
    return new ModelAndView(
        new RedirectView("/", true),
        model
    );
  }
}
