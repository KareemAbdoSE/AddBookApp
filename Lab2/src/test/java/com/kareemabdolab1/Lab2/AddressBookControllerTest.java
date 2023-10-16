package com.kareemabdolab1.Lab2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllAddressBooks() throws Exception {
        this.mockMvc.perform(get("/addressBooks"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAddressBookById() throws Exception {
        this.mockMvc.perform(get("/addressBooks/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateAddressBook() throws Exception {
        // Prepare JSON payload
        String jsonPayload = "{\"name\": \"John\", \"phoneNumber\": \"1234567890\"}";

        // Perform POST request and validate response
        mockMvc.perform(post("/addressBooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isCreated())  // Expect 201 Created status
                .andExpect(jsonPath("$.id").exists())  // Expect id to exist
                .andExpect(jsonPath("$.buddies[0].name").value("John"))  // Expect the first buddy's name to be "John"
                .andExpect(jsonPath("$.buddies[0].phoneNumber").value("1234567890"));  // Expect the first buddy's phone number to be "1234567890"
    }

    @Test
    public void testUpdateAddressBook() throws Exception {
        String jsonPayload = "{\"buddies\": [{\"name\": \"Jane\", \"phoneNumber\": \"0987654321\"}]}";
        this.mockMvc.perform(put("/addressBooks/1")
                        .contentType("application/json")
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.buddies[0].name").value("Jane"));
    }

    @Test
    public void testDeleteAddressBook() throws Exception {
        this.mockMvc.perform(delete("/addressBooks/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testBuddyInfoAddress() throws Exception {
        String jsonPayload = "{\"name\": \"John\", \"phoneNumber\": \"1234567890\", \"address\": \"123 Main St\"}";

        mockMvc.perform(post("/addressBooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.buddies[0].address").value("123 Main St"));
    }
}
