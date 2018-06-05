/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harriserpentryprogram;

/**
 *
 * @author zacha
 */
public class Transaction {
    
    //Constructors
    public Transaction(Payment payment, Fee fee, float amount) {
        this.payment = payment;
        this.fee = fee;
        this.amount = amount;
        System.out.println("New transaction created with payment, fee, and amount as follows:");
        System.out.println("p: "+payment.toString()+" f: "+fee.toString()+" a: "+Float.toString(amount));
    }
    
    public Transaction(){
        //Nothing
    }
    
    //Getters and Setters
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Float getAmount() {
        return amount;
    }
    
    //Class Methods
    @Override
    public String toString(){
        return "Amount of this Transaction: "+Float.toString(amount);
    }

    //Declarations
    public void setAmount(float amount) {
        this.amount = amount;
    }
    private Payment payment;
    private Fee fee;
    private float amount;
}
