package primeiro.cliente.ferramentalayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    EditText editNomeCompleto;
    Button btnConfirmar;
    ToggleButton tbLigado;
    Switch swMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        editNomeCompleto = findViewById(R.id.editTextNome);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        tbLigado = findViewById(R.id.tbLigado);
        swMostrar = findViewById(R.id.swMostrar);


        txtTitulo.setText("Retrato Principal");

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean dadosPreenchidos = true;

                if (TextUtils.isEmpty(editNomeCompleto.getText().toString())) {
                    editNomeCompleto.setError("Por favor, digite o nome completo:");
                    //Toast.makeText(getBaseContext(), "Digite o nome: ", Toast.LENGTH_LONG).show();
                    dadosPreenchidos = false;
                }


                if (dadosPreenchidos) {
                    Toast.makeText(getBaseContext(), "Você digitou: " + editNomeCompleto.getText(), Toast.LENGTH_LONG).show();
                }
            }
        });

        tbLigado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tbLigado.isChecked())
                    editNomeCompleto.setEnabled(false);
                else editNomeCompleto.setEnabled(true);
            }
        });

        swMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swMostrar.isChecked()){
                    txtTitulo.setVisibility(View.GONE);
                }

                else{
                    txtTitulo.setVisibility(View.VISIBLE);
                    String novoTitulo = txtTitulo.getText().toString().toLowerCase();
                    txtTitulo.setText(novoTitulo);

                }

            }
        });
    }
}
