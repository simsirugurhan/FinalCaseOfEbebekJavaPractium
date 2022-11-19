package patikaStore;

public interface IPatikaScreen {
	void runFirstly();
	void runForPhoneASC();
	void runForPhoneDESC();
	void runForNotebookASC();
	void runForNotebookDESC();
	void runForAllProducts();
	int createUniqueNumberForNewDevice();
	Company findCompanyFromId(int companyId);
}
