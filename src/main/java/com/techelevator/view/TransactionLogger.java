package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionLogger {
    private String logPath = "Log.txt";
    private File logFile = new File(logPath);
    private String logMessage = "%s %s $%.2f $%.2f";

    public TransactionLogger() {
    }

    public void log(String productName, double spent, double currentBalance) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String strDate = dateFormat.format(date);
        String line = String.format(logMessage, strDate, productName, spent, currentBalance);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            writer.append(line + System.lineSeparator());
        } catch (Exception e) {

        }
    }
}