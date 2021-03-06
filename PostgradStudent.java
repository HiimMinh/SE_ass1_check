package a1_BI10_118;

import utils.*;

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
public class PostgradStudent extends Student
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
		super(id, name, phoneNumber, address);
		if (!validateGpa(gpa))
		{
			throw new NotPossibleException("Student.init: Invalid Student address" + gpa);
		}
		this.gpa = gpa;
	}
					
	
	//Setter methods
		/**
		 * @effects <pre>
		 * 	if gpa is valid
		 * 		set this.gpa = gpa
		 * 	else
		 * 		throw new NotPossibleException
		 */
		@DOpt(type=OptType.Mutator) @AttrRef("gpa")
		public boolean setName(float gpa)
		throws NotPossibleException
		{
			if (validateGpa(gpa))
			{
				this.gpa = gpa;
				return true;
			}
			else
			{
				throw new NotPossibleException("Student.init: Invalid Student address" + gpa);
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
	


