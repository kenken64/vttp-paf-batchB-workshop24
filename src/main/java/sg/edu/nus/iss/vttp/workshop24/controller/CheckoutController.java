package sg.edu.nus.iss.vttp.workshop24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.vttp.workshop24.exception.OrderException;
import sg.edu.nus.iss.vttp.workshop24.models.LineItem;
import sg.edu.nus.iss.vttp.workshop24.models.PurchaseOrder;
import sg.edu.nus.iss.vttp.workshop24.service.OrderService;

@Controller
@RequestMapping(path="/checkout")
public class CheckoutController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String postCheckout(Model model, HttpSession sess) throws OrderException{
        List<LineItem> lineItems = (List<LineItem>)sess
                                    .getAttribute("cart");
        PurchaseOrder po = (PurchaseOrder) sess.getAttribute("checkoutCart");
        System.out.println(po);
        orderService.createNewOrder(po);
        sess.invalidate();
        model.addAttribute("total", lineItems.size());
        return "checkout";
    }
}
