package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierProduct;

import java.util.List;

@Service
public class SupplierProductService implements IService<SupplierProduct, Long>{
    @Override
    public SupplierProduct create(SupplierProduct supplierProduct) {
        return null;
    }

    @Override
    public SupplierProduct read(Long aLong) {
        return null;
    }

    @Override
    public SupplierProduct update(SupplierProduct supplierProduct) {
        return null;
    }

    @Override
    public boolean delete(Long d) {
        return false;
    }

    @Override
    public List<SupplierProduct> getAll() {
        return List.of();
    }
}
