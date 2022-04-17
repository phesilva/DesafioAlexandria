package br.projeto.alexandria.desafio.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TabelaControl {
    
    Connection conn;
    PreparedStatement pstm;
    String url = "jdbc:mysql://localhost:3306/bancodesafio?user=root&password=";
    
    public void executeSqlScript(String script) {
    File arq = new File(script);
    
    File inputFile = arq;
    // limitador
    String delimiter = ";";

    // Scanner criado 
    Scanner scanner;
    try {
        scanner = new Scanner(inputFile).useDelimiter(delimiter);
    } catch (FileNotFoundException erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage());
        return;
    }

    // Loop para executar o  SQL file statements 
    Statement currentStatement = null;
    while(scanner.hasNext()) {

        // string q recebe o comando
        String rawStatement = scanner.next() + delimiter;
        try {
            // executando o statement
            Connection conn = DriverManager.getConnection(url);
            currentStatement = conn.createStatement();
            currentStatement.execute(rawStatement);
            JOptionPane.showMessageDialog(null,"o comando SQL: "+rawStatement+" foi executada com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // limpando recursos
            if (currentStatement != null) {
                try {
                    currentStatement.close();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, erro.getMessage());
                }
            }
            currentStatement = null;
          }
        }
    	scanner.close();
    }
}
