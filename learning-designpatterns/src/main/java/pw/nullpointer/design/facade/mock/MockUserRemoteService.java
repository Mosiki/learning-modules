package pw.nullpointer.design.facade.mock;

import org.springframework.stereotype.Service;
import pw.nullpointer.design.facade.dto.UserInfo;

/**
 * @author WeJan
 * @since 2020-03-03
 */
@Service
public class MockUserRemoteService {

    public boolean isNewUser(Long userId) {
        // TODO 调用远程接口
        return true;
    }

    public UserInfo getUserInfo(Long userId) {
        // TODO 调用远程接口
        return new UserInfo();
    }
}
