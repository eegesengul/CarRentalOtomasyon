abstract public class User {
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    final protected boolean admin;

    public User(String firstName, String lastName, String username, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

        if(username.equalsIgnoreCase("Admin")){
            this.admin=true;
        }
        else{
            this.admin=false;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin(){
        return admin;
    }


    public abstract void displayInfo();

    //public abstract boolean girisDogrulama(String girilenSifre);

}
