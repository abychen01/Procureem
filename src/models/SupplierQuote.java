package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SupplierQuote extends Quote{
    private double supplierPrice;


    public SupplierQuote(int id,
                         String name,
                         String specification,
                         int quantity,
                         double maxUnitPrice,
                         String deliveryDue,
                         String range,
                         String supportPeriod,
                         String additionalRequirements,
                         int buyerId,
                         int sellerId, double supplierPrice) {
        super(id, name, specification, quantity, maxUnitPrice, deliveryDue, range, supportPeriod, additionalRequirements, buyerId, sellerId);
        this.supplierPrice = supplierPrice;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public boolean canConfirm() {
        try {
            Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(getDeliveryDue());
            return date1.getTime() <= new Date().getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
