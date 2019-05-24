package other.JDKProxy;

/**
 * desc: XXXX
 *
 * @author Ying
 * Date: 2019/4/11
 * @version 1.0.0
 */
public class TestServiceImpl implements TestService{

    @Override
    public String getName() {
        System.out.println("---------This is testServiceImpl's getName------------");
        return "***Impl's getName***";
    }

    @Override
    public String getDesc() {
        System.out.println("---------This is testServiceImpl's getdesc------------");
        return "***Impl's getDesc***";
    }
}
