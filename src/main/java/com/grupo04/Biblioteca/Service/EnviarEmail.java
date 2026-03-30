public void enviarAvisoTrocaSenha(String email) {
    // você pode reaproveitar seu método de envio aqui dentro
    enviarEmail(email, "Aviso de Segurança", 
        "Olá! Por segurança, recomendamos que você altere sua senha.");
}
