package com.company.service;

public class SimpleCaesarMessageService implements CaesarMessageService {

    @Override
    public char decipher(char characterToBeDeciphered, int keyShift) {

        String character = String.valueOf(characterToBeDeciphered);

        if (!character.matches("[А-Яа-яЁё]")) {
            return characterToBeDeciphered;
        }

        String decipheredCharacter = null;

        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String template = alphabet + alphabet;

        boolean characterIsInUpperCase = character.matches("[А-ЯЁ]");
        character = character.toLowerCase(); // to ignore case while deciphering

        int shiftedPositionOfTheCharacterInTheTemplate = template.indexOf(character) + keyShift;
        decipheredCharacter = template.substring(shiftedPositionOfTheCharacterInTheTemplate,
                                                 shiftedPositionOfTheCharacterInTheTemplate + 1);

        if (characterIsInUpperCase) {
            decipheredCharacter = decipheredCharacter.toUpperCase();
        }

        return decipheredCharacter.charAt(0);
    }

    @Override
    public String decipher(String messageToBeDeciphered, int keyShift) {

        char[] charactersFromMessage = messageToBeDeciphered.toCharArray();

        for (int i = 0; i < charactersFromMessage.length; i++) {
                charactersFromMessage[i] = this.decipher(charactersFromMessage[i], keyShift);
        }

        return String.valueOf(charactersFromMessage);
    }

    @Override
    public void decipherIntoConsoleForAllKeyShifts(String messageToBeDeciphered) {

        System.out.println("\nШифрованное сообщение:\n\"" + messageToBeDeciphered + "\"");
        System.out.println("\nРасшифровка сообщения для всех возможных вариантов шифра Цезаря:\n");

        for(int keyShift = 1; keyShift < 33; keyShift++) {
            System.out.println("" + keyShift + ".\"" +
                                this.decipher(messageToBeDeciphered, keyShift) + "\"");
        }
    }
}
