package inside_payment.controller;

import inside_payment.domain.*;
import inside_payment.service.InsidePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
@RestController
public class InsidePaymentController {
    @Autowired
    InsidePaymentService service;

    @RequestMapping(value="/inside_payment/pay", method = RequestMethod.POST)
    public boolean pay(@RequestBody PaymentInfo info){
        return service.pay(info);
    }

    @RequestMapping(value="/inside_payment/createAccount", method = RequestMethod.POST)
    public boolean createAccount(@RequestBody CreateAccountInfo info){
        return service.createAccount(info);
    }

    @RequestMapping(value="/inside_payment/addMoney", method = RequestMethod.POST)
    public boolean addMoney(@RequestBody AddMoneyInfo info){
        return service.addMoney(info);
    }

    @RequestMapping(value="/inside_payment/queryPayment", method = RequestMethod.GET)
    public List<Payment> queryPayment(){
        return service.queryPayment();
    }

    @RequestMapping(value="/inside_payment/queryAccount", method = RequestMethod.GET)
    public List<Balance> queryAccount(){
        return service.queryAccount();
    }
}