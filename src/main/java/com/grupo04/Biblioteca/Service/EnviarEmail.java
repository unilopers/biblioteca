package com.grupo04.Biblioteca.services;

import com.grupo04.Biblioteca.models.BibliotecarioModel;
import com.grupo04.Biblioteca.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnviarAviso {

    @Autowired
    private BibliotecarioRepository repository;

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

    @Scheduled(cron = "0 0 9 * * ?") // todo dia às 09:00
    public void enviarAvisosAutomaticos() {

        List<BibliotecarioModel> lista = repository.findAll();

        for (BibliotecarioModel b : lista) {
            enviarAvisoTrocaSenha(
                b.getDsEmail(),
                b.getNmBibliotecario()
            );
        }

        System.out.println("Envio automático executado.");
    }
}
