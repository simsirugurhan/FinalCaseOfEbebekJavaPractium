package patikaStore;

public interface INotebookService {

	Notebook[] getNotebooks();
	Notebook[] getNotebookNamesASC(Notebook[] notebooks);
	Notebook[] getNotebookNamesDESC(Notebook[] notebooks);
	void printNotebook(Notebook[] notebooks);
	void printNotebook(Notebook notebook);
	Notebook[] addNewNotebook(Notebook notebook);
	Notebook[] removeNotebookFromId(Product notebook);
}
