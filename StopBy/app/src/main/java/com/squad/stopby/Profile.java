package com.squad.stopby;

import com.google.firebase.auth.FirebaseAuth;

/**
<<<<<<< HEAD
 * Created by Yuanjian on 3/15/2018.
=======
 * Created by Yuanjian on 3/25/2018.
>>>>>>> 1dbe265afb7e0ca77ead138fcdb35406c3e85b80
 */

public class Profile {
    private String username;
    private String email;
    private String password;
    private String userInfo;
    private String uID;




    public Profile(String username, String email, String password, String userInfo, String uid) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.uID = uid;

    }

    public String getUsername() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getuID(){
        return uID;
    }

    public void setuID(String uid){
        this.uID = uid;
    }

}
