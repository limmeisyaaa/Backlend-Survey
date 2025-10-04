package id.com.service.mh.service.impl;

import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.entity.Relatives;
import id.com.service.mh.repository.RelativesRepository;
import id.com.service.mh.service.RelativesService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelativesServiceImpl implements RelativesService {

    RelativesRepository relativesRepository;

    @Autowired
    public RelativesServiceImpl(RelativesRepository relativesRepository) {
        this.relativesRepository = relativesRepository;
    }

    @Override
    public Relatives createRelatives(Relatives relatives) {
        return relativesRepository.save(relatives);
    }

    @Override
    public List<Relatives> readAllRelatives() {
        return relativesRepository.findAll();
    }

    @Override
    public Relatives readRelativesById(String id) {
        if(relativesRepository.findById(id).isPresent()){
        return relativesRepository.findById(id).get();
        } else{
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND, ResponseMessage.RELATIVES, id));
        }
    }

    @Override
    public Relatives updateRelatives(Relatives relatives) {
        return relativesRepository.save(relatives);
    }
}
