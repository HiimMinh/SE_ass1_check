package a1_BI10_118;

import utils.*;

/**
 * @author nguyenquyminh
 * 
 * @overview UndergradStudent is a person who learn in university, college and has personal information such as id, name, phonenumber, address. 
 *
 * @abstract
 * 	mutable(id) = false /\ optional(id) = false /\ min(id) = 100000 /\ max(id) = 100000000
 * 	
 */

//Create attributes
public class UndergradStudent extends Student
{
	private static final int MIN_ID = 100000;
	private static final int MAX_ID = 1000000000;
	private static String name;
	
	
	//Constructors
	public UndergradStudent (@AttrRef("id") int id,@AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
	throws NotPossibleException
			{
				super(id, name, phoneNumber, address);
			}
	
	//Getter
		
	//Validation methods
		/**
		 * @effects <pre>
		 * 	if id is valid
		 * 		return true
		 * 	else
		 * 		return false
		 * 			</pre>
		 */
		
		protected boolean validateId(int id)
		{
			if(id< MIN_ID || id> MAX_ID)
			{
				return false;
			}	
				return true;
		}

	//RepOK methods
		/**
		 * @effects <pre>
		 * 		if this satisfies abstract properties
		 * 			return true
		 * 		else
		 * 			return false
		 * 			</pre>
		 */
		public boolean repOK()
		{
			if(!validateId(Student.getId()) || !validateName(Student.getName()))
			{
				return false;
			}
		return true;
		}	
	
	//toString methods
		@Override
		public String toString()
		{
			if (this.getClass().getSimpleName() == "Student")
			{
				return "Student(" + Student.getName() + ")";
			}
			else if (this.getClass().getSimpleName() == "PostgradStudent")
			{
				return "PostgradStudent(" + Student.getName() + ")";
			}
			else
			{
				return "UndergradStudent(" + Student.getName() + ")";
			}
		}		
		
}



