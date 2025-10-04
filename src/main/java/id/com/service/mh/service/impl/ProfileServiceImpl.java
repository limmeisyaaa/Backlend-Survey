package id.com.service.mh.service.impl;

import id.com.service.mh.constant.ResponseMessage;
import id.com.service.mh.entity.Profile;
import id.com.service.mh.repository.ProfileRepository;
import id.com.service.mh.service.ProfileService;
import id.com.service.mh.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> readAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public Profile readProfileById(String id) {
        if(profileRepository.findById(id).isPresent()){
            return profileRepository.findById(id).get();
        } else{
            throw new DataNotFoundException(String.format(ResponseMessage.NOT_FOUND, ResponseMessage.PROFILE, id));
        }
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }
}
