package com.company.service;

public interface CaesarMessageService {

    char decipher(char characterToBeDeciphered, int keyShift);

    String decipher(String messageToBeDeciphered, int keyShift);

    void decipherIntoConsoleForAllKeyShifts(String messageToBeDeciphered);
}
