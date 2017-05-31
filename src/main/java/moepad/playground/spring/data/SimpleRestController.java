package moepad.playground.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    return switchView("/");
  }

  @RequestMapping("/delete/{id}")
  public ModelAndView deleteUser(@PathVariable(value = "id") long id) {
    if(!userRepository.exists(id)) {
      return switchView("/userDoesNotExist/" + id);
    }
    userRepository.delete(id);
    return switchView("/queryAllUsers");
  }

  private ModelAndView switchView(String url) {
    ModelMap modelMap = new ModelMap();
    return new ModelAndView(new RedirectView(url, true), modelMap);
  }

  @RequestMapping("/userDoesNotExist/{id}")
  public String userNotKnown(@PathVariable long id) {
    return  "<h2>User with ID " + id + " does not exist.</h2><br>" +
        "<a href='/'>back</a>";
  }
}
