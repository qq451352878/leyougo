package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.com.leyou.common.parameter.BrandQueryByPageParameter;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "brand",method = RequestMethod.POST)
public class BrandController {

    @Autowired
    private BrandService brandService;
    @GetMapping("page")
    /**
     * 分页查询品牌
     */
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(

            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> result = this.brandService.queryBrandByPage (new BrandQueryByPageParameter (page, rows,sortBy ,desc ,key )) ;
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println (result );
        return ResponseEntity.ok(result);
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @RequestMapping("addBrand")
    public ResponseEntity<Void> seveBrand(Brand brand,@RequestParam("cids") List<Long> cids){
        System.out.println ("进入了新增品牌方法" );
        brandService.saveBrand (brand,cids);
        return ResponseEntity.status (HttpStatus.CREATED).build ();
    }

    /**
     * 根据category的id查询品牌信息
     * @param cid
     * @return
     */
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandByCategoryId(@PathVariable("cid") Long cid){
        List<Brand> list = this.brandService.queryBrandByCategoryId(cid);
        if (list == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

}
