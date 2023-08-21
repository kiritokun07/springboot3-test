//package com.kirito.test.service;
//
//import com.kirito.test.domain.Contents;
//import com.kirito.test.domain.ContentsIndex;
//import jakarta.annotation.Resource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.IndexOperations;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 内容索引服务类
// *
// * @author 公众号:知了一笑
// * @since 2023-07-28 13:30
// */
//@Service
//public class ContentsIndexService {
//
//    private static final Logger log = LoggerFactory.getLogger(ContentsIndexService.class);
//
//    @Resource
//    private IContentsService contentsService;
//
//    @Resource
//    private ElasticsearchTemplate template;
//
//    /**
//     * 初始化索引结构和数据
//     */
//    public void initIndex() {
//        // 处理索引结构
//        IndexOperations indexOps = template.indexOps(ContentsIndex.class);
//        if (indexOps.exists()) {
//            boolean delFlag = indexOps.delete();
//            log.info("contents_index exists，delete:{}", delFlag);
//            indexOps.createMapping(ContentsIndex.class);
//        } else {
//            log.info("contents_index not exists");
//            indexOps.createMapping(ContentsIndex.class);
//        }
//        // 同步数据库表记录
//        List<Contents> contentsList = contentsService.list();
//        if (contentsList.size() > 0) {
//            List<ContentsIndex> contentsIndexList = new ArrayList<>();
//            contentsList.forEach(contents -> {
//                ContentsIndex contentsIndex = new ContentsIndex();
//                BeanUtils.copyProperties(contents, contentsIndex);
//                contentsIndexList.add(contentsIndex);
//            });
//            template.save(contentsIndexList);
//        }
//        // ID查询
//        ContentsIndex contentsIndex = template.get("10", ContentsIndex.class);
//        log.info("contents-index-10:{}", contentsIndex);
//    }
//
//}
