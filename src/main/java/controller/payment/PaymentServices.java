/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.payment;

import io.github.cdimascio.dotenv.Dotenv;
import modal.OrderDetail;

import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

/**
 *
 * @author baoquoc
 */
public class PaymentServices {
    static Dotenv dotenv = Dotenv.load();
    private static final String CLIENT_ID = dotenv.get("CLIENT_ID");
    private static final String CLIENT_SECRET = dotenv.get("CLIENT_SECRET");
    private static final String LOCALHOST = dotenv.get("LOCALHOST");
    private static final String MODE = "sandbox";

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        Payment payment = new Payment().setId(paymentId);
        APIContext context = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return payment.execute(context, paymentExecution);
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext context = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(context, paymentId);
    }

    public String authorizePayment(OrderDetail orderDetail) throws PayPalRESTException {
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = gRedirectUrls();
        List<Transaction> transactionList = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(transactionList);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }
        return approvalLink;
    }

    private String convertNumberFromGermanToUsFormat(String germanNumber) {
        double usNumber = Double.parseDouble(germanNumber.replace(",", ".")) / 25000.0;
        String result = String.format("%.2f", usNumber);
        return result;
    }

    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        Details details = new Details();
        details.setSubtotal(convertNumberFromGermanToUsFormat(orderDetail.getTotalPrice()));

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(convertNumberFromGermanToUsFormat(orderDetail.getTotalPrice()));
        amount.setDetails(details);

        Item item = new Item();
        item.setCurrency("USD");
        item.setName("Movie Ticket");
        item.setPrice(convertNumberFromGermanToUsFormat(orderDetail.getTotalPrice()));
        item.setQuantity("1");

        List<Item> items = new ArrayList<Item>();
        items.add(item);

        ItemList itemList = new ItemList();
        itemList.setItems(items);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Buying movie ticket");
        transaction.setItemList(itemList);

        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        return transactions;
    }

    private RedirectUrls gRedirectUrls() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(LOCALHOST+"/manage-cinema/home");
        redirectUrls.setReturnUrl(LOCALHOST+"/manage-cinema/review_payment");

        return redirectUrls;
    }

    private Payer getPayerInformation() {
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("Bao")
                .setLastName("Quoc")
                .setEmail("managecinema2003@gmail.com");

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        payer.setPayerInfo(payerInfo);

        return payer;
    }

}
