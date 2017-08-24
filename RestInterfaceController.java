package umut;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by umut.
 */
public interface RestInterfaceController {

    @GET("/gistfile1.txt")
    void getJsonValues(Callback<RetrofitModel[]> response);

}
