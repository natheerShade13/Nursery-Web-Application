package za.ac.cput.factory;

import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierProduct;
import za.ac.cput.util.SupplierProductHelper;

import java.time.LocalDate;

public class SupplierProductFactory {

    public static SupplierProduct buildSupplierProduct( Supplier supplier,
            int quantity, double supplyPrice,String productName, LocalDate supplyDate, String productDescription,String imageUrl){
        if ( supplier == null
                || SupplierProductHelper.isLessThanZero(quantity) || !SupplierProductHelper.isValidPrice(supplyPrice)
                || SupplierProductHelper.isNull(supplyDate)){
                    return null;
        }

        return new SupplierProduct.Builder().setSupplier(supplier).setProductName(productName).setProductDescription(productDescription)
                .setQuantity(quantity).setSupplyPrice(supplyPrice).setSupplyDate(supplyDate).setImageUrl(imageUrl)
                .build();
    }

}
