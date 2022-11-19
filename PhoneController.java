package patikaStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneController implements IPhoneService {

	ICompanyService companyService = new CompanyController();

	@Override
	public Phone[] getPhones() {
		// 0,2,3,4,7
		int[] companyIds = new int[] { 0, 2, 3, 4, 7, 3 };
		Company[] companies = companyService.createCompaniesForDevice(companyIds);

		// memories of phone
		String[] memories = new String[] { "128 GB", "64 GB" };

		// colors of phone
		String[] colors = new String[] { "Siyah", "Kırmızı", "Mavi" };

		int companyNo = 0;

		// phones
		Phone phone1 = new Phone(0, 3250.99, 0, 50, "Telefon Bronz", companies[companyNo], "6.1 Inc", "6 MB", memories,
				"4000", colors);
		Phone phone2 = new Phone(1, 4250.99, 0, 40, "Telefon Gümüş", companies[companyNo + 1], "5.6 Inc", "8 MB",
				memories, "5000", colors);
		Phone phone3 = new Phone(2, 5500.00, 3, 30, "Telefon Altın", companies[companyNo + 2], "5.1 Inc", "16 MB",
				memories, "6000", colors);
		Phone phone4 = new Phone(3, 6250.99, 5, 30, "Telefon Uranyum", companies[companyNo + 3], "4.6 Inc", "32 MB",
				memories, "7000", colors);
		Phone phone5 = new Phone(4, 10100.00, 10, 20, "Telefon Bor", companies[companyNo + 4], "4.1 Inc", "64 MB",
				memories, "8000", colors);
		Phone phone6 = new Phone(9, 1500.00, 12, 20, "Telefon Mega", companies[companyNo + 5], "3.7 Inc", "64 MB",
				memories, "9000", colors);

		Phone[] phones = new Phone[] { phone1, phone2, phone3, phone4, phone5, phone6 };

		return phones;
	}

	@Override
	public Phone[] getPhoneNamesASC(Phone[] phones) {
		String[] phoneNames = new String[phones.length];
		Phone[] phoneModel = new Phone[phones.length];

		int i = 0;
		for (Phone phone : phones) {
			phoneNames[i] = phone.getProductName();
			i++;
		}

		Arrays.sort(phoneNames);

		int j = 0;
		for (String phoneName : phoneNames) {
			for (Phone phone : phones) {
				if (phone.getProductName().equals(phoneName)) {
					phoneModel[j] = phone;
					j++;
				}
			}
		}

		return phoneModel;
	}

	@Override
	public Phone[] getPhoneNamesDESC(Phone[] phones) {
		String[] phoneNames = new String[phones.length];
		Phone[] phoneModel = new Phone[phones.length];

		int i = 0;
		for (Phone phone : phones) {
			phoneNames[i] = phone.getProductName();
			i++;
		}

		Arrays.sort(phoneNames, Collections.reverseOrder());

		int j = 0;
		for (String phoneName : phoneNames) {
			for (Phone phone : phones) {
				if (phone.getProductName().equals(phoneName)) {
					phoneModel[j] = phone;
					j++;
				}
			}
		}

		return phoneModel;
	}

	@Override
	public void printPhone(Phone[] phones) {
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf(
				" Telefon Modelleri                                                                                                                                      %n");

		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s | %15s | %25s |%n", "ID",
				"Telefon ismi", "Fiyat", "İndirim", "Marka", "Ekran Boyutu", "Ram", "Hafıza Çşt.", "Batarya Gücü",
				"Renk Çeşitleri");
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");

		for (Phone phone : phones) {
			List<String> memories = new ArrayList<String>();
			for (String memory : phone.getMemory()) {
				memories.add(memory);
			}

			List<String> colors = new ArrayList<String>();
			for (String color : phone.getColor()) {
				colors.add(color);
			}

			System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s | %15s | %25s |%n", phone.getId(),
					phone.getProductName(), phone.getUnitPrice(), phone.getDiscountRate(), phone.getCompany().getName(),
					phone.getScreenSize(), phone.getRam(), memories.toString(), phone.getBatteryPower(),
					colors.toString());
			System.out.printf(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		}
	}
	
	@Override
	public void printPhone(Phone phone) {
		Phone[] phones = new Phone[] {
			phone	
		};
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf(
				" Telefon Modeli                                                                                                                                         %n");

		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s | %15s | %25s |%n", "ID",
				"Telefon ismi", "Fiyat", "İndirim", "Marka", "Ekran Boyutu", "Ram", "Hafıza Çşt.", "Batarya Gücü",
				"Renk Çeşitleri");
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		for (Phone phoneModel : phones) {
			List<String> memories = new ArrayList<String>();
			for (String memory : phoneModel.getMemory()) {
				memories.add(memory);
			}

			List<String> colors = new ArrayList<String>();
			for (String color : phoneModel.getColor()) {
				colors.add(color);
			}

			System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s | %15s | %25s |%n", phoneModel.getId(),
					phoneModel.getProductName(), phoneModel.getUnitPrice(), phoneModel.getDiscountRate(), phoneModel.getCompany().getName(),
					phoneModel.getScreenSize(), phoneModel.getRam(), memories.toString(), phoneModel.getBatteryPower(),
					colors.toString());
			System.out.printf(
					"--------------------------------------------------------------------------------------------------------------------------------------------------------%n");
		}
	}

	@Override
	public Phone[] addNewPhone(Phone phone) {
		Phone[] phones = new Phone[getPhones().length + 1];

		for (int i = 0; i < phones.length; i++) {
			if (i == getPhones().length) {
				phones[i] = phone;
			} else {
				phones[i] = getPhones()[i];
			}
		}

		return phones;
	}

	@Override
	public Phone[] removePhoneFromId(Product phone) {
		Phone[] phones = new Phone[getPhones().length - 1];

		int i = 0;
		for (Phone phoneModel : getPhones()) {
			if (phoneModel.getId() == phone.getId()) {

			} else {
				phones[i] = phoneModel;
				i++;
			}
		}

		return phones;
	}

	

}
