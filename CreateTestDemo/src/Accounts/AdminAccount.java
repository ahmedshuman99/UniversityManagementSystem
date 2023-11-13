/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Accounts;

/**
 *
 * @author ahmedshuman
 */
public class AdminAccount extends UserAccount {

    public AdminAccount(Builder builder) {
        super(builder);
    }

    public static class Builder extends UserAccount.Builder {
       
    }
}