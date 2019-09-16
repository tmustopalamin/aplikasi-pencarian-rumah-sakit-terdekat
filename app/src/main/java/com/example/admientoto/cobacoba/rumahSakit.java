package com.example.admientoto.cobacoba;


public class rumahSakit {

    private String imageRS,namaRs,ketRS,noTelp,alamatRS;
    private Double latTujuan,lonTujuan;

    public String getImageRS() {
        return imageRS;
    }

    public String getNamaRs() {
        return namaRs;
    }

    public String getKetRS() {
        return ketRS;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getAlamatRS() {
        return alamatRS;
    }

    public Double getlatTujuan(){return latTujuan;}

    public Double getlonTujuan(){return lonTujuan;}

    public void setAmbilLagi(String a){
        if (a == "RS. BAYUKARTA"){
            setDataRs(1);
        }

        if (a == "RS. CITRA SARI INTAN BAROKAH"){
            setDataRs(2);
        }

        if (a == "RS. DELIMA ASIH"){
            setDataRs(3);
        }

        if (a == "RS. DEWI SRI"){
            setDataRs(4);
        }

        if (a == "RS. FIKRI MEDIKA"){
            setDataRs(5);
        }

        if (a == "RS. ISLAM"){
            setDataRs(6);
        }

        if (a == "RS. IZZA"){
            setDataRs(7);
        }

        if (a == "RS. KARYA HUSADA"){
            setDataRs(8);
        }

        if (a == "RS. LIRA MEDIKA"){
            setDataRs(9);
        }

        if (a == "RS. MANDAYA"){
            setDataRs(10);
        }
//
        if (a == "RS. PROKLAMASI"){
            setDataRs(11);
        }
//
        if (a == "RS. PURI ASIH"){
            setDataRs(12);
        }
//
        if (a == "RS. ROSELA"){
            setDataRs(13);
        }
//
        if (a == "RS. SARASWATI"){
            setDataRs(14);
        }
//
        if (a == "RS. PERSADA MEDIKA"){
            setDataRs(15);
        }
//
        if (a == "RSUD. KARAWANG"){
            setDataRs(16);
        }

    }

    public void setDataRs(int a){
        if(a == 1){
           setDataRS("RS. BAYUKARTA");
        }

        if(a == 2){
            setDataRS("RS. CITRA SARI INTAN BAROKAH");
        }

        if(a == 3){
            setDataRS("RS. DELIMA ASIH");
        }

        if(a == 4){
            setDataRS("RS. DEWI SRI");
        }

        if(a == 5){
            setDataRS("RS. FIKRI MEDIKA");
        }

        if(a == 6){
            setDataRS("RS. ISLAM");
        }

        if(a == 7){
            setDataRS("RS. IZZA");
        }

        if(a == 8){
            setDataRS("RS. KARYA HUSADA");
        }

        if(a == 9){
            setDataRS("RS. LIRA MEDIKA");
        }

        if(a == 10){
            setDataRS("RS. MANDAYA");
        }

        if(a == 11){
            setDataRS("RS. PROKLAMASI");
        }

        if(a == 12){
            setDataRS("RS. PURI ASIH");
        }

        if(a == 13){
            setDataRS("RS. ROSELA");
        }

        if(a == 14){
            setDataRS("RS. SARASWATI");
        }

        if(a == 15){
            setDataRS("RS. PERSADA MEDIKA");
        }

        if(a == 16){
            setDataRS("RSUD. KARAWANG");
        }
    }

    public void setDataRS(String b) {
        if(b.equals("RS. BAYUKARTA")){
            imageRS = "bayukarta";
            namaRs = "RS. BAYUKARTA";
            ketRS = "Rumah sakit Bayukarta merupakan salah satu rumah sakit terbesar di kota Karawang. Rumah sakit ini memberikan pelayanan kesehatan yang didukung oleh sumber daya manusia yang profesional serta memenuhi standar pelayanan yang ditetapkan oleh pemerintah dan sesuai dengan kebutuhan dan harapan masyarakat.";
            noTelp = "0267401817";
            alamatRS = "Jl. Kertabumi No. 44,Karawang Jawa Barat - Indonesia";
            latTujuan =-6.303647;
            lonTujuan =107.292155;
        }

        if(b.equals("RS. CITRA SARI INTAN BAROKAH")){
            imageRS = "rscsib";
            namaRs = "RS. CITRA SARI INTAN BAROKAH";
            ketRS = "Rumah Sakit Citra Sari Husada Intan Barokah Group berada di Kabupaten Karawang tepatnya di Jalan Raya Kosambi - Telagasari KM. 3 Klari Karawang. Didirikan pada tanggal 19 Januari 2009 oleh Drs. H. Hasan Permana. Kami senantiasa berusaha memberikan pelayanan terbaik dengan tenaga-tenaga professional guna membantu pemerintah dalam menciptakan masyarakat yang sehat.";
            noTelp = "081298411971";
            alamatRS = "Jl. Raya Kosambi - Telagasari KM. 3 Klari Karawang 41371 Jawa Barat";
            latTujuan =-6.349775;
            lonTujuan =107.377613;
        }

        if(b.equals("RS. DELIMA ASIH")){
            imageRS = "rsdelimaasih";
            namaRs = "RS. DELIMA ASIH";
            ketRS = "Rumah Sakit Delima Asih Sisma Medika saat berbentuk rumah bersalin didirikan dengan akta notaris pendirian PT. Delima Abdi Sehati No. 30 TGl 11 Agustus 2003 dan kemudian dengan perubahan manajemen yang dibawah sismadi grup, maka Rumah Sakit Delima Asih Sisma Medika berubah menjadi sebuah rumah sakit umum dengan akte pendiriannya menjadi PT. Delima Sisma Medika No. 35 tanggal 31 Juli 2007";
            noTelp = "02678454373";
            alamatRS = "Jl. Raya Kosambi - Telagasari KM. 3 Klari Karawang 41371 Jawa Barat";
            latTujuan =-6.314937 ;
            lonTujuan =107.316373;
        }

        if(b.equals("RS. DEWI SRI")){
            imageRS = "rsdewisri";
            namaRs = "RS. DEWI SRI";
            ketRS = "Rumah Sakit Dewi Sri berada di bawah naungan PT. Dewi Sri Piranti Syifa Persada. Sebelum resmi menjadi sebuah rumah sakit, Rumah Sakit Dewi Sri mengalami perjalanan yang cukup panjang. Dimulai dengan praktek dokter umum oleh pemiliknya pada tahun 1978. Pendiri sekaligus Pemilik RS.Dewi Sri adalah dr. Yunanto Sam’un Bashor, beliau dilahirkan di Karawang tanggal 7 maret 1945 dan merupakan alumni Fakultas Kedokteran Universitas Indonesia yang lulus tahun 1973. Pernah menjabat sebagai Kepala Kantor Departemen kesehatan Kabupaten Karawang dan Kepala Ikatan Dokter IndonesiaKabupaten Karawang.\\n \\n Dasar spirit beliau dalam mendirikan Rumah Sakit adalah Pertama, agar dapat mengobati adik dan keluarga, Kedua, “orang lain bisa, aku juga harus bisa” serta Ketiga, dasar keimanan mendapatkan hasil jerih payah yang halal dihadapan Allah SWT.\\n \\nBerdirinya Rumah Sakit Dewi Sri juga berkat adanya networking yang luas dari pemilik, kepercayaan dari masyarakat dan teman sejawat serta berkompeten dalam memimpin rumah sakit ini.";
            noTelp = "0267402855";
            alamatRS = "Jl. Arief Rachman Hakim No. 1A Karawang, Karawang Jawa Barat, Indonesia.";
            latTujuan =-6.304424;
            lonTujuan =107.297835;
        }

        if(b.equals("RS. FIKRI MEDIKA")){
            imageRS = "rsfikrimedika";
            namaRs = "RS. FIKRI MEDIKA";
            ketRS = "Rumah Sakit Fikri Medika yakni salah satu Rumah Sakit milik Perusahaan Karawang yang berbentuk RSU, dikelola oleh PT. Karya Mandiri Me dan tercatat kedalam Rumah Sakit Tipe C. Rumah Sakit ini telah terdaftar mulai 30/07/2012 dengan Nomor Surat ijin 503/sk.7025-ppi/2013 dan Tanggal Surat ijin 24/12/2013 dari Dinkes Karawang dengan Sifat Tetap, dan berlaku sampai 5 tahun. Sehabis melakukan Metode AKREDITASI RS Seluruh Indonesia dengan proses Pentahapan I ( 5 Pelayanan) akhirnya ditetapkan status Lulus Akreditasi Rumah Sakit. RSU ini berlokasi di Jl.Raya Kosambi-Telagasari KM 03 KLARI, Karawang, Indonesia.";
            noTelp = "02678615555";
            alamatRS = "Jl.Raya Kosambi-Telagasari KM 03 KLARI, Karawang, Indonesia.";
            latTujuan = -6.352003;
            lonTujuan = 107.378086;
        }

        if(b.equals("RS. ISLAM")){
            imageRS = "rsislamkarawang";
            namaRs = "RS. ISLAM KARAWANG";
            ketRS = "Rumah Sakit Islam Karawang (RSIK) di kelola oleh yayasan singaperbangsa Karawang berdasarkan Akta Notaris Khadijah Syahbudi Saleh, SH. No. 14, 20 Mei 1999. Kemudian RS. Islam Karawang diresmikan pada tanggal 14 september 1999.";
            noTelp = "0267414520";
            alamatRS = "Jalan Pangkal Perjuangan KM 2 (By pass) Karawang – Jawa Barat.";
            latTujuan = -6.281446;
            lonTujuan = 107.283270;
        }

        if(b.equals("RS. IZZA")){
            imageRS = "rsizza";
            namaRs = "RS. IZZA";
            ketRS = "RS IZZA yakni satu dari sekian Layanan Kesehatan milik Swasta/Lainnya Karawang yang bermodel RSU, dinaungi oleh Lainnya Perusahaan dan termuat kedalam Rumah Sakit Kelas C. Layanan Kesehatan ini telah terdaftar semenjak 27/12/2013 dengan Nomor Surat Izin 503/SK.2176-PPI/2013 dan Tanggal Surat Izin 15/05/2013 dari Dinkes Karawang dengan Sifat Perpanjang, dan berlaku sampai 15/05/2013 s.d 15/05/2018. Sehabis melaksanakan Proses AKREDITASI Rumah sakit Seluruh Indonesia dengan proses Pentahapan I ( 5 Pelayanan) akhirnya ditetapkan status Akreditasi Rumah Sakit. RSU ini beralamat di Jl. Raya Ciselang Cikampek Utara, Kotabaru Kab.Karawang, Karawang, Indonesia.";
            noTelp = "0264319307";
            alamatRS = "Jl. Raya Ciselang Cikampek Utara Kec. Kota Baru Kab. Karawang.";
            latTujuan = -6.389758;
            lonTujuan = 107.466499;
        }

        if(b.equals("RS. KARYA HUSADA")){
            imageRS = "rskaryahusada";
            namaRs = "RS. KARYA HUSADA";
            ketRS = "RS IZZA yakni satu dari sekian Layanan Kesehatan milik Swasta/Lainnya Karawang yang bermodel RSU, dinaungi oleh Lainnya Perusahaan dan termuat kedalam Rumah Sakit Kelas C. Layanan Kesehatan ini telah terdaftar semenjak 27/12/2013 dengan Nomor Surat Izin 503/SK.2176-PPI/2013 dan Tanggal Surat Izin 15/05/2013 dari Dinkes Karawang dengan Sifat Perpanjang, dan berlaku sampai 15/05/2013 s.d 15/05/2018. Sehabis melaksanakan Proses AKREDITASI Rumah sakit Seluruh Indonesia dengan proses Pentahapan I ( 5 Pelayanan) akhirnya ditetapkan status Akreditasi Rumah Sakit. RSU ini beralamat di Jl. Raya Ciselang Cikampek Utara, Kotabaru Kab.Karawang, Karawang, Indonesia.";
            noTelp = "0264319307";
            alamatRS = "Jl. Raya Ciselang Cikampek Utara Kec. Kota Baru Kab. Karawang.";
            latTujuan = -6.401041;
            lonTujuan = 107.443574;
        }

        if(b.equals("RS. LIRA MEDIKA")){
            imageRS = "rslira";
            namaRs = "RS. LIRA MEDIKA";
            ketRS = "Rumah Sakit Lira Medika mengutamakan keselamatan pasien dan mutu pelayanan yang didukung dengan fasilitas lengkap dan modern serta tenaga medis yang profesional dibidangnya. RS Lira Medika beroperasi sejak 5 Juni 2014 dan berada di atas tanah seluas ± 2 Hektar. Berlokasi di Jalan Syech Quro No 14 Lamaran, Karawang, Jawa Barat.";
            noTelp = "02678450222";
            alamatRS = "Jl. Syech Quro No.14 Lamaran Karawang - Jawa Barat 41314, Indonesia.";
            latTujuan = -6.302340;
            lonTujuan = 107.326700;
        }

        if(b.equals("RS. MANDAYA")){
            imageRS = "rsmandaya";
            namaRs = "RS. MANDAYA";
            ketRS = "Semangat untuk penyembuhan – Slogan ini merangkum apa yang ada di hati kami dalam melaksanakan pekerjaan sehari-hari: menggabungkan pengobatan berkualitas tinggi dengan perawatan pribadi. Ini adalah alasan mengapa para pasien telah mempercayakan harta yang paling berharga kepada kami – kesehatan mereka. Tinggal di rumah sakit kami serasa tinggal di hotel, dan kami percaya bahwa lingkungan seperti ini akan lebih membantu mempercepat penyembuhan.";
            noTelp = "02678643000";
            alamatRS = "Jalan Arteri Tol Karawang Barat, Teluk Jambe Karawang – Jawa Barat.";
            latTujuan = -6.304911;
            lonTujuan = 107.277907;
        }

        if(b.equals("RS. PROKLAMASI")){
            imageRS = "rsproklamasi";
            namaRs = "RS. PROKLAMASI";
            ketRS = "RS Proklamasi ialah satu dari sekian RS milik Swasta/Lainnya Karawang yang berbentuk RSU, diurus oleh  Lainnya  Perusahaan dan tergolong kedalam RS Tipe C. RS ini telah teregistrasi sedari  23/12/2013 dengan Nomor Surat Izin  HK.07.06/III/595/07 dan Tanggal Surat Izin  27/08/2007 dari  DEPKES RI dengan Sifat  Perpanjang, dan berlaku sampai   5. Sesudah melakukan Proses AKREDITASI Rumah sakit Seluruh Indonesia dengan proses  Pentahapan I ( 5 Pelayanan) akhirnya ditetapkan status  Lulus Akreditasi Rumah Sakit. RSU ini bertempat di Jl. Raya Proklamasi KM.2 Rengasdengklok, Karawang, Karawang, Indonesia.";
            noTelp = "0267482192";
            alamatRS = "Jl. Raya Proklamasi KM.2 Rengasdengklok, Karawang.";
            latTujuan = -6.170436;
            lonTujuan = 107.297514;
        }

        if(b.equals("RS. PURI ASIH")){
            imageRS = "rspuri";
            namaRs = "RS. PURI ASIH";
            ketRS = "Rumah Sakit Puri Asih – Jatisari yang berdiri pada tanggal 15 November 2010, bersamaan dengan terbitnya Ijin Menyelenggarakan RS Puri Asih Jatisari - Karawang, terletak di Desa Mekarsari, Kecamatan Jatisari, Kabupaten Karawang.\\n \\nRS Puri Asih berawal dari praktek pribadi dr.H.Akhid, M.Kes AIFO sejak tahun 1997. Dari praktek pribadi tersebut terus berkembang dan pada Tanggal 15 Agustus 2000 berdirilah Klinik dan Apotek Puri Asih, yang selanjutnya pada Thn. 2006 dikembangkan lagi menjadi BP DTP Klinik Puri Asih- Jatisari.";
            noTelp = "0264361459";
            alamatRS = "Jl. Raya Jatisari Mo. 3 Jatisari, Karawang.";
            latTujuan = -6.371648;
            lonTujuan = 107.520976;
        }

        if(b.equals("RS. ROSELA")){
            imageRS = "rsrosela";
            namaRs = "RS. ROSELA";
            ketRS = "RSU ROSELA adalah salah satu RS milik Perusahaan Karawang yang berbentuk RSU, dikelola oleh PT. SANJAYA PUTRA PE perusahaan dan termuat kedalam RS Tipe Belum ditetapkan. RS ini telah teregistrasi semenjak 21/08/2014 dengan Nomor Surat ijin – dan Tanggal Surat ijin 00/00/0000 dari – dengan Sifat , dan berlaku sampai -. Setelah melangsungkan Prosedur AKREDITASI RS Seluruh Indonesia dengan proses akhirnya diberikan status Akreditasi Rumah Sakit. RSU ini bertempat di Jl. Interchange Tol Karawang Barat No.3, Karawang, Indonesia.";
            noTelp = "02678637207";
            alamatRS = "Jl. Interchange Tol Karawang Barat No.3, Karawang, Indonesia.";
            latTujuan = -6.334228;
            lonTujuan = 107.273361;
        }

        if(b.equals("RS. SARASWATI")){
            imageRS = "rssaraswati";
            namaRs = "RS. SARASWATI";
            ketRS = "RS Saraswati ialah salah satu Rumah Sakit milik Swasta/Lainnya Karawang yang berupa RSU, dinaungi oleh  PT. Saraswati Medika  Perorangan dan tercantum kedalam Rumah Sakit Kelas D. Rumah Sakit ini telah terdaftar mulai  31/12/2014 dengan Nomor Surat ijin  HK.03.05/I/785/11 dan Tanggal Surat ijin  18/03/2011 dari  Ka Dinkes Kab. Karawang dengan Sifat  Tetap, dan berlaku sampai   16 MEI 2016. Sehabis melangsungkan Metode AKREDITASI RS Seluruh Indonesia dengan proses  Pentahapan I ( 5 Pelayanan) akhirnya diberikan status  Lulus Akreditasi Rumah Sakit. RSU ini berlokasi di Jl. Jend Ahmad Yani No.27,Cikampek,Kab.Karawang, Karawang, Indonesia.";
            noTelp = "0264316101";
            alamatRS = "Jl. Jend Ahmad Yani No.27,Cikampek,Kab.Karawang, Indonesia.";
            latTujuan = -6.421670;
            lonTujuan = 107.475836;
        }

        if(b.equals("RS. PERSADA MEDIKA")){
            imageRS = "rspersadamedika";
            namaRs = "RS. PERSADA MEDIKA";
            ketRS = "Bermula dari keinginan untuk memberikan pelayanan kesehatan yang terbaik untuk masyarakat, Klinik nusantara dari tahun ke tahun mengalami pengembangan hingga akhirnya berada pada titik ini. Sebuah komitmen yang bukan hanya memberikan pelayanan kesehatan, namun juga sebuah kepuasan bagi hati nurani. \\n \\nKini setelah 30 tahun pelayanan yang berkesinambungan, melalui pembaharuan tenaga medis dan peralatan kesehatan berstandar internasional, Rumah Sakit Jati Rahayu bertransformasi menjadi RS Persada Medika Jatirahayu dengan membawa visi “Menjadi Rumah Sakit Yang Memberikan Pelayanan Kesehatan Berkualitas, Terampil, Ramah dan Terjangkau”.";
            noTelp = "02648385999";
            alamatRS = "Jl. Ir. H. Juanda no.123, Cikampek, Jawa Barat 41373.";
            latTujuan = -6.413285;
            lonTujuan = 107.464626;
        }

        if(b.equals("RSUD. KARAWANG")){
            imageRS = "rsudkarawang";
            namaRs = "RSUD. KARAWANG";
            ketRS = "Visi\\nRumah Sakit Umum Daerah Regional Jawa Barat yang Maju dan Terkemuka di Tingkat Nasional\\n \\nMisi\\n1. Mewujudkan SDM yang profesional \\n2.Mewujudkan Sarana dan Prasarana yang sesuai standar \\n3.Mewujudkan pelayanan yang Komprehensif \\n4.Mewujudkan Rumah Sakit Pendidikan yang berkualitas \\n5.Mewujudkan peningkatan Derajat Kesehatan Masyarakat";
            noTelp = "089656944194";
            alamatRS = "Jl. Galuh Mas Raya No.1 Sukaharja Telukjambe Timur - Karawang.";
            latTujuan = -6.320475;
            lonTujuan = 107.293152;
        }


    }

}// class rumahSakit
