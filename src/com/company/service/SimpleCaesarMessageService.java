package com.company.service;

public class SimpleCaesarMessageService implements CaesarMessageService {

    @Override
    public char decypher(char characterToBeDecyphered, int keyShift) {

        String character = String.valueOf(characterToBeDecyphered);

        if (!character.matches("[А-Яа-яЁё]")) {
            return characterToBeDecyphered;
        }

        String decypheredCharacter = null;

        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String template = alphabet + alphabet;

        boolean characterIsInUpperCase = character.matches("[А-ЯЁ]");
        character = character.toLowerCase(); // to ignore case while decyphering

        int shiftedPositionOfTheCharacterInTheTemplate = template.indexOf(character) + keyShift;
        decypheredCharacter = template.substring(shiftedPositionOfTheCharacterInTheTemplate,
                                                 shiftedPositionOfTheCharacterInTheTemplate + 1);

        if (characterIsInUpperCase) {
            decypheredCharacter = decypheredCharacter.toUpperCase();
        }

        return decypheredCharacter.charAt(0);
    }

    @Override
    public String decypher(String messageToBeDecyphered, int keyShift) {

        char[] charactersFromMessage = messageToBeDecyphered.toCharArray();

        for (int i = 0; i < charactersFromMessage.length; i++) {
                charactersFromMessage[i] = this.decypher(charactersFromMessage[i], keyShift);
        }

        return String.valueOf(charactersFromMessage);
    }

    @Override
    public void decypherIntoConsoleForAllKeyShifts(String messageToBeDecyphered) {

        for(int keyShift = 1; keyShift < 33; keyShift++) {
            System.out.println("Дешифрованное сообщение ( сдвиг = " + keyShift + " ): \"" +
                                this.decypher(messageToBeDecyphered, keyShift) + "\"");
        }
    }
}
