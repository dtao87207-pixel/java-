package students;

public class User {
    private String username;
    private  String id;
    private  String telephone;
    private String password;


    public User() {
    }

    public User(String username, String id, String telephone) {
        this.username = username;
        this.id = id;
        this.telephone = telephone;
    }

    public User(String username, String id, String telephone, String password) {
        this.username = username;
        this.id = id;
        this.telephone = telephone;
        this.password = password;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String toString() {
        return "User{username = " + username + ", id = " + id + ", telephone = " + telephone + "}";
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
