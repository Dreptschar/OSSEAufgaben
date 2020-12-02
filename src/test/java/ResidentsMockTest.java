import org.junit.Test;
import residents.domain.Resident;
import residents.repository.ResidentRepository;
import residents.service.BaseResidentService;
import residents.service.ResidentServiceException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResidentsMockTest {

@Test
public void test() throws ResidentServiceException {
    List<Resident> residentList = new ArrayList<>();
    residentList.add(new Resident( "Jonas", "Kern", "Goethestraße", "Ämmedinge", new Date(1212,8,11)));
    residentList.add(new Resident( "Niklas", "Eicher", "Eciherstraße", "Ämmedinge", new Date(1312,12,12)));
    residentList.add(new Resident( "Schmorri", "Lolnoob", "Intweg", "Tiltingen", new Date(1633,5,15)));

    ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
    expect(residentRepositoryMock.getResidents()).andReturn(residentList);

    replay(residentRepositoryMock);
    BaseResidentService baseResidentService = new BaseResidentService();
    baseResidentService.setResidentRepository(residentRepositoryMock);

    Resident para1 = new Resident("Jonas", "", "", "", null);

    Resident result = baseResidentService.getUniqueResident(para1);

    verify(residentRepositoryMock);

    assertThat(result, equalTo(residentList.get(0)));
}

}
