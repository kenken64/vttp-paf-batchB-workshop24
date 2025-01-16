package sg.edu.nus.iss.vttp.workshop24.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.vttp.workshop24.exception.OrderException;
import sg.edu.nus.iss.vttp.workshop24.models.PurchaseOrder;
import sg.edu.nus.iss.vttp.workshop24.repository.LineItemRepository;
import sg.edu.nus.iss.vttp.workshop24.repository.PurchaseOrderRepository;

@Service
public class OrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(PurchaseOrder po) throws OrderException{
        String orderId = UUID.randomUUID().toString().substring(0,8 );
        System.out.println("Order Id >>>> %s".formatted(orderId));
        System.out.println(po);
        po.setOrderId(orderId);
        purchaseOrderRepository.insertPurchaseOrder(po);
        if(po.getLineItems().size() > 5){
            throw new OrderException("Maximum 5 items allowed in an order");
        }
        lineItemRepository.addLineItems(po);
    }
}
