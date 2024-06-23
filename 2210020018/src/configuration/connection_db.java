/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement; //coding crud
import java.sql.ResultSet;
/**
 *
 * @author 
 */
public class connection_db {
    private String databaseName = "2210020018";
    private String username = "root";
    private String password = "";
    
    public static Connection koneksi;
    
    public connection_db(){
    
        try {
            String url = "jdbc:mysql://localhost/"+this.databaseName;
            koneksi = DriverManager.getConnection(url,this.username,this.password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
    
    public void simpanDataKeluarga(String id_keluarga, String no_ktp){
        try {
            String sql = "INSERT INTO dat_keluarga (id_keluarga, no_ktp) value(?,?)";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_keluarga);
            perintah.setString(2, no_ktp);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahDataKeluarga(String id_keluarga, String no_ktp){
        try {
            String sql = "UPDATE dat_keluarga  SET  no_ktp=? WHERE id_keluarga=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, no_ktp);
            perintah.setString(2, id_keluarga);
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusDataKeluarga(String id_keluarga ){
        try {
            String sql = "DELETE FROM dat_keluarga WHERE id_keluarga=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_keluarga);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariDataKeluarga(String id_keluarga) {
        try {
            String sql ="SELECT * FROM dat_keluarga WHERE id_keluarga=? ";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1,id_keluarga);
            ResultSet data=perintah.executeQuery();
            while(data.next()) {
                System.out.println(data.getString("no_ktp"));
                System.out.println(data.getString("id_keluarga"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanMutasi(String id_mutasi, String id_warga, String tgl_lahir, String jenis_mutasi, String tanggal, String keterangan){
        try {
            String sql = "INSERT INTO mutasi_warga (id_mutasi, id_warga, tgl_lahir, jenis_mutasi, tanggal, keterangan) value(?,?,?,?,?,?)";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_mutasi);
            perintah.setString(2, id_warga);
            perintah.setString(3, tgl_lahir);
            perintah.setString(4, jenis_mutasi);
            perintah.setString(5, tanggal);
            perintah.setString(6, keterangan);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahMutasi(String id_mutasi, String id_warga, String tgl_lahir, String jenis_mutasi, String tanggal, String keterangan){
        try {
            String sql = "UPDATE mutasi_warga SET id_warga=?, tgl_lahir=?, jenis_mutasi=?, tanggal=?, keterangan=?  WHERE id_mutasi=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_warga);
            perintah.setString(2, tgl_lahir);
            perintah.setString(3, jenis_mutasi);
            perintah.setString(4, tanggal);
            perintah.setString(5, keterangan);
            perintah.setString(6, id_mutasi);
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusMutasi(String id_mutasi ){
        try {
            String sql = "DELETE FROM mutasi_warga WHERE id_mutasi=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_mutasi );
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariMutasi(String id_mutasi ) {
        try {
            String sql ="SELECT * FROM mutasi_warga WHERE id_mutasi=? ";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1,id_mutasi);
            ResultSet data=perintah.executeQuery();
            while(data.next()) {
                System.out.println(data.getString("tgl_lahir"));
                System.out.println(data.getString("jenis_mutasi"));
                System.out.println(data.getString("tanggal"));
                System.out.println(data.getString("keterangan"));
                System.out.println(data.getString("alamat"));
                System.out.println(data.getString("id_mutasi"));
                System.out.println(data.getString("id_warga"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanSurat(String id_surat, String jenis_surat, String no_surat, String nama_surat, String tanggal, String isi_surat, String tanda_tangan, String id_warga, String nama_warga){
        try {
            String sql = "INSERT INTO surat (id_surat, jenis_surat, no_surat, nama_surat, tanggal, isi_surat, tanda_tangan, id_warga, nama_warga) value(?,?,?,?,?,?,?,?,?)";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_surat);
            perintah.setString(2, jenis_surat);
            perintah.setString(3, no_surat);
            perintah.setString(4, nama_surat);
            perintah.setString(5, tanggal);
            perintah.setString(6, isi_surat);
            perintah.setString(7, tanda_tangan);
            perintah.setString(8, id_warga);
            perintah.setString(9, nama_warga);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        public void ubahSurat(String id_surat, String jenis_surat, String no_surat, String nama_surat, String tanggal, String isi_surat, String tanda_tangan, String id_warga, String nama_warga){
        try {
            String sql = "UPDATE surat  SET jenis_surat=?, id_warga=?, no_surat=?, nama_surat=?, tanggal=?, isi_surat=?, tanda_tangan=?, nama_warga=? WHERE id_surat=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, jenis_surat);
            perintah.setString(2, no_surat);
            perintah.setString(3, nama_surat);
            perintah.setString(4, tanggal);
            perintah.setString(5, isi_surat);
            perintah.setString(6, tanda_tangan);
            perintah.setString(7, id_warga);
            perintah.setString(8, nama_warga);
            perintah.setString(9, id_surat);
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        
    public void hapusSurat(String id_surat ){
        try {
            String sql = "DELETE FROM surat WHERE id_surat=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_surat);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariSurat(String id_surat) {
        try {
            String sql ="SELECT * FROM surat WHERE id_surat=? ";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1,id_surat);
            ResultSet data=perintah.executeQuery();
            while(data.next()) {
                System.out.println(data.getString("jenis_surat"));
                System.out.println(data.getString("nama_surat"));
                System.out.println(data.getString("no_surat"));
                System.out.println(data.getString("tanggal"));
                System.out.println(data.getString("isi_surat"));
                System.out.println(data.getString("tanda_tangan"));
                System.out.println(data.getString("nama_warga"));
                System.out.println(data.getString("id_warga"));
                System.out.println(data.getString("id_surat"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanWarga(String no_ktp, String id_keluarga, String nama, String t_lahir, String tgl_lahir, String j_kel, String gol_darah, String w_negara, String pendidikan, String pekerjaan, String s_nikah, String status){
        try {
            String sql = "INSERT INTO warga (no_ktp, id_keluarga, nama, t_lahir, tgl_lahir, j_kel, gol_darah, w_negara, pendidikan, pekerjaan, s_nikah, status) value(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, no_ktp);
            perintah.setString(2, id_keluarga);
            perintah.setString(3, nama);
            perintah.setString(4, t_lahir);
            perintah.setString(5, tgl_lahir);
            perintah.setString(6, j_kel);
            perintah.setString(7, gol_darah);
            perintah.setString(8, w_negara);
            perintah.setString(9, pendidikan);
            perintah.setString(10, pekerjaan);
            perintah.setString(11, s_nikah);
            perintah.setString(12, status);
            perintah.executeUpdate();
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahWarga(String no_ktp, String id_keluarga, String nama, String t_lahir, String tgl_lahir, String j_kel, String gol_darah, String w_negara, String pendidikan, String pekerjaan, String s_nikah, String status){
        try {
            String sql = "UPDATE warga  SET id_keluarga=?, nama=?, t_lahir=?, tgl_lahir=?, j_kel=?, gol_darah=?, w_negara=?, pendidikan=?, pekerjaan=?, s_nikah=?, status=? WHERE no_ktp=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, id_keluarga);
            perintah.setString(2, nama);
            perintah.setString(3, t_lahir);
            perintah.setString(4, tgl_lahir);
            perintah.setString(5, j_kel);
            perintah.setString(6, gol_darah);
            perintah.setString(7, w_negara);
            perintah.setString(8, pendidikan);
            perintah.setString(9, pekerjaan);
            perintah.setString(10, s_nikah);
            perintah.setString(11, status);
            perintah.setString(12, no_ktp);
            perintah.executeUpdate();
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
    
    public void hapusWarga(String no_ktp ){
        try {
            String sql = "DELETE FROM warga WHERE no_ktp=?";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1, no_ktp);
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariWarga(String no_ktp) {
        try {
            String sql ="SELECT * FROM warga WHERE no_ktp=? ";
            PreparedStatement perintah = koneksi.prepareStatement(sql);
            perintah.setString(1,no_ktp);
            ResultSet data=perintah.executeQuery();
            while(data.next()) {
                System.out.println(data.getString("no_ktp"));
                System.out.println(data.getString("nama"));
                System.out.println(data.getString("t_lahir"));
                System.out.println(data.getString("tgl_lahir"));
                System.out.println(data.getString("j_kel"));
                System.out.println(data.getString("gol_darah"));
                System.out.println(data.getString("w_negara"));
                System.out.println(data.getString("pendidikan"));
                System.out.println(data.getString("pekerjaan"));
                System.out.println(data.getString("s_nikah"));
                System.out.println(data.getString("status"));
                System.out.println(data.getString("id_keluarga"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
