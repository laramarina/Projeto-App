package br.edu.fecap.projetoni;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private RadioGroup generos;
    private SeekBar seekBar;
    private TextView textoResultado;
    int indice;
    int[] listaImg = {R.drawable.acaonac, R.drawable.comedianac,
            R.drawable.ficcao,R.drawable.romance,R.drawable.terrorint};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generos = findViewById(R.id.radioGenero);
        seekBar = findViewById(R.id.seekBarEscala);
        textoResultado = findViewById(R.id.textoResultado);
        indice = 0;
        opcaoSelect();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textoResultado.setText("Assistiria: " + i + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                textoResultado.setText("onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                textoResultado.setText("onStopTrackingTouch");
            }
        });
    }

    public void opcaoSelect() {

        generos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton3:
                        indice = 0;
                        break;

                    case R.id.radioButton4:
                        indice = 1;
                        break;

                    case R.id.radioButton5:
                        indice = 2;
                         break;

                    case R.id.radioButton6:
                        indice = 3;
                    break;

                    case R.id.radioButton7:
                        indice = 4;
                        break;
                }
            }
        });
    }
    public void enviar(View view){
        ImageView fundoFilme = findViewById(R.id.fundoFilme);
        fundoFilme.setImageResource(listaImg[indice]);
    }
        public void abrirDialog(View view){

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);


            dialog.setTitle("ALERTA");
            dialog.setMessage("Você gostou da indicação?");


            dialog.setCancelable(false);

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Que bom que gostou!",
                            Toast.LENGTH_LONG
                    ).show();
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Que pena, tente outro gênero!",
                            Toast.LENGTH_LONG
                    ).show();
                }
            });
            dialog.create();
            dialog.show();

        }
    }


