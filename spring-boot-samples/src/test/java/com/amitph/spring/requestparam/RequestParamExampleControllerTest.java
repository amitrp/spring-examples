package com.amitph.spring.requestparam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(controllers = RequestParamExampleController.class)
class RequestParamExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSingleParam() throws Exception {
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.get("/data1?id=222"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), 200);
        assertEquals("id: 222", new String(response.getContentAsByteArray()));
    }

    @Test
    public void testMultiParam() throws Exception {
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.get("/data2?id=543&name=Jon"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), 200);
        assertEquals("id: 543, name: Jon", new String(response.getContentAsByteArray()));
    }

    @Test
    public void testTypedParam() throws Exception {
        MockHttpServletResponse response1 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data3?id=NaN"))
                .andReturn().getResponse();

        assertEquals(response1.getStatus(), 400);

        MockHttpServletResponse response2 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data3?id=102"))
                .andReturn().getResponse();

        assertEquals(response2.getStatus(), 200);
        assertEquals("id: 102", new String(response2.getContentAsByteArray()));
    }

    @Test
    public void testMultiValueParams() throws Exception {
        MockHttpServletResponse response1 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data4?id=6,3,5"))
                .andReturn().getResponse();

        assertEquals(response1.getStatus(), 200);
        assertEquals("id: [6, 3, 5]", new String(response1.getContentAsByteArray()));

        MockHttpServletResponse response2 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data4?id=1&id=5"))
                .andReturn().getResponse();

        assertEquals(response2.getStatus(), 200);
        assertEquals("id: [1, 5]", new String(response2.getContentAsByteArray()));
    }

    @Test
    public void testOptionalParams() throws Exception {
        MockHttpServletResponse response1 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data5"))
                .andReturn().getResponse();

        assertEquals(response1.getStatus(), 200);
        assertEquals("id: null", new String(response1.getContentAsByteArray()));

        MockHttpServletResponse response2 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data5?id=1"))
                .andReturn().getResponse();

        assertEquals(response2.getStatus(), 200);
        assertEquals("id: 1", new String(response2.getContentAsByteArray()));
    }

    @Test
    public void testJavaOptionalParams() throws Exception {
        MockHttpServletResponse response1 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data6"))
                .andReturn().getResponse();

        assertEquals(response1.getStatus(), 200);
        assertEquals("id: Unknown", new String(response1.getContentAsByteArray()));

        MockHttpServletResponse response2 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data6?id=1"))
                .andReturn().getResponse();

        assertEquals(response2.getStatus(), 200);
        assertEquals("id: 1", new String(response2.getContentAsByteArray()));
    }

    @Test
    public void testDefaultValueParams() throws Exception {
        MockHttpServletResponse response1 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data7"))
                .andReturn().getResponse();

        assertEquals(response1.getStatus(), 200);
        assertEquals("id: Unknown", new String(response1.getContentAsByteArray()));

        MockHttpServletResponse response2 = mockMvc
                .perform(MockMvcRequestBuilders.get("/data7?id=10"))
                .andReturn().getResponse();

        assertEquals(response2.getStatus(), 200);
        assertEquals("id: 10", new String(response2.getContentAsByteArray()));
    }

    @Test
    public void testNamedParams() throws Exception {
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.get("/data8?id=Mac"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), 200);
        assertEquals("dataId: Mac", new String(response.getContentAsByteArray()));
    }

    @Test
    public void testMappedParams() throws Exception {
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.get("/data9?k1=v1&k2=v2"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), 200);
        assertEquals("{k1=v1, k2=v2}", new String(response.getContentAsByteArray()));
    }
}