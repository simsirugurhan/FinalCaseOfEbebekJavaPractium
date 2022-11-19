package patikaStore;

import java.util.Arrays;
import java.util.Collections;

public class NotebookController implements INotebookService {

	ICompanyService companyService = new CompanyController();

	@Override
	public Notebook[] getNotebooks() {

		int[] companyIds = new int[] { 1, 5, 6, 8, 1 };
		Company[] companies = companyService.createCompaniesForDevice(companyIds);

		int companyNo = 0;

		Notebook notebook1 = new Notebook(5, 25000.00, 5, 100, "Notebook Bronz", companies[companyNo], "14 inç", "8 GB",
				"512 SSD");
		Notebook notebook2 = new Notebook(6, 27500.50, 10, 80, "Notebook Gümüş", companies[companyNo + 1], "15 inç",
				"16 GB", "512 HDD");
		Notebook notebook3 = new Notebook(7, 35999.99, 15, 60, "Notebook Altın", companies[companyNo + 2], "16 inç",
				"32 GB", "1028 HDD");
		Notebook notebook4 = new Notebook(8, 50000.00, 20, 40, "Notebook Uranyum", companies[companyNo + 3], "17 inç",
				"64 GB", "1028 SSD");
		Notebook notebook5 = new Notebook(10, 60000.00, 20, 40, "Notebook Mega", companies[companyNo + 4], "18 inç",
				"128 GB", "1028 SSD");

		Notebook[] notebooks = new Notebook[] { notebook1, notebook2, notebook3, notebook4, notebook5, };

		return notebooks;
	}

	@Override
	public Notebook[] getNotebookNamesASC(Notebook[] notebooks) {

		String[] notebookNames = new String[notebooks.length];
		Notebook[] notebookModel = new Notebook[notebooks.length];

		int i = 0;
		for (Notebook notebook : notebooks) {
			notebookNames[i] = notebook.getProductName();
			i++;
		}

		Arrays.sort(notebookNames);

		int j = 0;
		for (String notebookName : notebookNames) {
			for (Notebook notebook : notebooks) {
				if (notebook.getProductName().equals(notebookName)) {
					notebookModel[j] = notebook;
					j++;
				}
			}

		}

		return notebookModel;
	}

	@Override
	public Notebook[] getNotebookNamesDESC(Notebook[] notebooks) {
		String[] notebookNames = new String[notebooks.length];
		Notebook[] notebookModel = new Notebook[notebooks.length];

		int i = 0;
		for (Notebook notebook : notebooks) {
			notebookNames[i] = notebook.getProductName();
			i++;
		}

		Arrays.sort(notebookNames, Collections.reverseOrder());

		int j = 0;
		for (String notebookName : notebookNames) {
			for (Notebook notebook : notebooks) {
				if (notebook.getProductName().equals(notebookName)) {
					notebookModel[j] = notebook;
					j++;
				}
			}

		}

		return notebookModel;
	}

	@Override
	public void printNotebook(Notebook[] notebooks) {
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		System.out.printf(
				" Notebook Modelleri                                                                                        %n");

		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s |%n", "ID", "Notebook ismi", "Fiyat",
				"İndirim", "Marka", "Ekran Boyutu", "Ram", "Hafıza");
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		for (Notebook notebook : notebooks) {
			System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s |%n", notebook.getId(),
					notebook.getProductName(), notebook.getUnitPrice(), notebook.getDiscountRate(),
					notebook.getCompany().getName(), notebook.getScreenSize(), notebook.getRam(), notebook.getMemory());
		}
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
	}
	
	//OVERLOAD METHOD
	@Override
	public void printNotebook(Notebook notebook) {
		Notebook[] notebooks = new Notebook[] {
			notebook
		};
		
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		System.out.printf(
				" Notebook Modeli                                                                                           %n");

		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s |%n", "ID", "Notebook ismi", "Fiyat",
				"İndirim", "Marka", "Ekran Boyutu", "Ram", "Hafıza");
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		for (Notebook notebookModel : notebooks) {
			System.out.printf("| %-2s | %-18s | %8s | %8s | %8s | %15s | %8s | %15s |%n", notebookModel.getId(),
					notebookModel.getProductName(), notebookModel.getUnitPrice(), notebookModel.getDiscountRate(),
					notebookModel.getCompany().getName(), notebookModel.getScreenSize(), notebookModel.getRam(), notebookModel.getMemory());
		}
		System.out.printf(
				"-----------------------------------------------------------------------------------------------------------%n");
		
	}

	@Override
	public Notebook[] addNewNotebook(Notebook notebook) {
		Notebook[] notebooks = new Notebook[getNotebooks().length + 1];

		for(int i = 0; i < notebooks.length; i++) {
			if(i == getNotebooks().length) {
				notebooks[i] = notebook;
			}else {
				notebooks[i] = getNotebooks()[i];
			}
		}
		
		return notebooks;
	}

	@Override
	public Notebook[] removeNotebookFromId(Product notebook) {
		Notebook[] notebooks = new Notebook[getNotebooks().length - 1];
		
		int i = 0;
		for(Notebook notebookModel : getNotebooks()) {
			if(notebookModel.getId() == notebook.getId()) {
				
			}
			else {
				notebooks[i] = notebookModel; 
				i++;
			}
		}
				
		return notebooks;
	}

}
