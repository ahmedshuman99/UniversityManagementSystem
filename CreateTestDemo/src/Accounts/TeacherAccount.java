
package Accounts;

/**
 *
 * @author ahmedshuman
 */
public class TeacherAccount extends UserAccount {
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final String specialization;

    private TeacherAccount(Builder builder) {
        super(builder);
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.specialization = builder.specialization;
    }

    public Integer getId() {
        return id;
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
}