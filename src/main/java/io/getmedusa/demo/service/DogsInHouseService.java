package io.getmedusa.demo.service;

import io.getmedusa.demo.model.DogsInHouse;
import io.getmedusa.demo.model.Lang;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DogsInHouseService {
    final DogsInHouseRepository dogsInHouseRepository;

    public DogsInHouseService(DogsInHouseRepository dogsInHouseRepository) {
        this.dogsInHouseRepository = dogsInHouseRepository;
    }

    public DogsInHouse findDogHouseByName(String name) {
        return dogsInHouseRepository.findByName(name);
    }

    @Cacheable("dogsInHouse")
    public DogsInHouse findDogHouseEnFromDB (String name) {
        return dogsInHouseRepository.findByNameAndLangIs(name, Lang.EN);
    }
}