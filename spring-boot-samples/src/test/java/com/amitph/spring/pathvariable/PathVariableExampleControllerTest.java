package com.amitph.spring.pathvariable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Random;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PathVariableExampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        PathVariableExampleController controller = new PathVariableExampleController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void mapSimplePathVariable_readsAndReturnsPathVariable() throws Exception {
        String id = randomUUID().toString();
        String response = mockMvc.perform(get("/v1/students/" + id))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id, response);
    }

    @Test
    public void mapPathVariableByName_readsByNameAndReturnsPathVariable() throws Exception {
        String id = randomUUID().toString();
        String response = mockMvc.perform(get("/v2/students/" + id))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id, response);
    }

    @Test
    public void mapMultiplePathVariables_readsAndReturnsMultiplePathVariable() throws Exception {
        String id = randomUUID().toString();
        String termId = randomUUID().toString();

        String response = mockMvc.perform(get("/v3/students/" + id + "/terms/" + termId))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id + ", term id: " + termId, response);
    }

    @Test
    public void mapMultiplePathVariablesAsMap_readsAndReturnsMultiplePathVariableAsMap() throws Exception {
        String id = randomUUID().toString();
        String termId = randomUUID().toString();

        String response = mockMvc.perform(get("/v4/students/" + id + "/terms/" + termId))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        assertEquals(Map.of("id", id, "termId", termId), new Gson().fromJson(response, type));
    }

    @Test
    public void mapPathVariableAsLong_readsAndReturnsPathVariableAsLong() throws Exception {
        long id = new Random().nextLong();
        String response = mockMvc.perform(get("/v5/students/" + id))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id, response);
    }

    @Test
    public void mapNotRequiredPathVariables_whenVariableIsNull_readsAndReturnsNull() throws Exception {
        String id = randomUUID().toString();

        String response = mockMvc.perform(get("/v6/students/" + id + "/terms/"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id + ", term id: null", response);
    }

    @Test
    public void mapNotRequiredPathVariables_whenVariableExists_readsAndReturnsVariable() throws Exception {
        String id = randomUUID().toString();
        String termId = randomUUID().toString();

        String response = mockMvc.perform(get("/v6/students/" + id + "/terms/" + termId))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id + ", term id: " + termId, response);
    }

    @Test
    public void mapOptionalPathVariables_whenVariableIsNull_readsAndReturnsDefaultValue() throws Exception {
        String id = randomUUID().toString();

        String response = mockMvc.perform(get("/v7/students/" + id + "/terms/"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id + ", term id: 3", response);
    }

    @Test
    public void mapOptionalPathVariables_whenVariableIsNull_readsAndReturnsVariable() throws Exception {
        String id = randomUUID().toString();
        String termId = randomUUID().toString();

        String response = mockMvc.perform(get("/v7/students/" + id + "/terms/" + termId))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id + ", term id: " + termId, response);
    }

    @Test
    public void mapPathVariableWithTermId_whenGivenIdAndTermId_readsAndReturnsBoth() throws Exception {
        String id = randomUUID().toString();
        String termId = randomUUID().toString();

        String response = mockMvc.perform(get("/v8/students/" + id + "/terms/" + termId))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id + ", term id: " + termId, response);
    }

    @Test
    public void mapPathVariableWithTermId_whenGivenId_readsAndReturnsId() throws Exception {
        String id = randomUUID().toString();

        String response = mockMvc.perform(get("/v8/students/" + id + "/terms/"))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertEquals("id: " + id, response);
    }
}