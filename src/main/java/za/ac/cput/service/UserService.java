package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<User, Long> {
    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }


    public void registerUser(User user) {
        if (user != null) {
            repository.save(user);
        } else {
            // Handle invalid user creation
            throw new IllegalArgumentException("Invalid user details provided.");
        }
    }

    public Optional<User> validateUser(String email, String password){
        Optional<User> user = repository.findUserByEmail(email);

        if(user.isPresent() && user.get().getPassword().equals(password))

            return user;

        return Optional.empty();
    }

    @Override
    public boolean delete(Long d) {
        if (repository.existsById(d)) {
            repository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("User with Id " + d + " does not exist");
        }
    }
    public boolean deleteUserByEmail(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            repository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
