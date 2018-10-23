package com.soumen.bootmongo.repository;

import com.soumen.bootmongo.model.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Soumen Karmakar
 * 10/11/2018
 */
public interface PetsRepository extends MongoRepository<Pets, String> {

    Pets findBy_id(ObjectId id);

}
