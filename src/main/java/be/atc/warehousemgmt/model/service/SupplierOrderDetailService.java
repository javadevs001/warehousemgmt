package be.atc.warehousemgmt.model.service;


import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderDetail;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderDetailType;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 22/08/16.
 */
public interface SupplierOrderDetailService {

    List<SupplierOrderDetail> getAll();

    List<SupplierOrderDetail> findBySupplierOrderDetailTypeAndArticle(SupplierOrderDetailType supplierOrderDetailType, Article article);

    SupplierOrderDetail save(SupplierOrderDetail supplierOrderDetail);

    void delete(SupplierOrderDetail supplierOrderDetail);

    boolean exists(Long supplierOrderDetailId);

}
