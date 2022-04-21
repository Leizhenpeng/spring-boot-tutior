package com.example.local_map_restful.control;

import com.example.local_map_restful.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * @author river
 */
@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "用户接口")
public class UserController {

    /*创建 线程安全的 hashmap*/

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * 随便测试一下
     * @return string
     */
    @GetMapping("/")
    @Operation(summary = "测试接口", description = "测试接口")
    public String getUsers() {
        return "u made it";
    }

    /**
     * 获取用户列表
     * @return List<User>
     */
    @GetMapping("/list")
    @Operation(summary = "获取用户列表", description = "获取用户列表")
    public List<User> getUser() {
        return new ArrayList<>(users.values());
    }

    /**
     * 新增一个用户
     * @param user    用户信息
     * @return string
     */
    @PostMapping("/add")
    @Operation(summary = "新增用户", description = "新增用户")
    public String addUser(@Valid @RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    /**
     * 根据id获取用户
     * @param id    用户id
     * @return User
     */
    @GetMapping("/{id}")
    @Parameters({
            @Parameter(name = "id", description = "用户id", required = true)
    })
    @Operation(summary = "根据id获取用户", description = "根据id获取用户")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }


    /**
     * 根据id修改用户
     *
     * 这里是 是修改部分的内容,应该用
     * @param id    用户id
     * @param user      用户信息
     * @return string
     */
    @PutMapping("/{id}")
    @Operation(summary = "根据id修改用户", description = "根据id修改用户")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }


    /**
     * 根据id删除用户
     * @param id    用户id
     * @return string
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除用户", description = "根据id删除用户")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
