/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harriserpentryprogram;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author zacha
 */
public class PaymentHandler {
    //Constructors
    public PaymentHandler(){
        resetLists();
    }

    public PaymentHandler(ArrayList<Payment> payList, ArrayList<Fee> feeList) {
        this.payList = payList;
        this.feeList = feeList;
        resetLists();
    }
    
    //Getters and Setters
    public ArrayList<Payment> getPayments(){
        return payList;
    }
    public ArrayList<Fee> getFees(){
        return feeList;
    }
    public ArrayList<Transaction> getTransactions(){
        return transactionList;
    }
    
    //Class Methods
    public void addPayment(Payment p){
        if (p.getAmount() >= 0){
            payList.add(p);
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Only positive numbers are accepted!");
        }
    }
    
    public void addFee(Fee f){
        if (f.getAmount() >= 0){
            feeList.add(f);
        }else{
            JOptionPane.showMessageDialog(new JFrame(),"Only positive numbers are accepted!");
        }
    }
    
    public void applyPayments(){
        applyPayment(0,0);
    }
    
    public void applyPayment(int pIdx,int fIdx){//Looks like someone was paying attention to recursion in college
        if (!(pIdx>=payList.size()||fIdx>=feeList.size())){
            Payment p = payList.get(pIdx);
            Fee f = feeList.get(fIdx);
            //If the amount of the Payment is greater than the amount of the Fee, we need to apply some of the Payment to a following Fee, so step the fee forward and continue working with this payment
            if (p.getAmount() > f.getAmount()){
                transactionList.add(new Transaction(p,f,f.getAmount()));
                p.setAmount(p.getAmount() - f.getAmount());
                applyPayment(pIdx,fIdx+1);
            }
            //If the amount of the Fee is greater than the Amount of the Payment, we need to use another Payment to satisfy the rest of this Fee, so step the payment forward and continue working with this fee
            else if(f.getAmount() > p.getAmount()){
                transactionList.add(new Transaction(p,f,p.getAmount()));
                f.setAmount(f.getAmount() - p.getAmount());
                applyPayment(pIdx+1,fIdx);
            }
            //If they are equal, we are good, step forward on each list
            else if(p.getAmount() == f.getAmount()){
                transactionList.add(new Transaction(p,f,f.getAmount()));
                f.setAmount(0);
                applyPayment(pIdx+1,fIdx+1);
            }
            //If code makes it here, the payment application probably failed and we should inform the user
            else{
                System.err.println("There was an error applying your payment, Sorry!");
            }
        }
    }
    
    public void totalFees(){
        float total = 0f;
        for(Fee f:feeList){
            total+=f.getAmount();
        }
    }
    
    public void totalPayments(){
        float total = 0f;
        for(Payment p:payList){
            total+=p.getAmount();
        }
        System.out.println(total);
    }
    
    public void printTransactions(){//For debugging
        transactionList.forEach((t)->{
            System.out.println(t.toString());
        });
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Old "applyPayment" method ">
    /*
    private void applyPayment(Payment p, Fee f){
        //If the amount of the Payment is greater than the amount of the Fee, we need to apply some of the Payment to a following Fee
        if (p.getAmount() > f.getAmount()){
            transactionList.add(new Transaction(p,f,f.getAmount()));
            f.setCompletion(true);
        }
        //If the amount of the Fee is greater than the Amount of the Payment, we need to use another Payment to satisfy the rest of this Fee
        else if(f.getAmount() > p.getAmount()){
            transactionList.add(new Transaction(p,f,f.getAmount() - p.getAmount()));            
            f.setCompletion(false);
        }
        //
        else if(p.getAmount() == f.getAmount()){
            transactionList.add(new Transaction(p,f,f.getAmount()));
            f.setCompletion(true);
        }
        //
        else{
            //Inform the user that their payment could not be applied
            System.err.println("Failure applying payment!");
        }
    }*/
    //</editor-fold>
    
    /*
    //<editor-fold defaultstate="collapsed" desc="Old "applyPayments" method">
    public void applyPayments(){
        for (Payment p:payList){
            for(Fee f:feeList){
                if (f.getCompletion()== false){
                    applyPayment(p,f);
                }
            }
        }
        transactionList.forEach((t)->{
            System.out.println(t.toString());
        });
    }*/
    
    //</editor-fold>
    
    public void resetLists(){
        payList = new ArrayList<>();
        feeList =  new ArrayList<>();
        transactionList = new ArrayList<>();
    }
    
    //Declarations
    private ArrayList<Payment> payList;
    private ArrayList<Fee> feeList;
    private ArrayList<Transaction> transactionList;
}
