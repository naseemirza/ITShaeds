package tbs.thinkbiz.solutions.itshades.Jobs;

import java.util.ArrayList;

/**
 * Created by User on 10-Sep-18.
 */

public interface AsyncResult<TData> {
    void success(TData data, ArrayList<String> JobID);
    void error(String error);

}
