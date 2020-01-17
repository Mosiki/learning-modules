package pw.nullpointer.mapstruct.mapping;

import com.alibaba.fastjson.JSON;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pw.nullpointer.mapstruct.common.BaseMapping;
import pw.nullpointer.mapstruct.domain.User;
import pw.nullpointer.mapstruct.dto.UserVo;
import pw.nullpointer.mapstruct.dto.UserVo.UserConfig;

import java.util.List;

/**
 * @author WeJan
 * @since 2020-01-17
 */
// import org.mapstruct.Mapper;
@Mapper(componentModel = "spring"/*, uses = JsonObjectMapping.class*/, unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapping extends BaseMapping<User, UserVo> {

    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    UserVo sourceToTarget(User var1);

    @Mapping(target = "sex", source = "gender")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    User targetToSource(UserVo var1);

    default List<UserConfig> strConfigToListUserConfig(String config) {
        return JSON.parseArray(config, UserConfig.class);
    }

    default String listUserConfigToStrConfig(List<UserConfig> list) {
        return JSON.toJSONString(list);
    }
}
