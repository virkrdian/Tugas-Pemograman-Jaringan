




# Tugas-Pemograman-Jaringan
Ini adalah Tugas Pemograman Jaringan dari kelompok yang ber anggotakan Virki Fardian (362201022) , Raden Hasan (362201019), Muhammad Rahmadika (362201024).
dua program ini dibuat:
-Program UnblockingServer\Client :Virki Fardian Nur Rohman (362201022)
-Program BlockingServer\Client\ClintHandlr :Raden Hasan RR (362201019)
-Membuat kata-kata presentasi maupun yang ada di Github : Muhammad Rahmadika (362201024) dan Virki F N R (362201022)

Tentu, berikut adalah langkah-langkah umum untuk membuka program dari GitHub:

1. **Unduh dan Instal Git:**
   - Pastikan Git telah diinstal di komputer\Laptop Anda. Anda dapat mengunduhnya dari situs resmi Git dan mengikuti instruksi instalasinya.

2. **Dapatkan URL Repositori GitHub:**
   - Kunjungi halaman repositori GitHub yang berisi program yang ingin Anda unduh.
   - Klik tombol "Code" atau "Clone" dan salin URL repositori.

3. **Buka Terminal atau Command Prompt:**
   - Buka terminal atau command prompt di komputer Anda.

4. **Pilih Lokasi Penyimpanan:**
   - Pindah ke direktori atau lokasi di mana Anda ingin menyimpan program GitHub tersebut dengan menggunakan perintah `cd`.

     ```bash
     cd path/to/directory
     ```

5. **Klon Repositori:**
   - Gunakan perintah `git clone` untuk mengunduh repositori ke komputer Anda.

     ```bash
     git clone <URL Repositori GitHub>
     ```

   - Gantilah `<URL Repositori GitHub>` dengan URL yang telah Anda salin sebelumnya.

6. **Buka Proyek:**
   - Setelah proses pengunduhan selesai, pindah ke direktori repositori yang baru dibuat.

     ```bash
     cd nama-repositori
     ```

7. **Buka dengan IDE atau Editor Kode:**
   - Buka proyek menggunakan Integrated Development Environment (IDE) atau editor kode seperti IntelliJ IDEA, Eclipse, atau Visual Studio Code.

8. **Jalankan atau Modifikasi Program:**
   - Jika proyek memiliki instruksi khusus untuk konfigurasi atau instalasi dependensi, ikuti petunjuk tersebut.
   - Buka dan jalankan program sesuai dengan instruksi proyek.

Dengan mengikuti langkah-langkah ini, Anda seharusnya dapat mengunduh, membuka, dan menjalankan program yang ada di GitHub.




Program blocking merujuk pada kode atau aplikasi yang memiliki operasi atau bagian tertentu yang dapat menyebabkan proses atau thread yang menjalankannya untuk terhenti atau terblokir. Situasi ini dapat terjadi dalam berbagai konteks dalam pemrograman, terutama dalam lingkungan konkurensi atau saat menggunakan sumber daya eksternal.

Beberapa contoh situasi yang dapat mengakibatkan program menjadi terblokir atau melakukan operasi yang bersifat blocking adalah:

1. **I/O Blocking:**
   - Ketika program melakukan operasi input/output (I/O), seperti membaca dari disk atau menulis ke jaringan, seringkali operasi tersebut bersifat blocking. Misalnya, ketika menggunakan `InputStream` untuk membaca data dari file atau `Socket` untuk berkomunikasi dengan server, proses akan terhenti sementara atau terblokir hingga operasi I/O selesai.

2. **Synchronization Blocking:**
   - Pada lingkungan konkurensi atau multithreading, penggunaan mekanisme sinkronisasi seperti `synchronized` dalam Java atau penggunaan mutexes dapat menyebabkan blocking. Ketika satu thread mendapatkan akses terhadap sumber daya yang sedang dikunci, thread lain yang membutuhkan akses tersebut akan terblokir sampai sumber daya tersebut tersedia kembali.

3. **Operasi Jaringan Blocking:**
   - Saat melakukan operasi jaringan, seperti pengiriman atau penerimaan data melalui socket, jika tidak menggunakan mekanisme non-blocking atau asynchronous, operasi jaringan dapat menyebabkan program terblokir sementara hingga operasi tersebut selesai.

4. **Menunggu Input Pengguna:**
   - Dalam aplikasi yang berinteraksi dengan pengguna, seperti program dengan antarmuka grafis atau command-line interface, proses dapat terblokir saat menunggu input dari pengguna. Program akan berhenti dan menunggu hingga pengguna memberikan input.

Pada dasarnya, blocking merupakan situasi di mana suatu operasi atau proses menyebabkan eksekusi program terhenti sementara sampai operasi tersebut selesai atau kondisi tertentu terpenuhi. Blocking dapat mengganggu kinerja aplikasi terutama jika terjadi terlalu lama, sehingga pengembang sering mencari solusi non-blocking atau asynchronous untuk menghindari keadaan terblokir yang berlebihan dalam aplikasi.


