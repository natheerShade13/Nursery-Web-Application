package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

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

    @Override
    public boolean delete(Long d) {
        if (repository.existsById(d)) {
            repository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("User with Id " + d + " does not exist");
        }
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
