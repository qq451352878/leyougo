//package com.leyou.client;
//
//import com.leyou.LySearchService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = LySearchService.class)
//public class CategoryClientTest {
//
//    @Autowired
//    private CategoryClient categoryClient;
//
//    @Test
//    public void testQueryCategories() {
//        List<String> names = categoryClient.queryNameByIds (Arrays.asList (1L, 2L, 3L));
//        names.forEach(System.out::println);
//        while (true) {
//
//        }
//    }
//}