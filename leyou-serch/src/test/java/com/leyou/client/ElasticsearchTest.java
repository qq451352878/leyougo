package com.leyou.client;//package com.leyou.client;

import com.leyou.LySearchApplication;
import com.leyou.pojo.Goods;
import com.leyou.repository.GoodsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

//import com.leyou.service.impl.SearchServiceImpl;

/**
 * @Author: 98050
 * Time: 2018-10-11 22:13
 * Feature:elasticsearch goods索引创建
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LySearchApplication.class)
public class ElasticsearchTest {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void createIndex(){
        // 创建索引
        this.elasticsearchTemplate.createIndex(Goods.class);
        // 配置映射
        this.elasticsearchTemplate.putMapping(Goods.class);
    }
//
//    @Test
//    public void loadData() throws IOException {
//        List<SpuBo> list = new ArrayList<>();
//        int page = 1;
//        int row = 100;
//        int size;
//        do {
//            //分页查询数据
//            PageResult<SpuBo> result = this.goodsClient.querySpuByPage(page, row, null, true, null, true);
//            List<SpuBo> spus = result.getItems();
//            size = spus.size();
//            page ++;
//            list.addAll(spus);
//        }while (size == 100);
//
//        //创建Goods集合
//        List<Goods> goodsList = new ArrayList<>();
//        //遍历spu
//        for (SpuBo spu : list) {
//            try {
//                System.out.println("spu id" + spu.getId());
//                Goods goods = this.searchService.buildGoods(spu);
//                goodsList.add(goods);
//            } catch (IOException e) {
//                System.out.println("查询失败：" + spu.getId());
//            }
//        }
//        this.goodsRepository.saveAll(goodsList);
//    }
//
//    @Test
//    public void testAgg(){
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        // 不查询任何结果
//        queryBuilder.withQuery(QueryBuilders.termQuery("cid3",76)).withSourceFilter(new FetchSourceFilter(new String[]{""},null)).withPageable(PageRequest.of(0,1));
//        Page<Goods> goodsPage = this.goodsRepository.search(queryBuilder.build());
//        goodsPage.forEach(System.out::println);
//    }
//
//    @Test
//    public void testDelete(){
//        this.goodsRepository.deleteAll();
//    }
//
//    @Test
//    public void testConnection(){
//        List<SpuBo> list = new ArrayList<>();
//        int page = 1;
//        int row = 10;
//        int size;
//        PageResult<SpuBo> result = this.goodsClient.querySpuByPage(page, row, null, true, null, true);
////        do {
////            //分页查询数据
////            PageResult<SpuBo> result = this.goodsClient.querySpuByPage(page, row, null, true, null, true);
////            List<SpuBo> spus = result.getItems();
////            size = spus.size();
////            page ++;
////            list.addAll(spus);
////        }while (size == 10);
//
//        System.out.println("数据量：" + list.size());
//    }
//
//
//
//
}