Program yang bersifat "unblocking" atau non-blocking merujuk pada kode atau aplikasi yang dirancang agar operasi-operasi tertentu tidak menyebabkan proses atau thread yang menjalankannya menjadi terhenti atau terblokir. Pendekatan non-blocking atau unblocking biasanya digunakan untuk memastikan bahwa program tetap responsif dan dapat menjalankan beberapa operasi secara bersamaan tanpa harus menunggu operasi sebelumnya untuk selesai.

Beberapa pendekatan untuk membuat program menjadi non-blocking adalah:

1. **Asynchronous Programming:**
   - Dalam pemrograman asynchronous, operasi-operasi yang membutuhkan waktu lama (seperti operasi I/O atau permintaan jaringan) dieksekusi secara terpisah tanpa menghentikan jalannya program. Contoh implementasi dalam bahasa Java adalah dengan menggunakan `CompletableFuture`, `Future`, atau `Callback`.

2. **Event-driven Architecture:**
   - Dalam arsitektur event-driven, program bereaksi terhadap peristiwa-peristiwa (events) yang terjadi, seperti input pengguna atau notifikasi dari sistem. Hal ini memungkinkan program untuk terus berjalan tanpa terblokir saat menunggu input.

3. **Non-blocking I/O:**
   - Beberapa bahasa pemrograman dan lingkungan runtime menyediakan mekanisme non-blocking I/O, yang memungkinkan program untuk melakukan operasi I/O tanpa harus menunggu hingga operasi selesai. Dalam Java, `java.nio` menyediakan Channel dan Selector yang mendukung I/O non-blocking.

4. **Threading dan Concurrency:**
   - Dalam penggunaan thread dan konkurensi, pendekatan non-blocking dapat dicapai dengan menggunakan mekanisme seperti `Lock-Free Algorithms` atau `Concurrent Data Structures`. Ini memungkinkan beberapa thread untuk mengakses sumber daya bersama tanpa harus saling menghentikan atau terblokir.

5. **Penggunaan Timeout:**
   - Memasukkan timeout ke dalam operasi-operasi yang berpotensi memakan waktu lama bisa menjadi cara untuk mencegah program dari terblokir terlalu lama. Jika operasi tidak selesai dalam batas waktu tertentu, program dapat melanjutkan dengan tindakan alternatif.

Memilih pendekatan yang tepat untuk membuat program menjadi non-blocking tergantung pada kebutuhan dan konteks pengembangan aplikasi. Saat merancang aplikasi, mengidentifikasi titik-titik yang berpotensi menyebabkan blokade dan mencari solusi non-blocking yang sesuai dapat membantu meningkatkan responsivitas dan kinerja keseluruhan aplikasi.

Terdapat perbedaan utama antara program yang bersifat "blocking" (terblokir) dan "non-blocking" (tidak terblokir) dalam konteks eksekusi operasi tertentu:

1. **Blocking (Terblokir):**
   - **Sifat Operasi:** Operasi-operasi dalam program blocking dapat menyebabkan proses atau thread yang menjalankannya terhenti atau terblokir. Artinya, operasi yang memerlukan waktu, seperti membaca dari disk atau menunggu respons dari jaringan, akan membuat thread tersebut berhenti sampai operasi selesai.
   - **Sifat Responsif:** Program blocking akan terhenti dalam menjalankan operasi-operasi yang memerlukan waktu lama, sehingga dapat menghambat responsivitas program terhadap interaksi pengguna atau terhadap tugas lain yang perlu segera diselesaikan.

2. **Non-blocking (Tidak Terblokir):**
   - **Sifat Operasi:** Operasi-operasi dalam program non-blocking dirancang agar tidak membuat proses atau thread terhenti. Hal ini memungkinkan program untuk menjalankan operasi-operasi lain tanpa harus menunggu operasi yang memerlukan waktu lama untuk selesai.
   - **Sifat Responsif:** Program non-blocking dapat tetap responsif terhadap tindakan atau input pengguna, serta dapat menjalankan beberapa tugas secara bersamaan tanpa harus menunggu operasi sebelumnya selesai.

Inti dari perbedaan antara kedua pendekatan ini adalah bagaimana program menangani operasi-operasi yang memerlukan waktu lama. Program blocking akan menghentikan eksekusi sampai operasi selesai, sementara program non-blocking akan memungkinkan program untuk melanjutkan eksekusi tanpa harus menunggu operasi selesai.

Pilihan antara kedua pendekatan ini bergantung pada kebutuhan aplikasi. Program yang memerlukan responsivitas tinggi atau interaksi yang cepat dengan pengguna biasanya memilih pendekatan non-blocking agar tidak menghambat jalannya program. Sementara aplikasi yang mengandalkan operasi-operasi tertentu yang membutuhkan waktu lama mungkin lebih cocok dengan pendekatan blocking, terutama jika menunggu hasil dari operasi tersebut sangat penting.
