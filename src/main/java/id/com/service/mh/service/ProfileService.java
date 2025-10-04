package id.com.service.mh.service;

import id.com.service.mh.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile profile);
    List<Profile> readAllProfile();
    Profile readProfileById(String id);
    Profile updateProfile(Profile profile);
}
