package webserver.service;

import webserver.dao.FrameDao;
import webserver.dao.LensDao;
import webserver.domain.Frame;
import webserver.domain.Lens;

import java.util.List;

public class FrameService {
    private FrameDao frameDao = new FrameDao();
    public List<Frame> findAll(){
        return frameDao.findAll();
    }
}
