package com.viacep.viacep;

import java.util.Scanner;




public class Menu extends CadastrovViaCep  {
    

    public Menu(String nome, String cpf, String telefone, String cep) {
       super(nome, cpf, telefone, cep);

    }

    public void MenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        String numero;
        String complemento;

        System.out.println("\n\n\n"+"\n--- Bem vindo ao cadastro do viaCep ---\n");
        System.out.println("Preencha o cadastro;");
        try {
            
            System.out.print("Nome:");
            this.nome = sc.nextLine();
            if (nome.isBlank()) {
                throw new IllegalArgumentException("O campo nome não pode ficar em branco");
              
            }

            System.out.print("CPF:");
            this.cpf = sc.nextLine();
            if (cpf.isBlank()) {
                throw new IllegalArgumentException("O campo cpf não pode ficar em branco");

            } else if (cpf.length() != 11) {
                throw new IllegalAccessError("CPF invalido!");

            }
            for (char c : cpf.toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException("Digite somente numeros no campo CPF!");

                }
            }

            System.out.print("Telefone:");
            this.telefone = sc.nextLine();
            if (telefone.isBlank()) {
                throw new IllegalArgumentException("O campo telefone não pode ficar em branco");
            } else if (telefone.length() != 9) {
                throw new IllegalAccessError("Numero de telefone incorreto!");
            }
            
             System.out.print("Email:");
             this.email = sc.nextLine();
             if (!email.equals(nome + "@gmail.com")) {
                throw new IllegalArgumentException("email invalido!\n sugestão para cadastro:" + nome + "@gmail.com");
                
             }
            
          
            System.out.print("CEP:");
            this.cep = sc.nextLine();

            Endereco endereco = Endereco.getEnderecoByCep(getCep());
            System.out.print("Confirma endereco?S/N:");
            String confirma = sc.nextLine();

            if (confirma.equalsIgnoreCase("s")) {
                System.out.print("Digite o numero:");
                numero = sc.nextLine();
                System.out.print("Digite o complemento:");
                complemento = sc.nextLine();
                System.out.println("\n* Ficha de dados *");
                System.out.println("nome:" + getNome());
                System.out.println("CPF:" + getCpf());
                System.out.println("Telefone:" + getTelefone());
                System.out.println("Email:" + getEmail());
                endereco.getEnderecoByCep(getCep());
                System.out.println("Numero:" + numero);
                System.out.println("Complemento:" + complemento);

            } else if (confirma.equalsIgnoreCase("n")) {
                System.out.print("CEP:");
                cep = sc.nextLine();
                System.out.print("Cidade:");
                String cidade = sc.nextLine();
                System.out.print("Bairro:");
                String bairro = sc.nextLine();
                System.out.print("Rua:");
                String rua = sc.nextLine();
                System.out.print("UF:");
                String uf = sc.nextLine();
                System.out.print("DDD:");
                String ddd = sc.nextLine();
                System.out.print("Numero:");
                numero = sc.nextLine();
                System.out.print("Complemento:");
                complemento = sc.nextLine();
                System.out.println("\n* Ficha de dados *");
                System.out.println("nome:" + getNome());
                System.out.println("CPF:" + getCpf());
                System.out.println("Telefone:" + getTelefone());
                System.out.println("Email:" + getEmail());
                endereco.getEnderecoByCep(getCep());
                System.out.println("Numero:" + numero);
                System.out.println("Complemento:" + complemento);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro:" + e.getMessage());

        } catch (IllegalAccessError a) {
            System.out.println("Erro:" + a.getMessage());

        } catch (UnsupportedOperationException i) {
            System.out.println("Erro:" + i.getMessage());

        }
    }

  }