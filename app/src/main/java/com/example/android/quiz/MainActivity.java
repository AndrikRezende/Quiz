package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int RESPOSTA_CORRETA_QUESTAO1 = 2;
    private final int ESCOLHA_UM = 1;
    private final int ESCOLHA_DOIS = 2;
    private final int ESCOLHA_TRES = 3;
    private final int ESCOLHA_QUATRO = 4;
    //resposta correta; 70km/h , X>15 , 10h
    private final int []RESPOSTAS_CORRETAS={ESCOLHA_TRES,ESCOLHA_TRES,ESCOLHA_QUATRO};
    //resposta correta; -3 e 0,5
    private final boolean []RESPOSTAS_CORRETAS_QUESTAO5={false,true,true,false};

    // valor 1 corresponde apenas o primeiro RadioButton marcado e assim por adiante
    // cada posição equivale ao um RadioGroup
    private int []respostasRadioButton = new int[3];
    // cada posição do vetor equivale a um Checkbox, true se marcado, false se não marcado
    private boolean[]respostaCheckBox = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Este metodo é chamado quando radioButton é clicado
     * @param view
     */

    public void onClickRadioButton2 (View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.id_radioButton2_1:
                if (checked)
                    respostasRadioButton[0] = ESCOLHA_UM;
                break;
            case R.id.id_radioButton2_2:
                if (checked)
                    respostasRadioButton[0] = ESCOLHA_DOIS;
                break;
            case R.id.id_radioButton2_3:
                if (checked)
                    respostasRadioButton[0] = ESCOLHA_TRES;
                break;
            case R.id.id_radioButton2_4:
                if (checked)
                    respostasRadioButton[0] = ESCOLHA_QUATRO;
                break;
        }
    }

    /**
     * Este metodo é chamado quando radioButton é clicado
     * @param view
     */

    public void onClickRadioButton3 (View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.id_radioButton3_1:
                if (checked)
                    respostasRadioButton[1] = ESCOLHA_UM;
                break;
            case R.id.id_radioButton3_2:
                if (checked)
                    respostasRadioButton[1] = ESCOLHA_DOIS;
                break;
            case R.id.id_radioButton3_3:
                if (checked)
                    respostasRadioButton[1] = ESCOLHA_TRES;
                break;
            case R.id.id_radioButton3_4:
                if (checked)
                    respostasRadioButton[1] = ESCOLHA_QUATRO;
                break;
        }
    }

    /**
     * Este metodo é chamado quando radioButton é clicado
     * @param view
     */

    public void onClickRadioButton4 (View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.id_radioButton4_1:
                if (checked)
                    respostasRadioButton[2] = ESCOLHA_UM;
                break;
            case R.id.id_radioButton4_2:
                if (checked)
                    respostasRadioButton[2] = ESCOLHA_DOIS;
                break;
            case R.id.id_radioButton4_3:
                if (checked)
                    respostasRadioButton[2] = ESCOLHA_TRES;
                break;
            case R.id.id_radioButton4_4:
                if (checked)
                    respostasRadioButton[2] = ESCOLHA_QUATRO;
                break;
        }
    }

    /**
     * Este metodo é chamado quando checkbox é clicado
     * @param view
     */

    public void onClickCheckBox5 (View view){
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.id_checkBox5_1:
                if (checked)
                    respostaCheckBox[0] = true;
                else
                    respostaCheckBox[0] = false;
                break;
            case R.id.id_checkBox5_2:
                if (checked)
                    respostaCheckBox[1] = true;
                else
                    respostaCheckBox[1] = false;
                break;
            case R.id.id_checkBox5_3:
                if (checked)
                    respostaCheckBox[2] = true;
                else
                    respostaCheckBox[2] = false;
                break;
            case R.id.id_checkBox5_4:
                if (checked)
                    respostaCheckBox[3] = true;
                else
                    respostaCheckBox[3] = false;
                break;
        }
    }

    /**
     * Este metodo é chamado quando o botão verificar respostas é clicado
     * @param view
     */

    public void verificarRespostas(View view){
        String questoesCertas= "";
        int pontuacao = 0;
        EditText numeroEditText = (EditText) findViewById(R.id.id_editText1);
        String resposta1 = numeroEditText.getText().toString();
        if(!resposta1.isEmpty()&&Integer.parseInt(resposta1)==RESPOSTA_CORRETA_QUESTAO1){
            questoesCertas = "1 ";
            pontuacao = pontuacao + 1;
        }
        for(int i=0;i<=2;i++)
            if(respostasRadioButton[i]==RESPOSTAS_CORRETAS[i]) {
                int n=i+2;
                questoesCertas = questoesCertas + n + ' ';
                pontuacao = pontuacao + 1;
            }
        if(respostaCheckBox[0]==RESPOSTAS_CORRETAS_QUESTAO5[0])// checkbox errado desmarcado
            if(respostaCheckBox[1]==RESPOSTAS_CORRETAS_QUESTAO5[1])// checkbox certo marcado
                if(respostaCheckBox[2]==RESPOSTAS_CORRETAS_QUESTAO5[2])// checkbox certo marcado
                    if (respostaCheckBox[3] == RESPOSTAS_CORRETAS_QUESTAO5[3]) {// checkbox errado desmarcado
                        questoesCertas = questoesCertas +"5";
                        pontuacao = pontuacao + 1;
                    }
        if(questoesCertas.isEmpty())
            questoesCertas="nenhum";
        Toast.makeText(this,"Questões certas: "+questoesCertas+" Pontuação: "+pontuacao,Toast.LENGTH_SHORT).show();
    }
}
