package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    protected User(){

    }
    private User(Builder builder){

        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName= builder.lastName;;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{

        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String email;
        private String password;


        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return  this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return  this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return  this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return  this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return  this;
        }

        public Builder copy(User user){
            this.email = user.email;
            this.password = user.password;
            this.firstName= user.firstName;
            this.lastName = user.lastName;
            this.phoneNumber = user.phoneNumber;
            return  this;
        }

        public User build(){
            return  new User(this);
        }
    }
}
