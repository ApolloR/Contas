package fatecmm.edu.br.contasmensaisapolo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdicionarContaActivity extends AppCompatActivity {

    private ContaADO contaADO;
    private EditText descricaoConta,valorConta;
    private Button btn_Salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contaADO = new ContaADO(getBaseContext());
        descricaoConta = (EditText) findViewById(R.id.descricaoConta);
        valorConta = (EditText) findViewById(R.id.valorConta);
        btn_Salvar = (Button) findViewById(R.id.btn_Salvar);

        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contaADO.open();
                contaADO.insertConta(descricaoConta.getText().toString(),Double.parseDouble(valorConta.getText().toString()));
            }
        });
    }

}
