package com.capitole.consulting.technicalassessment.units.controllers;

import com.capitole.consulting.technicalassessment.controller.ExceptionGlobalResponse;
import com.capitole.consulting.technicalassessment.controller.PriceController;
import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.model.builders.impl.PriceResultBuilder;
import com.capitole.consulting.technicalassessment.service.IPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(PriceController.class)
public class PriceControllerUnitTest {

    @MockBean
    IPriceService priceService;

    MockMvc mvc;

    @BeforeEach
    public void asd() {
        this.mvc = MockMvcBuilders.standaloneSetup(new PriceController(priceService))
                .setControllerAdvice(ExceptionGlobalResponse.class)
                .build();
    }

    @Test
    public void getPricesWith200ResponseTest() throws Exception {
        Mockito.when(priceService.getPrices(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(createMockResponse());
        mvc.perform(MockMvcRequestBuilders.get("/getPrices")
                        .param("applyDate", "2020-06-15-15.00.00")
                        .param("productId", "1")
                        .param("brandId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPricesWith404ResponseResourceNotFoundTest() throws Exception {
        Mockito.when(priceService.getPrices(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenThrow(ResourceNotFoundException.class);
        mvc.perform(MockMvcRequestBuilders.get("/getPrices")
                        .param("applyDate", "2020-06-15-15.00.00")
                        .param("productId", "1")
                        .param("brandId", "2"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void getPricesWith404ResponseMissingParameterTest() throws Exception {
        Mockito.when(priceService.getPrices(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenThrow(MethodArgumentTypeMismatchException.class);
        mvc.perform(MockMvcRequestBuilders.get("/getPrices")
                        .param("applyDate", "2020-06-15-15.00.00")
                        .param("brandId", "2"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void getPricesWith400ResponseArgumentTypeMismatchTest() throws Exception {
        Mockito.when(priceService.getPrices(Mockito.any(), Mockito.any(), Mockito.any()))
                .thenThrow(MethodArgumentTypeMismatchException.class);
        mvc.perform(MockMvcRequestBuilders.get("/getPrices")
                        .param("applyDate", "2020-06-15 15:00;:00")
                        .param("productId", "1")
                        .param("brandId", "2"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    private static List<PriceResult> createMockResponse() {
        LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, Month.JUNE, 14, 18, 30, 0);
        PriceResult priceResult = new PriceResultBuilder()
                .withPrice(30.50)
                .withPriceList(1)
                .withBrandId(1)
                .withEndDate(endDate)
                .withStartDate(startDate)
                .withProductId(35455)
                .build();

        return new ArrayList<PriceResult>() {{
            add(priceResult);
        }};

    }
}
