package sekta.platform.core.dao;

import sekta.platform.core.entity.Treaty;
import sekta.platform.core.entity.User;

public interface TreatyDao extends BaseDao<Treaty>{
    Treaty getById(Long id);
}
