package com.example.local_map_restful;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;

/**
 * @author river
 */
@Data
@Schema(description = "用户信息")
public class User {
	@Schema(description = "ID", required = true, example = "1")
	private Long id;

	@Schema(description = "名称", required = true, example = "张三")
	@NotNull
	private String name;

	@Max(10)
	@Min(1)
	@Schema(description = "年龄", required = true, example = "10")
	private Integer age;

}
