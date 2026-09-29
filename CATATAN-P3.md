# CATATAN-P3.md — Tugas Analisis Skema

### 8. Analisis Relasi @OneToMany
* **Nama Entity:** Kelas `Prodi` (atau `Kategori` pada modul pengumuman).
* **Sisi Pemilik Relasi:** Sisi pemilik relasi (*owning side*) adalah sisi "Banyak" (Many), yaitu entitas `Kurikulum` (atau `Pengumuman`), karena sisi tersebut yang secara fisik menyimpan kolom kunci asing (*foreign key*) melalui anotasi `@JoinColumn(name = "id_prodi")`. Kelas `Prodi` bertindak sebagai sisi bukan pemilik (inversi) yang ditandai dengan parameter `mappedBy = "prodi"`.
* **Deklarasi Fetch:** Sudah dinyatakan secara eksplisit dengan nilai `fetch = FetchType.LAZY` untuk mencegah pemuatan data relasi secara berlebihan (*eager loading*) ke memori.

---

### 9. Analisis columnDefinition
* **Nama Entity & Nilai:** Ditemukan pada entitas `Pengumuman` (atau kasus kode basis lama PSDKU) yang mendefinisikan `@Column(columnDefinition = "TEXT", nullable = false)`.
* **Portabilitas Nilai:** Nilai `"TEXT"` portabel untuk basis data modern seperti PostgreSQL dan MySQL. Namun, jika menggunakan definisi spesifik dialek tertentu seperti `"SMALLINT UNSIGNED"` (bawaan dialek MySQL), nilainya **tidak portabel**. Ketika basis data dialihkan ke PostgreSQL, eksekusi DDL akan gagal dengan galat `ERROR: syntax error at or near "UNSIGNED"` karena PostgreSQL tidak mendukung kata kunci `UNSIGNED`. Disarankan menggunakan atribut JPA standar seperti `length`, `nullable`, `precision`, dan `scale`.

---

### 10. Tiga Risiko ddl-auto=update dan Langkah Awal Pengenalan Flyway
* **Tiga Risiko Konkret `ddl-auto=update` di Lingkungan Produksi:**
  1. **Hanya Menambah, Tidak Pernah Mengurangi:** Tabel atau kolom usang yang sudah dihapus dari kode Java tidak akan dihapus dari basis data, menyebabkan penumpukan kolom sampah. Perubahan nama field juga berisiko membuat kolom baru dan menduplikasi struktur data.
  2. **Gagal Secara Diam-Diam (*Silent Failure*):** Galat DDL (seperti kesalahan tipe data atau sintaks dialek) hanya dicatat sebagai peringatan (*WARN*) di berkas log. Maven dan aplikasi tetap melaporkan start sukses, sehingga kegagalan struktur baru disadari ketika pengguna mengakses fitur terkait di produksi.
  3. **Ketiadaan Riwayat dan Mekanisme *Rollback*:** Tidak ada jejak audit atau log historis mengenai siapa yang mengubah skema dan kapan perubahan tersebut dieksekusi, serta tidak ada prosedur otomatis untuk mengembalikan (*rollback*) kondisi skema ke versi stabil sebelumnya.

* **Langkah Pertama Memperkenalkan Flyway Tanpa Merusak Data yang Sudah Ada:**
  Menggunakan mekanisme **Baseline Flyway** pada berkas konfigurasi (`application.properties` / `application-dev.properties`):
  ```properties
  spring.flyway.baseline-on-migrate=true
  spring.flyway.baseline-version=1
  spring.flyway.baseline-description=skema awal website PSDKU