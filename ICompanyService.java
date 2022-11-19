package patikaStore;

public interface ICompanyService {
	Company[] createCompanies();

	Company[] getCompanyNamesASC(Company[] companies);

	void printCompanyNames(Company[] companies);

	Company[] createCompaniesForDevice(int[] companyIds);

}
