package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.supplier.SupplierOrder;
import be.atc.warehousemgmt.model.repository.SupplierOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

@Service
@Transactional
public class SupplierOrderServiceImpl implements SupplierOrderService {

    @Inject
    private SupplierOrderRepository supplierOrderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SupplierOrder> getAllSupplierOrder() {
        return supplierOrderRepository.findAll();
    }

    @Override
    public SupplierOrder saveSupplierOrder(SupplierOrder supplierOrder) {
        return supplierOrderRepository.save(supplierOrder);
    }

    @Override
    public SupplierOrder getSupplierOrderById(Long supplierOrderId) {
        return supplierOrderRepository.findOne(supplierOrderId);
    }
}
