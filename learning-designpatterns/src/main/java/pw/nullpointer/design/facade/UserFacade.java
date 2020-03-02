package pw.nullpointer.design.facade;

import org.springframework.stereotype.Component;
import pw.nullpointer.design.facade.dto.DeptInfo;
import pw.nullpointer.design.facade.dto.UserInfo;
import pw.nullpointer.design.facade.mock.MockDeptRemoteService;
import pw.nullpointer.design.facade.mock.MockUserRemoteService;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-03-03
 */
@Component
public class UserFacade {
    @Resource
    private MockUserRemoteService userRemoteService;
    @Resource
    private MockDeptRemoteService deptRemoteService;

    /**
     * 判断是否是新用户
     */
    public boolean isNewUser(Long userId) {
        return userRemoteService.isNewUser(userId);
    }

    /**
     * 获取用户信息
     */
    public UserInfo getUserInfo(Long userId) {
        return userRemoteService.getUserInfo(userId);
    }

    /**
     * 获取用户部门信息
     */
    public DeptInfo getDeptInfo(Long userId) {
        return deptRemoteService.getDeptInfo(userId);
    }

}
