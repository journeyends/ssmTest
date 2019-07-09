package song;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import song.entity.SalesInfoPre;
import song.idao.ISalesInfoPreDao;
import song.model.SalesInfoPreSearchModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    InputStream in;
    SqlSession session;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
    }

    public void searchTest(){
        ISalesInfoPreDao dao = session.getMapper(ISalesInfoPreDao.class);
        List<SalesInfoPre> list = dao.getList();

        for(SalesInfoPre salesInfoPre : list){
            System.out.println(salesInfoPre.getProject_name());
        }
    }

    @Test
    public void searchTest1(){
        ISalesInfoPreDao dao = session.getMapper(ISalesInfoPreDao.class);
        SalesInfoPreSearchModel model = new SalesInfoPreSearchModel();
        SalesInfoPre pre = new SalesInfoPre();
        pre.setProject_name("%苏州%");
        model.setPre(pre);
        List<SalesInfoPre> list = dao.searchList(model);

        for(SalesInfoPre salesInfoPre : list){
            System.out.println(salesInfoPre.getProject_name());
        }
    }

    public void saveTest(){
        ISalesInfoPreDao dao = session.getMapper(ISalesInfoPreDao.class);
        SalesInfoPre entity = new SalesInfoPre();
        entity.setProject_name("test");
        dao.saveSalesInfoPre(entity);
        session.commit();
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }
}
