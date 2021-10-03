package com.example.demo;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"classpath:wood-schema.sql", "classpath:wood-data.slq"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class AccountIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ModelMapper mapper;

    private AccountDTO mapToDTO(Account account){
        return this.mapper.map(account, AccountDTO.class);
    }

    @Autowired
    private ObjectMapper jsonifier;


    private final Long TEST_ID = 1L;
    private final Account TEST_ACCOUNT = new Account("123abc", "John");

    @Test
    public void testAddAccount() throws Exception{
        this.mock
            .perform(post("/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.jsonifier.writeValueAsString(TEST_ACCOUNT)))
            .andExpect(status().isCreated())
            .andExpect(content().json(this.jsonifier.writeValueAsString(this.mapToDTO(TEST_ACCOUNT))));
    }
}
