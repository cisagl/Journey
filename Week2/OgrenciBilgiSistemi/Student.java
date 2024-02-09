package Hafta2.OgrenciBilgiSistemi;

public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }

    //Sözlü notlarının ortalamaya dahil edilmesi sağlandı, 0'dan düşük ya da 100'den yüksek not verilmesi engellendi
    public void addBulkExamNote(int mat, int fizik, int kimya, int matSozlu, int fizikSozlu, int kimyaSozlu) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

        if (matSozlu >= 0 && matSozlu <= 100) {
            this.mat.sozlu = matSozlu;
        }

        if (fizikSozlu >= 0 && fizikSozlu <= 100) {
            this.fizik.sozlu = fizikSozlu;
        }

        if (kimyaSozlu >= 0 && kimyaSozlu <= 100) {
            this.kimya.sozlu = kimyaSozlu;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        // Önce not ve sözlü notu hesaplamaları yapıldı
        double fizikAverage = this.fizik.note*0.8 + this.fizik.sozlu*0.2;
        double matAverage = this.mat.note*0.8 + this.mat.sozlu*0.2;
        double kimyaAverage = this.kimya.note*0.8 + this.kimya.sozlu*0.2;

        // Ortalamalar avg değişkeni ile 3'e bölündü (avg değişkeni casting için oluşturuldu)
        double avg = (fizikAverage + kimyaAverage + matAverage) / 3;
        // Çıkan ortalama double'dan int'e çevirildi
        this.avarage = (int) avg;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        // Öğrencinin bütün çıktıları görmesi sağlandı
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Matematik Sözlü Notu : " + this.mat.sozlu);
        System.out.println("-------------------------");
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik Sözlü Notu : " + this.fizik.sozlu);
        System.out.println("-------------------------");
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Kimya Sözlü Notu : " + this.kimya.sozlu);
        System.out.println("-------------------------");
    }

}