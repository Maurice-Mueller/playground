package moepad.playground.spring.data;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;

  private int age;
  private String surname;
  private String firstname;

  public User() {
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public static User createRandom() {
    Random random = new Random();
    User user = new User();
    user.age = random.nextInt();
    user.firstname = "Nach: " + Double.toString(random.nextDouble());
    user.surname = "Vor: " + String.valueOf(random.nextDouble());
    return user;
  }
}
