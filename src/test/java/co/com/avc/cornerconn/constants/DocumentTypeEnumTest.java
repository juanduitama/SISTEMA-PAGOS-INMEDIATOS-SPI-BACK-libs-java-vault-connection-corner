package co.com.avc.cornerconn.constants;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DocumentTypeEnumTest {

    @ParameterizedTest
    @EnumSource(DocumentTypeEnum.class)
    void testDocumentTypeEnum(DocumentTypeEnum documentTypeEnum){
        switch (documentTypeEnum){
            case CC :
                assertEquals("CC", documentTypeEnum.getAthValue());
                break;
            case CE:
                assertEquals("CE", documentTypeEnum.getAthValue());
                break;
            case NUIP:
                assertEquals("NUIP", documentTypeEnum.getAthValue());
                break;
            case PPT:
                assertEquals("PPT", documentTypeEnum.getAthValue());
                break;
            case NIT:
                assertEquals("NIT", documentTypeEnum.getAthValue());
                break;
            case PEP:
                assertEquals("PEP", documentTypeEnum.getAthValue());
                break;
            case PAS:
                assertEquals("PAS", documentTypeEnum.getAthValue());
                break;
            case TDI:
                assertEquals("TDI", documentTypeEnum.getAthValue());
                break;
            default:
                fail("Unexpected value: " + documentTypeEnum);
        }
}
}
