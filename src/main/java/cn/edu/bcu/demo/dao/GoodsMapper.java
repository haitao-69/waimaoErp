package cn.edu.bcu.demo.dao;

import cn.edu.bcu.demo.domain.Goods;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface GoodsMapper {


//    搜索框功能
    @Select("select * from goods where goodsName like CONCAT('%',#{search},'%')")
    ArrayList<Goods> searchGoods(String search);


    @Select("select * from goods")
    ArrayList<Goods> getAllGoods();

    @Select("select * from goods where goodsName=#{goodsName}")
    Goods getGoodsName(String goodsName);

    @Select("select * from goods where goodsId=#{id}")
    Goods getGoodsId(int id);

    @Select("select * from goods where type=#{type}")
    ArrayList<Goods> getTypeGoods(String type);

    @Select("select * from goods where goodsId=#{id}")
    Goods selectOne(int id);

    @Insert("insert into goods(goodsName,unit,categoryId,imgUrl,smallImg,inventory,description,updateTime,putTime,type)"
            + "values(#{goodsName},#{unit},#{categoryId},#{imgUrl},#{smallImg},#{inventory},#{description},#{updateTime},now(),#{type})")
    int addGoods(Goods Goods);

    @Update("UPDATE goods\n" +
            "SET goodsName = #{goodsName},\n" +
            "    unit = #{unit},\n" +
            "    categoryId = #{categoryId},\n" +
            "    smallImg = #{smallImg},\n" +
            "    inventory = #{inventory},\n" +
            "    description = #{description},\n" +
            "    updateTime = NOW(),\n" +
            "    putTime = now(),\n" +
            "    type = #{type}\n" +
            "WHERE goodsId = #{goodsId};")
    int updGoods(Goods Goods);

    @Delete("delete from goods where goodsId=#{id}")
    int delGoods(int id);
}
