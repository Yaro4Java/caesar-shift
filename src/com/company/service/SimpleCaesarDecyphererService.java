package com.company.service;

public class SimpleCaesarDecyphererService implements CaesarDecyphererService {

    @Override
    public char decypher(char characterToBeDecyphered, int keyShift) {

        String character = String.valueOf(characterToBeDecyphered);

        if (!character.matches("[А-Яа-яЁё]")) {
            return characterToBeDecyphered;
        }

        String decypheredCharacter = null;

        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String template = alphabet + alphabet + alphabet;
        template = template.substring(1, template.length() - 1);

        boolean characterIsInUpperCase = character.matches("[А-ЯЁ]");
        character = character.toLowerCase(); // to ignore case while decyphering

        int positionOfDecypheredCharacterInTheTemplate = template.indexOf(character, 32) + keyShift;
        decypheredCharacter = template.substring(positionOfDecypheredCharacterInTheTemplate,
                                                 positionOfDecypheredCharacterInTheTemplate + 1);

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

        for(int keyShift = 1; keyShift <= 32; keyShift++) {
            System.out.println("Дешифрованное сообщение ( сдвиг = " + keyShift + " ): \"" +
                                this.decypher(messageToBeDecyphered, keyShift) + "\"");
        }
    }
}
