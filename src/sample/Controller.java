package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_field;

    @FXML
    private Button clear_btn;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button divide_btn;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_9;

    @FXML
    private Button mult_btn;

    @FXML
    private Button btn_6;

    @FXML
    private Button minus_btn;

    @FXML
    private Button btn_3;

    @FXML
    private Button plus_btn;

    @FXML
    private Button comma_btn;

    @FXML
    private Button equal_btn;

    private String strNum = "";
    private float first_num = 0;
    private char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(event -> {
            addNumber(0);
        });
        btn_1.setOnAction(event -> {
            addNumber(1);
        });
        btn_2.setOnAction(event -> {
            addNumber(2);
        });
        btn_3.setOnAction(event -> {
            addNumber(3);
        });
        btn_4.setOnAction(event -> {
            addNumber(4);
        });
        btn_5.setOnAction(event -> {
            addNumber(5);
        });
        btn_6.setOnAction(event -> {
            addNumber(6);
        });
        btn_7.setOnAction(event -> {
            addNumber(7);
        });
        btn_8.setOnAction(event -> {
            addNumber(8);
        });
        btn_9.setOnAction(event -> {
            addNumber(9);
        });

        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        mult_btn.setOnAction(event -> {
            mathAction('*');
        });
        divide_btn.setOnAction(event -> {
            mathAction('/');
        });
        equal_btn.setOnAction(event -> {
            if (this.operation == '+' || this.operation == '-' || this.operation == '/' || this.operation == '*')
                equalMetgod();
        });
        comma_btn.setOnAction(event -> {
            if (!this.strNum.contains(".")) {
                this.strNum += ".";
                label_field.setText(strNum);
            }
        });

        percent_btn.setOnAction(event -> {
            if (this.strNum != "") {
                float num = Float.parseFloat(this.strNum) * 0.1f;
                this.strNum = Float.toString(num);
                label_field.setText(strNum);
            }
        });
        plus_minus_btn.setOnAction(event -> {
            if (this.strNum != "") {
                float num = Float.parseFloat(this.strNum) * -1;
                this.strNum = Float.toString(num);
                label_field.setText(strNum);
            }
        });

        clear_btn.setOnAction(event ->  {
            label_field.setText("0");
            this.strNum = "";
            this.first_num = 0;
            this.operation = 'A';

        });

    }

    private void equalMetgod() {
        float res = 0;
        switch (this.operation) {
            case '+':
                res = this.first_num + Float.parseFloat(this.strNum);
                break;
            case '-':
                res = this.first_num - Float.parseFloat(this.strNum);
                break;
            case '/':
                if (Float.parseFloat(this.strNum) != 0)
                    res = this.first_num / Float.parseFloat(this.strNum);
                else
                    res = 0;
                break;
            case '*':
                res = this.first_num * Float.parseFloat(this.strNum);
                break;
        }

        label_field.setText(Float.toString(res));
        this.strNum = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    private void mathAction(char operation) {
        if (this.operation != '+' && this.operation != '-' && this.operation != '/' && this.operation != '*') {
            this.first_num = Float.parseFloat(this.strNum);
            label_field.setText(String.valueOf(operation));
            this.strNum = "";
            this.operation = operation;
        }

    }

    private void addNumber(int number) {
        this.strNum += Integer.toString(number);
        label_field.setText(strNum);

    }
}
