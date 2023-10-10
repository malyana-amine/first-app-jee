import com.example.first_app_jee.Dao.Users.UserDao;
import com.example.first_app_jee.Dao.Users.UserDaoImp;
import com.example.first_app_jee.Entities.Users;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImp();
        Users user = new Users("Abdeessalam");
        userDao.add(user);

    }
}
