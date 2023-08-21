//package com.kirito.test;
//
//import com.kirito.test.domain.ContentsIndex;
//import com.kirito.test.repository.ContentsIndexRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//
///**
// * @author 公众号:知了一笑
// * @since 2023-07-28 14:39
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ContentsIndexRepositoryTest {
//
//    @Autowired
//    private ContentsIndexRepository contentsIndexRepository;
//
//    @Test
//    public void testAdd() {
//        // 单个新增
//        contentsIndexRepository.save(buildOne());
//        // 批量新增
//        contentsIndexRepository.saveAll(buildList());
//    }
//
//    @Test
//    public void testUpdate() {
//        // 根据ID查询后再更新
//        Optional<ContentsIndex> contentsOpt = contentsIndexRepository.findById(14L);
//        if (contentsOpt.isPresent()) {
//            ContentsIndex contentsId = contentsOpt.get();
//            System.out.println("id=14:" + contentsId);
//            contentsId.setContent("update-content");
//            contentsId.setCreateTime(new Date());
//            contentsIndexRepository.save(contentsId);
//        }
//    }
//
//    @Test
//    public void testQuery() {
//        // 单个ID查询
//        Optional<ContentsIndex> contentsOpt = contentsIndexRepository.findById(1L);
//        if (contentsOpt.isPresent()) {
//            ContentsIndex contentsId1 = contentsOpt.get();
//            System.out.println("id=1:" + contentsId1);
//        }
//        // 批量ID查询
//        for (ContentsIndex contentsIndex : contentsIndexRepository
//                .findAllById(Arrays.asList(10L, 12L))) {
//            System.out.println("id=" + contentsIndex.getId() + ":" + contentsIndex);
//        }
//    }
//
//    @Test
//    public void testDelete() {
//        contentsIndexRepository.deleteById(15L);
//        contentsIndexRepository.deleteById(16L);
//    }
//
//    public ContentsIndex buildOne() {
//        return new ContentsIndex
//                (13, "赵六-标题", "赵六-简介", "赵六-内容", 4, "赵六", new Date());
//    }
//
//    public List<ContentsIndex> buildList() {
//        ContentsIndex contents1 = new ContentsIndex
//                (14, "孙七-标题", "孙七-简介", "孙七-内容", 5, "孙七", new Date());
//        ContentsIndex contents2 = new ContentsIndex
//                (15, "孙七-标题", "孙七-简介", "孙七-内容", 5, "孙七", new Date());
//        return Arrays.asList(contents1, contents2);
//    }
//}
