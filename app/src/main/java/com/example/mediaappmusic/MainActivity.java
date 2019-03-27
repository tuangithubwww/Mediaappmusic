package com.example.mediaappmusic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtuser, edtpassword;
    Button btndangnhap, btndangky, btnthoat;
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Controlbtn();
    }
    //chuc nang cua button
    private void Controlbtn() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thoat ung dung?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Cancel!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("DANG KY TAI KHOAN MOI!");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dangkydialog);
                final EditText edtuserdk = (EditText) dialog.findViewById(R.id.edtuserdk);
                final EditText edtpassdk = (EditText) dialog.findViewById(R.id.edtpassdk);
                Button btnhuydk = (Button) dialog.findViewById(R.id.btnhuydk);
                Button btndongydk = (Button) dialog.findViewById(R.id.btndongydk);
                btndongydk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        user = edtuserdk.getText().toString().trim();
                        pass = edtpassdk.getText().toString().trim();

                        edtuser.setText(user);
                        edtpassword.setText(pass);

                        dialog.cancel();
                    }
                });
                btnhuydk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtuser.getText().length() != 0 && edtpassword.getText().length() != 0){
                    if(edtuser.getText().toString().equals(user) && edtpassword.getText().toString().equals(pass)){
                        Toast.makeText(MainActivity.this,"Dang nhap thanh cong!",Toast.LENGTH_SHORT).show();
                        Intent acti2 = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(acti2);//chuyen man hinh
                    }else if(edtuser.getText().toString().equals("media") && edtpassword.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this,"Dang nhap thanh cong!",Toast.LENGTH_SHORT).show();
                        Intent acti2 = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(acti2);
                    }else {
                        Toast.makeText(MainActivity.this,"Dang nhap that bai!",Toast.LENGTH_SHORT).show();
                        //thong bao dang nhap
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Vui long nhap du thong tin!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //tham chieu den cac thanh phan
    private void Anhxa() {
        edtuser = (EditText) findViewById(R.id.edittextuser);
        edtpassword = (EditText) findViewById(R.id.edittextpassword);
        btndangky = (Button) findViewById(R.id.btndangky);
        btndangnhap = (Button) findViewById(R.id.btndangnhap);
        btnthoat = (Button) findViewById(R.id.btnthoat);
    }

}
