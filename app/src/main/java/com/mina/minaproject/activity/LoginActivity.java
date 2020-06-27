package com.mina.minaproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mina.minaproject.R;
import com.mina.minaproject.helper.ConfiguracaoFirebase;
import com.mina.minaproject.helper.UsuariaFirebase;
import com.mina.minaproject.models.Usuaria;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnEsqueciSenha;
    private Button btnEntrar;
    private Button btnCriarConta;


    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.iniciaComponentes();
        this.verificarUsuarioLogado();

    }

    public void recuperarSenha(View view){ // sera usado no btn (esqueci a senha)

    }

    public void entrarNaConta(View view){ // fara a validação do login
        String email=edtEmail.getText().toString();
        String senha=edtSenha.getText().toString();

        FirebaseAuth autenticacao=ConfiguracaoFirebase.getAutenticador();

        if(this.confereCampos()){
            autenticacao.signInWithEmailAndPassword(email,senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(), TelaAposLoginActivity.class));
                            }else{
                                Toast.makeText(getApplicationContext(),
                                        "Erro ao fazer login",
                                        Toast.LENGTH_LONG).show();
                            }

                        }
                    });
        }
    }

    public void criarConta(View view){// transfere para a criação de conta
        startActivity(new Intent(getApplicationContext(), CriarContaActivity.class));
    }

    public void verificarUsuarioLogado(){
        this.autenticacao = ConfiguracaoFirebase.getAutenticador();
        if( this.autenticacao.getCurrentUser() != null ){
            startActivity(new Intent(getApplicationContext(), TelaAposLoginActivity.class));
            finish();
        }
    }

    private boolean confereCampos(){
        if(!edtEmail.getText().toString().isEmpty()){
            if(!edtSenha.getText().toString().isEmpty()){
                return true;
            }else{
                Toast.makeText(this, "Por favor preecha o campo: Senha", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Por favor preecha o campo: E-mail", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    private void iniciaComponentes(){
        this.edtEmail=findViewById(R.id.edtEmail);
        this.edtSenha=findViewById(R.id.edtSenha);
        this.btnEntrar=findViewById(R.id.btnEntrar);
        this.btnCriarConta=findViewById(R.id.btnCriarConta);
        this.btnEsqueciSenha=findViewById(R.id.btnEsqueciSenha);
    }

}
