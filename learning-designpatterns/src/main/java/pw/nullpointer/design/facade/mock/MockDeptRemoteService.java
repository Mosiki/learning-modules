package pw.nullpointer.design.facade.mock;

import org.springframework.stereotype.Service;
import pw.nullpointer.design.facade.dto.DeptInfo;

/**
 * @author WeJan
 * @since 2020-03-03
 */
@Service
public class MockDeptRemoteService {
    public DeptInfo getDeptInfo(Long userId) {
        // TODO 调用远程接口
        return new DeptInfo();
    }
}
