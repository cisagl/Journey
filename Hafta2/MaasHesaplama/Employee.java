package Hafta2.MaasHesaplama;

public class Employee {
    String name;
    int salary;
    int workHour;
    int hireYear;

    Employee(String name, int salary, int workHour, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHour = workHour;
        this.hireYear = hireYear;
    }

    int tax() {
        int tax = 0;
        if (this.salary < 0) {
            System.out.println("Lütfen geçerli bir maaş giriniz");
        } else if (this.salary > 1000) {
            tax = (int) (this.salary * 0.03);
        } else {
            System.out.println("1000TL'den düşük maaş için vergi alınmamaktadır.");
        }
        return tax;
    }

    int calculateBonus() {
        int bonusMiktar = 0;
        for (int i = 1; i <= workHour; i++) {
            if (i >= 40) {
                bonusMiktar += 30;
            }
        }
        return bonusMiktar;
    }

    int raiseSalary() {
        int thisYear = 2021;
        int howManyYear;
        double raise = 0;
        howManyYear = thisYear - hireYear;

        if (howManyYear >= 20) {
            raise = this.salary * 0.15;
        } else if (howManyYear <= 18 && howManyYear > 9) {
            raise = this.salary * 0.1;
        } else {
            raise = this.salary * 0.05;
        }

        int raiseInt = (int) raise;

        return raiseInt;
    }

    public String toString() {

        int maasArtis = raiseSalary();
        int vergi = tax();
        int bonus = calculateBonus();

        double total = salary + bonus - vergi + maasArtis;
        double bonusVeVergi = bonus - vergi + salary;
        double artis = bonus + maasArtis;

        System.out.println("Çalışanın ismi: " + name);
        System.out.println("Çalışanın maaşı: " + salary);
        System.out.println("Çalışanın çalışma saati: " + workHour);
        System.out.println("Çalışanın işe başlama tarihi: " + hireYear);
        System.out.println("Çalışanın maaşındaki vergi kesintisi: "+vergi);
        System.out.println("Çalışanın maaşındaki bonus: "+bonus);
        System.out.println("Çalışanın maaş artışı: " + artis);
        System.out.println("Çalışanın vergi ve bonuslarla birlikte maaşı: " + bonusVeVergi);
        System.out.println("Çalışanın toplam maaşı: "+total);
        System.out.println("================================");
        return "İşlem Tamamlandı";
    }
}