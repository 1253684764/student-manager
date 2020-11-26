package entity;

/**
 * @ClassName adminName
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/18 22:31
 **/
public class AdminName {
    private static String adminName;

    public static String getAdminName() {
        return adminName;
    }

    public static void setAdminName(String adminName) {
        AdminName.adminName = adminName;
    }
}
