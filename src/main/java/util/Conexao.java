package com.br.senac.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/tecnica";

    private static final String USUARIO = "root";

    public static Connection conectar() throws SQLException {

        String senha = System.getenv("DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new SQLException(
                "Variável de ambiente DB_PASSWORD não configurada."
            );
        }

        return DriverManager.getConnection(
                URL, USUARIO, senha
        );
    }
}