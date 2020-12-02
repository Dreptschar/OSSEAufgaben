import org.junit.Assert;
import org.junit.Test;
import residents.domain.Resident;
import residents.service.BaseResidentService;
import residents.service.ResidentServiceException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentsTest {
    ResidentRepositoyStub residentRepositoyStub = new ResidentRepositoyStub();
    BaseResidentService baseResidentService = new BaseResidentService();

    private void initResidents(){
        residentRepositoyStub.createResidentList();
        baseResidentService.setResidentRepository(residentRepositoyStub);
}

@Test
public void UniqueResidentTest() throws ResidentServiceException {
    initResidents();
    Resident para1 = new Resident("Jonas", "", "", "", null);
    Resident result1 = residentRepositoyStub.residentList.get(0);
    Assert.assertEquals(result1, baseResidentService.getUniqueResident(para1));

    Resident para2 = new Resident("", "Kappa", "", "", null);
    Resident result2 = residentRepositoyStub.residentList.get(3);
    Assert.assertEquals(result2, baseResidentService.getUniqueResident(para2));
}

@Test(expected = ResidentServiceException.class)
public void UniqueResidentWildcardTest() throws ResidentServiceException {
    initResidents();
    Resident para1 = new Resident("J*","","","",null);
    baseResidentService.getUniqueResident(para1);
    }

@Test(expected = ResidentServiceException.class)
public void UniqueResidentNoResidentFoundTest() throws ResidentServiceException {
    initResidents();
    Resident para1 = new Resident("Test","","","",null);
    baseResidentService.getUniqueResident(para1);
}

@Test
public void FilteredResidentTest() throws ResidentServiceException {
     // One Result Test
     initResidents();
     Resident para1 = new Resident("J*","","","",null);
     Resident result1 = residentRepositoyStub.residentList.get(0);
     Assert.assertEquals(result1,(baseResidentService.getFilteredResidentsList(para1)).get(0));

     //Multiple Results Test
     List<Resident> result2 = new ArrayList<>();
     result2.add(residentRepositoyStub.residentList.get(0));
     result2.add(residentRepositoyStub.residentList.get(3));
     Resident para2 = new Resident("","K*","","",null);
     Assert.assertEquals(result2,(baseResidentService.getFilteredResidentsList(para2)));

     //No Result Test
     initResidents();
     Resident para3 = new Resident("X*","","","",null);
     int result3 = 0;
     Assert.assertEquals(result3,(baseResidentService.getFilteredResidentsList(para3)).size());
}

@Test
public void FilteredResidentFilterTest(){
    initResidents();
    Resident para1 = new Resident("J*","","","",null);
    Resident result1 = residentRepositoyStub.residentList.get(0);
    Assert.assertEquals(result1,(baseResidentService.getFilteredResidentsList(para1)).get(0));

    Resident para2 = new Resident("","Kern","","",null);
    Assert.assertEquals(result1,(baseResidentService.getFilteredResidentsList(para2)).get(0));

    Resident para3 = new Resident("","","Goethe*","",null);
    Assert.assertEquals(result1,(baseResidentService.getFilteredResidentsList(para3)).get(0));

    Resident para4 = new Resident("","","","Ämme*",null);
    Assert.assertEquals(result1,(baseResidentService.getFilteredResidentsList(para4)).get(0));

    Resident para5 = new Resident("","","","", new Date(1212,8,11));
    Assert.assertEquals(result1,(baseResidentService.getFilteredResidentsList(para5)).get(0));

}



}
