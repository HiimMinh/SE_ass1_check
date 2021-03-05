package a1_118;

import a1_118.DomainConstraint;
import a1_118.AttrRef;
import a1_118.NotPossibleException;

/**
 * @author nguyenquyminh
 * 
 * @overview PostgradStudent is a person who study in Master, Ph.D and higher levels, with personal information such as id, name, phonenumber, address, gpa.
 * 
 * @attribute
 * 	id			Integer
 * 	name		String
 *	phoneNumber	String 
 *	address		String
 *	gpa			Float 
 * 
 * @object A typical Student is
 * 	s = <i,n,p,a,g> where id(i), name(n), phoneNumber(p), address(a), gpa(g).
 * 
 * @abstract
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 1000000000 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 100
 * mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0.0 /\ max(gpa) = 4.0
 */

//Create attributes
public class PostgradStudent
{
	private static final int MIN_ID = 100000001;
	private static final int MAX_ID = 1000000000;
	private static final float MIN_GPA = 0;
	private static final float MAX_GPA = 4;
	@DomainConstraint(type = "String", mutable = true, optional = false, min = MIN_GPA, max = MAX_GPA)
	private float gpa;
	private static String name;
	
	//Constructor
	public PostgradStudent(@AttrRef("id") int id, @AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("gpa") float gpa)
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
					
					this.gpa = gpa;
	}
	
	//Setter methods
		/**
		 * @effects <pre>
		 * 	if gpa is valid
		 * 		set this.gpa = gpa
		 */
		@DOpt(type=OptType.Mutator) @AttrRef("gpa")
		public boolean setName(float gpa)
		{
			if (validateGpa(gpa))
			{
				this.gpa = gpa;
				return true;
			}
			else
			{
				return false;
			}
		}
	
	//Getter methods
		/**
		 * @effects return <tt>name</tt>
		 */
		@DOpt(type=OptType.Observer) @AttrRef("name")
		public static String getName()
		{
			return name;
		}
		
		/**
		 * @effects return <tt>gpa<tt>
		 */
		@DOpt(type=OptType.Observer) @AttrRef("gpa")
		public float getGpa()
		{
			return gpa;
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
		
		/**
		 * @effects <pre>
		 * 	if gpa is valid
		 * 		return true
		 * 	else
		 * 		return false
		 * 			</pre>
		 */
		private boolean validateGpa(float gpa)
		{
			if(gpa< MIN_GPA || gpa> MAX_GPA)
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
			if (this.getClass().getSimpleName() == "UndergradStudent")
			{
				return "UndergradStudent(" + Student.getName() + ")";
			}
			else if (this.getClass().getSimpleName() == "Student")
			{
				return "Student(" + Student.getName() + ")";
			}
			else
			{
				return "PostgradStudent(" + Student.getName() + ")";
			}
		}
			
}
	


