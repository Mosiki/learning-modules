package pw.nullpointer.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pw.nullpointer.design.App;
import pw.nullpointer.design.facade.UserFacade;
import pw.nullpointer.design.facade.dto.DeptInfo;
import pw.nullpointer.design.facade.dto.UserInfo;

import javax.annotation.Resource;

/**
 * @author WeJan
 * @since 2020-03-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class FacadeTest {
    @Resource
    protected UserFacade userFacade;

    @Test
    public void test1() {
        long userId = 11L;
        UserInfo userInfo = userFacade.getUserInfo(userId);
        DeptInfo deptInfo = userFacade.getDeptInfo(userId);
    }
}
