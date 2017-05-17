package user.service;

import user.entity.User;

/**
 * Created by changbohong on 2017/5/16.
 */
public interface UserService {
    /**
     * 检查密码正确
     * @param name
     * @return
     */
    public boolean checkPassword(User user);
}
