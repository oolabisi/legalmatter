package legalmanagement.data.dao;

import legalmanagement.data.entity.Attorney;

import java.util.List;

public interface AttorneyDao {

    public List <Attorney> findAll();

    public Attorney findAttorneyById(int theId);

    public void saveAttorney(Attorney theAttorney);

    public void deleteAttorneyById(int theId);

}
