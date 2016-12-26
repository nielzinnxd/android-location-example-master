package teamtreehouse.com.iamhere;

import android.app.Activity;
import android.os.Bundle;



import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import okhttp3.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by dleite on 26/12/2016.
 */
public class TesteXML extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesquisa);

//
//
//        Strategy strategy = new AnnotationStrategy();
//        Serializer serializer = new Persister(strategy);
//        OkHttpClient okHttpClient = new OkHttpClient();
//
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint("")
//                .setClient(new OkClient(new OkHttpClient()))
//                .setConverter(new SimpleXMLConverter(serializer))
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .build();
//        api = restAdapter.create(SoapApi.class);


    }
}
