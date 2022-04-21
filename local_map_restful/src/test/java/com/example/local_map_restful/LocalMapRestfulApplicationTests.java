package com.example.local_map_restful;

import com.example.local_map_restful.control.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class LocalMapRestfulApplicationTests {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }


    @Test
    void contextLoads() throws Exception {
        RequestBuilder request;
       // 测试链接成功
        request = get("/user/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("u made it"));
      // 获取用户列表,应该为空
        request = get("/user/list");
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 1.插入数据
        request = post("/user/add").contentType(MediaType.APPLICATION_JSON).content(
                "{\"id\":\"1\",\"name\":\"test\",\"age\":\"20\"}"
        );
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

        // get获取user列表，应该有刚才插入的数据
        request = get("/user/list");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"test\",\"age\":20}]")));
        request = get("/user/1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"test\",\"age\":20}")));

        // 修改用户信息
        request = put("/user/1").contentType(MediaType.APPLICATION_JSON).content(
                "{\"name\":\"test1\",\"age\":\"21\"}");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));
        request = get("/user/1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"test1\",\"age\":21}")));

        // 删除用户
        request = delete("/user/1");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));
        request = get("/user/list");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}
