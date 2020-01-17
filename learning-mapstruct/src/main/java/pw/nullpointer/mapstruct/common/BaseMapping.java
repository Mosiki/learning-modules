package pw.nullpointer.mapstruct.common;

import org.mapstruct.*;

import java.util.List;
import java.util.stream.Stream;

@MapperConfig
public interface BaseMapping<SOURCE, TARGET> {

    /**
     * 映射同名属性
     */
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    TARGET sourceToTarget(SOURCE var1);

    /**
     * 反向，映射同名属性
     */
    @InheritInverseConfiguration(name = "sourceToTarget")
    SOURCE targetToSource(TARGET var1);

    /**
     * 映射同名属性，集合形式
     */
    @InheritConfiguration(name = "sourceToTarget")
    List<TARGET> sourceToTarget(List<SOURCE> var1);

    /**
     * 反向，映射同名属性，集合形式
     */
    @InheritConfiguration(name = "targetToSource")
    List<SOURCE> targetToSource(List<TARGET> var1);

    /**
     * 映射同名属性，集合流形式
     */
    List<TARGET> sourceToTarget(Stream<SOURCE> stream);

    /**
     * 反向，映射同名属性，集合流形式
     */
    List<SOURCE> targetToSource(Stream<TARGET> stream);
}
