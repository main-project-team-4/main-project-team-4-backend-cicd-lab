package com.example.demo.category;

import com.example.demo.category.dto.CategoryRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.demo.utils.ProxyTestRequest.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@MockBean(JpaMetamodelMappingContext.class)
class CategoryControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @WithMockUser(roles = {"ADMIN"})
    @Test
    @DisplayName("[정상 작동] createLarge의 Admin 인가 확인")
    void createLarge() throws Exception {
        // given
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setName("mock name1");

        // when & then
        mvc.perform(postAsJson("/api/categories", categoryRequestDto))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser(roles = {"ADMIN"})
    @Test
    @DisplayName("[정상 작동] createMiddle의 Admin 인가 확인")
    void createMiddle() throws Exception {
        // given
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setName("mock name1");

        // when & then
        mvc.perform(postAsJson("/api/categories/1/categories", categoryRequestDto))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser
    @Test
    @DisplayName("[정상 작동] read의 비로그인 인가 확인")
    void read() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/categories/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser
    @Test
    @DisplayName("[정상 작동] readChildCategory의 비로그인 인가 확인")
    void readChildCategory() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/categories/1/categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser
    @Test
    @DisplayName("[정상 작동] readChildItem의 비로그인 인가 확인")
    void readChildItem() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/categories/1/items"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser(roles = {"ADMIN"})
    @Test
    @DisplayName("[정상 작동] update의 Admin 인가 확인")
    void update() throws Exception {
        // given
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
        categoryRequestDto.setName("mock name1");

        // when & then
        mvc.perform(putAsJson("/api/categories/1", categoryRequestDto))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser(roles = {"ADMIN"})
    @Test
    @DisplayName("[정상 작동] delete의 Admin 인가 확인")
    void delete() throws Exception {
        // given

        // when & then
        mvc.perform(deleteWithCsrf("/api/categories/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}