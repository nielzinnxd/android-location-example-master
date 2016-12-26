package teamtreehouse.com.iamhere;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dleite on 07/11/2016.
 */
public interface JsonService {

    String pesquisa = "https://maps.googleapis.com/maps/api/geocode/"; //Lista
//    String API_BASE_FREQUENCIA  = "http://mgappr9.magnasistemas.com.br/MAGNA/Frequencia.nsf/api/data/documents/unid/"; //Quinzena
//    String API_BASE_URL_LOGIN   = "http://mgappr9.magnasistemas.com.br/magna/pessoal.nsf/api/data/collections/name/"; //Logon
//    String API_BASE_POST_OK     = "http://mgappr9.magnasistemas.com.br/magna/frequencia.nsf/api/data/documents/unid/"; //Quinzena

    //BASE_URL_MATRICULA
    @GET("json?address=08275170&key=AIzaSyDT_5UdRiILGkpiLB7oxd8jIdS2YL5OcJY")
    Call<List<CEP>> getByCep();
//@Query("address") String category
//    //API_BASE_FREQUENCIA
//    @GET("{id}")
//    Call<FrequenciaBean> getFrequenciaById(@Path("id") String id);
//
//    //API_BASE_URL_LOGIN
//    @GET("infocolabmobile?")
//    Call<List<UsuarioMatriculaBean>> autenticaUsuario(@Query("category") String id);
//
//    //API_BASE_POST_OK
//    @POST("{id}?form=CF&computewithform=true")
//    Call<ResponseBody>frequenciaOk(@Path("id") String id);
//}


    public interface ApiService {
        @GET("/xml/simple.xml")
        TesteXML getUser();
    }

}
