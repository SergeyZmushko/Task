package by.epam.task.bean;


public class Letter {
    private String title;
    private String message;
    private String recipientEmail;
    private String senderEmail;
    private LetterType letterType;

    public Letter() {

    }

    public Letter(String title, String message, String recipientEmail, String senderEmail, LetterType letterType) {
        this.title = title;
        this.message = message;
        this.recipientEmail = recipientEmail;
        this.senderEmail = senderEmail;
        this.letterType = letterType;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public LetterType getLetterType() {
        return letterType;
    }

    public static class Builder {
        private Letter newLetter;

        public Builder() {
            newLetter = new Letter();
        }

        public Builder withTitle(String title) {
            newLetter.title = title;
            return this;
        }

        public Builder withMessage(String message) {
            newLetter.message = message;
            return this;
        }

        public Builder withRecipientEmail(String recipientEmail) {
            newLetter.recipientEmail = recipientEmail;
            return this;
        }

        public Builder withSenderEmail(String senderEmail) {
            newLetter.senderEmail = senderEmail;
            return this;
        }

        public Builder withLetterType(String letterType) {
            if (letterType.equalsIgnoreCase("прочитано")) {
                newLetter.letterType = LetterType.READ;
            } else if (letterType.equalsIgnoreCase("не прочитано")) {
                newLetter.letterType = LetterType.UNREAD;
            }
            return this;
        }

        public Letter build() {
            return newLetter;
        }
    }

    public static enum LetterType {
        READ("Прочитано"),
        UNREAD("Не прочитано");

        private String value;

        LetterType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter = (Letter) o;

        if (title != null ? !title.equals(letter.title) : letter.title != null) return false;
        if (message != null ? !message.equals(letter.message) : letter.message != null) return false;
        if (recipientEmail != null ? !recipientEmail.equals(letter.recipientEmail) : letter.recipientEmail != null)
            return false;
        if (senderEmail != null ? !senderEmail.equals(letter.senderEmail) : letter.senderEmail != null) return false;
        return letterType == letter.letterType;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (recipientEmail != null ? recipientEmail.hashCode() : 0);
        result = 31 * result + (senderEmail != null ? senderEmail.hashCode() : 0);
        result = 31 * result + (letterType != null ? letterType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Тема: " + title + " | " +
                "Отправитель: " + senderEmail + " | " +
                "Состояние: " + letterType.getValue();
    }
}
