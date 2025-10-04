package id.com.service.mh.service;

import id.com.service.mh.entity.Spouse;

import java.util.List;

public interface SpouseService {
    Spouse createSpouse(Spouse spouse);
    List<Spouse> readAllSpouse();
    Spouse readSpouseById(String id);
    Spouse updateSpouse(Spouse spouse);
}
