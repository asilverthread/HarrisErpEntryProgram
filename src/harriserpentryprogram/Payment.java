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
public class Payment {

    //Constructors
    public Payment(float amount) {
        this.amount = amount;
    }
    
    public Payment(){
        //Nothing
    }

    //Getters and Setters
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    //Class Methods
    @Override
    public String toString(){
        return "This is a payment in the amount of: "+Float.toString(amount);
    }
      
    //Declarations
    private float amount;
}
