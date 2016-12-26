package teamtreehouse.com.iamhere;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dleite on 20/12/2016.
 */

public class Localiza extends Activity {
    Button btnStart, btn_limpar;
    TextView textCounter, hr1, hr2, horas, descricao_apontamento, entrada, saida;
    String datade, dataate;
    Timer timer;
    MyTimerTask myTimerTask;
    Calendar c1, c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localiza);
        btnStart = (Button) findViewById(R.id.start);
        btn_limpar = (Button) findViewById(R.id.btn_limpar);
        textCounter = (TextView) findViewById(R.id.counter);
        descricao_apontamento = (TextView) findViewById(R.id.descricao_apontamento);
        entrada = (TextView) findViewById(R.id.entrada);
        saida = (TextView) findViewById(R.id.saida);
        hr1 = (TextView) findViewById(R.id.hr1);
        hr2 = (TextView) findViewById(R.id.hr2);
        horas = (TextView) findViewById(R.id.horas);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entrada.setText("");
                saida.setText("");
                descricao_apontamento.setText("");
                horas.setText("");
                textCounter.setText("");
                hr1.setText("");
                hr2.setText("");
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("HH:mm");
                final String strDate = simpleDateFormat.format(calendar.getTime());
                final String endDate = simpleDateFormat.format(calendar.getTime());
                btnStart.setText("Parar");

                if (timer != null) {
                    btnStart.setText("Iniciar");
                    timer.cancel();
                    dataate = endDate;

                    c2 = Calendar.getInstance();
                    c2.set(Calendar.HOUR, c2.getTime().getHours());
                    c2.set(Calendar.MINUTE, c2.getTime().getMinutes());

                    //diferenca em horas e minutos
                    long diff = c2.getTimeInMillis() - c1.getTimeInMillis();
                    long hours = (60 * 60 * 1000);
                    long diffHoras = diff / hours;
                    long diffHorasMinutos = (diff % hours) / (60 * 1000);
                    System.out.println("Diferença em horas/minutos: " + diffHoras + " horas e " + diffHorasMinutos + " minutos");
                    horas.setText("TOTAL h:m: " + diffHoras + ":" + diffHorasMinutos);
                    openDialogDescricao();
                    saida.setText(endDate);
                    hr2.setText("Horario de saída: " + endDate);
                    timer = null;
                } else {
                    timer = new Timer();
                    myTimerTask = new MyTimerTask();
                    timer.schedule(myTimerTask, 1, 1000);

                    textCounter.append(strDate + "\n");
                    hr1.setText("Horário de entrada: " + strDate);
                    datade = strDate;

                    c1 = Calendar.getInstance();
                    c1.set(Calendar.HOUR, c1.getTime().getHours());
                    c1.set(Calendar.MINUTE, c1.getTime().getMinutes());

                    entrada.setText(strDate);
                }
            }
        });

    }

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("HH:mm:ss");
            final String strDate = simpleDateFormat.format(calendar.getTime());

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //seta tempo dinamicamente
                    textCounter.setText("Tempo " + strDate + "\n");
                }
            });
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Thread.currentThread().interrupt();
    }

    void openDialogDescricao() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Localiza.this);
        alertDialogBuilder.setTitle("Deseja adicionar uma descrição de atividade?");
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        View v = getLayoutInflater().inflate(R.layout.descricao, null);
                        AlertDialog.Builder alert = new AlertDialog.Builder(Localiza.this);
                        alert.setView(v);
                        final TextView tv_desc = (TextView) v.findViewById(R.id.descricao_dialog);

                        alert.create();
                        alert.setPositiveButton("Salvar", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        descricao_apontamento.setText(tv_desc.getText().toString());
                                    }
                                });
                        alert.show();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}