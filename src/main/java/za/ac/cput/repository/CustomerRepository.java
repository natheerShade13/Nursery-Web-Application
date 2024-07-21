package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Optional<Customer> findByEmail(String email);

    //Optional<Customer> findByMobileNumber(String mobileNumber);

    //Optional<Customer> findByEmailAndPassword(String email, String password);

    //List<Customer> findAllByReviews(List<Review> reviews); //Find all customers that have reviews.

    //Optional<Customer> findByContact_EmailContaining(String email);

}
