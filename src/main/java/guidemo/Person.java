package guidemo;

import java.time.LocalDate;
import java.time.Period;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 * @author jwright
 */
public class Person {

    private String firstName, lastName;
    private String birthday;
    private String photo;
    private int age;

    public Person(String firstName, String lastName, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.photo = "defaultImage.png";
    }

    public Person(String firstName, String lastName, String birthday, String photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.photo = photo;
    }

    public Person(String firstName, String lastName, String birthday, String photo, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.photo = photo;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
