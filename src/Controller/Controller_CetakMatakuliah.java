package Controller;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Agung Ma'ruf;
 */
public class Controller_CetakMatakuliah {
    public void cetak(){
//    Menyimpan file ke excel
        try {
            Connection conn = Koneksi.Database.KoneksiDB();
            String path = "src/Report/report_matakuliah.jasper";
            File xlsx = new File("D:/report_matakuliah.xlsx");
            JasperPrint print = JasperFillManager.fillReport(path, null, conn);

            JRXlsxExporter xlsxExporter = new JRXlsxExporter();
            xlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            xlsxExporter.setParameter(JRExporterParameter.OUTPUT_FILE, xlsx);
            xlsxExporter.exportReport();

            JOptionPane.showMessageDialog(null, "Cek file pada drive D:/Report-Matakuliah.xlsx");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dicetak!!" + ex.getMessage(),
                    "Cetak Data", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void review(){
        try {
            HashMap parameter = new HashMap();
            java.sql.Connection cn = Koneksi.Database.KoneksiDB();
            File file = new File("src/Report/report_matakuliah.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, cn);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Data Tidak Dapat di Cetak !!!" + "\n" + e.getMessage(), "Cetak Data",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
