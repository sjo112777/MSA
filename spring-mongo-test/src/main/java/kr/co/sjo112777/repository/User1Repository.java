package kr.co.sjo112777.repository;

import kr.co.sjo112777.document.User1Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User1Repository extends MongoRepository<User1Document, String> {

    public Optional<User1Document> findByUid(String uid);
    public void deleteByUid(String uid);
    public boolean existsByUid(String uid);

}