package com.example.demo;

import com.example.demo.controller.ProductController;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class,secure = false)
public class TestProductControllerWithFeature {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Features features;

    @MockBean
     ProductService productService;

    @Test
    public void testSaveProduct() throws Exception {
        features = mock(Features.class);
        Mockito.when(features.updateFeatureEnabled()).thenReturn(true);
        Mockito.doNothing().when(productService).saveProduct(Mockito.any(Product.class));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Product/saveProduct").content("{\"id\":10,\"name\":\"Snickers Bar\"}").contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(),mvcResult.getResponse().getStatus());
    }

    @Test
    public void testSaveProductWithoutFeatureEnabled() throws Exception {
        features = mock(Features.class);
        Mockito.when(features.updateFeatureEnabled()).thenReturn(true);
        Mockito.doNothing().when(productService).saveProduct(Mockito.any(Product.class));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Product/saveProduct").content("{\"id\":10,\"name\":\"Snickers Bar\"}").contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus());
    }
}
