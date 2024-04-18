package com.lth.ecommerce_backend.model;

public class PaymentDetails
{
    private String paymentMethod;
    private String status;
    private String paymentId;
    private String razorPaymentLinkId;
    private String razorPaymentLinkReferencedId;
    private String razorPaymentLinkStatus;
    private String razorpayPaymentId;

    public PaymentDetails() {
    }

    public PaymentDetails(String paymentMethod, String status, String paymentId, String razorPaymentLinkId, String razorPaymentLinkReferencedId, String razorPaymentLinkStatus, String razorpayPaymentId) {
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.paymentId = paymentId;
        this.razorPaymentLinkId = razorPaymentLinkId;
        this.razorPaymentLinkReferencedId = razorPaymentLinkReferencedId;
        this.razorPaymentLinkStatus = razorPaymentLinkStatus;
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRazorPaymentLinkId() {
        return razorPaymentLinkId;
    }

    public void setRazorPaymentLinkId(String razorPaymentLinkId) {
        this.razorPaymentLinkId = razorPaymentLinkId;
    }

    public String getRazorPaymentLinkReferencedId() {
        return razorPaymentLinkReferencedId;
    }

    public void setRazorPaymentLinkReferencedId(String razorPaymentLinkReferencedId) {
        this.razorPaymentLinkReferencedId = razorPaymentLinkReferencedId;
    }

    public String getRazorPaymentLinkStatus() {
        return razorPaymentLinkStatus;
    }

    public void setRazorPaymentLinkStatus(String razorPaymentLinkStatus) {
        this.razorPaymentLinkStatus = razorPaymentLinkStatus;
    }

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }
}
