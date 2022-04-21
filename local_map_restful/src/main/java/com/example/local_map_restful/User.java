package com.example.local_map_restful;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author river
 */
@Data
@Schema(description = "用户信息")
public class User {
    private Long id;
    @Schema(description = "名称", required = true, example = "张三")
    private String name;
    private Integer age;
}
