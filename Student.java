package a1_118;

import a1_118.DomainConstraint;
import a1_118.AttrRef;
import a1_118.NotPossibleException;


/**
 * @author nguyenquyminh
 * 
 * @overview Students is a person who learn in the school and has personal information such as id, name, phonenumber, address.
 * 
 * @attribute
 * 	id			Integer
 * 	name		String
 *	phoneNumber	String 
 *	address		String 
 * 
 * @object A typical Student is
 * 	s = <i,n,p,a> where id(i), name(n), phoneNumber(p), address(a).
 * 
 * @abstract
 * 	mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 1000000000 /\
 * 	mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * 	mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 * 	mutable(address) = true /\ optional(address) = false /\ length(address) = 100
 * 	
 */


//Create attributes for class
public class Student implements Comparable<Student>
{
	private static final int MIN_ID = 1;
	private static final int MAX_ID = 1000000000;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = MIN_ID, max = MAX_ID)
	private static int id;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
	private static String name;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
	private String phoneNumber;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
	private String address;
	
	//Constructors
	public Student(@AttrRef("id") int id, @AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
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
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		}
	
// Setter methods
	/**
	 * @effects <pre>
	 * 	if name is valid
	 * 		set this.name = name
	 * 		return true
	 * 	else
	 * 		return false </pre>
	 */
	@DOpt(type=OptType.Mutator) @AttrRef("name")
	public boolean setName(String name)
	{
		if (validateName(name))
		{
			this.name = name;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @effects <pre>
	 * 	if phoneNumber is valid
	 * 		set this.phoneNumber = phoneNumber
	 * 		return true
	 * 	else
	 * 		return false </pre>
	 */
	@DOpt(type=OptType.Mutator) @AttrRef("phoneNumber")
	public boolean setphoneNumber(String phoneNumber)
	{
		if (validatePhoneNumber(phoneNumber))
		{
			this.phoneNumber = phoneNumber;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @effects <pre>
	 * 	if address is valid
	 * 		set this.address = address
	 * 		return true
	 * 	else
	 * 		return false </pre>
	 */
	@DOpt(type=OptType.Mutator) @AttrRef("address")
	public boolean setaddress(String address)
	{
		if (validateAddress(address))
		{
			this.address = address;
			return true;
		}
		else
		{
			return false;
		}
	}
	
//Getter methods
	/**
	 * @effects return <tt>id<tt>
	 */
	@DOpt(type=OptType.Observer) @AttrRef("id")
	public static int getId()
	{
		return id;
	}
	
	/**
	 * @effects return <tt>name</tt>
	 */
	@DOpt(type=OptType.Observer) @AttrRef("name")
	public static String getName()
	{
		return name;
	}
	
	/**
	 * @effects return <tt>phoneNumber</tt>
	 */
	@DOpt(type=OptType.Observer) @AttrRef("phoneNumber")
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * @effects return <tt>address</tt>
	 */
	@DOpt(type=OptType.Observer) @AttrRef("address")
	public String getAddress()
	{
		return address;
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
		if(!validateId(id) || !validateName(name))
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
			return "UndergradStudent(" + name + ")";
		}
		else if (this.getClass().getSimpleName() == "PostgradStudent")
		{
			return "PostgradStudent(" + name + ")";
		}
		else
		{
			return "Student(" + name + ")";
		}
	}
	
//compareTo
	/**
	 * @effects
	 * return result of comparing this.name and student.name
	 */
	
	@Override
	public int compareTo(Student student)
	{
		int compare = (this.getName()).compareTo(student.getName());
		return compare;
	}
	
	
	
	
	public static void main(String[] args) {
		
	}
}



