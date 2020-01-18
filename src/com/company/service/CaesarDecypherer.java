package com.company.service;

public interface CaesarDecypherer {

    char decypher(char characterToBeDecyphered, int keyShift);

    String decypher(String messageToBeDecyphered, int keyShift);

    void decypherIntoConsoleForAllKeyShifts(String messageToBeDecyphered);
}
