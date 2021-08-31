package cl.ceduc.calculadorag2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_add, btn_divide, btn_subtract, btn_multiply, btn_backspace, btn_clear, btn_decimal, btn_equal, btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine;
    private TextView txt_display;
    private double num1, num2, resultado;
    private String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos los botones numericos
        Button btn_zero = (Button) this.findViewById(R.id.btn_zero);
        Button btn_one = (Button) this.findViewById(R.id.btn_one);
        Button btn_two = (Button) this.findViewById(R.id.btn_two);
        Button btn_three = (Button) this.findViewById(R.id.btn_three);
        Button btn_four = (Button) this.findViewById(R.id.btn_four);
        Button btn_five = (Button) this.findViewById(R.id.btn_five);
        Button btn_six = (Button) this.findViewById(R.id.btn_six);
        Button btn_seven = (Button) this.findViewById(R.id.btn_seven);
        Button btn_eight = (Button) this.findViewById(R.id.btn_eight);
        Button btn_nine = (Button) this.findViewById(R.id.btn_nine);
        //Asignamos los botones operacionales
        Button btn_add = (Button) this.findViewById(R.id.btn_add);
        Button btn_divide = (Button) this.findViewById(R.id.btn_divide);
        Button btn_multiply = (Button) this.findViewById(R.id.btn_multiply);
        Button btn_subtract = (Button) this.findViewById(R.id.btn_subtract);
        Button btn_backspace = (Button) this.findViewById(R.id.btn_backspace);
        Button btn_clear = (Button) this.findViewById(R.id.btn_clear);
        Button btn_decimal = (Button) this.findViewById(R.id.btn_decimal);
        Button btn_equal = (Button) this.findViewById(R.id.btn_equal);
        //Asignamos la pantalla
        TextView txt_display = (TextView) this.findViewById(R.id.txt_display);

        btn_zero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("0");}
        });
        btn_one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("1");}
        });
        btn_two.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("2");}
        });
        btn_three.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("3");}
        });
        btn_four.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("4");}
        });
        btn_five.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("5");}
        });
        btn_six.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("6");}
        });
        btn_seven.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("7");}
        });
        btn_eight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("8");}
        });
        btn_nine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setDigito("9");}
        });
        btn_decimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {setDigito("."); }
        });


        btn_divide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {OnClickOperacionNum1();}
        });
        btn_multiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setOperacion();}
        });
        btn_add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setOperacion(add("+"););}
        });
        btn_subtract.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {setOperacion("-");}
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {setClear("C");}
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {setEqual("=");}
        });
    }

    void setDigito(String digito){
        TextView txt_display = (TextView) this.findViewById(R.id.txt_display);
        String actual = txt_display.getText().toString();
        String nuevo = actual + digito;
        txt_display.setText(nuevo);
    }
    void setClear (String clear){
        TextView txt_display = (TextView) this.findViewById(R.id.txt_display);
        num1 = 0;
        num2 = 0;
        txt_display.setText("");
    }
    public void setOperacion (String operacion){
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        num1=Double.parseDouble(txt_display.getText().toString());
        txt_display.setText(" ");
    }
    public void add (View view){
        operador = "+";
        setOperacion(" ");
    }
    public void subtract (View view){
        operador = "-";
        OnClickOperacionNum1(view);
    }
    public void multiply (View view){
        operador = "*";
        OnClickOperacionNum1(view);
    }
    public void divide (View view){
        operador = "/";
        OnClickOperacionNum1(view);
    }
    public void setEqual (View v){
        txt_display = (TextView) this.findViewById(R.id.txt_display);
        num2=Double.parseDouble(txt_display.getText().toString());
        if (operador.equals("+")){
            resultado=num1+num2;
        }else if (operador.equals("-")){
            resultado=num1-num2;
        }else if (operador.equals("*")){
            resultado=num1*num2;
        }else if (operador.equals("/")){
            resultado=num1/num2;
        }
        txt_display.setText(" "+resultado);
    }


 }