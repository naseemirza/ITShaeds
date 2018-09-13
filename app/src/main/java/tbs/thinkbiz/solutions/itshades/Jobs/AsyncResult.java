package tbs.thinkbiz.solutions.itshades.Jobs;

/**
 * Created by User on 10-Sep-18.
 */

public interface AsyncResult<TData> {
    void success(TData data);
    void error(String error);

}
