package id.com.service.mh.service;

import id.com.service.mh.entity.Relatives;

import java.util.List;

public interface RelativesService {
    Relatives createRelatives(Relatives relatives);
    List<Relatives> readAllRelatives();
    Relatives readRelativesById(String id);
    Relatives updateRelatives(Relatives relatives);
}
