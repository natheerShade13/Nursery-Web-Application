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

    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
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
    public Optional<Supplier> validateSupplier(String email, String password){
        Optional<Supplier> supplier = supplierRepository.findUserByEmail(email);

        if(supplier.isPresent() && supplier.get().getPassword().equals(password))
            return supplier;

        return Optional.empty();
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
