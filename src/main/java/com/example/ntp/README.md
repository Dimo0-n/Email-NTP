# NTP Client Java App

Aceasta este o aplicație simplă Java care utilizează protocolul NTP (Network Time Protocol) pentru a obține ora exactă de la un server de timp și o afișează în funcție de zona geografică introdusă de utilizator.

## 📦 Tehnologii utilizate

- Java 8+
- Consolă interactivă pentru input

## 🚀 Cum funcționează

1. Utilizatorul introduce o zonă geografică în format `GMT+X` sau `GMT-X` (ex: `GMT+2`).
2. Aplicația se conectează la serverul public NTP `pool.ntp.org`.
3. Obține ora exactă și o convertește în fusul orar specificat.
4. Afișează ora locală conform fusului orar introdus.

## ✅ Exemplu rulare

![image](https://github.com/user-attachments/assets/82bc5de3-a5d3-4c64-bf76-f35a160be6e6)

![image](https://github.com/user-attachments/assets/5bcd8906-6293-44e1-b338-7bd74b7a7cf1)


## ⚙️ Configurare

Dependenta obligatorie care trebuie sa fie prezenta in pom.xml
```xml
        <dependency>
            <groupId>commons-net</groupId>
            <artifactId>commons-net</artifactId>
            <version>3.9.0</version>
        </dependency>
