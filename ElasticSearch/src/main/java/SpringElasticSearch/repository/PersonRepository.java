package SpringElasticSearch.repository;

import SpringElasticSearch.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {

}
