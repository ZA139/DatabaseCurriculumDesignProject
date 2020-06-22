package tools;

public class SqlBackUp {
    //生成备份sql文件
    public static void backup() {
        try {
            //@SuppressWarnings("unused")
            Runtime.getRuntime().exec(
                    "cmd /c c:\\mysqldump -hlocalhost -uroot -proot --opt "+"databasecurriculumdesignproject"+">"+ "C:\\Users"
                            + "backup.sql");
            System.out.println("备份数据库成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("备份数据库失败");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    // 加载sql文件
    public static void load() {
        try {
            @SuppressWarnings("unused")
            Process process = Runtime.getRuntime().exec(
                    "cmd  /c  mysql -hlocalhost -uroot -proot " +"databasecurriculumdesignproject"+ " < " + "C:\\Users");
            System.out.println("恢复数据库成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("恢复数据库失败");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }

    }
}
