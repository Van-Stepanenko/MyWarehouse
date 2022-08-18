package dev.stepanenko.my.warehouse.domain;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InMemoryInvoiceService implements InvoiceService{
    String pathToInvoice = "C:\\Users\\Ivan\\IdeaProjects\\MyWarehouse\\src\\main\\java\\dev\\stepanenko\\my\\warehouse\\invoice\\";
    private static final String NEW_LINE = System.lineSeparator();
    @SneakyThrows
    @Override
    public void createInvoice(String nameInvoice) {

        FileWriter fw = new FileWriter(pathToInvoice + nameInvoice +".txt");

        fw.close();
    }

    @Override
    public void deleteInvoice(String nameInvoice) {

        File file = new File(pathToInvoice +nameInvoice + ".txt");
        file.delete();
    }

    @Override
    public void putInvoice(String nameInvoice, String newName) {
        File fileOld = new File(pathToInvoice + nameInvoice + ".txt");
        File fileNew = new File(pathToInvoice + newName + ".txt");
        fileOld.renameTo(fileNew);
    }

    @Override
    public void addANoteToInvoice(String nameInvoice, String goodInfo) throws IOException { // в  nameInvoice входит тип операции(покупка, продажа и т.д. и имя склада
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatterData = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy ");
        String dataTime = formatterData.format(calendar.getTime());
        String time = formatterTime.format(calendar.getTime());
        Path path1 = Paths.get(pathToInvoice + nameInvoice + dataTime+".txt");
        appendToFile(path1, goodInfo +"  Время операции: "+time+ NEW_LINE);

    }
    private static void appendToFile(Path path1, String content) throws IOException {

        Files.write(path1, content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }




}



