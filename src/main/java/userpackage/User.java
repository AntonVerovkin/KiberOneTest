package userpackage;

public class User {
    private String name;
    private String age;
    private String hobby;

    public User(String name, String age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }
}
