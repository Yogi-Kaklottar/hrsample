package com.axelor.app.service;

import com.axelor.data.Importer;
import com.axelor.data.csv.CSVImporter;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class Studentimportcsv {

  public void studImport(ActionRequest request, ActionResponse response) throws IOException {
    File configdata = getfileconfig();
    Importer importer = new CSVImporter(configdata.getAbsolutePath(), getDataCsvFile());
    importer.run();
  }

  public File getfileconfig() throws IOException {
    File config = File.createTempFile("stud-csv", "xml");
    InputStream inputStream = this.getClass().getResourceAsStream("/data-demo/input-config3.xml");
    FileOutputStream outputStream = new FileOutputStream(config);
    IOUtils.copy(inputStream, outputStream);
    return config;
  }

  public String getDataCsvFile() throws IOException {
    URL url = this.getClass().getResource("/data-demo/input/");
    return url.getPath();
  }
}
