package com.capitole.consulting.technicalassessment.integrations.controllers;

import com.capitole.consulting.technicalassessment.TechnicalAssessmentApplication;
import com.capitole.consulting.technicalassessment.model.PriceResult;
import com.capitole.consulting.technicalassessment.model.ResponseError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TechnicalAssessmentApplication.class)
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    static TestRestTemplate restTemplate;

    static HttpHeaders headers;

    static HttpEntity<String> entity;

    @BeforeAll
    public static void setUp() {
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        entity = new HttpEntity<>(null, headers);
    }

    @Test
    public void test1() {
        String[] params = {"2020-06-14-10.00.00", "35455", "1"};
        ResponseEntity<PriceResult[]> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, PriceResult[].class);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());

        PriceResult[] response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotEquals(0, response.length);
    }

    @Test
    public void test2() {
        String[] params = {"2020-06-14-16.00.00", "35455", "1"};
        ResponseEntity<PriceResult[]> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, PriceResult[].class);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());

        PriceResult[] response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotEquals(0, response.length);
    }

    @Test
    public void test3() {
        String[] params = {"2020-06-14-21.00.00", "35455", "1"};
        ResponseEntity<PriceResult[]> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, PriceResult[].class);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());

        PriceResult[] response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotEquals(0, response.length);
    }

    @Test
    public void test4() {
        String[] params = {"2020-06-15-10.00.00", "35455", "1"};
        ResponseEntity<PriceResult[]> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, PriceResult[].class);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());

        PriceResult[] response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotEquals(0, response.length);
    }

    @Test
    public void test5() {
        String[] params = {"2020-06-16-21.00.00", "35455", "1"};
        ResponseEntity<PriceResult[]> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, PriceResult[].class);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode().value());

        PriceResult[] response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotEquals(0, response.length);
    }


    @Test
    public void requestParameterExceptionTest() {
        String[] params = {"2020-06-16-21.00.00", "35455"};
        ResponseEntity<ResponseError> responseEntity = restTemplate.exchange(createUrlWithOutAParameter(params),
                HttpMethod.GET, entity, ResponseError.class);
        Assertions.assertNotNull(responseEntity);

        ResponseError response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getResponseCode());
    }

    @Test
    public void resourceNotFoundExceptionTest() {
        String[] params = {"2020-06-16-21.00.00", "354551", "1"};
        ResponseEntity<ResponseError> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, ResponseError.class);
        Assertions.assertNotNull(responseEntity);

        ResponseError response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getResponseCode());
    }

    @Test
    public void argumentTypeMismatchExceptionTest() {
        String[] params = {"2020-06-16-21:00:00", "35455", "1"};
        ResponseEntity<ResponseError> responseEntity = restTemplate.exchange(createUrl(params),
                HttpMethod.GET, entity, ResponseError.class);
        Assertions.assertNotNull(responseEntity);

        ResponseError response = responseEntity.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getResponseCode());
    }

    private String createUrl(String[] params) {
        String applyDate = params[0];
        String productId = params[1];
        String brandId = params[2];
        return String.format("http://localhost:8080/getPrices?applyDate=%s&productId=%s&brandId=%s",
                applyDate, productId, brandId);
    }

    private String createUrlWithOutAParameter(String[] params) {
        String applyDate = params[0];
        String productId = params[1];
        return String.format("http://localhost:8080/getPrices?applyDate=%s&productId=%s",
                applyDate, productId);
    }

}
