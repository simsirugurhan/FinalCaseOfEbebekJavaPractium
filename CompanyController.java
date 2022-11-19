package patikaStore;

import java.util.Arrays;

public class CompanyController implements ICompanyService {

	@Override
	public Company[] createCompanies() {
		// companies
		Company company1 = new Company(0, "Samsung");
		Company company2 = new Company(1, "Lenovo");
		Company company3 = new Company(2, "Apple");
		Company company4 = new Company(3, "Huawei");
		Company company5 = new Company(4, "Casper");
		Company company6 = new Company(5, "Asus");
		Company company7 = new Company(6, "HP");
		Company company8 = new Company(7, "Xiaomi");
		Company company9 = new Company(8, "Monster");

		Company[] companies = new Company[] { company1, company2, company3, company4, company5, company6, company7,
				company8, company9, };

		return companies;
	}

	@Override
	public Company[] getCompanyNamesASC(Company[] companies) {
		String[] companyNames = new String[companies.length];
		Company[] companyModel = new Company[companies.length];

		int i = 0;
		for (Company company : companies) {
			companyNames[i] = company.getName();
			i++;
		}

		Arrays.sort(companyNames);

		int j = 0;
		for (String companyName : companyNames) {
			for (Company company : companies) {
				if (company.getName().equals(companyName)) {
					companyModel[j] = company;
					j++;
				}
			}
		}

		return companyModel;
	}

	@Override
	public void printCompanyNames(Company[] companies) {
		System.out.println("ID : Marka");
		for (Company company : companies) {
			System.out.println(company.getId() + " : " + company.getName());
		}
	}

	@Override
	public Company[] createCompaniesForDevice(int[] companyIds) {
		Company[] companies = new Company[companyIds.length];

		int i = 0;
		for (int id : companyIds) {
			for (Company company : createCompanies()) {
				if (id == company.getId()) {
					companies[i] = company;
					i++;
				}
			}
		}

		return companies;
	}

}
