package com.company.service;

public interface CaesarMessageService {

    char decypher(char characterToBeDecyphered, int keyShift);

    String decypher(String messageToBeDecyphered, int keyShift);

    void decypherIntoConsoleForAllKeyShifts(String messageToBeDecyphered);
}
