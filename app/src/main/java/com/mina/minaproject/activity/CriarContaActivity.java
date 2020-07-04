package com.mina.minaproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mina.minaproject.R;
import com.mina.minaproject.helper.ConfiguracaoFirebase;
import com.mina.minaproject.helper.UsuariaFirebase;
import com.mina.minaproject.models.Usuaria;

public class CriarContaActivity extends AppCompatActivity {
    public SharedPreferences preferences;

    //campos para cadastro
    private EditText editNome;
    private EditText editSobrenome;
    private EditText editCpf;
    private EditText editDataNascimento;
    private EditText editTelefone;
    private EditText editCidade;
    private EditText editEmail;
    private EditText editSenha;
    private Button btnContinuar;

    private String[] nomes={"Nome","Sobrenome", "CPF", "DataDeNascimento","Telefone","Cidade","Email","Senha"};

    private Usuaria usuaria;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        this.iniciaComponentes();


    }

    public void voltarParaLogin(View view){
        finish();
    }

    public void continuarCriacaoDeConta(View view){
        this.salvaPreferencias();
        this.cadastra();

        finish();
    }

    public void salvaPreferencias(){
        //Salva os dados em um arquivo de preferencias para posterior uso
        preferences=getSharedPreferences(getString(R.string.PREFERENCES_USUARIO), 0);//pode ser acessado dessa forma de qualquer activity
        SharedPreferences.Editor editor=preferences.edit();//instancia um editor

        editor.putString("Nome", editNome.getText().toString());
        editor.putString("Sobrenome", editSobrenome.getText().toString());
        editor.putString("CPF", editCpf.getText().toString());
        editor.putString("DataDeNascimento", editDataNascimento.getText().toString());
        editor.putString("Telefone", editTelefone.getText().toString());
        editor.putString("Cidade", editCidade.getText().toString());
        editor.putString("Email", editEmail.getText().toString());
        editor.putString("Senha", editSenha.getText().toString());
        editor.commit();//salva no Preferences

    }




    public void cadastra(){

        String nome=editNome.getText().toString();
        String sobrenome=editSobrenome.getText().toString();
        String cpf=editCpf.getText().toString();
        String dataDeNascimento=editDataNascimento.getText().toString();
        String telefone=editTelefone.getText().toString();
        String cidade= editCidade.getText().toString();
        String email=editEmail.getText().toString();
        String senha= editSenha.getText().toString();

        if(this.confereCamposVazios()){
            usuaria=new Usuaria();
            usuaria.setNome(nome);
            usuaria.setSobrenome(sobrenome);
            usuaria.setCpf(cpf);
            usuaria.setDataNascimento(dataDeNascimento);
            usuaria.setTelefone(telefone);
            usuaria.setCidade(cidade);
            usuaria.setEmail(email);
            usuaria.setSenha(senha);


            autenticacao= ConfiguracaoFirebase.getAutenticador();
            autenticacao.createUserWithEmailAndPassword(
                    usuaria.getEmail(),
                    usuaria.getSenha()
            ).addOnCompleteListener(
                    CriarContaActivity.this,
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                try {
                                    String id = task.getResult().getUser().getUid();//pega o id do usuario
                                    //UsuariaFirebase.cadastraFirestore(usuaria, id);//cadastra no banco

                                    FirebaseFirestore firestore= ConfiguracaoFirebase.getFirestore();

                                    firestore.collection("users")
                                            .add(usuaria).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Log.i("success", "DocumentSnapshot added with ID: " + documentReference.getId());
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.i("error", "Error adding document", e);
                                        }
                                    });


                                    Toast.makeText(getApplicationContext(), "Cadastro concluido.",
                                            Toast.LENGTH_SHORT).show();


                                    if(confereCamposVazios()){
                                        startActivity(new Intent(getApplicationContext(), ValidarContaActivity.class));
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                            }else{
                                Log.i("abc", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "A senha precisa de no mínimo 6 caracteres.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
            );
            //aqui pegar o id, salvar no firestore
        }

    }

    public boolean confereCamposVazios(){
        String nomeCampo="";

        if( !editNome.getText().toString().isEmpty() ){
            if( !editSobrenome.getText().toString().isEmpty()){
                if(!editCpf.getText().toString().isEmpty()){
                    if(!editDataNascimento.getText().toString().isEmpty()){
                        if(!editTelefone.getText().toString().isEmpty()){
                            if(!editCidade.getText().toString().isEmpty()){
                                if(!editEmail.getText().toString().isEmpty()){
                                    if(!editSenha.getText().toString().isEmpty()){

                                        return true;

                                    }else nomeCampo="Senha";
                                }else nomeCampo="E-mail";
                            }else nomeCampo= "Cidade";
                        }else nomeCampo= "Telefone";
                    }else nomeCampo= "Data de Nascimento";
                }else nomeCampo = "CPF";
            }else nomeCampo= "Sobrenome";
        }else nomeCampo="Nome";


        Toast.makeText(this, "Por favor preecha o campo:"+ nomeCampo, Toast.LENGTH_LONG).show();
        return false;
    }

    public void iniciaComponentes(){
        editNome=findViewById(R.id.edtNome);
        editSobrenome=findViewById(R.id.edtSobrenome);
        editCpf=findViewById(R.id.edtCpf);
        editDataNascimento=findViewById(R.id.edtDataNascimento);
        editTelefone=findViewById(R.id.edtTelefone);
        editCidade=findViewById(R.id.edtCidade);
        editEmail=findViewById(R.id.edtEmail);
        editSenha=findViewById(R.id.edtSenha);
        btnContinuar=findViewById(R.id.btnContinuar);


        editNome.requestFocus();
    }

}
