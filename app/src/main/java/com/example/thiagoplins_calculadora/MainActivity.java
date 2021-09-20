package com.example.thiagoplins_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numZero, numUm, numDois, numTres, numQuatro, numCinco, numSeis, numSete, numOito, numNove, numDecimal, btnSoma, btnSubtracao,
    btnDivisao, btnMultiplicacao, btnResultado, btnLimpar;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numZero.setOnClickListener(this);
        numUm.setOnClickListener(this);
        numDois.setOnClickListener(this);
        numTres.setOnClickListener(this);
        numQuatro.setOnClickListener(this);
        numCinco.setOnClickListener(this);
        numSeis.setOnClickListener(this);
        numSete.setOnClickListener(this);
        numOito.setOnClickListener(this);
        numNove.setOnClickListener(this);
        numDecimal.setOnClickListener(this);
        btnSoma.setOnClickListener(this);
        btnSubtracao.setOnClickListener(this);
        btnMultiplicacao.setOnClickListener(this);
        btnDivisao.setOnClickListener(this);
    }

    private void IniciarComponentes(){
        numZero = findViewById(R.id.numZero);
        numUm = findViewById(R.id.numUm);
        numDois = findViewById(R.id.numDois);
        numTres = findViewById(R.id.numTres);
        numQuatro = findViewById(R.id.numQuatro);
        numCinco = findViewById(R.id.numCinco);
        numSeis = findViewById(R.id.numSeis);
        numSete = findViewById(R.id.numSete);
        numOito = findViewById(R.id.numOito);
        numNove = findViewById(R.id.numNove);
        numDecimal = findViewById(R.id.numDecimal);
        btnSoma = findViewById(R.id.btnSoma);
        btnSubtracao = findViewById(R.id.btnSubtracao);
        btnDivisao = findViewById(R.id.btnDivisao);
        btnMultiplicacao = findViewById(R.id.btnMultiplicacao);
        btnResultado = findViewById(R.id.btnResultado);
        btnLimpar = findViewById(R.id.btnLimpar);
        txtExpressao = findViewById(R.id.txtExpressao);
        txtResultado = findViewById(R.id.txtResultado);
        backspace = findViewById(R.id.backspace);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txtExpressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch ( Exception e){

                }

            }
        });

    }

    public void AddExpression(String string, boolean btnLimpar){
        if(txtResultado.getText().equals("")){
            txtResultado.setText(" ");
        }

        if (btnLimpar){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numZero:
                AddExpression( "0", true );
                break;
            case R.id.numUm:
                AddExpression( "1", true );
                break;
            case R.id.numDois:
                AddExpression( "2", true );
                break;
            case R.id.numTres:
                AddExpression( "3", true );
                break;
            case R.id.numQuatro:
                AddExpression( "4", true );
                break;
            case R.id.numCinco:
                AddExpression( "5", true );
                break;
            case R.id.numSeis:
                AddExpression( "6", true );
                break;
            case R.id.numSete:
                AddExpression( "7", true );
                break;
            case R.id.numOito:
                AddExpression( "8", true );
                break;
            case R.id.numNove:
                AddExpression( "9", true );
                break;
            case R.id.numDecimal:
                AddExpression( ".", true );
                break;

            case R.id.btnSoma:
                AddExpression( "+", false );
                break;
            case R.id.btnSubtracao:
                AddExpression( "-", false );
                break;
            case R.id.btnMultiplicacao:
                AddExpression( "*", false );
                break;
            case R.id.btnDivisao:
                AddExpression( "/", false );
                break;
        }
    }
}