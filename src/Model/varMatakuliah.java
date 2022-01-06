/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Agung Ma'ruf
 */
public class varMatakuliah {
    private String vKodeMtk;
    private String vNamaMtk;
    private Integer vSks;

    public Integer getvSks() {
        return vSks;
    }

    public void setvSks(Integer vSks) {
        this.vSks = vSks;
    }
    private String vKodePrasyarat;

    public String getvKodePrasyarat() {
        return vKodePrasyarat;
    }

    public void setvKodePrasyarat(String vKodePrasyarat) {
        this.vKodePrasyarat = vKodePrasyarat;
    }

    public String getvKodeMtk() {
        return vKodeMtk;
    }

    public void setvKodeMtk(String vKodeMtk) {
        this.vKodeMtk = vKodeMtk;
    }

    public String getvNamaMtk() {
        return vNamaMtk;
    }

    public void setvNamaMtk(String vNamaMtk) {
        this.vNamaMtk = vNamaMtk;
    }

}
