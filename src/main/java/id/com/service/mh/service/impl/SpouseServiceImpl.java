package id.com.service.mh.service.impl;

import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.entity.Spouse;
import id.com.service.mh.repository.SpouseRepository;
import id.com.service.mh.service.SpouseService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpouseServiceImpl implements SpouseService {

    SpouseRepository spouseRepository;

    @Autowired
    public SpouseServiceImpl(SpouseRepository spouseRepository) {
        this.spouseRepository = spouseRepository;
    }

    @Override
    public Spouse createSpouse(Spouse spouse) {
        return spouseRepository.save(spouse);
    }

    @Override
    public List<Spouse> readAllSpouse() {
        return spouseRepository.findAll();
    }

    @Override
    public Spouse readSpouseById(String id) {
        if (spouseRepository.findById(id).isPresent()){
            return spouseRepository.findById(id).get();
        } else{
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND, ResponseMessage.SPOUSE, id));
        }
    }

    @Override
    public Spouse updateSpouse(Spouse spouse) {
        return spouseRepository.save(spouse);
    }
}
