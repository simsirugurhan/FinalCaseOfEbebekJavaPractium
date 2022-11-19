package patikaStore;

import java.util.Scanner;

public class PatikaStore implements IPatikaScreen {

	// company service
	ICompanyService companyService = new CompanyController();
	// phone service
	IPhoneService phoneService = new PhoneController();
	// notebooks
	INotebookService notebookService = new NotebookController();

	@Override
	public void runFirstly() {
		// companies created
		// Company[] companies =
		companyService.createCompanies();

		// print companies ASC
		// companyService.printCompanyNames(companyService.getCompaniesASC(companyService.getCompanyNames(companies)));

		// phones created
		phoneService.getPhones();

		// notebooks created
		notebookService.getNotebooks();

		System.out.println("PatikaStore Mağazamıza Hoşgeldiniz!\n-----------------------------------");
		System.out.println(
				"Tüm Ürünler için [1] basınız.\nTelefon Modelleri için [2] basınınz.\nNotebook Modelleri için [3] basınınz.");
		System.out.println("Yeni Ürün Eklemek için [4] basınız.");
		System.out.println("Id ile Ürün İşlemleri için [5] basınız.");
		System.out.println("Marka ile Ürün İşlemleri için [6] basınız.");

		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("-----------------------------------\nSayı girişi: ");
			int input = scan.nextInt();
			System.out.println("-----------------------------------");
			
			if (input == 1) {
				runForAllProducts();
			} else if (input == 2) {
				System.out.println("Telefonları A-Z sıralamak için [1] basınız.\nTelefonları Z-A sıralamak için [2] basınız\nSıralamak istemiyorsanız [3] basınız.");
				System.out.print("-----------------------------------\nSayı girişi: ");
				int inputScan = scan.nextInt();
				System.out.println("-----------------------------------");
				if(inputScan == 1) {
					runForPhoneASC();
				}else if( inputScan == 2) {
					runForPhoneDESC();
				}else if(inputScan == 3) {
					phoneService.printPhone(phoneService.getPhones());
				}else {
					System.out.println("Geçersiz İşlem!");
				}
			} else if (input == 3) {
				//notebookService.printNotebook(notebookService.getNotebooks());
				System.out.println("Notebookları A-Z sıralamak için [1] basınız.\nNotebookları Z-A sıralamak için [2] basınız\nSıralamak istemiyorsanız [3] basınız.");
				System.out.print("-----------------------------------\nSayı girişi: ");
				int inputScan = scan.nextInt();
				System.out.println("-----------------------------------");
				if(inputScan == 1) {
					runForNotebookASC();
				}else if( inputScan == 2) {
					runForNotebookDESC();
				}else if(inputScan == 3) {
					phoneService.printPhone(phoneService.getPhones());
				}else {
					System.out.println("Geçersiz İşlem!");
				}
			}else if(input == 4) {
				System.out.println("Yeni ürün Telefon ise [1] basınız.\nYeni ürün Notebook ise [2] basınız.");
				System.out.print("-----------------------------------\nSayı girişi: ");
				int inputScan = scan.nextInt();
				System.out.println("-----------------------------------");
				if(inputScan == 1) {
					//product name
					System.out.print("Telefon Adı: ");
					String inputName = scan.next();
					
					//unit price
					System.out.print("Telefon Ücreti: ");
					Double inputPrice = scan.nextDouble();
					
					//discount rate
					System.out.print("Telefon İndirim oranı: ");
					int inputDiscount = scan.nextInt();
					
					//stock
					System.out.print("Telefon Stok Sayısı: ");
					int inputStock = scan.nextInt();
					
					System.out.println("Marka ID numaraları");
					
					//company
					Company[] companiesModel = companyService.createCompanies();
					companyService.printCompanyNames(companiesModel);
					Company company = companiesModel[0];

					System.out.print("Telefon Marka IDsi: ");
					int inputId = scan.nextInt();
					company = findCompanyFromId(inputId);

					//screen size
					System.out.print("Telefon Ekran Boyutu: ");
					String inputScreen = scan.next();
					
					//ram
					System.out.print("Telefon Ram: ");
					String inputRam = scan.next();
					
					System.out.print("Telefonun Kaç Hafıza Çeşidi var: ");
					//memories
					int inputMemo = scan.nextInt();
					String[] memories = new String[inputMemo];
					for(int i = 0; i < inputMemo; i++) {
						System.out.print("Telefon Hafıza Çeşit " + (i+1) + ": ");
						String inputFeature = scan.next();
						memories[i] = inputFeature;
					}
					
					//battery
					System.out.print("Telefon Batarya Gücü: ");
					String inputBattery = scan.next();
					
					System.out.print("Telefonun Kaç Renk Çeşidi var: ");
					//colors
					int inputColour = scan.nextInt();
					String[] colors = new String[inputColour];
					for(int i = 0; i < inputColour; i++) {
						System.out.print("Telefon Renk Çeşit " + (i+1) + ": ");
						String inputFeature = scan.next();
						colors[i] = inputFeature;
					}
					
					//id create
					int newID = createUniqueNumberForNewDevice();
					
					Phone newPhone = new Phone(newID, inputPrice, inputDiscount, inputStock, inputName, company, inputScreen, inputRam, memories, inputBattery, colors);
					phoneService.printPhone(phoneService.addNewPhone(newPhone));
				}else if( inputScan == 2) {

					//product name
					System.out.print("Notebook Adı: ");
					String inputName = scan.next();
					
					//unit price
					System.out.print("Notebook Ücreti: ");
					Double inputPrice = scan.nextDouble();
					
					//discount rate
					System.out.print("Notebook İndirim oranı: ");
					int inputDiscount = scan.nextInt();
					
					//stock
					System.out.print("Notebook Stok Sayısı: ");
					int inputStock = scan.nextInt();
					
					System.out.println("Marka ID numaraları");
					
					//company
					Company[] companiesModel = companyService.createCompanies();
					companyService.printCompanyNames(companiesModel);
					Company company = companiesModel[0];

					System.out.print("Notebook Marka IDsi: ");
					int inputId = scan.nextInt();
					company = findCompanyFromId(inputId);

					//screen size
					System.out.print("Notebook Ekran Boyutu: ");
					String inputScreen = scan.next();
					
					//ram
					System.out.print("Notebook Ram: ");
					String inputRam = scan.next();
					
					//memory
					System.out.print("Notebook Hafıza: ");
					String inputMemo = scan.next();
					
					//id create
					int newID = createUniqueNumberForNewDevice();
					
					Notebook newNotebook = new Notebook(newID, inputPrice, inputDiscount, inputStock, inputName, company, inputScreen, inputRam, inputMemo);
					notebookService.printNotebook(notebookService.addNewNotebook(newNotebook));
				}else {
					System.out.println("Geçersiz İşlem!");
				}
			}else if(input == 5) {
				//filter or remove
				System.out.println("Id ile ürün Silinecek ise [1] basınız.\nId ile ürün Filtrelenecek ise [2] basınız.");
				System.out.print("-----------------------------------\nSayı girişi: ");
				int inputScan = scan.nextInt();
				System.out.println("-----------------------------------");
				if(inputScan == 1) {
					//remove method
					runForAllProducts();
					System.out.print("Silinecek ID giriniz: ");
					int inputId = scan.nextInt();
					
					Phone[] phones = phoneService.getPhones();
					Notebook[] notebooks = notebookService.getNotebooks();
					Product productRemove;
					
					boolean flag = false;
					for(Phone phone : phones) {
						if(inputId == phone.getId()) {
							productRemove = phone;
							System.out.println("--Telefon SİLİNDİ!--");
							phoneService.printPhone(phoneService.removePhoneFromId(productRemove));
							flag = true;
						}
					}
					
					//waste time blocker
					if(flag == false) {
						for(Notebook notebook : notebooks) {
							if(inputId == notebook.getId()) {
								productRemove = notebook;
								System.out.println("--Notebook SİLİNDİ!--");
								notebookService.printNotebook(notebookService.removeNotebookFromId(productRemove));
							}
						}
					}
				}else if(inputScan == 2) {
					//filter method
					System.out.print("Filtrelenecek ürün ID giriniz: ");
					int inputId = scan.nextInt();
					
					Phone[] phones = phoneService.getPhones();
					Notebook[] notebooks = notebookService.getNotebooks();
					
					boolean flag = false;
					for(Phone phone : phones) {
						if(inputId == phone.getId()) {
							System.out.println("--Telefon GETİRİLDİ!--");
							phoneService.printPhone(phone);
							flag = true;
						}
					}
					
					//waste time blocker
					if(flag == false) {
						for(Notebook notebook : notebooks) {
							if(inputId == notebook.getId()) {
								System.out.println("--Notebook GETİRİLDİ!--");
								notebookService.printNotebook(notebook);
							}
						}
					}
				}else {
					System.out.println("Geçersiz İşlem!");
				}
			}else if(input == 6) {
				//filter from company
				Company[] companiesModel = companyService.createCompanies();
				
				//companies list ASC
				companyService.printCompanyNames(companyService.getCompanyNamesASC(companiesModel));
				
				System.out.print("Filtrelenecek marka ID giriniz: ");
				int inputId = scan.nextInt();
				
				Phone[] phones = phoneService.getPhones();
				Notebook[] notebooks = notebookService.getNotebooks();
				
				System.out.println("--Ürünler GETİRİLDİ!--");
				
				for(Phone phone : phones) {
					if(inputId == phone.getCompany().getId()) {
						phoneService.printPhone(phone);
					}
				}

				for(Notebook notebook : notebooks) {
					if(inputId == notebook.getCompany().getId()) {
						notebookService.printNotebook(notebook);
					}
				}
			}
			
			else {
				System.out.println("Geçersiz İşlem!");
			}
		}
	}

	@Override
	public void runForPhoneASC() {
		phoneService.printPhone(phoneService.getPhoneNamesASC(phoneService.getPhones()));
	}

	@Override
	public void runForPhoneDESC() {
		phoneService.printPhone(phoneService.getPhoneNamesDESC(phoneService.getPhones()));
	}
	
	@Override
	public void runForNotebookASC() {
		notebookService.printNotebook(notebookService.getNotebookNamesASC(notebookService.getNotebooks()));
	}

	@Override
	public void runForNotebookDESC() {
		notebookService.printNotebook(notebookService.getNotebookNamesDESC(notebookService.getNotebooks()));
	}

	@Override
	public void runForAllProducts() {
		phoneService.printPhone(phoneService.getPhones());
		notebookService.printNotebook(notebookService.getNotebooks());
	}

	@Override
	public int createUniqueNumberForNewDevice() {
		/*ID Creator*/
		Phone[] phonesModel = phoneService.getPhones();
		Notebook[] notebooksModel = notebookService.getNotebooks();
		
		int maxId = 0;
		for(int i = 0; i <phonesModel.length; i++) {
			if(phonesModel[i].getId() > maxId) {
				maxId = phonesModel[i].getId();
			}
		}
		for(int i = 0; i <notebooksModel.length; i++) {
			if(notebooksModel[i].getId() > maxId) {
				maxId = notebooksModel[i].getId();
			}
		}
		
		return maxId + 1;
	}

	@Override
	public Company findCompanyFromId(int companyId) {
		Company[] companiesModel = companyService.createCompanies();
		Company com = companiesModel[0];
			for(Company company : companiesModel) {
				if(company.getId() == companyId) {
					com = company;
				}
			}
		
		return com;
	}


}
