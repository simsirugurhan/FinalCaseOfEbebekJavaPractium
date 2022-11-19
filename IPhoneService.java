package patikaStore;

public interface IPhoneService {

	Phone[] getPhones();
	Phone[] getPhoneNamesASC(Phone[] phones);
	Phone[] getPhoneNamesDESC(Phone[] phones);
	void printPhone(Phone[] phones);
	void printPhone(Phone phone);
	Phone[] addNewPhone(Phone phone);
	Phone[] removePhoneFromId(Product phone);
}
