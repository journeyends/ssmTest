package song;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import song.entity.SalesInfoPre;
import song.idao.ISalesInfoPreDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        ISalesInfoPreDao dao = session.getMapper(ISalesInfoPreDao.class);
        List<SalesInfoPre> list = dao.getList();

        for(SalesInfoPre salesInfoPre : list){
            System.out.println(salesInfoPre.getProject_name());
        }

        session.close();
        in.close();
    }
}
