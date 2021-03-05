package a1_118;

import a1_118.DomainConstraint;
import a1_118.AttrRef;
import a1_118.NotPossibleException;

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
public class UndergradStudent
{
	private static final int MIN_ID = 100000;
	private static final int MAX_ID = 1000000000;
	private static String name;
	
	
	//Constructors
	public UndergradStudent (@AttrRef("id") int id,@AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
	throws NotPossibleException
			{
				if (!validateId(id))
				{
					throw new NotPossibleException("Student.init: Invalid Student id: " + id);
				}
				if (!validateName(name))
				{
					throw new NotPossibleException("Student.init: Invalid Student name: " + name);
				}
				if (!validatePhoneNumber(phoneNumber))
				{
					throw new NotPossibleException("Student.init: Invalid Student phoneNumber" + phoneNumber);
				}
				if (!validateAddress(address))
				{
					throw new NotPossibleException("Student.init: Invalid Student address" + address);
				}	
			}
	
	//Getter
		/**
		 * @effects return <tt>name</tt>
		 */
		@DOpt(type=OptType.Observer) @AttrRef("name")
		public static String getName()
		{
			return name;
		}
		
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

		/**
		 * @effects <pre>
		 * if name is valid
		 * 		return true
		 * else
		 * 		return false
		 * 			</pre>
		 */
		private boolean validateName(String n)
		{
			if(n == null || n.length() > 50 || n.isBlank() || n.isEmpty())
			{
				return false;
			}
			return true;
		}
		
		/**
		 * @effects <pre>
		 * if phoneNumber is valid
		 * 		return true
		 * else
		 * 		return false
		 * 			</pre>
		 */
		
		private boolean validatePhoneNumber(String p)
		{
			if(p == null || p.length() != 10 || p.isBlank() || p.isEmpty())
			{
				return false;
			}
			return true;
		}
		
		/**
		 * @effects <pre>
		 * if address is valid
		 * 		return true
		 * else
		 * 		return false
		 * 			</pre>
		 */
		
		private boolean validateAddress(String ad)
		{
			if(ad == null || ad.length() > 100 || ad.isBlank() || ad.isEmpty())
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



