public class User {
    private int id;
    private String name;
    private String email;
    private int age;


    public User() {
    }

    public User(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Id= " + id + ", Name = " + name + ", Email: " + email + ", age: " + age;
    }
}
