package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderDetail;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderDetailType;
import be.atc.warehousemgmt.model.repository.SupplierOrderDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ahmedidoumhaidi on 22/08/16.
 * Ce service est utilisé par le gestionnaire des commandes client pour insérer les détails de commandes fournisseurs à traiter.
 */

@Service
@Transactional
public class SupplierOrderDetailServiceImpl implements SupplierOrderDetailService {

    @Inject
    private SupplierOrderDetailRepository supplierOrderDetailRepository;


    @Override
    @Transactional(readOnly = true)
    public List<SupplierOrderDetail> getAll() {
        return supplierOrderDetailRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierOrderDetail> findBySupplierOrderDetailTypeAndArticle(SupplierOrderDetailType supplierOrderDetailType, Article article) {
        return supplierOrderDetailRepository.findBySupplierOrderDetailTypeAndArticle(supplierOrderDetailType, article);
    }

    @Override
    public SupplierOrderDetail save(SupplierOrderDetail supplierOrderDetail) {
        return supplierOrderDetailRepository.save(supplierOrderDetail);
    }

    @Override
    public void delete(SupplierOrderDetail supplierOrderDetail) {
        supplierOrderDetailRepository.delete(supplierOrderDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(Long supplierOrderDetailId) {
        return supplierOrderDetailRepository.exists(supplierOrderDetailId);
    }
}
