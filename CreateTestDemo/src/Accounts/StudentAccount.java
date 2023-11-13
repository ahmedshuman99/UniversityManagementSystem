
package Accounts;
/**
 *
 * @author ahmedshuman
 */
public class StudentAccount extends UserAccount{
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final Double balance;
    private final String specialization;

       private StudentAccount(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.balance = builder.balance;
        this.specialization = builder.specialization;
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
    public Integer getId() {
        return id;
    }
    public Double getBalance() {
        return balance;
    }

    public String getSpecialization() {
        return specialization;
    }
//__________________________________________________
public static class Builder extends UserAccount.Builder {
        private String name;
        private String email;
        private String password;
        private Integer id;
        private Double balance;
        private String specialization;

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

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }
        
         public Builder setBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }
         @Override
        public StudentAccount build() {
            return new StudentAccount(this);
        }
}
 
}
   /*public class StudentAccount extends UserAccount {
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final String specialization;

    private StudentAccount(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.balance = builder.balance
        this.specialization = builder.specialization;
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
    public Integer getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public static class Builder extends UserAccount.Builder {
        private String name;
        private String email;
        private String password;
        private Integer id;
        private String specialization;

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

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        @Override
        public TeacherAccount build() {
            return new TeacherAccount(this);
        }
    }
}*/