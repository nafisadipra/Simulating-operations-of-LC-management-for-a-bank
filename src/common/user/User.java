package common.user;

/**
 *
 * @author Muyeed
 */
public class User {
    private String name;
    private String passowrd;
    private String email;
    private String phone;
    private String address;
    private String dob;
    private String type;
    private String state;
    private String country;
    private String nid;
    private String company;

    public User(String name, String passowrd, String email, String phone, String address, String dob, String type, String state, String country, String nid, String company) {
        this.name = name;
        this.passowrd = passowrd;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.type = type;
        this.state = state;
        this.country = country;
        this.nid = nid;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", passowrd=" + passowrd + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dob=" + dob + ", type=" + type + ", state=" + state + ", country=" + country + ", nid=" + nid + ", company=" + company + '}';
    }
    
}
