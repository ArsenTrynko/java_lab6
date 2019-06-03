package ua.lviv.iot.WaterTransport.managers;

import ua.lviv.iot.WaterTransport.models.WaterTransport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class WaterTransportWriter {

    private String filePath;

    WaterTransportWriter() {
    }

    WaterTransportWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<WaterTransport> WaterTransport) {
        File csvFile = new File(filePath + ".csv");

        try (FileOutputStream fos = new FileOutputStream(csvFile);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)
        ) {
            for (WaterTransport WaterTransport : WaterTransport) {
                writer.write(WaterTransport.getHeaders());
                writer.newLine();
                writer.write(WaterTransport.toCSV());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Writing to the file ended");
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
