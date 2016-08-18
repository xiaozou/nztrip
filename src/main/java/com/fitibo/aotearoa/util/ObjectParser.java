package com.fitibo.aotearoa.util;

import com.google.common.collect.Lists;

import com.fitibo.aotearoa.model.OrderTicket;
import com.fitibo.aotearoa.model.OrderTicketUser;
import com.fitibo.aotearoa.model.SkuTicket;
import com.fitibo.aotearoa.model.SkuTicketPrice;
import com.fitibo.aotearoa.vo.OrderTicketUserVo;
import com.fitibo.aotearoa.vo.OrderTicketVo;
import com.fitibo.aotearoa.vo.SkuTicketPriceVo;
import com.fitibo.aotearoa.vo.SkuTicketVo;

/**
 * Created by qianhao.zhou on 8/17/16.
 */
public final class ObjectParser {

    private ObjectParser() {
    }

    public static SkuTicketPriceVo parse(SkuTicketPrice input) {
        SkuTicketPriceVo result = new SkuTicketPriceVo();
        result.setId(input.getId());
        result.setCostPrice(input.getCostPrice());
        result.setSalePrice(input.getSalePrice());
        result.setSkuId(input.getSkuId());
        result.setSkuTicketId(input.getSkuTicketId());
        result.setDescription(input.getDescription());
        result.setDate(DateUtils.formatDate(input.getDate()));
        result.setTime(input.getTime());
        return result;
    }

    public static SkuTicketVo parse(SkuTicket input) {
        SkuTicketVo ticket = new SkuTicketVo();
        ticket.setDescription(input.getDescription());
        ticket.setName(input.getName());
        ticket.setId(input.getId());
        ticket.setCount(Integer.parseInt(input.getCountConstraint()));
        String[] ages = input.getAgeConstraint().split("-");
        ticket.setMinAge(Integer.parseInt(ages[0]));
        ticket.setMaxAge(Integer.parseInt(ages[1]));
        String[] weights = input.getWeightConstraint().split("-");
        ticket.setMinWeight(Integer.parseInt(weights[0]));
        ticket.setMaxWeight(Integer.parseInt(weights[1]));
        ticket.setTicketPrices(Lists.transform(input.getTicketPrices(), ObjectParser::parse));
        return ticket;
    }

    public static OrderTicketVo parse(OrderTicket orderTicket) {
        OrderTicketVo result = new OrderTicketVo();
        result.setId(orderTicket.getId());
        result.setAgeConstraint(orderTicket.getAgeConstraint());
        result.setCountConstraint(orderTicket.getAgeConstraint());
        result.setWeightConstraint(orderTicket.getWeightConstraint());
        result.setPriceDescription(orderTicket.getPriceDescription());
        result.setSalePrice(orderTicket.getSalePrice());
        result.setTicketDate(DateUtils.formatDate(orderTicket.getTicketDate()));
        result.setTicketTime(orderTicket.getTicketTime());
        result.setSkuTicket(orderTicket.getSkuTicket());
        result.setSkuTicketId(orderTicket.getSkuTicketId());
        result.setTicketPriceId(orderTicket.getTicketPriceId());
        result.setOrderTicketUsers(Lists.transform(orderTicket.getUsers(), ObjectParser::parse));
        result.setCostPrice(orderTicket.getCostPrice());
        return result;
    }

    public static OrderTicketUserVo parse(OrderTicketUser input2) {
        OrderTicketUserVo userVo = new OrderTicketUserVo();
        userVo.setAge(input2.getAge());
        userVo.setId(input2.getId());
        userVo.setName(input2.getName());
        userVo.setOrderTicketId(input2.getOrderTicketId());
        userVo.setWeight(input2.getWeight());
        return userVo;
    }
}
