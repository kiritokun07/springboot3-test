//package com.kirito.test;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MasterTest {
//    @Autowired
//    private BuyerMapper buyerMapper;
//    @Autowired
//    private SellerMapper sellerMapper;
//
//    @Test
//    public void testBuyerQuery() {
//        // 主键查询
//        Buyer buyer = buyerMapper.selectByPrimaryKey(1);
//        System.out.println(buyer.getId() + ";" + buyer.getBuyerName());
//    }
//
//    @Test
//    public void testBuyerInsert() {
//        // 新增数据
//        Buyer buyer = new Buyer();
//        buyer.setBuyerName("买家Three");
//        System.out.println(buyerMapper.insert(buyer));
//    }
//
//    @Test
//    public void testBuyerUpdate() {
//        // 更新数据
//        Buyer buyer = buyerMapper.selectByPrimaryKey(3);
//        if (buyer != null) {
//            buyer.setBuyerName("Three买家");
//            System.out.println(buyerMapper.updateByPrimaryKey(buyer));
//        }
//    }
//
//    @Test
//    public void testSellerPage() {
//        // 1、设置分页和查询条件
//        PageHelper.startPage(2, 2);
//        SellerExample sellerExample = new SellerExample();
//        sellerExample.setOrderByClause("id asc");
//        // 2、查询数据
//        List<Seller> sellerList = sellerMapper.selectByExample(sellerExample);
//        // 3、构建分页实体对象
//        PageInfo<Seller> pageInfo = new PageInfo<>(sellerList);
//        System.out.println(pageInfo);
//    }
//}