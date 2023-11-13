/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Accounts;

/**
 *
 * @author ahmedshuman
 */
public class UserAccount {
    private final String name;
    private final  String email;
    private final String password;
    
    UserAccount(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public static class Builder {
        private String name;
        private String email;
        private String password;
        
       public Builder setName(String name) {
            this.name = name;
            return this;
          
        }
        
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        
        public UserAccount build() {
            return new UserAccount(this);
        }

        
        
    }
}




