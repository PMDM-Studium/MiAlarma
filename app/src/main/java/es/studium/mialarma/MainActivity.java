package es.studium.mialarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button miBoton;
EditText mEditMe,mEditHo,mEditMi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miBoton=findViewById(R.id.btnAlarma);
        mEditMe=findViewById(R.id.textMensaje);
        mEditHo=findViewById(R.id.textHora);
        mEditMi=findViewById(R.id.textMinutos);
        //Le añadimos el Listener correspondiente
        miBoton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==(R.id.btnAlarma)){
            crearAlarma(v, mEditMe, mEditHo, mEditMi);
        }
    }

    private void crearAlarma(View view, EditText mEditMe,EditText mEditHo,EditText mEditMi) {
        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,mEditMe.getText().toString())
                .putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(mEditHo.getText().toString()))
                .putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt(mEditMi.getText().toString()));
                //.putExtra(AlarmClock.EXTRA_HOUR, Integer.valueOf(String.valueOf(mEditHo)))
                //.putExtra(AlarmClock.EXTRA_MINUTES,Integer.valueOf(String.valueOf(mEditMi)));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}