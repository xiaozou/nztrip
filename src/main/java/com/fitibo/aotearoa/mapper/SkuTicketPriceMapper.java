package com.fitibo.aotearoa.mapper;

import com.fitibo.aotearoa.model.SkuTicketPrice;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * Created by qianhao.zhou on 7/24/16.
 */
public interface SkuTicketPriceMapper {

    @Insert({
            "<script>",
            "insert into sku_ticket_price (sku_id, sku_ticket_id, date, time, sale_price, cost_price, description)",
            "values ",
            "<foreach  collection='skuTicketPrices' item='item' separator=','>",
            "(#{item.skuId}, #{item.skuTicketId}, #{item.date}, #{item.time}, #{item.salePrice}, #{item.costPrice}, #{item.description})",
            "</foreach>",
            "</script>"
    })
    int batchCreate(@Param("skuTicketPrices") List<SkuTicketPrice> skuTicketPrices);

    @Select("select * from sku_ticket_price where sku_id = #{skuId} and date >= #{start} and date < #{end}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "sku_ticket_id", property = "skuTicketId"),
            @Result(column = "date", property = "date"),
            @Result(column = "time", property = "time"),
            @Result(column = "cost_price", property = "costPrice"),
            @Result(column = "sale_price", property = "salePrice"),
            @Result(column = "description", property = "description"),
    })
    List<SkuTicketPrice> findBySkuIdAndStartTime(@Param("skuId") int skuId, @Param("start") Date start, @Param("end") Date end);

    @Select("select * from sku_ticket_price where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "sku_ticket_id", property = "skuTicketId"),
            @Result(column = "date", property = "date"),
            @Result(column = "time", property = "time"),
            @Result(column = "cost_price", property = "costPrice"),
            @Result(column = "sale_price", property = "salePrice"),
            @Result(column = "description", property = "description"),
    })
    SkuTicketPrice findById(int id);

    @Select({"<script>",
            "select * from sku_ticket_price where id in ",
            "<foreach collection='ids' item='id' index='index' open='(' separator=',' close=')'>#{id}",
            "</foreach>",
            "</script>"})
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "sku_ticket_id", property = "skuTicketId"),
            @Result(column = "date", property = "date"),
            @Result(column = "time", property = "time"),
            @Result(column = "cost_price", property = "costPrice"),
            @Result(column = "sale_price", property = "salePrice"),
            @Result(column = "description", property = "description"),
    })
    List<SkuTicketPrice> findByIds(@Param("ids") List<Integer> ids);

    @Select("select * from sku_ticket_price where sku_id = #{skuId} and date > now()")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "sku_ticket_id", property = "skuTicketId"),
            @Result(column = "date", property = "date"),
            @Result(column = "time", property = "time"),
            @Result(column = "cost_price", property = "costPrice"),
            @Result(column = "sale_price", property = "salePrice"),
            @Result(column = "description", property = "description"),
    })
    List<SkuTicketPrice> findBySkuId(@Param("skuId") int skuId);

    @Select("select * from sku_ticket_price where sku_ticket_id = #{skuTicketId} and date =#{date}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "sku_ticket_id", property = "skuTicketId"),
            @Result(column = "date", property = "date"),
            @Result(column = "time", property = "time"),
            @Result(column = "cost_price", property = "costPrice"),
            @Result(column = "sale_price", property = "salePrice"),
            @Result(column = "description", property = "description"),
    })
    List<SkuTicketPrice> findBySkuTicketIdAndDate(@Param("skuTicketId") int skuTicketId, @Param("date") Date date);

    @Select("select * from sku_ticket_price where sku_ticket_id = #{skuTicketId} and date > now() order by date desc")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sku_id", property = "skuId"),
            @Result(column = "sku_ticket_id", property = "skuTicketId"),
            @Result(column = "date", property = "date"),
            @Result(column = "time", property = "time"),
            @Result(column = "cost_price", property = "costPrice"),
            @Result(column = "sale_price", property = "salePrice"),
            @Result(column = "description", property = "description"),
    })
    List<SkuTicketPrice> findBySkuTicketId(int skuTicketId, RowBounds rowBounds);

    @Delete({
            "<script>",
            "delete from sku_ticket_price where sku_id = #{skuId} and sku_ticket_id = #{skuTicketId} and date = #{date}",
            "<if test =\"time != null and time != ''\">and time = #{time} </if>",
            "</script>"
    })
    int deleteTicketPrice(SkuTicketPrice price);

}
