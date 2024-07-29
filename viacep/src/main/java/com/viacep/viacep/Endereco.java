package com.viacep.viacep;

import java.util.Scanner;
import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import lombok.Data;




@Data
public class Endereco {

    protected String cep;
    private String localidade;
    private String logradouro;
    private String bairro;
    private String uf;
    private String ddd;
    private String complemento;



    public static Endereco getEnderecoByCep(String cep) {
        Endereco endereco = new Endereco();
        OkHttpClient client = new OkHttpClient();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (response.isSuccessful() && response.body() != null) {
                String result = response.body().string();

                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);
                System.out.println("CEP: " + endereco.getCep());
                System.out.println("Cidade:" + endereco.getLocalidade());
                System.out.println("Endereço: " + endereco.getLogradouro());
                System.out.println("Bairro: " + endereco.getBairro());
                System.out.println("UF: " + endereco.getUf());
                System.out.println("DDD:" + endereco.getDdd());
                

            } else {
                System.out.println("Erro ao buscar CEP: " + response.code());
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar CEP: " + e.getMessage());
        }

        return endereco;

    }
}

