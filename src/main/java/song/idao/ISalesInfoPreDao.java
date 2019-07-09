package song.idao;

import song.entity.SalesInfoPre;
import song.model.SalesInfoPreSearchModel;

import java.util.List;

public interface ISalesInfoPreDao {
    List<SalesInfoPre> getList();

    boolean saveSalesInfoPre(SalesInfoPre entity);

    List<SalesInfoPre> searchList(SalesInfoPreSearchModel model);
}
