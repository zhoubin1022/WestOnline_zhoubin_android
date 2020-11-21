package com.company;

/**
 * create By zb on 2020/11/5.
 */
public class OverdraftBalanceException extends RuntimeException {
    public OverdraftBalanceException(double balance){
        System.out.println("Your account'money is not enough,and it still need "+balance+" yuan");
    }
}
