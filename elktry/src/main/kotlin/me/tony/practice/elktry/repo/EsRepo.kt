package me.tony.practice.elktry.repo

import co.elastic.clients.elasticsearch.ElasticsearchClient
import org.elasticsearch.client.RestClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate
import org.springframework.stereotype.Service

@Service
class EsRepo {

    @Autowired
    lateinit var rest: RestClient

    @Autowired
    lateinit var esClient: ElasticsearchClient

    @Autowired
    lateinit var esTemplate:ElasticsearchTemplate

}