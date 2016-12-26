package teamtreehouse.com.iamhere;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by dleite on 23/12/2016.
 */

public class Pesquisa extends Activity {
    Button pesquisar;
    EditText cep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesquisa);

        pesquisar = (Button) findViewById(R.id.btn_pesquisar);
        cep = (EditText) findViewById(R.id.cpf);
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(Pesquisa.this,GPSMainActivity.class));

            }
        });

    }
}
