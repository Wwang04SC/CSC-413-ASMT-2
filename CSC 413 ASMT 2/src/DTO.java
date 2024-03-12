import java.sql.SQLException;
public class DTO {
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;

    static DAOConcrete ed = new DAOConcrete();

    public DTO(){}
    public DTO(int busID, String username, String email){
        this.username = username;
        this.email = email;
        id = busID;
    }

    public DTO(String username, String email, String phoneNumber){
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getID() {

        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public static Business accountByID(int anID){
        Business anBus = null;

        try{
            anBus = ed.get(anID);
        } catch(SQLException se){
            System.out.println(se.getMessage());
        }
        if(anBus != null) System.out.println(anBus.toString());

        System.out.println("\nAccount ID: " + anID + "\n Details:\n" + anBus.toString());
        return anBus;
    }

    public static int update(Business anBus){
        int updateResult = -1;

        try{
            updateResult = ed.update(anBus);
        } catch(SQLException se){
            System.out.println(se.getMessage());
        }
        if(updateResult != -1) System.out.println("\nUpdate Successful");
        System.out.println(" Details:\n" + anBus.toString());
        return updateResult;
    }
}
