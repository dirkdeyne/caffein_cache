package io.getmedusa.demo.service;

import io.getmedusa.demo.model.DogsInHouse;
import io.getmedusa.demo.model.Lang;
import org.springframework.data.repository.ListCrudRepository;

public interface DogsInHouseRepository extends ListCrudRepository<DogsInHouse,Long> {

    DogsInHouse findByName(String name);

    DogsInHouse findByNameAndLangIs(String name, Lang lang);
}
