package com.bridgelabz.indianstatecodetest;

import com.bridgelabz.customexception.CustomExceptionService;
import com.bridgelabz.indianstatecodes.IndianStateCodeService;
import com.bridgelabz.indianstatecodes.StateCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IndianStateCodeTest {
    @Test
    public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() {
        String fileName = "/StateCode.csv";
        IndianStateCodeService codeService = new IndianStateCodeService();
        List<StateCode> stateCensusList = codeService.readIndiaStatCode(fileName);
        Assertions.assertEquals(37, stateCensusList.size());
    }

    @Test
    public void givenWrongFileExtension_ShouldReturnWrongFileType() {
        String fileName = "/StateCodeData.txt";
        IndianStateCodeService censusService = new IndianStateCodeService();
        try {
            List<StateCode> StateCodeList = censusService.readIndiaStatCode(fileName);
            Assertions.assertEquals(37, StateCodeList.size());
        } catch (CustomExceptionService e) {
            Assertions.assertEquals(CustomExceptionService.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenWrongFile_ShouldReturnFileNotFound() {
        String fileName = "/StateCode.csv";
        IndianStateCodeService censusService = new IndianStateCodeService();
        try {
            List<StateCode> StateCodeList = censusService.readIndiaStatCode(fileName);
            Assertions.assertEquals(37, StateCodeList.size());
        } catch (CustomExceptionService e) {
            Assertions.assertEquals(CustomExceptionService.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenWrongFileHeaders_ShouldReturnWrongHeader() {
        String fileName = "/IndiaStateCensusDataWrongHeaders.csv";
        IndianStateCodeService codeService = new IndianStateCodeService();
        try {
            List<StateCode> stateCodeList = codeService.readIndiaStatCode(fileName);
            Assertions.assertEquals(37, stateCodeList.size());
        } catch (CustomExceptionService e) {
            Assertions.assertEquals(CustomExceptionService.ExceptionType.WRONG_HEADER, e.type);
        }
    }
}
