package pw.nullpointer.easypoi.import1.service;

import org.springframework.stereotype.Service;
import pw.nullpointer.easypoi.import1.TalentUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WeJan
 * @since 2019-12-28
 */
@Service
public class MockTalentDataService {
    private static List<TalentUser> talentUsers = new ArrayList<>();
    static {
        TalentUser u1 = new TalentUser(1L, "凌风", "18311342567");
        TalentUser u2 = new TalentUser(2L, "张三", "18512343567");
        TalentUser u3 = new TalentUser(3L, "李四", "18902343267");
        talentUsers.add(u1);
        talentUsers.add(u2);
        talentUsers.add(u3);
    }

    /**
     * 校验是否重复
     */
    public boolean checkForDuplicates(String name, String phone) {
        // 姓名与手机号相等个数不等于0则为重复
        return talentUsers.stream().anyMatch(e -> e.getName().equals(name) && e.getPhone().equals(phone));
    }
}
