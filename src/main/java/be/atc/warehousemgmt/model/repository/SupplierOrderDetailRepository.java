package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderDetail;
import be.atc.warehousemgmt.model.entity.orders.SupplierOrderDetailType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 22/08/16.
 */

public interface SupplierOrderDetailRepository extends JpaRepository<SupplierOrderDetail, Long> {

    List<SupplierOrderDetail> findBySupplierOrderDetailTypeAndArticle(SupplierOrderDetailType supplierOrderDetailType, Article article);
}





