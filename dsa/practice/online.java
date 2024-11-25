import java.util.*;

/*
 * Online cloud reading application Similar to Amazon kindle(for short stories) 
 * we need help designing actual application
 * A few things looking for:
 * - user have a library of books that they can add to or remove from
 *   - Users can set a book from their library as active
 *   - The reading application remembers where a user left of in a given book
 *  - The reading application only displays a page of text at a time in the active book.
 * 
 */

/*
 * notes
 * classes:
 *      - representing a book (Book)
 *          - id : str/int ?
 *          - title: str
 *          - pages/content in the book: list of strings (per page)
 *          - last page user looked at: int (off-by-one)
 *      - Representing a library
 *      - collection of books: {id: Book()}
 *      - active book: variable corresponding to id
 */
class online {
}

class Book{
    private int id;
    private String title;
    private List<String> pages;
    private int lastPageRead;

    //contructor
    public Book(int id, String title, List<String> pages){
        this.id = id;
        this.title = title;
        this.page = pages;
        this.lastPageRead = 0;
    }

    // getters
    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getCurrentPageContent() {
        return pages.get(lastPageRead);
    }

    public int getLastPageRead(){
        return lastPage;
    }

    public void goToNextPage(){
        if (lastPage < pages.size() - 1){
            return lastPageRead++;
        }
    }

    public void goToPreviousPage(){
        if (lastPageRead > 0){
            return lastPageRead--;
          }
    }

    public boolean isFirstPage(){
        lastPageRead = 0;
    }


    public boolean isLastPage(){
        lastPageRead == pages.size() -1;
    }

    public void setLastPageRead(int page){
        if (page >= 0 && page < page.size()){
            lastPageRead = page;
        }
    }

    @Override
    public String toString(){
        return "Book Id: " + id + ", Title: " + title;
    }

}


class library{
    public Map<Integer, Book> books;
    private Book activeBook;

    public library(){
        books = new HashMap<>();
        activeBook = null;
    }

    // method to add book into the library
    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    // method to remove book from the library
    public void removeBook(int id){
        if (book.containsKey(id)){
            books.remove(id);
            if (activeBook != null && activeBook.getId == id){
                activeBook = null;
            }
        }
    }

    // method to set book active using its id
    public void setActiveBook(){
        if (books.containsKey(id)){
            activeBook = books.getId();
        } else {
            System.out.println("Books not found in the Library");
        }
    }

    // method to display active page of active book
    public void displayActiveBooksPage(){
        if (activeBook != null){
            System.out.println("Reading: " + activeBook.getTitle());
            System.out.println("Page " + activeBook.getLastPageRead() + 1);
            Sysytem.out.println(activeBook.getCurrentPageContent());
        } else {
            System.out.println("No active books selected");
        }
    }

    public void nexPage(){
        if (activeBook != null){
            activeBook.goToNextPage();
            displayActiveBooksPage();
        }
    }

    // method to go to the previous page
    public void previousPage(){
        if (activeBook != null){
            activeBook.goToPreviousPage();
            displayActiveBooksPage();
        }
    }

    // display all books in the library
    public void displayAllBooks(){
        if (books.isEmpty()){
            System.out.println("Library is Empty");
        }else{
            System.out.println("Books in the library");
            for (Book book : books.values()){
                System.out.prinln(book);
            }
        }
    }
}




            



    
