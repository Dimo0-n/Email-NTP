# Email Client - Java Console App

Acesta este un client de email simplu scris în Java, care permite:

- Citirea emailurilor prin **POP3** sau **IMAP**
- Trimiterea de emailuri text
- Trimiterea de emailuri cu atașamente

Aplicația folosește biblioteca **Jakarta Mail** pentru interacțiunea cu serverele de email și funcționează cu conturi Gmail (cu parolă de aplicație activată).

---

## 📦 Structura proiectului

- `EmailReceiver.java` – gestionează citirea emailurilor din inbox folosind POP3 sau IMAP.
- `EmailSender.java` – permite trimiterea de emailuri cu sau fără atașamente.
- `MainApp.java` – interfața principală de tip consolă unde utilizatorul selectează opțiunile disponibile.

---

## 🛠️ Cerințe

- Java 17+
- Jakarta Mail API (inclus în dependințele proiectului)
- Acces la internet
- Cont Gmail configurat cu [parolă de aplicație](https://support.google.com/accounts/answer/185833?hl=ro)

---

## 🔐 Setări Gmail necesare

1. Activează **verificarea în doi pași** pe contul tău Gmail.
2. Creează o **parolă de aplicație** din setările de securitate Gmail.
3. Folosește această parolă în aplicație în locul parolei normale.
4. Configurarea setarilor generale pentru IMAP is POP3 din gmail-ul personal
   [Setari generale gmail](https://mail.google.com/mail/u/0/#settings)
  ![image](https://github.com/user-attachments/assets/991b7759-d206-44a4-b170-759fa294b910)



---

## ▶️ Cum rulezi aplicația?
Ruleaza clasa MainApp din foldelul emailClient, dupa alegeti una dintre optiuni

![image](https://github.com/user-attachments/assets/1c6b1e34-c24c-48da-b4da-4172ea2e89ce)

Clonează acest repository:
   ```bash
   git clone https://github.com/numele-tau/email-client-java.git
   cd email-client-java
