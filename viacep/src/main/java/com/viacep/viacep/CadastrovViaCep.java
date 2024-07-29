package com.viacep.viacep;

import java.util.Scanner;
import lombok.Data;


@Data
public class CadastrovViaCep extends Endereco{

    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected String cep;
    
    
    public CadastrovViaCep(String nome,String cpf, String telefone, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        
        this.cep = cep;
        
    }
   
    
  

    
}
