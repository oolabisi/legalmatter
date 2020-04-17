package legalmanagement.service;

import legalmanagement.data.entity.Attorney;

import java.util.List;


public interface AttorneyService {

    public List<Attorney> findAll();

    public Attorney findAttorneyById(int theId);

    public void saveAttorney(Attorney theAttorney);

    public int deleteAttorneyById(int theId);
}
