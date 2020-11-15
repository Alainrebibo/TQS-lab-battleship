import model.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MockDirecction {

    Map<Integer, Direction> mDirecction;
    Map<Integer, Direction> mDirecctionIncorrect;

    public Map<Integer, Direction> getmDirecction() {
        return mDirecction;
    }

    public Map<Integer, Direction> getmDirecctionIncorrect() {
        return mDirecctionIncorrect;
    }

    public MockDirecction(){


        mDirecction = new HashMap<>();
        mDirecctionIncorrect = new HashMap<>();
        mDirecction.put(1, Direction.HORIZONTAL);
        mDirecction.put(2, Direction.VERTICAL);

        mDirecctionIncorrect.put(-1, null);
        mDirecctionIncorrect.put(0, null);
        mDirecctionIncorrect.put(3, null);
        mDirecctionIncorrect.put(1234, null);
    }




}
