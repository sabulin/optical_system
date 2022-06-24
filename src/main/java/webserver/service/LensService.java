package webserver.service;

import webserver.dao.CategoryDao;
import webserver.dao.LensDao;
import webserver.domain.Category;
import webserver.domain.Lens;

import java.util.List;

public class LensService{
    private LensDao lensDao = new LensDao();
    public List<Lens> findAll(){
        return lensDao.findAll();
    }
}
