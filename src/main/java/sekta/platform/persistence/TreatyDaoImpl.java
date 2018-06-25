package sekta.platform.persistence;

import org.springframework.stereotype.Repository;
import sekta.platform.core.dao.TreatyDao;
import sekta.platform.core.entity.Treaty;

@Repository
public class TreatyDaoImpl extends BaseDaoImpl<Treaty> implements TreatyDao {

    @Override
    public Treaty getById(Long id) {
        return (Treaty) sessionFactory.getCurrentSession().get(Treaty.class, id);
    }
}
