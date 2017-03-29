package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by setiyawan on 3/29/17.
 */

public class DBAdapter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test_db";
    public static final String NAMA = "nama";
    public static final String KEY_ID = "_id";

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    // method createTable untuk membuat table WISATA
    public void createTable(SQLiteDatabase db) {
        //db.execSQL("DROP TABLE IF EXISTS WISATA");
        db.execSQL("CREATE TABLE if not exists Master_pengguna (_id INTEGER PRIMARY KEY,nama TEXT,alamat TEXT,username TEXT,password TEXT,email TEXT,no_hp TEXT,keterangan TEXT,jenis_pengguna TEXT);");
        db.execSQL("CREATE TABLE if not exists Master_produk (_id INTEGER PRIMARY KEY,nama_produk TEXT,kategori TEXT,spesifikasi TEXT,foto TEXT,persediaan TEXT,harga_satuan TEXT,subkategoriid TEXT,satuan TEXT,harga_grosir TEXT,satuan_grosir TEXT);");

    }


    public void daftar(SQLiteDatabase db,String id_pengguna,String nama,String alamat,String pengguna,String password,String email,String no_hp,String keterangan,String role){
        ContentValues cv = new ContentValues();
        cv.put("_id", id_pengguna);
        cv.put("nama", nama);
        cv.put("alamat", alamat);
        cv.put("username", pengguna);
        cv.put("password", password);
        cv.put("email", email);
        cv.put("no_hp", no_hp);
        cv.put("keterangan", keterangan);
        cv.put("jenis_pengguna", role);
        db.insert("Master_pengguna", "Master_pengguna", cv);
    }
    public void isiData(SQLiteDatabase db,String idProduct,String nama_produk,String kategori,String spesifikasi,String foto,String persediaan,String harga_satuan,String satuan,String harga_grosir,String satuan_grosir){
        ContentValues cv = new ContentValues();
        cv.put("_id", idProduct);
        cv.put("nama_produk", nama_produk);
        cv.put("kategori", kategori);
        cv.put("spesifikasi", spesifikasi);
        cv.put("foto", foto);
        cv.put("persediaan", persediaan);
        cv.put("harga_satuan", harga_satuan);
        cv.put("satuan", satuan);
        cv.put("harga_grosir", harga_grosir);
        cv.put("satuan_grosir", satuan_grosir);
        db.insert("Master_produk", "Master_produk", cv);
    }

    // method delAllAdata untuk menghapus data di table Wisata.
    public void delAllData(SQLiteDatabase db) {
        db.delete("Master_produk", null, null);
    }

    public void delPengerajin(SQLiteDatabase db) {
        db.delete("Master_pengguna", null, null);
//        db.execSQL("CREATE TABLE if not exists spk (_id INTEGER PRIMARY KEY,tanggal TEXT,id_pengguna TEXT,id_pesanan TEXT,jumlah_pesanan TEXT,tanggal_selesai TEXT,tanggal_update TEXT,jumlah_bayar TEXT,keterangan TEXT);");
    }
    public Cursor fetchAllWisata(SQLiteDatabase db) {
        return db.query("WISATA", new String[] { KEY_ID, NAMA }, null, null,
                null, null, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
        Log.e("Database Log","Database Dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}
