package za.ac.cput.factory;

import za.ac.cput.domain.OrderLine;
import za.ac.cput.domain.Orders;
import za.ac.cput.util.OrderLineHelper;

public class OrderLineFactory {

    public static OrderLine buildOrderLine(long orderLineOrder, Orders orders, int quantity
            , double quotedPrice){
        if(OrderLineHelper.validId(orderLineOrder) || orders == null
                || OrderLineHelper.isLessThanZero(quantity) || OrderLineHelper.isNegative(quotedPrice)){
            return null;
        }

        return new OrderLine.Builder().setOrderLineId(orderLineOrder).setOrders(orders)
                .setQuantity(quantity).setQuotedPrice(quotedPrice).build();
    }
}
