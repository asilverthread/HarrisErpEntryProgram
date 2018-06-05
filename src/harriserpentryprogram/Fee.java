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
public class Fee {

    //Constructors
    public Fee(float amount, String name) {
        this.amount = amount;
        this.name = name;
    }
    
    public Fee(){
        //Nothing
    }
    
    //Getters and Setters
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    public boolean getCompletion(){
        return isSatisfied;
    }
    
    public void setCompletion(boolean isSatisfied){
        this.isSatisfied = isSatisfied;
    }
    */
    //Class Methods
    @Override
    public String toString(){
        return "Fee name: "+name+", Amount: "+Float.toString(amount);
    }
    
    //Declarations
    private float amount;
    private String name;
    //private boolean isSatisfied;
}
