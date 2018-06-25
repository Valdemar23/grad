package sekta.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sekta.platform.core.dao.TreatyDao;
import sekta.platform.core.entity.Treaty;
import sekta.platform.core.service.TreatyService;

import java.util.List;

@Service
public class TreatyServiceImpl implements TreatyService {
    @Autowired
    TreatyDao treatyDao;

    @Override
    @Transactional
    public List<Treaty> getAllTreaty() {
        return treatyDao.findAll();
    }

    @Override
    @Transactional
    public Treaty getTreatyById(Long id) {
        return treatyDao.getById(id);
    }

    @Override
    @Transactional
    public Treaty createTreaty(Treaty treaty) {
        treatyDao.create(treaty);
        return treaty;
    }

    @Override
    @Transactional
    public Treaty updateTreaty(Treaty treaty) {
        treatyDao.update(treaty);
        return treaty;
    }

    @Override
    @Transactional
    public void deleteTreaty(Long id) {
        Treaty treaty= new Treaty();
        treaty.setId(id);
        treatyDao.delete(treaty);
    }
}
