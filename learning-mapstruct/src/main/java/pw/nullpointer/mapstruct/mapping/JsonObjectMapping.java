package pw.nullpointer.mapstruct.mapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.mapstruct.Mapper;
import pw.nullpointer.mapstruct.dto.UserVo.UserConfig;

import java.util.List;

@Mapper
public class JsonObjectMapping {
    public String asString(List<UserConfig> list) {
        return JSON.toJSONString(list);
    }

    public List<UserConfig> asObject(String string) {
        return JSON.parseObject(string, new TypeReference<List<UserConfig>>() {
        });
    }
}