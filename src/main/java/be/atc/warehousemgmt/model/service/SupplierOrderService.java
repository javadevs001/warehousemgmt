package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.supplier.SupplierOrder;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */
public interface SupplierOrderService {

    List<SupplierOrder> getAllSupplierOrder();

    SupplierOrder saveSupplierOrder(SupplierOrder supplierOrder);

    SupplierOrder getSupplierOrderById(Long supplierOrderId);

}
