package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.User;
import za.ac.cput.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements IService<Supplier, Long>{


    private final SupplierRepository supplierRepository;
    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void registerSupplier(Supplier supplier) {
        if (supplier != null) {
            supplierRepository.save(supplier);
        } else {
            // Handle invalid user creation
            throw new IllegalArgumentException("Invalid Supplier details provided.");
        }
    }


    @Override
    public Supplier create(Supplier supplier) {
        return null;
    }

    @Override
    public Supplier read(Long aLong) {
        return supplierRepository.findById(aLong).orElseThrow(()-> new IllegalStateException("Supplier with id "
                + aLong + " does not exist"));
    }

    @Override
    public Supplier update(Supplier supplier) {
        return null;
    }
    public Supplier validateSupplier(String email, String password){
       Supplier supplier = supplierRepository.findSupplierByEmail(email);
        if(supplier!=null && supplier.getPassword().equals(password))
            return supplier;
        return null;
    }

    @Override
    public boolean delete(Long d) {
        if (supplierRepository.existsById(d)){
            supplierRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Supplier with id " + d + " does not exist");
        }
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }
}
