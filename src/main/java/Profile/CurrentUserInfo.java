package Profile;

import sms.Users;

public class CurrentUserInfo {
    private static Users user;

    public  CurrentUserInfo(Users db_user){user = db_user;}
    public static Users getUser(){return user;}
    public static void setUser(Users u){user = u;}
}
