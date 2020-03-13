package web.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    private String password;

    //    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH})
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(
//                    name = "user_id",
//                    referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id",
//                    referencedColumnName = "id")
//    )
    private String role;

    public User() {
    }

    public User(String name, int age, String password, String role) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //    public User(String name, String password, String role) {
//        this.name = name;
//        this.password = password;
//        this.role = role;
//    }
}
