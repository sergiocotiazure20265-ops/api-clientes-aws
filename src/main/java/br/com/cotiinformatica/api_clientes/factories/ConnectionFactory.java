package br.com.cotiinformatica.api_clientes.factories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionFactory {

    @Value("${database.host}")
    private String host;

    @Value("${database.user}")
    private String user;

    @Value("${database.pass}")
    private String pass;

    /*
        Método para retornar a conexão com o banco de dados
     */
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(host, user, pass);
    }
}
