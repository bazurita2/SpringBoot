package ec.edu.espe.skiworkerselector.repository;

import ec.edu.espe.skiworkerselector.model.Interview;
import ec.edu.espe.skiworkerselector.vo.UserVo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MongoCRUDRepository
        extends MongoRepository<Interview, String>{

    @Query("{'key' : ?0}")
    Optional<Interview> findByKey(String key);

    @Query("{'key' : ?0}")
    Optional<UserVo> findUserByKey(String key);
}
