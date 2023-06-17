package io.xccit.store.search.repository;

import io.xccit.store.model.search.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author CH_ywx
 * @date 2023-06-16
 * @description elasticsearch搜索的商品模型
 */
@Repository
public interface SkuInfoRepository extends ElasticsearchRepository<SkuEs,Long> {

}
