package pw.nullpointer.design.state;

import lombok.Getter;

/**
 * @author WeJan
 * @since 2020-02-27
 */
@Getter
public enum ActivityStateEnum {
    DRAFT(1, "草稿箱"),
    ENABLE(2, "已启用"),
    START(3, "进行中"),
    DISABLE(4, "已停用"),
    FINISH(5, "已结束")
    ;

    private Integer code;
    private String desc;

    ActivityStateEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
