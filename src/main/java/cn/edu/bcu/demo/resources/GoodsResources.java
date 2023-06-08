package cn.edu.bcu.demo.resources;

import cn.edu.bcu.demo.dao.GoodsMapper;
import cn.edu.bcu.demo.domain.Goods;
import cn.edu.bcu.demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


@RestController
public class GoodsResources {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 更新商品
     * @param
     * @return
     */


    @PostMapping("/searchGoods")
    public Result searchGoods(@RequestParam("search")String search){

        System.out.println("模糊查询的关键字:"+search);
        ArrayList<Goods> searchOutGoods = goodsMapper.searchGoods(search);
        System.out.println("模糊查询的结果:"+searchOutGoods);
        return Result.success(searchOutGoods);
    }

    @PostMapping("/updGoods")
    public Result updGoods(@RequestBody Goods Goods) {

        System.out.println(Goods.toString());

        goodsMapper.updGoods(Goods);
        return Result.success("修改成功！");
    }

    /**
     * 新增商品
     * @param
     * @return
     */
    @PostMapping("/addGoods")
    public Result addGoods(@RequestParam("imgUrl") MultipartFile productImage,
                           @RequestParam("goodsName") String goodsName,
                           @RequestParam("unit") double unit,
                           @RequestParam("inventory") int inventory,
                           @RequestParam("type") String type,
                           @RequestParam("description") String description) throws IOException {

        // 设置数据
        Goods Goods = new Goods();
        Goods.setInventory(inventory);
        Goods.setGoodsName(goodsName);
        Goods.setType(type);
        Goods.setDescription(description);
        Goods.setUnit(unit);

        System.out.println(Goods.toString());


        // 保存图片文件到服务器
        String fileName = productImage.getOriginalFilename();
        // 获取static文件夹的绝对路径
//        Resource resource = resourceLoader.getResource("classpath:static/");
//        String staticPath = resource.getFile().getAbsolutePath();
        //获取项目根路径
        String projectPath = System.getProperty("user.dir");
        //文件存储目录路径
        String uploadPath = projectPath + "/src/main/resources/static/images/goods/";
        String newFileName = new Date().getTime() + fileName;
        String savePath = uploadPath + newFileName;
//        System.out.println("fileName:" + fileName);
//        System.out.println("projectPath:" + projectPath);
//        System.out.println("uploadPath:" + uploadPath);
//        System.out.println("newFileName:" + newFileName);
//        System.out.println("savePath:" + savePath);

        // 保存文件
        try {
            productImage.transferTo(new File(savePath));
        } catch (IOException e) {
            // 处理文件保存异常
            e.printStackTrace();
            return Result.success("未知错误！");
        }

        System.out.println(Goods.toString());

        Goods.setImgUrl(newFileName);
        goodsMapper.addGoods(Goods);
        return Result.success("新增成功！");
    }
    /**
     * 删除商品
     */
    @PostMapping("/delGoods")
    public Result delGoods(@RequestParam("goodsId")int goodsId) {
        goodsMapper.delGoods(goodsId);

        return Result.success("删除成功");
    }

    /**
     * 获取所有商品
     * @return
     */
    @GetMapping("/getAllGoods")
    public Result getAllGoods() {

        ArrayList<Goods> allGoods = goodsMapper.getAllGoods();
        System.out.println(allGoods);
        return Result.success(allGoods);
    }

    /**
     * 获取指定类型商品
     * @param type
     * @return
     */
    @GetMapping("/getTypeGoods")
    public Result getTypeGoods(@RequestParam("type")String type) {
        return Result.success(goodsMapper.getTypeGoods(type));
    }

    /**
     * 获取指定id商品
     * @param id
     * @return
     */
    @GetMapping("/getGoodsId")
    public Result getGoodsId(@RequestParam("goodsId")int id) {
        return Result.success(goodsMapper.getGoodsId(id));
    }
}
