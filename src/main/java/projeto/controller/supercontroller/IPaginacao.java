package projeto.controller.supercontroller;

public interface IPaginacao {
	
	
	public int getCount(); 

	/**
	 * @Get("/paginacao")
	 */
	public void findPagination(int begin, int limit);
	

}
