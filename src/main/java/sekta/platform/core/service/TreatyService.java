package sekta.platform.core.service;

import sekta.platform.core.entity.Treaty;

import java.util.List;

public interface TreatyService {
    List<Treaty> getAllTreaty();
    Treaty getTreatyById(Long id);
    Treaty createTreaty(Treaty user);
    Treaty updateTreaty(Treaty user);
    void deleteTreaty(Long id);
}
