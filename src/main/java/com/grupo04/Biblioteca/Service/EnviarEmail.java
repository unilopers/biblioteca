package com.grupo04.Biblioteca.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EnviarAviso {

    @Async
    public void enviarAvisoTrocaSenha(String dsEmail, String nmBibliotecario) {
        try {
            Thread.sleep(3000);

            System.out.println("=================================");
            System.out.println("AVISO DE TROCA DE SENHA");
            System.out.println("E-mail enviado para: " + dsEmail);
            System.out.println("Bibliotecário: " + nmBibliotecario);
            System.out.println("Mensagem: Olá, por segurança, recomendamos que você altere sua senha.");
            System.out.println("=================================");

        } catch (InterruptedException e) {
            System.out.println("Erro ao enviar o aviso de troca de senha");
        }
    }
}
