public class Business {

    private String username;
    private String email;
    private String phone;
    private String address;
    private int id;

    public Business() {
        // Default constructor
    }

    public Business(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Business(int identity, String username, String email, String ph) {
        this.username = username;
        this.email = email;
        this.phone = ph;
        this.id = identity;
    }

    public void getBusiness(int i) {

        BusinessDTO empDTO = buildDTO(this.getID(), this.getUsername(), this.getEmail());

        this.setID(empDTO.getID());
        this.setUsername(empDTO.getUsername());
        this.setEmail(empDTO.getEmail());

    }

    public static BusinessDTO buildDTO(int empID, String name, String email) {

        BusinessDTO theDTO = new BusinessDTO(empID, name, email);
        return theDTO;

    }


    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID() {
        return id;
    }

    public void setID(int idNum) {
        this.id = idNum;
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

    public void setPhone(String ph) {
        this.phone = ph;
    }
    public void setAddress(String b) {
        this.address = b;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {

        String empString =  " ID-" + this.getID() + ", " + " Name-" + this.getUsername() + ", " + "Email-" + this.getEmail() + ", " + "Phone-" + this.getPhone();
        return empString;
    }

}
