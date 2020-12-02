import residents.domain.Resident;
import residents.repository.ResidentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentRepositoyStub implements ResidentRepository {

    List<Resident> residentList = new ArrayList<>();


    @Override
    public List<Resident> getResidents() {
        return residentList;
    }

    public void createResidentList(){
        residentList.add(new Resident( "Jonas", "Kern", "Goethestraße", "Ämmedinge", new Date(1212,8,11)));
        residentList.add(new Resident( "Niklas", "Eicher", "Eciherstraße", "Ämmedinge", new Date(1312,12,12)));
        residentList.add(new Resident( "Schmorri", "Lolnoob", "Intweg", "Tiltingen", new Date(1633,5,15)));
        residentList.add(new Resident( "Chrizzzz", "Kappa", "Krummnasenstraße", "Niewiedersehingen", new Date(1805,3,31)));
        residentList.add(new Resident( "Fränk", "thetänk", "GHB", "Furtwängingen", new Date(1999,9,9)));
    }
}
