package example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Student {

    private String rollNumber;
    private String email;
    private String name;
    private String avatar;
    private int age;
    private ImageView imageAvatar;

    public Student() {
    }

    public Student(String rollNumber, String name, String avatar) {
        this.rollNumber = rollNumber;
        this.avatar = avatar;
        this.name = name;
        this.imageAvatar = new ImageView(new Image(this.avatar, true)); // đưa ảnh vào image view.
        this.imageAvatar.setFitWidth(50); // set kích thước.
        this.imageAvatar.setFitHeight(50);
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ImageView getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(ImageView imageAvatar) {
        this.imageAvatar = imageAvatar;
    }
}
