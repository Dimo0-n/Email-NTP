# 🧰 Java Utilities Collection

Acest repository conține două aplicații Java de tip consolă, fiecare cu scopuri practice diferite — de la sincronizarea orei prin NTP până la gestionarea emailurilor prin protocoale standard.

---

## 📂 Conținutul proiectului

### 1. 🕒 NTP Client (`ntp-client`)

- **Descriere**: Aplicatie Java care se conectează la un server NTP public (`pool.ntp.org`) pentru a obține ora exactă, convertind-o în funcție de fusul orar specificat de utilizator.
- **Tehnologii**: Java, Apache Commons Net.
- **Funcționalitate**:
  - Solicită un fus orar în formatul `GMT+X` sau `GMT-X`.
  - Afișează ora curentă pentru fusul selectat.
- **Cerințe**:
  - Java 8+
  - [Apache Commons Net](https://commons.apache.org/proper/commons-net/)

📁 Cod sursă: [`/ntp-client`](https://github.com/Dimo0-n/Email-NTP/tree/main/src/main/java/com/example/ntp)

---

### 2. 📧 Email Client (`email-client`)

- **Descriere**: Aplicație Java pentru trimiterea și primirea de emailuri folosind protocoalele POP3, IMAP și SMTP, compatibilă cu Gmail.
- **Tehnologii**: Java 17+, Jakarta Mail API.
- **Funcționalitate**:
  - Citire emailuri din inbox (POP3/IMAP).
  - Trimitere de emailuri cu sau fără atașamente.
- **Cerințe**:
  - Java 17+
  - Biblioteca Jakarta Mail
  - Cont Gmail cu [parolă de aplicație](https://support.google.com/accounts/answer/185833?hl=ro)

📁 Cod sursă: [`/email-client`](https://github.com/Dimo0-n/Email-NTP/tree/main/src/main/java/com/example/emailClient)

---

## 🛠 Cerințe generale

- Java 8 sau mai recent (Java 17 recomandat pentru `email-client`)
- IDE precum IntelliJ IDEA, Eclipse sau rulare din terminal
- Acces la internet
- Adăugarea bibliotecilor externe în classpath (ex: `commons-net.jar`, `jakarta.mail.jar`)

---

## 📌 Recomandări

- Rulează fiecare aplicație în propriul director sau proiect IDE separat.
- Configurează corect accesul la contul Gmail (doar pentru `email-client`):
  - Activează verificarea în doi pași.
  - Generează o parolă de aplicație din contul Google.

---

