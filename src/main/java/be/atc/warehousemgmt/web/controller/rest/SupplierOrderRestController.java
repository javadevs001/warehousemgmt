package be.atc.warehousemgmt.web.controller.rest;

import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.model.service.SupplierOrderService;
import be.atc.warehousemgmt.util.SupplierOrderDocumentGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ahmedidoumhaidi on 21/08/16.
 */

@RequestMapping(value = "/api/secured/SupplierOrderRestController/")
@RestController
public class SupplierOrderRestController {

    @Autowired
    private SupplierOrderService supplierOrderService;

    @RequestMapping(value = "deleteOrderDetail/{supplierOrderDetailId}", method = RequestMethod.POST)
    public ResponseEntity<JSResponse> deleteOrderDetail(@PathVariable Long supplierOrderDetailId) {
        OrderDetail supplierOrderDetailById = supplierOrderService.findSupplierOrderDetailById(supplierOrderDetailId);
        supplierOrderDetailById.setArchived(true);
        supplierOrderService.saveSupplierOrdersDetail(supplierOrderDetailById);
        return new ResponseEntity<>(JSResponse.of(true, "SUCCESS"), HttpStatus.OK);
    }

    @RequestMapping(value = "deleteSupplierOrder/{supplierOrderId}", method = RequestMethod.POST)
    public ResponseEntity<JSResponse> deleteSupplierOrder(@PathVariable Long supplierOrderId) {
        Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrderId);
        supplierOrderService.findAllSupplierOrderDetailBySupplierOrder(supplierOrders).stream().forEach((dd) -> {
            dd.setArchived(true);
            supplierOrderService.saveSupplierOrdersDetail(dd);
        });
        supplierOrders.setArchived(true);
        supplierOrderService.saveSupplierOrder(supplierOrders);
        return new ResponseEntity<>(JSResponse.of(true, "SUCCESS"), HttpStatus.OK);
    }

    @RequestMapping(value = "getSupplierOrderDocument", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public FileSystemResource getSupplierOrderDocument(@RequestParam Long supplierOrderId, HttpServletResponse response) throws Exception {
        SupplierOrderDocumentGenerator supplierOrderDocumentGenerator = new SupplierOrderDocumentGenerator();
        Orders supplierOrders = supplierOrderService.findSupplierOrders(supplierOrderId);
        List<OrderDetail> allSupplierOrderDetailBySupplierOrder = supplierOrderService.findAllSupplierOrderDetailBySupplierOrder(supplierOrders).stream().filter((d) -> !d.isArchived()).collect(Collectors.toList());
        supplierOrderDocumentGenerator.process(supplierOrders, allSupplierOrderDetailBySupplierOrder);
        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "filename=\"" + supplierOrderDocumentGenerator.getTargetFile() + "\"");
        return new FileSystemResource(supplierOrderDocumentGenerator.getTargetFile());
    }
}
