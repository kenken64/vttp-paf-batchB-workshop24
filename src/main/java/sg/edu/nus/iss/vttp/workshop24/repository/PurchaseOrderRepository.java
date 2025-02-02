package sg.edu.nus.iss.vttp.workshop24.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp.workshop24.models.PurchaseOrder;

import static sg.edu.nus.iss.vttp.workshop24.repository.Queries.*;

@Repository
public class PurchaseOrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertPurchaseOrder(PurchaseOrder po){
        return jdbcTemplate.update(SQL_INSERT_PURCHASE_ORDER
            , po.getOrderId(), po.getName()) > 0;
    }
}
