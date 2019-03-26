package jit.manage.pojo;

/**
 * Created by sunlotus on 2019/2/21.
 */
public class User {
    private String userId;
    private String userName;
    private String userPW;
    private String userUid;
    private String image;


    public User(String userId, String userName, String userPW, String userUid, String image) {
        this.userId = userId;
        this.userName = userName;
        this.userPW = userPW;
        this.userUid = userUid;
        this.image = image;
    }

    public User(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPW() {
        return userPW;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPW='" + userPW + '\'' +
                ", userUid=" + userUid +
                ", image='" + image + '\'' +
                '}';
    }
}
