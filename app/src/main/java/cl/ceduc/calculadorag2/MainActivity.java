package cl.ceduc.calculadorag2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine, btn_decimal, btn_clear, btn_delete, btn_add, btn_subtract, btn_multiply,btn_divide, btn_equal;
    TextView txt_display;
    double num1, num2, digito, resultado;
    String operador, actual, nuevo, txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos los botones numericos
        btn_zero = (Button) findViewById(R.id.btn_zero);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_six = (Button) findViewById(R.id.btn_six);
        btn_seven = (Button) findViewById(R.id.btn_seven);
        btn_eight = (Button) findViewById(R.id.btn_eight);
        btn_nine = (Button) findViewById(R.id.btn_nine);
        btn_decimal = (Button) findViewById(R.id.btn_decimal);
        //Asignamos los botones operacionales
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_subtract = (Button) findViewById(R.id.btn_subtract);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        //Asignamos la pantalla
        txt_display = (TextView) findViewById(R.id.txt_display);

        btn_zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("0");}});
        btn_one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("1");}});
        btn_two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("2");}});
        btn_three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("3");}});
        btn_four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("4");}});
        btn_five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("5");}});
        btn_six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("6");}});
        btn_seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("7");}});
        btn_eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("8");}});
        btn_nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("9");}});
        btn_decimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDecimal();}});

        //Botones Operacionales
        btn_clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setClear();}});
        btn_delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDelete();}});
        btn_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setOperacion();
                operador = "+";
            }});
        btn_subtract.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setOperacion();
                operador = "-";
            }});
        btn_multiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setOperacion();
                operador = "*";
            }});
        btn_divide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setOperacion();
                operador = "/";
            }});
        btn_equal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setEqual();
            }});
    }

    public void setDigito(String ingresonum) {
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        digito = Double.parseDouble(txt_display.getText().toString());
            if (digito != 0.0) {
                actual = txt_display.getText().toString();
                nuevo = actual + ingresonum;
                txt_display.setText(nuevo);
            }else{
                txt_display.setText(ingresonum);
            }
        // borrar numero despues de una operacion, sino siguen los numeros agregandos
    }

    public void setDecimal (){
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        digito = Double.parseDouble(txt_display.getText().toString());
        if (digito == 0) {
            actual = "0.";
            //txt_display.setText("0." + setDigito()); // falta cohesionar numero 0. + se imprime despues el numero
        } else {
            txt_display = (TextView) this.findViewById(R.id.txt_display);
            String txt = txt_display.getText().toString();
                if (!txt.contains(".")) {
                // txt_display.append("." + setDigito());
            }
        }
    }

    public void setOperacion() {
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        num1 = Double.parseDouble(txt_display.getText().toString());

    }

    public void setEqual() {
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        num2=Double.parseDouble(txt_display.getText().toString());
        if (operador.equals("+")) {
            resultado = num1 + num2;
        }else if (operador.equals("-")) {
            resultado = num1 - num2;
        }else if (operador.equals("*")) {
            resultado = num1 * num2;
        }else if (operador.equals("/")) {
            if (num2 == 0){
                Toast.makeText(this,"Operación no válida",Toast.LENGTH_LONG).show();
                txt_display.setText("0");
            }else{
                resultado = num1 / num2;
            }}
        txt_display.setText(resultado+"");
        //DecimalFormat format = new DecimalFormat("0.#");
        //txt_display.setText((format.format(resultado)));

        num1 = 0;
        num2 = 0;
        operador = "";

        //si se ingresa otro numero , se debe borrar el anterior y comenzar a escribir con otro
        // txt_display.setText("0");


    }

    public boolean setClear() {
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        num1 = 0;
        num2 = 0;
        operador = "";
        txt_display.setText("0");
        return false;
    }

    public void setDelete () {
        String txt = txt_display.getText().toString();
        if (txt.length() > 0) {
            txt = txt.substring(0, txt.length() - 1);
            if (txt.equals(""))
                txt = "0";
                txt_display.setText(txt);
            //txt_display.setSelection(txt.length());
            }
    }
}